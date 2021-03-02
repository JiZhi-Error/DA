package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class i extends a<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        AppMethodBeat.i(47635);
        b bsp = agVar.getRuntime().bsp();
        if (bsp != null && bsp.bPq()) {
            mVar.b(this.nfG, context.getResources().getString(R.string.a1y), R.raw.icons_outlined_multitask);
        }
        AppMethodBeat.o(47635);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(47634);
        ag agVar2 = agVar;
        b bsp = agVar2.getRuntime().bsp();
        if (bsp != null) {
            bsp.ic(true);
        } else {
            Log.w("MicroMsg.AppBrand.MenuDelegate_Minimize", "performItemClick, no float ball helper");
        }
        com.tencent.mm.plugin.appbrand.report.i.a(agVar2.getAppId(), agVar2.lBI, 29, "", Util.nowSecond(), 1, 0);
        AppMethodBeat.o(47634);
    }

    public i() {
        super(u.Minimize.ordinal());
        AppMethodBeat.i(47633);
        AppMethodBeat.o(47633);
    }
}
