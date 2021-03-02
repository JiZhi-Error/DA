package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class h extends a<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(47631);
        ag agVar2 = agVar;
        g gVar = new g();
        gVar.appId = "wxae8e93bbcb785195";
        gVar.username = "gh_32d0f14ab3c6@app";
        gVar.scene = agVar2.getRuntime().NA() ? 1085 : 1170;
        gVar.version = 0;
        gVar.iOo = 0;
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(context, gVar);
        i.a(agVar2.getAppId(), agVar2.lBI, 32, "", Util.nowSecond(), 1, 0);
        AppMethodBeat.o(47631);
    }

    public h() {
        super(u.GrowthCare.ordinal());
        AppMethodBeat.i(47630);
        AppMethodBeat.o(47630);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        AppMethodBeat.i(47632);
        if (!"wxae8e93bbcb785195".equals(str)) {
            mVar.b(this.nfG, context.getString(R.string.a1z), R.raw.appbrand_menu_growth_care);
        }
        AppMethodBeat.o(47632);
    }
}
