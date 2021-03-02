package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u0007H\u0007J\u000e\u0010\b\u001a\u00020\u0006*\u0004\u0018\u00010\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandActivityUtils;", "", "()V", "TAG", "", "hideVKB", "", "Landroid/app/Activity;", "showVKB", "plugin-appbrand-integration_release"})
public final class b {
    public static final b nRg = new b();

    static {
        AppMethodBeat.i(175216);
        AppMethodBeat.o(175216);
    }

    private b() {
    }

    public static final void G(Activity activity) {
        AppMethodBeat.i(175215);
        if (activity != null) {
            if (activity instanceof MMActivity) {
                ((MMActivity) activity).hideVKB();
                AppMethodBeat.o(175215);
                return;
            } else if (activity instanceof ad) {
                ((ad) activity).hideVKB();
                AppMethodBeat.o(175215);
                return;
            } else {
                Log.e("MicroMsg.AppBrandActivityUtils", "hideVKB not supported in " + activity.getLocalClassName());
            }
        }
        AppMethodBeat.o(175215);
    }
}
