package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class y extends q implements m {
    private i callback;
    private final d rr;

    public y() {
        AppMethodBeat.i(112831);
        d.a aVar = new d.a();
        aVar.iLN = new bkd();
        aVar.iLO = new bke();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardcount";
        aVar.funcId = 1088;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(112831);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1088;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112832);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112832);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112833);
        Log.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + i3 + " errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            bke bke = (bke) this.rr.iLL.iLR;
            Log.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + bke.LTr + " has_share_card:" + bke.LTs);
            if (bke.LTr > 0) {
                l.cxE();
                if (TextUtils.isEmpty((String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, (Object) null))) {
                    am.ctP();
                    b.Ef(1);
                }
            }
            if (bke.LTs > 0) {
                l.cxG();
                Long l = (Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_CARD_REQUENCE_LONG_SYNC, (Object) 0L);
                if (l != null && l.longValue() == 0) {
                    am.ctX().cuu();
                }
            }
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(282882, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112833);
    }
}
