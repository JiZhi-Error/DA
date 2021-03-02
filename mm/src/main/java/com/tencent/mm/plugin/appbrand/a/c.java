package com.tencent.mm.plugin.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;

public final class c {
    final AppBrandRuntime kEc;
    public final d kQM;
    public final android.support.v4.e.a<a, c> kQN = new android.support.v4.e.a<>();

    public interface a {
        void a(String str, b bVar);
    }

    public c(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(134712);
        this.kEc = appBrandRuntime;
        this.kQM = new d(appBrandRuntime) {
            /* class com.tencent.mm.plugin.appbrand.a.c.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // com.tencent.mm.plugin.appbrand.a.d
            public final void bwW() {
                AppMethodBeat.i(134710);
                c.this.kEc.finish();
                AppMethodBeat.o(134710);
            }

            /* access modifiers changed from: package-private */
            @Override // com.tencent.mm.plugin.appbrand.a.d
            public final void a(b bVar) {
                a[] aVarArr;
                AppMethodBeat.i(134711);
                c cVar = c.this;
                synchronized (cVar.kQN) {
                    try {
                        aVarArr = (a[]) cVar.kQN.keySet().toArray(new a[cVar.kQN.size()]);
                    } finally {
                        AppMethodBeat.o(134711);
                    }
                }
                for (a aVar : aVarArr) {
                    aVar.a(cVar.kEc.mAppId, bVar);
                }
            }
        };
        AppMethodBeat.o(134712);
    }

    public final void gK(boolean z) {
        AppMethodBeat.i(162077);
        this.kQM.gK(z);
        AppMethodBeat.o(162077);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(134713);
        if (aVar == null || this.kQM.kQW.get()) {
            AppMethodBeat.o(134713);
            return;
        }
        synchronized (this.kQN) {
            try {
                this.kQN.put(aVar, this);
            } finally {
                AppMethodBeat.o(134713);
            }
        }
    }

    public final void b(a aVar) {
        AppMethodBeat.i(134714);
        if (aVar == null || b.DESTROYED == this.kQM.bwY()) {
            AppMethodBeat.o(134714);
            return;
        }
        synchronized (this.kQN) {
            try {
                this.kQN.remove(aVar);
            } finally {
                AppMethodBeat.o(134714);
            }
        }
    }
}
