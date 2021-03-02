package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.card.sharecard.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class j implements i {
    private List<WeakReference<a>> pQG = new ArrayList();
    public ArrayList<String> pRC = new ArrayList<>();
    public ArrayList<String> pRD = new ArrayList<>();
    public MMHandler pRE = new MMHandler();
    public HashMap<String, Runnable> pRF = new LinkedHashMap();

    public interface a {
        void ajf(String str);

        void b(String str, b bVar);

        void fq(String str, String str2);
    }

    public static class b {
        public String pRK;
        public int pRL = 0;
        public String pRM;
        public int pRN;
        public String pRO;
    }

    public j() {
        AppMethodBeat.i(112672);
        g.aAg().hqi.a(1078, this);
        this.pRC.clear();
        this.pRD.clear();
        this.pRF.clear();
        AppMethodBeat.o(112672);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(112673);
        if (this.pQG == null) {
            this.pQG = new ArrayList();
        }
        this.pQG.add(new WeakReference<>(aVar));
        AppMethodBeat.o(112673);
    }

    public final void b(a aVar) {
        a aVar2;
        AppMethodBeat.i(112674);
        if (this.pQG == null) {
            AppMethodBeat.o(112674);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (weakReference != null && (aVar2 = weakReference.get()) != null && aVar2.equals(aVar)) {
                this.pQG.remove(weakReference);
                AppMethodBeat.o(112674);
                return;
            }
        }
        AppMethodBeat.o(112674);
    }

    private void a(String str, b bVar) {
        a aVar;
        AppMethodBeat.i(112675);
        Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
        if (this.pQG == null) {
            AppMethodBeat.o(112675);
        } else if (this.pRC.contains(str) || this.pRD.contains(str)) {
            for (int i2 = 0; i2 < this.pQG.size(); i2++) {
                WeakReference<a> weakReference = this.pQG.get(i2);
                if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                    if (this.pRC.contains(str)) {
                        aVar.b(str, bVar);
                    } else if (this.pRD.contains(str)) {
                        aVar.ajf(str);
                    }
                }
            }
            AppMethodBeat.o(112675);
        } else {
            Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
            AppMethodBeat.o(112675);
        }
    }

    private void fp(String str, String str2) {
        a aVar;
        AppMethodBeat.i(112676);
        Log.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
        if (this.pQG == null) {
            AppMethodBeat.o(112676);
        } else if (!this.pRC.contains(str) || this.pRD.contains(str)) {
            Log.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
            AppMethodBeat.o(112676);
        } else {
            for (int i2 = 0; i2 < this.pQG.size(); i2++) {
                WeakReference<a> weakReference = this.pQG.get(i2);
                if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                    aVar.fq(str, str2);
                }
            }
            AppMethodBeat.o(112676);
        }
    }

    private void ajd(String str) {
        AppMethodBeat.i(112677);
        Log.i("MicroMsg.CardMarkCodeMgr", "removeId()");
        if (this.pRC.contains(str) && !this.pRD.contains(str)) {
            this.pRC.remove(str);
            Log.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is ".concat(String.valueOf(str)));
        }
        if (!this.pRC.contains(str) && this.pRD.contains(str)) {
            this.pRD.remove(str);
            this.pRF.remove(str);
            this.pRE.removeCallbacks(this.pRF.get(str));
            Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(str)));
            Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(112677);
    }

    private void aje(String str) {
        AppMethodBeat.i(112678);
        Log.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
        if (this.pRD.contains(str)) {
            this.pRD.remove(str);
            Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is ".concat(String.valueOf(str)));
        }
        if (this.pRF.containsKey(str)) {
            Log.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is ".concat(String.valueOf(str)));
            this.pRF.remove(str);
            this.pRE.removeCallbacks(this.pRF.get(str));
        }
        AppMethodBeat.o(112678);
    }

    public final void V(String str, int i2, int i3) {
        AppMethodBeat.i(112679);
        Log.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
        aje(str);
        if (!this.pRC.contains(str)) {
            this.pRC.add(str);
        }
        k(str, i2, 1, i3);
        AppMethodBeat.o(112679);
    }

    public final void cO(final String str, final int i2) {
        AppMethodBeat.i(112680);
        Log.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
        aje(str);
        this.pRD.add(str);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.card.b.j.AnonymousClass1 */
            final /* synthetic */ int pRH = 0;
            final /* synthetic */ int pRI = 0;

            public final void run() {
                AppMethodBeat.i(112671);
                j.k(str, this.pRH, this.pRI, i2);
                Log.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + str + " system.time:" + System.currentTimeMillis());
                AppMethodBeat.o(112671);
            }
        };
        this.pRE.postDelayed(r0, (long) (Util.getInt(h.aqK().aj("ShareCard", "UnMarkDelay"), 0) * 1000));
        this.pRF.put(str, r0);
        Log.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + str + " system.time:" + System.currentTimeMillis());
        AppMethodBeat.o(112680);
    }

    static void k(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(112681);
        if (TextUtils.isEmpty(str)) {
            Log.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
            AppMethodBeat.o(112681);
            return;
        }
        Log.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
        g.aAg().hqi.a(new f(str, i2, i3, i4), 0);
        AppMethodBeat.o(112681);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112682);
        Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof f) {
                f fVar = (f) qVar;
                b bVar = new b();
                bVar.pRK = fVar.pRK;
                bVar.pRL = fVar.pRL;
                bVar.pRM = fVar.pRM;
                bVar.pRN = fVar.pRN;
                bVar.pRO = fVar.pRO;
                Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + fVar.pVU);
                Log.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + bVar.pRK + " mark_succ:" + bVar.pRL + " mark_card_id:" + bVar.pRM + " expire_time:" + bVar.pRN + " pay_qrcode_wording:" + bVar.pRO);
                a(fVar.pVU, bVar);
                ajd(fVar.pVU);
                AppMethodBeat.o(112682);
                return;
            }
        } else if (qVar instanceof f) {
            f fVar2 = (f) qVar;
            Log.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + fVar2.pVU);
            fp(fVar2.pVU, str);
            ajd(fVar2.pVU);
        }
        AppMethodBeat.o(112682);
    }
}
