package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    public int Na;
    public String appId;
    public int bNu;
    private i callback;
    public int dJY = 1;
    public int iKP;
    d rr;
    public int sOB;
    public b sOC;
    public String sOD;
    public gt sOE;
    public gn sOF;
    int sOG = 5000;
    long sOH = 0;

    public a(int i2, String str, int i3, String str2, gt gtVar) {
        boolean z = true;
        AppMethodBeat.i(24534);
        this.appId = str;
        this.sOB = i2;
        this.Na = 1;
        this.iKP = i3;
        this.sOE = gtVar;
        this.sOF = null;
        this.sOD = str2;
        Object[] objArr = new Object[7];
        objArr[0] = 1;
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = 1;
        objArr[5] = Boolean.valueOf(gtVar == null ? false : z);
        objArr[6] = Boolean.FALSE;
        Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s", objArr);
        AppMethodBeat.o(24534);
    }

    public a(int i2, String str, gn gnVar, long j2) {
        AppMethodBeat.i(24535);
        this.appId = str;
        this.sOB = i2;
        this.Na = 1;
        this.sOE = null;
        this.sOF = gnVar;
        this.sOH = j2;
        Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", 2, str, Integer.valueOf(i2), 1, Boolean.FALSE, Boolean.TRUE);
        AppMethodBeat.o(24535);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(24536);
        if (i3 == 0 && i4 == 0 && sVar != null) {
            Log.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        } else {
            Log.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(24536);
            return;
        }
        Log.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
        AppMethodBeat.o(24536);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 985;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(24537);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.funcId = 985;
        aVar.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
        aVar.iLN = new go();
        aVar.iLO = new gp();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        go goVar = (go) this.rr.iLK.iLR;
        goVar.OpCode = this.dJY;
        goVar.jfi = this.appId;
        goVar.KKn = this.sOB;
        goVar.KKo = this.Na;
        goVar.KKp = this.sOE;
        goVar.KKq = this.sOF;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(24537);
        return dispatch;
    }
}
