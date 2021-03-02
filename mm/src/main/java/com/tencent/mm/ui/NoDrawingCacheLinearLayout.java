package com.tencent.mm.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NoDrawingCacheLinearLayout extends LinearLayout {
    @SuppressLint({"NewApi"})
    public NoDrawingCacheLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public NoDrawingCacheLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildDrawingCache() {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(33676);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(33676);
    }
}
