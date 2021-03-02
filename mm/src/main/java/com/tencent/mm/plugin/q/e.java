package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;

public final class e extends q implements m {
    private String aeskey;
    private i callback;
    private String fileId;
    private String gna;
    private d rr;
    private int zGp;
    private String zGq;
    private String zGr;

    public e(String str, String str2, int i2, String str3, String str4, String str5) {
        AppMethodBeat.i(26524);
        this.fileId = str;
        this.aeskey = str2;
        this.zGp = i2;
        this.gna = str3;
        this.zGq = str4;
        this.zGr = str5;
        d.a aVar = new d.a();
        aVar.iLN = new dth();
        aVar.iLO = new dti();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.funcId = TbsListener.ErrorCode.UNLZMA_FAIURE;
        aVar.iLP = 107;
        aVar.respCmdId = 1000000107;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", str4, this.zGq, str, Integer.valueOf(i2), str3, Util.getStack());
        AppMethodBeat.o(26524);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26525);
        this.callback = iVar;
        k.b bVar = new k.b();
        bVar.title = "ChatSync";
        bVar.description = "ChatSync";
        bVar.type = 35;
        bVar.url = this.fileId;
        bVar.aesKey = this.aeskey;
        bVar.ixb = this.aeskey;
        bVar.iwI = this.zGp;
        bVar.ixb = this.aeskey;
        bVar.dDG = 0;
        bVar.action = "phone";
        bVar.messageAction = this.zGq;
        bVar.extInfo = "supportAfterSleep,supportGetMore";
        bVar.content = this.zGr;
        fd fdVar = new fd();
        fdVar.xNH = this.gna;
        fdVar.KIy = bVar.sdkVer;
        fdVar.oUv = 35;
        fdVar.xNG = this.gna;
        fdVar.iAc = k.b.a(bVar, null, null, 0, 0);
        fdVar.CreateTime = (int) Util.nowSecond();
        ((dth) this.rr.iLK.iLR).MVu = fdVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(26525);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26526);
        Log.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(26526);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.UNLZMA_FAIURE;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }
}
