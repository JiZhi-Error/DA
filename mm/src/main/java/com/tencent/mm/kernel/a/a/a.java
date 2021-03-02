package com.tencent.mm.kernel.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class a<T> {
    protected final ConcurrentHashMap<T, C0364a<T>> hsy = new ConcurrentHashMap<>();

    public a() {
        AppMethodBeat.i(158345);
        AppMethodBeat.o(158345);
    }

    /* access modifiers changed from: protected */
    public C0364a<T> bD(T t) {
        AppMethodBeat.i(158346);
        if (!this.hsy.containsKey(t)) {
            this.hsy.putIfAbsent(t, new C0364a<>(t));
        }
        C0364a<T> aVar = this.hsy.get(t);
        AppMethodBeat.o(158346);
        return aVar;
    }

    public final C0364a<T> bE(T t) {
        AppMethodBeat.i(158347);
        C0364a<T> aVar = this.hsy.get(t);
        AppMethodBeat.o(158347);
        return aVar;
    }

    public final boolean bF(T t) {
        AppMethodBeat.i(158348);
        C0364a<T> aVar = this.hsy.get(t);
        if (aVar == null || (!aVar.aAF() && !aVar.aAH())) {
            AppMethodBeat.o(158348);
            return false;
        }
        AppMethodBeat.o(158348);
        return true;
    }

    private static void bG(T t) {
        AppMethodBeat.i(158349);
        Assert.assertNotNull("Found a null object, maybe your component isn't installedor registered.", t);
        Assert.assertFalse("Found a dummy object, maybe your component isn't installed or registered.", f.bx(t));
        AppMethodBeat.o(158349);
    }

    public final void z(T t, T t2) {
        AppMethodBeat.i(158350);
        Object[] objArr = {t, t2};
        bG(t);
        bG(t2);
        if (t == t2) {
            bD(t).aAG();
            AppMethodBeat.o(158350);
            return;
        }
        bD(t).a(bD(t2));
        AppMethodBeat.o(158350);
    }

    public void reset(boolean z) {
        AppMethodBeat.i(158351);
        for (Map.Entry<T, C0364a<T>> entry : this.hsy.entrySet()) {
            entry.getValue().hsC = false;
        }
        AppMethodBeat.o(158351);
    }

    /* renamed from: com.tencent.mm.kernel.a.a.a$a  reason: collision with other inner class name */
    public static class C0364a<T> {
        private HashSet<C0364a> hsA;
        public T hsB;
        public volatile boolean hsC = false;
        private boolean hsD = true;
        private HashSet<C0364a> hsz;

        protected C0364a(T t) {
            AppMethodBeat.i(176013);
            Assert.assertNotNull("Subject should not be null!", t);
            this.hsB = t;
            AppMethodBeat.o(176013);
        }

        public final synchronized HashSet<C0364a> aAC() {
            HashSet<C0364a> hashSet;
            AppMethodBeat.i(158334);
            if (this.hsA == null) {
                hashSet = null;
                AppMethodBeat.o(158334);
            } else {
                hashSet = new HashSet<>(this.hsA);
                AppMethodBeat.o(158334);
            }
            return hashSet;
        }

        public final synchronized HashSet<C0364a> aAD() {
            HashSet<C0364a> hashSet;
            AppMethodBeat.i(158335);
            if (this.hsz == null) {
                hashSet = null;
                AppMethodBeat.o(158335);
            } else {
                hashSet = new HashSet<>(this.hsz);
                AppMethodBeat.o(158335);
            }
            return hashSet;
        }

        public final synchronized int aAE() {
            int size;
            AppMethodBeat.i(158336);
            if (this.hsz == null) {
                size = 0;
                AppMethodBeat.o(158336);
            } else {
                size = this.hsz.size();
                AppMethodBeat.o(158336);
            }
            return size;
        }

        public final synchronized boolean aAF() {
            return this.hsD;
        }

        public final synchronized void aAG() {
            AppMethodBeat.i(158337);
            if (this.hsz == null || this.hsz.size() == 0) {
                this.hsD = true;
            }
            AppMethodBeat.o(158337);
        }

        public final synchronized boolean aAH() {
            boolean z;
            AppMethodBeat.i(158338);
            if (this.hsz == null || this.hsz.size() <= 0) {
                z = false;
                AppMethodBeat.o(158338);
            } else {
                z = true;
                AppMethodBeat.o(158338);
            }
            return z;
        }

        public String toString() {
            AppMethodBeat.i(158339);
            String str = "Ref-" + this.hsB.toString();
            AppMethodBeat.o(158339);
            return str;
        }

        public void a(C0364a aVar) {
            AppMethodBeat.i(158340);
            b(aVar);
            aVar.c(this);
            AppMethodBeat.o(158340);
        }

        private synchronized void b(C0364a aVar) {
            AppMethodBeat.i(158341);
            this.hsD = false;
            if (this.hsz == null) {
                this.hsz = new HashSet<>(4);
            }
            this.hsz.add(aVar);
            AppMethodBeat.o(158341);
        }

        private synchronized void c(C0364a aVar) {
            AppMethodBeat.i(158342);
            if (this.hsA == null) {
                this.hsA = new HashSet<>(4);
            }
            this.hsA.add(aVar);
            AppMethodBeat.o(158342);
        }

        public int hashCode() {
            AppMethodBeat.i(158343);
            int hashCode = this.hsB.hashCode();
            AppMethodBeat.o(158343);
            return hashCode;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(158344);
            if (obj instanceof C0364a) {
                boolean equals = this.hsB.equals(((C0364a) obj).hsB);
                AppMethodBeat.o(158344);
                return equals;
            }
            boolean equals2 = this.hsB.equals(obj);
            AppMethodBeat.o(158344);
            return equals2;
        }
    }
}
