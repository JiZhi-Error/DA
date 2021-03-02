package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class g {
    private static g HWD;
    public String ANp;
    public int HWE = 0;
    private JSONObject HWF;

    public static g fQl() {
        AppMethodBeat.i(70243);
        if (HWD == null) {
            HWD = new g();
        }
        g gVar = HWD;
        AppMethodBeat.o(70243);
        return gVar;
    }

    public final void bC(JSONObject jSONObject) {
        AppMethodBeat.i(70244);
        this.HWF = jSONObject;
        try {
            if (this.HWF != null) {
                JSONObject optJSONObject = this.HWF.optJSONObject("bind_newcard_switch");
                this.HWE = optJSONObject.optInt("forbid_bind_card");
                this.ANp = optJSONObject.optString("forbid_word");
            } else {
                this.HWE = 0;
                this.ANp = "";
            }
        } catch (Exception e2) {
            this.HWE = 0;
            this.ANp = "";
            Log.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", e2, "", new Object[0]);
        }
        Log.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", this.HWF, Integer.valueOf(this.HWE), this.ANp);
        AppMethodBeat.o(70244);
    }

    public final boolean bJw() {
        AppMethodBeat.i(70245);
        if (this.HWE != 1 || Util.isNullOrNil(this.ANp)) {
            AppMethodBeat.o(70245);
            return false;
        }
        AppMethodBeat.o(70245);
        return true;
    }
}
