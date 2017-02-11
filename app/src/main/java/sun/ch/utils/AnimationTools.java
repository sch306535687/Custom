package sun.ch.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by sunch on 2017/1/6.
 */
public class AnimationTools {
    /**
     * 旋转动画
     * @param view
     */
    public static void hideRotate(ViewGroup view){
        hideRotate(view,0);
    }
    public static void hideRotate(ViewGroup view,long delay) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
        rotateAnimation.setDuration(800);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(delay);
        //禁用ViewGroup子类的点击事件
        int count = view.getChildCount();
        for(int i=0;i<count;i++){
            View childAt = view.getChildAt(i);
            childAt.setEnabled(false);
        }
        view.startAnimation(rotateAnimation);
    }
    /**
     * 旋转动画
     * @param view
     */
    public static void showRotate(ViewGroup view){
        showRotate(view,0);
    }
    public static void showRotate(ViewGroup view,long delay) {
        RotateAnimation rotateAnimation = new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
        rotateAnimation.setDuration(800);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(delay);
        //禁用ViewGroup子类的点击事件
        int count = view.getChildCount();
        for(int i=0;i<count;i++){
            View childAt = view.getChildAt(i);
            childAt.setEnabled(true);
        }
        view.startAnimation(rotateAnimation);
    }
}
