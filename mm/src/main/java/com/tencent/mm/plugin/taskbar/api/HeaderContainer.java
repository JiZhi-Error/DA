package com.tencent.mm.plugin.taskbar.api;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.appbrand.widget.c.a.a;
import com.tencent.mm.ui.MMFragmentActivity;

public abstract class HeaderContainer extends RelativeLayout {
    public abstract void fuA();

    public abstract boolean fuw();

    public abstract int getAnimationScrollOffset();

    public abstract Rect getBackUpFooterRect();

    public abstract View getBackgroundGLSurfaceContainer();

    public abstract View getBackgroundGLSurfaceView();

    public abstract View getBackgroundGradientView();

    public abstract View getEmptyView();

    public abstract int getExtraBottomHeight();

    public abstract GyroView getGyroView();

    public abstract a getHeaderView();

    public abstract View getMaskView();

    public abstract LinearLayout getRootLayout();

    public abstract void hWQ();

    public abstract void o(View view, View view2);

    public abstract void setActivity(MMFragmentActivity mMFragmentActivity);

    public abstract void setAnimController(b bVar);

    public abstract void setBlurAlpha(float f2);

    public abstract void setBlurAnimateStatue(boolean z);

    public abstract void setDynamicBackgroundView(View view);

    public abstract void setExtraBottomHeight(int i2);

    public abstract void setFixedHeight(boolean z);

    public HeaderContainer(Context context) {
        super(context);
    }

    public HeaderContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HeaderContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public int getViewHeight() {
        return 0;
    }

    public void setActionBar(View view) {
    }

    public void jh(int i2, int i3) {
    }

    public void abx(int i2) {
    }

    public void ji(int i2, int i3) {
    }

    public boolean isFullScreen() {
        return false;
    }

    public void wn(boolean z) {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }

    public void ac(long j2, int i2) {
    }

    public void ad(long j2, int i2) {
    }

    public void f(Configuration configuration) {
    }
}
