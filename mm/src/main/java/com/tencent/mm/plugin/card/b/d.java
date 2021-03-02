package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d implements i, k.a, com.tencent.mm.plugin.card.base.d {
    public WeakReference<Context> mContextRef;
    public List<WeakReference<a>> pQG = new ArrayList();
    public HashMap<a, Boolean> pQS = new HashMap<>();
    public HashMap<String, Boolean> pQT = new HashMap<>();
    public HashMap<String, Boolean> pQU = new HashMap<>();
    public b pQV = null;
    public boolean pQW = false;
    public String pQX;

    public interface a {
        void ajc(String str);

        void ctp();

        void ctq();

        void d(b bVar);
    }

    public d() {
        AppMethodBeat.i(112598);
        AppMethodBeat.o(112598);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(112600);
        if (this.pQG == null) {
            this.pQG = new ArrayList();
        }
        this.pQG.add(new WeakReference<>(aVar));
        AppMethodBeat.o(112600);
    }

    public final void b(a aVar) {
        a aVar2;
        AppMethodBeat.i(112601);
        if (this.pQG == null) {
            AppMethodBeat.o(112601);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (weakReference != null && (aVar2 = weakReference.get()) != null && aVar2.equals(aVar)) {
                this.pQG.remove(weakReference);
                AppMethodBeat.o(112601);
                return;
            }
        }
        AppMethodBeat.o(112601);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(112602);
        this.pQV = bVar;
        if (this.pQW && this.pQV != null && bVar.csU() != null && !bVar.csU().equals(this.pQV.csU())) {
            this.pQW = false;
        }
        if (this.pQG == null) {
            AppMethodBeat.o(112602);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (weakReference != null) {
                a aVar = weakReference.get();
                Boolean bool = this.pQS.get(aVar);
                if (!(aVar == null || bool == null || bool.booleanValue())) {
                    aVar.d(bVar);
                }
            }
        }
        AppMethodBeat.o(112602);
    }

    public final void a(a aVar, boolean z) {
        AppMethodBeat.i(112603);
        if (this.pQS == null) {
            this.pQS = new HashMap<>();
        }
        this.pQS.put(aVar, Boolean.valueOf(z));
        AppMethodBeat.o(112603);
    }

    public final void c(a aVar) {
        AppMethodBeat.i(112604);
        if (this.pQS == null) {
            this.pQS = new HashMap<>();
        }
        this.pQS.remove(aVar);
        AppMethodBeat.o(112604);
    }

    @Override // com.tencent.mm.plugin.card.base.d
    public final void ctb() {
        ShareCardInfo ajk;
        AppMethodBeat.i(112605);
        Log.i("MicroMsg.CardConsumedMgr", "onDBchange()");
        if (this.pQV == null) {
            Log.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
            AppMethodBeat.o(112605);
            return;
        }
        if (this.pQV.csw()) {
            ajk = am.ctY().ajA(this.pQV.csU());
        } else {
            ajk = am.ctQ().ajk(this.pQV.csU());
        }
        if (!(ajk == null || ajk.csR() == null || this.pQV == null || this.pQV.csR() == null)) {
            int i2 = this.pQV.csR().status;
            Log.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", Integer.valueOf(i2), Integer.valueOf(ajk.csR().status), Boolean.valueOf(this.pQW), Boolean.valueOf(this.pQV.csw()));
            if (this.pQV.csw() && (this.pQV instanceof ShareCardInfo)) {
                Log.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", Integer.valueOf(((ShareCardInfo) this.pQV).field_status));
            } else if (this.pQV.csw()) {
                Log.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
            }
            if (ajk.csR().status != i2) {
                ctl();
                if (this.pQV.csw() && !this.pQW && ajk.csR().status == 1) {
                    Log.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
                    Boolean bool = this.pQT.get(this.pQV.csU());
                    if (bool == null || !bool.booleanValue()) {
                        Log.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.pQV.csU());
                        com.tencent.mm.plugin.card.sharecard.a.b.a(this.mContextRef.get(), this.pQV);
                        this.pQT.put(this.pQV.csU(), Boolean.TRUE);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ArrayList<IDKey> arrayList = new ArrayList<>();
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(281);
                        iDKey.SetKey(30);
                        iDKey.SetValue(1);
                        IDKey iDKey2 = new IDKey();
                        iDKey2.SetID(281);
                        iDKey2.SetKey(31);
                        iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                        arrayList.add(iDKey);
                        arrayList.add(iDKey2);
                        h.INSTANCE.b(arrayList, true);
                    } else {
                        Log.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                    }
                    ctn();
                } else if (!this.pQV.csw() || !this.pQW) {
                    Log.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
                    ctm();
                } else {
                    Log.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
                }
                Log.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
            }
            this.pQV = ajk;
            c(this.pQV);
        }
        AppMethodBeat.o(112605);
    }

    @Override // com.tencent.mm.plugin.card.b.k.a
    public final void onChange() {
        AppMethodBeat.i(112606);
        ctl();
        AppMethodBeat.o(112606);
    }

    @Override // com.tencent.mm.plugin.card.b.k.a
    public final void a(g gVar) {
        AppMethodBeat.i(112607);
        Log.i("MicroMsg.CardConsumedMgr", "onChange()");
        Log.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.pQV == null) {
            Log.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
            ctm();
            AppMethodBeat.o(112607);
            return;
        }
        Log.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.pQV.csv() && gVar.field_card_id != null && gVar.field_card_id.equals(this.pQV.csU()) && gVar.pTF == 3) {
            Log.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
            ctm();
            AppMethodBeat.o(112607);
        } else if (!this.pQV.csw()) {
            Log.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
            ctm();
            AppMethodBeat.o(112607);
        } else {
            if (gVar.pTF == 3 || (gVar.field_card_id != null && gVar.field_card_id.equals(this.pQV.csU()) && !TextUtils.isEmpty(gVar.field_consumed_box_id))) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
                if (gVar.field_card_id != null && gVar.field_card_id.equals(this.pQV.csU())) {
                    ShareCardInfo ajA = am.ctY().ajA(this.pQV.csU());
                    if (!(ajA == null || ajA.csR() == null)) {
                        int i2 = this.pQV.csR().status;
                        Log.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", Integer.valueOf(i2), Integer.valueOf(ajA.csR().status), Integer.valueOf(((ShareCardInfo) this.pQV).field_status));
                        if (ajA.csR().status != i2) {
                            ctl();
                        } else if (i2 != 1) {
                            Log.i("MicroMsg.CardConsumedMgr", "share card oldState status is ".concat(String.valueOf(i2)));
                            ty csR = this.pQV.csR();
                            csR.status = 1;
                            ((ShareCardInfo) this.pQV).field_status = 1;
                            this.pQV.a(csR);
                            l.h(this.pQV);
                        }
                    }
                } else if (gVar.field_card_id != null) {
                    ShareCardInfo ajA2 = am.ctY().ajA(gVar.field_card_id);
                    if (ajA2 == null || ajA2.csR() == null) {
                        Log.w("MicroMsg.CardConsumedMgr", "tempCard is null");
                    } else {
                        Log.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", Integer.valueOf(ajA2.csR().status), Integer.valueOf(ajA2.field_status));
                        if (ajA2.csR().status != 1) {
                            ty csR2 = ajA2.csR();
                            csR2.status = 1;
                            ajA2.field_status = 1;
                            ajA2.a(csR2);
                            l.h(ajA2);
                        }
                    }
                }
                c(this.pQV);
                Boolean bool = this.pQT.get(this.pQV.csU());
                if (bool == null || !bool.booleanValue()) {
                    Log.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.pQV.csU());
                    com.tencent.mm.plugin.card.sharecard.a.b.a(this.mContextRef.get(), this.pQV);
                    this.pQT.put(this.pQV.csU(), Boolean.TRUE);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList<IDKey> arrayList = new ArrayList<>();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(30);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(31);
                    iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    h.INSTANCE.b(arrayList, true);
                } else {
                    Log.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                }
                ctn();
            }
            AppMethodBeat.o(112607);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112608);
        Log.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) qVar;
                if (!TextUtils.isEmpty(dVar.pTY)) {
                    ajb(dVar.pTY);
                } else {
                    Log.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
                }
                this.pQW = false;
                Log.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
                ctm();
                AppMethodBeat.o(112608);
                return;
            }
        } else if (qVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
            this.pQW = false;
            Log.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
            ctm();
            AppMethodBeat.o(112608);
            return;
        }
        AppMethodBeat.o(112608);
    }

    private void ajb(String str) {
        AppMethodBeat.i(112609);
        Log.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
        if (this.pQG == null) {
            AppMethodBeat.o(112609);
            return;
        }
        int i2 = 0;
        boolean z = false;
        while (i2 < this.pQG.size()) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (weakReference != null) {
                a aVar = weakReference.get();
                Boolean bool = this.pQS.get(aVar);
                if (!(aVar == null || bool == null || !bool.booleanValue())) {
                    aVar.ajc(str);
                    z = true;
                }
            }
            i2++;
            z = z;
        }
        Boolean bool2 = this.pQT.get(this.pQV.csU());
        if (z) {
            Log.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
            this.pQX = "";
            AppMethodBeat.o(112609);
            return;
        }
        if (bool2 != null && bool2.booleanValue()) {
            Log.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
            this.pQX = str;
            this.pQU.put(this.pQV.csU(), Boolean.TRUE);
        }
        AppMethodBeat.o(112609);
    }

    private void c(b bVar) {
        a aVar;
        AppMethodBeat.i(112610);
        Log.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
        if (this.pQG == null) {
            AppMethodBeat.o(112610);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.d(bVar);
            }
        }
        AppMethodBeat.o(112610);
    }

    private void ctl() {
        a aVar;
        AppMethodBeat.i(112611);
        Log.i("MicroMsg.CardConsumedMgr", "doVibrate()");
        if (this.pQG == null) {
            AppMethodBeat.o(112611);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.ctp();
            }
        }
        AppMethodBeat.o(112611);
    }

    private void ctm() {
        a aVar;
        AppMethodBeat.i(112612);
        Log.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
        if (this.pQG == null) {
            AppMethodBeat.o(112612);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.ctq();
            }
        }
        AppMethodBeat.o(112612);
    }

    private void ctn() {
        AppMethodBeat.i(112613);
        Log.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
        cto();
        AppMethodBeat.o(112613);
    }

    private synchronized void cto() {
        AppMethodBeat.i(112614);
        if (this.pQW) {
            Log.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is true, is doing NetSceneGetShareCardConsumedInfo. return");
            AppMethodBeat.o(112614);
        } else {
            Log.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is false, do NetSceneGetShareCardConsumedInfo. ");
            this.pQW = true;
            com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.card.sharecard.model.d(this.pQV.csU(), "", ""), 0);
            AppMethodBeat.o(112614);
        }
    }

    public final void release() {
        com.tencent.mm.plugin.card.base.d dVar;
        AppMethodBeat.i(112599);
        com.tencent.mm.kernel.g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.f.b.CTRL_INDEX, this);
        am.ctX().b(this);
        b ctP = am.ctP();
        if (ctP.pQG != null) {
            int i2 = 0;
            while (true) {
                if (i2 < ctP.pQG.size()) {
                    WeakReference<com.tencent.mm.plugin.card.base.d> weakReference = ctP.pQG.get(i2);
                    if (weakReference != null && (dVar = weakReference.get()) != null && dVar.equals(this)) {
                        ctP.pQG.remove(weakReference);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        this.pQG.clear();
        this.pQS.clear();
        this.pQU.clear();
        this.pQW = false;
        AppMethodBeat.o(112599);
    }
}
