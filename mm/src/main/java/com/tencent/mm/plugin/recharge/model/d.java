package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends q implements m {
    public String BCZ = null;
    public MallRechargeProduct BDh = null;
    public List<MallRechargeProduct> BDi = null;
    public String BDj;
    private i callback;
    public int iFf;
    public String kHR;
    public String kik;
    public com.tencent.mm.ak.d rr;

    public d(int i2, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(67104);
        this.kHR = str;
        this.iFf = i2;
        this.kik = str5;
        this.BDj = str2;
        d.a aVar = new d.a();
        aVar.iLN = new bpa();
        aVar.iLO = new bpb();
        aVar.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
        aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX;
        aVar.iLP = 229;
        aVar.respCmdId = 1000000229;
        this.rr = aVar.aXF();
        bpa bpa = (bpa) this.rr.iLK.iLR;
        bpa.LOs = str;
        bpa.LOt = str3;
        bpa.LXc = str2;
        bpa.LOu = str4;
        bpa.Bri = c.fSg().aVu(str);
        Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", str, str3, str2, str4));
        AppMethodBeat.o(67104);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        String[] split;
        AppMethodBeat.i(67105);
        Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + i4 + ", errMsg " + str);
        bpb bpb = (bpb) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + bpb.LOx);
        String str2 = bpb.LOx;
        this.BCZ = "";
        if (!Util.isNullOrNil(str2) && (split = str2.split("&")) != null && split.length > 0) {
            boolean z = true;
            for (String str3 : split) {
                String[] split2 = str3.split("=");
                if (split2.length == 2) {
                    if (!z) {
                        this.BCZ += " ";
                    } else {
                        z = false;
                    }
                    this.BCZ += split2[1];
                }
            }
        }
        if (!Util.isNullOrNil(bpb.LXe)) {
            try {
                this.BDi = b.a(this.kHR, new JSONObject(bpb.LXe).optJSONArray("product_info"));
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e2, "", new Object[0]);
            }
        }
        if (i3 == 0 && i4 == 0) {
            String str4 = bpb.LXd;
            Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product ".concat(String.valueOf(str4)));
            if (!Util.isNullOrNil(str4)) {
                try {
                    this.BDh = b.n(this.kHR, new JSONObject(str4));
                    this.BDh.BCZ = this.BCZ;
                } catch (JSONException e3) {
                    Log.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e3, "", new Object[0]);
                }
            }
        }
        Log.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", Integer.valueOf(bpb.LOv), bpb.LOw, Integer.valueOf(bpb.LOy), bpb.LOz));
        if (i4 == 0) {
            if (bpb.LOy != 0) {
                i4 = bpb.LOy;
            } else {
                i4 = bpb.LOv;
            }
        }
        if (Util.isNullOrNil(str)) {
            if (!Util.isNullOrNil(bpb.LOz)) {
                str = bpb.LOz;
            } else {
                str = bpb.LOw;
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(67105);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.storage.d.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67106);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67106);
        return dispatch;
    }
}
