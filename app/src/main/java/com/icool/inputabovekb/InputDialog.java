package com.icool.inputabovekb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * @author zhzy
 * created on 2018/8/30.
 */
public class InputDialog extends Dialog {

    private static final String TAG = "InputDialog";

    private MyEditText mEditText;
    private View mBtnSend;
    private IInputSendListener mSendListener;

    public InputDialog(@NonNull Context context) {
        super(context);
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(Window.FEATURE_NO_TITLE);
            View view = getLayoutInflater().inflate(R.layout.dialog_input, null);
            setContentView(view);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WRAP_CONTENT;
            lp.windowAnimations = -1;
            lp.gravity = Gravity.BOTTOM;
            lp.dimAmount = 0.5f;
            window.setAttributes(lp);
            window.setBackgroundDrawable(new BitmapDrawable());
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        }
        mEditText = findViewById(R.id.editText);
        mBtnSend = findViewById(R.id.btn_send);

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSendListener != null)
                    mSendListener.onSendClick(getContent());
            }
        });

        mEditText.setIBack(new MyEditText.IBack() {
            @Override
            public void back() {
                dismiss();
            }
        });


        mEditText.requestFocus();


        setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                KeyboardUtils.showSoftInput(mEditText);
            }
        });
    }


    @Override
    public void dismiss() {
        KeyboardUtils.hideSoftInput(mEditText);
        super.dismiss();
    }

    public InputDialog setSendListener(IInputSendListener sendListener) {
        mSendListener = sendListener;
        return this;
    }

    private String getContent() {
        return mEditText.getText().toString();
    }


    public interface IInputSendListener {
        void onSendClick(String content);
    }

    @Override
    public void onBackPressed() {
        dismiss();
    }
}
