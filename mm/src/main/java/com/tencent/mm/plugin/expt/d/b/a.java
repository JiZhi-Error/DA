package com.tencent.mm.plugin.expt.d.b;

import android.util.Base64;
import com.facebook.GraphRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.a.b;
import com.tencent.mm.plugin.expt.d.e.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.commons.b.g;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public final b gl(String str, String str2) {
        AppMethodBeat.i(220294);
        if (g.eP(str) || g.eP(str2)) {
            AppMethodBeat.o(220294);
            return null;
        }
        Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig configID : " + str + ", json : " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("dataSourceType", 0);
            int optInt2 = jSONObject.optInt("dataSourceID", 0);
            int optInt3 = jSONObject.optInt("reportID", 0);
            int optInt4 = jSONObject.optInt("isInstantReport", 0);
            int optInt5 = jSONObject.optInt("isRepeat", 1);
            int optInt6 = jSONObject.optInt("runPeriod", 0);
            int optInt7 = jSONObject.optInt("dbExpireTime", 0);
            String optString = jSONObject.optString("scriptMD5", "");
            String optString2 = jSONObject.optString("script", "");
            JSONArray optJSONArray = jSONObject.optJSONArray(GraphRequest.FIELDS_PARAM);
            if (g.eP(optString2) || g.eP(optString)) {
                AppMethodBeat.o(220294);
                return null;
            }
            b bVar = new b();
            bVar.syg = str;
            bVar.syj = optInt;
            bVar.syk = optInt2;
            bVar.syl = optInt3;
            bVar.syn = optInt4;
            bVar.syo = optInt5;
            bVar.syp = optInt6;
            bVar.syq = optInt7;
            bVar.sys = optString;
            bVar.script = new String(Base64.decode(optString2, 0), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            bVar.syr = str2;
            bVar.sym = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                com.tencent.mm.plugin.expt.d.e.a.a aVar = new com.tencent.mm.plugin.expt.d.e.a.a();
                aVar.index = 0;
                aVar.name = "report_time_ec";
                aVar.type = 2;
                bVar.sym.add(aVar);
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    com.tencent.mm.plugin.expt.d.e.a.a aL = aL(optJSONArray.getJSONObject(i2));
                    if (aL != null) {
                        bVar.sym.add(aL);
                    }
                }
                Collections.sort(bVar.sym, new Comparator<com.tencent.mm.plugin.expt.d.e.a.a>() {
                    /* class com.tencent.mm.plugin.expt.d.b.a.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(com.tencent.mm.plugin.expt.d.e.a.a aVar, com.tencent.mm.plugin.expt.d.e.a.a aVar2) {
                        com.tencent.mm.plugin.expt.d.e.a.a aVar3 = aVar;
                        com.tencent.mm.plugin.expt.d.e.a.a aVar4 = aVar2;
                        if (aVar3.index > aVar4.index) {
                            return 1;
                        }
                        if (aVar3.index < aVar4.index) {
                            return -1;
                        }
                        return 0;
                    }
                });
            }
            com.tencent.mm.plugin.expt.d.f.a.lT(true);
            AppMethodBeat.o(220294);
            return bVar;
        } catch (Exception e2) {
            com.tencent.mm.plugin.expt.d.f.a.lT(false);
            Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptJsonConfig throw Exception : " + e2.getMessage() + ", json : " + str2);
            AppMethodBeat.o(220294);
            return null;
        }
    }

    private static com.tencent.mm.plugin.expt.d.e.a.a aL(JSONObject jSONObject) {
        AppMethodBeat.i(220295);
        if (jSONObject == null) {
            AppMethodBeat.o(220295);
            return null;
        }
        Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig fieldConfigJson : " + jSONObject.toString());
        try {
            int optInt = jSONObject.optInt(FirebaseAnalytics.b.INDEX, 0);
            String optString = jSONObject.optString("name", "");
            int optInt2 = jSONObject.optInt("type", 0);
            if (g.eP(optString)) {
                AppMethodBeat.o(220295);
                return null;
            }
            com.tencent.mm.plugin.expt.d.e.a.a aVar = new com.tencent.mm.plugin.expt.d.e.a.a();
            aVar.index = optInt;
            aVar.name = optString;
            aVar.type = optInt2;
            AppMethodBeat.o(220295);
            return aVar;
        } catch (Exception e2) {
            Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseScriptFieldConfig throw Exception : " + e2.getMessage() + ", fieldConfigJson : " + jSONObject.toString());
            AppMethodBeat.o(220295);
            return null;
        }
    }

    public static c gm(String str, String str2) {
        AppMethodBeat.i(220296);
        if (g.eP(str) || g.eP(str2)) {
            AppMethodBeat.o(220296);
            return null;
        }
        Log.d("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig configID : " + str + ", json : " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("reportID", 0);
            String optString = jSONObject.optString(SharePluginInfo.ISSUE_KEY_SQL, "");
            String optString2 = jSONObject.optString("dbPath", "");
            String optString3 = jSONObject.optString("sqlMD5", "");
            if (optInt <= 0 || g.eP(optString) || g.eP(optString3)) {
                AppMethodBeat.o(220296);
                return null;
            }
            c cVar = new c();
            cVar.syg = str;
            cVar.dbPath = optString2;
            cVar.sql = optString;
            cVar.syt = optString3;
            cVar.syl = optInt;
            cVar.syr = str2;
            com.tencent.mm.plugin.expt.d.f.a.lU(true);
            AppMethodBeat.o(220296);
            return cVar;
        } catch (Exception e2) {
            com.tencent.mm.plugin.expt.d.f.a.lU(false);
            Log.e("EdgeComputingConfigParser", "[EdgeComputingConfigParser] parseSqlJsonConfig throw Exception : " + e2.getMessage() + ", json : " + str2);
            AppMethodBeat.o(220296);
            return null;
        }
    }
}
