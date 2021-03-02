package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.io.IOException;

public final class g extends q implements m {
    private i callback;
    private d rr = null;
    private bye yrA = null;
    public byf yrB = null;

    public g(int i2) {
        AppMethodBeat.i(25469);
        d.a aVar = new d.a();
        aVar.iLN = new bye();
        aVar.iLO = new byf();
        aVar.funcId = CdnLogic.kAppTypeFestivalImage;
        aVar.uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yrA = (bye) this.rr.iLK.iLR;
        this.yrA.Scene = i2;
        bye bye = this.yrA;
        bg.aVF();
        bye.MdE = ((Integer) c.azQ().get(ar.a.USERFINO_IPCALL_REDDOT_RECHARGE_VERSION_INT, (Object) 0)).intValue();
        bye bye2 = this.yrA;
        bg.aVF();
        bye2.MdF = ((Integer) c.azQ().get(ar.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_TYPE_VERSION_INT, (Object) 0)).intValue();
        Log.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", Integer.valueOf(this.yrA.Scene), Integer.valueOf(this.yrA.MdE), Integer.valueOf(this.yrA.MdF));
        AppMethodBeat.o(25469);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return CdnLogic.kAppTypeFestivalImage;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(25470);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25470);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        byf byf;
        AppMethodBeat.i(25471);
        Log.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrB = (byf) ((d) sVar).iLL.iLR;
        if ((i3 == 0 || i4 == 0) && i3 == 0 && i4 == 0 && (byf = this.yrB) != null) {
            Log.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", byf.MdJ, byf.MdK, byf.MdG, byf.xJH, byf.Title, byf.Desc, byf.MdH, byf.MdI, byf.MdL, byf.MdR);
            try {
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_IPCALL_ACCOUNT_CACHE_STRING, Util.encodeHexString(byf.toByteArray()));
            } catch (IOException e2) {
                Log.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", e2.getMessage());
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25471);
    }
}
