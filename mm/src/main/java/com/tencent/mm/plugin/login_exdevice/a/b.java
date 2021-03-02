package com.tencent.mm.plugin.login_exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b extends q implements m {
    private i callback;
    public d hJu;

    public b() {
        AppMethodBeat.i(231732);
        d.a aVar = new d.a();
        aVar.iLN = new bpx();
        aVar.iLO = new bpy();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.uri = "/cgi-bin/micromsg-bin/getloginqrcode";
        this.hJu = aVar.aXF();
        bpx bpx = (bpx) this.hJu.iLK.iLR;
        byte[] uuidRandom = Util.getUuidRandom();
        bpx.KPW = z.aC(uuidRandom);
        bpx.KQy = 0;
        this.hJu.setRsaInfo(ac.gtT());
        this.hJu.option = 1;
        this.hJu.getReqObj().setPassKey(uuidRandom);
        AppMethodBeat.o(231732);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(231733);
        Log.i("MicroMsg.NetSceneGetLoginQRCode", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(231733);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 502;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(231734);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(231734);
        return dispatch;
    }
}
