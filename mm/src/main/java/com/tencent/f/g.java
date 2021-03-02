package com.tencent.f;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.f.a;
import com.tencent.f.d;
import com.tencent.f.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class g {
    private static Executor RTb;

    public interface a {
        a a(a.C0134a aVar);

        void a(c cVar);
    }

    public interface b {
        void a(Thread thread, String str);

        boolean eCC();

        boolean eCD();
    }

    public interface c {
        void a(d.a aVar);

        void a(d.e eVar);

        void a(d.f fVar);
    }

    public static void a(Context context, a aVar) {
        AppMethodBeat.i(183142);
        aVar.a(new c() {
            /* class com.tencent.f.g.AnonymousClass1 */

            @Override // com.tencent.f.g.c
            public final void a(d.e eVar) {
                d.RSQ = eVar;
            }

            @Override // com.tencent.f.g.c
            public final void a(d.a aVar) {
                d.RSS = aVar;
            }

            @Override // com.tencent.f.g.c
            public final void a(d.f fVar) {
                d.RSR = fVar;
            }
        });
        a a2 = aVar.a(new a.C0134a());
        com.tencent.f.c.b.RTE = new com.tencent.f.b.a(context, a2);
        h.RUe = h.b(a2);
        h.a(a2);
        if (a2.RSw) {
            hmf();
        }
        AppMethodBeat.o(183142);
    }

    public static void shutdown() {
        AppMethodBeat.i(183143);
        h.RTc.hmg();
        com.tencent.f.c.b.RTE.onShutdown();
        if (h.RTc.hmh().RSw) {
            try {
                com.tencent.f.k.c.d(AsyncTask.class, "THREAD_POOL_EXECUTOR", RTb);
            } catch (Exception e2) {
                d.RSS.e("ThreadModuleBoot", e2.toString(), new Object[0]);
            }
            RTb = null;
        }
        AppMethodBeat.o(183143);
    }

    private static void hmf() {
        AppMethodBeat.i(183144);
        try {
            RTb = (Executor) com.tencent.f.k.c.l(AsyncTask.class, "THREAD_POOL_EXECUTOR");
            com.tencent.f.k.c.d(AsyncTask.class, "THREAD_POOL_EXECUTOR", new Executor() {
                /* class com.tencent.f.g.AnonymousClass2 */

                public final void execute(Runnable runnable) {
                    AppMethodBeat.i(183141);
                    h.RTc.aX(runnable);
                    AppMethodBeat.o(183141);
                }
            });
            AppMethodBeat.o(183144);
        } catch (Exception e2) {
            d.RSS.e("ThreadModuleBoot", e2.toString(), new Object[0]);
            AppMethodBeat.o(183144);
        }
    }
}
