package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;

public abstract class b<T extends RecyclerView.v> implements c<T> {
    public static float e(RecyclerView recyclerView, RecyclerView.v vVar) {
        if (!(vVar instanceof d)) {
            return 0.0f;
        }
        int[] iArr = new int[2];
        ((d) vVar).nnL.getLocationOnScreen(iArr);
        return ((float) iArr[1]) + (com.tencent.mm.plugin.appbrand.widget.desktop.b.ey(recyclerView.getContext()) / 2.0f);
    }

    public static float f(RecyclerView recyclerView, RecyclerView.v vVar) {
        if (!(vVar instanceof d)) {
            return 0.0f;
        }
        int[] iArr = new int[2];
        ((d) vVar).nnL.getLocationOnScreen(iArr);
        return ((float) iArr[0]) + (com.tencent.mm.plugin.appbrand.widget.desktop.b.ey(recyclerView.getContext()) / 2.0f);
    }
}
