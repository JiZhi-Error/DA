package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class g extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetCode";
    private i callback;
    public wv qxG;
    private d rr;

    public g(LinkedList<Integer> linkedList, String str, boolean z, boolean z2) {
        AppMethodBeat.i(63908);
        d.a aVar = new d.a();
        aVar.iLN = new wu();
        aVar.iLO = new wv();
        aVar.funcId = 1562;
        aVar.uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        wu wuVar = (wu) this.rr.iLK.iLR;
        wuVar.Lhn = linkedList;
        wuVar.desc = str;
        wuVar.LhR = z;
        wuVar.LhS = z2;
        Log.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2));
        AppMethodBeat.o(63908);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1562;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(63909);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(63909);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.collect.reward.a.a
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(63910);
        Log.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.qxG = (wv) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.qxG.dDN), this.qxG.qwn);
        if (!this.qxx && this.qxG.dDN != 0) {
            this.qxy = true;
        }
        if (!this.qxx && !this.qxy) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf(this.qxG.Lhq));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf(this.qxG.Lhm));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, this.qxG.desc);
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, this.qxG.Cog);
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = this.qxG.Lhn.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().intValue()));
            }
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, Util.listToString(arrayList, ","));
            h.INSTANCE.idkeyStat(724, 5, 1, false);
        } else if (this.qxx) {
            h.INSTANCE.idkeyStat(724, 7, 1, false);
        } else {
            h.INSTANCE.idkeyStat(724, 6, 1, false);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(63910);
    }
}
