package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J,\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/menu/MenuDelegate_Restart;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "attachTo", "", "context", "Landroid/content/Context;", "pageView", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "appId", "", "performItemClick", "menuInfo", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "plugin-appbrand-integration_release"})
public final class k extends a<ag> {
    public k() {
        super(u.Restart.ordinal());
        AppMethodBeat.i(175203);
        AppMethodBeat.o(175203);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        AppMethodBeat.i(175201);
        p.h(context, "context");
        p.h(agVar, "pageView");
        if (e.dE(context) || mVar == null) {
            AppMethodBeat.o(175201);
            return;
        }
        mVar.b(bPj(), context.getString(R.string.q0), R.raw.icons_outlined_refresh);
        AppMethodBeat.o(175201);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(175202);
        ag agVar2 = agVar;
        p.h(context, "context");
        p.h(agVar2, "pageView");
        i.a(agVar2.getAppId(), agVar2.getURL(), 40, "", Util.nowSecond(), 1, 0);
        q runtime = agVar2.getRuntime();
        p.g(runtime, "pageView.runtime");
        if (!runtime.NA()) {
            q runtime2 = agVar2.getRuntime();
            p.g(runtime2, "pageView.runtime");
            runtime2.bsC().kHw = "";
        }
        agVar2.getRuntime().a((AppBrandInitConfig) null, "MenuDelegate_Restart");
        AppMethodBeat.o(175202);
    }
}
