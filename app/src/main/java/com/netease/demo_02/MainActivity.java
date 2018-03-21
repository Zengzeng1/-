package com.netease.demo_02;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  List<String> list1=new ArrayList<>();
  List<String> list2=new ArrayList<>();
  List<String> list3=new ArrayList<>();
  ArrayList<Fragment>list=new ArrayList<>();

  ViewPager vp;

  TextView tv1;
  TextView tv2;
  TextView tv3;
  ImageView tabline;
  int mScreen1_3;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.main_layout);
    vp=(ViewPager)findViewById(R.id.viewpager);
    tv1=(TextView)findViewById(R.id.tv_top1);
    tv2=(TextView)findViewById(R.id.tv_top2);
    tv3=(TextView)findViewById(R.id.tv_top3);

    //三个Fragment
    list.add(new Fragment1());
    list.add(new Fragment2());
    list.add(new Fragment3());

    //设置滑块的长度
    initTabLine();

    //实现滑动
    FragmentPagerAdapter fpadapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
      @Override
      public Fragment getItem(int position) {
        return list.get(position);
      }

      @Override
      public int getCount() {
        return list.size();
      }
    };

    vp.setAdapter(fpadapter);


    vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tabline.getLayoutParams();
        layoutParams.leftMargin = (int) ((position + positionOffset) * mScreen1_3);//算出距离，然后设置margin值
        tabline.setLayoutParams(layoutParams);
      }

      @Override
      public void onPageSelected(int position) {
          switch (position){
            case 0:
              resetColor();
              tv1.setTextColor(Color.BLACK);
              break;
            case 1:
              resetColor();
              tv2.setTextColor(Color.BLACK);break;
            case 2:
              resetColor();
              tv3.setTextColor(Color.BLACK);break;
            default:
          }
      }

      @Override
      public void onPageScrollStateChanged(int state) {

      }
    });
  }

  private void resetColor() {
    tv1.setTextColor(Color.GRAY);
    tv2.setTextColor(Color.GRAY);
    tv3.setTextColor(Color.GRAY);
  }

  /**
   * 点击最上面一栏事件
   *
   * */
  public void tabClick(View view){
    switch(view.getId()){
      case R.id.tv_top1:
        vp.setCurrentItem(0);break;
      case R.id.tv_top2:
        vp.setCurrentItem(1);break;
      case R.id.tv_top3:
        vp.setCurrentItem(2);break;
    }
  }


  /**
   * tab 一起滑动
   * */
      private void initTabLine(){
        tabline = (ImageView) findViewById(R.id.tabline1);
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        mScreen1_3 = metrics.widthPixels/3;//得到屏幕长度的三分之一
        ViewGroup.LayoutParams layoutParams = tabline.getLayoutParams();
        layoutParams.width = mScreen1_3;
        tabline.setLayoutParams(layoutParams);//设置滑动条的宽度
      }







}
