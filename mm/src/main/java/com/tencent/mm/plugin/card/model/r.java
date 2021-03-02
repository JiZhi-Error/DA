package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ju;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends q implements m {
    private i callback;
    private int gJY = 0;
    private final d rr;

    public r(LinkedList<String> linkedList) {
        AppMethodBeat.i(112808);
        d.a aVar = new d.a();
        aVar.iLN = new ju();
        aVar.iLO = new jv();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
        aVar.funcId = 1077;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((ju) this.rr.iLK.iLR).KOl = linkedList;
        AppMethodBeat.o(112808);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1077;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112809);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112809);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean delete;
        AppMethodBeat.i(112810);
        Log.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            LinkedList<String> linkedList = ((jv) this.rr.iLL.iLR).KOm;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            Log.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, resp list count = %d", objArr);
            if (linkedList == null || linkedList.size() == 0) {
                Log.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
            } else {
                this.gJY = 0;
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (TextUtils.isEmpty(next)) {
                        Log.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
                        delete = false;
                    } else {
                        CardInfo cardInfo = new CardInfo();
                        cardInfo.field_card_id = next;
                        delete = am.ctQ().delete(cardInfo, new String[0]);
                        Log.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", Boolean.valueOf(delete));
                    }
                    if (!delete) {
                        this.gJY++;
                    }
                }
                Log.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", Integer.valueOf(this.gJY));
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112810);
    }
}
