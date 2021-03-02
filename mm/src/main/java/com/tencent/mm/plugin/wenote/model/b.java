package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b extends q implements m {
    public int JGC = 1;
    private String JGD = "";
    private amz JGE = null;
    private LinkedList<amz> JGF = new LinkedList<>();
    public int JGG = 0;
    private i callback = null;
    private final d rr;

    public b(int i2, int i3, String str, LinkedList<amz> linkedList, amz amz) {
        AppMethodBeat.i(30287);
        this.JGF = linkedList;
        this.JGE = amz;
        this.JGD = str;
        this.JGC = i3;
        this.JGG = i2;
        d.a aVar = new d.a();
        aVar.iLN = new anf();
        aVar.iLO = new ang();
        aVar.uri = "/cgi-bin/micromsg-bin/favsecurity ";
        aVar.funcId = 921;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(30287);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(30288);
        anf anf = (anf) this.rr.iLK.iLR;
        anf.him = this.JGC;
        anf.Lyg = this.JGE;
        anf.Lyf = this.JGF;
        anf.KTg = this.JGD;
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(30288);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(30289);
        Log.i("MicroMsg.NetSceneCheckNoteSecurity", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        ang ang = (ang) ((d) sVar).iLL.iLR;
        if (i3 != 0) {
            Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,errType:%d,fail", Integer.valueOf(i3));
            this.callback.onSceneEnd(i3, -1, str, this);
            AppMethodBeat.o(30289);
        } else if (ang == null || ang.getBaseResponse() == null) {
            Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,response == null,ok");
            this.callback.onSceneEnd(i3, 0, str, this);
            AppMethodBeat.o(30289);
        } else if (ang.getBaseResponse().Ret != 0) {
            Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,baseresponse.ret != 0,ok");
            this.callback.onSceneEnd(i3, 0, str, this);
            AppMethodBeat.o(30289);
        } else if (ang.Lyh > 0) {
            Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult > 0,fail");
            this.callback.onSceneEnd(i3, -1, str, this);
            AppMethodBeat.o(30289);
        } else {
            Log.i("MicroMsg.NetSceneCheckNoteSecurity", "NetSceneCheckNoteSecurity,SecurityResult = 0,fail");
            this.callback.onSceneEnd(i3, 0, str, this);
            AppMethodBeat.o(30289);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 921;
    }
}
