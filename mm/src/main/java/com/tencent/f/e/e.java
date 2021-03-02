package com.tencent.f.e;

import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class e<P> {
    static g RTH = new c();
    static g RTI = new b();
    static g RTJ = new i();
    private static final a RTK = new a();
    P RTM;
    g RTN;
    volatile a RTO;
    a<Throwable, ?> RTP;
    volatile e RTQ;
    volatile e RTR;
    private volatile boolean RTS = false;
    private final Object lock = new Object();
    AtomicBoolean pCM = new AtomicBoolean(false);

    public static class a {
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(183299);
        eVar.hmp();
        AppMethodBeat.o(183299);
    }

    static {
        AppMethodBeat.i(183301);
        AppMethodBeat.o(183301);
    }

    public static <T> e<T> eD(T t) {
        AppMethodBeat.i(183290);
        e<T> eVar = new e<>(t);
        AppMethodBeat.o(183290);
        return eVar;
    }

    public static e<a> hmm() {
        AppMethodBeat.i(183291);
        e<a> eVar = new e<>(RTK);
        AppMethodBeat.o(183291);
        return eVar;
    }

    public static f<a> hmn() {
        AppMethodBeat.i(183292);
        f<a> fVar = new f<>(RTK);
        AppMethodBeat.o(183292);
        return fVar;
    }

    e() {
        AppMethodBeat.i(183293);
        AppMethodBeat.o(183293);
    }

    e(P p) {
        AppMethodBeat.i(183294);
        this.RTM = p;
        AppMethodBeat.o(183294);
    }

    public <R> e<R> a(a<P, R> aVar) {
        AppMethodBeat.i(183295);
        Objects.requireNonNull(aVar);
        e<R> eVar = new e<>();
        eVar.RTN = hmr();
        eVar.RTQ = null;
        this.RTR = eVar;
        this.RTO = aVar;
        this.pCM.compareAndSet(false, true);
        b(aVar);
        AppMethodBeat.o(183295);
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public final void b(final a aVar) {
        AppMethodBeat.i(183296);
        if (aVar == null) {
            hmp();
            AppMethodBeat.o(183296);
            return;
        }
        AnonymousClass1 r0 = new h() {
            /* class com.tencent.f.e.e.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                AppMethodBeat.i(183288);
                String obj = aVar.toString();
                AppMethodBeat.o(183288);
                return obj;
            }

            /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0092  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 156
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.f.e.e.AnonymousClass1.run():void");
            }
        };
        if (this.RTM != null) {
            if (this.RTN == null) {
                r0.run();
                AppMethodBeat.o(183296);
                return;
            }
            this.RTN.execute(r0);
        }
        AppMethodBeat.o(183296);
    }

    /* access modifiers changed from: package-private */
    public a<Throwable, ?> hmo() {
        return null;
    }

    private void hmp() {
        AppMethodBeat.i(183297);
        if (this.RTS) {
            synchronized (this.lock) {
                try {
                    if (this.RTS) {
                        this.lock.notifyAll();
                    }
                } finally {
                    AppMethodBeat.o(183297);
                }
            }
            return;
        }
        AppMethodBeat.o(183297);
    }

    public P take() {
        AppMethodBeat.i(183298);
        try {
            if (this.RTM == null) {
                synchronized (this.lock) {
                    try {
                        if (this.RTM == null) {
                            this.RTS = true;
                            this.lock.wait();
                            this.RTS = false;
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(183298);
                        throw th;
                    }
                }
            }
        } catch (InterruptedException e2) {
        }
        P p = this.RTM;
        AppMethodBeat.o(183298);
        return p;
    }

    public e<P> hmq() {
        this.RTN = RTJ;
        return this;
    }

    public g hmr() {
        return this.RTN;
    }

    static /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(183300);
        while (eVar != null) {
            eVar.hmp();
            eVar = eVar.RTR;
        }
        AppMethodBeat.o(183300);
    }
}
