package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m, e {
    private i callback;
    private boolean rop = false;
    private d rr;
    private boolean sPX = false;
    public String sPY = null;
    private String sPZ = "";

    public m(long j2, String str, String str2, String str3, String str4, int i2, float f2, int i3) {
        AppMethodBeat.i(103607);
        d.a aVar = new d.a();
        aVar.iLN = new ama();
        aVar.iLO = new amb();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ama ama = (ama) this.rr.iLK.iLR;
        ama.dNI = str;
        ama.LuJ = j2;
        ama.KRB = str2;
        ama.LuL = str3;
        ama.LuK = str4;
        ama.sPV = i2;
        ama.LuN = f2;
        ama.LuO = i3;
        Log.i("MicroMsg.NetSceneFaceVerifyFace", "NetSceneFacePicThirdVerifyFace, checkAliveType: %s  ,light:%f ,upload_video:%d  appid:%s  bioid:%s json_str:%s picture_cdn_id:%s cdnAesKey:%s uploadVideo:%s", Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), str, Long.valueOf(j2), str2, str3, str4, Integer.valueOf(i3));
        AppMethodBeat.o(103607);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1080;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103608);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103608);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103609);
        Log.i("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        amb amb = (amb) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", amb.LuP);
        this.sPY = amb.LuP;
        this.rop = amb.LuQ;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(103609);
    }

    @Override // com.tencent.mm.plugin.facedetect.b.e
    public final String cSP() {
        return this.sPY;
    }

    @Override // com.tencent.mm.plugin.facedetect.b.e
    public final boolean cSO() {
        return this.rop;
    }
}
