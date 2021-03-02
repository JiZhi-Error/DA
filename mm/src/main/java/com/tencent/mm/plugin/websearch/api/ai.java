package com.tencent.mm.plugin.websearch.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.support.v4.content.b;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

public final class ai {
    private static Map<Integer, at> IEv;
    private static int IEw;

    public static Properties X(o oVar) {
        AppMethodBeat.i(117660);
        Properties properties = new Properties();
        if (oVar != null && oVar.isFile()) {
            InputStream inputStream = null;
            try {
                inputStream = s.ao(oVar);
                properties.load(inputStream);
                Util.qualityClose(inputStream);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e2, "", new Object[0]);
                Util.qualityClose(inputStream);
            } catch (Throwable th) {
                Util.qualityClose(inputStream);
                AppMethodBeat.o(117660);
                throw th;
            }
        }
        AppMethodBeat.o(117660);
        return properties;
    }

    public static final String afq(int i2) {
        AppMethodBeat.i(117661);
        StringBuilder append = new StringBuilder().append(i2).append("_");
        g.aAf();
        String sb = append.append(p.getString(a.getUin())).append("_").append(System.currentTimeMillis()).toString();
        AppMethodBeat.o(117661);
        return sb;
    }

    static {
        AppMethodBeat.i(117705);
        HashMap hashMap = new HashMap();
        IEv = hashMap;
        hashMap.put(3, new at("wxa/template", "wxa_template.zip", "wxa"));
        IEv.put(1, new at("topstory/template", "wrd_template.zip", "topstory"));
        IEv.put(0, new at("websearch/template", "fts_template.zip", "websearch"));
        IEv.put(2, new at("box/template", "box_template.zip", "box"));
        IEv.put(4, new at("scan_goods/template", "scan_goods_template.zip", "scan_goods"));
        IEv.put(5, new at("pardus/template", "pardus_template.zip", "pardus"));
        IEv.put(6, new at("tagsearch/template", "tsc_template.zip", "tagsearch"));
        IEv.put(7, new at("material_forward/template", "material_forward_template.zip", "material_forward"));
        IEv.put(8, new at("ocr/template", "ocr_template.zip", "ocr"));
        AppMethodBeat.o(117705);
    }

    public static at afr(int i2) {
        AppMethodBeat.i(117662);
        at atVar = IEv.get(Integer.valueOf(i2));
        AppMethodBeat.o(117662);
        return atVar;
    }

    public static int fXU() {
        AppMethodBeat.i(117663);
        String fYt = IEv.get(1).fYt();
        AssetManager assets = MMApplicationContext.getContext().getAssets();
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = assets.open(fYt);
            properties.load(inputStream);
            Util.qualityClose(inputStream);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e2, e2.getMessage(), new Object[0]);
            Util.qualityClose(inputStream);
        } catch (Throwable th) {
            Util.qualityClose(inputStream);
            AppMethodBeat.o(117663);
            throw th;
        }
        int intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
        AppMethodBeat.o(117663);
        return intValue;
    }

    public static boolean afs(int i2) {
        AppMethodBeat.i(117664);
        Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", Integer.valueOf(i2));
        if (IEv.get(Integer.valueOf(i2)).bbw() > 1) {
            AppMethodBeat.o(117664);
            return true;
        }
        AppMethodBeat.o(117664);
        return false;
    }

    public static int aft(int i2) {
        AppMethodBeat.i(117665);
        int bbw = IEv.get(Integer.valueOf(i2)).bbw();
        AppMethodBeat.o(117665);
        return bbw;
    }

    public static void afu(int i2) {
        IEw = i2;
    }

    public static int fXV() {
        return IEw;
    }

    public static String afv(int i2) {
        AppMethodBeat.i(187848);
        at atVar = IEv.get(Integer.valueOf(i2));
        String z = aa.z(new o(atVar.fYs(), atVar.IFx).her());
        AppMethodBeat.o(187848);
        return z;
    }

    public static String afw(int i2) {
        AppMethodBeat.i(117667);
        String fYs = IEv.get(Integer.valueOf(i2)).fYs();
        AppMethodBeat.o(117667);
        return fYs;
    }

    public static String fXW() {
        AppMethodBeat.i(187849);
        String property = X(new o(IEv.get(1).fYs(), "config_data.conf")).getProperty("kv_set", "");
        AppMethodBeat.o(187849);
        return property;
    }

    public static String ait() {
        AppMethodBeat.i(117669);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            AppMethodBeat.o(117669);
            return "wifi";
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(117669);
            return "4g";
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(117669);
            return "3g";
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(117669);
            return "2g";
        } else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            AppMethodBeat.o(117669);
            return "fail";
        } else {
            AppMethodBeat.o(117669);
            return "";
        }
    }

    public static chl clJ() {
        AppMethodBeat.i(117670);
        try {
            String str = (String) g.aAh().azQ().get(67591, (Object) null);
            if (str != null) {
                chl chl = new chl();
                String[] split = str.split(",");
                chl.LuT = Integer.valueOf(split[0]).intValue();
                chl.LuW = Integer.valueOf(split[1]).intValue();
                chl.LbD = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                chl.LbC = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", Float.valueOf(chl.LbD), Float.valueOf(chl.LbC));
                AppMethodBeat.o(117670);
                return chl;
            }
            Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
            AppMethodBeat.o(117670);
            return null;
        } catch (Exception e2) {
            Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", e2.getMessage());
            AppMethodBeat.o(117670);
            return null;
        }
    }

    private static Intent bi(Intent intent) {
        AppMethodBeat.i(117671);
        if (intent == null) {
            AppMethodBeat.o(117671);
            return null;
        }
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        intent.putExtra("neverGetA8Key", true);
        AppMethodBeat.o(117671);
        return intent;
    }

    public static Intent fXX() {
        AppMethodBeat.i(117672);
        Intent bi = bi(new Intent());
        AppMethodBeat.o(117672);
        return bi;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02ec, code lost:
        if (com.tencent.mm.plugin.websearch.api.ak.aXe("bizEntry").optInt("sugSwitch") == 1) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02ff, code lost:
        if (com.tencent.mm.plugin.websearch.api.ak.aXe("bizUnionTopEntry").optInt("sugSwitch") == 1) goto L_0x01a8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> a(int r10, boolean r11, int r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
        // Method dump skipped, instructions count: 844
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.api.ai.a(int, boolean, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.Map");
    }

    public static Map<String, String> h(int i2, boolean z, int i3) {
        AppMethodBeat.i(117674);
        Map<String, String> a2 = a(i2, z, i3, "");
        AppMethodBeat.o(117674);
        return a2;
    }

    public static Map<String, String> a(int i2, boolean z, int i3, String str) {
        AppMethodBeat.i(117675);
        Map<String, String> a2 = a(i2, z, i3, str, "");
        AppMethodBeat.o(117675);
        return a2;
    }

    private static Map<String, String> a(int i2, boolean z, int i3, String str, String str2) {
        AppMethodBeat.i(117676);
        Map<String, String> a2 = a(i2, z, i3, str, "", "", "", "", "", str2);
        AppMethodBeat.o(117676);
        return a2;
    }

    private static Map<String, String> a(int i2, boolean z, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(117677);
        Map<String, String> a2 = a(i2, z, i3, str, str2, str3, str4, str5, str6, str7, "");
        AppMethodBeat.o(117677);
        return a2;
    }

    public static boolean n(Activity activity, int i2) {
        AppMethodBeat.i(117678);
        try {
            if (b.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                try {
                    h.INSTANCE.a(15104, Integer.valueOf(i2), 2);
                    AppMethodBeat.o(117678);
                    return true;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e2, "", new Object[0]);
                }
            } else {
                h.INSTANCE.a(15104, Integer.valueOf(i2), 1);
                if (android.support.v4.app.a.a(activity, "android.permission.ACCESS_FINE_LOCATION")) {
                    Log.w("MicroMsg.WebSearch.WebSearchApiLogic", "has shown request permission and user denied, do not show agagin");
                    AppMethodBeat.o(117678);
                    return true;
                }
                Log.w("MicroMsg.WebSearch.WebSearchApiLogic", "showing request permission dialog");
                android.support.v4.app.a.a(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 73);
                AppMethodBeat.o(117678);
                return false;
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e3, "", new Object[0]);
            AppMethodBeat.o(117678);
            return true;
        }
    }

    public static void a(Context context, String str, Intent intent, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        String str8;
        AppMethodBeat.i(117679);
        if (context == null) {
            Log.e("MicroMsg.WebSearch.WebSearchApiLogic", "openNews intent is null, or context is null");
            AppMethodBeat.o(117679);
            return;
        }
        Intent bi = bi(intent);
        bi.putExtra("ftsbizscene", 21);
        bi.putExtra("ftsQuery", str);
        if (str2 != null) {
            bi.putExtra("title", str2);
        }
        bi.putExtra("isWebwx", str);
        bi.putExtra("ftscaneditable", false);
        bi.putExtra("key_load_js_without_delay", true);
        if (TextUtils.isEmpty(str5)) {
            str7 = afq(21);
        } else {
            str7 = str5;
        }
        if (TextUtils.isEmpty(str6)) {
            str8 = afq(21);
        } else {
            str8 = str6;
        }
        Map<String, String> a2 = a(21, false, 2, str3, str4, str7, str, "2", str8, "", "");
        if (!Util.isNullOrNil("")) {
            a2.put("redPointMsgId", "");
        }
        bi.putExtra("rawUrl", g(a2, 1));
        bi.putExtra("sessionId", str7);
        bi.putExtra("customize_status_bar_color", Color.parseColor("#F2F2F2"));
        bi.putExtra("status_bar_style", "black");
        c.b(context, "webview", ".ui.tools.fts.FTSWebViewUI", bi);
        AppMethodBeat.o(117679);
    }

    public static void fXY() {
        AppMethodBeat.i(117680);
        P(0, false);
        AppMethodBeat.o(117680);
    }

    public static void LW(long j2) {
        AppMethodBeat.i(117681);
        P(j2, false);
        AppMethodBeat.o(117681);
    }

    public static void fXZ() {
        AppMethodBeat.i(184552);
        P(0, true);
        AppMethodBeat.o(184552);
    }

    private static void P(long j2, boolean z) {
        AppMethodBeat.i(187850);
        com.tencent.f.h.RTc.a(new Runnable(true, z) {
            /* class com.tencent.mm.plugin.websearch.api.ai.AnonymousClass1 */
            final /* synthetic */ boolean IDa = true;
            final /* synthetic */ boolean IEx;

            {
                this.IEx = r3;
            }

            public final void run() {
                AppMethodBeat.i(117658);
                com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
                if (!com.tencent.mm.util.c.cnC()) {
                    AppMethodBeat.o(117658);
                } else if (d.oE(29)) {
                    AppMethodBeat.o(117658);
                } else {
                    String yO = ai.yO(this.IDa);
                    if (!TextUtils.isEmpty(yO)) {
                        an.fYj().w(yO, 4, this.IEx);
                    }
                    AppMethodBeat.o(117658);
                }
            }
        }, j2, "WebSearchThread");
        AppMethodBeat.o(187850);
    }

    public static void LX(long j2) {
        AppMethodBeat.i(187851);
        Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "preloadWxaSearch %s", Long.valueOf(j2));
        com.tencent.f.h.RTc.a(new Runnable() {
            /* class com.tencent.mm.plugin.websearch.api.ai.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(117659);
                com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
                if (!com.tencent.mm.util.c.cnC()) {
                    AppMethodBeat.o(117659);
                } else if (d.oE(29)) {
                    AppMethodBeat.o(117659);
                } else {
                    String fYa = ai.fYa();
                    if (!TextUtils.isEmpty(fYa)) {
                        an.fYj().w(fYa, 5, false);
                    }
                    AppMethodBeat.o(117659);
                }
            }
        }, j2, "WebSearchThread");
        AppMethodBeat.o(187851);
    }

    public static String fYa() {
        AppMethodBeat.i(187852);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", "-1");
        hashMap.put("type", "64");
        hashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        hashMap.put(TPDownloadProxyEnum.USER_PLATFORM, "android");
        hashMap.put("version", String.valueOf(IEv.get(3).bbw()));
        hashMap.put("isHomePage", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("isSug", "1");
        hashMap.put(DownloadInfo.NETTYPE, ait());
        hashMap.put("WASessionId", "");
        hashMap.put("sessionId", "");
        hashMap.put("subSessionId", "");
        hashMap.put("isPreload", "1");
        String g2 = g(hashMap, 3);
        AppMethodBeat.o(187852);
        return g2;
    }

    public static String bd(Map<String, String> map) {
        AppMethodBeat.i(258824);
        String g2 = g(map, 0);
        AppMethodBeat.o(258824);
        return g2;
    }

    public static String g(Map<String, String> map, int i2) {
        AppMethodBeat.i(117688);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        String fYs = afr(i2).fYs();
        map.put("isOpenPreload", "1");
        stringBuffer.append(fYs);
        if (map.size() > 0) {
            StringBuffer append = stringBuffer.append(FilePathGenerator.ANDROID_DIR_SEP);
            afr(i2);
            append.append("app.html?");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue());
                stringBuffer.append("&");
            }
            String str = map.get("sessionId");
            if (!map.containsKey("sessionId")) {
                str = afq(Util.safeParseInt(map.get("scene")));
                stringBuffer.append("sessionId");
                stringBuffer.append("=");
                stringBuffer.append(str);
                stringBuffer.append("&");
            }
            if (!map.containsKey("subSessionId")) {
                stringBuffer.append("subSessionId");
                stringBuffer.append("=");
                stringBuffer.append(str);
                stringBuffer.append("&");
            }
            stringBuffer.append("wechatVersion");
            stringBuffer.append("=");
            stringBuffer.append(com.tencent.mm.protocal.d.KyO);
            stringBuffer.append("&");
            String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
            AppMethodBeat.o(117688);
            return substring;
        }
        StringBuffer append2 = stringBuffer.append(FilePathGenerator.ANDROID_DIR_SEP);
        afr(i2);
        append2.append("app.html");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(117688);
        return stringBuffer2;
    }

    public static void f(Intent intent, int i2) {
        AppMethodBeat.i(117689);
        intent.putExtra("ftsbizscene", i2);
        Map<String, String> h2 = h(i2, false, 384);
        String afq = afq(Util.safeParseInt(h2.get("scene")));
        h2.put("sessionId", afq);
        intent.putExtra("sessionId", afq);
        intent.putExtra("rawUrl", g(h2, 0));
        intent.putExtra("ftsType", 384);
        AppMethodBeat.o(117689);
    }

    public static long aXb(String str) {
        AppMethodBeat.i(117690);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(117690);
            return 0;
        }
        long longValue = new BigInteger(str).longValue();
        Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "seq %s to snsId %d ", str, Long.valueOf(longValue));
        AppMethodBeat.o(117690);
        return longValue;
    }

    public static boolean LY(long j2) {
        AppMethodBeat.i(117691);
        Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "rec updateRedDotTimestamp %d", Long.valueOf(j2));
        g.aAh().azQ().set(ar.a.USERINFO_SEARCH_REDDOT_LONG, Long.valueOf(j2));
        AppMethodBeat.o(117691);
        return false;
    }

    public static boolean fYb() {
        AppMethodBeat.i(117692);
        JSONObject aXe = ak.aXe("snsContactMatch");
        if (aXe == null) {
            AppMethodBeat.o(117692);
            return false;
        } else if (aXe.optInt("matchSwitch") == 1) {
            AppMethodBeat.o(117692);
            return true;
        } else {
            AppMethodBeat.o(117692);
            return false;
        }
    }

    public static void a(String str, String str2, String str3, String str4, int i2, String str5, int i3, String str6, int i4, String str7, Map<String, String> map) {
        AppMethodBeat.i(187854);
        pu puVar = new pu();
        puVar.dVN.query = str4;
        puVar.dVN.sessionId = str2;
        puVar.dVN.dVO = str3;
        puVar.dVN.scene = i2;
        puVar.dVN.dVP = str;
        puVar.dVN.dVR = str5;
        puVar.dVN.dVS = i3;
        puVar.dVN.dVQ = str6;
        puVar.dVN.dVT = i4;
        puVar.dVN.dDL = str7;
        puVar.dVN.dVU = map;
        EventCenter.instance.publish(puVar);
        AppMethodBeat.o(187854);
    }

    public static void cM(int i2, String str) {
        AppMethodBeat.i(187855);
        pv pvVar = new pv();
        pvVar.dVV.scene = i2;
        pvVar.dVV.sessionId = str;
        EventCenter.instance.publish(pvVar);
        AppMethodBeat.o(187855);
    }

    public static int fYc() {
        AppMethodBeat.i(117695);
        JSONObject aXe = ak.aXe("snsContactMatch");
        if (aXe != null) {
            int optInt = aXe.optInt("queryUtfLenLimit");
            AppMethodBeat.o(117695);
            return optInt;
        }
        AppMethodBeat.o(117695);
        return 0;
    }

    public static String toUrlParams(Map<String, ? extends Object> map) {
        AppMethodBeat.i(117696);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            if (entry.getValue() != null) {
                stringBuffer.append(entry.getValue().toString());
            }
            stringBuffer.append("&");
        }
        String str = stringBuffer.substring(0, stringBuffer.length() - 1).toString();
        AppMethodBeat.o(117696);
        return str;
    }

    public static String N(Map<String, Object> map, String str) {
        AppMethodBeat.i(117697);
        if (!map.containsKey(str)) {
            AppMethodBeat.o(117697);
            return "";
        } else if (map.get(str) != null) {
            String obj = map.get(str).toString();
            AppMethodBeat.o(117697);
            return obj;
        } else {
            AppMethodBeat.o(117697);
            return "";
        }
    }

    public static boolean O(Map<String, Object> map, String str) {
        AppMethodBeat.i(117698);
        String N = N(map, str);
        if (Util.isNullOrNil(N)) {
            AppMethodBeat.o(117698);
            return false;
        }
        try {
            if ("1".equals(N)) {
                AppMethodBeat.o(117698);
                return true;
            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(N)) {
                AppMethodBeat.o(117698);
                return false;
            } else {
                boolean booleanValue = Boolean.valueOf(N).booleanValue();
                AppMethodBeat.o(117698);
                return booleanValue;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(117698);
            return false;
        }
    }

    public static int b(Map<String, Object> map, String str, int i2) {
        AppMethodBeat.i(117699);
        String N = N(map, str);
        if (Util.isNullOrNil(N)) {
            AppMethodBeat.o(117699);
        } else {
            try {
                i2 = Integer.valueOf(N).intValue();
                AppMethodBeat.o(117699);
            } catch (Exception e2) {
                AppMethodBeat.o(117699);
            }
        }
        return i2;
    }

    public static long a(Map<String, Object> map, String str, long j2) {
        AppMethodBeat.i(117700);
        String N = N(map, str);
        if (Util.isNullOrNil(N)) {
            AppMethodBeat.o(117700);
        } else {
            try {
                j2 = Long.valueOf(N).longValue();
                AppMethodBeat.o(117700);
            } catch (Exception e2) {
                AppMethodBeat.o(117700);
            }
        }
        return j2;
    }

    public static void e(Context context, String str, Intent intent) {
        AppMethodBeat.i(117701);
        try {
            String str2 = MMApplicationContext.getSourcePackageName() + ".plugin.topstory";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(MMApplicationContext.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(117701);
                return;
            }
            intent.addFlags(268435456);
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/websearch/api/WebSearchApiLogic", "startTopStoryActivity", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(117701);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", e2);
            AppMethodBeat.o(117701);
        }
    }

    private static void b(Context context, String str, Intent intent, int i2) {
        AppMethodBeat.i(117702);
        try {
            String str2 = MMApplicationContext.getSourcePackageName() + ".plugin.topstory";
            if (str.startsWith(".")) {
                str = str2 + str;
            }
            intent.setClassName(MMApplicationContext.getPackageName(), str);
            Class.forName(str, false, context.getClassLoader());
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, i2);
            }
            AppMethodBeat.o(117702);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebSearch.WebSearchApiLogic", "Class Not Found when startActivity %s", e2);
            AppMethodBeat.o(117702);
        }
    }

    private static boolean LZ(long j2) {
        return j2 == 100203;
    }

    public static void a(Activity activity, eit eit, int i2) {
        AppMethodBeat.i(117703);
        if (((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
            ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(activity);
            AppMethodBeat.o(117703);
            return;
        }
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", eit.toByteArray());
        } catch (IOException e2) {
        }
        if (LZ(eit.Nib)) {
            b(activity, ".ui.video.fs.TopStoryFSVideoUI", intent, i2);
            AppMethodBeat.o(117703);
            return;
        }
        b(activity, ".ui.video.list.TopStoryListVideoUI", intent, i2);
        AppMethodBeat.o(117703);
    }

    public static void a(Context context, eit eit, crq crq) {
        AppMethodBeat.i(187856);
        if (((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
            ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(context);
            AppMethodBeat.o(187856);
            return;
        }
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", eit.toByteArray());
            ach ach = new ach();
            ach.LmQ = crq;
            intent.putExtra("key_multi_task_common_info", ach.toByteArray());
        } catch (IOException e2) {
        }
        if (LZ(eit.Nib)) {
            e(context, ".ui.video.fs.TopStoryMultiTaskFSVideoUI", intent);
            AppMethodBeat.o(187856);
            return;
        }
        e(context, ".ui.video.list.TopStoryMultiTaskListVideoUI", intent);
        AppMethodBeat.o(187856);
    }

    public static void a(Context context, eit eit) {
        AppMethodBeat.i(117704);
        if (((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
            ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(context);
            AppMethodBeat.o(117704);
            return;
        }
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", eit.toByteArray());
        } catch (IOException e2) {
        }
        if (LZ(eit.Nib)) {
            e(context, ".ui.video.fs.TopStoryFSVideoUI", intent);
            AppMethodBeat.o(117704);
            return;
        }
        e(context, ".ui.video.list.TopStoryListVideoUI", intent);
        AppMethodBeat.o(117704);
    }

    public static void b(Context context, eit eit) {
        AppMethodBeat.i(187857);
        if (((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
            ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(context);
            AppMethodBeat.o(187857);
            return;
        }
        Intent intent = new Intent();
        try {
            intent.putExtra("key_context", eit.toByteArray());
        } catch (IOException e2) {
        }
        if (LZ(eit.Nib)) {
            b(context, ".ui.video.fs.TopStoryFSVideoUI", intent, 1);
            AppMethodBeat.o(187857);
            return;
        }
        b(context, ".ui.video.list.TopStoryListVideoUI", intent, 1);
        AppMethodBeat.o(187857);
    }

    public static aah fYd() {
        AppMethodBeat.i(187858);
        aah aah = new aah();
        aah.Llv = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
        if (aah.Llv) {
            aah.Lls = afx(((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvo());
            aah.Llt = afx(((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp());
            aah.Llu = afx(((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).dxW());
        }
        AppMethodBeat.o(187858);
        return aah;
    }

    private static int afx(int i2) {
        switch (i2) {
            case 0:
                return 3;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    public static String fYe() {
        AppMethodBeat.i(187859);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            AppMethodBeat.o(187859);
            return "wifi";
        } else if (isFreeSimCard()) {
            AppMethodBeat.o(187859);
            return "wangka";
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(187859);
            return "4g";
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(187859);
            return "3g";
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(187859);
            return "2g";
        } else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            AppMethodBeat.o(187859);
            return "fail";
        } else {
            AppMethodBeat.o(187859);
            return "";
        }
    }

    public static boolean isFreeSimCard() {
        boolean z;
        AppMethodBeat.i(187860);
        int eiV = ((com.tencent.mm.plugin.misc.a.a) g.af(com.tencent.mm.plugin.misc.a.a.class)).eiV();
        switch (eiV) {
            case 3:
            case 4:
            case 5:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        Log.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFreeSimCard result :%b simType: %d", Boolean.valueOf(z), Integer.valueOf(eiV));
        AppMethodBeat.o(187860);
        return z;
    }

    public static String yO(boolean z) {
        AppMethodBeat.i(117684);
        String afq = afq(-1);
        Map<String, String> h2 = h(-1, z, 0);
        h2.put("sessionId", afq);
        h2.put("inputMarginTop", "32");
        h2.put("inputMarginLeftRight", "24");
        h2.put("inputHeight", "48");
        h2.put("isPreload", "1");
        String g2 = g(h2, 0);
        AppMethodBeat.o(117684);
        return g2;
    }
}
