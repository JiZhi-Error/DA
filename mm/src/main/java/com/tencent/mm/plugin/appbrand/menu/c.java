package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class c extends a<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        String str2;
        AppMethodBeat.i(47618);
        ag agVar2 = agVar;
        AppBrandSysConfigWC bsB = agVar2.getRuntime().bsB();
        String b2 = com.tencent.mm.plugin.appbrand.d.a.b(agVar2);
        WxaExposedParams.a aVar = new WxaExposedParams.a();
        aVar.appId = ((AppBrandSysConfigLU) bsB).appId;
        aVar.from = 3;
        if (agVar2.nmX == null) {
            str2 = "";
        } else {
            str2 = agVar2.lBI;
        }
        aVar.pageId = str2;
        aVar.kNW = ((AppBrandSysConfigLU) bsB).leE.kNW;
        aVar.pkgVersion = ((AppBrandSysConfigLU) bsB).leE.pkgVersion;
        aVar.lhp = b2;
        if (b.aeU(agVar2.getAppId()) != null) {
            aVar.sessionId = b.aeU(agVar2.getAppId()).kEY;
        }
        WxaExposedParams bAv = aVar.bAv();
        Intent intent = new Intent();
        String a2 = w.a(bAv);
        Log.i("MicroMsg.MenuDelegate_Complaint", "feedbackUrl:%s, wxaExposedParams:%s", a2, bAv.toString());
        intent.putExtra("title", context.getString(R.string.pr));
        intent.putExtra("rawUrl", a2);
        intent.putExtra("forceHideShare", true);
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        i.a(agVar2.getAppId(), agVar2.lBI, 31, "", Util.nowSecond(), 1, 0);
        AppMethodBeat.o(47618);
    }

    public c() {
        super(u.Complaint.ordinal());
        AppMethodBeat.i(47617);
        AppMethodBeat.o(47617);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        AppMethodBeat.i(47619);
        mVar.b(this.nfG, context.getString(R.string.pr), R.raw.appbrand_menu_complaint);
        AppMethodBeat.o(47619);
    }
}
