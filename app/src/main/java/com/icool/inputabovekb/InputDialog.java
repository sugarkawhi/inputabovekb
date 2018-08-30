package com.icool.inputabovekb;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * @author zhzy
 * created on 2018/8/30.
 */
public class InputDialog extends Dialog{
    public InputDialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.dialog_input);

    }


}
