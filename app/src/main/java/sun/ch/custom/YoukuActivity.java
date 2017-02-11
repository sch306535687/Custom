package sun.ch.custom;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import sun.ch.utils.AnimationTools;

/**
 * Created by sunch on 2017/1/6.
 */
public class YoukuActivity extends Activity implements View.OnClickListener {
    private ImageView home;
    private ImageView menu;
    private RelativeLayout level1;
    private RelativeLayout level2;
    private RelativeLayout level3;
    private boolean isMenuShow = true;
    private boolean isHomeShow = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youku);
        home = (ImageView) findViewById(R.id.home);
        menu = (ImageView) findViewById(R.id.menu);
        level1 = (RelativeLayout) findViewById(R.id.level1);
        level2 = (RelativeLayout) findViewById(R.id.level2);
        level3 = (RelativeLayout) findViewById(R.id.level3);
        home.setOnClickListener(this);
        menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home:
                if(isHomeShow){
                    AnimationTools.hideRotate(level2);
                    AnimationTools.hideRotate(level3,100);
                    isHomeShow = false;
                }else{
                    AnimationTools.showRotate(level2);
                    AnimationTools.showRotate(level3,100);
                    isHomeShow = true;
                }
                break;
            case R.id.menu:
                if(isMenuShow){
                    AnimationTools.hideRotate(level3);
                    isMenuShow = false;
                }else{
                    AnimationTools.showRotate(level3);
                    isMenuShow = true;
                }
                break;
        }
    }

    /**
     * 监听菜单按键
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_MINUS){
            if(isMenuShow){
                AnimationTools.hideRotate(level3);
                isMenuShow = false;
            }else{
                AnimationTools.showRotate(level3);
                isMenuShow = true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
