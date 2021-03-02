package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Random;

public final class u extends q implements m {
    private int bNu = 0;
    private i callback;
    private String filePath = null;
    private int iKP = 0;
    private j iYO;
    private String msgId;
    d rr;

    public u(String str, String str2, j jVar) {
        AppMethodBeat.i(122722);
        this.filePath = str;
        this.msgId = str2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2);
        this.iYO = jVar;
        Log.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", this.msgId, this.filePath);
        AppMethodBeat.o(122722);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(122723);
        Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            ai aiVar = (ai) ((d) sVar).iLL.iLR;
            String str2 = aiVar.izX;
            Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", aiVar.izX, Integer.valueOf(aiVar.BsF), aiVar.Brm);
            if (!str2.equals(this.msgId)) {
                AppMethodBeat.o(122723);
                return;
            }
            this.bNu = aiVar.BsG;
            if (this.bNu < this.iKP) {
                Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", Integer.valueOf(this.bNu), Integer.valueOf(this.iKP));
                if (doScene(dispatcher(), this.callback) < 0) {
                    Log.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
                    if (this.callback != null) {
                        this.callback.onSceneEnd(i3, i4, str, this);
                    }
                    if (this.iYO != null) {
                        this.iYO.a(this.bNu, this.iKP, this);
                    }
                    AppMethodBeat.o(122723);
                    return;
                }
            }
            Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", Integer.valueOf(this.bNu), Integer.valueOf(this.iKP), aiVar.Brm);
            if (this.callback != null) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            if (this.iYO != null) {
                this.iYO.a(this.bNu, this.iKP, this);
            }
            AppMethodBeat.o(122723);
            return;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(122723);
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 640;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(122724);
        if (Util.isNullOrNil(this.filePath) || !com.tencent.mm.vfs.s.YS(this.filePath)) {
            Log.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(122724);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(122724);
        return bVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 484;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(122725);
        this.callback = iVar;
        if (Util.isNullOrNil(this.filePath)) {
            Log.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
            AppMethodBeat.o(122725);
            return -1;
        } else if (!com.tencent.mm.vfs.s.YS(this.filePath)) {
            Log.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", this.filePath);
            AppMethodBeat.o(122725);
            return -1;
        } else {
            if (this.iKP == 0) {
                this.iKP = (int) com.tencent.mm.vfs.s.boW(this.filePath);
                Log.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", Integer.valueOf(this.iKP));
            }
            int min = Math.min(this.iKP - this.bNu, 32768);
            Log.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", Integer.valueOf(this.bNu), Integer.valueOf(min));
            byte[] aW = com.tencent.mm.vfs.s.aW(this.filePath, this.bNu, min);
            if (aW == null) {
                Log.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
                AppMethodBeat.o(122725);
                return -1;
            }
            Log.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", Integer.valueOf(aW.length));
            d.a aVar = new d.a();
            aVar.iLN = new ah();
            aVar.iLO = new ai();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadfile";
            aVar.funcId = 484;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            this.rr = aVar.aXF();
            ah ahVar = (ah) this.rr.iLK.iLR;
            ahVar.izX = this.msgId;
            ahVar.BsF = this.iKP;
            ahVar.BsG = this.bNu;
            ahVar.BsH = min;
            ahVar.BsI = z.aC(aW);
            int dispatch = dispatch(gVar, this.rr, this);
            Log.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", Integer.valueOf(dispatch));
            AppMethodBeat.o(122725);
            return dispatch;
        }
    }
}
