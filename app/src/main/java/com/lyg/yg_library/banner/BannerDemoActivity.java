package com.lyg.yg_library.banner;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.lyg.yg_library.R;

import java.util.ArrayList;

public class BannerDemoActivity extends AppCompatActivity {

    private ArrayList<BannerItem> bannerItems = new ArrayList<BannerItem>();
    private ImageCycleView icvBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_demo);
        icvBanner = (ImageCycleView) findViewById(R.id.icv_main_banner);
        for(int i=0;i<=3;i++){
            BannerItem info = new BannerItem();
            info.setUrl("http://jcodecraeer.com/uploads/20150327/1427445294110987.jpg");
            info.setContent("test"+i);
            bannerItems.add(info);
        }
        icvBanner.setImageResources(bannerItems, mAdCycleViewListener);


    }
    /**
     * 广告栏
     */
    public ImageCycleView.ImageCycleViewListener mAdCycleViewListener = new ImageCycleView.ImageCycleViewListener() {
        @Override
        public void onImageClick(BannerItem info, int postion, View imageView) {
            Toast.makeText(BannerDemoActivity.this,info.getContent(),Toast.LENGTH_LONG).show();
        }
        @Override
        public void displayImage(String imageURL, ImageView imageView) {
            Glide.with(BannerDemoActivity.this)
                    .load(imageURL)
                    .placeholder(R.color.gray)
                    .error(R.color.gray)
                    .skipMemoryCache( true )
                    .centerCrop()
                    .into(imageView);
        }
    };
    @Override
    public void onResume() {
        super.onResume();
//        icvBanner.startImageCycle();
    };

    @Override
    public void onPause() {
        super.onPause();
//        icvBanner.pushImageCycle();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        icvBanner.pushImageCycle();
    }
}
