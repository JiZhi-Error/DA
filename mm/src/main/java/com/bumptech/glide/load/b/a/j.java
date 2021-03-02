package com.bumptech.glide.load.b.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class j implements b {
    private final h<a, Object> aIk;
    private final b aIt;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> aIu;
    private final Map<Class<?>, a<?>> aIv;
    private int currentSize;
    private final int maxSize;

    public j() {
        AppMethodBeat.i(77099);
        this.aIk = new h<>();
        this.aIt = new b();
        this.aIu = new HashMap();
        this.aIv = new HashMap();
        this.maxSize = 4194304;
        AppMethodBeat.o(77099);
    }

    public j(int i2) {
        AppMethodBeat.i(77100);
        this.aIk = new h<>();
        this.aIt = new b();
        this.aIu = new HashMap();
        this.aIv = new HashMap();
        this.maxSize = i2;
        AppMethodBeat.o(77100);
    }

    @Override // com.bumptech.glide.load.b.a.b
    public final synchronized <T> void put(T t) {
        boolean z;
        AppMethodBeat.i(77101);
        Class<?> cls = t.getClass();
        a<T> q = q(cls);
        int U = q.U(t);
        int oY = U * q.oY();
        if (oY <= this.maxSize / 2) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(77101);
        } else {
            a d2 = this.aIt.d(U, cls);
            this.aIk.a(d2, t);
            NavigableMap<Integer, Integer> p = p(cls);
            Integer num = (Integer) p.get(Integer.valueOf(d2.size));
            p.put(Integer.valueOf(d2.size), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
            this.currentSize += oY;
            dj(this.maxSize);
            AppMethodBeat.o(77101);
        }
    }

    @Override // com.bumptech.glide.load.b.a.b
    public final synchronized <T> T o(Class<T> cls) {
        T t;
        AppMethodBeat.i(77102);
        t = (T) a(this.aIt.d(8, cls), cls);
        AppMethodBeat.o(77102);
        return t;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r0.intValue() > (r6 * 8)) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    @Override // com.bumptech.glide.load.b.a.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized <T> T a(int r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            r1 = 1
            r2 = 0
            monitor-enter(r5)
            r0 = 77103(0x12d2f, float:1.08044E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r0)     // Catch:{ all -> 0x0053 }
            java.util.NavigableMap r0 = r5.p(r7)     // Catch:{ all -> 0x0053 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = r0.ceilingKey(r3)     // Catch:{ all -> 0x0053 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x004a
            int r3 = r5.currentSize     // Catch:{ all -> 0x0053 }
            if (r3 == 0) goto L_0x0025
            int r3 = r5.maxSize     // Catch:{ all -> 0x0053 }
            int r4 = r5.currentSize     // Catch:{ all -> 0x0053 }
            int r3 = r3 / r4
            r4 = 2
            if (r3 < r4) goto L_0x0048
        L_0x0025:
            r3 = r1
        L_0x0026:
            if (r3 != 0) goto L_0x0030
            int r3 = r0.intValue()     // Catch:{ all -> 0x0053 }
            int r4 = r6 * 8
            if (r3 > r4) goto L_0x004a
        L_0x0030:
            if (r1 == 0) goto L_0x004c
            com.bumptech.glide.load.b.a.j$b r1 = r5.aIt     // Catch:{ all -> 0x0053 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0053 }
            com.bumptech.glide.load.b.a.j$a r0 = r1.d(r0, r7)     // Catch:{ all -> 0x0053 }
        L_0x003c:
            java.lang.Object r0 = r5.a(r0, r7)     // Catch:{ all -> 0x0053 }
            r1 = 77103(0x12d2f, float:1.08044E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)     // Catch:{ all -> 0x0053 }
            monitor-exit(r5)
            return r0
        L_0x0048:
            r3 = r2
            goto L_0x0026
        L_0x004a:
            r1 = r2
            goto L_0x0030
        L_0x004c:
            com.bumptech.glide.load.b.a.j$b r0 = r5.aIt
            com.bumptech.glide.load.b.a.j$a r0 = r0.d(r6, r7)
            goto L_0x003c
        L_0x0053:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.a.j.a(int, java.lang.Class):java.lang.Object");
    }

    private <T> T a(a aVar, Class<T> cls) {
        AppMethodBeat.i(77104);
        a<T> q = q(cls);
        T t = (T) a(aVar);
        if (t != null) {
            this.currentSize -= q.U(t) * q.oY();
            b(q.U(t), cls);
        }
        if (t == null) {
            if (Log.isLoggable(q.getTag(), 2)) {
                q.getTag();
                new StringBuilder("Allocated ").append(aVar.size).append(" bytes");
            }
            t = q.di(aVar.size);
        }
        AppMethodBeat.o(77104);
        return t;
    }

    private <T> T a(a aVar) {
        AppMethodBeat.i(77105);
        T t = (T) this.aIk.b(aVar);
        AppMethodBeat.o(77105);
        return t;
    }

    @Override // com.bumptech.glide.load.b.a.b
    public final synchronized void oZ() {
        AppMethodBeat.i(77106);
        dj(0);
        AppMethodBeat.o(77106);
    }

    @Override // com.bumptech.glide.load.b.a.b
    public final synchronized void trimMemory(int i2) {
        AppMethodBeat.i(77107);
        if (i2 >= 40) {
            oZ();
            AppMethodBeat.o(77107);
        } else {
            if (i2 >= 20 || i2 == 15) {
                dj(this.maxSize / 2);
            }
            AppMethodBeat.o(77107);
        }
    }

    private void dj(int i2) {
        AppMethodBeat.i(77108);
        while (this.currentSize > i2) {
            Object removeLast = this.aIk.removeLast();
            com.bumptech.glide.g.j.checkNotNull(removeLast, "Argument must not be null");
            a V = V(removeLast);
            this.currentSize -= V.U(removeLast) * V.oY();
            b(V.U(removeLast), removeLast.getClass());
            if (Log.isLoggable(V.getTag(), 2)) {
                V.getTag();
                new StringBuilder("evicted: ").append(V.U(removeLast));
            }
        }
        AppMethodBeat.o(77108);
    }

    private void b(int i2, Class<?> cls) {
        AppMethodBeat.i(77109);
        NavigableMap<Integer, Integer> p = p(cls);
        Integer num = (Integer) p.get(Integer.valueOf(i2));
        if (num == null) {
            NullPointerException nullPointerException = new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
            AppMethodBeat.o(77109);
            throw nullPointerException;
        } else if (num.intValue() == 1) {
            p.remove(Integer.valueOf(i2));
            AppMethodBeat.o(77109);
        } else {
            p.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
            AppMethodBeat.o(77109);
        }
    }

    private NavigableMap<Integer, Integer> p(Class<?> cls) {
        AppMethodBeat.i(77110);
        NavigableMap<Integer, Integer> navigableMap = this.aIu.get(cls);
        if (navigableMap == null) {
            navigableMap = new TreeMap<>();
            this.aIu.put(cls, navigableMap);
        }
        AppMethodBeat.o(77110);
        return navigableMap;
    }

    private <T> a<T> V(T t) {
        AppMethodBeat.i(77111);
        a<T> q = q(t.getClass());
        AppMethodBeat.o(77111);
        return q;
    }

    private <T> a<T> q(Class<T> cls) {
        AppMethodBeat.i(77112);
        i iVar = (a<T>) this.aIv.get(cls);
        if (iVar == null) {
            if (cls.equals(int[].class)) {
                iVar = new i();
            } else if (cls.equals(byte[].class)) {
                iVar = new g();
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                AppMethodBeat.o(77112);
                throw illegalArgumentException;
            }
            this.aIv.put(cls, iVar);
        }
        AppMethodBeat.o(77112);
        return iVar;
    }

    static final class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: package-private */
        public final a d(int i2, Class<?> cls) {
            AppMethodBeat.i(77097);
            a aVar = (a) pd();
            aVar.c(i2, cls);
            AppMethodBeat.o(77097);
            return aVar;
        }

        /* Return type fixed from 'com.bumptech.glide.load.b.a.m' to match base method */
        /* access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.b.a.d
        public final /* synthetic */ a pc() {
            AppMethodBeat.i(77098);
            a aVar = new a(this);
            AppMethodBeat.o(77098);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements m {
        private final b aIw;
        private Class<?> aIx;
        int size;

        a(b bVar) {
            this.aIw = bVar;
        }

        /* access modifiers changed from: package-private */
        public final void c(int i2, Class<?> cls) {
            this.size = i2;
            this.aIx = cls;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.size == aVar.size && this.aIx == aVar.aIx) {
                return true;
            }
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(77094);
            String str = "Key{size=" + this.size + "array=" + this.aIx + '}';
            AppMethodBeat.o(77094);
            return str;
        }

        @Override // com.bumptech.glide.load.b.a.m
        public final void pb() {
            AppMethodBeat.i(77095);
            this.aIw.a(this);
            AppMethodBeat.o(77095);
        }

        public final int hashCode() {
            AppMethodBeat.i(77096);
            int hashCode = (this.aIx != null ? this.aIx.hashCode() : 0) + (this.size * 31);
            AppMethodBeat.o(77096);
            return hashCode;
        }
    }
}
