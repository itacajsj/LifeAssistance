package io.orz.lifeassistance;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

/**
 * Created by itaca on 2018/10/15.
 */

public class ClockView extends View{

    //背景
    @ColorInt
    protected static int CLOCK_BACKGROUND_COLOR = 0xFFF0F0F0;
    // 外边框圆环颜色
    @ColorInt
    protected static int CLOCK_RING_COLOR = 0xFFF0F0F0;
    // 字体颜色
    @ColorInt
    protected static int TEXT_COLOR  = 0xFFF0F0F0;
    // 时针和分针颜色
    @ColorInt
    protected static int HOUR_MINUTE_COLOR = 0xFFF0F0F0;
    // 秒针颜色
    @ColorInt
    protected static int SECOND_COLOR  = 0xFFF0F0F0;
    // 刻度颜色
    @ColorInt
    protected static int CLOCK_SCALE_COLOR = 0xFFF0F0F0;

    // 时针最小尺寸
    private static final int CLOCK_MIN_SIZE = 200;

    // 时针宽度
    private static final int HOUR_WIDTH = 16;

    // 分针宽度
    private static final int MINIT_WIDTH = 13;

    // 秒针宽度
    private static final int SECOND_WIDTH = 8;

    //刻度宽度
    private static final int SCALE_WIDTH = 4;

    // 秒针间隔
    private static final int SECOND_DEGREE = 6;

    private static  final int TEXT_SIZE = 13;

    private static final String[] SCALE_TEXT = {"12","1","2","3","4","5","6","7","8","9","10","11"};

    private float hour=5;

    private float minit = 30;

    private float second = 5;

    // 时针画笔
    private Paint hourPaint;

    // 分针画笔
    private Paint minutePaint;

    // 秒针画笔
    private Paint secondPaint;

    //圆环宽度
    private int clockRingWidth = 10;

    // 时钟大小
    private int clockSize;

    // 时钟画笔
    private Paint clockPaint;

    // 时钟中心外部圆
    private Paint clockRingPaint;

    // 时钟外圆画笔
    private Paint clockCenterOuterRoundPaint;

    // 时钟内圆画笔
    private Paint clockCenterInnerRoundPaint;

    // 时钟刻度画笔
    private Paint clockScalePaint;

    // 时钟文本画笔
    private Paint clockTextPaint;

    // 获取时间工具
    private Calendar calendar = null;

    public ClockView(Context context) {
        super(context);
        initView();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    public void initView(){
        // 初始化画笔
        clockPaint = new Paint();
        clockPaint.setColor(CLOCK_BACKGROUND_COLOR);
        // 开启抗锯齿
        clockPaint.setAntiAlias(true);

        // 圆环
        clockRingPaint = new Paint();
        clockRingPaint.setColor(CLOCK_RING_COLOR);
        clockRingPaint.setAntiAlias(true);
        // 画笔粗
        clockRingPaint.setStrokeWidth(clockRingWidth);
        clockRingPaint.setStyle(Paint.Style.STROKE);
        clockRingPaint.setShadowLayer(4,2,2,0x80000000);

        // 时针
        hourPaint = new Paint();
        hourPaint.setAntiAlias(true);
        hourPaint.setColor(HOUR_MINUTE_COLOR);
        hourPaint.setStrokeWidth(HOUR_WIDTH);
        // 设置角部为圆角
        hourPaint.setStrokeCap(Paint.Cap.ROUND);
        hourPaint.setShadowLayer(4,2,2,0x80000000);

        // 时针
        minutePaint = new Paint();
        minutePaint.setAntiAlias(true);
        minutePaint.setColor(HOUR_MINUTE_COLOR);
        minutePaint.setStrokeWidth(MINIT_WIDTH);
        minutePaint.setStrokeCap(Paint.Cap.ROUND);
        minutePaint.setShadowLayer(4,2,2,0x80000000);

        // 秒针
        secondPaint = new Paint();
        secondPaint.setAntiAlias(true);
        secondPaint.setColor(SECOND_COLOR);
        secondPaint.setStrokeWidth(SECOND_WIDTH);
        secondPaint.setStrokeCap(Paint.Cap.ROUND);
        secondPaint.setShadowLayer(4, 3, 0, 0x80000000);

        // 指针中心外圆
        clockCenterOuterRoundPaint = new Paint();
        clockCenterOuterRoundPaint.setAntiAlias(true);
        clockCenterOuterRoundPaint.setColor(HOUR_MINUTE_COLOR);
        clockCenterOuterRoundPaint.setShadowLayer(5,0,0,0x80000000);

        // 指针中心内圆
        clockCenterInnerRoundPaint = new Paint();
        clockCenterInnerRoundPaint.setAntiAlias(true);
        clockCenterInnerRoundPaint.setColor(SECOND_COLOR);
        clockCenterInnerRoundPaint.setShadowLayer(5,0,0,0x80000000);

        //刻度画笔
        clockScalePaint = new Paint();
        clockScalePaint.setAntiAlias(true);
        clockScalePaint.setColor(CLOCK_SCALE_COLOR);
        clockScalePaint.setStrokeCap(Paint.Cap.ROUND);
        clockScalePaint.setStrokeWidth(SCALE_WIDTH);

        // 文字画笔
        clockTextPaint = new Paint();
        clockTextPaint.setAntiAlias(true);
        clockTextPaint.setStrokeWidth(1f);
        clockTextPaint.setColor(TEXT_COLOR);
        clockTextPaint.setTextSize(TEXT_SIZE);

    }
}
