package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class l extends com.tencent.mm.plugin.appbrand.menu.a.a<ag> {

    public static final class a extends s {
        private static final int CTRL_INDEX = 904;
        public static final String NAME = "onStartHandoff";
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        boolean z;
        AppMethodBeat.i(227170);
        ag agVar2 = agVar;
        if (!((b) g.af(b.class)).a(b.a.clicfg_appbrand_open_handoff_android, false) || com.tencent.mm.plugin.appbrand.jsapi.f.a.l("MicroMsg.MenuDelegate_SendHandoff", agVar2.getAppId(), agVar2.getRuntime().NA()) != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            mVar.a(u.SendHandoff.ordinal(), context.getString(R.string.a22), R.raw.icons_outlined_colorful_handoff, 0);
            i.a(str, agVar2.lBI, 45, "", Util.nowSecond(), 1, 0);
        }
        AppMethodBeat.o(227170);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(227169);
        ag agVar2 = agVar;
        Log.i("MicroMsg.MenuDelegate_SendHandoff", "performItemClick");
        new a().b(agVar2.getRuntime().bsE(), agVar2.getComponentId()).Zg("").bEo();
        i.a(str, agVar2.lBI, 46, "", Util.nowSecond(), 1, 0);
        AppMethodBeat.o(227169);
    }

    public l() {
        super(u.SendHandoff.ordinal());
        AppMethodBeat.i(227168);
        AppMethodBeat.o(227168);
    }
}
