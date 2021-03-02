package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public String IcA;
    public boolean IcB;
    public int IcC;
    public Bankcard Icy;
    public String Icz;
    public boolean sPX;

    public static String bU(JSONObject jSONObject) {
        AppMethodBeat.i(70577);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("cvv_length", jSONObject.optInt("cvv_length"));
            jSONObject2.put("information", jSONObject.optString("information"));
            jSONObject2.put("verified", jSONObject.optBoolean("verified"));
            jSONObject2.put("card_expiry", jSONObject.optString("card_expiry"));
            jSONObject2.put("is_credit", jSONObject.optString("bank_type").equals("CREDITCARD_PAYU"));
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.BankcardPayUWrapper", e2, "", new Object[0]);
        }
        String jSONObject3 = jSONObject2.toString();
        AppMethodBeat.o(70577);
        return jSONObject3;
    }

    public b(Bankcard bankcard) {
        AppMethodBeat.i(70578);
        this.Icy = bankcard;
        try {
            JSONObject jSONObject = new JSONObject(this.Icy.field_ext_msg);
            this.Icz = jSONObject.optString("information");
            this.sPX = jSONObject.optBoolean("verified");
            this.IcA = jSONObject.optString("card_expiry");
            this.IcC = jSONObject.optInt("cvv_length");
            this.IcB = jSONObject.optBoolean("is_credit");
            AppMethodBeat.o(70578);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.BankcardPayUWrapper", e2, "", new Object[0]);
            AppMethodBeat.o(70578);
        }
    }
}
