package com.tencent.mm.plugin.crashfix;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.crashfix.a.a;
import com.tencent.mm.plugin.crashfix.d.b;
import com.tencent.mm.plugin.crashfix.d.c;
import com.tencent.mm.plugin.crashfix.d.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public class PluginSystemCrashFix extends f implements a {
    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(145614);
        alias(a.class);
        AppMethodBeat.o(145614);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(145615);
        dependsOnRoot();
        AppMethodBeat.o(145615);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(145616);
        Log.i("MicroMsg.SystemCrashFixPatch", "api level : " + Build.VERSION.SDK_INT);
        Handler handler = new Handler(Looper.myLooper());
        if (c.qCA == null) {
            ArrayList arrayList = new ArrayList();
            c.qCA = arrayList;
            arrayList.add(new d());
            c.qCA.add(new com.tencent.mm.plugin.crashfix.d.e.a());
            c.qCA.add(new com.tencent.mm.plugin.crashfix.d.a.a());
            c.qCA.add(new com.tencent.mm.plugin.crashfix.d.b.a());
            c.qCA.add(new com.tencent.mm.plugin.crashfix.d.c.a());
        }
        for (b bVar : c.qCA) {
            if (bVar.Fh(Build.VERSION.SDK_INT)) {
                if (bVar instanceof com.tencent.mm.plugin.crashfix.d.a) {
                    handler.postDelayed(new Runnable((com.tencent.mm.plugin.crashfix.d.a) bVar, bVar) {
                        /* class com.tencent.mm.plugin.crashfix.d.c.AnonymousClass1 */
                        final /* synthetic */ a qCB;
                        final /* synthetic */ b qCC;

                        {
                            this.qCB = r1;
                            this.qCC = r2;
                        }

                        public final void run() {
                            AppMethodBeat.i(145628);
                            if (!this.qCB.cAN()) {
                                Log.i("MicroMsg.SystemCrashFixPatch", this.qCC.getClass().getCanonicalName() + " : start");
                                this.qCB.start();
                                boolean cAO = this.qCB.cAO();
                                this.qCB.cAM();
                                Log.i("MicroMsg.SystemCrashFixPatch", this.qCC.getClass().getCanonicalName() + " : " + cAO);
                                AppMethodBeat.o(145628);
                                return;
                            }
                            Log.i("MicroMsg.SystemCrashFixPatch", this.qCC.getClass().getCanonicalName() + " has failed before");
                            AppMethodBeat.o(145628);
                        }
                    }, 0);
                } else {
                    Log.i("MicroMsg.SystemCrashFixPatch", bVar.getClass().getCanonicalName() + " : " + bVar.cAO());
                }
            }
        }
        AppMethodBeat.o(145616);
    }
}
