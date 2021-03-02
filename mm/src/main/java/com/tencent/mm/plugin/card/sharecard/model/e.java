package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends q implements m {
    private i callback;
    public LinkedList<String> pUc;
    public LinkedList<String> pUd = new LinkedList<>();
    private final d rr;

    public e(LinkedList<String> linkedList) {
        AppMethodBeat.i(112966);
        this.pUc = linkedList;
        d.a aVar = new d.a();
        aVar.iLN = new bvd();
        aVar.iLO = new bve();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
        aVar.funcId = 1132;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((bvd) this.rr.iLK.iLR).KOl = linkedList;
        Log.i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + linkedList.size());
        AppMethodBeat.o(112966);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112967);
        Log.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(getType()), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            bve bve = (bve) this.rr.iLL.iLR;
            Log.v("MicroMsg.NetSceneGetShareCardList", "json:" + bve.pTY);
            String str2 = bve.pTY;
            if (TextUtils.isEmpty(str2)) {
                Log.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
                this.callback.onSceneEnd(4, -1, null, this);
                AppMethodBeat.o(112967);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<ShareCardInfo> ajW = f.ajW(str2);
            if (ajW != null) {
                if (this.pUc != null) {
                    this.pUd.addAll(this.pUc);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
                int i5 = 0;
                Iterator<ShareCardInfo> it = ajW.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    ShareCardInfo next = it.next();
                    i5++;
                    if (!l.a(next)) {
                        i6++;
                        this.pUd.remove(next.field_card_id);
                    } else {
                        Log.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
                        b.al(MMApplicationContext.getContext(), next.field_card_tp_id);
                        if (next.field_status != 0) {
                            b.fs(next.field_card_id, next.field_card_tp_id);
                        }
                    }
                }
                g.aAh().hqK.endTransaction(beginTransaction);
                Log.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                Log.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", Integer.valueOf(i6), Integer.valueOf(i5));
                l.cxG();
                if (ajW.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList<IDKey> arrayList = new ArrayList<>();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(17);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(18);
                    iDKey2.SetValue((long) currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(19);
                    iDKey3.SetValue((long) ajW.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(21);
                    iDKey4.SetValue((long) (currentTimeMillis3 / ajW.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    h.INSTANCE.b(arrayList, true);
                }
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(112967);
            return;
        }
        Log.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112967);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1132;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(112968);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112968);
        return dispatch;
    }
}
