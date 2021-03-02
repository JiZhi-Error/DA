package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class e implements b<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, ag agVar, String str) {
        AppMethodBeat.i(227180);
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) agVar.av(AppBrandSysConfigWC.class);
        if (appBrandSysConfigWC.leE.kNW == 1 || appBrandSysConfigWC.leE.kNW == 2 || WeChatEnvironment.hasDebugger() || WeChatEnvironment.isMonkeyEnv() || BuildInfo.IS_FLAVOR_RED || p.Un(str).kDe) {
            AppMethodBeat.o(227180);
            return true;
        } else if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(227180);
            return true;
        } else {
            AppMethodBeat.o(227180);
            return false;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ void c(Context context, ag agVar, String str) {
        String string;
        AppMethodBeat.i(227178);
        if (Util.isNullOrNil(m.bAc())) {
            m.Xe("--prof_cpp");
            string = context.getString(R.string.jy);
        } else {
            m.bAd();
            string = context.getString(R.string.jx);
        }
        AppBrandProcessSuicideLogic.a((AppBrandUI) context, string);
        AppMethodBeat.o(227178);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ String b(Context context, ag agVar, String str) {
        String string;
        AppMethodBeat.i(227179);
        if (Util.isNullOrNil(m.bAc())) {
            string = context.getString(R.string.km);
        } else {
            string = context.getString(R.string.kj);
        }
        String charSequence = string.toString();
        AppMethodBeat.o(227179);
        return charSequence;
    }
}
