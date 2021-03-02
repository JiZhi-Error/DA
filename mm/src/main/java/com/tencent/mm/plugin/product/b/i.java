package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.p.ao;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends q implements m {
    public LinkedList<ahl> AZv;
    private com.tencent.mm.ak.i callback;
    public String mUrl;
    private d rr;

    public i(String str, String str2) {
        AppMethodBeat.i(66897);
        d.a aVar = new d.a();
        aVar.iLN = new bsy();
        aVar.iLO = new bsz();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdiscount";
        aVar.funcId = ao.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bsy bsy = (bsy) this.rr.iLK.iLR;
        bsy.Lca = str;
        this.mUrl = str2;
        bsy.Url = str2;
        AppMethodBeat.o(66897);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(66898);
        bsz bsz = (bsz) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0 && bsz.KOt == 0) {
            Log.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + bsz.LZC);
            try {
                JSONArray optJSONArray = new JSONObject(bsz.LZC).optJSONArray("discount_list");
                if (optJSONArray != null) {
                    this.AZv = new LinkedList<>();
                    int length = optJSONArray.length();
                    for (int i5 = 0; i5 < length; i5++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i5);
                        ahl ahl = new ahl();
                        ahl.Title = jSONObject.getString("title");
                        ahl.KZx = jSONObject.getInt("fee");
                        this.AZv.add(ahl);
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (i4 == 0 && bsz.KOt != 0) {
            i4 = bsz.KOt;
            str = bsz.KOu;
        }
        Log.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + i4 + ", errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(66898);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return ao.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(66899);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66899);
        return dispatch;
    }
}
