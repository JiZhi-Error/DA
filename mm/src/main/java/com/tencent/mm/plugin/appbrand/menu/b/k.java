package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;

public final class k implements b<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ boolean a(Context context, ag agVar, String str) {
        AppMethodBeat.i(47701);
        ag agVar2 = agVar;
        if (agVar2.getRuntime() instanceof q) {
            q runtime = agVar2.getRuntime();
            if (runtime.NA() && runtime.OQ()) {
                AppMethodBeat.o(47701);
                return true;
            }
        }
        AppMethodBeat.o(47701);
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ void c(Context context, ag agVar, String str) {
        AppMethodBeat.i(47699);
        if (v.bAY()) {
            v.gY(false);
            Toast.makeText(context, "Disable success, please restart WeChat to take effect.", 1).show();
            AppMethodBeat.o(47699);
            return;
        }
        v.gY(true);
        Toast.makeText(context, "Enable success, please restart WeChat to take effect.", 1).show();
        AppMethodBeat.o(47699);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.b
    public final /* synthetic */ String b(Context context, ag agVar, String str) {
        AppMethodBeat.i(47700);
        if (v.bAY()) {
            AppMethodBeat.o(47700);
            return "Disable Preload";
        }
        AppMethodBeat.o(47700);
        return "Enable Preload";
    }
}
