package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback;
    private String rAs;
    private long rAt;
    private String rAu;
    private long rAv;
    private d rr;

    public m(long j2, String str, String str2, long j3) {
        this.rAt = j2;
        this.rAu = str;
        this.rAs = str2;
        this.rAv = j3;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(23386);
        Log.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        if (i3 == 0 && i4 == 0) {
            mm mmVar = (mm) this.rr.iLL.iLR;
            cat cat = mmVar.KPD;
            String str2 = null;
            String str3 = null;
            if (cat != null) {
                str2 = cat.oTH;
                str3 = cat.KLO;
            }
            Log.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", str2, str3);
            if (ad.cKL().gc(str3, str2) != null) {
                boolean gd = ad.cKL().gd(str2, str3);
                Log.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", str3, Boolean.valueOf(gd));
                if (gd) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = true;
            }
            b bVar = new b();
            bVar.field_connProto = this.rAs;
            bVar.field_connStrategy = 1;
            bVar.field_closeStrategy = 1;
            bVar.field_url = "";
            f.a(bVar, cat, mmVar.KPE);
            if (bVar.field_mac == 0) {
                Log.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
                bVar.field_mac = this.rAt;
            }
            if (z) {
                ad.cKL().insert(bVar);
            } else {
                ad.cKL().e(bVar);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23386);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1262;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23387);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new ml();
        aVar.iLO = new mm();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
        aVar.funcId = 1262;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ml mlVar = (ml) this.rr.iLK.iLR;
        mlVar.mac = com.tencent.mm.plugin.exdevice.k.b.Dk(this.rAt);
        mlVar.KQG = this.rAu;
        mlVar.KQF = this.rAs;
        mlVar.KQH = this.rAv;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23387);
        return dispatch;
    }
}
