package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.plugin.appbrand.ui.w;
import com.tencent.mm.plugin.appbrand.ui.x;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0002¨\u0006\u0005"}, hxF = {"obtainPersistentContextWrapper", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimePersistentContextWrapper;", "Landroid/content/Context;", "obtainScreenAdaptiveContext", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIScreenAdaptiveContextThemeWrapper;", "plugin-appbrand-integration_release"})
public final class f {
    static final w eh(Context context) {
        w wVar;
        AppMethodBeat.i(50911);
        if (context instanceof w) {
            w wVar2 = (w) context;
            AppMethodBeat.o(50911);
            return wVar2;
        }
        if (context instanceof AppBrandUI) {
            wVar = ((AppBrandUI) context).bXx();
        } else {
            wVar = new w(context, x.bXG());
        }
        p.g(wVar, "if (this is AppBrandUI) …ITheme.THEME())\n        }");
        AppMethodBeat.o(50911);
        return wVar;
    }

    static final n ei(Context context) {
        AppMethodBeat.i(50912);
        if (context instanceof n) {
            n eo = n.eo(((n) context).getBaseContext());
            p.g(eo, "AppBrandRuntimePersisten…BrandUI(this.baseContext)");
            AppMethodBeat.o(50912);
            return eo;
        }
        n eo2 = n.eo(context);
        p.g(eo2, "AppBrandRuntimePersisten…apper.forAppBrandUI(this)");
        AppMethodBeat.o(50912);
        return eo2;
    }
}
