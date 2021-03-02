package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class as extends RecyclerView.f {
    public boolean awI = true;

    public abstract boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5);

    public abstract boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5);

    public abstract boolean b(RecyclerView.v vVar);

    public abstract boolean c(RecyclerView.v vVar);

    public final void my() {
        this.awI = false;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public boolean p(RecyclerView.v vVar) {
        return !this.awI || vVar.isInvalid();
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public boolean d(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i2 = cVar.left;
        int i3 = cVar.top;
        View view = vVar.aus;
        int left = cVar2 == null ? view.getLeft() : cVar2.left;
        int top = cVar2 == null ? view.getTop() : cVar2.top;
        if (vVar.isRemoved() || (i2 == left && i3 == top)) {
            return b(vVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(vVar, i2, i3, left, top);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public boolean e(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar == null || (cVar.left == cVar2.left && cVar.top == cVar2.top)) {
            return c(vVar);
        }
        return a(vVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public boolean f(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar.left != cVar2.left || cVar.top != cVar2.top) {
            return a(vVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
        }
        x(vVar);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.f
    public boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i2;
        int i3;
        int i4 = cVar.left;
        int i5 = cVar.top;
        if (vVar2.lP()) {
            i2 = cVar.left;
            i3 = cVar.top;
        } else {
            i2 = cVar2.left;
            i3 = cVar2.top;
        }
        return a(vVar, vVar2, i4, i5, i2, i3);
    }

    public final void w(RecyclerView.v vVar) {
        D(vVar);
        n(vVar);
    }

    public final void x(RecyclerView.v vVar) {
        F(vVar);
        n(vVar);
    }

    public final void y(RecyclerView.v vVar) {
        n(vVar);
    }

    public final void z(RecyclerView.v vVar) {
        n(vVar);
    }

    public final void A(RecyclerView.v vVar) {
        C(vVar);
    }

    public final void B(RecyclerView.v vVar) {
        E(vVar);
    }

    public void C(RecyclerView.v vVar) {
    }

    public void D(RecyclerView.v vVar) {
    }

    public void E(RecyclerView.v vVar) {
    }

    public void F(RecyclerView.v vVar) {
    }
}
