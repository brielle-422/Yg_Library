package com.lyg.yg_library.swipemenu;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ArrayAdapter;

import com.lyg.yg_library.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeMenuDemoActivity extends AppCompatActivity {
    private SwipeMenuListView mListView;
    private List<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_menu_demo);
        mListView = (SwipeMenuListView) findViewById(R.id.lv_collection);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        /**
         * 创建滑动菜单
         */
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // 创建删除按钮
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // 按钮背景颜色
                deleteItem.setBackground(new ColorDrawable(Color.rgb(255,
                        255, 255)));
                // 按钮宽度
                deleteItem.setWidth(dp2px(100));
                // 文字、颜色、大小
                deleteItem.setTitle("取消收藏");
                deleteItem.setTitleSize(14);
                deleteItem.setTitleColor(Color.WHITE);
                // 加入到菜单中
                menu.addMenuItem(deleteItem);
            }
        };
        /**
         * 将菜单加入到list列表中
         */
        mListView.setMenuCreator(creator);
    }
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
    public List<String> getData() {
        List<String > data=new ArrayList<String>();
        data.add("广告轮播banner");
        data.add("fragment");
        return data;
    }
}
