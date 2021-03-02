package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lf;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class u {
    public String IaU;
    public String IaV;
    public String dQx;

    public static u bM(JSONObject jSONObject) {
        AppMethodBeat.i(70406);
        if (jSONObject == null) {
            AppMethodBeat.o(70406);
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("under_age_dialog");
            if (jSONObject2 == null) {
                AppMethodBeat.o(70406);
                return null;
            }
            u uVar = new u();
            uVar.dQx = jSONObject2.optString("wording");
            uVar.IaU = jSONObject2.optString("btn_cancel");
            uVar.IaV = jSONObject2.optString("btn_confirm");
            AppMethodBeat.o(70406);
            return uVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.UnderAgeDialog", "parseUnderAgeDialogFromJson Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(70406);
            return null;
        }
    }

    public static void xV(int i2) {
        AppMethodBeat.i(70407);
        lf lfVar = new lf();
        lfVar.ejA = (long) i2;
        lfVar.bfK();
        AppMethodBeat.o(70407);
    }
}
