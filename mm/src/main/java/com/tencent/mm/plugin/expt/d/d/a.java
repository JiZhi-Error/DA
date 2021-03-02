package com.tencent.mm.plugin.expt.d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.b.g;

public final class a {
    public ThreadPoolExecutor sxy = b.cMK();
    b syd;

    public a(b bVar) {
        AppMethodBeat.i(220333);
        this.syd = bVar;
        AppMethodBeat.o(220333);
    }

    public final void aoo(final String str) {
        AppMethodBeat.i(220334);
        if (!b.cML()) {
            AppMethodBeat.o(220334);
        } else if (g.eP(str)) {
            Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle data or sessionPageID isEmpty!");
            AppMethodBeat.o(220334);
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            this.sxy.execute(new Runnable() {
                /* class com.tencent.mm.plugin.expt.d.d.a.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(220329);
                    List<com.tencent.mm.plugin.expt.d.e.a.b> cMU = com.tencent.mm.plugin.expt.d.b.b.cMS().cMU();
                    if (cMU.size() <= 0) {
                        AppMethodBeat.o(220329);
                        return;
                    }
                    for (com.tencent.mm.plugin.expt.d.e.a.b bVar : cMU) {
                        if (bVar.syj == 5 && a.this.syd != null) {
                            a.this.syd.a(currentTimeMillis, bVar, str);
                        }
                    }
                    AppMethodBeat.o(220329);
                }
            });
            AppMethodBeat.o(220334);
        }
    }

    public final void aop(final String str) {
        AppMethodBeat.i(220335);
        if (!b.cML()) {
            AppMethodBeat.o(220335);
        } else if (g.eP(str)) {
            Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageMerge data isEmpty!");
            AppMethodBeat.o(220335);
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            this.sxy.execute(new Runnable() {
                /* class com.tencent.mm.plugin.expt.d.d.a.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(220330);
                    List<com.tencent.mm.plugin.expt.d.e.a.b> cMU = com.tencent.mm.plugin.expt.d.b.b.cMS().cMU();
                    if (cMU.size() <= 0) {
                        AppMethodBeat.o(220330);
                        return;
                    }
                    for (com.tencent.mm.plugin.expt.d.e.a.b bVar : cMU) {
                        if (bVar.syj == 6 && a.this.syd != null) {
                            a.this.syd.a(currentTimeMillis, bVar, str);
                        }
                    }
                    AppMethodBeat.o(220330);
                }
            });
            AppMethodBeat.o(220335);
        }
    }

    public final void aoq(final String str) {
        AppMethodBeat.i(220336);
        if (!b.cML()) {
            AppMethodBeat.o(220336);
        } else if (g.eP(str)) {
            Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionUBAAll data isEmpty!");
            AppMethodBeat.o(220336);
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            this.sxy.execute(new Runnable() {
                /* class com.tencent.mm.plugin.expt.d.d.a.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(220332);
                    List<com.tencent.mm.plugin.expt.d.e.a.b> cMU = com.tencent.mm.plugin.expt.d.b.b.cMS().cMU();
                    if (cMU.size() <= 0) {
                        AppMethodBeat.o(220332);
                        return;
                    }
                    for (com.tencent.mm.plugin.expt.d.e.a.b bVar : cMU) {
                        if (bVar.syj == 9 && a.this.syd != null) {
                            a.this.syd.a(currentTimeMillis, bVar, str);
                        }
                    }
                    AppMethodBeat.o(220332);
                }
            });
            AppMethodBeat.o(220336);
        }
    }
}
