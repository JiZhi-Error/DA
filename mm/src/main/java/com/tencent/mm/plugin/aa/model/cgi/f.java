package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f extends q implements m {
    private i callback;
    public String chatroomName;
    private d hJu;
    private com.tencent.mm.protocal.protobuf.f jTe = ((com.tencent.mm.protocal.protobuf.f) this.hJu.iLK.iLR);
    public g jTf;

    public f(long j2, String str, List<String> list, int i2, long j3, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(63378);
        d.a aVar = new d.a();
        aVar.iLN = new com.tencent.mm.protocal.protobuf.f();
        aVar.iLO = new g();
        aVar.funcId = 1624;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.chatroomName = str2;
        this.hJu = aVar.aXF();
        this.hJu.setIsUserCmd(true);
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.jTe.KBv = list.size();
                    this.jTe.KBw = j2;
                    this.jTe.title = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    this.jTe.KBx = new LinkedList<>();
                    this.jTe.KBx.addAll(list);
                    this.jTe.scene = i2;
                    this.jTe.KBt = str2;
                    this.jTe.KBy = k.fQy();
                    this.jTe.KBz = j3;
                    this.jTe.KBA = str3;
                    this.jTe.KBB = str4;
                    this.jTe.KBC = str5;
                    Log.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", this.jTe.KBy);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", e2.getMessage());
            }
        }
        Log.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s, pic_cdn_url: %s, pic_cdn_thumb_url: %s, pf_order_no: %s", Integer.valueOf(this.jTe.KBv), Long.valueOf(this.jTe.KBw), this.jTe.title, this.jTe.KBx, Integer.valueOf(this.jTe.scene), this.jTe.KBt, Long.valueOf(this.jTe.KBz), Util.nullAs(this.jTe.KBA, ""), Util.nullAs(this.jTe.KBB, ""), Util.nullAs(this.jTe.KBC, ""));
        AppMethodBeat.o(63378);
    }

    public f(long j2, String str, int i2, int i3, long j3, String str2) {
        AppMethodBeat.i(63379);
        d.a aVar = new d.a();
        aVar.iLN = new com.tencent.mm.protocal.protobuf.f();
        aVar.iLO = new g();
        aVar.funcId = 1624;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.chatroomName = str2;
        try {
            this.jTe.KBv = i2;
            this.jTe.KBw = j2;
            this.jTe.title = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            this.jTe.KBx = new LinkedList<>();
            this.jTe.scene = i3;
            this.jTe.KBt = str2;
            this.jTe.KBy = k.fQy();
            Log.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", this.jTe.KBy);
            this.jTe.KBz = j3;
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", e2.getMessage());
        }
        Log.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", Integer.valueOf(this.jTe.KBv), Long.valueOf(this.jTe.KBw), this.jTe.title, this.jTe.KBx, Integer.valueOf(this.jTe.scene), this.jTe.KBt, Long.valueOf(this.jTe.KBz));
        AppMethodBeat.o(63379);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1624;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(63380);
        Log.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(63380);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63381);
        Log.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        this.jTf = (g) ((d) sVar).iLL.iLR;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.jTf.dDN);
        objArr[1] = this.jTf.qwn;
        objArr[2] = Boolean.valueOf(this.jTf.KBu == null);
        objArr[3] = this.jTf.KBs;
        Log.i("MicroMsg.NetSceneAALaunchByMoney", "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s", objArr);
        Log.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", this.jTf.KBu);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63381);
    }
}
