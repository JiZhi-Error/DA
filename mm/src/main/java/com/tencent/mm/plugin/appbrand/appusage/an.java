package com.tencent.mm.plugin.appbrand.appusage;

import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.b.a.lr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.d;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appcache.predownload.d.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.m.ae;
import com.tencent.mm.plugin.appbrand.page.bj;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public enum an {
    ;

    public static an valueOf(String str) {
        AppMethodBeat.i(44651);
        an anVar = (an) Enum.valueOf(an.class, str);
        AppMethodBeat.o(44651);
        return anVar;
    }

    static /* synthetic */ void w(String str, String str2, int i2) {
        AppMethodBeat.i(44655);
        v(str, str2, i2);
        AppMethodBeat.o(44655);
    }

    public static void t(final String str, final String str2, final int i2) {
        AppMethodBeat.i(44652);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.appusage.an.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(44649);
                if (!g.aAf().azp()) {
                    AppMethodBeat.o(44649);
                    return;
                }
                an.w(str, str2, i2);
                AppMethodBeat.o(44649);
            }
        }, "MicroMsg.AppBrand.RemoveUsageTask");
        AppMethodBeat.o(44652);
    }

    public static void u(String str, String str2, int i2) {
        AppMethodBeat.i(44653);
        v(str, str2, i2);
        AppMethodBeat.o(44653);
    }

    private static void v(String str, String str2, int i2) {
        AppMethodBeat.i(44654);
        Log.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl with username(%s) appId(%s) type(%d)", str, str2, Integer.valueOf(i2));
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44654);
            return;
        }
        n.buJ().bp(str, i2);
        ((k) n.W(k.class)).Wu(str);
        n.buU().gC(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = y.Xw(str);
        }
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(44654);
            return;
        }
        bi.bwz();
        com.tencent.mm.plugin.appbrand.task.h.bWb().cl(str2, i2);
        int aZ = n.buL().aZ(str2, i2);
        lr lrVar = new lr();
        lrVar.eZr = 1;
        lr yZ = lrVar.yZ(str2);
        yZ.eZs = (long) i2;
        yZ.eZt = (long) aZ;
        yZ.eZp = 1;
        yZ.bfK();
        n.buR().clear(str2);
        n.buS();
        bm.clear(str2);
        if (i2 == 0) {
            ((a) n.W(a.class)).gC(str2);
        }
        boolean aW = n.buL().aW(str2, 0);
        boolean aW2 = n.buL().aW(str2, 2);
        boolean aW3 = n.buL().aW(str2, 1);
        boolean bj = ((u) n.W(u.class)).bj(str, i2);
        Log.i("MicroMsg.AppBrand.RemoveUsageTask", "removeImpl, with username(%s) appId(%s) type(%d) hasRelease(%B), hasPreview(%B), hasDebug(%B), isCollection(%B)", str, str2, Integer.valueOf(i2), Boolean.valueOf(aW), Boolean.valueOf(aW2), Boolean.valueOf(aW3), Boolean.valueOf(bj));
        if (aW || aW2 || aW3) {
            ((b) n.W(b.class)).ct(str2, i2);
            if (!aW) {
                ((v) n.W(v.class)).Xq(str);
            }
        } else {
            WxaAttributes d2 = n.buC().d(str, "smallHeadURL", "bigHeadURL", "brandIconURL", "roundedSquareIconURL");
            if (d2 != null) {
                String[] strArr = {d2.field_smallHeadURL, d2.field_bigHeadURL, d2.field_brandIconURL, d2.field_roundedSquareIconURL};
                for (int i3 = 0; i3 < 4; i3++) {
                    String str3 = strArr[i3];
                    com.tencent.mm.modelappbrand.a.b.aXY().LJ(str3);
                    com.tencent.mm.modelappbrand.a.b.aXY().LK(str3);
                }
            }
            if (bj) {
                y.Xz(str);
            } else {
                n.buC().Xq(str);
            }
            ((b) n.W(b.class)).afy(str2);
            ((v) n.W(v.class)).Xq(str);
        }
        n.NK().VJ(str2);
        ((com.tencent.luggage.sdk.customize.a) e.M(com.tencent.luggage.sdk.customize.a.class)).dD(str2).VJ(str2);
        AppBrandStickyBannerLogic.b.cr(str2, i2);
        n.NL().WY(str2);
        n.buD().gC(str2);
        m.WY(str2);
        n.buG().gC(str2);
        JsApiOperateWXData.clear(str2);
        String string = p.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a) g.af(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Wp(str2));
        try {
            at.dt(string, str2).bxq();
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean NonFlatten appId=%s e=%s", str2, e2);
        }
        try {
            at.du(string, str2).bxq();
        } catch (Exception e3) {
            Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean OpenDataNonFlatten appId=%s e=%s", str2, e3);
        }
        try {
            at.dv(string, str2).bxq();
        } catch (Exception e4) {
            Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean ClientDataFlatten appId=%s e=%s", str2, e4);
        }
        try {
            at.dw(string, str2).bxq();
        } catch (Exception e5) {
            Log.e("MicroMsg.AppBrand.RemoveUsageTask", "clean SinglePageNotFlatten appId=%s e=%s", str2, e5);
        }
        AppBrandLocalMediaObjectManager.clear(str2);
        if (j.a.sE(i2)) {
            ((t) n.W(t.class)).A(str2, i2, "{}");
            ((d) n.W(d.class)).aN(str2, i2);
        }
        bj.a aVar = bj.ntu;
        o oVar = new o(bj.a.Mo());
        if (oVar.exists() && oVar.isDirectory()) {
            o[] het = oVar.het();
            for (o oVar2 : het) {
                if (oVar2.getName().startsWith(str2)) {
                    if (oVar2.isFile()) {
                        oVar2.delete();
                    } else {
                        s.dy(aa.z(oVar2.her()), true);
                    }
                }
            }
        }
        com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.cd(str2, i2);
        ae.WY(str2);
        ((com.tencent.mm.plugin.appbrand.appcache.b) n.W(com.tencent.mm.plugin.appbrand.appcache.b.class)).UO(str2);
        ((bp) g.af(bp.class)).UZ(str2);
        AppMethodBeat.o(44654);
    }
}
