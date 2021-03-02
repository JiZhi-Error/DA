package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FirstRowLayoutManager extends GridLayoutManager {
    public FirstRowLayoutManager(Context context, int i2) {
        super(i2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(256706);
        a aVar = new a(recyclerView.getContext());
        aVar.atO = i2;
        startSmoothScroll(aVar);
        AppMethodBeat.o(256706);
    }

    static class a extends ae {
        a(Context context) {
            super(context);
        }

        @Override // android.support.v7.widget.ae
        public final int f(int i2, int i3, int i4, int i5, int i6) {
            return i4 - i2;
        }

        @Override // android.support.v7.widget.ae
        public final float a(DisplayMetrics displayMetrics) {
            return 50.0f / ((float) displayMetrics.densityDpi);
        }
    }
}
