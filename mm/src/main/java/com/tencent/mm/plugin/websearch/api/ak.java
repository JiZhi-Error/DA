package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aas;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.faq;
import com.tencent.mm.protocal.protobuf.far;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak {
    private static HashMap<String, ar.a> IEM = new HashMap<>();
    private static Map<String, JSONObject> IEN = new HashMap();
    private static ab IEO;
    private static HashMap<String, Long> IEP;
    private static String IEQ = "";
    private static i gNh = new i() {
        /* class com.tencent.mm.plugin.websearch.api.ak.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(117709);
            Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (qVar instanceof ab) {
                g.azz().b(1948, ak.gNh);
                aas aas = new aas();
                if (i2 == 0 && i3 == 0) {
                    ab abVar = (ab) qVar;
                    far far = abVar.IEh;
                    faq faq = abVar.IEg;
                    Log.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", far.MaZ);
                    if (ak.lJ(faq.rBI, far.MaZ) == a.Valid) {
                        aas.ehH.result = 0;
                    } else {
                        aas.ehH.result = -1;
                    }
                } else {
                    aas.ehH.result = -1;
                }
                EventCenter.instance.publish(aas);
            }
            AppMethodBeat.o(117709);
        }
    };

    static /* synthetic */ a lJ(String str, String str2) {
        AppMethodBeat.i(117721);
        a lI = lI(str, str2);
        AppMethodBeat.o(117721);
        return lI;
    }

    static {
        AppMethodBeat.i(117722);
        IEM.put(LocaleUtil.CHINA, ar.a.USERINFO_WEB_SEARCH_CONFIG_ZH_CN_STRING);
        IEM.put(LocaleUtil.HONGKONG, ar.a.USERINFO_WEB_SEARCH_CONFIG_ZH_HK_STRING);
        IEM.put(LocaleUtil.TAIWAN, ar.a.USERINFO_WEB_SEARCH_CONFIG_ZH_TW_STRING);
        IEM.put(LocaleUtil.ENGLISH, ar.a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING);
        IEM.put(LocaleUtil.ARABIC, ar.a.USERINFO_WEB_SEARCH_CONFIG_AR_STRING);
        IEM.put(LocaleUtil.GERMAN, ar.a.USERINFO_WEB_SEARCH_CONFIG_DE_STRING);
        IEM.put("de_DE", ar.a.USERINFO_WEB_SEARCH_CONFIG_DE_DE_STRING);
        IEM.put(LocaleUtil.SPANISH, ar.a.USERINFO_WEB_SEARCH_CONFIG_ES_STRING);
        IEM.put(LocaleUtil.FRENCH, ar.a.USERINFO_WEB_SEARCH_CONFIG_FR_STRING);
        IEM.put("he", ar.a.USERINFO_WEB_SEARCH_CONFIG_HE_STRING);
        IEM.put("hi", ar.a.USERINFO_WEB_SEARCH_CONFIG_HI_STRING);
        IEM.put("id", ar.a.USERINFO_WEB_SEARCH_CONFIG_ID_STRING);
        IEM.put(LocaleUtil.INDONESIAN_NEWNAME, ar.a.USERINFO_WEB_SEARCH_CONFIG_IN_STRING);
        IEM.put(LocaleUtil.ITALIAN, ar.a.USERINFO_WEB_SEARCH_CONFIG_IT_STRING);
        IEM.put("iw", ar.a.USERINFO_WEB_SEARCH_CONFIG_IW_STRING);
        IEM.put(LocaleUtil.JAPANESE, ar.a.USERINFO_WEB_SEARCH_CONFIG_JA_STRING);
        IEM.put(LocaleUtil.KOREAN, ar.a.USERINFO_WEB_SEARCH_CONFIG_KO_STRING);
        IEM.put(LocaleUtil.LAO, ar.a.USERINFO_WEB_SEARCH_CONFIG_LO_STRING);
        IEM.put(LocaleUtil.MALAY, ar.a.USERINFO_WEB_SEARCH_CONFIG_MS_STRING);
        IEM.put(LocaleUtil.MYANMAR, ar.a.USERINFO_WEB_SEARCH_CONFIG_MY_STRING);
        IEM.put("pl", ar.a.USERINFO_WEB_SEARCH_CONFIG_PL_STRING);
        IEM.put(LocaleUtil.PORTUGUESE, ar.a.USERINFO_WEB_SEARCH_CONFIG_PT_STRING);
        IEM.put(LocaleUtil.RUSSIAN, ar.a.USERINFO_WEB_SEARCH_CONFIG_RU_STRING);
        IEM.put(LocaleUtil.THAI, ar.a.USERINFO_WEB_SEARCH_CONFIG_TH_STRING);
        IEM.put(LocaleUtil.TURKEY, ar.a.USERINFO_WEB_SEARCH_CONFIG_TR_STRING);
        IEM.put(LocaleUtil.VIETNAMESE, ar.a.USERINFO_WEB_SEARCH_CONFIG_VI_STRING);
        AppMethodBeat.o(117722);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean bq(int r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.api.ak.bq(int, boolean):boolean");
    }

    public enum a {
        Valid,
        Expired,
        Invalid;

        public static a valueOf(String str) {
            AppMethodBeat.i(117711);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(117711);
            return aVar;
        }

        static {
            AppMethodBeat.i(117712);
            AppMethodBeat.o(117712);
        }
    }

    private static JSONObject aXc(String str) {
        AppMethodBeat.i(117714);
        if (!IEN.containsKey(str) || IEN.get(str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                IEN.put(str, jSONObject);
                AppMethodBeat.o(117714);
                return jSONObject;
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e2, "", new Object[0]);
                AppMethodBeat.o(117714);
                return null;
            }
        } else {
            JSONObject jSONObject2 = IEN.get(str);
            AppMethodBeat.o(117714);
            return jSONObject2;
        }
    }

    private static ar.a aXd(String str) {
        AppMethodBeat.i(117715);
        ar.a aVar = IEM.get(str);
        if (aVar == null) {
            aVar = ar.a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING;
        }
        AppMethodBeat.o(117715);
        return aVar;
    }

    private static a lI(String str, String str2) {
        AppMethodBeat.i(117716);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put(ch.COL_UPDATETIME, System.currentTimeMillis());
            String jSONObject2 = jSONObject.toString();
            g.aAh().azQ().set(aXd(str), jSONObject2);
            try {
                IEN.put(jSONObject2, new JSONObject(jSONObject2));
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e2, "", new Object[0]);
            }
            a aVar = a.Valid;
            AppMethodBeat.o(117716);
            return aVar;
        } catch (JSONException e3) {
            a aVar2 = a.Invalid;
            AppMethodBeat.o(117716);
            return aVar2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x003f A[SYNTHETIC, Splitter:B:6:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject aXe(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.api.ak.aXe(java.lang.String):org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0034 A[SYNTHETIC, Splitter:B:6:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String aXf(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 130
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.api.ak.aXf(java.lang.String):java.lang.String");
    }

    private static String fYf() {
        InputStream inputStream;
        Throwable th;
        Exception e2;
        String str = null;
        AppMethodBeat.i(117719);
        try {
            inputStream = MMApplicationContext.getContext().getAssets().open("webconfig/default.".concat(String.valueOf(LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()))));
            try {
                str = Util.streamToString(inputStream);
                Util.qualityClose(inputStream);
            } catch (Exception e3) {
                e2 = e3;
                try {
                    Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e2, e2.getMessage(), new Object[0]);
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(117719);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(117719);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            inputStream = null;
            Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchConfigLogic", e2, e2.getMessage(), new Object[0]);
            Util.qualityClose(inputStream);
            AppMethodBeat.o(117719);
            return str;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            Util.qualityClose(inputStream);
            AppMethodBeat.o(117719);
            throw th;
        }
        AppMethodBeat.o(117719);
        return str;
    }

    public static String aXg(String str) {
        AppMethodBeat.i(117720);
        JSONObject aXe = aXe("entranceWording");
        if (aXe != null) {
            String optString = aXe.optString(str);
            AppMethodBeat.o(117720);
            return optString;
        }
        AppMethodBeat.o(117720);
        return null;
    }
}
