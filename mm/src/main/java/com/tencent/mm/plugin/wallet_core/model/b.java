package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public double Cpd = 0.0d;
    public String HVg;
    public LinkedList<C1916b> HVh;
    public String HVi;
    public String HVj;
    public a HVk;
    public int Hvm = 0;
    public int Hvn = 0;
    public int Hvo = 0;
    public double Hvp = 0.0d;

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.b$b  reason: collision with other inner class name */
    public static class C1916b {
        public String key;
        public String value;
    }

    public static class c {
        public String desc;
        public String iwv;
        public String pTL;
        public String path;
        public String title;
        public int uSc;
        public String username;
    }

    public static a bz(JSONObject jSONObject) {
        AppMethodBeat.i(70212);
        a aVar = new a();
        if (jSONObject != null) {
            try {
                aVar.HVl = jSONObject.optString("sector_title", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("label");
                if (optJSONArray != null) {
                    aVar.HVm = new c[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        c cVar = new c();
                        cVar.title = jSONObject2.optString("title", "");
                        cVar.desc = jSONObject2.optString("desc", "");
                        cVar.iwv = jSONObject2.optString("logo_url", "");
                        cVar.uSc = jSONObject2.optInt("jump_type");
                        cVar.pTL = jSONObject2.optString("jump_url", "");
                        cVar.username = jSONObject2.optString(ch.COL_USERNAME, "");
                        cVar.path = jSONObject2.optString("path", "");
                        aVar.HVm[i2] = cVar;
                    }
                }
            } catch (JSONException e2) {
            }
        }
        AppMethodBeat.o(70212);
        return aVar;
    }

    public static class a {
        public String HVl = "";
        public c[] HVm = new c[0];

        public a() {
            AppMethodBeat.i(70211);
            AppMethodBeat.o(70211);
        }
    }
}
