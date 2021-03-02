package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.duq;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsMediaPlayer;

public final class a extends q implements m {
    private i callback;
    String jil;
    private final d rr;

    public a(float f2, float f3, int i2, int i3, String str, String str2, int i4, int i5, String str3) {
        AppMethodBeat.i(150874);
        d.a aVar = new d.a();
        aVar.iLN = new duq();
        aVar.iLO = new dur();
        aVar.uri = "/cgi-bin/micromsg-bin/sensewhere";
        aVar.funcId = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        chk chk = new chk();
        chk.LuV = str2;
        chk.LuW = i3;
        chk.LbD = f3;
        chk.LbC = f2;
        chk.LuU = str;
        chk.LuT = i2;
        duq duq = (duq) this.rr.iLK.iLR;
        duq.LpL = chk;
        duq.MVW = i4;
        duq.Scene = i5;
        duq.iAc = str3;
        AppMethodBeat.o(150874);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150875);
        Log.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.jil = ((dur) ((d) sVar).iLL.iLR).iAc;
        } else {
            Log.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(150875);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150876);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150876);
        return dispatch;
    }
}
