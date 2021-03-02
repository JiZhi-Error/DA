package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    private i callback;
    private final String id;
    public byte[] oSv;
    private final d rr;

    public e(String str) {
        AppMethodBeat.i(21948);
        d.a aVar = new d.a();
        aVar.iLN = new bir();
        aVar.iLO = new bis();
        aVar.uri = "/cgi-bin/micromsg-bin/getbakchatkey";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.funcId = 596;
        this.rr = aVar.aXF();
        bir bir = (bir) this.rr.iLK.iLR;
        bir.ID = str;
        bir.LSJ = ac.gtT().ver;
        this.id = str;
        Log.i("MicroMsg.NetSceneGetBakchatkey", "init id:%s, ver:0x%x", bir.ID, Integer.valueOf(bir.LSJ));
        AppMethodBeat.o(21948);
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(21949);
        super.cancel();
        AppMethodBeat.o(21949);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 596;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(21950);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(21950);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(21951);
        Log.i("MicroMsg.NetSceneGetBakchatkey", "errType %d,  errCode %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            this.oSv = ((bis) this.rr.iLL.iLR).KLU.getBuffer().zy;
            Object[] objArr = new Object[2];
            objArr[0] = this.id;
            objArr[1] = Integer.valueOf(this.oSv == null ? 0 : this.oSv.length);
            Log.i("MicroMsg.NetSceneGetBakchatkey", "id:%s,  key len:%d", objArr);
            if (this.oSv != null) {
                byte[] bArr2 = this.oSv;
                String str2 = "";
                for (int i5 = 0; i5 < bArr2.length; i5++) {
                    str2 = str2 + Integer.toHexString(bArr2[i5] & 255) + " ";
                }
                Log.i("MicroMsg.NetSceneGetBakchatkey", "dump bakchat: %s", str2);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(21951);
    }
}
