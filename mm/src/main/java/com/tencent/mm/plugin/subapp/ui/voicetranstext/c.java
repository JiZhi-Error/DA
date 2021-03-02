package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eoe;
import com.tencent.mm.protocal.protobuf.eof;
import com.tencent.mm.protocal.protobuf.eog;
import com.tencent.mm.protocal.protobuf.esg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class c extends q implements m {
    private i AAQ;
    private String FNA;
    private esg FNC;
    public eoe FNI;
    private int Scene;
    private final String TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    private String dkU;
    private String dkV;
    private d iLF;
    private String mFileName;

    public c(c cVar) {
        AppMethodBeat.i(29274);
        this.FNA = cVar.FNA;
        this.FNC = cVar.FNC;
        this.FNI = cVar.FNI;
        this.mFileName = cVar.mFileName;
        this.Scene = cVar.Scene;
        this.dkU = cVar.dkU;
        this.dkV = cVar.dkV;
        Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", Integer.valueOf(cVar.Scene), cVar.dkU, cVar.dkV);
        ftv();
        AppMethodBeat.o(29274);
    }

    public c(String str, eoe eoe, int i2, String str2) {
        boolean z;
        AppMethodBeat.i(29275);
        if (str2 != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.FNA = str;
        this.FNI = eoe;
        this.FNC = d.cz(i2, str2);
        this.mFileName = str2;
        ftv();
        AppMethodBeat.o(29275);
    }

    public c(String str, eoe eoe, int i2, String str2, int i3, String str3, String str4) {
        AppMethodBeat.i(29276);
        Assert.assertTrue(str2 != null);
        Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", Integer.valueOf(i3), str3, str4);
        this.FNA = str;
        this.FNI = eoe;
        this.FNC = d.cz(i2, str2);
        this.mFileName = str2;
        this.Scene = i3;
        this.dkU = str3;
        this.dkV = str4;
        ftv();
        AppMethodBeat.o(29276);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 547;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        boolean z;
        AppMethodBeat.i(29277);
        this.AAQ = iVar;
        if (Util.isNullOrNil(this.mFileName) || Util.isNullOrNil(this.FNA) || this.FNI == null || this.FNC == null) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Log.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
            AppMethodBeat.o(29277);
            return -1;
        }
        eof eof = (eof) this.iLF.iLK.iLR;
        eof.KXr = this.FNA;
        eof.Llj = this.FNC;
        eof.Lll = this.FNI;
        String str = this.mFileName;
        int i2 = this.FNI.BsG;
        int i3 = this.FNI.BsH;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        b Rf = s.Rf(str);
        if (Rf != null) {
            sKBuiltinBuffer_t = z.aC(Rf.dB(i2, i3).buf);
        }
        eof.BsI = sKBuiltinBuffer_t;
        eof.Scene = this.Scene;
        eof.xNH = this.dkU;
        eof.xNG = this.dkV;
        int dispatch = dispatch(gVar, this.iLF, this);
        AppMethodBeat.o(29277);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(29278);
        if (i3 == 0 && i4 == 0) {
            this.FNI = ((eog) this.iLF.iLL.iLR).Lll;
        } else {
            Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        this.AAQ.onSceneEnd(i3, i4, str, this);
        if (ftw()) {
            Object[] objArr = new Object[1];
            if (this.FNI != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.i("MicroMsg.NetSceneUploadVoiceForTrans", "succeeed finish: %B", objArr);
            AppMethodBeat.o(29278);
            return;
        }
        AppMethodBeat.o(29278);
    }

    private void ftv() {
        AppMethodBeat.i(29279);
        d.a aVar = new d.a();
        aVar.iLN = new eof();
        aVar.iLO = new eog();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
        aVar.funcId = 547;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iLF = aVar.aXF();
        AppMethodBeat.o(29279);
    }

    public final boolean ftw() {
        if (this.FNI == null || this.FNI.BsH <= 0) {
            return true;
        }
        return false;
    }
}
