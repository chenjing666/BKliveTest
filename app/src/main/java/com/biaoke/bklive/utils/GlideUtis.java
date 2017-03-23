package com.biaoke.bklive.utils;

import android.content.Context;
import android.widget.ImageView;

import com.biaoke.bklive.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Holiday on 2017/2/23.
 * 图片操作工具类
 */

public class GlideUtis {
    private Context mContext;
    public GlideUtis(Context mContext) {
        this.mContext = mContext;
    }
    /**
     * 加载正常图片
     * @param url
     * @param v
     * @param useMemory 是否使用缓存
     */
    public void glide(String url, ImageView v,boolean useMemory){
        Glide.with(mContext)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .skipMemoryCache(useMemory)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)//占位图
                .error(R.mipmap.ic_launcher)//加载出错的图
                .into(v);
    }

    /**
     * 加载圆形图片
     * @param url
     * @param v
     * @param useMemory 是否使用缓存
     */
    public void glideCircle(String url, ImageView v,boolean useMemory){
        Glide.with(mContext)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .skipMemoryCache(useMemory)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)//占位图
                .transform(new GlideCircleTransform(mContext))
                .error(R.mipmap.ic_launcher)//加载出错的图
                .into(v);
    }

    /**
     * 加载圆角图片
     * 注意：要展示该效果，需要设置View为warp属性
     * @param url
     * @param v
     * @param useMemory 是否使用缓存
     */
    public void glideRound(String url, ImageView v,boolean useMemory){
        Glide.with(mContext)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .skipMemoryCache(useMemory)
                .placeholder(R.mipmap.ic_launcher)//占位图
                .transform(new GlideRoundTransform(mContext,10))
                .error(R.mipmap.ic_launcher)//加载出错的图
                .into(v);
    }

    /**
     * 加载圆角图片
     * 注意：要展示该效果，需要设置View为warp属性
     * @param url
     * @param v
     * @param round  圆角的程度
     * @param useMemory 是否使用缓存
     */
    public void glideRound(String url, ImageView v,int round,boolean useMemory){
        Glide.with(mContext)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .skipMemoryCache(useMemory)
                .placeholder(R.mipmap.ic_launcher)//占位图
                .transform(new GlideRoundTransform(mContext,round))
                .error(R.mipmap.ic_launcher)//加载出错的图
                .into(v);
    }
}
