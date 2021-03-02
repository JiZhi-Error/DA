package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SpeedyLinearLayoutManager extends LinearLayoutManager {
    private float UXh = 50.0f;

    public SpeedyLinearLayoutManager(byte b2) {
    }

    public SpeedyLinearLayoutManager() {
        super(0, false);
    }

    public SpeedyLinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public final void hVQ() {
        this.UXh = 100.0f;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(111713);
        AnonymousClass1 r0 = new ae(recyclerView.getContext()) {
            /* class com.tencent.mm.plugin.gallery.ui.SpeedyLinearLayoutManager.AnonymousClass1 */

            @Override // android.support.v7.widget.RecyclerView.r
            public final PointF bZ(int i2) {
                AppMethodBeat.i(111712);
                PointF bZ = SpeedyLinearLayoutManager.this.bZ(i2);
                AppMethodBeat.o(111712);
                return bZ;
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                AppMethodBeat.i(261887);
                float f2 = SpeedyLinearLayoutManager.this.UXh / ((float) displayMetrics.densityDpi);
                AppMethodBeat.o(261887);
                return f2;
            }
        };
        r0.atO = i2;
        startSmoothScroll(r0);
        AppMethodBeat.o(111713);
    }
}
