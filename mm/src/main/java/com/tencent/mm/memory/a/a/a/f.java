package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.memory.a.a.a.b;
import com.tencent.mm.memory.a.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class f<T, V extends c<T>> implements d<T, V> {
    h<T, V> iuA;
    b<T, V> iuB = null;
    f.b<T, V> iuC;
    f.c<T, V> iuD;
    a iuf = null;

    /* access modifiers changed from: protected */
    public abstract T B(T t, T t2);

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.b.h<T, V extends com.tencent.mm.memory.a.a.a.c<T>> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.memory.a.a.a.d
    public final /* synthetic */ void f(Object obj, Object obj2, Object obj3) {
        c cVar = (c) obj3;
        if (a.iuj) {
            Log.i("MicroMsg.UsageLruMap", "update businessKey:%s key:%s size:%s maxSize:%s", obj, obj2, Util.getSizeKB((long) this.iuA.size()), Util.getSizeKB((long) this.iuA.maxSize()));
        }
        this.iuA.x(B(obj, obj2), cVar);
        this.iuB.cc(obj).x(obj2, cVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.memory.a.a.a.d
    public final /* synthetic */ Object g(Object obj, Object obj2, Object obj3) {
        c cVar = (c) obj3;
        if (a.iuj) {
            Log.i("MicroMsg.UsageLruMap", "put businessKey:%s key:%s size:%s maxSize:%s", obj, obj2, Util.getSizeKB((long) this.iuA.size()), Util.getSizeKB((long) this.iuA.maxSize()));
        }
        c cVar2 = (c) this.iuA.put(B(obj, obj2), cVar);
        return cVar2 == null ? this.iuB.cc(obj).put(obj2, cVar) : cVar2;
    }

    public f(a aVar, f.b<T, V> bVar, f.c<T, V> cVar) {
        this.iuf = aVar;
        this.iuC = bVar;
        this.iuD = cVar;
        this.iuA = new h<>(this.iuf.iuk, new f.b<T, V>() {
            /* class com.tencent.mm.memory.a.a.a.f.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.tencent.mm.b.f$b<T, V extends com.tencent.mm.memory.a.a.a.c<T>> */
            /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.tencent.mm.memory.a.a.a.b<T, V extends com.tencent.mm.memory.a.a.a.c<T>> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.b.f.b
            public final /* synthetic */ void c(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.i(156514);
                c cVar = (c) obj2;
                c cVar2 = (c) obj3;
                if (cVar != null) {
                    Object aSi = cVar.aSi();
                    Object aSj = cVar.aSj();
                    if (f.this.iuB.C(aSi, aSj)) {
                        if (a.iuj) {
                            Log.i("MicroMsg.UsageLruMap", "implMap RemoveCallback in extraLruMap businessKey:%s key:%s size:%s", aSi, aSj, Util.getSizeKB((long) f.this.iuA.size()));
                        }
                        AppMethodBeat.o(156514);
                        return;
                    }
                }
                if (f.this.iuC != null) {
                    Log.i("MicroMsg.UsageLruMap", "implMap RemoveCallback not in extraLruMap key:%s size:%s", obj, Util.getSizeKB((long) f.this.iuA.size()));
                    f.this.iuC.c(obj, cVar, cVar2);
                }
                AppMethodBeat.o(156514);
            }
        }, new f.c<T, V>() {
            /* class com.tencent.mm.memory.a.a.a.f.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.tencent.mm.b.f$c<T, V extends com.tencent.mm.memory.a.a.a.c<T>> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.b.f.c
            public final /* bridge */ /* synthetic */ int y(Object obj, Object obj2) {
                AppMethodBeat.i(156515);
                c cVar = (c) obj2;
                if (f.this.iuD != null) {
                    int y = f.this.iuD.y(obj, cVar);
                    AppMethodBeat.o(156515);
                    return y;
                }
                AppMethodBeat.o(156515);
                return 524288;
            }
        });
        this.iuB = new b<>(this.iuf, new b.a<T, V>() {
            /* class com.tencent.mm.memory.a.a.a.f.AnonymousClass3 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.tencent.mm.b.h<T, V extends com.tencent.mm.memory.a.a.a.c<T>> */
            /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.tencent.mm.b.h<T, V extends com.tencent.mm.memory.a.a.a.c<T>> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.memory.a.a.a.b.a
            public final /* synthetic */ void D(Object obj, Object obj2) {
                AppMethodBeat.i(156516);
                Object B = f.this.B(obj, obj2);
                if (!f.this.iuA.check(B)) {
                    f.this.iuA.remove(B);
                }
                AppMethodBeat.o(156516);
            }
        }, new b.AbstractC0441b<T, V>() {
            /* class com.tencent.mm.memory.a.a.a.f.AnonymousClass4 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.tencent.mm.b.f$c<T, V extends com.tencent.mm.memory.a.a.a.c<T>> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.memory.a.a.a.b.AbstractC0441b
            public final /* synthetic */ int e(Object obj, Object obj2, Object obj3) {
                AppMethodBeat.i(156517);
                c cVar = (c) obj3;
                if (f.this.iuD != null) {
                    int y = f.this.iuD.y(f.this.B(obj, obj2), cVar);
                    AppMethodBeat.o(156517);
                    return y;
                }
                AppMethodBeat.o(156517);
                return 524288;
            }
        });
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final boolean C(T t, T t2) {
        return this.iuA.check(B(t, t2)) || this.iuB.C(t, t2);
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final boolean H(T t, T t2) {
        return this.iuA.checkAndUpTime(B(t, t2)) || this.iuB.cc(t).checkAndUpTime(t2);
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final void trimToSize(int i2) {
        this.iuA.trimToSize(i2);
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final int maxSize() {
        return this.iuA.maxSize();
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final int size() {
        return this.iuA.size();
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final int hitCount() {
        return this.iuA.hitCount();
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final int missCount() {
        return this.iuA.missCount();
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final int createCount() {
        return this.iuA.createCount();
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final int putCount() {
        return this.iuA.putCount();
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final int evictionCount() {
        return this.iuA.evictionCount();
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final void aSq() {
        Log.i("MicroMsg.UsageLruMap", "growMaxSize %s and old %s  result %s", Double.valueOf(1.0d), Integer.valueOf(this.iuf.iuk), Integer.valueOf((int) (((double) this.iuf.iuk) * 2.0d)));
        this.iuA.setMaxSize((int) (((double) this.iuf.iuk) * 2.0d));
    }

    @Override // com.tencent.mm.memory.a.a.a.d
    public final void axJ() {
        Log.i("MicroMsg.UsageLruMap", "resetSize %s", Integer.valueOf(this.iuf.iuk));
        this.iuA.setMaxSize(this.iuf.iuk);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.memory.a.a.a.d
    public final /* synthetic */ Object G(Object obj, Object obj2) {
        V aT = this.iuA.aT(B(obj, obj2));
        return aT == null ? this.iuB.cc(obj).aT(obj2) : aT;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.memory.a.a.a.d
    public final /* synthetic */ Object F(Object obj, Object obj2) {
        c cVar = (c) this.iuA.get(B(obj, obj2));
        return cVar == null ? this.iuB.cc(obj).get(obj2) : cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.memory.a.a.a.d
    public final /* synthetic */ Object E(Object obj, Object obj2) {
        c cVar = (c) this.iuA.remove(B(obj, obj2));
        return cVar == null ? this.iuB.cc(obj).remove(obj2) : cVar;
    }
}
