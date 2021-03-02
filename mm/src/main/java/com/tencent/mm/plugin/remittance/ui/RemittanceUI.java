package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.f;

public class RemittanceUI extends RemittanceNewBaseUI {
    protected String Cxg;
    private String Cxh;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
    public final void eOj() {
        AppMethodBeat.i(68322);
        if (eNQ()) {
            g.aAi();
            this.Cro = (String) g.aAh().azQ().get(ar.a.USERINFO_DELAY_TRANSFER_CONFIRM_WORDING_STRING, "");
            g.aAi();
            this.Crp = (String) g.aAh().azQ().get(ar.a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, "");
            g.aAi();
            this.Crq = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, (Object) 0)).intValue();
            if (Util.isNullOrNil(this.Cro) || Util.isNullOrNil(this.Crp)) {
                aj.a(true, null);
            } else {
                aj.a(false, null);
            }
            Log.d("MicroMsg.RemittanceUI", "do before transfer");
            doSceneProgress(new e(this.goe), false);
        }
        AppMethodBeat.o(68322);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean shouldEnsureSoterConnection() {
        return true;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68323);
        super.onCreate(bundle);
        h.INSTANCE.a(15386, 1, 1);
        addSceneEndListener(2783);
        AppMethodBeat.o(68323);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
    public final void a(String str, int i2, String str2, String str3, String str4, String str5, String str6, gl glVar) {
        AppMethodBeat.i(68324);
        if (this.CqM != null) {
            this.CqM.k(3, Integer.valueOf(this.mPayScene), Double.valueOf(this.jVp));
        }
        int intExtra = getIntent().getIntExtra("pay_channel", -1);
        String str7 = "";
        if (!Util.isNullOrNil(new String[0])) {
            g.aAi();
            as bjJ = ((l) g.af(l.class)).aSN().bjJ(this.goe);
            if (bjJ != null) {
                str7 = bjJ.arJ();
            } else {
                Log.e("MicroMsg.RemittanceUI", "can not found contact for user::" + this.goe);
            }
        }
        if (Util.isNullOrNil(str6)) {
            this.Crx = true;
        } else {
            this.Crx = false;
        }
        Log.i("MicroMsg.RemittanceUI", "doSceneGenRemittance, channel: %s", Integer.valueOf(intExtra));
        int i3 = 0;
        if (Util.isEqual(this.dYe, 4)) {
            boolean isEqual = Util.isEqual(Double.valueOf(this.CrI), Double.valueOf(this.jVp));
            boolean isEqual2 = Util.isEqual(this.CrJ, str);
            boolean isEqual3 = Util.isEqual(this.CrK, str4);
            if (!isEqual) {
                i3 = 1;
            }
            if (!isEqual2) {
                i3 |= 2;
            }
            if (!isEqual3) {
                i3 |= 4;
            }
        }
        w wVar = new w(this.jVp, "1", this.goe, this.Crn, this.mPayScene, this.mScene, str, i2, str2, str3, str4, str5, this.CqS, intExtra, this.Crs, str6, this.CqN, str7, this.Crn, glVar, this.Cru, this.Crt, this.Cxg, this.Cxh, this.dYe, this.CrL, i3);
        wVar.setProcessName("RemittanceProcess");
        if (this.mKindaEnable) {
            showLoading();
            doSceneProgress(wVar, false);
        } else {
            doSceneProgress(wVar);
        }
        this.Cru = "";
        AppMethodBeat.o(68324);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(68325);
        if (qVar instanceof e) {
            final e eVar = (e) qVar;
            eVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(68320);
                    Log.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", eVar.Cos.LhU, eVar.Cos.Cxg);
                    RemittanceUI.this.Crn = eVar.Cos.LhU;
                    RemittanceUI.this.Cxg = eVar.Cos.Cxg;
                    RemittanceUI.this.CqR = eVar.Cos.LhV;
                    RemittanceUI.this.Cxh = eVar.Cos.Cxh;
                    RemittanceUI.this.Cnv = eVar.Cos.CpN;
                    RemittanceUI.this.eNO();
                    AppMethodBeat.o(68320);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(68319);
                    Log.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    AppMethodBeat.o(68319);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceUI.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(68318);
                    Log.e("MicroMsg.RemittanceUI", "net error: %s", eVar);
                    AppMethodBeat.o(68318);
                }
            });
            AppMethodBeat.o(68325);
            return true;
        }
        boolean onSceneEnd = super.onSceneEnd(i2, i3, str, qVar);
        AppMethodBeat.o(68325);
        return onSceneEnd;
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
    public final void eNK() {
        AppMethodBeat.i(68326);
        u.makeText(getContext(), (int) R.string.g1j, 0).show();
        AppMethodBeat.o(68326);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68327);
        super.onDestroy();
        removeSceneEndListener(2783);
        hideLoading();
        AppMethodBeat.o(68327);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI
    public final void eNN() {
        AppMethodBeat.i(68328);
        final zt ztVar = new zt();
        ztVar.efM.scene = "7";
        ztVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(68321);
                if (!Util.isNullOrNil(ztVar.efN.efO)) {
                    f.a((TextView) RemittanceUI.this.findViewById(R.id.a2b), ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                    AppMethodBeat.o(68321);
                    return;
                }
                Log.i("MicroMsg.RemittanceUI", "no bulletin data");
                AppMethodBeat.o(68321);
            }
        };
        EventCenter.instance.publish(ztVar);
        AppMethodBeat.o(68328);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean convertActivityFromTranslucent() {
        return false;
    }
}
