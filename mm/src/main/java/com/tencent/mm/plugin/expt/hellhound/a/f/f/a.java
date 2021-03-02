package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.d;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class a {
    static void f(cbo cbo) {
        AppMethodBeat.i(122215);
        if (!com.tencent.mm.plugin.expt.hellhound.a.cNo() || b.getUin() == 0) {
            AppMethodBeat.o(122215);
            return;
        }
        String g2 = g(cbo);
        if (TextUtils.isEmpty(g2)) {
            AppMethodBeat.o(122215);
            return;
        }
        Log.i("HABBYGE-MALI.AsyncBizReport", "doReport: %s", g2);
        d.aV(17648, g2);
        AppMethodBeat.o(122215);
    }

    private static JSONArray w(JSONArray jSONArray) {
        int length;
        AppMethodBeat.i(122217);
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            AppMethodBeat.o(122217);
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        List<String> cQj = com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cQj();
        if (cQj == null || cQj.isEmpty()) {
            Log.e("HABBYGE-MALI.AsyncBizReport", "AsyncBizReport, filterBySessionPage, bizIdOfCloudConfig is NULL !!");
            AppMethodBeat.o(122217);
            return null;
        }
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("businessId");
                if (!TextUtils.isEmpty(optString)) {
                    e.cQg();
                    if (!e.cQc() || cQj.contains(optString)) {
                        jSONArray2.put(optJSONObject);
                        cQj.remove(optString);
                    }
                }
            }
        }
        if (jSONArray2.length() > 0) {
            if (cQj == null || cQj.isEmpty()) {
                int uin = b.getUin();
                if (uin != 0) {
                    com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_async_bizid_sid".concat(String.valueOf(uin)), new byte[0]);
                }
            } else {
                com.tencent.mm.plugin.expt.hellhound.a.f.c.a.dq(cQj);
                com.tencent.mm.plugin.expt.hellhound.a.f.c.a.dr(cQj);
            }
        }
        AppMethodBeat.o(122217);
        return jSONArray2;
    }

    private static String g(cbo cbo) {
        JSONArray jSONArray;
        String str = null;
        AppMethodBeat.i(122216);
        try {
            String aqJ = d.aqJ(com.tencent.mm.plugin.expt.hellhound.a.f.c.a.cQi());
            if (TextUtils.isEmpty(aqJ) || "-1".equals(aqJ)) {
                jSONArray = null;
            } else {
                jSONArray = new JSONArray(aqJ);
            }
            JSONArray w = w(jSONArray);
            if (w == null || w.length() <= 0) {
                AppMethodBeat.o(122216);
                return str;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tbe", cbo.Mhp);
                long j2 = cbo.Mhq - cbo.Mhp;
                if (j2 <= 0) {
                    j2 = 0;
                }
                jSONObject.put(LocaleUtil.INDONESIAN_NEWNAME, j2);
                jSONObject.put("vv", "2.0");
                jSONObject.put("content", w);
                str = jSONObject.toString();
                AppMethodBeat.o(122216);
            } catch (JSONException e2) {
                Log.printErrStackTrace("HABBYGE-MALI.AsyncBizReport", e2, "AsyncBizReport, toJsons: %s", e2.getMessage());
                AppMethodBeat.o(122216);
            }
            return str;
        } catch (JSONException e3) {
            Log.printErrStackTrace("HABBYGE-MALI.AsyncBizReport", e3, "AsyncBizReport, getParamsJSONArray: %s", e3.getMessage());
            AppMethodBeat.o(122216);
        }
    }
}
