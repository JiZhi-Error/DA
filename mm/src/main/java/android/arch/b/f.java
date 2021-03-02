package android.arch.b;

import android.arch.b.d;
import android.arch.b.g;
import java.util.concurrent.Executor;

public abstract class f<Key, Value> extends b<Key, Value> {
    private final Object er = new Object();
    private Key es = null;
    private Key et = null;

    public static abstract class a<Key, Value> {
    }

    public abstract void a(c<Key> cVar, a<Key, Value> aVar);

    public static class c<Key> {
        public final int ex;
        public final boolean ey;

        public c(int i2, boolean z) {
            this.ex = i2;
            this.ey = z;
        }
    }

    static class b<Key, Value> extends a<Key, Value> {
        final d.c<Value> eu;
        private final f<Key, Value> ev;
        private final boolean ew;

        b(f<Key, Value> fVar, boolean z, g.a<Value> aVar) {
            this.eu = new d.c<>(fVar, aVar);
            this.ev = fVar;
            this.ew = z;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // android.arch.b.b
    public final void a(int i2, boolean z, Executor executor, g.a<Value> aVar) {
        b bVar = new b(this, z, aVar);
        a(new c<>(i2, z), bVar);
        d.c<Value> cVar = bVar.eu;
        synchronized (cVar.dZ) {
            cVar.ea = executor;
        }
    }
}
