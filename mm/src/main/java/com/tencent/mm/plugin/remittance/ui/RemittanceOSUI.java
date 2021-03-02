package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.remittance.model.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.f;

@a(19)
public class RemittanceOSUI extends RemittanceBaseUI implements e.a {
    private int CwF;
    private String CwG;
    private String CwH;
    private String CwI;
    private String CwJ;
    private boolean CwK = false;
    private IListener zlO = new IListener<aat>() {
        /* class com.tencent.mm.plugin.remittance.ui.RemittanceOSUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160851);
            this.__eventId = aat.class.getName().hashCode();
            AppMethodBeat.o(160851);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aat aat) {
            AppMethodBeat.i(68257);
            if (RemittanceOSUI.this.CwK) {
                RemittanceOSUI.this.finish();
            }
            AppMethodBeat.o(68257);
            return false;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceOSUI() {
        AppMethodBeat.i(68262);
        AppMethodBeat.o(68262);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public final void eNJ() {
        AppMethodBeat.i(68263);
        h.INSTANCE.a(13337, 2);
        AppMethodBeat.o(68263);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public final void eNK() {
        AppMethodBeat.i(68264);
        u.makeText(getContext(), getString(R.string.g3w, new Object[]{this.CwG}), 0).show();
        AppMethodBeat.o(68264);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68265);
        super.onCreate(bundle);
        EventCenter.instance.add(this.zlO);
        this.mNetSceneMgr.addSceneEndListener(1622);
        this.mNetSceneMgr.addSceneEndListener(1574);
        initView();
        this.qAh.setTitleText("");
        p.aYn().a(this);
        this.CwF = getIntent().getIntExtra("os_currency", 0);
        this.CwG = getIntent().getStringExtra("os_currencyuint");
        this.CwH = getIntent().getStringExtra("os_currencywording");
        this.CwI = getIntent().getStringExtra("os_notice");
        this.CwJ = getIntent().getStringExtra("os_notice_url");
        this.qAh.setTitleText(this.CwG);
        eNN();
        AppMethodBeat.o(68265);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public final void aMj(String str) {
        AppMethodBeat.i(68266);
        String aUa = z.aUa();
        if (Util.isNullOrNil(aUa)) {
            aUa = z.aTY();
        }
        g.aAi();
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.goe);
        String str2 = this.goe;
        if (((int) Kn.gMZ) != 0) {
            str2 = Kn.arJ();
        }
        ab abVar = new ab(this.jVp, aUa, this.goe, str2, str, this.CwF);
        abVar.setProcessName("RemittanceProcess");
        doSceneProgress(abVar);
        h.INSTANCE.a(13337, 1, Double.valueOf(this.jVp));
        AppMethodBeat.o(68266);
    }

    /* access modifiers changed from: protected */
    public final void aMa(String str) {
        AppMethodBeat.i(68267);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        f.b(getContext(), intent, 3);
        this.CwK = true;
        AppMethodBeat.o(68267);
    }

    /* access modifiers changed from: protected */
    public final void aMo(String str) {
        AppMethodBeat.i(68268);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        f.b(getContext(), intent, 3);
        this.CwK = true;
        AppMethodBeat.o(68268);
    }

    @Override // com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public final void eNN() {
        AppMethodBeat.i(68269);
        if (!Util.isNullOrNil(this.CwI)) {
            f.a((TextView) findViewById(R.id.a2b), "", this.CwI, this.CwJ);
            AppMethodBeat.o(68269);
            return;
        }
        Log.i("MicroMsg.RemittanceOSUI", "no bulletin data");
        AppMethodBeat.o(68269);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(68270);
        super.onResume();
        AppMethodBeat.o(68270);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(68271);
        super.onPause();
        AppMethodBeat.o(68271);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68272);
        super.onDestroy();
        EventCenter.instance.removeListener(this.zlO);
        p.aYn().b(this);
        this.mNetSceneMgr.removeSceneEndListener(1622);
        this.mNetSceneMgr.removeSceneEndListener(1574);
        AppMethodBeat.o(68272);
    }

    @Override // com.tencent.mm.aj.e.a, com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public final void Mr(String str) {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI, com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68273);
        Log.d("MicroMsg.RemittanceOSUI", "reqcode=" + i2 + ", resultCode=" + i3 + ", username=" + this.goe);
        this.CwK = false;
        if (i2 == 3 && i3 == -1) {
            finish();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(68273);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
    public int getLayoutId() {
        return R.layout.bmv;
    }

    @Override // com.tencent.mm.wallet_core.d.f, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onSceneEnd(int i2, int i3, String str, q qVar, boolean z) {
        boolean z2;
        AppMethodBeat.i(68274);
        super.onSceneEnd(i2, i3, str, qVar, z);
        if (i2 == 0 && i3 == 0 && (qVar instanceof ab)) {
            final ab abVar = (ab) qVar;
            if (abVar.CoV <= 0) {
                z2 = false;
            } else if (abVar.Cqo == 0) {
                com.tencent.mm.ui.base.h.c(this, getString(R.string.g48, new Object[]{Integer.valueOf(abVar.CoV)}), getString(R.string.yd), getString(R.string.g28), getString(R.string.g3v), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceOSUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68258);
                        RemittanceOSUI.this.aMa(abVar.CoO);
                        AppMethodBeat.o(68258);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceOSUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68259);
                        RemittanceOSUI.this.aMo(abVar.Cqn);
                        AppMethodBeat.o(68259);
                    }
                });
                z2 = true;
            } else if (abVar.Cqo == 1) {
                com.tencent.mm.ui.base.h.c(this, getString(R.string.g48, new Object[]{Integer.valueOf(abVar.CoV)}), getString(R.string.yd), getString(R.string.g28), getString(R.string.g3v), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceOSUI.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68260);
                        RemittanceOSUI.this.aMa(abVar.CoO);
                        AppMethodBeat.o(68260);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.ui.RemittanceOSUI.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68261);
                        RemittanceOSUI.this.aMo(abVar.Cqn);
                        AppMethodBeat.o(68261);
                    }
                });
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                String str2 = ((ab) qVar).CoO;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                f.b(getContext(), intent, 3);
            }
        }
        AppMethodBeat.o(68274);
    }
}
