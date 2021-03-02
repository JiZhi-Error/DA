package com.tencent.mm.vending.g;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.j.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import junit.framework.Assert;

public class e<_Var> implements c<_Var> {
    public volatile boolean QZR = false;
    volatile d QZS = d.Idle;
    boolean QZT = false;
    private Queue<a> QZU = new LinkedList();
    private volatile com.tencent.mm.vending.h.d QZV = this.QZW;
    private volatile com.tencent.mm.vending.h.d QZW = g.current();
    volatile boolean QZX;
    private volatile Object QZY;
    private volatile Object QZZ;
    a Raa;
    a Rab;
    private long Rac = -1;
    private boolean Rad = false;
    private b Rae = new b();
    private com.tencent.mm.vending.h.d Raf;
    private f.a Rag = new f.a() {
        /* class com.tencent.mm.vending.g.e.AnonymousClass1 */

        @Override // com.tencent.mm.vending.h.f.a
        public final void hdE() {
            AppMethodBeat.i(74855);
            f hdF = f.hdF();
            e eVar = e.this;
            Stack<c> stack = hdF.RaE.get();
            if (stack == null) {
                stack = new Stack<>();
                hdF.RaE.set(stack);
            }
            stack.push(eVar);
            AppMethodBeat.o(74855);
        }

        @Override // com.tencent.mm.vending.h.f.a
        public final void em(Object obj) {
            AppMethodBeat.i(74856);
            f.hdF().RaE.get().pop();
            synchronized (e.this) {
                try {
                    e.this.Raa = e.this.Rab;
                    e.this.Rab = null;
                    if (!e.this.QZX) {
                        e.this.el(obj);
                    }
                    if (e.this.QZT) {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
                    }
                    if (e.this.QZS == d.Interrupted) {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
                    } else if (e.this.QZS == d.Pausing) {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
                        AppMethodBeat.o(74856);
                    } else {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "last one resolved, dequeue next.", new Object[0]);
                        e.this.QZS = d.Resolved;
                        e.this.hdA();
                        e.this.hdD();
                        AppMethodBeat.o(74856);
                    }
                } finally {
                    AppMethodBeat.o(74856);
                }
            }
        }

        @Override // com.tencent.mm.vending.h.f.a
        public final void interrupt() {
            AppMethodBeat.i(74857);
            e.this.Dv(true);
            AppMethodBeat.o(74857);
        }
    };
    List<Pair<d.a, com.tencent.mm.vending.h.d>> Rah;
    private List<Pair<d.b, com.tencent.mm.vending.h.d>> Rai;
    private boolean Raj = false;
    boolean Rak = false;
    private boolean Ral = false;
    private Object Ram;
    Object Ran;
    private int mRetryCount = 0;
    f mSchedulerInvoker = new f(this.QZW, this.Rag);

    /* access modifiers changed from: package-private */
    public enum d {
        Idle,
        Resolved,
        Invoking,
        Pausing,
        Interrupted,
        AllDone;

        public static d valueOf(String str) {
            AppMethodBeat.i(177482);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(177482);
            return dVar;
        }

        static {
            AppMethodBeat.i(177483);
            AppMethodBeat.o(177483);
        }
    }

    public e() {
        AppMethodBeat.i(74826);
        AppMethodBeat.o(74826);
    }

    public c<_Var> boF(String str) {
        AppMethodBeat.i(74827);
        if (str == null) {
            Assert.assertNotNull("schedulerTypeString should not be null!", str);
            AppMethodBeat.o(74827);
        } else {
            this.QZV = g.boH(str);
            Assert.assertNotNull("mCurrentScheduler should not be null!", this.QZV);
            AppMethodBeat.o(74827);
        }
        return this;
    }

    @Override // com.tencent.mm.vending.g.c
    public c<_Var> b(com.tencent.mm.vending.h.d dVar) {
        AppMethodBeat.i(74828);
        if (dVar == null) {
            Assert.assertNotNull("scheduler should not be null!", dVar);
            AppMethodBeat.o(74828);
        } else {
            this.QZV = dVar;
            AppMethodBeat.o(74828);
        }
        return this;
    }

    @Override // com.tencent.mm.vending.g.c
    public c<_Var> b(com.tencent.mm.vending.e.b bVar) {
        AppMethodBeat.i(74829);
        Assert.assertNotNull("keeper should not be null!", bVar);
        bVar.keep(this);
        AppMethodBeat.o(74829);
        return this;
    }

    @Override // com.tencent.mm.vending.g.c
    public synchronized c<_Var> Oc(long j2) {
        this.Rac = j2;
        return this;
    }

    @Override // com.tencent.mm.vending.g.c
    public synchronized c<_Var> Du(boolean z) {
        this.Rad = z;
        return this;
    }

    public synchronized c<_Var> a(final c.a<_Var> aVar) {
        AppMethodBeat.i(74830);
        I(new Object[0]);
        a((com.tencent.mm.vending.c.a) new com.tencent.mm.vending.c.a<_Var, _Var>() {
            /* class com.tencent.mm.vending.g.e.AnonymousClass2 */

            @Override // com.tencent.mm.vending.c.a
            public final _Var call(_Var _var) {
                AppMethodBeat.i(74865);
                _Var _var2 = (_Var) aVar.call();
                AppMethodBeat.o(74865);
                return _var2;
            }
        }, true);
        AppMethodBeat.o(74830);
        return this;
    }

    public synchronized c<_Var> H(Object... objArr) {
        c<_Var> I;
        AppMethodBeat.i(74831);
        I = I(objArr);
        AppMethodBeat.o(74831);
        return I;
    }

    private c<_Var> I(Object... objArr) {
        AppMethodBeat.i(177484);
        if (this.QZS != d.Idle) {
            AppMethodBeat.o(177484);
        } else {
            this.QZS = d.Resolved;
            el(objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.J(objArr));
            hdD();
            AppMethodBeat.o(177484);
        }
        return this;
    }

    @Override // com.tencent.mm.vending.g.c
    public final void stop() {
        AppMethodBeat.i(258767);
        Dv(true);
        AppMethodBeat.o(258767);
    }

    @Override // com.tencent.mm.vending.g.c
    public final b hdx() {
        return this.Rae;
    }

    @Override // com.tencent.mm.vending.g.c
    public <_Ret> c<_Ret> f(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        AppMethodBeat.i(74834);
        c<_Ret> c2 = boF("Vending.UI").c(aVar);
        AppMethodBeat.o(74834);
        return c2;
    }

    @Override // com.tencent.mm.vending.g.c
    public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        AppMethodBeat.i(74835);
        c<_Ret> c2 = boF("Vending.LOGIC").c(aVar);
        AppMethodBeat.o(74835);
        return c2;
    }

    @Override // com.tencent.mm.vending.g.c
    public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        AppMethodBeat.i(74836);
        c<_Ret> c2 = boF("Vending.HEAVY_WORK").c(aVar);
        AppMethodBeat.o(74836);
        return c2;
    }

    private <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> aVar, boolean z) {
        AppMethodBeat.i(74837);
        hdz();
        this.QZU.add(new a(aVar, this.QZV, this.Rac, z));
        this.Rac = -1;
        if (this.QZS == d.Idle) {
            AppMethodBeat.o(74837);
        } else if (this.QZS != d.Resolved) {
            AppMethodBeat.o(74837);
        } else {
            hdD();
            AppMethodBeat.o(74837);
        }
        return this;
    }

    @Override // com.tencent.mm.vending.g.c
    public synchronized <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        c<_Ret> a2;
        AppMethodBeat.i(74838);
        a2 = a(aVar, this.Rad);
        AppMethodBeat.o(74838);
        return a2;
    }

    public static class c extends Error {
        public c(String str, Object... objArr) {
            super(String.format(str, objArr));
            AppMethodBeat.i(74804);
            AppMethodBeat.o(74804);
        }
    }

    private void hdz() {
        AppMethodBeat.i(177485);
        if (this.QZR) {
            c cVar = new c("This Pipeline(%s) has terminate and do not allow any next().", this);
            AppMethodBeat.o(177485);
            throw cVar;
        }
        AppMethodBeat.o(177485);
    }

    /* access modifiers changed from: package-private */
    public final void a(final Pair<d.a, com.tencent.mm.vending.h.d> pair, final Object obj) {
        AppMethodBeat.i(74840);
        com.tencent.mm.vending.h.d dVar = (com.tencent.mm.vending.h.d) pair.second;
        AnonymousClass3 r1 = new Runnable() {
            /* class com.tencent.mm.vending.g.e.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(74854);
                ((d.a) pair.first).cn(obj);
                AppMethodBeat.o(74854);
            }
        };
        if (dVar == null) {
            com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", this.QZW);
            AppMethodBeat.o(74840);
            return;
        }
        dVar.arrange(r1);
        AppMethodBeat.o(74840);
    }

    private void b(final Pair<d.b, com.tencent.mm.vending.h.d> pair, final Object obj) {
        AppMethodBeat.i(177486);
        final RuntimeException runtimeException = new RuntimeException("object is not right: ".concat(String.valueOf(obj)));
        new f((com.tencent.mm.vending.h.d) pair.second, null).a(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.vending.g.e.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r3) {
                AppMethodBeat.i(74853);
                Void buw = buw();
                AppMethodBeat.o(74853);
                return buw;
            }

            private Void buw() {
                AppMethodBeat.i(177476);
                try {
                    ((d.b) pair.first).bz(obj);
                    Void r0 = QZL;
                    AppMethodBeat.o(177476);
                    return r0;
                } catch (ClassCastException e2) {
                    if (runtimeException.getCause() == null) {
                        runtimeException.initCause(e2);
                    }
                    RuntimeException runtimeException = runtimeException;
                    AppMethodBeat.o(177476);
                    throw runtimeException;
                }
            }
        }, null, this.Rad);
        AppMethodBeat.o(177486);
    }

    @Override // com.tencent.mm.vending.g.c
    public final synchronized d<_Var> hdy() {
        this.QZR = true;
        return this;
    }

    @Override // com.tencent.mm.vending.g.d
    public final synchronized d<_Var> a(d.a aVar) {
        AppMethodBeat.i(74844);
        a(aVar, this.QZW);
        AppMethodBeat.o(74844);
        return this;
    }

    @Override // com.tencent.mm.vending.g.d
    public final synchronized d<_Var> a(com.tencent.mm.vending.h.d dVar, d.a aVar) {
        AppMethodBeat.i(74845);
        a(aVar, dVar);
        AppMethodBeat.o(74845);
        return this;
    }

    @Override // com.tencent.mm.vending.g.d
    public final synchronized d<_Var> a(d.b<_Var> bVar) {
        AppMethodBeat.i(74846);
        a(bVar, this.QZW);
        AppMethodBeat.o(74846);
        return this;
    }

    @Override // com.tencent.mm.vending.g.d
    public final synchronized d<_Var> a(com.tencent.mm.vending.h.d dVar, d.b<_Var> bVar) {
        AppMethodBeat.i(74847);
        a(bVar, dVar);
        AppMethodBeat.o(74847);
        return this;
    }

    public final synchronized void Dv(boolean z) {
        AppMethodBeat.i(177487);
        if (this.QZS == d.Interrupted || this.QZS == d.AllDone) {
            AppMethodBeat.o(177487);
        } else {
            if (z && this.QZU.size() > 0) {
                com.tencent.mm.vending.f.a.w("Vending.Pipeline", "Pipe is not finish and be interrupt! %s pipes did not run", Integer.valueOf(this.QZU.size()));
            }
            this.QZS = d.Interrupted;
            this.QZU.clear();
            el(null);
            if (this.Raf != null) {
                this.Raf.cancel();
            }
            AppMethodBeat.o(177487);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void hdA() {
        AppMethodBeat.i(201253);
        if (this.QZT) {
            this.mRetryCount++;
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", this.Raa.hsM.toString(), Integer.valueOf(this.mRetryCount));
            this.QZT = false;
            ((LinkedList) this.QZU).add(0, this.Raa);
            el(this.QZZ);
            AppMethodBeat.o(201253);
        } else {
            this.mRetryCount = 0;
            AppMethodBeat.o(201253);
        }
    }

    private synchronized Object hdB() {
        Object obj;
        AppMethodBeat.i(201254);
        obj = this.QZY;
        this.QZZ = this.QZY;
        this.QZY = null;
        this.QZX = false;
        com.tencent.mm.vending.f.a.d("Vending.Pipeline", "pop input(%s)", ek(obj));
        AppMethodBeat.o(201254);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final synchronized Object hdC() {
        return this.QZY;
    }

    static String ek(Object obj) {
        AppMethodBeat.i(201255);
        if (obj != null) {
            String valueOf = String.valueOf(obj.hashCode());
            AppMethodBeat.o(201255);
            return valueOf;
        }
        AppMethodBeat.o(201255);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void el(Object obj) {
        AppMethodBeat.i(201256);
        this.QZY = obj;
        this.QZX = true;
        com.tencent.mm.vending.f.a.d("Vending.Pipeline", "set input(%s)", ek(obj));
        AppMethodBeat.o(201256);
    }

    /* access modifiers changed from: package-private */
    public final void hdD() {
        AppMethodBeat.i(201257);
        if (this.QZS != d.Resolved) {
            AppMethodBeat.o(201257);
            return;
        }
        this.QZS = d.Invoking;
        a peek = this.QZU.peek();
        if (peek == null) {
            if (this.QZR) {
                this.QZS = d.AllDone;
                this.Ram = hdB();
                this.Raj = true;
                if (this.Rai != null) {
                    for (Pair<d.b, com.tencent.mm.vending.h.d> pair : this.Rai) {
                        b(pair, this.Ram);
                    }
                    AppMethodBeat.o(201257);
                    return;
                }
            } else {
                this.QZS = d.Resolved;
            }
            AppMethodBeat.o(201257);
            return;
        }
        final com.tencent.mm.vending.c.a aVar = peek.hsM;
        com.tencent.mm.vending.h.d dVar = peek.mScheduler;
        long j2 = peek.mInterval;
        final boolean z = peek.Rav;
        if (this.QZS == d.Pausing) {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeueFunctionAndInvoke and waiting resume() call", new Object[0]);
            AppMethodBeat.o(201257);
            return;
        }
        this.Rab = this.QZU.poll();
        this.mSchedulerInvoker.c(dVar);
        final Object hdB = hdB();
        if (j2 < 0) {
            this.mSchedulerInvoker.a(aVar, hdB, z);
            AppMethodBeat.o(201257);
            return;
        }
        this.Raf = g.current();
        this.Raf.arrangeInterval(new Runnable() {
            /* class com.tencent.mm.vending.g.e.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(74862);
                e.this.mSchedulerInvoker.a(aVar, hdB, z);
                AppMethodBeat.o(74862);
            }
        }, j2);
        AppMethodBeat.o(201257);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public boolean Rav;
        public com.tencent.mm.vending.c.a hsM;
        public long mInterval;
        public com.tencent.mm.vending.h.d mScheduler;

        public a(com.tencent.mm.vending.c.a aVar, com.tencent.mm.vending.h.d dVar, long j2, boolean z) {
            this.hsM = aVar;
            this.mScheduler = dVar;
            this.mInterval = j2;
            this.Rav = z;
        }
    }

    class b implements b {
        b() {
        }

        @Override // com.tencent.mm.vending.g.b
        public final void ej(Object obj) {
            AppMethodBeat.i(177477);
            synchronized (e.this) {
                try {
                    if (e.this.QZS == d.Interrupted) {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
                    } else if (e.a(e.this) || e.this.QZS == d.Pausing) {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", e.this);
                        e.this.Dv(false);
                        e.this.Rak = true;
                        e.this.Ran = obj;
                        if (e.this.Rah != null) {
                            for (Pair<d.a, com.tencent.mm.vending.h.d> pair : e.this.Rah) {
                                e.this.a(pair, obj);
                            }
                        }
                        AppMethodBeat.o(177477);
                    } else {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
                        AppMethodBeat.o(177477);
                    }
                } finally {
                    AppMethodBeat.o(177477);
                }
            }
        }

        @Override // com.tencent.mm.vending.g.b
        public final void hdw() {
            AppMethodBeat.i(177478);
            synchronized (e.this) {
                try {
                    synchronized (e.this) {
                        try {
                            if (e.this.QZS == d.Interrupted || e.this.QZS == d.Idle) {
                                com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", e.this.QZS);
                            } else if (!e.a(e.this)) {
                                com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", e.this);
                            } else if (!e.b(e.this)) {
                                com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", e.this);
                            } else {
                                e.this.QZS = d.Pausing;
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(177478);
                            throw th;
                        }
                    }
                } finally {
                    AppMethodBeat.o(177478);
                }
            }
        }

        @Override // com.tencent.mm.vending.g.b
        public final void G(Object... objArr) {
            Object J;
            AppMethodBeat.i(177479);
            synchronized (e.this) {
                try {
                    if (e.this.QZS != d.Pausing) {
                        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", e.this.QZS);
                        return;
                    }
                    e eVar = e.this;
                    if (objArr.length == 0) {
                        J = null;
                    } else if (objArr.length == 1) {
                        J = objArr[0];
                    } else {
                        J = k.J(objArr);
                    }
                    eVar.el(J);
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole(%s).", e.this, e.ek(e.this.hdC()));
                    resume();
                    AppMethodBeat.o(177479);
                } finally {
                    AppMethodBeat.o(177479);
                }
            }
        }

        @Override // com.tencent.mm.vending.g.b
        public final void resume() {
            AppMethodBeat.i(177480);
            synchronized (e.this) {
                try {
                    if (e.this.QZS != d.Pausing) {
                        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", e.this);
                        return;
                    }
                    if (!e.a(e.this)) {
                        e.this.QZS = d.Resolved;
                    } else {
                        e.this.QZS = d.Invoking;
                    }
                    e.this.hdA();
                    if (!e.b(e.this)) {
                        e.this.hdD();
                    }
                    AppMethodBeat.o(177480);
                } finally {
                    AppMethodBeat.o(177480);
                }
            }
        }
    }

    @Override // com.tencent.mm.vending.e.a
    public void dead() {
        AppMethodBeat.i(74833);
        Dv(true);
        AppMethodBeat.o(74833);
    }

    private void a(d.a aVar, com.tencent.mm.vending.h.d dVar) {
        AppMethodBeat.i(74842);
        this.QZR = true;
        if (this.Rah == null) {
            this.Rah = new LinkedList();
        }
        Pair<d.a, com.tencent.mm.vending.h.d> pair = new Pair<>(aVar, dVar);
        if (this.Rak) {
            a(pair, this.Ran);
            AppMethodBeat.o(74842);
            return;
        }
        this.Rah.add(pair);
        AppMethodBeat.o(74842);
    }

    private void a(d.b bVar, com.tencent.mm.vending.h.d dVar) {
        AppMethodBeat.i(74843);
        this.QZR = true;
        hdD();
        if (this.Rai == null) {
            this.Rai = new LinkedList();
        }
        Pair<d.b, com.tencent.mm.vending.h.d> pair = new Pair<>(bVar, dVar);
        if (this.Raj) {
            b(pair, this.Ram);
            AppMethodBeat.o(74843);
            return;
        }
        this.Rai.add(pair);
        AppMethodBeat.o(74843);
    }

    static /* synthetic */ boolean a(e eVar) {
        return eVar.Rab != null;
    }

    static /* synthetic */ boolean b(e eVar) {
        AppMethodBeat.i(201258);
        if (eVar.Rae == g.hdx()) {
            AppMethodBeat.o(201258);
            return true;
        }
        AppMethodBeat.o(201258);
        return false;
    }
}
