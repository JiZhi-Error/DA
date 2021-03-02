package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class d implements b<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, ag agVar, String str) {
        AppMethodBeat.i(47683);
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) agVar.av(AppBrandSysConfigWC.class);
        if (appBrandSysConfigWC.leE.kNW == 1 || appBrandSysConfigWC.leE.kNW == 2 || WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED || p.Un(str).kDe) {
            AppMethodBeat.o(47683);
            return true;
        }
        AppMethodBeat.o(47683);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ String b(Context context, ag agVar, String str) {
        AppMethodBeat.i(47682);
        if (((AppBrandSysConfigWC) agVar.av(AppBrandSysConfigWC.class)).cyD) {
            String string = context.getString(R.string.oa);
            AppMethodBeat.o(47682);
            return string;
        }
        String string2 = context.getString(R.string.oh);
        AppMethodBeat.o(47682);
        return string2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ void c(Context context, ag agVar, String str) {
        AppMethodBeat.i(47681);
        ag agVar2 = agVar;
        if (!((AppBrandSysConfigWC) agVar2.av(AppBrandSysConfigWC.class)).cyD) {
            AppBrandPerformanceManager.aej(str);
            Toast.makeText(context, (int) R.string.oi, 0).show();
        } else {
            AppBrandPerformanceManager.aek(str);
            Toast.makeText(context, (int) R.string.ob, 0).show();
        }
        agVar2.getRuntime().finish();
        AppMethodBeat.o(47681);
    }
}
