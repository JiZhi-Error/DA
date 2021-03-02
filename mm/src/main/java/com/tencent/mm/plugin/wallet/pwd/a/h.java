package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekb;
import com.tencent.mm.protocal.protobuf.ekc;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends q implements m {
    public ekc HIj;
    public a HIk;
    private i callback;
    private final d rr;

    public h(int i2) {
        AppMethodBeat.i(182519);
        d.a aVar = new d.a();
        ekb ekb = new ekb();
        ekb.NiZ = i2;
        aVar.iLN = ekb;
        aVar.iLO = new ekc();
        aVar.uri = "/cgi-bin/mmpay-bin/transferphonegetswitch";
        aVar.funcId = 1813;
        this.rr = aVar.aXF();
        AppMethodBeat.o(182519);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1813;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69545);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69545);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69546);
        Log.w("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.HIj = (ekc) ((d) sVar).iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69546);
    }

    public static class a {
        public String HHX;
        public boolean HIl;
        public String dQx;
        public int pTZ;
        public boolean pTt;
        public String pUa;

        public final String toString() {
            AppMethodBeat.i(69541);
            String str = "MobileRemitSwitchConfig{ret_code=" + this.pTZ + ", ret_msg='" + this.pUa + '\'' + ", is_show=" + this.pTt + ", is_open=" + this.HIl + ", entrance_name='" + this.HHX + '\'' + ", wording='" + this.dQx + '\'' + '}';
            AppMethodBeat.o(69541);
            return str;
        }

        public final String fON() {
            AppMethodBeat.i(69542);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret_code", this.pTZ);
                jSONObject.put("ret_msg", this.pUa);
                jSONObject.put("is_show", this.pTt);
                jSONObject.put("is_open", this.HIl);
                jSONObject.put("entrance_name", this.HHX);
                jSONObject.put("wording", this.dQx);
                String jSONObject2 = jSONObject.toString();
                AppMethodBeat.o(69542);
                return jSONObject2;
            } catch (JSONException e2) {
                Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "MobileRemitSwitchConfig getJSONObjectString() Exception: %s", e2.getMessage());
                AppMethodBeat.o(69542);
                return "";
            }
        }

        public static a aVa(String str) {
            AppMethodBeat.i(69543);
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar.pTZ = jSONObject.optInt("ret_code");
                aVar.pUa = jSONObject.optString("ret_msg");
                aVar.pTt = jSONObject.optBoolean("is_show");
                aVar.HIl = jSONObject.optBoolean("is_open");
                aVar.HHX = jSONObject.optString("entrance_name");
                aVar.dQx = jSONObject.optString("wording");
            } catch (JSONException e2) {
                Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "createFromJSONObject() Exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(69543);
            return aVar;
        }
    }
}
