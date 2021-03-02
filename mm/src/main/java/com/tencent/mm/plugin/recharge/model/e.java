package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends q implements m {
    public ArrayList<MallRechargeProduct> BDk = null;
    public String BDl;
    public String BDm;
    public String BDn;
    public String BDo;
    private i callback;
    public String kHR;
    private d rr;

    public e(String str) {
        AppMethodBeat.i(67107);
        d.a aVar = new d.a();
        aVar.iLN = new bse();
        aVar.iLO = new bsf();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
        aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX;
        aVar.iLP = 228;
        aVar.respCmdId = 1000000228;
        this.rr = aVar.aXF();
        this.kHR = str;
        ((bse) this.rr.iLK.iLR).LOs = str;
        AppMethodBeat.o(67107);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67108);
        Log.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            bsf bsf = (bsf) ((d) sVar).iLL.iLR;
            String str2 = bsf.LXe;
            Log.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList ".concat(String.valueOf(str2)));
            if (!Util.isNullOrNil(str2)) {
                try {
                    this.BDk = b.a(this.kHR, new JSONObject(str2).getJSONArray("pay_product_list"));
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e2, "", new Object[0]);
                }
            }
            if (!Util.isNullOrNil(bsf.LZm)) {
                try {
                    JSONObject jSONObject = new JSONObject(bsf.LZm);
                    this.BDl = jSONObject.optString("balance_link");
                    this.BDn = jSONObject.optString("recharge_link");
                    this.BDm = jSONObject.optString("balance_wording");
                    this.BDo = jSONObject.optString("recharge_wording");
                } catch (JSONException e3) {
                    Log.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e3, "", new Object[0]);
                }
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(67108);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.storage.m.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67109);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67109);
        return dispatch;
    }
}
