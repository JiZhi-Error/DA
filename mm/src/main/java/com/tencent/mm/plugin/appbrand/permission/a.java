package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.w.b;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends c {
    private final k mui;
    private final q nxf;
    private final com.tencent.mm.plugin.appbrand.jsapi.w.a nxg;

    private String bSV() {
        AppMethodBeat.i(47987);
        if (this.nxf.NA()) {
            try {
                String nullAsNil = Util.nullAsNil(this.nxf.bsC().kHw);
                AppMethodBeat.o(47987);
                return nullAsNil;
            } catch (Exception e2) {
                AppMethodBeat.o(47987);
                return "";
            }
        } else {
            x bsD = this.nxf.bsD();
            if (bsD == null) {
                AppMethodBeat.o(47987);
                return null;
            }
            String currentUrl = bsD.getCurrentUrl();
            AppMethodBeat.o(47987);
            return currentUrl;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.c, com.tencent.mm.plugin.appbrand.jsapi.f.b
    public final boolean a(p pVar, String str, int i2, f.a aVar) {
        AppMethodBeat.i(47988);
        com.tencent.mm.plugin.appbrand.jsapi.w.a aVar2 = this.nxg;
        k kVar = this.mui;
        String bSV = bSV();
        kotlin.g.b.p.h(kVar, "component");
        kotlin.g.b.p.h(pVar, ProviderConstants.API_PATH);
        if (!i.aeO(pVar.getName())) {
            b bIz = aVar2.moZ.bIz();
            long currentTicks = Util.currentTicks();
            bIz.mpb = kVar;
            bIz.mpc = pVar;
            bIz.data = str;
            bIz.startTime = currentTicks;
            bIz.path = bSV;
            SparseArray<b> sparseArray = aVar2.moY;
            synchronized (sparseArray) {
                try {
                    sparseArray.put(i2, bIz);
                    kotlin.x xVar = kotlin.x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(47988);
                    throw th;
                }
            }
        }
        if (s.a(this.mui, pVar, aVar)) {
            AppMethodBeat.o(47988);
            return true;
        }
        boolean a2 = super.a(pVar, str, i2, aVar);
        AppMethodBeat.o(47988);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.c, com.tencent.mm.plugin.appbrand.jsapi.f.b
    public final void V(int i2, String str) {
        AppMethodBeat.i(47989);
        super.V(i2, str);
        this.nxg.ao(i2, str);
        AppMethodBeat.o(47989);
    }

    @Override // com.tencent.mm.plugin.appbrand.c, com.tencent.mm.plugin.appbrand.jsapi.f.b
    public final void a(p pVar, String str, int i2, String str2) {
        AppMethodBeat.i(47990);
        super.a(pVar, str, i2, str2);
        if (!TextUtils.isEmpty(str2)) {
            if ((BuildInfo.IS_FLAVOR_RED || d.KyS || d.KyR) && "fail:internal error invalid js component".equals(str2)) {
                ClassCastException classCastException = new ClassCastException(String.format("Mismatch api(%s) component", pVar.getName()));
                AppMethodBeat.o(47990);
                throw classCastException;
            }
            this.nxg.ao(i2, str2);
        }
        AppMethodBeat.o(47990);
    }

    public a(q qVar, k kVar) {
        super(qVar, kVar, qVar.cCn);
        this.nxf = qVar;
        this.mui = kVar;
        this.nxg = qVar.kDh;
    }
}
