package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czz;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.protocal.protobuf.dye;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;
import java.util.Iterator;

public final class c extends w {
    public int HQI = 0;
    public Orders HQs;
    private i callback;
    private d rr;

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(69973);
        d.a aVar = new d.a();
        aVar.iLN = new dag();
        aVar.iLO = new dah();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
        aVar.funcId = 1565;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dag dag = (dag) this.rr.iLK.iLR;
        dag.jfi = str;
        dag.Lkq = str4;
        dag.Lkp = str2;
        dag.Lkr = str5;
        dag.Lks = str6;
        dag.KPJ = str3;
        dag.Ljk = str7;
        AppMethodBeat.o(69973);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(69974);
        Log.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        dah dah = (dah) ((d) sVar).iLL.iLR;
        if (i4 == 0 && i3 == 0) {
            i4 = dah.rBL;
            str = dah.rBM;
        }
        Log.i("MicroMsg.NetSceneIbgGetTransaction", "resp.IsUseNewPage: %s", Integer.valueOf(dah.MFA));
        this.HQI = dah.MFA;
        this.HQs = new Orders();
        this.HQs.HQg = 1;
        if (dah == null || dah.MFx == null) {
            Log.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
        } else {
            this.HQs.HZp = dah.HZp;
            this.HQs.HZr = new ArrayList<>();
            Iterator<dye> it = dah.MFB.iterator();
            while (it.hasNext()) {
                dye next = it.next();
                Orders.ShowInfo showInfo = new Orders.ShowInfo();
                showInfo.name = next.name;
                showInfo.value = next.value;
                showInfo.xEk = next.MXS;
                showInfo.Iaq = next.MXT;
                if (next.MXR != null) {
                    showInfo.Iar = next.MXR.gTx;
                    showInfo.Ias = next.MXR.HZV;
                    showInfo.Iat = next.MXR.HZW;
                    showInfo.Iau = next.MXR.HZX;
                    showInfo.Iav = next.MXR.NgM;
                }
                this.HQs.HZr.add(showInfo);
            }
            this.HQs.dDO = (double) dah.MFx.MFI;
            Orders.Commodity commodity = new Orders.Commodity();
            commodity.dDM = dah.MFx.CpP;
            commodity.desc = dah.MFx.iZU;
            commodity.qwJ = ((double) dah.MFx.MFI) / 100.0d;
            commodity.AOe = String.valueOf(dah.MFx.MFK);
            commodity.AOf = dah.MFx.MFL;
            commodity.AOj = dah.MFx.MFH;
            commodity.AOh = dah.MFx.MFG;
            commodity.AOl = dah.MFx.AOl;
            commodity.AOa = dah.MFx.MFJ;
            commodity.HZE = ((double) dah.MFx.MFM) / 100.0d;
            if (dah.MFy != null) {
                commodity.dCu = dah.MFy.KZR;
                Orders.Promotions promotions = new Orders.Promotions();
                promotions.name = dah.MFy.MFi;
                promotions.dCu = dah.MFy.KZR;
                commodity.HZF = dah.MFy.KZR;
                promotions.Bah = dah.MFy.iwv;
                commodity.HYT = dah.MFy.MFg;
                promotions.type = Orders.HZC;
                if (!Util.isNullOrNil(promotions.name)) {
                    commodity.HZN.add(promotions);
                    commodity.HZO = true;
                }
                this.HQs.HYT = dah.MFy.MFg;
            } else {
                Log.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
                this.HQs.HYT = 0;
            }
            if (dah.MFx.MFN != null && dah.MFx.MFN.size() > 0) {
                commodity.HZH = new ArrayList();
                Iterator<czz> it2 = dah.MFx.MFN.iterator();
                while (it2.hasNext()) {
                    Orders.DiscountInfo discountInfo = new Orders.DiscountInfo();
                    discountInfo.Coh = it2.next().MFj;
                    commodity.HZH.add(discountInfo);
                }
            }
            if (dah.MFz != null && dah.MFz.size() > 0) {
                Iterator<czv> it3 = dah.MFz.iterator();
                while (it3.hasNext()) {
                    czv next2 = it3.next();
                    Orders.Promotions promotions2 = new Orders.Promotions();
                    promotions2.type = Orders.HZD;
                    promotions2.url = next2.url;
                    promotions2.name = next2.dQx;
                    promotions2.Bah = next2.icon;
                    promotions2.HYF = next2.IhY;
                    promotions2.trD = Util.getInt(next2.type, 0);
                    promotions2.title = next2.title;
                    promotions2.crw = next2.Iai;
                    promotions2.Vgg = (int) next2.Iaj;
                    promotions2.Vgi = next2.HYG;
                    promotions2.Vgh = (int) next2.Iak;
                    promotions2.HYC = next2.Ial;
                    promotions2.HYD = next2.Iam;
                    promotions2.Vgj = next2.MFd;
                    promotions2.Vgk = next2.MFe;
                    promotions2.HYE = next2.Ian;
                    promotions2.Vgl = next2.MFf;
                    commodity.HZN.add(promotions2);
                }
            }
            this.HQs.HZd = new ArrayList();
            this.HQs.HZd.add(commodity);
            this.HQs.HYV = dah.MFx.MFL;
            Log.i("MicroMsg.NetSceneIbgGetTransaction", "formatOrders finish, mOrder.commoditys.size: %s, mOrder: %s", Integer.valueOf(this.HQs.HZd.size()), this.HQs);
        }
        if (Util.isNullOrNil(str)) {
            str = MMApplicationContext.getContext().getString(R.string.ibn);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69974);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1565;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69975);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69975);
        return dispatch;
    }
}
