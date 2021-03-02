package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import java.util.HashMap;

public final class p extends com.tencent.mm.plugin.appbrand.menu.a.a<ag> {

    public static final class a extends s {
        private static final int CTRL_INDEX = 76;
        public static final String NAME = "onShareTimeline";
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(180324);
        ag agVar2 = agVar;
        int a2 = ((b) g.af(b.class)).a(agVar2.getRuntime().NA() ? b.a.clicfg_weapp_game_share_timeline_entry_android : b.a.clicfg_weapp_share_timeline_entry_android, 0);
        AppBrandSysConfigWC bsB = agVar2.getRuntime().bsB();
        Context context2 = agVar2.getContext();
        if (bsB == null || context2 == null) {
            z = true;
        } else if ((bsB.czf & 64) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.MenuDelegate_ShareToTimeline", "isShow openFlag:%d isPermissionDenied:%b", Integer.valueOf(a2), Boolean.valueOf(z));
        if (a2 != 1 || z) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            int i2 = this.nfG;
            String string = context.getString(R.string.a24);
            if (g(agVar2)) {
                z3 = false;
            }
            mVar.a(i2, string, R.raw.bottomsheet_icon_moment, 0, z3);
        }
        AppMethodBeat.o(180324);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(47661);
        ag agVar2 = agVar;
        Log.i("MicroMsg.MenuDelegate_ShareToTimeline", "performItemClick");
        AppBrandSysConfigWC bsB = agVar2.getRuntime().bsB();
        a aVar = new a();
        HashMap hashMap = new HashMap();
        String bDn = agVar2.bDn();
        if (Util.isNullOrNil(bDn)) {
            bDn = bsB.brandName;
        }
        hashMap.put("title", bDn);
        hashMap.put("path", agVar2.nna);
        aVar.b(agVar2.getRuntime().bsE(), agVar2.getComponentId()).L(hashMap).bEo();
        i.a(str, agVar2.lBI, 41, "", Util.nowSecond(), 1, 0);
        AppMethodBeat.o(47661);
    }

    p() {
        super(u.ShareToTimeLine.ordinal());
        AppMethodBeat.i(47660);
        AppMethodBeat.o(47660);
    }

    public static boolean g(ag agVar) {
        AppMethodBeat.i(227171);
        if (!agVar.yK(u.ShareToTimeLine.ordinal()).neT) {
            AppMethodBeat.o(227171);
            return true;
        }
        AppMethodBeat.o(227171);
        return false;
    }
}
