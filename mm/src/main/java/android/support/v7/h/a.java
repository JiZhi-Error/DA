package android.support.v7.h;

import android.support.v7.widget.RecyclerView;

public final class a implements d {
    private final RecyclerView.a adj;

    public a(RecyclerView.a aVar) {
        this.adj = aVar;
    }

    @Override // android.support.v7.h.d
    public final void f(int i2, int i3) {
        this.adj.as(i2, i3);
    }

    @Override // android.support.v7.h.d
    public final void k(int i2, int i3) {
        this.adj.at(i2, i3);
    }

    @Override // android.support.v7.h.d
    public final void l(int i2, int i3) {
        this.adj.ar(i2, i3);
    }

    @Override // android.support.v7.h.d
    public final void c(int i2, int i3, Object obj) {
        this.adj.e(i2, i3, obj);
    }
}
