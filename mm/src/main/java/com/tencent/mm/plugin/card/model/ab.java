package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bkm;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab extends q implements m {
    private i callback;
    public String pTY;
    public int pUj;
    public String pUk;
    public int pUl;
    public String pUm;
    private final d rr;

    public ab(LinkedList<um> linkedList, int i2, String str, String str2, String str3, String str4, String str5, int i3) {
        AppMethodBeat.i(112840);
        d.a aVar = new d.a();
        aVar.iLN = new bkl();
        aVar.iLO = new bkm();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
        aVar.funcId = 1079;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bkl bkl = (bkl) this.rr.iLK.iLR;
        bkl.KDk = linkedList;
        bkl.eaQ = i2;
        bkl.qGp = str;
        bkl.sign = str2;
        bkl.KDg = str3;
        bkl.KDf = str4;
        bkl.LTz = str5;
        bkl.KDh = i3;
        AppMethodBeat.o(112840);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1079;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112841);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112841);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112842);
        Log.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i3 + " errCode = " + i4 + " netType = " + getType());
        if (i3 == 0 && i4 == 0) {
            this.pTY = ((bkm) this.rr.iLL.iLR).pTY;
            if (TextUtils.isEmpty(this.pTY)) {
                Log.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.pTY);
                    this.pUj = jSONObject.optInt("accept_button_status", 0);
                    this.pUk = jSONObject.optString("accept_button_wording");
                    this.pUl = jSONObject.optInt("private_status", 0);
                    this.pUm = jSONObject.optString("private_wording");
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", e2, "", new Object[0]);
                    Log.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + e2.getMessage());
                }
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112842);
    }
}
