package com.lujianchao.praisetextview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lujianchao on 2017/1/23.
 *
 * @author lujianchao
 */

public class PraiseTextView extends TextView {
    private List<PraiseInfo> mPraiseInfos;
    private onPraiseClickListener mListener;
    /**
     * 第一个显示的图标
     */
    private int mIcon = R.drawable.emoji_1f0cf;
    /**
     * 名字文字颜色，分割文本用textview默认的，自行设置即可
     */
    private int mNameTextColor = Color.GREEN;
    /**
     * 不设置默认与文字大小匹配
     */
    private Rect mIconSize = null;
    /**
     * 中间分割的文本
     */
    private String mMiddleStr = "，";
    private boolean isClickName = false;

    public PraiseTextView (Context context) {
        super (context);
    }

    public PraiseTextView (Context context, AttributeSet attrs) {
        super (context, attrs);
    }

    public onPraiseClickListener getonPraiseListener () {
        return mListener;
    }

    public PraiseTextView setonPraiseListener (onPraiseClickListener mListener) {
        this.mListener = mListener;
        return this;
    }

    public String getMiddleStr () {
        return mMiddleStr;
    }

    public PraiseTextView setMiddleStr (final String mMiddleStr) {
        this.mMiddleStr = mMiddleStr;
        return this;
    }

    public int getIcon () {
        return mIcon;
    }

    public PraiseTextView setIcon (int mIcon) {
        this.mIcon = mIcon;
        return this;
    }

    public int getNameTextColor () {
        return mNameTextColor;
    }

    public PraiseTextView setNameTextColor (int mNameTextColor) {
        this.mNameTextColor = mNameTextColor;
        return this;
    }

    public Rect getIconSize () {
        return mIconSize;
    }

    /**
     * 不设置默认与文字大小匹配
     */
    public PraiseTextView setIconSize (Rect mIconSize) {
        this.mIconSize = mIconSize;
        return this;
    }

    public PraiseTextView setData (List<PraiseInfo> mPraiseInfos) {
        this.mPraiseInfos = mPraiseInfos;
        this.setHighlightColor (Color.TRANSPARENT);
        this.setMovementMethod (LinkMovementMethod.getInstance ());
        this.setText (getPraiseString ());
        this.setOnClickListener (new OnClickListener () {
            @Override
            public void onClick (final View mView) {
                if (isClickName) {
                    isClickName=false;
                    return;
                }
                if (mListener != null) {
                    mListener.onOtherClick ();
                }
            }
        });
        return this;
    }

    private SpannableStringBuilder getPraiseString () {
        SpannableStringBuilder mBuilder = new SpannableStringBuilder ("我");
        mBuilder.setSpan (new iconimage (getResources ().getDrawable (mIcon)), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        for (int mI = 0; mI < mPraiseInfos.size (); mI++) {
            if (!TextUtils.isEmpty (mPraiseInfos.get (mI).getNickname ())) {
                mBuilder.append (mPraiseInfos.get (mI).getNickname () + mMiddleStr);
                final int finalMI = mI;
                mBuilder.setSpan (new ClickableSpan () {
                    @Override
                    public void onClick (final View mView) {
                        isClickName = true;
                        if (mListener != null) {
                            mListener.onClick (finalMI, mPraiseInfos.get (finalMI));
                        }
                    }

                    @Override
                    public void updateDrawState (final TextPaint ds) {
                        super.updateDrawState (ds);
                        ds.setUnderlineText (false);
                        ds.setColor (mNameTextColor);
                    }
                }, mBuilder.length () - mPraiseInfos.get (mI).getNickname ().length () - mMiddleStr.length (), mBuilder.length () - mMiddleStr.length (), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        mBuilder = new SpannableStringBuilder (mBuilder, 0, mBuilder.length () - 1);
        mBuilder.append (" ");
        return mBuilder;
    }

    public interface onPraiseClickListener {
        public void onClick (int position, PraiseInfo mPraiseInfo);

        public void onOtherClick ();
    }

    public static class PraiseInfo {
        private int id;
        private String nickname;
        private String logo;

        @Override
        public String toString () {
            return "PraiseInfo{" +
                    "id=" + id +
                    ", nickname='" + nickname + '\'' +
                    ", logo='" + logo + '\'' +
                    '}';
        }

        public int getId () {
            return id;
        }

        public PraiseInfo setId (final int mId) {
            id = mId;
            return this;
        }

        public String getNickname () {
            return nickname;
        }

        public PraiseInfo setNickname (final String mNickname) {
            nickname = mNickname;
            return this;
        }

        public String getLogo () {
            return logo;
        }

        public PraiseInfo setLogo (final String mLogo) {
            logo = mLogo;
            return this;
        }
    }

    public class iconimage extends ImageSpan {
        private Drawable mDrawable;

        public iconimage (Drawable d) {
            super (d);
            mDrawable = d;
        }

        @Override
        public Drawable getDrawable () {
            if (mIconSize == null) {
                Rect mRect = new Rect ();
                getPaint ().getTextBounds ("我", 0, 1, mRect);
                mDrawable.setBounds (mRect);
            } else {
                mDrawable.setBounds (mIconSize);
            }
            return mDrawable;
        }
    }
}
