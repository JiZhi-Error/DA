package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ui.ag;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dimenPX", "", "resId", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "getExpectedSize", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "luggage-wechat-full-sdk_release"})
public class al implements ag {
    private final AppBrandRuntime cBW;

    public al(AppBrandRuntime appBrandRuntime) {
        p.h(appBrandRuntime, "rt");
        AppMethodBeat.i(230233);
        this.cBW = appBrandRuntime;
        AppMethodBeat.o(230233);
    }

    public Context getContext() {
        AppMethodBeat.i(230232);
        Activity context = this.cBW.getContext();
        if (context != null) {
            Activity activity = context;
            AppMethodBeat.o(230232);
            return activity;
        }
        Context appContext = this.cBW.getAppContext();
        p.g(appContext, "rt.appContext");
        AppMethodBeat.o(230232);
        return appContext;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ag
    public ag.a No() {
        AppMethodBeat.i(148223);
        ag.a aVar = new ag.a(0, (zr(R.dimen.b9) - zr(R.dimen.p4)) / 2, zr(R.dimen.oq), 0);
        AppMethodBeat.o(148223);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ag
    public final ag.b bXN() {
        AppMethodBeat.i(148224);
        Resources resources = getContext().getResources();
        p.g(resources, "context.resources");
        ag.b bVar = new ag.b(a.cR(resources.getDisplayMetrics().density * 96.0f), zr(R.dimen.p4));
        AppMethodBeat.o(148224);
        return bVar;
    }

    public final int zr(int i2) {
        AppMethodBeat.i(148225);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i2);
        AppMethodBeat.o(148225);
        return dimensionPixelSize;
    }
}
