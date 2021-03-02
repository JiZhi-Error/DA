package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.plugin.offline.a.e;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c {
    a AKH;
    s AKI;
    float AKJ = 0.0f;
    int AKK = g.sHCENCODEVIDEOTIMEOUT;
    Activity mActivity;
    Vibrator paT;

    public c(Activity activity, a aVar) {
        this.mActivity = activity;
        this.AKH = aVar;
    }

    public final void a(q qVar, int i2, String str) {
        AppMethodBeat.i(66387);
        a(qVar, i2, str, null);
        AppMethodBeat.o(66387);
    }

    public final void a(q qVar, int i2, String str, String str2) {
        AppMethodBeat.i(66388);
        Log.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + i2 + " msg:" + str);
        ezA();
        if (i2 == 409) {
            aJh(str);
            AppMethodBeat.o(66388);
        } else if (i2 == 410) {
            aJg(str);
            AppMethodBeat.o(66388);
        } else if (i2 == 413) {
            aJi(str);
            AppMethodBeat.o(66388);
        } else if (i2 == 411) {
            if (t.fQI().fRm() || t.fQI().fRl()) {
                Log.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
                AppMethodBeat.o(66388);
                return;
            }
            if (!k.AIX || !(this.mActivity instanceof WalletOfflineCoinPurseUI)) {
                a.j(this.mActivity, str);
            } else {
                ((WalletOfflineCoinPurseUI) this.mActivity).ezV();
            }
            h.INSTANCE.idkeyStat(135, 1, 1, true);
            AppMethodBeat.o(66388);
        } else if (this.mActivity instanceof WalletBaseUI) {
            if (!com.tencent.mm.wallet_core.d.h.a((WalletBaseUI) this.mActivity, qVar, 1000, i2, str)) {
                b.d(this.mActivity, str, str2);
            }
            AppMethodBeat.o(66388);
        } else {
            b.i(this.mActivity, str);
            AppMethodBeat.o(66388);
        }
    }

    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = false;
        AppMethodBeat.i(66389);
        Log.i("MicroMsg.OfflineLogicMgr", "errType:" + i2 + "  errCode" + i3 + " errMsg:" + str + " cgi type:" + qVar.getType());
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof e) {
                e eVar = (e) qVar;
                String str2 = eVar.AJn;
                ezA();
                if (eVar.AJo != 0 || TextUtils.isEmpty(str2)) {
                    if (!(eVar.AJo == 0 || eVar.dDN == 0 || eVar.AJq != 1)) {
                        Log.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                        a(eVar, eVar.AJo, eVar.AJp);
                    }
                    z = true;
                } else {
                    a.a(this.mActivity, str2, qVar);
                    this.mActivity.setResult(-1);
                    this.mActivity.finish();
                    z = true;
                }
            }
        } else if (qVar instanceof e) {
            ezA();
            if (((e) qVar).AJq == 1) {
                Log.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                a(qVar, i3, str);
            }
            z = true;
        }
        AppMethodBeat.o(66389);
        return z;
    }

    public final void ezA() {
        AppMethodBeat.i(66390);
        if (this.AKI != null) {
            this.AKI.dismiss();
            this.AKI = null;
        }
        AppMethodBeat.o(66390);
    }

    private void aJg(String str) {
        AppMethodBeat.i(66391);
        Log.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:".concat(String.valueOf(str)));
        com.tencent.mm.ui.base.h.c(this.mActivity, str, "", getString(R.string.imy), getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass16 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(66385);
                f.aE(c.this.mActivity, 0);
                Log.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                AppMethodBeat.o(66385);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass17 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(66391);
    }

    private void aJh(String str) {
        AppMethodBeat.i(66392);
        Log.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:".concat(String.valueOf(str)));
        com.tencent.mm.ui.base.h.c(this.mActivity, str, "", getString(R.string.ivd), getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass18 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(66386);
                f.aE(c.this.mActivity, 0);
                Log.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                AppMethodBeat.o(66386);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(66392);
    }

    private void aJi(String str) {
        AppMethodBeat.i(66393);
        Log.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:".concat(String.valueOf(str)));
        com.tencent.mm.ui.base.h.c(this.mActivity, str, "", getString(R.string.iuq), getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(66373);
                c.this.AKH.ezw();
                Log.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
                AppMethodBeat.o(66373);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(66393);
    }

    public final void a(s.b bVar) {
        AppMethodBeat.i(66394);
        if (bVar == null) {
            AppMethodBeat.o(66394);
            return;
        }
        Log.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
        if ("1".equals(bVar.AKe)) {
            com.tencent.mm.ui.base.h.a((Context) this.mActivity, false, bVar.AKg, "", getString(R.string.iv4), getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(66374);
                    dialogInterface.dismiss();
                    a.ay(c.this.mActivity);
                    Log.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
                    AppMethodBeat.o(66374);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.offline.ui.c.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(66375);
                    dialogInterface.dismiss();
                    c.this.mActivity.finish();
                    AppMethodBeat.o(66375);
                }
            });
        }
        AppMethodBeat.o(66394);
    }

    public static boolean ezB() {
        AppMethodBeat.i(66395);
        k.ezn();
        if (k.ezo().AKa != null) {
            AppMethodBeat.o(66395);
            return true;
        }
        AppMethodBeat.o(66395);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final String getString(int i2) {
        AppMethodBeat.i(66396);
        String string = this.mActivity.getString(i2);
        AppMethodBeat.o(66396);
        return string;
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(66397);
        Log.i("MicroMsg.OfflineLogicMgr", "closeOffline");
        if (cVar.AKH != null) {
            cVar.AKH.ezx();
        }
        AppMethodBeat.o(66397);
    }
}
