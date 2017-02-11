package sun.ch.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import sun.ch.custom.R;

/**
 * 自定义开关
 * Created by asus on 2017/1/6.
 */
public class MySwitch extends View {

    private Paint paint;
    private Bitmap bitmapBg;
    private Bitmap bitmapSlide;
    private int maxSlide;//最大滑动距离
    private int slide;
    private boolean isSwitch;
    private boolean isClick;

    public MySwitch(Context context) {
        super(context);
        init();
    }

    public MySwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化数据
     */
    public void init() {
        paint = new Paint();//初始化画笔
        bitmapBg = BitmapFactory.decodeResource(getResources(), R.mipmap.switch_background);
        bitmapSlide = BitmapFactory.decodeResource(getResources(), R.mipmap.slide_button);
        maxSlide = bitmapBg.getWidth() - bitmapSlide.getWidth();

        /**
         * 监听开关
         */
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isClick){
                    if (isSwitch) {
                        //打开状态
                        slide = 0;
                        isSwitch = false;
                        invalidate();//重新调用onDraw()
                    } else {
                        //关闭状态
                        slide = maxSlide;
                        isSwitch = true;
                        invalidate();//重新调用onDraw()
                    }
                }
                mListener.setOnClickListener(view, isSwitch);//设置对外参数
            }
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmapBg, 0, 0, paint);
        canvas.drawBitmap(bitmapSlide, slide, 0, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //设置画布大小
        setMeasuredDimension(bitmapBg.getWidth(), bitmapBg.getHeight());
    }

    /**
     * 定义对外操作的方法
     */
    private OnCheckListener mListener;

    public void setOnCheckListener(OnCheckListener listener) {
        mListener = listener;
    }

    /**
     * 定义接口
     */
    public interface OnCheckListener {
        public void setOnClickListener(View view, boolean checked);
    }

    ;

    /**
     * 监听滑动事件
     *
     * @param event
     * @return
     */
    int startX;
    int moveX;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                int x = (int) event.getX();
                //滑动距离
                int dx = x - startX;
                slide += dx;
                moveX += dx;
                //限制范围
                if (slide < 0) {
                    slide = 0;
                }
                if (slide > maxSlide) {
                    slide = maxSlide;
                }
                invalidate();
                startX = x;
                break;
            case MotionEvent.ACTION_UP:

                if (moveX < 5) {
                    //点击事件
                    isClick=true;
                } else {
                    //滑动事件
                    isClick=false;
                }
                if(!isClick){
                    if (moveX < (maxSlide / 2)) {
                        slide = 0;
                        isSwitch = false;
                    } else {
                        slide = maxSlide;
                        isSwitch = true;
                    }
                    invalidate();
                }
                break;
        }
        return super.onTouchEvent(event);//由系统动态计算是返回true还是false
        //return true;
    }
}
