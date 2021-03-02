package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;

/* access modifiers changed from: package-private */
public abstract class r extends y {
    public r(Context context) {
        super(context);
        super.setHorizontallyScrolling(true);
    }

    public void setGravity(int i2) {
        super.setGravity((i2 & -81 & -49) | 16);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab, com.tencent.mm.plugin.appbrand.widget.input.y
    public boolean cbB() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void setSingleLine(boolean z) {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.y
    public final void setInputType(int i2) {
        super.setInputType(-131073 & i2);
    }

    public boolean canScrollVertically(int i2) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.ab
    public final boolean cbx() {
        return false;
    }

    public final boolean isLaidOut() {
        boolean z;
        boolean isLaidOut = super.isLaidOut();
        if (isLaidOut && isFocusable()) {
            if (getBottom() <= getTop() || getRight() <= getLeft()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                try {
                    StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                    if (stackTrace != null && stackTrace.length >= 3 && stackTrace[2].getMethodName().equals("canTakeFocus")) {
                        return false;
                    }
                } catch (Throwable th) {
                }
            }
        }
        return isLaidOut;
    }
}
