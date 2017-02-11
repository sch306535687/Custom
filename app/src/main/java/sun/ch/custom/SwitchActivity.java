package sun.ch.custom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import sun.ch.view.MySwitch;

/**
 * Created by asus on 2017/1/6.
 */
public class SwitchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        MySwitch mMySwitch = (MySwitch) findViewById(R.id.mSwitch);
        mMySwitch.setOnCheckListener(new MySwitch.OnCheckListener() {
            @Override
            public void setOnClickListener(View view, boolean checked) {
                Toast.makeText(SwitchActivity.this,"开关状态"+checked,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
