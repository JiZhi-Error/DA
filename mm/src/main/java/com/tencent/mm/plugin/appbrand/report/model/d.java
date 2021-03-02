package com.tencent.mm.plugin.appbrand.report.model;

import android.content.Intent;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.openmaterial.model.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    public static void a(q qVar, JSONObject jSONObject) {
        AppMethodBeat.i(48109);
        try {
            if (j.a.sE(qVar.bsC().eix) && !TextUtils.isEmpty(qVar.bsC().ldS)) {
                jSONObject.put("debugLaunchInfo", new JSONObject(qVar.bsC().ldS));
            }
            AppMethodBeat.o(48109);
        } catch (JSONException e2) {
            Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillDebugLaunchInfo ex = %s", e2);
            AppMethodBeat.o(48109);
        }
    }

    public static void b(q qVar, JSONObject jSONObject) {
        AppMethodBeat.i(48110);
        try {
            c(qVar, jSONObject);
            jSONObject.put("referpagepath", d(qVar.bsC().cys));
            jSONObject.put("clickTimestamp", qVar.bsC().startTime);
            AppMethodBeat.o(48110);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", e2);
            AppMethodBeat.o(48110);
        }
    }

    private static String F(q qVar) {
        AppMethodBeat.i(227381);
        if (qVar.bsC().kHL.isEnable()) {
            AppMethodBeat.o(227381);
            return "halfPage";
        } else if (bb.r(qVar)) {
            AppMethodBeat.o(227381);
            return "singlePage";
        } else {
            AppMethodBeat.o(227381);
            return BuildConfig.KINDA_DEFAULT;
        }
    }

    public static void c(q qVar, JSONObject jSONObject) {
        int i2 = 0;
        AppMethodBeat.i(48111);
        jSONObject.put("scene", qVar.ON().cyA.scene);
        jSONObject.put("scene_note", qVar.ON().cyA.dCw);
        jSONObject.put("sessionId", qVar.bsC().cym);
        jSONObject.put("usedState", qVar.ON().cyA.nHt);
        jSONObject.put("prescene", qVar.ON().cyA.ecU);
        jSONObject.put("prescene_note", qVar.ON().cyA.ecV);
        String str = qVar.bsC().kHG;
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("chatroomUsername", str);
        }
        String str2 = qVar.bsC().kHQ;
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("shortLink", str2);
        }
        if (!TextUtils.isEmpty(qVar.bsC().ldR)) {
            String str3 = qVar.bsC().ldR;
            if (1173 == qVar.ON().cyA.scene) {
                str3 = a(qVar, str3);
            }
            try {
                jSONObject.put("nativeExtraData", new JSONObject(str3));
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", e2, "", new Object[0]);
            }
        }
        PersistableBundle persistableBundle = qVar.bsC().ldQ;
        if (persistableBundle != null && persistableBundle.size() > 0) {
            try {
                jSONObject.put("transitExtraData", e.a(qVar.bsC().ldQ));
            } catch (JSONException e3) {
                Log.printErrStackTrace("MicroMsg.AppBrandPageVisitStatisticsHelper", e3, "", new Object[0]);
            }
        }
        if (!j.a.sE(qVar.bsC().eix)) {
            i2 = qVar.bsC().appVersion;
        }
        jSONObject.put("appversion", i2);
        jSONObject.put("mode", F(qVar));
        AppMethodBeat.o(48111);
    }

    private static String a(q qVar, String str) {
        String str2;
        AppMethodBeat.i(227382);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(227382);
            return str;
        }
        a adn = a.adn(str);
        if (adn == null) {
            AppMethodBeat.o(227382);
            return str;
        }
        String trim = adn.nlI.trim();
        Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, originMaterialPath: ".concat(String.valueOf(trim)));
        if (trim.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || trim.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            AppMethodBeat.o(227382);
            return str;
        }
        String str3 = adn.mimeType;
        if (str3.startsWith("image") || str3.startsWith("video")) {
            str2 = "";
        } else {
            str2 = org.apache.commons.a.d.getName(trim);
        }
        String extension = org.apache.commons.a.d.getExtension(trim);
        o oVar = new o(trim);
        int length = (int) oVar.length();
        Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, fileName: %s, fileExt: %s，fileSize: %d", str2, extension, Integer.valueOf(length));
        i<String> iVar = new i<>();
        m a2 = qVar.OK().a(oVar, extension, false, iVar);
        Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, result: ".concat(String.valueOf(a2)));
        if (m.OK != a2) {
            AppMethodBeat.o(227382);
            return str;
        }
        T t = iVar.value;
        Log.d("MicroMsg.AppBrandPageVisitStatisticsHelper", "preProcessNativeExtraData4OpenMaterial, newMaterialPath: ".concat(String.valueOf(t)));
        String bua = new a(str3, t, str2, length).bua();
        AppMethodBeat.o(227382);
        return bua;
    }

    public static Pair<Integer, String> t(ag agVar) {
        String str;
        String className;
        int i2 = 7;
        AppMethodBeat.i(48112);
        switch (h.Uc(agVar.getAppId())) {
            case CLOSE:
                i2 = agVar.nrs.isLoading() ? 4 : 3;
                str = null;
                break;
            case BACK:
                if (agVar.nrs.isLoading()) {
                    i2 = 5;
                }
                str = null;
                break;
            case HANG:
                i2 = 6;
                str = null;
                break;
            case LAUNCH_MINI_PROGRAM:
                i2 = 9;
                str = p.Um(agVar.getAppId()).kCT + ":" + com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(p.Um(agVar.getAppId()).kCU));
                break;
            default:
                Intent bOA = u(agVar).bOA();
                if (bOA == null) {
                    str = null;
                    break;
                } else {
                    if (bOA.getComponent() == null) {
                        className = "";
                        Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", bOA);
                    } else {
                        className = bOA.getComponent().getClassName();
                    }
                    if (!className.contains("WebViewUI") && !className.contains("WebviewMpUI")) {
                        str = Util.nullAs(IntentUtil.getStringExtra(bOA, AppBrandProcessProxyUI.lwf), className);
                        i2 = 8;
                        break;
                    } else {
                        i2 = 10;
                        str = IntentUtil.getStringExtra(bOA, AppBrandProcessProxyUI.lwe);
                        break;
                    }
                }
                break;
        }
        Pair<Integer, String> create = Pair.create(Integer.valueOf(i2), str);
        AppMethodBeat.o(48112);
        return create;
    }

    private static f u(ag agVar) {
        AppMethodBeat.i(48113);
        f reporter = agVar.getRuntime().bsD().getReporter();
        AppMethodBeat.o(48113);
        return reporter;
    }

    public static String d(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        if (appBrandLaunchReferrer == null) {
            return null;
        }
        if (1 == appBrandLaunchReferrer.leo || 3 == appBrandLaunchReferrer.leo) {
            return appBrandLaunchReferrer.appId;
        }
        if (2 == appBrandLaunchReferrer.leo) {
            return appBrandLaunchReferrer.url;
        }
        return "";
    }
}
