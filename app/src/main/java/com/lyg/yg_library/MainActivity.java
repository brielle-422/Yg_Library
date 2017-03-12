package com.lyg.yg_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lyg.yg_library.banner.BannerDemoActivity;
import com.lyg.yg_library.fragment.FragmentDemoActivity;
import com.lyg.yg_library.pulltorefresh.PullToRefreshDemoActivity;
import com.lyg.yg_library.swipemenu.SwipeMenuDemoActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_main);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent_0=new Intent(MainActivity.this, BannerDemoActivity.class);
                        startActivity(intent_0);
                        break;
                    case 1:
                        Intent intent_1=new Intent(MainActivity.this, FragmentDemoActivity.class);
                        startActivity(intent_1);
                        break;
                    case 2:
                        Intent intent_2=new Intent(MainActivity.this, SwipeMenuDemoActivity.class);
                        startActivity(intent_2);
                        break;
                    case 3:
                        Intent intent_3=new Intent(MainActivity.this, PullToRefreshDemoActivity.class);
                        startActivity(intent_3);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public List<String> getData() {
        List<String > data=new ArrayList<String>();
        data.add("广告轮播banner");
        data.add("fragment");
        data.add("swipeMenu");
        data.add("pulltorefresh");
        return data;
    }
}
