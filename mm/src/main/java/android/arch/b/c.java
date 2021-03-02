package android.arch.b;

import android.arch.b.g;
import android.arch.b.h;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public final class c<K, V> extends h<V> {
    private final b<K, V> dP;
    private boolean dQ = false;
    private boolean dR = false;
    private int dS = 0;
    private int dT = 0;
    private g.a<V> dU = new g.a<V>() {
        /* class android.arch.b.c.AnonymousClass1 */
    };

    c(b<K, V> bVar, Executor executor, Executor executor2, h.a<V> aVar, h.d dVar, K k, int i2) {
        super(new j(), executor, executor2, aVar, dVar);
        this.dP = bVar;
        this.eG = -1;
        if (this.dP.cj.get()) {
            this.eM.set(true);
        } else {
            this.dP.a(this.ed.eS, this.ed.eR, this.dB, this.dU);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // android.arch.b.h
    public final void a(h<V> hVar, h.c cVar) {
        j<T> jVar = hVar.eF;
        int i2 = this.eF.fk - jVar.fk;
        int i3 = this.eF.fj - jVar.fj;
        int i4 = jVar.fg;
        int i5 = jVar.fe;
        if (jVar.isEmpty() || i2 < 0 || i3 < 0 || this.eF.fg != Math.max(i4 - i2, 0) || this.eF.fe != Math.max(i5 - i3, 0) || this.eF.fi != jVar.fi + i2 + i3) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        if (i2 != 0) {
            int min = Math.min(i4, i2);
            int i6 = i2 - min;
            int i7 = jVar.fi + jVar.fe;
            if (min != 0) {
                cVar.g(i7, min);
            }
            if (i6 != 0) {
                cVar.f(i7 + min, i6);
            }
        }
        if (i3 != 0) {
            int min2 = Math.min(i5, i3);
            int i8 = i3 - min2;
            if (min2 != 0) {
                cVar.g(i5, min2);
            }
            if (i8 != 0) {
                cVar.f(0, i8);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // android.arch.b.h
    public final boolean ao() {
        return true;
    }

    @Override // android.arch.b.h
    public final d<?, V> ap() {
        return this.dP;
    }

    @Override // android.arch.b.h
    public final Object aq() {
        return null;
    }
}
