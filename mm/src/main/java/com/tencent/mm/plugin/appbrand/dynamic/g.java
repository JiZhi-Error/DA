package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collection;

public final class g {
    private static p.a lme = new p.a() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.g.AnonymousClass1 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(121173);
            Bundle bundle = new Bundle();
            bundle.putInt("status", i2);
            for (String str : i.bBL().bBM()) {
                h.a(str, bundle, a.class, null);
            }
            AppMethodBeat.o(121173);
        }
    };

    static {
        AppMethodBeat.i(121177);
        AppMethodBeat.o(121177);
    }

    public static void initialize() {
        AppMethodBeat.i(121175);
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(121175);
            return;
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().a(lme);
        AppMethodBeat.o(121175);
    }

    public static void release() {
        AppMethodBeat.i(121176);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().b(lme);
        AppMethodBeat.o(121176);
    }

    static final class a implements b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(121174);
            Collection<c> values = d.bBH().llW.values();
            if (values == null || values.isEmpty()) {
                AppMethodBeat.o(121174);
                return;
            }
            com.tencent.mm.plugin.appbrand.dynamic.f.d dVar2 = new com.tencent.mm.plugin.appbrand.dynamic.f.d();
            String str = dVar2.name;
            String jSONObject = dVar2.toJSONObject().toString();
            for (c cVar : values) {
                if (cVar != null) {
                    cVar.cY(str, jSONObject);
                }
            }
            AppMethodBeat.o(121174);
        }
    }
}
