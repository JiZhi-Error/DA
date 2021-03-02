package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class r extends a {
    public r() {
        super(u.StickInWeChat.ordinal());
        AppMethodBeat.i(47662);
        AppMethodBeat.o(47662);
    }

    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final void a(Context context, ac acVar, m mVar, String str) {
        AppMethodBeat.i(47663);
        g.af(l.class);
        AppMethodBeat.o(47663);
    }

    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final void a(Context context, ac acVar, String str, t tVar) {
        AppMethodBeat.i(47664);
        com.tencent.mm.plugin.appbrand.config.l OT = acVar.getRuntime().OT();
        WxaPkgWrappingInfo wxaPkgWrappingInfo = OT.leE;
        AppBrandStickyBannerLogic.a.bYc();
        h.a(str, h.d.HANG);
        AppBrandStickyBannerLogic.a.a(context, OT.appId, OT.leE.kNW, OT.brandName, OT.jyi);
        i.a(str, acVar.lBI, 13, "", Util.nowSecond(), 1, 0);
        AppMethodBeat.o(47664);
    }
}
