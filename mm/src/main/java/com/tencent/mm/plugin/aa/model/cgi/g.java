package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.protocal.protobuf.k;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.util.LinkedList;
import java.util.List;

public final class g extends q implements m {
    private i callback;
    public String chatroomName;
    private d hJu;
    private j jTg = ((j) this.hJu.iLK.iLR);
    public k jTh;

    public g(String str, long j2, List<l> list, int i2, String str2, long j3, String str3, String str4, String str5) {
        AppMethodBeat.i(63382);
        d.a aVar = new d.a();
        aVar.iLN = new j();
        aVar.iLO = new k();
        aVar.funcId = 1655;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.hJu.setIsUserCmd(true);
        try {
            this.jTg.title = com.tencent.mm.compatible.util.q.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            this.jTg.KBF = j2;
            this.jTg.KBx = new LinkedList<>();
            this.jTg.KBx.addAll(list);
            this.jTg.scene = i2;
            this.jTg.KBt = str2;
            this.jTg.KBy = com.tencent.mm.plugin.wallet_core.model.k.fQy();
            this.jTg.KBz = j3;
            this.jTg.KBA = str3;
            this.jTg.KBB = str4;
            this.jTg.KBC = str5;
            Log.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", this.jTg.KBy);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", e2.getMessage());
        }
        this.chatroomName = str2;
        Log.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", this.jTg.title, Long.valueOf(this.jTg.KBF), this.jTg.KBx, Integer.valueOf(this.jTg.scene), this.jTg.KBt, Long.valueOf(this.jTg.KBz), Util.nullAs(this.jTg.KBA, ""), Util.nullAs(this.jTg.KBB, ""), Util.nullAs(this.jTg.KBC, ""));
        AppMethodBeat.o(63382);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1655;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(63383);
        Log.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(63383);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63384);
        Log.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        this.jTh = (k) ((d) sVar).iLL.iLR;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.jTh.dDN);
        objArr[1] = this.jTh.qwn;
        objArr[2] = this.jTh.KBs;
        objArr[3] = Boolean.valueOf(this.jTh.KBu == null);
        Log.i("MicroMsg.NetSceneAALaunchByPerson", "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s", objArr);
        Log.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", this.jTh.KBu);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63384);
    }
}
