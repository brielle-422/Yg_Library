package com.lyg.yg_library.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.lyg.yg_library.R;

public class FragmentDemoActivity extends FragmentActivity implements OnClickListener {
    OneFragment oneFragment=OneFragment.newInstance("oneFragment","");
    TwoFragment twoFragment=TwoFragment.newInstance("twoFragment","");
    ThreeFragment threeFragment=ThreeFragment.newInstance("threeFragment","");
    private Fragment mContent;
    private LinearLayout llOne;
    private LinearLayout llTwo;
    private LinearLayout llThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        llOne= (LinearLayout) findViewById(R.id.ll_one);
        llOne.setOnClickListener(this);
        llTwo= (LinearLayout) findViewById(R.id.ll_two);
        llTwo.setOnClickListener(this);
        llThree= (LinearLayout) findViewById(R.id.ll_three);
        llThree.setOnClickListener(this);
        initFragment();
    }
    private void initFragment() {
        switchFragment(R.id.fragment_container_MainActivity, oneFragment);
    }
    private void switchFragment(int id, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mContent != fragment) {
            if (!fragment.isAdded()) {// 先判断是否被add过
                if (mContent == null) {
                    transaction.add(id, fragment).commit();
                } else {
                    transaction.hide(mContent).add(id, fragment).commit();// 隐藏当前的fragment，add下一个到Activity中
                }
            }else{
                transaction.hide(mContent).show(fragment).commit(); // 隐藏当前的fragment，显示下一个
            }
            mContent = fragment;
        }
    }
    public void initImage() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_one:
                switchFragment(R.id.fragment_container_MainActivity, oneFragment);
                break;
            case R.id.ll_two:
                switchFragment(R.id.fragment_container_MainActivity, twoFragment);
                break;
            case R.id.ll_three:
                switchFragment(R.id.fragment_container_MainActivity, threeFragment);
                break;
        }

    }
}
