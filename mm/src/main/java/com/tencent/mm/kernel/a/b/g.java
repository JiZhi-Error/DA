package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.a.a;
import com.tencent.mm.kernel.a.a.b;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.f;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g implements b, c<Object>, d<Object> {
    private Map<Class<?>, f<Object>> htf = new ConcurrentHashMap();
    private Class<?>[] htg;
    public volatile Class<?>[] hth;
    public Map<Class, Object> hti = new ConcurrentHashMap();
    private int htj = 0;
    private Queue<f.a> htk = new ConcurrentLinkedQueue();
    private ConcurrentHashMap<Object, a> htl = new ConcurrentHashMap<>();

    public g() {
        AppMethodBeat.i(158398);
        AppMethodBeat.o(158398);
    }

    public final void a(Class... clsArr) {
        AppMethodBeat.i(158399);
        this.htg = new Class[clsArr.length];
        System.arraycopy(clsArr, 0, this.htg, 0, clsArr.length);
        for (int i2 = 0; i2 < this.htg.length; i2++) {
            this.htf.put(this.htg[i2], new f<>(this.htg[i2], this, this));
        }
        AppMethodBeat.o(158399);
    }

    private boolean am(Class cls) {
        if (this.hth == null) {
            return true;
        }
        for (Class<?> cls2 : this.hth) {
            if (cls2 == cls) {
                return true;
            }
        }
        return false;
    }

    public final Map<f, List<a.C0364a>> aAW() {
        AppMethodBeat.i(158400);
        HashMap hashMap = new HashMap();
        for (f<Object> fVar : this.htf.values()) {
            List<a.C0364a> aAQ = fVar.aAQ();
            if (aAQ.size() > 0) {
                hashMap.put(fVar, aAQ);
            }
        }
        AppMethodBeat.o(158400);
        return hashMap;
    }

    public final <T> f<T> an(Class<T> cls) {
        AppMethodBeat.i(158401);
        f<T> fVar = (f<T>) this.htf.get(cls);
        AppMethodBeat.o(158401);
        return fVar;
    }

    public final void c(Class cls, boolean z) {
        AppMethodBeat.i(158402);
        int min = Math.min(ao(cls), this.htg.length - 1);
        if (min >= 0 && this.htj > min) {
            for (int i2 = min; i2 < this.htj; i2++) {
                an(this.htg[i2]).reset(z);
            }
            this.htj = min;
        }
        AppMethodBeat.o(158402);
    }

    @Override // com.tencent.mm.kernel.a.b.c
    public final void prepare() {
        int i2;
        AppMethodBeat.i(158403);
        j.i("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
        synchronized (this.htg) {
            try {
                if (this.htg.length > this.htj) {
                    i2 = this.htj;
                    this.htj++;
                } else {
                    i2 = -1;
                }
            } finally {
                AppMethodBeat.o(158403);
            }
        }
        if (i2 != -1) {
            an(this.htg[i2]).prepare();
        }
    }

    public final void aAX() {
        AppMethodBeat.i(158404);
        while (true) {
            synchronized (this.htg) {
                try {
                    if (this.htg.length <= this.htj) {
                        return;
                    }
                } finally {
                    AppMethodBeat.o(158404);
                }
            }
            prepare();
        }
    }

    private int ao(Class cls) {
        for (int i2 = 0; i2 < this.htg.length; i2++) {
            if (this.htg[i2] == cls) {
                return i2;
            }
        }
        return -1;
    }

    /* Return type fixed from 'com.tencent.mm.kernel.a.b.f$a' to match base method */
    @Override // com.tencent.mm.kernel.a.b.d, com.tencent.mm.kernel.a.b.c
    public final f.a<Object> aAJ() {
        f.a poll;
        AppMethodBeat.i(158405);
        synchronized (this.htk) {
            try {
                poll = this.htk.poll();
            } finally {
                AppMethodBeat.o(158405);
            }
        }
        return poll;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.kernel.a.b.f$a] */
    @Override // com.tencent.mm.kernel.a.b.c
    public final void a(f.a<Object> aVar) {
        AppMethodBeat.i(158406);
        Log.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", aVar, aVar.htb.hsF, aVar.htb.htn);
        an(aVar.htb.hsF).a(aVar);
        if (aVar.htb.htn != null) {
            an(aVar.htb.htn).bK(aVar);
        }
        AppMethodBeat.o(158406);
    }

    @Override // com.tencent.mm.kernel.a.b.d
    public final void b(f.a<Object> aVar) {
        AppMethodBeat.i(158407);
        synchronized (this.htk) {
            try {
                this.htk.offer(aVar);
            } catch (Throwable th) {
                AppMethodBeat.o(158407);
                throw th;
            }
        }
        Log.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", aVar, aVar.htb.hsF);
        AppMethodBeat.o(158407);
    }

    @Override // com.tencent.mm.kernel.a.a.b
    public final void a(Class cls, Object obj, Object obj2) {
        AppMethodBeat.i(158408);
        if (am(cls)) {
            f an = an(cls);
            if (an != null) {
                an.z(obj, obj2);
            }
            AppMethodBeat.o(158408);
            return;
        }
        j.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", cls);
        AppMethodBeat.o(158408);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        byte[] lock;

        private a() {
            AppMethodBeat.i(158397);
            this.lock = new byte[1];
            AppMethodBeat.o(158397);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final boolean aAY() {
            boolean z = false;
            synchronized (this.lock) {
                if (this.lock[0] == 2) {
                    z = true;
                }
            }
            return z;
        }
    }

    public final boolean bL(Object obj) {
        AppMethodBeat.i(158409);
        a aVar = this.htl.get(obj);
        if (aVar == null || !aVar.aAY()) {
            AppMethodBeat.o(158409);
            return false;
        }
        AppMethodBeat.o(158409);
        return true;
    }

    public final void bM(Object obj) {
        int i2 = 0;
        AppMethodBeat.i(158410);
        if (!this.htl.containsKey(obj)) {
            this.htl.putIfAbsent(obj, new a((byte) 0));
        }
        a aVar = this.htl.get(obj);
        synchronized (aVar.lock) {
            try {
                if (aVar.lock[0] != 2) {
                    if (aVar.lock[0] == 1) {
                        try {
                            aVar.lock.wait();
                        } catch (InterruptedException e2) {
                        }
                    } else {
                        aVar.lock[0] = 1;
                    }
                }
            } finally {
                AppMethodBeat.o(158410);
            }
        }
        if (aVar.aAY()) {
            j.i("MicroMsg.ParallelsManagement", "%s Has done. return.", obj);
            AppMethodBeat.o(158410);
            return;
        }
        j.d("MicroMsg.ParallelsManagement", "Make dependency on subject(%s), hashcode(%s)", obj, Integer.valueOf(obj.hashCode()));
        if (obj instanceof b) {
            a.start();
            ((b) obj).parallelsDependency();
            a.b aAI = a.aAI();
            if (aAI.mMap != null) {
                for (a.C0365a aVar2 : aAI.mMap.values()) {
                    for (Object obj2 : aVar2.hsG) {
                        if (an(aVar2.hsF).bE(obj2) == null) {
                            j.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", obj2, obj);
                            bM(obj2);
                        }
                        a(aVar2.hsF, obj, obj2);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Class<?>[] clsArr = this.htg;
        for (Class<?> cls : clsArr) {
            if (cls.isInstance(obj)) {
                arrayList.add(cls);
            }
        }
        Class[] clsArr2 = (Class[]) arrayList.toArray(new Class[0]);
        f.a aVar3 = null;
        f.a aVar4 = null;
        while (i2 < clsArr2.length) {
            Class cls2 = clsArr2[i2];
            Class cls3 = i2 < clsArr2.length - 1 ? clsArr2[i2 + 1] : null;
            f.a d2 = aVar3 != null ? aVar3 : d(cls2, obj);
            aVar3 = cls3 != null ? d(cls3, obj) : null;
            d2.hsZ = aVar4;
            d2.hta = aVar3;
            if (aVar4 != null) {
                d2.htb.htm = aVar4.htb.hsF;
            }
            if (aVar3 != null) {
                d2.htb.htn = aVar3.htb.hsF;
            }
            i2++;
            aVar4 = d2;
        }
        synchronized (aVar.lock) {
            try {
                if (aVar.lock[0] == 1) {
                    aVar.lock[0] = 2;
                    aVar.lock.notifyAll();
                }
            } finally {
                AppMethodBeat.o(158410);
            }
        }
    }

    private f.a d(Class cls, Object obj) {
        AppMethodBeat.i(158411);
        f an = an(cls);
        f.a aVar = (f.a) an.bE(obj);
        Log.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", cls, obj, an);
        if (aVar == null) {
            Object obj2 = this.hti.get(cls);
            if (obj2 == null) {
                obj2 = obj;
            }
            an.z(obj, obj2);
            aVar = (f.a) an.bE(obj);
        }
        AppMethodBeat.o(158411);
        return aVar;
    }
}
