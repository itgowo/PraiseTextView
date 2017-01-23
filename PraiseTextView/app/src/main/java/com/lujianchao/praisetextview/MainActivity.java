package com.lujianchao.praisetextview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        mPraiseTextView.setData (mPraiseInfos);
        mPraiseTextView.setNameTextColor (Color.BLUE);
        mPraiseTextView.setIcon (R.drawable.emoji_1f0cf);
        mPraiseTextView.setMiddleStr ("，");
//        mPraiseTextView.setIconSize (new Rect (0,0,33,33));
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
