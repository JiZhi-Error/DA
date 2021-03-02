package android.arch.b;

import android.arch.b.h;
import android.support.v7.f.a.a;
import android.support.v7.h.c;
import android.support.v7.h.d;
import android.support.v7.widget.RecyclerView;
import java.util.concurrent.Executor;

public final class a<T> {
    final android.support.v7.f.a.a<T> dA;
    Executor dB = android.arch.a.a.a.T();
    AbstractC0002a<T> dC;
    boolean dD;
    h<T> dE;
    h<T> dF;
    int dG;
    h.c dH = new h.c() {
        /* class android.arch.b.a.AnonymousClass1 */

        @Override // android.arch.b.h.c
        public final void f(int i2, int i3) {
            a.this.dz.f(i2, i3);
        }

        @Override // android.arch.b.h.c
        public final void g(int i2, int i3) {
            a.this.dz.c(i2, i3, null);
        }
    };
    final d dz;

    /* renamed from: android.arch.b.a$a  reason: collision with other inner class name */
    interface AbstractC0002a<T> {
    }

    public a(RecyclerView.a aVar, c.AbstractC0051c<T> cVar) {
        this.dz = new android.support.v7.h.a(aVar);
        this.dA = new a.C0050a(cVar).hy();
    }

    public final int getItemCount() {
        if (this.dE != null) {
            return this.dE.size();
        }
        if (this.dF == null) {
            return 0;
        }
        return this.dF.size();
    }
}
