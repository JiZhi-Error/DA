package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class IPCallFeedbackScrollView extends ScrollView {
    public IPCallFeedbackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IPCallFeedbackScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(25796);
        try {
            Display defaultDisplay = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i3 = View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels / 2, Integer.MIN_VALUE);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.IPCallFeedbackScrollView", e2, "", new Object[0]);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(25796);
    }
}
