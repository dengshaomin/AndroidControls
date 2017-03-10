package com.example.dengshaomin.androidcontrol;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public class GCButton extends Button {
    private Context mContext;
    private GradientDrawable gradientDrawable;
    private int backColor = 0;//背景色
    private int backColorSelected = 0;//按下后的背景色
    private int backGroundImage = 0;//背景图
    private int backGroundImageSeleted = 0;//按下后的背景图
    private int textColor = Color.BLACK;//文字颜色
    private int textColorSeleted = 0;//按下后的文字颜色
    private float radius = 8;//圆角半径
    private int shape = 0;//圆角样式，矩形、圆形等，由于矩形的Id为0，默认为矩形
    private Boolean fillet = false;//是否设置圆角
    private int strokeWidth = 1;//边框宽度
    private int strokeColor = Color.TRANSPARENT;//边框颜色

    public GCButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init();
        initAttrs(attrs);
    }

    public GCButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GCButton(Context context) {
        this(context, null);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.GCButton);
        setStroke(a.getDimensionPixelSize(R.styleable.GCButton_strokeWidth, strokeWidth), a.getColor(R.styleable
                .GCButton_strokeColor, strokeColor));
        setBackColor(a.getColor(R.styleable.GCButton_backColors, 0));
        setBackColorSelected(a.getColor(R.styleable.GCButton_backColorSelected, 0));
        setBackGroundImage(a.getInteger(R.styleable.GCButton_backGroundImage, 0));
        setBackGroundImageSeleted(a.getInteger(R.styleable.GCButton_backGroundImageSeleted, 0));
        setTextColorSelected(a.getColor(R.styleable.GCButton_textColorSeleted, 0));
        setRadius(a.getDimensionPixelSize(R.styleable.GCButton_radius, 0));
        setShape(a.getInt(R.styleable.GCButton_shape, 0));
        setFillet(a.getBoolean(R.styleable.GCButton_fillet, false));
        a.recycle();
        TypedArray b = mContext.obtainStyledAttributes(attrs, new int[]{android.R.attr.textColor});
        setTextColor(b.getColor(0, textColor));
        b.recycle();
        invalidateView();
    }

    @Override
    public void setOnClickListener(@Nullable final OnClickListener l) {
        super.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                l.onClick(v);
            }
        });
    }

    private void init() {
        //将Button的默认背景色改为透明
//        if (fillet) {
//            if (gradientDrawable == null) {
//                gradientDrawable = new GradientDrawable();
//            }
//            gradientDrawable.setColor(Color.TRANSPARENT);
//        } else {
//            setBackgroundColor(Color.TRANSPARENT);
//        }
        //设置文字默认居中
        setGravity(Gravity.CENTER);
        //设置Touch事件
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent event) {
                //按下改变样式
                setColor(event.getAction());
                //此处设置为false，防止Click事件被屏蔽
                return false;
            }
        });
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //改变样式
    @SuppressWarnings("Range")
    private void setColor(int state) {
        if (state == MotionEvent.ACTION_DOWN) {
            //按下
            if (backColorSelected != 0) {
                //先判断是否设置了按下后的背景色int型
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(backColorSelected);
                } else {
                    setBackgroundColor(backColorSelected);
                }
            } else if (backColorSelected != 0) {
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(backColorSelected);
                } else {
                    setBackgroundColor(backColorSelected);
                }
            }
            //判断是否设置了按下后文字的颜色
            if (textColorSeleted != 0) {
                setTextColor(textColorSeleted);
            } else if (backColorSelected != 0) {
                setTextColor(backColorSelected);
            }
            //判断是否设置了按下后的背景图
            if (backGroundImageSeleted != 0) {
                setBackgroundResource(backGroundImageSeleted);
            }
        }
        if (state == MotionEvent.ACTION_UP) {
            //抬起
            if (backColor == 0) {
                //如果没有设置背景色，默认改为透明
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(Color.TRANSPARENT);
                } else {
                    setBackgroundColor(Color.TRANSPARENT);
                }
            } else if (backColor != 0) {
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(backColor);
                } else {
                    setBackgroundColor(backColor);
                }
            } else {
                if (fillet) {
                    if (gradientDrawable == null) {
                        gradientDrawable = new GradientDrawable();
                    }
                    gradientDrawable.setColor(backColor);
                } else {
                    setBackgroundColor(backColor);
                }
            }
            //如果为设置字体颜色，默认为黑色
            if (textColor == 0) {
                setTextColor(Color.BLACK);
            } else if (textColor != 0) {
                setTextColor(textColor);
            } else {
                setTextColor(textColor);
            }
            if (backGroundImage != 0) {
                setBackgroundResource(backGroundImage);
            }
        }
    }

    /**
     * 设置按钮的背景色,如果未设置则默认为透明
     *
     * @param backColor
     */
    public void setBackColor(int backColor) {
        this.backColor = backColor;
    }

    /**
     * 设置按钮按下后的颜色
     *
     * @param backColorSelected
     */
    public void setBackColorSelected(int backColorSelected) {
        this.backColorSelected = backColorSelected;
    }


    /**
     * 设置按钮的背景图
     *
     * @param backGroundImage
     */
    public void setBackGroundImage(int backGroundImage) {
        this.backGroundImage = backGroundImage;
    }

    /**
     * 设置按钮按下的背景图
     *
     * @param backGroundImageSeleted
     */
    public void setBackGroundImageSeleted(int backGroundImageSeleted) {
        this.backGroundImageSeleted = backGroundImageSeleted;
    }

    /**
     * 设置按钮圆角半径大小
     *
     * @param radius
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }


    /**
     * 设置按钮文字颜色
     *
     * @param textColor
     */
    public void settextColor(int textColor) {
        this.textColor = textColor;
        setTextColor(textColor);
    }


    /**
     * 设置按钮按下的文字颜色
     *
     * @param textColor
     */
    public void setTextColorSelected(int textColor) {
        this.textColorSeleted = textColor;
    }

    /**
     * 按钮的形状
     *
     * @param shape
     */
    public void setShape(int shape) {
        this.shape = shape;
    }

    /**
     * 设置其是否为圆角
     *
     * @param fillet
     */
    @SuppressWarnings("deprecation")
    public void setFillet(Boolean fillet) {
        this.fillet = fillet;
    }

    public void setStroke(int strokeWidth, int strokeColor) {
        this.strokeWidth = strokeWidth;
        this.strokeColor = strokeColor;
    }

    public void invalidateView() {
        if (gradientDrawable == null) {
            gradientDrawable = new GradientDrawable();
        }
        if (backColor == 0) {
            if (fillet) {
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                }
                gradientDrawable.setColor(Color.TRANSPARENT);
            } else {
                setBackgroundColor(Color.TRANSPARENT);
            }
        } else {
            if (fillet) {
                if (gradientDrawable == null) {
                    gradientDrawable = new GradientDrawable();
                }
                gradientDrawable.setColor(backColor);
            } else {
                setBackgroundColor(backColor);
            }
        }
        if (backGroundImage != 0) {
            setBackgroundResource(backGroundImage);
        }
        //GradientDrawable.RECTANGLE
        if (fillet) {
            gradientDrawable.setShape(shape);
            gradientDrawable.setCornerRadius(radius);
            gradientDrawable.setStroke(strokeWidth, strokeColor);
            setBackgroundDrawable(gradientDrawable);
        }
    }

    public abstract class NoDoubleClickListener implements OnClickListener {

        public static final int MIN_CLICK_DELAY_TIME = 1000;
        private long lastClickTime = 0;

        @Override
        public void onClick(View v) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
                lastClickTime = currentTime;
                onNoDoubleClick(v);
            }
        }

        protected abstract void onNoDoubleClick(View v);
    }
}