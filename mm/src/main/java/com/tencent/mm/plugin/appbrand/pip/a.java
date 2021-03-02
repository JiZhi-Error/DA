package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h;
import com.tencent.mm.plugin.appbrand.jsapi.s.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public final String cDW = ("MicroMsg.AppBrand.AppBrandPageScopedPipInfo#" + hashCode());
    final ac cwK;
    public i.a mKh = null;
    boolean nBN;
    final LinkedList<String> nBO = new LinkedList<>();
    public final Map<String, C0785a> nBP = new ConcurrentHashMap();

    public a(ac acVar) {
        AppMethodBeat.i(219494);
        this.cwK = acVar;
        this.nBN = this.cwK.cwV;
        Log.i(this.cDW, "mIsCurPageForeground: " + this.nBN);
        acVar.a(new i.d() {
            /* class com.tencent.mm.plugin.appbrand.pip.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
            public final void onForeground() {
                AppMethodBeat.i(219490);
                a aVar = a.this;
                Log.i(aVar.cDW, "markCurPageForeground");
                aVar.nBN = true;
                AppMethodBeat.o(219490);
            }
        });
        acVar.a(new i.b() {
            /* class com.tencent.mm.plugin.appbrand.pip.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
            public final void onBackground() {
                AppMethodBeat.i(219491);
                a aVar = a.this;
                Log.i(aVar.cDW, "markCurPageBackground");
                aVar.nBN = false;
                AppMethodBeat.o(219491);
            }
        });
        AppMethodBeat.o(219494);
    }

    public final void aez(String str) {
        AppMethodBeat.i(219495);
        Log.i(this.cDW, "removePipRelatedKey, key: ".concat(String.valueOf(str)));
        synchronized (this.nBO) {
            try {
                this.nBO.remove(str);
            } finally {
                AppMethodBeat.o(219495);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String bTD() {
        String first;
        AppMethodBeat.i(219496);
        synchronized (this.nBO) {
            try {
                if (this.nBO.isEmpty()) {
                    first = null;
                } else {
                    first = this.nBO.getFirst();
                    AppMethodBeat.o(219496);
                }
            } finally {
                AppMethodBeat.o(219496);
            }
        }
        return first;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.pip.a$a  reason: collision with other inner class name */
    public static class C0785a {
        public final int id;
        public b.a nBR = b.a.NONE;
        public boolean nBS = false;
        public final h.a nBT;
        public final c nBU;
        public final g nBV;
        public final com.tencent.mm.plugin.appbrand.jsapi.s.i nBW;
        public c nBX;

        public C0785a(int i2, b bVar, g gVar, h.a aVar, c cVar, c cVar2, i.a aVar2) {
            AppMethodBeat.i(219492);
            this.id = i2;
            this.nBV = gVar;
            this.nBT = aVar;
            this.nBU = cVar;
            this.nBX = cVar2;
            a(bVar);
            this.nBW = gVar.bIs();
            this.nBW.a(aVar2);
            AppMethodBeat.o(219492);
        }

        public final void a(b bVar) {
            AppMethodBeat.i(219493);
            b.a Px = bVar.Px();
            if (Px != null) {
                this.nBR = Px;
            }
            Boolean Py = bVar.Py();
            if (Py != null) {
                this.nBS = Py.booleanValue();
            }
            AppMethodBeat.o(219493);
        }
    }
}
