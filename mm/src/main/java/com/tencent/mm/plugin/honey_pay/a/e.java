package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;

public final class e extends r {
    private final String TAG = "MicroMsg.NetSceneGetHoneyPayCard";
    public bol yjB;

    public e(String str) {
        AppMethodBeat.i(64620);
        d.a aVar = new d.a();
        aVar.iLN = new bok();
        aVar.iLO = new bol();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/gethpcard";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bok bok = (bok) this.rr.iLK.iLR;
        bok.LWD = str;
        bok.LUV = k.elk();
        Log.i("MicroMsg.NetSceneGetHoneyPayCard", "card no: %s", str);
        AppMethodBeat.o(64620);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return Exif.PARSE_EXIF_ERROR_NO_EXIF;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64621);
        Log.i("MicroMsg.NetSceneGetHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.yjB = (bol) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneGetHoneyPayCard", "retcode: %s, retmsg: %s", Integer.valueOf(this.yjB.pTZ), this.yjB.pUa);
        if (this.yjB.LWE != null) {
            c.s(this.yjB.LWE.dXf, this.yjB.LWE.LaR, this.yjB.LWE.dWw, null);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(64621);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        bol bol = (bol) ((d) sVar).iLL.iLR;
        this.RtZ = bol.pTZ;
        this.Rua = bol.pUa;
    }
}
