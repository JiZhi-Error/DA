package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;

public interface c<VH extends RecyclerView.v> {
    boolean R(VH vh);

    boolean S(VH vh);

    boolean T(VH vh);

    void a(RecyclerView recyclerView, VH vh, int i2, Runnable runnable);

    void a(View view, float f2, float f3, RecyclerView.v vVar, int i2);

    boolean a(RecyclerView recyclerView, VH vh, VH vh2, int i2, int i3);

    View g(RecyclerView recyclerView, VH vh);

    void h(RecyclerView recyclerView);

    void h(RecyclerView recyclerView, VH vh);
}
