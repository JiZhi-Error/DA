package com.tencent.mm.plugin.webview.d;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.d;
import com.tencent.mm.plugin.appbrand.jsapi.ca;
import com.tencent.mm.plugin.appbrand.jsapi.i.p;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.share.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class r {
    private static Set<String> ISn = new HashSet();
    private static String ISo = "";
    private static String ISp = "";
    private static String nKc = "";

    static {
        AppMethodBeat.i(224438);
        AppMethodBeat.o(224438);
    }

    public static void a(Map<String, Object> map, boolean z, String str, String str2) {
        AppMethodBeat.i(224433);
        if (map != null) {
            map.put("fromMenu", Boolean.valueOf(z));
            map.put("keyParam", str);
            if (Util.isNullOrNil((String) map.get("appId"))) {
                map.put("appId", str2);
            }
        }
        AppMethodBeat.o(224433);
    }

    public static void a(f fVar) {
        AppMethodBeat.i(224434);
        boolean z = fVar == null;
        try {
            ISo = z ? "" : fVar.fWW();
            nKc = z ? "" : fVar.getCurrentUrl();
            ISp = z ? "" : fVar.fWX();
            AppMethodBeat.o(224434);
        } catch (Exception e2) {
            Log.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + e2.getMessage());
            AppMethodBeat.o(224434);
        }
    }

    public static void bd(String str, String str2, String str3) {
        ISo = str;
        nKc = str2;
        ISp = str3;
    }

    public static void P(String str, Map<String, Object> map) {
        String str2;
        AppMethodBeat.i(224435);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
            AppMethodBeat.o(224435);
            return;
        }
        boolean z = false;
        String str3 = null;
        String str4 = "";
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        String str5 = "";
        if (map != null) {
            z = Util.nullAsFalse((Boolean) map.get("fromMenu"));
            str3 = Util.nullAsNil((String) map.get("keyParam"));
            str4 = Util.nullAs((String) map.get("appId"), "");
            z2 = Util.nullAsFalse((Boolean) map.get("isSuccess"));
            i2 = Util.nullAsNil((Integer) map.get("permissionValue"));
            i3 = Util.nullAsNil((Integer) map.get("baseErrorCode"));
            i4 = Util.nullAsNil((Integer) map.get("jsapiErrorCode"));
            str5 = Util.nullAs((String) map.get("containerEnv"), "");
        }
        String bfG = z.bfG(Util.nullAsNil(ISo));
        String bfG2 = z.bfG(Util.nullAsNil(nKc));
        StringBuilder sb = new StringBuilder();
        sb.append(bfG);
        sb.append(",");
        sb.append(bfG2);
        sb.append(",");
        sb.append(ISp == null ? "" : ISp);
        sb.append(",");
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        sb.append(str2);
        sb.append(",");
        sb.append(z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        sb.append(",");
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(",");
        sb.append(str4);
        sb.append(",");
        sb.append(z2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        sb.append(",");
        sb.append(i2);
        if (!z2) {
            sb.append(",");
            sb.append(0);
            sb.append(",");
            sb.append(i3);
            sb.append(",");
            sb.append(i4);
        }
        String sb2 = sb.toString();
        Log.d("MicroMsg.WebViewSecurityUtil", "report: %s", sb2);
        h.INSTANCE.kvStat(10417, sb2);
        if (!Util.isNullOrNil(str5)) {
            h.INSTANCE.kvStat(18816, sb2);
        }
        if (aYp(str)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(bfG);
            sb3.append(",");
            sb3.append(bfG2);
            sb3.append(",");
            if (str == null) {
                str = "";
            }
            sb3.append(str);
            sb3.append(",");
            sb3.append(str4);
            sb3.append(",");
            sb3.append(z2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            String sb4 = sb3.toString();
            Log.d("MicroMsg.WebViewSecurityUtil", "report importantJsApi %s", sb4);
            h.INSTANCE.kvStat(17048, sb4);
            if (!Util.isNullOrNil(str5)) {
                h.INSTANCE.kvStat(18817, sb4);
            }
        }
        AppMethodBeat.o(224435);
    }

    public static boolean aYp(String str) {
        AppMethodBeat.i(224436);
        gbr();
        boolean contains = ISn.contains(str);
        AppMethodBeat.o(224436);
        return contains;
    }

    private static void gbr() {
        AppMethodBeat.i(224437);
        if (ISn.size() > 0) {
            AppMethodBeat.o(224437);
            return;
        }
        ISn.add("openUrlByExtBrowser");
        ISn.add("startVoipCall");
        ISn.add("getCurrentSSID");
        ISn.add("chooseVideo");
        ISn.add("uploadVideo");
        ISn.add("getOpenDeviceId");
        ISn.add("chooseIdCard");
        ISn.add("recordVideo");
        ISn.add(JsApiChooseMedia.NAME);
        ISn.add("requestWxFacePictureVerify");
        ISn.add("requestWxFacePictureVerifyUnionVideo");
        ISn.add(com.tencent.mm.plugin.appbrand.jsapi.autofill.f.NAME);
        ISn.add(JsApiGetInstallState.NAME);
        ISn.add(JsApiAddDownloadTask.NAME);
        ISn.add(JsApiCancelDownloadTask.NAME);
        ISn.add(JsApiQueryDownloadTask.NAME);
        ISn.add(JsApiInstallDownloadTask.NAME);
        ISn.add("launch3rdApp");
        ISn.add(JsApiPauseDownloadTask.NAME);
        ISn.add(JsApiResumeDownloadTask.NAME);
        ISn.add("launchApplication");
        ISn.add(JsApiAddDownloadTaskStraight.NAME);
        ISn.add(Scopes.PROFILE);
        ISn.add("addContact");
        ISn.add("jumpToBizProfile");
        ISn.add("startTempSession");
        ISn.add("quicklyAddBrandContact");
        ISn.add("openBizChat");
        ISn.add(l.NAME);
        ISn.add("sendAppMessage");
        ISn.add("sendServiceAppMessage");
        ISn.add("getSendC2CMessageRequest");
        ISn.add("shareQQ");
        ISn.add("selectSingleContact");
        ISn.add("sendAppMessageToSpecifiedContact");
        ISn.add("sendSingleAppMessage");
        ISn.add("openWeApp");
        ISn.add(com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.NAME);
        ISn.add("addCustomMenuItems");
        ISn.add("openUrlWithExtraWebview");
        ISn.add("enableFullScreen");
        ISn.add("openCustomWebview");
        ISn.add("openSpecificView");
        ISn.add("getBrandWCPayBindCardRequest");
        ISn.add("getTransferMoneyRequest");
        ISn.add("verifyWCPayPassword");
        ISn.add("getRecevieBizHongBaoRequest");
        ISn.add("getH5PrepayRequest");
        ISn.add("getH5TransactionRequest");
        ISn.add("getWebPayCheckoutCounterRequst");
        ISn.add("getWCPayRealnameVerify");
        ISn.add("unbindBankCard");
        ISn.add("idCardRealnameVerify");
        ISn.add("openLuckyMoneyDetailView");
        ISn.add("setWCPayPassword");
        ISn.add(ca.NAME);
        ISn.add(d.NAME);
        ISn.add("scanLicence");
        ISn.add(com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.NAME);
        ISn.add("getBrandWCPayRequest");
        ISn.add(com.tencent.mm.plugin.appbrand.jsapi.pay.l.NAME);
        ISn.add("editAddress");
        ISn.add("getLatestAddress");
        ISn.add(p.NAME);
        ISn.add(az.NAME);
        ISn.add("requireSoterBiometricAuthentication");
        ISn.add(bh.NAME);
        AppMethodBeat.o(224437);
    }
}
