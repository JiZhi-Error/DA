package android.arch.b;

import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class h<T> extends AbstractList<T> {
    final Executor dB;
    final Executor eE;
    final j<T> eF;
    int eG = 0;
    T eH = null;
    private boolean eI = false;
    private boolean eJ = false;
    private int eK = Integer.MAX_VALUE;
    private int eL = Integer.MIN_VALUE;
    final AtomicBoolean eM = new AtomicBoolean(false);
    private final ArrayList<WeakReference<c>> eN = new ArrayList<>();
    final d ed;
    final a<T> ef;

    public static abstract class a<T> {
    }

    public static abstract class c {
        public abstract void f(int i2, int i3);

        public abstract void g(int i2, int i3);
    }

    /* access modifiers changed from: package-private */
    public abstract void a(h<T> hVar, c cVar);

    /* access modifiers changed from: package-private */
    public abstract boolean ao();

    public abstract d<?, T> ap();

    public abstract Object aq();

    static /* synthetic */ h a(d dVar, Executor executor, Executor executor2, a aVar, d dVar2, Object obj) {
        return new c((b) dVar, executor, executor2, aVar, dVar2, obj, -1);
    }

    h(j<T> jVar, Executor executor, Executor executor2, a<T> aVar, d dVar) {
        this.eF = jVar;
        this.dB = executor;
        this.eE = executor2;
        this.ef = aVar;
        this.ed = dVar;
    }

    public static final class b<Key, Value> {
        final d<Key, Value> dY;
        Executor eO;
        Key eP;
        final d ed;
        a ef;
        Executor eg;

        public b(d<Key, Value> dVar, d dVar2) {
            if (dVar == null) {
                throw new IllegalArgumentException("DataSource may not be null");
            } else if (dVar2 == null) {
                throw new IllegalArgumentException("Config may not be null");
            } else {
                this.dY = dVar;
                this.ed = dVar2;
            }
        }
    }

    @Override // java.util.List, java.util.AbstractList
    public T get(int i2) {
        T t = this.eF.get(i2);
        if (t != null) {
            this.eH = t;
        }
        return t;
    }

    public int size() {
        return this.eF.size();
    }

    public boolean isImmutable() {
        return isDetached();
    }

    public final List<T> at() {
        return isImmutable() ? this : new l(this);
    }

    public boolean isDetached() {
        return this.eM.get();
    }

    public final void a(List<T> list, c cVar) {
        if (!(list == null || list == this)) {
            if (!list.isEmpty()) {
                a((h) ((h) list), cVar);
            } else if (!this.eF.isEmpty()) {
                cVar.f(0, this.eF.size());
            }
        }
        for (int size = this.eN.size() - 1; size >= 0; size--) {
            if (this.eN.get(size).get() == null) {
                this.eN.remove(size);
            }
        }
        this.eN.add(new WeakReference<>(cVar));
    }

    public final void a(c cVar) {
        for (int size = this.eN.size() - 1; size >= 0; size--) {
            c cVar2 = this.eN.get(size).get();
            if (cVar2 == null || cVar2 == cVar) {
                this.eN.remove(size);
            }
        }
    }

    public static class d {
        public final int eQ;
        public final boolean eR;
        public final int eS;
        public final int pageSize;

        /* synthetic */ d(int i2, int i3, boolean z, int i4, byte b2) {
            this(i2, i3, z, i4);
        }

        private d(int i2, int i3, boolean z, int i4) {
            this.pageSize = i2;
            this.eQ = i3;
            this.eR = z;
            this.eS = i4;
        }

        public static final class a {
            private int eT = -1;
            private int eU = -1;
            private int eV = -1;
            private boolean eW = true;

            public final a au() {
                this.eT = 60;
                return this;
            }

            public final a av() {
                this.eU = 30;
                return this;
            }

            public final a aw() {
                this.eW = false;
                return this;
            }

            public final a ax() {
                this.eV = 15;
                return this;
            }

            public final d ay() {
                if (this.eT <= 0) {
                    throw new IllegalArgumentException("Page size must be a positive number");
                }
                if (this.eU < 0) {
                    this.eU = this.eT;
                }
                if (this.eV < 0) {
                    this.eV = this.eT * 3;
                }
                if (this.eW || this.eU != 0) {
                    return new d(this.eT, this.eU, this.eW, this.eV, (byte) 0);
                }
                throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in the PagedList, so either placeholders must be enabled, or prefetch distance must be > 0.");
            }
        }
    }
}
