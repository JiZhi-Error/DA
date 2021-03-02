package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI;
import com.tencent.mm.sdk.crash.CrashReportFactory;

public final class e implements n {
    boolean lmL;

    @Override // com.tencent.mm.modelappbrand.n
    public final void d(Context context, Bundle bundle) {
        AppMethodBeat.i(121243);
        Intent intent = new Intent(context, WxaWidgetDebugUI.class);
        String da = WxaWidgetInitializer.da(bundle.getString("app_id"), bundle.getString("msg_id"));
        intent.putExtras(bundle);
        intent.putExtra("id", da);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/dynamic/api/WxaWidgetDebugger", "openDebugUI", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/dynamic/api/WxaWidgetDebugger", "openDebugUI", "(Landroid/content/Context;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(121243);
    }

    @Override // com.tencent.mm.modelappbrand.n
    public final void cV(Context context) {
        AppMethodBeat.i(121244);
        com.tencent.mm.plugin.appbrand.wxawidget.console.e.eD(context);
        AppMethodBeat.o(121244);
    }

    @Override // com.tencent.mm.modelappbrand.n
    public final boolean sE(int i2) {
        AppMethodBeat.i(121245);
        boolean sE = j.a.sE(i2);
        AppMethodBeat.o(121245);
        return sE;
    }

    @Override // com.tencent.mm.modelappbrand.n
    public final boolean a(String str, n.a aVar) {
        AppMethodBeat.i(121246);
        boolean c2 = b.c(str, aVar);
        AppMethodBeat.o(121246);
        return c2;
    }

    @Override // com.tencent.mm.modelappbrand.n
    public final boolean b(String str, n.a aVar) {
        AppMethodBeat.i(121247);
        boolean d2 = b.d(str, aVar);
        AppMethodBeat.o(121247);
        return d2;
    }

    @Override // com.tencent.mm.modelappbrand.n
    public final void fu(boolean z) {
        this.lmL = z;
    }

    @Override // com.tencent.mm.modelappbrand.n
    public final boolean aXO() {
        return this.lmL;
    }

    @Override // com.tencent.mm.modelappbrand.n
    public final boolean aXP() {
        AppMethodBeat.i(121248);
        boolean hasDebuger = CrashReportFactory.hasDebuger();
        AppMethodBeat.o(121248);
        return hasDebuger;
    }
}
