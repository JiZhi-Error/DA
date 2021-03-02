package com.tencent.mm.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.widget.AbsListView;

public abstract class l {
    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    public void onFinish() {
    }
}
