package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

final class o implements r {
    o() {
    }

    @Override // android.support.v7.widget.r
    public final void a(q qVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        qVar.q(new an(colorStateList, f2));
        View jz = qVar.jz();
        jz.setClipToOutline(true);
        jz.setElevation(f3);
        b(qVar, f4);
    }

    @Override // android.support.v7.widget.r
    public final void a(q qVar, float f2) {
        an j2 = j(qVar);
        if (f2 != j2.auL) {
            j2.auL = f2;
            j2.h(null);
            j2.invalidateSelf();
        }
    }

    @Override // android.support.v7.widget.r
    public final void initStatic() {
    }

    @Override // android.support.v7.widget.r
    public final void b(q qVar, float f2) {
        j(qVar).a(f2, qVar.getUseCompatPadding(), qVar.getPreventCornerOverlap());
        f(qVar);
    }

    @Override // android.support.v7.widget.r
    public final float a(q qVar) {
        return j(qVar).auO;
    }

    @Override // android.support.v7.widget.r
    public final float d(q qVar) {
        return j(qVar).auL;
    }

    @Override // android.support.v7.widget.r
    public final void c(q qVar, float f2) {
        qVar.jz().setElevation(f2);
    }

    @Override // android.support.v7.widget.r
    public final float e(q qVar) {
        return qVar.jz().getElevation();
    }

    @Override // android.support.v7.widget.r
    public final void f(q qVar) {
        if (!qVar.getUseCompatPadding()) {
            qVar.e(0, 0, 0, 0);
            return;
        }
        float f2 = j(qVar).auO;
        float f3 = j(qVar).auL;
        int ceil = (int) Math.ceil((double) ao.b(f2, f3, qVar.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil((double) ao.a(f2, f3, qVar.getPreventCornerOverlap()));
        qVar.e(ceil, ceil2, ceil, ceil2);
    }

    @Override // android.support.v7.widget.r
    public final void a(q qVar, ColorStateList colorStateList) {
        an j2 = j(qVar);
        j2.g(colorStateList);
        j2.invalidateSelf();
    }

    @Override // android.support.v7.widget.r
    public final ColorStateList i(q qVar) {
        return j(qVar).auR;
    }

    private static an j(q qVar) {
        return (an) qVar.jy();
    }

    @Override // android.support.v7.widget.r
    public final float b(q qVar) {
        return j(qVar).auL * 2.0f;
    }

    @Override // android.support.v7.widget.r
    public final float c(q qVar) {
        return j(qVar).auL * 2.0f;
    }

    @Override // android.support.v7.widget.r
    public final void g(q qVar) {
        b(qVar, j(qVar).auO);
    }

    @Override // android.support.v7.widget.r
    public final void h(q qVar) {
        b(qVar, j(qVar).auO);
    }
}
