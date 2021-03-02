package com.tencent.luggage.sdk.c;

import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.p.a;

public final class a {

    /* renamed from: com.tencent.luggage.sdk.c.a$a  reason: collision with other inner class name */
    public static final class C0183a extends a.c {
        private final d cBE;

        public /* synthetic */ C0183a(d dVar, byte b2) {
            this(dVar);
        }

        private C0183a(d dVar) {
            this.cBE = dVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.p.a, com.tencent.mm.plugin.appbrand.p.a.c
        public final void a(String str, a.b bVar) {
            AppMethodBeat.i(169443);
            ((com.tencent.luggage.sdk.b.a.c.d) this.cBE.NY()).dt(ModulePkgInfo.MAIN_MODULE_NAME);
            super.a(str, bVar);
            AppMethodBeat.o(169443);
        }
    }
}
