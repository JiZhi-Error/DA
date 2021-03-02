package android.support.v7.f.a;

import android.support.v7.h.c;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class a<T> {
    public final c.AbstractC0051c<T> adg;
    private final Executor dB;
    public final Executor eE;

    a(Executor executor, Executor executor2, c.AbstractC0051c<T> cVar) {
        this.dB = executor;
        this.eE = executor2;
        this.adg = cVar;
    }

    /* renamed from: android.support.v7.f.a.a$a  reason: collision with other inner class name */
    public static final class C0050a<T> {
        private static final Object adh = new Object();
        private static Executor adi = null;
        private final c.AbstractC0051c<T> adg;
        private Executor dB;
        private Executor eE;

        public C0050a(c.AbstractC0051c<T> cVar) {
            this.adg = cVar;
        }

        public final a<T> hy() {
            if (this.eE == null) {
                synchronized (adh) {
                    if (adi == null) {
                        adi = Executors.newFixedThreadPool(2);
                    }
                }
                this.eE = adi;
            }
            return new a<>(this.dB, this.eE, this.adg);
        }
    }
}
