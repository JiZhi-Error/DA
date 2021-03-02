package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.plugin.appbrand.report.model.d;
import com.tencent.mm.plugin.appbrand.report.model.f;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.plugin.appbrand.report.model.q;
import com.tencent.mm.sdk.system.AndroidContextUtil;

@SuppressLint({"ViewConstructor"})
public final class j extends x {
    @Override // com.tencent.mm.plugin.appbrand.page.w.a, com.tencent.mm.plugin.appbrand.page.x
    public final /* synthetic */ ac a(w wVar) {
        AppMethodBeat.i(175008);
        ag bOx = bOx();
        AppMethodBeat.o(175008);
        return bOx;
    }

    public j(l lVar) {
        super(AndroidContextUtil.castActivityOrNull(lVar.mContext), lVar);
        AppMethodBeat.i(47512);
        AppMethodBeat.o(47512);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w, com.tencent.mm.plugin.appbrand.page.x
    public final void init(String str) {
        AppMethodBeat.i(47513);
        super.init(str);
        AppMethodBeat.o(47513);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.x
    public final f bOw() {
        AppMethodBeat.i(47514);
        AnonymousClass1 r0 = new f() {
            /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j.AnonymousClass1 */
            private final h nay = new c(d.d(j.this.getRuntime().bsC().cys), j.this.getRuntime().brs());

            {
                AppMethodBeat.i(47506);
                AppMethodBeat.o(47506);
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.f
            public final void bOy() {
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.f
            public final void a(long j2, bx bxVar) {
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.f
            public final void c(ag agVar) {
                AppMethodBeat.i(47507);
                d(agVar);
                AppMethodBeat.o(47507);
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.f
            public final h bOz() {
                return this.nay;
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.f
            public final void I(Intent intent) {
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.f
            public final Intent bOA() {
                return null;
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.f
            public final p bOB() {
                AppMethodBeat.i(47508);
                p bUW = p.bUW();
                AppMethodBeat.o(47508);
                return bUW;
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.f
            public final q bOC() {
                AppMethodBeat.i(180319);
                q bUX = q.bUX();
                AppMethodBeat.o(180319);
                return bUX;
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.f
            public final void bOD() {
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.f
            public final void resetSession() {
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.g
            public final void a(ag agVar, ag agVar2, bx bxVar) {
                AppMethodBeat.i(47509);
                this.nay.a(agVar, agVar2, bxVar);
                AppMethodBeat.o(47509);
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.g
            public final void d(ag agVar) {
                AppMethodBeat.i(47510);
                this.nay.d(agVar);
                AppMethodBeat.o(47510);
            }

            @Override // com.tencent.mm.plugin.appbrand.report.model.g
            public final void e(ag agVar) {
                AppMethodBeat.i(47511);
                this.nay.e(agVar);
                AppMethodBeat.o(47511);
            }
        };
        AppMethodBeat.o(47514);
        return r0;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.x
    public final ag bOx() {
        AppMethodBeat.i(175007);
        k kVar = new k();
        AppMethodBeat.o(175007);
        return kVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.w, com.tencent.mm.plugin.appbrand.page.x
    public final boolean e(t tVar) {
        return false;
    }
}
