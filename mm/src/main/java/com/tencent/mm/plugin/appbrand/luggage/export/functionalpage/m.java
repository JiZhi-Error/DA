package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalUIAnimationStyle;", "", "()V", "setOpenAnimation", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "plugin-appbrand-integration_release"})
public final class m {
    public static final m naG = new m();

    static {
        AppMethodBeat.i(50877);
        AppMethodBeat.o(50877);
    }

    private m() {
    }

    public static final boolean a(Activity activity, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        boolean z = false;
        AppMethodBeat.i(50876);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(appBrandInitConfig, "config");
        p.h(appBrandStatObject, "stat");
        if (!(appBrandInitConfig instanceof AppBrandInitConfigWC)) {
            AppMethodBeat.o(50876);
        } else {
            try {
                if (g.e((AppBrandInitConfigWC) appBrandInitConfig, appBrandStatObject)) {
                    activity.overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
                    z = true;
                }
            } catch (Exception e2) {
            }
            AppMethodBeat.o(50876);
        }
        return z;
    }
}
