package com.netease.demo_02;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wuxiangkun on 2018/3/21.
 * Contact by bjwuxiangkun@corp.netease.com
 */

public class Fragment2 extends Fragment {
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.fragment2_layout,container,false);
    return view;
  }
}
