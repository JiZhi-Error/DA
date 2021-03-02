package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.elc;
import com.tencent.mm.protocal.protobuf.eld;
import com.tencent.mm.sdk.platformtools.Log;

public final class x extends q implements m {
    private i callback;
    public cat rAA;
    private d rr;

    public x(cat cat, int i2) {
        AppMethodBeat.i(23419);
        this.rAA = cat;
        d.a aVar = new d.a();
        aVar.iLN = new elc();
        aVar.iLO = new eld();
        aVar.funcId = 537;
        aVar.uri = "/cgi-bin/micromsg-bin/unbindharddevice";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        elc elc = (elc) this.rr.iLK.iLR;
        elc.KPD = cat;
        elc.KHa = i2;
        AppMethodBeat.o(23419);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 537;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23420);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23420);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        eld eld;
        AppMethodBeat.i(23421);
        Log.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        i iVar = i.INSTANCE;
        i.CS(0);
        b anJ = ad.cKL().anJ(this.rAA.oTH);
        if (anJ != null) {
            if (u.cLy().rxT != null && !u.cLy().rxT.De(anJ.field_mac)) {
                Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
            }
            if (!ad.cKL().gd(this.rAA.oTH, this.rAA.KLO)) {
                Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
            }
        } else {
            Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", this.rAA.oTH);
        }
        if (!(i3 == 0 && i4 == 0)) {
            Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", Integer.valueOf(getType()));
        }
        if (this.rr == null || this.rr.iLL.iLR == null) {
            eld = null;
        } else {
            eld = (eld) this.rr.iLL.iLR;
        }
        if (eld == null) {
            Log.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23421);
    }
}
