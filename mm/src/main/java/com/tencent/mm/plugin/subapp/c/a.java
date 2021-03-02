package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a extends q implements m {
    private int FJI = 0;
    private i callback;
    private RandomAccessFile file = null;
    private String filePath = null;
    private int iKP = 0;
    String url;

    public a(String str) {
        this.url = str;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28915);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new bry();
        aVar.iLO = new brz();
        aVar.uri = "/cgi-bin/micromsg-bin/getpsmimg";
        aVar.funcId = 141;
        aVar.iLP = 29;
        aVar.respCmdId = 1000000029;
        d aXF = aVar.aXF();
        bry bry = (bry) aXF.iLK.iLR;
        bry.URL = this.url;
        bry.KZk = this.FJI;
        Log.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.FJI + " totallen:" + this.iKP);
        int dispatch = dispatch(gVar, aXF, this);
        AppMethodBeat.o(28915);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        boolean z;
        AppMethodBeat.i(28916);
        String str = ((bry) ((d) sVar).iLK.iLR).URL;
        if (str == null) {
            z = false;
        } else if (str.indexOf("weixin://") != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(28916);
            return bVar;
        } else if (this.FJI < 0 || this.iKP < 0) {
            Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.FJI + " total:" + this.iKP);
            q.b bVar2 = q.b.EFailed;
            AppMethodBeat.o(28916);
            return bVar2;
        } else {
            if (this.FJI == 0) {
                if (this.iKP != 0) {
                    Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.FJI + " total:" + this.iKP);
                    q.b bVar3 = q.b.EFailed;
                    AppMethodBeat.o(28916);
                    return bVar3;
                }
            } else if (this.FJI >= this.iKP) {
                Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.FJI + " total:" + this.iKP);
                q.b bVar4 = q.b.EFailed;
                AppMethodBeat.o(28916);
                return bVar4;
            }
            q.b bVar5 = q.b.EOk;
            AppMethodBeat.o(28916);
            return bVar5;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28917);
        if (i3 == 0 && i4 == 0) {
            brz brz = (brz) ((d) sVar).iLL.iLR;
            Log.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.FJI + " Resp[ totallen:" + brz.LZd + " bufSize:" + brz.BsI.getILen() + " ]");
            if (brz.LZd > 0) {
                this.iKP = brz.LZd;
            }
            if (!c(this.url, brz.BsI.getBuffer().zy, this.FJI)) {
                this.callback.onSceneEnd(3, -1, str, this);
                AppMethodBeat.o(28917);
                return;
            }
            this.FJI = brz.BsI.getILen() + this.FJI;
            if (this.iKP <= this.FJI) {
                Log.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.iKP);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(28917);
                return;
            }
            if (doScene(dispatcher(), this.callback) < 0) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(28917);
            return;
        }
        Log.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28917);
    }

    private boolean c(String str, byte[] bArr, int i2) {
        AppMethodBeat.i(28918);
        if (i2 == 0) {
            if (this.file == null && this.filePath == null) {
                this.filePath = com.tencent.mm.pluginsdk.k.a.a.bek(str);
                if (this.filePath == null) {
                    Log.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + str + "]");
                    AppMethodBeat.o(28918);
                    return false;
                }
                try {
                    this.file = com.tencent.mm.vfs.s.dB(this.filePath, true);
                } catch (Exception e2) {
                    Log.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + e2.getMessage());
                    AppMethodBeat.o(28918);
                    return false;
                }
            } else {
                Log.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
                AppMethodBeat.o(28918);
                return false;
            }
        }
        try {
            this.file.seek((long) i2);
            this.file.write(bArr, 0, bArr.length);
            AppMethodBeat.o(28918);
            return true;
        } catch (IOException e3) {
            Log.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + e3.getMessage());
            AppMethodBeat.o(28918);
            return false;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 141;
    }
}
