package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;

public final class b extends a<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        AppMethodBeat.i(47616);
        ag agVar2 = agVar;
        if (!agVar2.getRuntime().bsC().NA()) {
            if (g(agVar2) || e.dE(context)) {
                mVar.a(this.nfG, context.getString(R.string.a1w), R.raw.appbrand_menu_back_to_home, 0);
                AppMethodBeat.o(47616);
                return;
            }
            mVar.a(this.nfG, (CharSequence) context.getString(R.string.a1x), R.raw.appbrand_menu_back_to_home, 0, true);
        }
        AppMethodBeat.o(47616);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(47615);
        ag agVar2 = agVar;
        if (e.dE(context)) {
            ((Activity) context).finish();
        }
        agVar2.getRuntime().bsD().bQR();
        if (agVar2.nmX != null) {
            i.a(str, agVar2.lBI, 20, "", Util.nowSecond(), 1, 0);
        }
        AppMethodBeat.o(47615);
    }

    public static boolean g(ac acVar) {
        AppMethodBeat.i(227149);
        q qVar = (q) acVar.getRuntime();
        if (qVar.NA()) {
            AppMethodBeat.o(227149);
            return false;
        }
        boolean startsWith = acVar.nna.startsWith(qVar.getAppConfig().bzI());
        AppMethodBeat.o(227149);
        return startsWith;
    }
}
