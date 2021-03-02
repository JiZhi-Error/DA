package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;

public final class h extends q implements m {
    private i callback;
    public String chatroomName;
    private d hJu;
    private com.tencent.mm.protocal.protobuf.h jTi = ((com.tencent.mm.protocal.protobuf.h) this.hJu.iLK.iLR);
    public com.tencent.mm.protocal.protobuf.i jTj;

    public h(String str, int i2, String str2, long j2, String str3, String str4, String str5) {
        AppMethodBeat.i(212945);
        d.a aVar = new d.a();
        aVar.iLN = new com.tencent.mm.protocal.protobuf.h();
        aVar.iLO = new com.tencent.mm.protocal.protobuf.i();
        aVar.funcId = 2831;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbypayercustomize";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.hJu.setIsUserCmd(true);
        try {
            this.jTi.title = com.tencent.mm.compatible.util.q.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            this.jTi.scene = i2;
            this.jTi.KBt = str2;
            this.jTi.KBy = k.fQy();
            this.jTi.KBz = j2;
            this.jTi.KBA = str3;
            this.jTi.KBB = str4;
            this.jTi.KBC = str5;
            Log.d("MicroMsg.NetSceneAALaunchByPersonCustomize", "location %s", this.jTi.KBy);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneAALaunchByPersonCustomize", "build NetSceneAALaunchByPerson request error: %s", e2.getMessage());
        }
        this.chatroomName = str2;
        Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "NetSceneAALaunchByPersonCustomize, title: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", this.jTi.title, Integer.valueOf(this.jTi.scene), this.jTi.KBt, Long.valueOf(this.jTi.KBz), Util.nullAs(this.jTi.KBA, ""), Util.nullAs(this.jTi.KBB, ""), Util.nullAs(this.jTi.KBC, ""));
        AppMethodBeat.o(212945);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2831;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(212946);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(212946);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(212947);
        Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        this.jTj = (com.tencent.mm.protocal.protobuf.i) ((d) sVar).iLL.iLR;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.jTj.dDN);
        objArr[1] = this.jTj.qwn;
        objArr[2] = this.jTj.KBs;
        objArr[3] = Boolean.valueOf(this.jTj.KBu == null);
        Log.i("MicroMsg.NetSceneAALaunchByPersonCustomize", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", objArr);
        Log.d("MicroMsg.NetSceneAALaunchByPersonCustomize", "msgxml: %s", this.jTj.KBu);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(212947);
    }
}
