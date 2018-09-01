package com.icool.inputabovekb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

/**
 * @author zhzy
 * created on 2018/8/31.
 */
public class MyEditText extends android.support.v7.widget.AppCompatEditText {

    private IBack mIBack;

    public void setIBack(IBack IBack) {
        mIBack = IBack;
    }


    public MyEditText(Context context) {
        this(context, null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (mIBack != null) mIBack.back();
        return super.onKeyPreIme(keyCode, event);
    }

    public interface IBack {
        void back();
    }
}
