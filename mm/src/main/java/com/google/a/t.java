package com.google.a;

import com.google.a.ac;
import com.google.a.l;

public final class t extends s<l.f> {
    private static final long bUl = Ge();

    t() {
    }

    private static <T> long Ge() {
        try {
            return ch.a(ac.d.class.getDeclaredField("bWd"));
        } catch (Throwable th) {
            throw new IllegalStateException("Unable to lookup extension field offset");
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.a.s
    public final boolean f(aw awVar) {
        return awVar instanceof ac.d;
    }

    @Override // com.google.a.s
    public final x<l.f> an(Object obj) {
        return (x) ch.k(obj, bUl);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.a.s
    public final x<l.f> ao(Object obj) {
        x<l.f> an = an(obj);
        if (!an.bUC) {
            return an;
        }
        x<l.f> Gk = an.clone();
        ch.a(obj, bUl, Gk);
        return Gk;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.a.s
    public final void ap(Object obj) {
        an(obj).yK();
    }
}
