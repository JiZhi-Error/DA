package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements i {
    public int gVP;
    public List<WeakReference<a>> pQG = new ArrayList();
    public c pRd;
    public MTimerHandler pRe = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.card.b.g.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            a aVar;
            AppMethodBeat.i(112624);
            Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
            g gVar = g.this;
            Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
            if (gVar.pQG != null) {
                for (int i2 = 0; i2 < gVar.pQG.size(); i2++) {
                    WeakReference<a> weakReference = gVar.pQG.get(i2);
                    if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                        aVar.ctv();
                    }
                }
            }
            AppMethodBeat.o(112624);
            return true;
        }
    }, false);

    public interface a {
        void aM(int i2, String str);

        void b(c cVar);

        void c(c cVar);

        void ctv();
    }

    public g() {
        AppMethodBeat.i(112625);
        AppMethodBeat.o(112625);
    }

    public final void release() {
        AppMethodBeat.i(112626);
        this.gVP = 0;
        ctj();
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
        com.tencent.mm.kernel.g.aAg().hqi.b(1382, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(1275, this);
        AppMethodBeat.o(112626);
    }

    public final void a(b bVar, r rVar) {
        AppMethodBeat.i(112627);
        if (!e(bVar)) {
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
            ak(2, "");
            AppMethodBeat.o(112627);
        } else if (!l.isNetworkAvailable(MMApplicationContext.getContext())) {
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
            ak(-1, "");
            AppMethodBeat.o(112627);
        } else if (this.gVP >= 3) {
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.gVP + ",cannot request!");
            AppMethodBeat.o(112627);
        } else {
            a(bVar.csU(), rVar);
            this.gVP++;
            AppMethodBeat.o(112627);
        }
    }

    public final void a(r rVar) {
        boolean z;
        AppMethodBeat.i(112628);
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", Integer.valueOf(rVar.scene));
        List<CardInfo> ctG = am.ctQ().ctG();
        if (ctG == null || ctG.isEmpty()) {
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", Integer.valueOf(rVar.scene));
            AppMethodBeat.o(112628);
            return;
        }
        for (CardInfo cardInfo : ctG) {
            if (cardInfo == null) {
                Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", Integer.valueOf(rVar.scene));
            } else if (rVar == null) {
                Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
            } else {
                Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", cardInfo.csU(), Integer.valueOf(rVar.scene));
                if (!e(cardInfo)) {
                    Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", cardInfo.csU());
                } else {
                    String csU = cardInfo.csU();
                    com.tencent.mm.plugin.card.model.i ajl = am.cuf().ajl(csU);
                    if (ajl == null) {
                        z = true;
                    } else {
                        List<k> ajm = am.cue().ajm(csU);
                        if (ajm.isEmpty()) {
                            z = true;
                        } else if (ajm.size() < ajl.field_lower_bound) {
                            this.pRd = c.CARDCODEREFRESHACTION_UPDATECHANGE;
                            z = true;
                        } else if (a(ajl)) {
                            this.pRd = c.CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT;
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (!z) {
                        Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", cardInfo.csU(), Integer.valueOf(rVar.scene));
                    } else {
                        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", Integer.valueOf(rVar.scene));
                        a(cardInfo.csU(), rVar);
                    }
                }
            }
        }
        AppMethodBeat.o(112628);
    }

    public final void b(com.tencent.mm.plugin.card.model.g gVar) {
        AppMethodBeat.i(112629);
        String str = gVar.field_card_id;
        com.tencent.mm.plugin.card.model.l cue = am.cue();
        if (gVar.pTG) {
            List<k> ajm = am.cue().ajm(str);
            k ajo = cue.ajo(str);
            Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", str);
            if (cue.gC(str)) {
                if (ajo != null) {
                    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", str);
                    b(c.CARDCODEREFRESHACTION_BANCODE);
                }
                a(str, ajm, c.CARDCODEREFRESHACTION_BANCODE);
            }
            AppMethodBeat.o(112629);
            return;
        }
        List<g.c> list = gVar.pTH;
        if (list == null) {
            Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", str);
            AppMethodBeat.o(112629);
            return;
        }
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", str, Integer.valueOf(list.size()));
        k ajo2 = cue.ajo(str);
        LinkedList<cxh> linkedList = new LinkedList<>();
        for (g.c cVar : list) {
            if (am.cue().fr(str, cVar.pTM)) {
                linkedList.add(b(str, cVar.pTM, c.CARDCODEREFRESHACTION_BANCODE));
            }
        }
        if (ajo2 != null) {
            Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", str, ajo2.field_code_id);
            b(c.CARDCODEREFRESHACTION_BANCODE);
        }
        if (!linkedList.isEmpty()) {
            Q(linkedList);
        }
        AppMethodBeat.o(112629);
    }

    public static boolean a(com.tencent.mm.plugin.card.model.i iVar) {
        AppMethodBeat.i(112630);
        if (System.currentTimeMillis() - iVar.field_fetch_time > ((long) (iVar.field_expire_time_interval * 1000))) {
            Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(iVar.field_fetch_time), Integer.valueOf(iVar.field_expire_time_interval));
            AppMethodBeat.o(112630);
            return true;
        }
        AppMethodBeat.o(112630);
        return false;
    }

    public final void ctj() {
        AppMethodBeat.i(112631);
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
        if (!this.pRe.stopped()) {
            this.pRe.stopTimer();
        }
        AppMethodBeat.o(112631);
    }

    private static boolean e(b bVar) {
        AppMethodBeat.i(112632);
        if (bVar == null) {
            AppMethodBeat.o(112632);
            return false;
        } else if (bVar.csR() == null || !bVar.csR().LcG) {
            Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
            AppMethodBeat.o(112632);
            return false;
        } else {
            AppMethodBeat.o(112632);
            return true;
        }
    }

    private void a(String str, r rVar) {
        int i2;
        int i3;
        AppMethodBeat.i(112633);
        StringBuilder append = new StringBuilder("doNetSceneGetDynamicQrcode, cardId:").append(str).append(",scene :");
        if (rVar == null) {
            i2 = 0;
        } else {
            i2 = rVar.scene;
        }
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", append.append(i2).toString());
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        if (rVar == null) {
            i3 = 0;
        } else {
            i3 = rVar.scene;
        }
        ae aeVar = new ae(linkedList, i3);
        com.tencent.mm.kernel.g.aAg().hqi.a(1382, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(aeVar, 0);
        AppMethodBeat.o(112633);
    }

    private void a(String str, List<k> list, c cVar) {
        AppMethodBeat.i(112634);
        if (cVar == null) {
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
            AppMethodBeat.o(112634);
            return;
        }
        LinkedList<cxh> linkedList = new LinkedList<>();
        for (k kVar : list) {
            linkedList.add(b(str, kVar.field_code_id, cVar));
        }
        Q(linkedList);
        AppMethodBeat.o(112634);
    }

    public final void a(String str, String str2, c cVar) {
        AppMethodBeat.i(112635);
        LinkedList<cxh> linkedList = new LinkedList<>();
        linkedList.add(b(str, str2, cVar));
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", Integer.valueOf(linkedList.size()), Integer.valueOf(cVar.action));
        Q(linkedList);
        AppMethodBeat.o(112635);
    }

    private void Q(LinkedList<cxh> linkedList) {
        AppMethodBeat.i(112636);
        com.tencent.mm.kernel.g.aAg().hqi.a(1275, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(new ah(linkedList), 0);
        AppMethodBeat.o(112636);
    }

    private static cxh b(String str, String str2, c cVar) {
        int i2;
        AppMethodBeat.i(112637);
        cxh cxh = new cxh();
        cxh.eaO = str;
        cxh.pTM = str2;
        cxh.MBP = new Long(System.currentTimeMillis() / 1000).intValue();
        if (cVar == null) {
            i2 = -1;
        } else {
            i2 = cVar.action;
        }
        cxh.MBQ = i2;
        AppMethodBeat.o(112637);
        return cxh;
    }

    private void a(dgv dgv) {
        AppMethodBeat.i(112638);
        if (dgv == null) {
            AppMethodBeat.o(112638);
            return;
        }
        String str = dgv.eaO;
        if (am.cuf().ajl(str) == null) {
            am.cuf().insert(b(dgv));
        } else {
            am.cuf().update(b(dgv), new String[0]);
        }
        List<k> ajm = am.cue().ajm(str);
        if (!ajm.isEmpty() && am.cue().gC(str) && this.pRd != null) {
            a(str, ajm, this.pRd);
        }
        Iterator<dgu> it = dgv.MLq.iterator();
        while (it.hasNext()) {
            dgu next = it.next();
            k kVar = new k();
            kVar.field_card_id = str;
            kVar.field_code_id = next.pTM;
            kVar.field_code = e.fy(str, next.data);
            am.cue().insert(kVar);
        }
        AppMethodBeat.o(112638);
    }

    private static com.tencent.mm.plugin.card.model.i b(dgv dgv) {
        AppMethodBeat.i(112639);
        com.tencent.mm.plugin.card.model.i iVar = new com.tencent.mm.plugin.card.model.i();
        iVar.field_card_id = dgv.eaO;
        iVar.field_lower_bound = dgv.MLl;
        iVar.field_expire_time_interval = dgv.MLo;
        iVar.field_need_insert_show_timestamp = dgv.MLm;
        iVar.field_show_expire_interval = dgv.MLp;
        iVar.field_show_timestamp_encrypt_key = dgv.MLn;
        iVar.field_fetch_time = System.currentTimeMillis();
        AppMethodBeat.o(112639);
        return iVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112640);
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i2 + " errCode = " + i3 + ",NetSceneBase=" + (qVar != null ? qVar.getClass() : ""));
        if (i2 != 0 || i3 != 0) {
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i2 + " errCode = " + i3 + " cmd:" + (qVar != null ? qVar.getType() : 0) + "  NetSceneBase=" + (qVar != null ? qVar.getClass() : ""));
            if (qVar instanceof ae) {
                ak(i3, str);
                com.tencent.mm.kernel.g.aAg().hqi.b(1382, this);
                AppMethodBeat.o(112640);
                return;
            }
            com.tencent.mm.kernel.g.aAg().hqi.b(1275, this);
            AppMethodBeat.o(112640);
        } else if (qVar instanceof ae) {
            dgv dgv = ((ae) qVar).pUr;
            if (dgv == null) {
                Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
                AppMethodBeat.o(112640);
                return;
            }
            a(dgv);
            a(this.pRd);
            com.tencent.mm.kernel.g.aAg().hqi.b(1382, this);
            AppMethodBeat.o(112640);
        } else {
            com.tencent.mm.kernel.g.aAg().hqi.b(1275, this);
            AppMethodBeat.o(112640);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(112641);
        if (this.pQG == null) {
            this.pQG = new ArrayList();
        }
        this.pQG.add(new WeakReference<>(aVar));
        AppMethodBeat.o(112641);
    }

    private void a(c cVar) {
        a aVar;
        AppMethodBeat.i(112642);
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
        if (this.pQG == null) {
            AppMethodBeat.o(112642);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.c(cVar);
            }
        }
        AppMethodBeat.o(112642);
    }

    public final void ak(int i2, String str) {
        a aVar;
        AppMethodBeat.i(112643);
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
        if (this.pQG == null) {
            AppMethodBeat.o(112643);
            return;
        }
        for (int i3 = 0; i3 < this.pQG.size(); i3++) {
            WeakReference<a> weakReference = this.pQG.get(i3);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.aM(i2, str);
            }
        }
        AppMethodBeat.o(112643);
    }

    private void b(c cVar) {
        a aVar;
        AppMethodBeat.i(112644);
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
        if (this.pQG == null) {
            AppMethodBeat.o(112644);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.b(cVar);
            }
        }
        AppMethodBeat.o(112644);
    }
}
