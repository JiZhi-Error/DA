package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.a.a;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class f<T> extends com.tencent.mm.kernel.a.a.a<T> implements c<T> {
    private c<T> hsN;
    private d<T> hsT;
    public Class hsU;
    private volatile boolean hsV = false;

    public f(Class cls, d<T> dVar, c cVar) {
        this.hsU = cls;
        this.hsT = dVar;
        this.hsN = cVar;
    }

    @Override // com.tencent.mm.kernel.a.a.a
    public final a.C0364a<T> bD(T t) {
        AppMethodBeat.i(158389);
        if (!this.hsy.containsKey(t)) {
            this.hsy.putIfAbsent(t, new a(t, this.hsU, this.hsN, (byte) 0));
        }
        a.C0364a<T> aVar = (a.C0364a) this.hsy.get(t);
        AppMethodBeat.o(158389);
        return aVar;
    }

    public final a<T> bJ(T t) {
        AppMethodBeat.i(158390);
        a<T> aVar = (a) this.hsy.get(t);
        AppMethodBeat.o(158390);
        return aVar;
    }

    @Override // com.tencent.mm.kernel.a.a.a
    public final void reset(boolean z) {
        AppMethodBeat.i(158391);
        for (a.C0364a aVar : this.hsy.values()) {
            a aVar2 = (a) aVar;
            if (z) {
                aVar2.hsC = false;
            }
            synchronized (aVar2) {
                try {
                    aVar2.hsW = aVar2.aAE();
                    aVar2.hsY = false;
                } catch (Throwable th) {
                    AppMethodBeat.o(158391);
                    throw th;
                }
            }
        }
        AppMethodBeat.o(158391);
    }

    @Override // com.tencent.mm.kernel.a.b.c
    public final void prepare() {
        AppMethodBeat.i(158392);
        Log.i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies for type %s", this.hsU);
        Assert.assertNotNull(this.hsT);
        this.hsV = true;
        for (a.C0364a aVar : this.hsy.values()) {
            if (aVar.aAF()) {
                a<T> aVar2 = (a) aVar;
                Log.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s", aVar2);
                if (aVar2.aAS()) {
                    this.hsT.b(aVar2);
                }
                Log.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s done", aVar2);
            }
        }
        Log.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare %s done", this.hsU);
        AppMethodBeat.o(158392);
    }

    @Override // com.tencent.mm.kernel.a.b.c
    public final a<T> aAJ() {
        AppMethodBeat.i(158393);
        a<T> aAJ = this.hsT.aAJ();
        AppMethodBeat.o(158393);
        return aAJ;
    }

    @Override // com.tencent.mm.kernel.a.b.c
    public final void a(a<T> aVar) {
        AppMethodBeat.i(158394);
        HashSet<a.C0364a> aAC = aVar.aAC();
        if (aAC != null) {
            Iterator<a.C0364a> it = aAC.iterator();
            while (it.hasNext()) {
                a<T> aVar2 = (a) it.next();
                if (aVar2.aAV()) {
                    this.hsT.b(aVar2);
                }
            }
        }
        AppMethodBeat.o(158394);
    }

    public final void bK(Object obj) {
        AppMethodBeat.i(158395);
        a<T> aVar = (a) this.hsy.get(obj);
        if (aVar.hsB != ((a) obj).hsB) {
            Log.e("MMSkeleton.ParallelsDependencies", "not same!!!! %s, %s, %s, %s", aVar, aVar.hsB, obj, this.hsy.get(obj));
        }
        if (this.hsV && aVar.aAS()) {
            this.hsT.b(aVar);
        }
        AppMethodBeat.o(158395);
    }

    public final List<a.C0364a> aAQ() {
        AppMethodBeat.i(158396);
        ArrayList arrayList = new ArrayList(1);
        for (a.C0364a aVar : this.hsy.values()) {
            if (!((a) aVar).hsC) {
                Object[] objArr = new Object[4];
                objArr[0] = aVar;
                objArr[1] = Integer.valueOf(((a) aVar).hsW);
                objArr[2] = ((a) aVar).hsZ;
                objArr[3] = ((a) aVar).hsZ != null ? Boolean.valueOf(((a) aVar).hsZ.hsC) : "";
                Log.e("MMSkeleton.ParallelsDependencies", "ParallelsDependencies node(%s) not consumed!!!! %s, %s, %s", objArr);
                arrayList.add(aVar);
            }
        }
        AppMethodBeat.o(158396);
        return arrayList;
    }

    public static class a<T> extends a.C0364a<T> {
        volatile int hsW;
        private boolean hsX;
        volatile boolean hsY;
        public volatile a hsZ;
        public volatile a hta;
        public h htb;
        private c htc;
        public b htd;

        /* synthetic */ a(Object obj, Class cls, c cVar, byte b2) {
            this(obj, cls, cVar);
        }

        private a(T t, Class cls, c cVar) {
            super(t);
            AppMethodBeat.i(158380);
            this.hsW = 0;
            this.hsX = false;
            this.hsY = false;
            this.htb = new h();
            this.htd = new b();
            this.htb.hsF = cls;
            this.htc = cVar;
            AppMethodBeat.o(158380);
        }

        @Override // com.tencent.mm.kernel.a.a.a.C0364a
        public final void a(a.C0364a aVar) {
            AppMethodBeat.i(158381);
            super.a(aVar);
            synchronized (this) {
                try {
                    this.hsW++;
                } finally {
                    AppMethodBeat.o(158381);
                }
            }
        }

        private boolean aAR() {
            return this.hsW == 0 && (this.hsZ == null || this.hsZ.hsC);
        }

        public final synchronized boolean aAS() {
            boolean z = false;
            synchronized (this) {
                AppMethodBeat.i(158383);
                Object[] objArr = new Object[7];
                objArr[0] = this.hsB;
                objArr[1] = this.htb.hsF;
                objArr[2] = Boolean.valueOf(this.hsY);
                objArr[3] = Integer.valueOf(this.hsW);
                objArr[4] = this.hsZ;
                objArr[5] = this.hsZ != null ? Boolean.valueOf(this.hsZ.hsC) : "";
                objArr[6] = this.htb.htm;
                Log.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies checkIfResolvedAndSwallowIt for %s with type %s mProvided %s, %s, %s, %s, %s", objArr);
                if (this.hsY) {
                    AppMethodBeat.o(158383);
                } else if (aAR()) {
                    Log.i("MMSkeleton.ParallelsDependencies", "checkIfResolvedAndSwallowIt node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.hsC), this.htb.hsF);
                    this.hsY = true;
                    notify();
                    AppMethodBeat.o(158383);
                    z = true;
                } else {
                    AppMethodBeat.o(158383);
                }
            }
            return z;
        }

        private synchronized boolean aAT() {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.i(158384);
                Object[] objArr = new Object[7];
                objArr[0] = this.hsB;
                objArr[1] = this.htb.hsF;
                objArr[2] = Boolean.valueOf(this.hsY);
                objArr[3] = Integer.valueOf(this.hsW);
                objArr[4] = this.hsZ;
                objArr[5] = this.hsZ != null ? Boolean.valueOf(this.hsZ.hsC) : "";
                objArr[6] = this.htb.htm;
                Log.i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies checkIfResolved for %s with type %s mProvided %s, %s, %s, %s, %s", objArr);
                if (this.hsY) {
                    AppMethodBeat.o(158384);
                } else {
                    z = aAR();
                    AppMethodBeat.o(158384);
                }
            }
            return z;
        }

        private synchronized void aAU() {
            AppMethodBeat.i(158385);
            try {
                if (this.hsY) {
                    Log.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.hsC), this.htb.hsF);
                    AppMethodBeat.o(158385);
                } else {
                    Log.i("MMSkeleton.ParallelsDependencies", "waiting resolved");
                    Log.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s", this, Boolean.valueOf(this.hsC), this.htb.hsF);
                    wait();
                    Log.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s done", this, Boolean.valueOf(this.hsC), this.htb.hsF);
                    AppMethodBeat.o(158385);
                }
            } catch (InterruptedException e2) {
                Log.printErrStackTrace("MMSkeleton.ParallelsDependencies", e2, "", new Object[0]);
                AppMethodBeat.o(158385);
            }
        }

        public final synchronized boolean aAV() {
            boolean aAS;
            AppMethodBeat.i(158386);
            this.hsW--;
            aAS = aAS();
            AppMethodBeat.o(158386);
            return aAS;
        }

        @Override // com.tencent.mm.kernel.a.a.a.C0364a
        public final String toString() {
            AppMethodBeat.i(158387);
            String str = super.toString() + " - with type " + this.htb.hsF;
            AppMethodBeat.o(158387);
            return str;
        }

        public final void a(com.tencent.mm.vending.c.a aVar) {
            boolean z;
            AppMethodBeat.i(158382);
            if (!this.hsC) {
                if (!aAT()) {
                    HashSet<a.C0364a> aAD = aAD();
                    Assert.assertNotNull(aAD);
                    Iterator<a.C0364a> it = aAD.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        a.C0364a next = it.next();
                        if (!((a) next).hsC) {
                            Log.i("MMSkeleton.ParallelsDependencies", "ParallelsNode(%s) found it's depending node(%s) not consumed.", this, next);
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        aAU();
                    }
                }
                this.htd.hte.hin();
                if (!this.hsC) {
                    j.i("MMSkeleton.ParallelsDependencies", "Consume node(%s) on phase(%s) may after waiting resolved.", this, this.htb.hsF);
                    aVar.call(this);
                    this.hsC = true;
                }
                this.htd.hte.done();
            }
            AppMethodBeat.o(158382);
        }
    }

    public static class b {
        public com.tencent.mm.co.b hte = new com.tencent.mm.co.b();

        public b() {
            AppMethodBeat.i(158388);
            AppMethodBeat.o(158388);
        }
    }
}
