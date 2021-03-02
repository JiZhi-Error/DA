package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import java.util.Set;

public abstract class e<T, V, X, Y> implements f<T, V> {
    protected a iuq;
    public f<T, X> iuv = null;
    public d<T, Y> iuw = null;
    public f.b<T, V> iux = null;
    public int maxSize;

    /* access modifiers changed from: protected */
    public abstract Y A(T t, V v);

    /* access modifiers changed from: protected */
    public abstract T aSg();

    /* access modifiers changed from: protected */
    public abstract V bY(X x);

    /* access modifiers changed from: protected */
    public abstract X ca(V v);

    /* access modifiers changed from: protected */
    public f<T, X> aSh() {
        return new h(this.maxSize, new f.b<T, X>() {
            /* class com.tencent.mm.memory.a.a.a.e.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.tencent.mm.b.f$b<T, V> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.b.f.b
            public final void c(T t, X x, X x2) {
                AppMethodBeat.i(156513);
                if (e.this.iux != null) {
                    e.this.iux.c(t, e.this.bY(x), e.this.bY(x2));
                }
                AppMethodBeat.o(156513);
            }
        });
    }

    /* access modifiers changed from: protected */
    public d<T, Y> a(a aVar) {
        return null;
    }

    public e(int i2) {
        this.maxSize = i2;
        init();
    }

    public e(int i2, f.b<T, V> bVar) {
        this.iux = bVar;
        this.maxSize = 10;
        init();
    }

    public e(int i2, f.b<T, V> bVar, a aVar) {
        this.iux = bVar;
        this.maxSize = i2;
        this.iuq = aVar;
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.iuv = aSh();
        this.iuw = a(this.iuq);
    }

    @Override // com.tencent.mm.b.f
    public void x(T t, V v) {
        this.iuv.x(t, ca(v));
        if (this.iuw != null) {
            this.iuw.f(aSg(), t, A(t, v));
        }
    }

    @Override // com.tencent.mm.b.f
    public V remove(T t) {
        V bY = bY(this.iuv.remove(t));
        if (this.iuw != null) {
            this.iuw.E(aSg(), t);
        }
        return bY;
    }

    @Override // com.tencent.mm.b.f
    public V get(T t) {
        V bY = bY(this.iuv.get(t));
        if (this.iuw != null) {
            this.iuw.F(aSg(), t);
        }
        return bY;
    }

    @Override // com.tencent.mm.b.f
    public V put(T t, V v) {
        V bY = bY(this.iuv.put(t, ca(v)));
        if (this.iuw != null) {
            this.iuw.g(aSg(), t, A(t, v));
        }
        return bY;
    }

    @Override // com.tencent.mm.b.f
    public boolean check(T t) {
        boolean check = this.iuv.check(t);
        if (this.iuw != null) {
            this.iuw.C(aSg(), t);
        }
        return check;
    }

    @Override // com.tencent.mm.b.f
    public final void clear() {
        this.iuv.clear();
    }

    @Override // com.tencent.mm.b.f
    public V aT(T t) {
        V bY = bY(this.iuv.aT(t));
        if (this.iuw != null) {
            this.iuw.G(aSg(), t);
        }
        return bY;
    }

    @Override // com.tencent.mm.b.f
    public int maxSize() {
        int maxSize2 = this.iuv.maxSize();
        if (this.iuw != null) {
            this.iuw.maxSize();
        }
        return maxSize2;
    }

    @Override // com.tencent.mm.b.f
    public void trimToSize(int i2) {
        this.iuv.trimToSize(i2);
    }

    @Override // com.tencent.mm.b.f
    public int size() {
        int size = this.iuv.size();
        if (this.iuw != null) {
            this.iuw.size();
        }
        return size;
    }

    @Override // com.tencent.mm.b.f
    public int sizeOf(T t, V v) {
        return this.iuv.sizeOf(t, ca(v));
    }

    @Override // com.tencent.mm.b.f
    public final void a(final f.a<T, V> aVar) {
        this.iuv.a(new f.a<T, X>() {
            /* class com.tencent.mm.memory.a.a.a.e.AnonymousClass2 */
        });
    }

    @Override // com.tencent.mm.b.f
    public int hitCount() {
        int hitCount = this.iuv.hitCount();
        if (this.iuw != null) {
            this.iuw.hitCount();
        }
        return hitCount;
    }

    @Override // com.tencent.mm.b.f
    public int missCount() {
        int missCount = this.iuv.missCount();
        if (this.iuw != null) {
            this.iuw.missCount();
        }
        return missCount;
    }

    @Override // com.tencent.mm.b.f
    public int createCount() {
        int createCount = this.iuv.createCount();
        if (this.iuw != null) {
            this.iuw.createCount();
        }
        return createCount;
    }

    @Override // com.tencent.mm.b.f
    public int putCount() {
        int putCount = this.iuv.putCount();
        if (this.iuw != null) {
            this.iuw.putCount();
        }
        return putCount;
    }

    @Override // com.tencent.mm.b.f
    public int evictionCount() {
        int evictionCount = this.iuv.evictionCount();
        if (this.iuw != null) {
            this.iuw.evictionCount();
        }
        return evictionCount;
    }

    @Override // com.tencent.mm.b.f
    public boolean checkAndUpTime(T t) {
        boolean checkAndUpTime = this.iuv.checkAndUpTime(t);
        if (this.iuw != null) {
            this.iuw.H(aSg(), t);
        }
        return checkAndUpTime;
    }

    @Override // com.tencent.mm.b.f
    public Set<T> keySet() {
        return this.iuv.keySet();
    }
}
