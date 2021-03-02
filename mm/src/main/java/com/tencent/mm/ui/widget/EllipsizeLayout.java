package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.k;

public class EllipsizeLayout extends LinearLayout {
    private final boolean QBL;

    public EllipsizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(204438);
        this.QBL = context.obtainStyledAttributes(attributeSet, k.a.EllipsizeLayout).getBoolean(0, false);
        AppMethodBeat.o(204438);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 248
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.EllipsizeLayout.onMeasure(int, int):void");
    }
}
