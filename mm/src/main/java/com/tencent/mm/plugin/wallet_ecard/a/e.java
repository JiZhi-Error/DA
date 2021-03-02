package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.cvn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends q implements m {
    public cvn IpW;
    private i callback;
    public int dDN = 0;
    public String qwn = "";
    private d rr;
    public String token = null;

    public e(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(71695);
        d.a aVar = new d.a();
        aVar.iLN = new cvm();
        aVar.iLO = new cvn();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/openecardauth";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cvm cvm = (cvm) this.rr.iLK.iLR;
        cvm.KPu = str;
        cvm.MAN = str2;
        cvm.dUS = i2;
        cvm.token = str3;
        this.token = null;
        Log.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d, token: %s, wxp_passwd_enc==null: %s", str, Integer.valueOf(i2), str3, Boolean.valueOf(Util.isNullOrNil(str2)));
        Log.i("MicroMsg.NetSceneOpenECardAuth", "cardType: %s, scene: %d", str, Integer.valueOf(i2));
        AppMethodBeat.o(71695);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(71696);
        Log.i("MicroMsg.NetSceneOpenECardAuth", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.IpW = (cvn) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneOpenECardAuth", "ret_code: %d, ret_msg: %s, is_token_invalid: %s", Integer.valueOf(this.IpW.pTZ), this.IpW.pUa, Boolean.valueOf(this.IpW.MAQ));
        if (!Util.isNullOrNil(this.IpW.MAO)) {
            Log.d("MicroMsg.NetSceneOpenECardAuth", "rettext: %s", this.IpW.MAO);
            try {
                JSONObject jSONObject = new JSONObject(this.IpW.MAO);
                this.dDN = jSONObject.optInt("retcode", 0);
                this.qwn = jSONObject.optString("retmsg", "");
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneOpenECardAuth", e2, "", new Object[0]);
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(71696);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1958;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(71697);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71697);
        return dispatch;
    }
}
