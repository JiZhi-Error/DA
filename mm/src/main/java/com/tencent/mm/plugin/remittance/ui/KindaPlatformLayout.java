package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaPlatformLayout extends LinearLayout {
    public static String TAG = "KindaPlatformLayout";
    private h CqA = new h();

    public KindaPlatformLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(67928);
        AppMethodBeat.o(67928);
    }

    public KindaPlatformLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(67929);
        AppMethodBeat.o(67929);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(67930);
        long currentTimeMillis = System.currentTimeMillis();
        super.onMeasure(i2, i3);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        this.CqA.valMeasure += currentTimeMillis2;
        Log.i(TAG, "testandroid root measure out %s %s", Long.valueOf(currentTimeMillis2), this.CqA.result());
        AppMethodBeat.o(67930);
    }

    public void requestLayout() {
        AppMethodBeat.i(67931);
        super.requestLayout();
        AppMethodBeat.o(67931);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(67932);
        long currentTimeMillis = System.currentTimeMillis();
        super.onLayout(z, i2, i3, i4, i5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        this.CqA.valLayout += currentTimeMillis2;
        Log.i(TAG, "testandroid root layout out %s %s", Long.valueOf(currentTimeMillis2), this.CqA.result());
        AppMethodBeat.o(67932);
    }
}
