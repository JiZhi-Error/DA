package com.tencent.mm.plugin.address.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public static String a(b bVar) {
        AppMethodBeat.i(21057);
        JSONObject jSONObject = new JSONObject();
        if (bVar == null) {
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(21057);
            return jSONObject2;
        }
        try {
            jSONObject.put("type", bVar.type);
            if (bVar.type == null || !bVar.type.equals("1")) {
                jSONObject.put("title", bVar.title);
                if (bVar.ynR != null) {
                    jSONObject.put("taxNumber", bVar.ynR);
                } else {
                    jSONObject.put("taxNumber", "");
                }
                if (bVar.ynX != null) {
                    jSONObject.put("companyAddress", bVar.ynX);
                } else {
                    jSONObject.put("companyAddress", "");
                }
                if (bVar.ynV != null) {
                    jSONObject.put("telephone", bVar.ynV);
                } else {
                    jSONObject.put("telephone", "");
                }
                if (bVar.ynT != null) {
                    jSONObject.put("bankName", bVar.ynT);
                } else {
                    jSONObject.put("bankName", "");
                }
                if (bVar.ynS != null) {
                    jSONObject.put("bankAccount", bVar.ynS);
                } else {
                    jSONObject.put("bankAccount", "");
                }
                String jSONObject3 = jSONObject.toString();
                AppMethodBeat.o(21057);
                return jSONObject3;
            }
            jSONObject.put("title", bVar.ynQ);
            jSONObject.put("taxNumber", "");
            jSONObject.put("companyAddress", "");
            jSONObject.put("telephone", "");
            jSONObject.put("bankName", "");
            jSONObject.put("bankAccount", "");
            String jSONObject32 = jSONObject.toString();
            AppMethodBeat.o(21057);
            return jSONObject32;
        } catch (JSONException e2) {
            Log.e("MicroMsg.InvoiceUtil", "put json value error : %s", android.util.Log.getStackTraceString(e2));
        }
    }
}
