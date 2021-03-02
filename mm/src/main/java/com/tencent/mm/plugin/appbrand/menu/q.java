package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.base.m;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import java.util.HashMap;

public final class q extends a<ag> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
        boolean z;
        boolean z2;
        String b2;
        boolean z3 = true;
        AppMethodBeat.i(227175);
        ag agVar2 = agVar;
        if (!ef(context)) {
            Log.i("MicroMsg.MenuDelegate_ShareToWeWork", "not support WeWork share api");
            AppMethodBeat.o(227175);
            return;
        }
        AppBrandSysConfigWC bsB = agVar2.getRuntime().bsB();
        if (bsB == null) {
            Log.e("MicroMsg.MenuDelegate_ShareToWeWork", "show query, config is null");
            z = false;
        } else {
            int a2 = com.tencent.mm.plugin.appbrand.config.a.ShareToWeWork.a(bsB);
            if (a2 != 1) {
                z = true;
            } else {
                z = false;
            }
            Log.i("MicroMsg.MenuDelegate_ShareToWeWork", "controlByte:%d, isShow:%b", Integer.valueOf(a2), Boolean.valueOf(z));
        }
        if (z) {
            AppBrandSysConfigWC bsB2 = agVar2.getRuntime().bsB();
            Context context2 = agVar2.getContext();
            if (bsB2 == null || context2 == null) {
                Log.e("MicroMsg.MenuDelegate_ShareToWeWork", "permission denied query, config or context is null");
                z2 = true;
            } else {
                int a3 = com.tencent.mm.plugin.appbrand.config.a.ShareToWeWork.a(bsB2);
                if (a3 == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Log.i("MicroMsg.MenuDelegate_ShareToWeWork", "controlByte:%d, forbidden:%b", Integer.valueOf(a3), Boolean.valueOf(z2));
            }
            boolean z4 = !o.g(agVar2);
            Log.i("MicroMsg.MenuDelegate_ShareToWeWork", "attachTo permissionDenied:%b, shareAppMsgDisable:%b", Boolean.valueOf(z2), Boolean.valueOf(z4));
            if (!WeChatBrands.AppInfo.current().isMainland()) {
                b2 = context.getString(R.string.j2v);
            } else {
                b2 = WWAPIFactory.ly(context).b(IWWAPI.WWAppType.WwAppTypeDefault);
            }
            int i2 = this.nfG;
            String string = context.getString(R.string.a25, b2);
            if ((!z2 && !z4) || bsB2 == null || bsB2.leE.kNW != 0) {
                z3 = false;
            }
            mVar.a(i2, string, R.raw.bottomsheet_icon_wework, 0, z3);
            AppMethodBeat.o(227175);
            return;
        }
        Log.i("MicroMsg.MenuDelegate_ShareToWeWork", "attachTo hide share wework menu!");
        AppMethodBeat.o(227175);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        String str2;
        AppMethodBeat.i(227174);
        ag agVar2 = agVar;
        i.a(str, agVar2.lBI, 43, "", Util.nowSecond(), 1, 0);
        Log.i("MicroMsg.MenuDelegate_ShareToWeWork", "performItemClick username：%s", agVar2.getRuntime().bsm());
        Log.i("MicroMsg.MenuDelegate_ShareToWeWork", "dispatchMenuShareAppMsgEventForWework username：%s", agVar2.getRuntime().bsm());
        AppBrandSysConfigWC bsB = agVar2.getRuntime().bsB();
        o.a aVar = new o.a();
        HashMap hashMap = new HashMap();
        hashMap.put("title", bsB.brandName);
        hashMap.put("desc", "");
        hashMap.put("path", agVar2.nna);
        com.tencent.mm.plugin.appbrand.jsapi.af.a bRM = agVar2.bRM();
        if (bRM != null) {
            str2 = bRM.getWebView().getUrl();
        } else {
            str2 = null;
        }
        hashMap.put("webViewUrl", str2);
        hashMap.put("imgUrl", bsB.jyi);
        hashMap.put("mode", tVar.lEi.JY("enable_share_with_share_ticket") ? "withShareTicket" : "common");
        hashMap.put("dynamic", Boolean.valueOf(tVar.lEi.JY("enable_share_dynamic")));
        hashMap.put(FirebaseAnalytics.b.ORIGIN, "qyweixin");
        tVar.lEi.H("user_clicked_share_btn", true);
        aVar.b(agVar2.getRuntime().bsE(), agVar2.getComponentId()).L(hashMap).bEo();
        AppMethodBeat.o(227174);
    }

    public q() {
        super(u.ShareToWork.ordinal());
        AppMethodBeat.i(227172);
        AppMethodBeat.o(227172);
    }

    public static boolean ef(Context context) {
        AppMethodBeat.i(227173);
        IWWAPI ly = WWAPIFactory.ly(context);
        if (!ly.a(IWWAPI.WWAppType.WwAppTypeDefault) || !ly.hrE()) {
            AppMethodBeat.o(227173);
            return false;
        }
        AppMethodBeat.o(227173);
        return true;
    }
}
