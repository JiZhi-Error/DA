package com.tencent.mm.plugin.webview.emojistore;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.drx;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;

public final class b extends q implements m {
    int INw = -1;
    boolean INx = true;
    private i heq;
    private long rbH = 0;
    private byte[] rcO = null;
    private String rcQ;
    private int rcy;
    private final d rr;

    public b(int i2, String str, byte[] bArr, int i3, long j2) {
        AppMethodBeat.i(77868);
        d.a aVar = new d.a();
        aVar.iLN = new drx();
        aVar.iLO = new dry();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
        aVar.funcId = TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rcy = i2;
        this.rcQ = str;
        this.rcO = bArr;
        this.INw = i3;
        this.rbH = j2;
        AppMethodBeat.o(77868);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(77869);
        this.heq = iVar;
        drx drx = (drx) this.rr.iLK.iLR;
        if (!Util.isNullOrNil(this.rcO)) {
            drx.LUY = z.aC(this.rcO);
            this.INx = false;
            drx.LVb = this.rbH;
        } else {
            drx.LUY = new SKBuiltinBuffer_t();
            this.INx = true;
        }
        Log.d("MicroMsg.emoji.NetSceneSearchEmotion", drx.LUY == null ? "Buf is NULL" : drx.LUY.toString());
        drx.ReqType = this.rcy;
        drx.LUZ = this.rcQ;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(77869);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(77870);
        Log.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(77870);
    }

    public final dry gap() {
        if (this.rr == null) {
            return null;
        }
        return (dry) this.rr.iLL.iLR;
    }
}
