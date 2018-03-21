package com.netease.demo_02;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.netease.demo_02.bean.Person;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by wuxiangkun on 2018/3/21.
 * Contact by bjwuxiangkun@corp.netease.com
 */

public class Fragment1 extends Fragment {

  private ListView lv;
  ArrayList<Person> list=new ArrayList<>();
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    for (int i=0;i<30;i++){
      list.add(new Person("张三",10,"11"+i));
    }
    View view=inflater.inflate(R.layout.fragment1_layout,container,false);
    lv=(ListView)view.findViewById(R.id.frg1_lv);
    lv.setAdapter(new BaseAdapter() {
      @Override
      public int getCount() {
        return list.size();
      }

      @Override
      public Object getItem(int i) {
        return list.get(i);
      }

      @Override
      public long getItemId(int i) {
        return i;
      }

      @Override
      public View getView(int i, View view, ViewGroup viewGroup) {
        TextView view1;
        if(view==null){
          view1=new TextView(getContext());
        }else{
          view1=(TextView) view;
        }
        view1.setText("姓名："+list.get(i).getName()+",年龄："+list.get(i).getAge());
        return view1;
      }
    });
    return view;
  }

}

