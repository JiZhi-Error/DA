package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class b extends q implements m {
    private i callback;
    private d rr;
    private bng sXh = ((bng) this.rr.iLK.iLR);
    public bnh sXi;

    public b(String str, String str2, float f2, String str3, String str4, int i2, String str5, String str6, byte[] bArr, boolean z) {
        AppMethodBeat.i(186388);
        d.a aVar = new d.a();
        aVar.iLN = new bng();
        aVar.iLO = new bnh();
        aVar.funcId = 2726;
        aVar.uri = "/cgi-bin/mmpay-bin/getfacecheckresult";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.sXh.person_id = str;
        this.sXh.action_data = str2;
        this.sXh.LVP = (int) f2;
        this.sXh.LVQ = str3;
        this.sXh.KRe = str4;
        this.sXh.scene = i2;
        this.sXh.LjH = str5;
        this.sXh.qGp = str6;
        this.sXh.LUV = ((com.tencent.mm.pluginsdk.wallet.b) g.af(com.tencent.mm.pluginsdk.wallet.b.class)).elk();
        this.sXh.LVR = com.tencent.mm.bw.b.cD(bArr);
        this.sXh.LVS = z;
        Log.i("MicroMsg.NetSceneGetFaceCheckResult", "create GetFaceCheckResult, personId: %s, actionData: %s, reductionRatio: %s, videoFileid: %s, scene: %s, takeMessage: %s, packageName: %s，hash: %s", str, str2, Float.valueOf(f2), str3, Integer.valueOf(i2), str5, str6, Arrays.toString(bArr));
        AppMethodBeat.o(186388);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2726;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(104199);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(104199);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(104200);
        Log.i("MicroMsg.NetSceneGetFaceCheckResult", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        h.INSTANCE.idkeyStat(917, i4 == 0 ? 54 : 55, 1, false);
        this.sXi = (bnh) ((d) sVar).iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(104200);
    }
}
