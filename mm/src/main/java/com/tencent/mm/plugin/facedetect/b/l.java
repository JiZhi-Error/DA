package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class l extends q implements m {
    private i callback;
    private d rr;
    private LinkedList<cgi> sPN = null;
    public dfb sPO = null;
    public String sPP;
    public String sPQ;
    public String sPR = null;
    public String sPS = null;
    public String sPT = null;
    public float sPU;
    public int sPV;
    public String sPW;

    public l(String str, String str2, int i2) {
        AppMethodBeat.i(103603);
        d.a aVar = new d.a();
        aVar.iLN = new aly();
        aVar.iLO = new alz();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentifyprepage";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        aly aly = (aly) this.rr.iLK.iLR;
        aly.dNI = str;
        aly.KRB = str2;
        aly.sPV = i2;
        AppMethodBeat.o(103603);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1147;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103604);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103604);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103605);
        Log.i("MicroMsg.NetSceneFaceGetConfirmPageInfo", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        alz alz = (alz) ((d) sVar).iLL.iLR;
        if (alz != null) {
            this.sPN = alz.Lhs;
            this.sPO = alz.LuC;
            this.sPR = alz.LuE;
            this.sPS = alz.LuF;
            this.sPT = alz.LuG;
            this.sPU = alz.LuH;
            this.sPV = alz.sPV;
            this.sPW = alz.sPW;
            this.sPP = alz.LuI;
            this.sPQ = alz.LuD;
            Log.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "Light threshold is A : " + this.sPU);
            Log.d("MicroMsg.NetSceneFaceGetConfirmPageInfo", "check_alive_type is  : " + this.sPV);
            if (this.callback != null) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
        }
        AppMethodBeat.o(103605);
    }

    public final String toString() {
        AppMethodBeat.i(103606);
        String str = "NetSceneFaceGetConfirmPageInfo{callback=" + this.callback + ", rr=" + this.rr + ", mFaceConfirmInfoList=" + this.sPN + ", mPromptButtonInfo=" + this.sPO + ", bizHeadUrl='" + this.sPP + '\'' + ", bizNickName='" + this.sPQ + '\'' + ", mHeaderPrompt='" + this.sPR + '\'' + ", mFeedbackUrl='" + this.sPS + '\'' + ", mComplainUrl='" + this.sPT + '\'' + ", mLight_threshold=" + this.sPU + ", check_alive_type=" + this.sPV + ", business_tips='" + this.sPW + '\'' + '}';
        AppMethodBeat.o(103606);
        return str;
    }
}
