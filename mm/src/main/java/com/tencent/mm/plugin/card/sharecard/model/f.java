package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cmn;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends q implements m {
    private i callback;
    public String pRK;
    public int pRL = 0;
    public String pRM;
    public int pRN;
    public String pRO;
    public String pVU;
    private final d rr;

    public f(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(112969);
        d.a aVar = new d.a();
        aVar.iLN = new cmn();
        aVar.iLO = new cmo();
        aVar.uri = "/cgi-bin/micromsg-bin/marksharecard";
        aVar.funcId = 1078;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cmn cmn = (cmn) this.rr.iLK.iLR;
        cmn.eaO = str;
        cmn.MrL = i3;
        cmn.MrK = i2;
        cmn.scene = i4;
        this.pVU = str;
        AppMethodBeat.o(112969);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112970);
        Log.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(getType()), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            cmo cmo = (cmo) this.rr.iLL.iLR;
            Log.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + cmo.pTY);
            String str2 = cmo.pTY;
            if (TextUtils.isEmpty(str2)) {
                Log.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    this.pRK = jSONObject.optString("mark_user");
                    this.pRL = jSONObject.optInt("mark_succ", 0);
                    this.pRM = jSONObject.optString("mark_card_id");
                    this.pRN = jSONObject.optInt("expire_time", 0);
                    this.pRO = jSONObject.optString("pay_qrcode_wording");
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", e2, "", new Object[0]);
                }
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112970);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1078;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112971);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112971);
        return dispatch;
    }
}
