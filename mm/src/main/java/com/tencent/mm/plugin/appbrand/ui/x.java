package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ao;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUITheme;", "", "()V", "THEME", "", "plugin-appbrand-integration_release"})
public final class x {
    public static final x nXS = new x();

    static {
        AppMethodBeat.i(177768);
        AppMethodBeat.o(177768);
    }

    private x() {
    }

    public static final int bXG() {
        AppMethodBeat.i(177767);
        if (ao.isDarkMode()) {
            AppMethodBeat.o(177767);
            return R.style.x;
        }
        AppMethodBeat.o(177767);
        return R.style.w;
    }
}
