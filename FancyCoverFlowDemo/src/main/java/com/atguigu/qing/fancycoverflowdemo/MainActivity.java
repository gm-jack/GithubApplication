package com.atguigu.qing.fancycoverflowdemo;

import android.app.Activity;
import android.os.Bundle;

import com.dalong.francyconverflow.FancyCoverFlow;

public class MainActivity extends Activity {

    //图片数组
    private int[] pictures = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,};

    private FancyCoverFlow fancy_cover_flow_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }

    private void initData() {

        //为FancyCoverFlow设置适配器
        MyFancyCoverFlowAdapter findFancyCoverFlowAdapter = new MyFancyCoverFlowAdapter(this, pictures);
        fancy_cover_flow_main.setAdapter(findFancyCoverFlowAdapter);
        findFancyCoverFlowAdapter.notifyDataSetChanged();

        //设置参数
        fancy_cover_flow_main.setUnselectedAlpha(0.2f);//未被选中时的透明度
        fancy_cover_flow_main.setUnselectedSaturation(0.5f);//设置未被选中的饱和度
        fancy_cover_flow_main.setUnselectedScale(0.2f);//设置未被选中所占的比例
        fancy_cover_flow_main.setSpacing(-400);//设置child间距
        fancy_cover_flow_main.setMaxRotation(0);//设置最大旋转度数
        fancy_cover_flow_main.setScaleDownGravity(0.3f);//非选中的重心偏移,负的向上
        fancy_cover_flow_main.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);//作用距离

        //设置从第一张图片开始显示
        int num = 1000 / 2 % pictures.length;
        int selectPosition = 1000 / 2 - num;
        fancy_cover_flow_main.setSelection(selectPosition);
    }

    private void initView() {
        fancy_cover_flow_main = (FancyCoverFlow)findViewById(R.id.fancy_cover_flow_main);
    }
}
