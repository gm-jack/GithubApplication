package com.atguigu.qing.fancycoverflowdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.dalong.francyconverflow.FancyCoverFlow;

/**
 * Created by qing on 2016/7/30.
 * FancyCoverFlow的适配器
 */
public class MyFancyCoverFlowAdapter extends com.dalong.francyconverflow.FancyCoverFlowAdapter {
    private final Context mContext;
    private final int[] mPictures;

    public MyFancyCoverFlowAdapter(Context context, int[] pictures) {
        mContext = context;
        mPictures = pictures;
    }

    @Override
    public View getCoverFlowItem(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_fancy_cover_flow, null);

            //设置显示图片所占宽度
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            convertView.setLayoutParams(new FancyCoverFlow.LayoutParams(width * 2 / 3, FancyCoverFlow.LayoutParams.WRAP_CONTENT));

            holder.iv_item = (ImageView) convertView.findViewById(R.id.iv_item);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //获取当前条目的数据
        int mPicture = mPictures[position % mPictures.length];

        //设置数据
        holder.iv_item.setImageResource(mPicture);

        return convertView;
    }

    @Override
    public int getCount() {
        return 1000;
    }

    @Override
    public Object getItem(int position) {
        return mPictures[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView iv_item;
    }
}
