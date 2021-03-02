package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.ah;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements i {
    List<WeakReference<a>> pQG = new ArrayList();
    String pQH = "";
    public LinkedList<String> pQI = new LinkedList<>();
    public int pQJ;
    private int pQK;
    private int pQL;
    private int pQM;
    private int pQN = 60;
    private boolean pQO = false;
    private MTimerHandler pQP = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.card.b.c.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(112581);
            Log.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
            c.this.aja(c.this.pQH);
            c.this.ctg();
            AppMethodBeat.o(112581);
            return true;
        }
    }, false);
    private MTimerHandler pQQ = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.card.b.c.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            a aVar;
            AppMethodBeat.i(112582);
            Log.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
            c cVar = c.this;
            Log.i("MicroMsg.CardCodeMgr", "onCodeChange()");
            if (cVar.pQG != null) {
                for (int i2 = 0; i2 < cVar.pQG.size(); i2++) {
                    WeakReference<a> weakReference = cVar.pQG.get(i2);
                    if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                        aVar.ctk();
                    }
                }
            }
            c.this.cti();
            AppMethodBeat.o(112582);
            return true;
        }
    }, false);

    public interface a {
        void aiZ(String str);

        void ctk();

        void onSuccess();
    }

    public c() {
        AppMethodBeat.i(112583);
        AppMethodBeat.o(112583);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(112585);
        if (this.pQG == null) {
            this.pQG = new ArrayList();
        }
        this.pQG.add(new WeakReference<>(aVar));
        AppMethodBeat.o(112585);
    }

    public final void b(a aVar) {
        a aVar2;
        AppMethodBeat.i(112586);
        if (this.pQG == null) {
            AppMethodBeat.o(112586);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (weakReference != null && (aVar2 = weakReference.get()) != null && aVar2.equals(aVar)) {
                this.pQG.remove(weakReference);
                AppMethodBeat.o(112586);
                return;
            }
        }
        AppMethodBeat.o(112586);
    }

    private void onSuccess() {
        a aVar;
        AppMethodBeat.i(112587);
        Log.i("MicroMsg.CardCodeMgr", "onSuccess()");
        if (this.pQG == null) {
            AppMethodBeat.o(112587);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.onSuccess();
            }
        }
        AppMethodBeat.o(112587);
    }

    private void aiZ(String str) {
        a aVar;
        AppMethodBeat.i(112588);
        Log.i("MicroMsg.CardCodeMgr", "onFail()");
        if (this.pQG == null) {
            AppMethodBeat.o(112588);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<a> weakReference = this.pQG.get(i2);
            if (!(weakReference == null || (aVar = weakReference.get()) == null)) {
                aVar.aiZ(str);
            }
        }
        AppMethodBeat.o(112588);
    }

    public final String getCode() {
        AppMethodBeat.i(112589);
        if (this.pQI == null || this.pQI.size() == 0) {
            Log.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            AppMethodBeat.o(112589);
            return "";
        } else if (this.pQJ >= this.pQI.size()) {
            Log.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            aja(this.pQH);
            AppMethodBeat.o(112589);
            return "";
        } else {
            if (this.pQL >= this.pQI.size() - this.pQJ) {
                Log.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
                aja(this.pQH);
            }
            Log.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.pQJ + " request_count:" + this.pQL + " codes size:" + this.pQI.size());
            LinkedList<String> linkedList = this.pQI;
            int i2 = this.pQJ;
            this.pQJ = i2 + 1;
            String str = linkedList.get(i2);
            AppMethodBeat.o(112589);
            return str;
        }
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(112590);
        if (this.pQI == null || this.pQI.size() == 0) {
            Log.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            AppMethodBeat.o(112590);
            return true;
        } else if (this.pQJ >= this.pQI.size()) {
            Log.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            AppMethodBeat.o(112590);
            return true;
        } else {
            AppMethodBeat.o(112590);
            return false;
        }
    }

    public final void aja(String str) {
        AppMethodBeat.i(112591);
        if (this.pQO) {
            Log.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
            AppMethodBeat.o(112591);
        } else if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
            AppMethodBeat.o(112591);
        } else {
            Log.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id ".concat(String.valueOf(str)));
            this.pQO = true;
            this.pQH = str;
            ctf();
            AppMethodBeat.o(112591);
        }
    }

    private void ctf() {
        AppMethodBeat.i(112592);
        g.aAg().hqi.a(new ac(this.pQH), 0);
        AppMethodBeat.o(112592);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112593);
        Log.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof ac) {
                this.pQO = false;
                Log.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.pQH);
                ac acVar = (ac) qVar;
                this.pQK = acVar.pQK;
                this.pQL = acVar.pQL;
                this.pQM = acVar.pQM;
                if (acVar.pQI != null) {
                    this.pQI.clear();
                    this.pQI.addAll(acVar.pQI);
                    this.pQJ = 0;
                }
                onSuccess();
                ctg();
                if (this.pQM != 0) {
                    cti();
                }
                AppMethodBeat.o(112593);
                return;
            }
        } else if (qVar instanceof ac) {
            this.pQO = false;
            Log.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.pQH);
            aiZ(str);
        }
        AppMethodBeat.o(112593);
    }

    public final void ctg() {
        AppMethodBeat.i(112594);
        cth();
        Log.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.pQK);
        if (this.pQK <= 0 || TextUtils.isEmpty(this.pQH)) {
            Log.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
            AppMethodBeat.o(112594);
            return;
        }
        this.pQP.startTimer((long) (this.pQK * 1000));
        Log.i("MicroMsg.CardCodeMgr", "start request code timer!");
        AppMethodBeat.o(112594);
    }

    private void cth() {
        AppMethodBeat.i(112595);
        Log.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
        if (!this.pQP.stopped()) {
            this.pQP.stopTimer();
        }
        AppMethodBeat.o(112595);
    }

    public final void cti() {
        AppMethodBeat.i(112596);
        ctj();
        Log.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.pQM);
        if (this.pQM > 0) {
            this.pQQ.startTimer((long) (this.pQM * 1000));
            Log.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
            AppMethodBeat.o(112596);
            return;
        }
        this.pQQ.startTimer((long) (this.pQN * 1000));
        Log.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
        AppMethodBeat.o(112596);
    }

    public final void ctj() {
        AppMethodBeat.i(112597);
        Log.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
        if (!this.pQQ.stopped()) {
            this.pQQ.stopTimer();
        }
        AppMethodBeat.o(112597);
    }

    public final void release() {
        AppMethodBeat.i(112584);
        g.aAg().hqi.b(ah.CTRL_INDEX, this);
        this.pQI.clear();
        this.pQO = false;
        this.pQH = "";
        this.pQJ = 0;
        this.pQK = 0;
        this.pQL = 0;
        this.pQM = 0;
        cth();
        ctj();
        AppMethodBeat.o(112584);
    }
}
