package com.tencent.mm.plugin.k;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

public abstract class a {
    public abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    public abstract boolean dispatchTouchEvent(MotionEvent motionEvent);

    public abstract boolean edH();

    public abstract void onBackPressed();

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    public void onActivityResult(int i2, int i3, Intent intent) {
    }
}
