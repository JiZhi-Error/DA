package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import org.json.JSONObject;

public final class f implements b<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ void c(Context context, ag agVar, String str) {
        AppMethodBeat.i(47684);
        ag agVar2 = agVar;
        d dVar = new d();
        c bsE = agVar2.bsE();
        new JSONObject();
        dVar.p(bsE);
        i.a(str, agVar2.lBI, 10, "", Util.nowSecond(), 1, 0);
        AppMethodBeat.o(47684);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ String b(Context context, ag agVar, String str) {
        AppMethodBeat.i(47685);
        String string = context.getString(R.string.j2);
        AppMethodBeat.o(47685);
        return string;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, ag agVar, String str) {
        AppMethodBeat.i(47686);
        if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED || p.Un(str).kDe) {
            AppMethodBeat.o(47686);
            return true;
        }
        AppMethodBeat.o(47686);
        return false;
    }
}
