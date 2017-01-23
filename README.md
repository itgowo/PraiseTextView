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

## 示例 ##
![](https://github.com/hnsugar/PraiseTextView/blob/master/pic1.jpg)
![](https://github.com/hnsugar/PraiseTextView/blob/master/pic2.gif)

![](http://i.imgur.com/BDFkB82.png)

 

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
		mPraiseTextView.setData (mPraiseInfos);
		mPraiseTextView.setNameTextColor (Color.BLUE);
		mPraiseTextView.setIcon (R.drawable.emoji_1f0cf);
		mPraiseTextView.setMiddleStr ("，");
		mPraiseTextView.setIconSize (new Rect (0,0,100,100));
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
