package com.tencent.mm.plugin.card.sharecard.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.e;
import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.plugin.card.sharecard.model.n;
import com.tencent.mm.plugin.card.sharecard.model.o;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a implements i {
    public byte[] lock = new byte[0];
    public MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private Runnable mRunnable = new Runnable() {
        /* class com.tencent.mm.plugin.card.sharecard.a.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(112909);
            Log.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
            g.aAg().hqi.a(new h(), 0);
            AppMethodBeat.o(112909);
        }
    };
    public List<n> pQE = new ArrayList();
    private List<WeakReference<d>> pQG = new ArrayList();
    public e pVH;
    private int pVI = 0;
    public int pVJ = 5;
    public List<n> pendingList = am.ctZ().ctO();

    public a() {
        AppMethodBeat.i(112911);
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr <init>, init pending list size = %d", Integer.valueOf(this.pendingList.size()));
        g.aAg().hqi.a(1132, this);
        AppMethodBeat.o(112911);
    }

    public final void a(dxh dxh) {
        AppMethodBeat.i(112912);
        if (dxh == null) {
            Log.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
            AppMethodBeat.o(112912);
            return;
        }
        ShareCardInfo ajA = am.ctY().ajA(dxh.eaO);
        Object[] objArr = new Object[3];
        objArr[0] = dxh.eaO;
        objArr[1] = Long.valueOf(ajA == null ? 0 : ajA.field_updateSeq);
        objArr[2] = Long.valueOf(dxh.seq);
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d", objArr);
        if (ajA == null || ajA.field_updateSeq != dxh.seq) {
            n c2 = n.c(dxh);
            synchronized (this.lock) {
                try {
                    if (!this.pendingList.contains(c2)) {
                        if (this.pQE.contains(c2)) {
                            AppMethodBeat.o(112912);
                            return;
                        }
                        this.pendingList.add(c2);
                        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", Boolean.valueOf(am.ctZ().insert(c2)));
                        AppMethodBeat.o(112912);
                    }
                } finally {
                    AppMethodBeat.o(112912);
                }
            }
        } else {
            Log.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
            AppMethodBeat.o(112912);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        if (r6.pVH == null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr getNow, already doing scene, not trigger now");
        com.tencent.matrix.trace.core.AppMethodBeat.o(112913);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        r3 = new java.util.LinkedList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        if (r0.size() > 10) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        r3.addAll(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r4 = new java.util.LinkedList();
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        if (r1 >= r3.size()) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        r4.add(((com.tencent.mm.plugin.card.sharecard.model.n) r3.get(r1)).field_card_id);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
        r3.addAll(r0.subList(0, 10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0075, code lost:
        r6.pVH = new com.tencent.mm.plugin.card.sharecard.model.e(r4);
        com.tencent.mm.kernel.g.aAg().hqi.a(r6.pVH, 0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(112913);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ctd() {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.sharecard.a.a.ctd():void");
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112914);
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.pVH = null;
        if (i2 == 0 && i3 == 0) {
            ArrayList<n> S = S(((e) qVar).pUd);
            Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd, batch get succ, remove succ id list, size = %d", Integer.valueOf(S.size()));
            synchronized (this.lock) {
                try {
                    this.pendingList.removeAll(S);
                } catch (Throwable th) {
                    AppMethodBeat.o(112914);
                    throw th;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
            o ctZ = am.ctZ();
            if (S.size() == 0) {
                Log.e("MicroMsg.ShareCardSyncItemInfoStorage", "deleteList fail, share card list is empty");
            } else {
                for (n nVar : S) {
                    if (nVar != null) {
                        ctZ.delete(nVar, new String[0]);
                    }
                }
            }
            g.aAh().hqK.endTransaction(beginTransaction);
            Log.i("MicroMsg.ShareCardBatchGetCardMgr", "onSceneEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            ctd();
            onChange();
            AppMethodBeat.o(112914);
            return;
        }
        Log.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr onSceneEnd fail, stop batch get, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        ArrayList<n> S2 = S(((e) qVar).pUc);
        synchronized (this.lock) {
            try {
                if (S2.size() > 0) {
                    this.pendingList.removeAll(S2);
                    this.pQE.addAll(S2);
                }
            } finally {
                AppMethodBeat.o(112914);
            }
        }
        o ctZ2 = am.ctZ();
        if (S2.size() == 0) {
            Log.e("MicroMsg.ShareCardSyncItemInfoStorage", "increaseRetryCount fail, share card list is empty");
            AppMethodBeat.o(112914);
            return;
        }
        for (n nVar2 : S2) {
            if (nVar2 != null) {
                nVar2.field_retryCount++;
                ctZ2.update(nVar2, new String[0]);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.ArrayList<com.tencent.mm.plugin.card.sharecard.model.n> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        if (r2 >= r9.size()) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        r0 = r9.get(r2);
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r4 >= r6.size()) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (r0 == null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r6.get(r4) == null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        if (r0.equals(((com.tencent.mm.plugin.card.sharecard.model.n) r6.get(r4)).field_card_id) == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
        r5.add(r6.get(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0070, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(112915);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.ArrayList<com.tencent.mm.plugin.card.sharecard.model.n> S(java.util.LinkedList<java.lang.String> r9) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.sharecard.a.a.S(java.util.LinkedList):java.util.ArrayList");
    }

    public final void cuu() {
        int i2;
        AppMethodBeat.i(112916);
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i3 = currentTimeMillis - this.pVI;
        if (this.pVJ <= 0) {
            i2 = 5;
        } else {
            i2 = this.pVJ;
        }
        if (i3 >= i2) {
            g.aAg().hqi.a(new h(), 0);
        } else {
            Log.i("MicroMsg.ShareCardBatchGetCardMgr", "sync interval is ".concat(String.valueOf(i3)));
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mHandler.postDelayed(this.mRunnable, (long) (i2 * 1000));
        }
        this.pVI = currentTimeMillis;
        AppMethodBeat.o(112916);
    }

    public final void onChange() {
        d dVar;
        AppMethodBeat.i(112917);
        if (this.pQG == null) {
            AppMethodBeat.o(112917);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<d> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (dVar = weakReference.get()) == null)) {
                dVar.ctb();
            }
        }
        AppMethodBeat.o(112917);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(112918);
        if (this.pQG == null) {
            this.pQG = new ArrayList();
        }
        this.pQG.add(new WeakReference<>(dVar));
        AppMethodBeat.o(112918);
    }

    public final void b(d dVar) {
        d dVar2;
        AppMethodBeat.i(112919);
        if (this.pQG == null) {
            AppMethodBeat.o(112919);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<d> weakReference = this.pQG.get(i2);
            if (weakReference != null && (dVar2 = weakReference.get()) != null && dVar2.equals(dVar)) {
                this.pQG.remove(weakReference);
                AppMethodBeat.o(112919);
                return;
            }
        }
        AppMethodBeat.o(112919);
    }
}
