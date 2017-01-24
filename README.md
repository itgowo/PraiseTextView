# PraiseTextView #
 

## 说明

#### 我是将朋友圈分成了几个独立模块单独自定义的View，通过回调完成交互，耦合性算是非常低了，主要有以下及部分： 

1.评论布局（自定义TextView）

[CommentListTextView](https://github.com/hnsugar/CommentListTextView/)

[Lu_PingLunLayout](https://github.com/hnsugar/lu_pinglunlayout/)

2.点赞布局（原理和评论的自定义TextView一样，都是用的SpannableString）

[PraiseTextView](https://github.com/hnsugar/PraiseTextView/)
 
 
3.图片列表（出门右转，理论上没有数量限制，和listView配合使用也很好，缓存也自己处理了）

[MultiImageViewLayout](https://github.com/hnsugar/MultiImageViewLayout/)

我也是找第三方例子不好找，于是自己写了一个，我和同事还打算做一套IM系统，app和后台都要做，我们自己定义sdk，我们还要封装H5，类似hbuilder如果有什么问题，可以联系我，

QQ:1264957104

CSDN:http://blog.csdn.net/hnsugar

GitHub:https://github.com/hnsugar

个人做测试项目的服务器:http://lujianchao.com

链接是跳转到GitHub的，部分文章我会直接贴出关键View的代码。

## 示例 ##

![](http://img.blog.csdn.net/20170124102731199?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG5zdWdhcg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![](http://img.blog.csdn.net/20170124102809731?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaG5zdWdhcg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

![](http://i.imgur.com/BDFkB82.png)

##主要方法##
 		mPraiseTextView.setData (mPraiseInfos);//设置数据
		mPraiseTextView.setNameTextColor (Color.BLUE);//设置名字字体颜色
		mPraiseTextView.setIcon (R.drawable.emoji_1f0cf);//设置图标
		mPraiseTextView.setMiddleStr ("，");//设置分割文本
		mPraiseTextView.setIconSize (new Rect (0,0,100,100));//设置图标大小，默认与字号匹配
		mPraiseTextView.setonPraiseListener()//设置监听

## onClick (int position, PraiseTextView.PraiseInfo mPraiseInfo)  ##
position是第几个点赞的人，mInfo是这条点赞的信息


## onOtherClick ##
内部处理了点击文字会触发两个回调的问题，这个是点击非文字或者没有单独定义点击事件的回调

 




## 布局 ##
 
	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:id="@+id/activity_main"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:orientation="vertical"
	    android:paddingBottom="@dimen/activity_vertical_margin"
	    android:paddingLeft="@dimen/activity_horizontal_margin"
	    android:paddingRight="@dimen/activity_horizontal_margin"
	    android:paddingTop="@dimen/activity_vertical_margin"
	    tools:context="com.lujianchao.praisetextview.MainActivity">

	    <com.lujianchao.praisetextview.PraiseTextView
		android:layout_width="match_parent"
		android:id="@+id/praisetextview"
		android:layout_height="wrap_content"
		/>

	    <TextView
		android:id="@+id/log"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:scrollbars="vertical"/>
	</LinearLayout>





## 代码 ##
    
	public class MainActivity extends AppCompatActivity {
	    private PraiseTextView mPraiseTextView;
	    private TextView mTextView;

	    @Override
	    protected void onCreate (Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_main);
		mPraiseTextView = (PraiseTextView) findViewById (R.id.praisetextview);
		mTextView = (TextView) findViewById (R.id.log);
		mTextView.setMovementMethod (ScrollingMovementMethod.getInstance ());


		List<PraiseTextView.PraiseInfo> mPraiseInfos = new ArrayList<> ();
		mPraiseInfos.add (new PraiseTextView.PraiseInfo ().setId (111).setNickname ("张三").setLogo ("http://lujianchao.com/images/headimg/1.jpg"));
		mPraiseInfos.add (new PraiseTextView.PraiseInfo ().setId (222).setNickname ("张四").setLogo ("http://lujianchao.com/images/headimg/2.jpg"));
		mPraiseInfos.add (new PraiseTextView.PraiseInfo ().setId (333).setNickname ("张五").setLogo ("http://lujianchao.com/images/headimg/3.jpg"));
		mPraiseInfos.add (new PraiseTextView.PraiseInfo ().setId (444).setNickname ("张六").setLogo ("http://lujianchao.com/images/headimg/4.jpg"));
		mPraiseInfos.add (new PraiseTextView.PraiseInfo ().setId (555).setNickname ("赵四").setLogo ("http://lujianchao.com/images/headimg/5.jpg"));
		mPraiseInfos.add (new PraiseTextView.PraiseInfo ().setId (666).setNickname ("赵三").setLogo ("http://lujianchao.com/images/headimg/6.jpg"));
		mPraiseInfos.add (new PraiseTextView.PraiseInfo ().setId (777).setNickname ("李大").setLogo ("http://lujianchao.com/images/headimg/7.jpg"));
		mPraiseInfos.add (new PraiseTextView.PraiseInfo ().setId (888).setNickname ("李二").setLogo ("http://lujianchao.com/images/headimg/8.jpg"));
		mPraiseInfos.add (new PraiseTextView.PraiseInfo ().setId (999).setNickname ("李三").setLogo ("http://lujianchao.com/images/headimg/9.jpg"));
		mPraiseTextView.setData (mPraiseInfos);//设置数据
		mPraiseTextView.setNameTextColor (Color.BLUE);//设置名字字体颜色
		mPraiseTextView.setIcon (R.drawable.emoji_1f0cf);//设置图标
		mPraiseTextView.setMiddleStr ("，");//设置分割文本
		mPraiseTextView.setIconSize (new Rect (0,0,100,100));//设置图标大小，默认与字号匹配
		mPraiseTextView.setonPraiseListener (new PraiseTextView.onPraiseClickListener () {
		    @Override
		    public void onClick (final int position, final PraiseTextView.PraiseInfo mPraiseInfo) {
		       mTextView.append ("position = [" + position + "], mPraiseInfo = [" + mPraiseInfo + "]"+"\r\n");
		    }

		    @Override
		    public void onOtherClick () {
			mTextView.append ("onOtherClick"+"\r\n");
		    }
		});
	    }
	}


##源码##
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
