package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWCFactory;", "()V", "matchLaunchScene", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "scene", "", "shouldInterceptLaunch", "_context", "Landroid/content/Context;", "shouldOverrideRuntimeInitialization", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "plugin-appbrand-integration_release"})
public final class g implements r {
    public static final g nav = new g();

    static {
        AppMethodBeat.i(50870);
        AppMethodBeat.o(50870);
    }

    private g() {
    }

    public static final boolean c(Context context, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        Context context2;
        JSONObject jSONObject;
        boolean z;
        boolean z2;
        AppMethodBeat.i(50867);
        p.h(appBrandInitConfigWC, "config");
        p.h(appBrandStatObject, "stat");
        if (e(appBrandInitConfigWC, appBrandStatObject)) {
            h.bWb().afe(appBrandInitConfigWC.appId);
            if (aa.n(appBrandInitConfigWC)) {
                try {
                    jSONObject = new JSONObject(aa.m(appBrandInitConfigWC));
                } catch (Exception e2) {
                    jSONObject = new JSONObject();
                }
                String optString = jSONObject.optString("instanceId", "");
                String str = optString;
                if (str == null || str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    appBrandInitConfigWC.dC(optString);
                    appBrandInitConfigWC.ldW = new QualitySession(appBrandInitConfigWC.NC(), appBrandInitConfigWC, appBrandStatObject);
                }
                String optString2 = jSONObject.optString("sessionId", "");
                String str2 = optString2;
                if (str2 == null || str2.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    appBrandInitConfigWC.dB(optString2);
                }
            }
            if (context == null) {
                context2 = MMApplicationContext.getContext();
            } else {
                context2 = context;
            }
            Intent intent = new Intent();
            intent.setClass(context2, AppBrandPluginUI.class);
            if (!(context2 instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("key_launch_app_client_version", BuildInfo.CLIENT_VERSION_INT);
            intent.putExtra("key_appbrand_init_config", appBrandInitConfigWC);
            intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor", "shouldInterceptLaunch", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor", "shouldInterceptLaunch", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (!(context2 instanceof Activity)) {
                context2 = null;
            }
            Activity activity = (Activity) context2;
            if (activity != null) {
                activity.overridePendingTransition(0, 0);
            }
            AppMethodBeat.o(50867);
            return true;
        }
        AppMethodBeat.o(50867);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.r
    public final q b(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandRuntimeContainerWC appBrandRuntimeContainerWC) {
        AppMethodBeat.i(50868);
        p.h(appBrandInitConfigWC, "config");
        p.h(appBrandRuntimeContainerWC, "container");
        AppBrandStatObject Nz = appBrandInitConfigWC.Nz();
        p.g(Nz, "config.statObject");
        if (e(appBrandInitConfigWC, Nz)) {
            l lVar = new l(appBrandRuntimeContainerWC);
            AppMethodBeat.o(50868);
            return lVar;
        }
        AppMethodBeat.o(50868);
        return null;
    }

    public static final boolean e(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(50869);
        p.h(appBrandInitConfigWC, "config");
        p.h(appBrandStatObject, "stat");
        boolean yt = yt(appBrandStatObject.scene);
        AppMethodBeat.o(50869);
        return yt;
    }

    public static final boolean yt(int i2) {
        return 1111 == i2;
    }
}
