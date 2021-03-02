package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.plugin.card.model.w;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b implements i {
    public byte[] lock = new byte[0];
    public List<ak> pQE = new ArrayList();
    private s pQF;
    public List<WeakReference<d>> pQG = new ArrayList();
    public List<ak> pendingList = am.ctR().ctO();

    public b() {
        AppMethodBeat.i(112574);
        Log.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", Integer.valueOf(this.pendingList.size()));
        g.aAg().hqi.a(1074, this);
        AppMethodBeat.o(112574);
    }

    public final void detach() {
        AppMethodBeat.i(112575);
        this.pendingList.clear();
        this.pQE.clear();
        if (this.pQF != null) {
            g.aAg().hqi.a(this.pQF);
        }
        g.aAg().hqi.b(1074, this);
        AppMethodBeat.o(112575);
    }

    public final void a(vb vbVar) {
        AppMethodBeat.i(112576);
        if (vbVar == null) {
            Log.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
            AppMethodBeat.o(112576);
            return;
        }
        CardInfo ajk = am.ctQ().ajk(vbVar.KUk);
        Object[] objArr = new Object[3];
        objArr[0] = vbVar.KUk;
        objArr[1] = Long.valueOf(ajk == null ? 0 : ajk.field_updateSeq);
        objArr[2] = Long.valueOf(vbVar.Lfn);
        Log.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d", objArr);
        if (ajk == null || ajk.field_updateSeq != vbVar.Lfn) {
            ak b2 = ak.b(vbVar);
            synchronized (this.lock) {
                try {
                    if (!this.pendingList.contains(b2)) {
                        if (this.pQE.contains(b2)) {
                            AppMethodBeat.o(112576);
                            return;
                        }
                        this.pendingList.add(b2);
                        Log.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", Boolean.valueOf(am.ctR().insert(b2)));
                        AppMethodBeat.o(112576);
                    }
                } finally {
                    AppMethodBeat.o(112576);
                }
            }
        } else {
            Log.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
            AppMethodBeat.o(112576);
        }
    }

    public final void ctd() {
        AppMethodBeat.i(112577);
        if (this.pendingList.size() == 0) {
            Log.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
            AppMethodBeat.o(112577);
        } else if (this.pQF != null) {
            Log.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
            AppMethodBeat.o(112577);
        } else {
            LinkedList linkedList = new LinkedList();
            if (this.pendingList.size() <= 10) {
                linkedList.addAll(this.pendingList);
            } else {
                linkedList.addAll(this.pendingList.subList(0, 10));
            }
            this.pQF = new s(linkedList);
            g.aAg().hqi.a(this.pQF, 0);
            AppMethodBeat.o(112577);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        d dVar;
        AppMethodBeat.i(112578);
        Log.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.pQF = null;
        LinkedList<ak> linkedList = ((s) qVar).pUd;
        if (i2 == 0 && i3 == 0) {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            Log.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, batch get succ, remove succ id list, size = %d", objArr);
            if (linkedList != null) {
                synchronized (this.lock) {
                    try {
                        this.pendingList.removeAll(linkedList);
                    } catch (Throwable th) {
                        AppMethodBeat.o(112578);
                        throw th;
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
            al ctR = am.ctR();
            if (linkedList == null || linkedList.size() == 0) {
                Log.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
            } else {
                for (ak akVar : linkedList) {
                    if (akVar != null) {
                        ctR.delete(akVar, new String[0]);
                    }
                }
            }
            g.aAh().hqK.endTransaction(beginTransaction);
            Log.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            ctd();
            if (this.pQG != null) {
                for (int i4 = 0; i4 < this.pQG.size(); i4++) {
                    WeakReference<d> weakReference = this.pQG.get(i4);
                    if (!(weakReference == null || (dVar = weakReference.get()) == null)) {
                        dVar.ctb();
                    }
                }
            }
            AppMethodBeat.o(112578);
            return;
        }
        Log.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        synchronized (this.lock) {
            if (linkedList != null) {
                try {
                    if (linkedList.size() > 0) {
                        this.pendingList.removeAll(linkedList);
                        this.pQE.addAll(linkedList);
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(112578);
                    throw th2;
                }
            }
        }
        al ctR2 = am.ctR();
        if (linkedList == null || linkedList.size() == 0) {
            Log.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
            AppMethodBeat.o(112578);
            return;
        }
        for (ak akVar2 : linkedList) {
            if (akVar2 != null) {
                akVar2.field_retryCount++;
                ctR2.update(akVar2, new String[0]);
            }
        }
        AppMethodBeat.o(112578);
    }

    public static void Ef(int i2) {
        AppMethodBeat.i(112579);
        g.aAg().hqi.a(new w(i2), 0);
        AppMethodBeat.o(112579);
    }

    public static void cte() {
        AppMethodBeat.i(112580);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC, (Object) 1)).intValue();
        Log.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is ".concat(String.valueOf(intValue)));
        g.aAg().hqi.a(new ad((double) am.ctW().gmu, (double) am.ctW().gmv, intValue), 0);
        AppMethodBeat.o(112580);
    }
}
