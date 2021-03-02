package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.af.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import java.util.HashMap;

public final class o extends com.tencent.mm.plugin.appbrand.menu.a.a<ag> {

    public static final class a extends s {
        private static final int CTRL_INDEX = 75;
        public static final String NAME = "onShareAppMessage";
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        AppMethodBeat.i(47658);
        ag agVar2 = agVar;
        AppBrandSysConfigWC bsB = agVar2.getRuntime().bsB();
        if (bsB == null || com.tencent.mm.plugin.appbrand.config.a.ShareToFriend.a(bsB) != 1) {
            if (!g(agVar2) || e.dE(context)) {
                mVar.a(this.nfG, (CharSequence) context.getString(R.string.a23), R.raw.appbrand_menu_share_appmsg, 0, true);
                AppMethodBeat.o(47658);
                return;
            }
            mVar.a(this.nfG, context.getString(R.string.a23), R.raw.appbrand_menu_share_appmsg, 0);
        }
        AppMethodBeat.o(47658);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* bridge */ /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(47657);
        a(context, agVar, str, tVar);
        AppMethodBeat.o(47657);
    }

    public o() {
        super(u.ShareAppMsg.ordinal());
        AppMethodBeat.i(47652);
        AppMethodBeat.o(47652);
    }

    public static boolean g(ag agVar) {
        AppMethodBeat.i(47653);
        AppBrandSysConfigWC bsB = agVar.getRuntime().bsB();
        if (bsB != null && bsB.leE.kNW == 0 && com.tencent.mm.plugin.appbrand.config.a.ShareToFriend.a(bsB) == 2) {
            AppMethodBeat.o(47653);
            return false;
        } else if (!agVar.yK(u.ShareAppMsg.ordinal()).neT) {
            AppMethodBeat.o(47653);
            return true;
        } else {
            AppMethodBeat.o(47653);
            return false;
        }
    }

    static void a(ag agVar, t tVar) {
        AppMethodBeat.i(47655);
        AppBrandSysConfigWC bsB = agVar.getRuntime().bsB();
        a aVar = new a();
        HashMap hashMap = new HashMap();
        hashMap.put("title", bsB.brandName);
        hashMap.put("desc", "");
        hashMap.put("path", agVar.nna);
        hashMap.put("webViewUrl", h(agVar));
        hashMap.put("imgUrl", bsB.jyi);
        hashMap.put("mode", tVar.lEi.JY("enable_share_with_share_ticket") ? "withShareTicket" : "common");
        hashMap.put("dynamic", Boolean.valueOf(tVar.lEi.JY("enable_share_dynamic")));
        hashMap.put(FirebaseAnalytics.b.ORIGIN, "weixin");
        tVar.lEi.H("user_clicked_share_btn", true);
        aVar.b(agVar.getRuntime().bsE(), agVar.getComponentId()).L(hashMap).bEo();
        AppMethodBeat.o(47655);
    }

    private static String h(ag agVar) {
        AppMethodBeat.i(47656);
        com.tencent.mm.plugin.appbrand.jsapi.af.a bRM = agVar.bRM();
        if (bRM != null) {
            String url = bRM.getWebView().getUrl();
            AppMethodBeat.o(47656);
            return url;
        }
        AppMethodBeat.o(47656);
        return null;
    }

    public final void a(Context context, final ag agVar, final String str, final t tVar) {
        AppMethodBeat.i(47654);
        i.a(str, agVar.lBI, 39, "", Util.nowSecond(), 1, 0);
        if (g.an(agVar.getRuntime())) {
            a(agVar, tVar);
            AppMethodBeat.o(47654);
            return;
        }
        AppBrandSysConfigWC bsB = agVar.getRuntime().bsB();
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(context, "pref_appbrand_" + agVar.getRuntime().bsC().uin, 4);
        if (bsB.leE.kNW == 1 && !sharedPreferences.contains("has_share_dev_tips")) {
            sharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
            h.a(context, (int) R.string.l_, (int) R.string.zb, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.menu.o.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(47650);
                    o.a(agVar, tVar);
                    AppMethodBeat.o(47650);
                }
            });
            AppMethodBeat.o(47654);
        } else if (bsB.leE.kNW != 2 || sharedPreferences.contains("has_share_beta_tips")) {
            a(agVar, tVar);
            AppMethodBeat.o(47654);
        } else {
            sharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
            h.a(context, (int) R.string.l9, (int) R.string.zb, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.menu.o.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(47651);
                    o.a(agVar, tVar);
                    AppMethodBeat.o(47651);
                }
            });
            AppMethodBeat.o(47654);
        }
    }
}
