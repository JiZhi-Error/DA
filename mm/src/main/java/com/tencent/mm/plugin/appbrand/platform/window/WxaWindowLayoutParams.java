package com.tencent.mm.plugin.appbrand.platform.window;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class WxaWindowLayoutParams extends FrameLayout.LayoutParams {
    public float scale = 1.0f;

    public WxaWindowLayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WxaWindowLayoutParams(int i2, int i3) {
        super(i2, i3);
    }

    public final void setScale(float f2) {
        this.scale = f2;
    }
}
