package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ab extends IListener<zv> implements i {
    private zv Ibi;
    private q Ibj;
    private boolean efT = false;
    private boolean efU = false;
    private boolean wEZ = false;

    public ab() {
        AppMethodBeat.i(160877);
        this.__eventId = zv.class.getName().hashCode();
        AppMethodBeat.o(160877);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(zv zvVar) {
        AppMethodBeat.i(70427);
        boolean a2 = a(zvVar);
        AppMethodBeat.o(70427);
        return a2;
    }

    private boolean a(zv zvVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(70422);
        if (!(zvVar instanceof zv)) {
            Log.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
            AppMethodBeat.o(70422);
            return false;
        }
        this.wEZ = false;
        this.Ibi = zvVar;
        this.efT = zvVar.efR.efT;
        this.efU = zvVar.efR.efU;
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", Boolean.valueOf(this.efU));
        g.aAi();
        g.aAg().hqi.a(385, this);
        g.aAi();
        g.aAg().hqi.a(1518, this);
        if (t.fQI().fRp()) {
            Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
            b(zvVar);
        } else if (zvVar.efR.efT) {
            Log.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
            an fQI = t.fQI();
            long nowSecond = Util.nowSecond();
            Log.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", Long.valueOf(nowSecond), Long.valueOf(fQI.IbT));
            if (fQI.IbT <= 0 || nowSecond > fQI.IbT) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                if (!this.efU) {
                    this.wEZ = true;
                }
                Log.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
                a(0, "", null, false);
                b(zvVar);
            } else {
                Log.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
                b(zvVar);
            }
        } else {
            an fQI2 = t.fQI();
            long secondsToNow = Util.secondsToNow(fQI2.IbS);
            Log.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(secondsToNow)), Long.valueOf(fQI2.IbS), Long.valueOf(System.currentTimeMillis() / 1000));
            if (secondsToNow > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
                b(zvVar);
            } else {
                this.wEZ = true;
                Log.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
                a(0, "", null, false);
            }
        }
        AppMethodBeat.o(70422);
        return true;
    }

    private void b(zv zvVar) {
        int i2;
        AppMethodBeat.i(70423);
        if (z.aUo()) {
            this.Ibj = new a();
            g.azz().a(this.Ibj, 0);
            AppMethodBeat.o(70423);
            return;
        }
        if (aeK(zvVar.efR.scene)) {
            i2 = zvVar.efR.scene;
        } else {
            i2 = 0;
        }
        this.Ibj = new ad(null, i2);
        g.azz().a(this.Ibj, 0);
        AppMethodBeat.o(70423);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70424);
        if (this.Ibi == null || this.Ibi.efR == null) {
            AppMethodBeat.o(70424);
            return;
        }
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s, retry: %s", Integer.valueOf(i2), Integer.valueOf(i3), qVar, Integer.valueOf(this.Ibi.efR.retryCount));
        if (qVar != this.Ibj) {
            AppMethodBeat.o(70424);
            return;
        }
        if ((qVar instanceof ad) || (qVar instanceof a)) {
            if (i2 == 0 && i3 == 0) {
                a(i3, str, qVar);
                AppMethodBeat.o(70424);
                return;
            } else if (this.Ibi.efR.retryCount == 0) {
                a(i3, str, qVar);
                AppMethodBeat.o(70424);
                return;
            } else {
                zv.a aVar = this.Ibi.efR;
                aVar.retryCount--;
                b(this.Ibi);
            }
        }
        AppMethodBeat.o(70424);
    }

    private void a(int i2, String str, q qVar) {
        AppMethodBeat.i(70425);
        g.azz().b(385, this);
        g.azz().b(1518, this);
        if (this.efU || !this.efT || !this.wEZ) {
            this.wEZ = true;
            a(i2, str, qVar, true);
            AppMethodBeat.o(70425);
            return;
        }
        Log.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
        AppMethodBeat.o(70425);
    }

    private void a(int i2, String str, q qVar, boolean z) {
        AppMethodBeat.i(70426);
        if (this.Ibi != null) {
            this.Ibi.efS.errCode = i2;
            this.Ibi.efS.errMsg = str;
            this.Ibi.efS.egy = qVar;
            this.Ibi.efS.efV = t.fQI().fRk();
            this.Ibi.efS.efW = t.fQI().fRK();
            this.Ibi.efS.efX = t.fQI().fRM();
            this.Ibi.efS.efY = t.fQI().fRs().fQY();
            this.Ibi.efS.efZ = t.fQI().fRr();
            this.Ibi.efS.ega = t.fQI().getTrueName();
            this.Ibi.efS.egb = t.fQI().fRl();
            this.Ibi.efS.egc = t.fQI().fRs().fRc();
            this.Ibi.efS.egd = "";
            this.Ibi.efS.egr = t.fQI().fRD();
            if (qVar != null && (qVar instanceof ad)) {
                this.Ibi.efS.egd = ((ad) qVar).egd;
                this.Ibi.efS.ege = ((ad) qVar).ege;
                this.Ibi.efS.egf = ((ad) qVar).egf;
                this.Ibi.efS.egg = ((ad) qVar).egg;
                this.Ibi.efS.egh = ((ad) qVar).egh;
                this.Ibi.efS.scene = ((ad) qVar).scene;
                this.Ibi.efS.egi = ((ad) qVar).egi;
                this.Ibi.efS.egj = ((ad) qVar).egj;
                this.Ibi.efS.egk = ((ad) qVar).egk;
                this.Ibi.efS.egm = ((ad) qVar).egm;
                this.Ibi.efS.egn = ((ad) qVar).egn;
                this.Ibi.efS.ego = ((ad) qVar).ego;
                this.Ibi.efS.subtitle = ((ad) qVar).subtitle;
                this.Ibi.efS.title = ((ad) qVar).title;
                this.Ibi.efS.egp = ((ad) qVar).egp;
                this.Ibi.efS.egq = ((ad) qVar).egq;
                this.Ibi.efS.egw = ((ad) qVar).HQo;
            }
            this.Ibi.efS.egs = t.fQI().fRz() ? 1 : 0;
            this.Ibi.efS.egt = t.fQI().fRA();
            this.Ibi.efS.egu = t.fQI().fRB();
            this.Ibi.efS.egv = t.fQI().fRC();
            this.Ibi.efS.egx = z;
            Log.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.Ibi.efS.efW + " hasNewTips : " + this.Ibi.efS.efX + " swipeOn : " + this.Ibi.efS.efY);
            if (this.Ibi.callback != null) {
                this.Ibi.callback.run();
            }
            if (this.Ibi.efS.efJ != null) {
                this.Ibi.efS.efJ.run();
            }
        }
        if (this.wEZ) {
            this.Ibi = null;
        }
        AppMethodBeat.o(70426);
    }

    private static boolean aeK(int i2) {
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 6 || i2 == 8 || i2 == 9 || i2 == 10 || i2 == 11 || i2 == 12 || i2 == 13 || i2 == 14 || i2 == 15 || i2 == 16 || i2 == 17 || i2 == 18 || i2 == 19 || i2 == 20 || i2 == 21 || i2 == 22 || i2 == 23) {
            return true;
        }
        return false;
    }
}
