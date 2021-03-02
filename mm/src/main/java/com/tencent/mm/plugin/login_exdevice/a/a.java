package com.tencent.mm.plugin.login_exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.protocal.protobuf.yu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class a extends q implements m {
    private i callback;
    private d hJu;
    private byte[] yOt;

    public a(String str, byte[] bArr) {
        AppMethodBeat.i(231728);
        d.a aVar = new d.a();
        aVar.iLN = new yt();
        aVar.iLO = new yu();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.uri = "/cgi-bin/micromsg-bin/checkloginqrcode";
        this.hJu = aVar.aXF();
        yt ytVar = (yt) this.hJu.iLK.iLR;
        byte[] uuidRandom = Util.getUuidRandom();
        ytVar.KPW = z.aC(uuidRandom);
        ytVar.hil = (int) (System.currentTimeMillis() / 1000);
        ytVar.UUID = str;
        ytVar.KQy = 0;
        this.hJu.setRsaInfo(ac.gtT());
        this.hJu.option = 1;
        this.hJu.getReqObj().setPassKey(uuidRandom);
        this.yOt = bArr;
        AppMethodBeat.o(231728);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(231729);
        Log.i("MicroMsg.NetSceneCheckLoginQRCode", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(231729);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 503;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(231730);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(231730);
        return dispatch;
    }

    public final ckg een() {
        AppMethodBeat.i(231731);
        byte[] a2 = z.a(((yu) this.hJu.iLL.iLR).LjU.MpF);
        if (this.yOt != null && this.yOt.length > 0) {
            byte[] aesDecrypt = MMProtocalJni.aesDecrypt(a2, this.yOt);
            Log.i("MicroMsg.NetSceneCheckLoginQRCode", "decrypt notifyData %s %s %s", Integer.valueOf(this.yOt.length), Integer.valueOf(a2.length), Integer.valueOf(aesDecrypt.length));
            ckg ckg = new ckg();
            try {
                ckg.parseFrom(aesDecrypt);
                AppMethodBeat.o(231731);
                return ckg;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneCheckLoginQRCode", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(231731);
        return null;
    }
}
