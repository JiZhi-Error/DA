package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.protocal.protobuf.aab;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.eoe;
import com.tencent.mm.protocal.protobuf.esg;
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends q implements m {
    public static int FNE = 1;
    public static int FNF = 2;
    public static int FNG = 3;
    private i AAQ;
    private String FNA;
    private int FNB;
    private esg FNC;
    private long FND;
    public esm FNH;
    public eoe FNI;
    public did FNJ;
    int FNK;
    private int Scene;
    private String dkU;
    private String dkV;
    private d iLF;
    private String mFileName;
    public int mState = -1;

    public a(String str, int i2, String str2) {
        AppMethodBeat.i(29262);
        a(str, i2, -1, -1, str2, 0, "", "");
        AppMethodBeat.o(29262);
    }

    public a(String str, int i2, int i3, long j2, String str2) {
        AppMethodBeat.i(29263);
        a(str, i2, i3, j2, str2, 0, "", "");
        AppMethodBeat.o(29263);
    }

    public a(String str, int i2, String str2, int i3, String str3, String str4) {
        AppMethodBeat.i(29264);
        a(str, i2, -1, -1, str2, i3, str3, str4);
        AppMethodBeat.o(29264);
    }

    public a(String str, int i2, int i3, long j2, String str2, int i4, String str3, String str4) {
        AppMethodBeat.i(29265);
        a(str, i2, i3, j2, str2, i4, str3, str4);
        AppMethodBeat.o(29265);
    }

    private void a(String str, int i2, int i3, long j2, String str2, int i4, String str3, String str4) {
        AppMethodBeat.i(29266);
        d.a aVar = new d.a();
        aVar.iLN = new aaa();
        aVar.iLO = new aab();
        aVar.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
        aVar.funcId = 546;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.mFileName = str2;
        this.iLF = aVar.aXF();
        Log.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
        if (i3 >= 0) {
            this.FNC = d.cz(i3, str2);
        }
        if (j2 > 0) {
            this.FND = j2;
        }
        this.FNA = str;
        this.FNB = i2;
        this.Scene = i4;
        this.dkU = str3;
        this.dkV = str4;
        AppMethodBeat.o(29266);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 546;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29267);
        this.AAQ = iVar;
        aaa aaa = (aaa) this.iLF.iLK.iLR;
        aaa.KXr = this.FNA;
        aaa.BsF = this.FNB;
        aaa.Llj = this.FNC;
        aaa.Brn = this.FND;
        aaa.Scene = this.Scene;
        aaa.xNH = this.dkU;
        aaa.xNG = this.dkV;
        int dispatch = dispatch(gVar, this.iLF, this);
        AppMethodBeat.o(29267);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29268);
        if (i3 == 0 && i4 == 0) {
            aab aab = (aab) this.iLF.iLL.iLR;
            if (aab == null) {
                AppMethodBeat.o(29268);
                return;
            }
            this.FNH = aab.Llk;
            this.mState = aab.oTW;
            this.FNI = aab.Lll;
            this.FNJ = aab.Llm;
            this.FNK = aab.Lln;
        } else {
            Log.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", Integer.valueOf(i3), Integer.valueOf(i4), this.FNA);
        }
        this.AAQ.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29268);
    }

    public final boolean ftu() {
        AppMethodBeat.i(29269);
        if (this.FNH == null || Util.isNullOrNil(this.FNH.NpE)) {
            AppMethodBeat.o(29269);
            return false;
        }
        AppMethodBeat.o(29269);
        return true;
    }
}
