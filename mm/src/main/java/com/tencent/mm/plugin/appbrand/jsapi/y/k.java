package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class k {
    static int mqS;
    final List<bc> mqT;
    Runnable mqU;
    private o mqi;

    /* synthetic */ k(byte b2) {
        this();
    }

    static class a {
        static k mqW = new k((byte) 0);

        static {
            AppMethodBeat.i(137653);
            AppMethodBeat.o(137653);
        }
    }

    private k() {
        AppMethodBeat.i(137654);
        this.mqT = new LinkedList();
        mqS = i.mqN.bIE();
        this.mqU = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.y.k.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x004f, code lost:
                monitor-enter(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
                r0 = r7.mqV.mqT.isEmpty();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0058, code lost:
                monitor-exit(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
                if (r0 != false) goto L_0x0065;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
                com.tencent.mm.plugin.appbrand.ac.m.bZn().j(r7, (long) com.tencent.mm.plugin.appbrand.jsapi.y.k.mqS);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(137651);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
                r0.bEo();
                com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", r0.getName(), java.lang.Integer.valueOf(r2));
                r1 = r7.mqV.mqT;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 117
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.y.k.AnonymousClass1.run():void");
            }
        };
        this.mqi = new o((long) mqS, new o.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.y.k.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.utils.o.a
            public final boolean j(Object... objArr) {
                AppMethodBeat.i(137652);
                synchronized (k.this.mqT) {
                    try {
                        if (k.this.mqT.isEmpty()) {
                            return false;
                        }
                        k.this.mqU.run();
                        AppMethodBeat.o(137652);
                        return true;
                    } finally {
                        AppMethodBeat.o(137652);
                    }
                }
            }
        });
        AppMethodBeat.o(137654);
    }

    public final boolean a(bc bcVar, f fVar) {
        AppMethodBeat.i(193699);
        if (i.mqN.bIF()) {
            boolean b2 = b(bcVar, fVar);
            AppMethodBeat.o(193699);
            return b2;
        }
        boolean c2 = c(bcVar, fVar);
        AppMethodBeat.o(193699);
        return c2;
    }

    private static boolean b(bc bcVar, f fVar) {
        AppMethodBeat.i(193700);
        if (bcVar == null || fVar == null) {
            AppMethodBeat.o(193700);
            return false;
        } else if (!i.mqN.a(fVar, bcVar)) {
            AppMethodBeat.o(193700);
            return false;
        } else {
            Log.v("MicroMsg.SensorJsEventPublisher", "post direct event(event : %s).", bcVar.getName());
            bcVar.bEo();
            AppMethodBeat.o(193700);
            return true;
        }
    }

    private boolean c(bc bcVar, f fVar) {
        boolean isEmpty;
        AppMethodBeat.i(137655);
        if (bcVar == null || fVar == null) {
            AppMethodBeat.o(137655);
            return false;
        } else if (!i.mqN.a(fVar, bcVar)) {
            AppMethodBeat.o(137655);
            return false;
        } else {
            synchronized (this.mqT) {
                try {
                    isEmpty = this.mqT.isEmpty();
                    if (this.mqT.isEmpty()) {
                        this.mqT.add(bcVar);
                    } else if (this.mqT.get(0).equals(bcVar)) {
                        this.mqT.add(0, bcVar);
                        this.mqT.remove(1);
                    } else {
                        this.mqT.remove(bcVar);
                        this.mqT.add(bcVar);
                    }
                } finally {
                    AppMethodBeat.o(137655);
                }
            }
            if (isEmpty && !this.mqi.l(new Object[0])) {
                Log.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", bcVar.getName());
                m.bZn().j(this.mqU, (long) mqS);
            }
            return true;
        }
    }
}
