package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.mb;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l extends q implements m {
    private i callback = null;
    private d rr = null;

    public l(String str, int i2) {
        AppMethodBeat.i(23383);
        d.a aVar = new d.a();
        aVar.iLN = new mb();
        aVar.iLO = new mc();
        aVar.uri = "/cgi-bin/micromsg-bin/bindharddevice";
        aVar.funcId = 536;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        mb mbVar = (mb) this.rr.iLK.iLR;
        mbVar.KOX = Util.nullAsNil(str);
        mbVar.KPC = Util.nullAsNil(Integer.valueOf(i2));
        AppMethodBeat.o(23383);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23384);
        Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        if (i3 == 0 && i4 == 0) {
            mc cKE = cKE();
            Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", cKE.KPD.oTH, cKE.KPD.KLO);
            Object[] objArr = new Object[6];
            objArr[0] = cKE.KPE.KLg;
            objArr[1] = cKE.KPE.MfY;
            objArr[2] = cKE.KPE.KOS;
            objArr[3] = cKE.KPE.MfZ;
            objArr[4] = Integer.valueOf(cKE.KPE.Mga);
            objArr[5] = cKE.KHa == 0 ? "sync" : "async";
            Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s", objArr);
            boolean z = false;
            if (ad.cKL().gc(cKE.KPE.MfY, cKE.KPD.oTH) != null) {
                boolean gd = ad.cKL().gd(cKE.KPD.oTH, cKE.KPE.MfY);
                Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", cKE.KPE.MfY, Boolean.valueOf(gd));
                if (gd) {
                    z = true;
                }
            } else {
                z = true;
            }
            b bVar = new b();
            f.a(bVar, cKE.KPD, cKE.KPE);
            bVar.field_url = "";
            f.a CY = u.cLx().CY(bVar.field_mac);
            if (CY != null && CY.dHO == 2) {
                Log.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
                ad.cKS();
                d.CM(bVar.field_mac);
                f cLx = u.cLx();
                long j2 = bVar.field_mac;
                if (cLx.rDC.containsKey(Long.valueOf(j2))) {
                    cLx.rDC.remove(Long.valueOf(j2));
                    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", Long.valueOf(j2));
                } else {
                    Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", Long.valueOf(j2));
                }
            }
            if (z) {
                ad.cKL().insert(bVar);
            } else {
                ad.cKL().e(bVar);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23384);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 536;
    }

    public final mc cKE() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (mc) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23385);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23385);
        return dispatch;
    }
}
