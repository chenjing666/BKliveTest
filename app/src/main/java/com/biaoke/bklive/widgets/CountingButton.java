package com.biaoke.bklive.widgets;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.widget.Button;

import com.biaoke.bklive.R;


/**
 * Created by Rickey on 2017/2/9.
 */
public class CountingButton extends Button {

    private String defaultText;
    private int normalBackgroundColor = getResources().getColor(R.color.cF8450e);
    private int countingBackgroundColor = getResources().getColor(R.color.cCbcbcb);
    private int normalTextColor = getResources().getColor(R.color.white);
    private int countingTextColor = getResources().getColor(R.color.cF8450e);
    private int countingTime = 0;
    private int recodeTime = 0;

    private static final int DEFAULT_COUNTING_TIME = 60;

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (countingTime <= 0) {
                handler.removeCallbacks(this);
                resume();
            } else {
                countingTime--;
                setText(String.valueOf(countingTime));
                handler.postDelayed(this, 1000);
            }
        }
    };

    public CountingButton(Context context) {
        this(context, null);
    }

    public CountingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        defaultText = getText().toString();
        setBackgroundColor(normalBackgroundColor);
        setTextColor(normalTextColor);
        if (countingTime <= 0) {
            countingTime = DEFAULT_COUNTING_TIME;
        }
    }

    public void counting() {
        setClickable(false);
        setBackgroundColor(countingBackgroundColor);
        setTextColor(countingTextColor);
        setText(String.valueOf(countingTime));
        handler.postDelayed(runnable, 1000);
    }

    public void resume() {
        setText(defaultText);
        countingTime = recodeTime;
        setBackgroundColor(normalBackgroundColor);
        setTextColor(normalTextColor);
        setClickable(true);
    }

    public void setCountingTime(int countingTime) {
        this.countingTime = countingTime;
        recodeTime = countingTime;
    }

    public void setNormalBackgroundColor(@ColorRes int color) {
        normalBackgroundColor = color;
    }

    public void setCountingBackgroundColor(@ColorRes int color) {
        countingBackgroundColor = color;
    }

    public void setNormalTextColor(@ColorRes int color) {
        normalTextColor = color;
    }

    public void setCountingTextColor(@ColorRes int color) {
        countingTextColor = color;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacks(runnable);
    }
}
