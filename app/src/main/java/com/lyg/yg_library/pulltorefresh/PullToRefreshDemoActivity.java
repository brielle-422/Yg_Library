package com.lyg.yg_library.pulltorefresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lyg.yg_library.R;

import java.util.ArrayList;
import java.util.List;

public class PullToRefreshDemoActivity extends AppCompatActivity {

    private PullToRefreshListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh_demo);
        listView= (PullToRefreshListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                if(refreshView.isShownHeader()){
                    //下拉刷新
                }
                if(refreshView.isShownFooter()){
                    //上拉加载
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    public List<String> getData() {
        List<String > data=new ArrayList<String>();
        data.add("广告轮播banner");
        data.add("fragment");
        data.add("swipeMenu");
        return data;
    }
}
