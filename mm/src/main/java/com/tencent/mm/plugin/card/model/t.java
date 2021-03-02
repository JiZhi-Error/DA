package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;

public final class t extends q implements m {
    private i callback;
    public String cardId;
    public LinkedList<CardInfo> pUe;
    private final d rr;

    public t(LinkedList<va> linkedList, eck eck, int i2) {
        this(linkedList, eck, i2, "");
    }

    public t(LinkedList<va> linkedList, eck eck, int i2, String str) {
        AppMethodBeat.i(112815);
        this.pUe = new LinkedList<>();
        d.a aVar = new d.a();
        aVar.iLN = new kg();
        aVar.iLO = new kh();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
        aVar.funcId = 1099;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        kg kgVar = (kg) this.rr.iLK.iLR;
        kgVar.iAd = linkedList;
        kgVar.KDj = eck;
        kgVar.eaQ = i2;
        this.cardId = str;
        AppMethodBeat.o(112815);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1099;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112816);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112816);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112817);
        Log.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            String str2 = ((kh) this.rr.iLL.iLR).pTY;
            if (TextUtils.isEmpty(str2)) {
                Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.callback.onSceneEnd(4, -1, null, this);
                AppMethodBeat.o(112817);
                return;
            }
            ArrayList<CardInfo> ajX = f.ajX(str2);
            if (ajX != null) {
                l.cxE();
                this.pUe.addAll(ajX);
            }
            this.callback.onSceneEnd(0, 0, str, this);
            AppMethodBeat.o(112817);
            return;
        }
        Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112817);
    }
}
