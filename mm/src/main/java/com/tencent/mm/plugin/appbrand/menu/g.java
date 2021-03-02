package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import java.util.HashMap;

public final class g extends com.tencent.mm.plugin.appbrand.menu.a.a<ag> {

    public static final class a extends s {
        private static final int CTRL_INDEX = 799;
        public static final String NAME = "onAddToFavorites";
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        AppMethodBeat.i(227167);
        ag agVar2 = agVar;
        if (e.dE(context)) {
            Log.i("MicroMsg.MenuDelegate_Fav", "AppBrandAdUI not support favorite");
            AppMethodBeat.o(227167);
        } else if (agVar2.getRuntime().bsC().ldN) {
            Log.i("MicroMsg.MenuDelegate_Fav", "isPluginApp not support");
            AppMethodBeat.o(227167);
        } else {
            mVar.a(this.nfG, context.getString(R.string.fn9), R.raw.bottomsheet_icon_fav, 0, agVar2.yK(u.Fav.ordinal()).neT);
            AppMethodBeat.o(227167);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(227166);
        ag agVar2 = agVar;
        String bDn = agVar2.bDn();
        if (Util.isNullOrNil(bDn)) {
            bDn = agVar2.getRuntime().bsC().brandName;
        }
        com.tencent.mm.plugin.appbrand.jsapi.af.a bRM = agVar2.bRM();
        String url = bRM == null ? "" : bRM.getWebView().getUrl();
        a aVar = new a();
        HashMap hashMap = new HashMap();
        hashMap.put("title", bDn);
        hashMap.put("path", agVar2.nna);
        hashMap.put("webViewUrl", url);
        agVar2.a(aVar.L(hashMap), (int[]) null);
        i.a(str, agVar2.lBI, 4, "", Util.nowSecond(), 1, 0);
        AppMethodBeat.o(227166);
    }

    public g() {
        super(u.Fav.ordinal());
        AppMethodBeat.i(227165);
        AppMethodBeat.o(227165);
    }
}
