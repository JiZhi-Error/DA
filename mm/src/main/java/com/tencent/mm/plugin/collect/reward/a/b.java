package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.wa;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;

public final class b extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardGetCode";
    private i callback;
    public wb qxA;
    public boolean qxB;
    private d rr;

    public b(boolean z) {
        AppMethodBeat.i(63894);
        d.a aVar = new d.a();
        aVar.iLN = new wa();
        aVar.iLO = new wb();
        aVar.funcId = 1323;
        aVar.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((wa) this.rr.iLK.iLR).Lhj = z;
        this.qxB = z;
        AppMethodBeat.o(63894);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1323;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63895);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(63895);
        return dispatch;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.collect.reward.a.a
    public final boolean czP() {
        return false;
    }

    @Override // com.tencent.mm.plugin.collect.reward.a.a
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(63896);
        Log.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.qxA = (wb) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.qxA.dDN), this.qxA.qwn);
        if (!this.qxx && this.qxA.dDN != 0) {
            this.qxy = true;
        }
        if (!this.qxx && !this.qxy) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_PHOTO_WIDTH_INT_SYNC, Integer.valueOf(this.qxA.Lhq));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_ICON_WIDTH_INT_SYNC, Integer.valueOf(this.qxA.Lhm));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_DESC_STRING_SYNC, this.qxA.desc);
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_WORD_STRING_SYNC, this.qxA.pqv);
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_MAX_AMT_INT_SYNC, Integer.valueOf(this.qxA.Lhp));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_BOTTOM_STR_STRING_SYNC, this.qxA.pTK);
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_BOTTOM_URL_STRING_SYNC, this.qxA.Lho);
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_LAST_PHOTO_URL_STRING_SYNC, this.qxA.Cog);
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = this.qxA.Lhn.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().intValue()));
            }
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_QR_REWARD_AMT_LIST_STRING_SYNC, Util.listToString(arrayList, ","));
            h.INSTANCE.idkeyStat(724, 2, 1, false);
        } else if (this.qxx) {
            h.INSTANCE.idkeyStat(724, 4, 1, false);
        } else {
            h.INSTANCE.idkeyStat(724, 3, 1, false);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(63896);
    }
}
