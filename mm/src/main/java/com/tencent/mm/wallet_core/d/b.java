package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.n;
import org.json.JSONObject;

public final class b implements i {
    static ITenpaySave.RetryPayInfo retryPayInfo;
    private n Ruu;
    private int Ruw = 0;
    private i Rux;

    private boolean canRetry() {
        AppMethodBeat.i(72834);
        if (this.Ruw >= hhG()) {
            AppMethodBeat.o(72834);
            return false;
        }
        AppMethodBeat.o(72834);
        return true;
    }

    private static int hhG() {
        AppMethodBeat.i(72835);
        if (retryPayInfo == null || !retryPayInfo.exv()) {
            AppMethodBeat.o(72835);
            return 0;
        }
        int i2 = retryPayInfo.MSD;
        AppMethodBeat.o(72835);
        return i2;
    }

    public b(i iVar) {
        this.Rux = iVar;
    }

    public final void destory() {
        AppMethodBeat.i(72837);
        this.Rux = null;
        g.aAi();
        g.aAg().hqi.b(385, this);
        AppMethodBeat.o(72837);
    }

    private void a(int i2, int i3, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72838);
        Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + i3 + "errType = " + i2);
        if (this.Ruu != null && jSONObject != null && i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
            this.Ruu.onGYNetEnd(i3, str, jSONObject);
            this.Rux.onSceneEnd(i2, i3, str, this.Ruu);
        } else if (this.Rux != null) {
            Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
            this.Rux.onSceneEnd(i2, i3, str, this.Ruu);
        }
        Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
        this.Ruw = 0;
        AppMethodBeat.o(72838);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72839);
        Log.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if (qVar instanceof n) {
            if (qVar instanceof ITenpaySave) {
                ITenpaySave.RetryPayInfo retryPayInfo2 = ((ITenpaySave) qVar).getRetryPayInfo();
                if (retryPayInfo2.exv()) {
                    retryPayInfo = retryPayInfo2;
                }
            }
            g.aAi();
            g.aAg().hqi.b(385, this);
            if (((n) qVar).ishasCGiRetried()) {
                if (this.Ruu.checkPaySuccess()) {
                    Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
                    a(i2, i3, str, ((n) qVar).RuU);
                    AppMethodBeat.o(72839);
                    return;
                } else if (this.Ruu.canPayRetry() && canRetry()) {
                    Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", Boolean.valueOf(this.Ruu.canPayRetry()), Boolean.valueOf(canRetry()));
                    if (!c(this.Ruu)) {
                        d(i2, i3, qVar);
                        AppMethodBeat.o(72839);
                        return;
                    }
                } else if (((n) qVar).checkRecSrvResp()) {
                    Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
                    if (!c(this.Ruu)) {
                        d(i2, i3, qVar);
                        AppMethodBeat.o(72839);
                        return;
                    }
                } else {
                    String str2 = retryPayInfo.RuI;
                    Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", str2);
                    a(i2, i3, str2, ((n) qVar).RuU);
                }
            }
        }
        AppMethodBeat.o(72839);
    }

    private void d(int i2, int i3, q qVar) {
        AppMethodBeat.i(72840);
        a(i2, i3, retryPayInfo.RuI, ((n) qVar).RuU);
        AppMethodBeat.o(72840);
    }

    public final boolean c(n nVar) {
        int i2;
        AppMethodBeat.i(72836);
        if (retryPayInfo == null || !retryPayInfo.exv()) {
            i2 = 0;
        } else {
            i2 = retryPayInfo.RuH;
        }
        int hhG = hhG();
        this.Ruw++;
        if (this.Ruw > hhG) {
            AppMethodBeat.o(72836);
            return false;
        }
        this.Ruu = nVar;
        this.Ruu.setHasRetried(true);
        g.aAi();
        g.aAg().hqi.a(385, this);
        this.Ruu.resetForRetry();
        nVar.updateConfig(this.Ruw, this.Ruw >= hhG ? 1 : 0);
        Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", Integer.valueOf(i2), Integer.valueOf(hhG));
        g.aAi();
        g.aAg().hqi.a(nVar, i2 * 1000);
        AppMethodBeat.o(72836);
        return true;
    }
}
