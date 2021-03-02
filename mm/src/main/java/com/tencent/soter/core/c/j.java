package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {
    private long RPO = -1;
    public String RPS = null;
    private String RPT = "";
    private String RPU = "";
    private String RPV = "";
    private String RPW = "";
    private String RPX = "";
    public int RPY = 20;
    public String RPZ = "";
    private String rawValue = null;
    public String signature = "";

    public final String toString() {
        AppMethodBeat.i(88676);
        String str = "SoterSignatureResult{rawValue='" + this.rawValue + '\'' + ", fid='" + this.RPS + '\'' + ", counter=" + this.RPO + ", TEEName='" + this.RPT + '\'' + ", TEEVersion='" + this.RPU + '\'' + ", FpName='" + this.RPV + '\'' + ", FpVersion='" + this.RPW + '\'' + ", cpuId='" + this.RPX + '\'' + ", saltLen=" + this.RPY + ", jsonValue='" + this.RPZ + '\'' + ", signature='" + this.signature + '\'' + '}';
        AppMethodBeat.o(88676);
        return str;
    }

    public static j bql(String str) {
        AppMethodBeat.i(88677);
        try {
            JSONObject jSONObject = new JSONObject(str);
            j jVar = new j();
            jVar.RPZ = str;
            jVar.rawValue = jSONObject.optString(ShareConstants.DEXMODE_RAW);
            jVar.RPS = jSONObject.optString("fid");
            jVar.RPO = jSONObject.optLong("counter");
            jVar.RPT = jSONObject.optString("tee_n");
            jVar.RPU = jSONObject.optString("tee_v");
            jVar.RPV = jSONObject.optString("fp_n");
            jVar.RPW = jSONObject.optString("fp_v");
            jVar.RPX = jSONObject.optString("cpu_id");
            jVar.RPY = jSONObject.optInt("rsa_pss_saltlen", 20);
            AppMethodBeat.o(88677);
            return jVar;
        } catch (JSONException e2) {
            d.e("Soter.SoterSignatureResult", "soter: convert from json failed." + e2.toString(), new Object[0]);
            AppMethodBeat.o(88677);
            return null;
        }
    }
}
