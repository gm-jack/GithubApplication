
package com.czm.xcguaguaka;

import com.czm.xcguaguaka.XCGuaguakaView.OnCompleteListener;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;
/**
 * 使用并测试自定义刮刮卡效果View
 * @author caizhiming
 *
 */
public class MainActivity extends Activity {

    private XCGuaguakaView xcGuaguakaView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xcGuaguakaView = (XCGuaguakaView)findViewById(R.id.ggk);
        xcGuaguakaView.setOnCompleteListener(new OnCompleteListener() {
            
            @Override
            public void complete() {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "您已经刮的差不多啦", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
