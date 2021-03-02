package android.arch.b;

import android.arch.b.h;

/* access modifiers changed from: package-private */
public final class l<T> extends h<T> {
    private final d<?, T> dY;
    private final boolean fu;
    private final Object fv;

    l(h<T> hVar) {
        super(new j(hVar.eF), hVar.dB, hVar.eE, null, hVar.ed);
        this.dY = hVar.ap();
        this.fu = hVar.ao();
        this.fv = hVar.aq();
    }

    @Override // android.arch.b.h
    public final boolean isImmutable() {
        return true;
    }

    @Override // android.arch.b.h
    public final boolean isDetached() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // android.arch.b.h
    public final boolean ao() {
        return this.fu;
    }

    @Override // android.arch.b.h
    public final Object aq() {
        return this.fv;
    }

    @Override // android.arch.b.h
    public final d<?, T> ap() {
        return this.dY;
    }

    /* access modifiers changed from: package-private */
    @Override // android.arch.b.h
    public final void a(h<T> hVar, h.c cVar) {
    }
}
