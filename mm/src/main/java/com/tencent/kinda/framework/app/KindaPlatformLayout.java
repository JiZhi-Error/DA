package com.tencent.kinda.framework.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaPlatformLayout extends LinearLayout {
    public static String TAG = "KindaPlatformLayout";
    private TestMeasure measure = new TestMeasure();

    public KindaPlatformLayout(Context context) {
        super(context);
        AppMethodBeat.i(18462);
        AppMethodBeat.o(18462);
    }

    public KindaPlatformLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(18463);
        AppMethodBeat.o(18463);
    }

    public KindaPlatformLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(18464);
        AppMethodBeat.o(18464);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(18465);
        long currentTimeMillis = System.currentTimeMillis();
        super.onMeasure(i2, i3);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        TestMeasure testMeasure = this.measure;
        testMeasure.valMeasure = currentTimeMillis2 + testMeasure.valMeasure;
        AppMethodBeat.o(18465);
    }

    public void requestLayout() {
        AppMethodBeat.i(18466);
        super.requestLayout();
        AppMethodBeat.o(18466);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(18467);
        long currentTimeMillis = System.currentTimeMillis();
        super.onLayout(z, i2, i3, i4, i5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        TestMeasure testMeasure = this.measure;
        testMeasure.valLayout = currentTimeMillis2 + testMeasure.valLayout;
        AppMethodBeat.o(18467);
    }
}
