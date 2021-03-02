package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ki;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends q implements m {
    private i callback;
    private LinkedList<ak> pUc;
    public LinkedList<ak> pUd = new LinkedList<>();
    private final d rr;

    public s(LinkedList<ak> linkedList) {
        AppMethodBeat.i(112811);
        this.pUc = linkedList;
        d.a aVar = new d.a();
        aVar.iLN = new ki();
        aVar.iLO = new kj();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
        aVar.funcId = 1074;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((ki) this.rr.iLK.iLR).KOl = R(linkedList);
        AppMethodBeat.o(112811);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1074;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112812);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112812);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(112813);
        Log.d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            String str2 = ((kj) this.rr.iLL.iLR).pTY;
            if (TextUtils.isEmpty(str2)) {
                Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.callback.onSceneEnd(4, -1, null, this);
                AppMethodBeat.o(112813);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<CardInfo> ajX = f.ajX(str2);
            if (ajX != null) {
                if (this.pUc != null) {
                    this.pUd.addAll(this.pUc);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                long beginTransaction = com.tencent.mm.kernel.g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
                int i5 = 0;
                Iterator<CardInfo> it = ajX.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    CardInfo next = it.next();
                    i6++;
                    if (!l.b(next)) {
                        i5++;
                        LinkedList<ak> linkedList = this.pUd;
                        if (next != null) {
                            ak akVar = new ak();
                            akVar.field_cardUserId = next.field_card_id;
                            linkedList.remove(akVar);
                        }
                    }
                    i5 = i5;
                }
                com.tencent.mm.kernel.g.aAh().hqK.endTransaction(beginTransaction);
                Log.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", Integer.valueOf(i5), Integer.valueOf(i6));
                l.cxE();
                if (ajX.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList<IDKey> arrayList = new ArrayList<>();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(43);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(44);
                    iDKey2.SetValue((long) currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(45);
                    iDKey3.SetValue((long) ajX.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(47);
                    iDKey4.SetValue((long) (currentTimeMillis3 / ajX.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    h.INSTANCE.b(arrayList, true);
                }
            }
            this.callback.onSceneEnd(0, 0, str, this);
            AppMethodBeat.o(112813);
            return;
        }
        Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112813);
    }

    private static LinkedList<String> R(LinkedList<ak> linkedList) {
        AppMethodBeat.i(112814);
        LinkedList<String> linkedList2 = new LinkedList<>();
        if (linkedList == null || linkedList.size() == 0) {
            AppMethodBeat.o(112814);
            return linkedList2;
        }
        Iterator<ak> it = linkedList.iterator();
        while (it.hasNext()) {
            ak next = it.next();
            if (next != null) {
                linkedList2.add(next.field_cardUserId);
            }
        }
        AppMethodBeat.o(112814);
        return linkedList2;
    }
}
