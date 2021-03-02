package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class a extends com.tencent.mm.plugin.appbrand.menu.a.a<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        String str2;
        AppMethodBeat.i(180321);
        ag agVar2 = agVar;
        AppBrandSysConfigWC bsB = agVar2.getRuntime().bsB();
        AppBrandInitConfigWC bsC = agVar2.getRuntime().bsC();
        if (bsB == null) {
            AppMethodBeat.o(180321);
            return;
        }
        String str3 = "";
        if (agVar2.getRuntime().ON().cyA != null) {
            str3 = agVar2.getRuntime().bsC().cym;
        }
        AppBrandOpReportLogic.a.d(agVar2);
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
        AppBrandProfileUI.a(context, bsC.username, 3, str3, aVar.bAv(), null, ActivityStarterIpcDelegate.aJ(context));
        i.a(str, agVar2.lBI, 6, "", Util.nowSecond(), 1, 0);
        AppMethodBeat.o(180321);
    }

    public a() {
        super(u.AboutUs.ordinal());
        AppMethodBeat.i(180320);
        AppMethodBeat.o(180320);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        AppMethodBeat.i(180322);
        mVar.b(u.AboutUs.ordinal(), context.getString(R.string.a20), R.raw.icons_outlined_mini_program2);
        AppMethodBeat.o(180322);
    }
}
