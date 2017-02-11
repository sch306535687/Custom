package sun.ch.custom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 优酷菜单
     * @param view
     */
    public void youku(View view){
        startActivity(new Intent(this,YoukuActivity.class));
    }
    /**
     * 轮播图片
     * @param view
     */
    public void scanner(View view){
        startActivity(new Intent(this,ScannerActivity.class));
    }
    /**
     * 自定义开关
     * @param view
     */
    public void mySwitch(View view){
        startActivity(new Intent(this,SwitchActivity.class));
    }
    /**
     * 自定义轮播器
     * @param view
     */
    public void myScanner(View view){
        startActivity(new Intent(this,MyScannerActivity.class));
    }
}
