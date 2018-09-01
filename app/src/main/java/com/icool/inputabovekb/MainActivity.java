package com.icool.inputabovekb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().getDecorView().getViewTreeObserver()
//                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//                        Log.e(TAG, "onGlobalLayout ");
//                    }
//                });
    }

    private void newDialog() {

        new InputDialog(this)
                .setSendListener(new InputDialog.IInputSendListener() {
                    @Override
                    public void onSendClick(String content) {
                        Toast toast = Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                })
                .show();

    }

    public void letsDoIt(View view) {
        newDialog();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
