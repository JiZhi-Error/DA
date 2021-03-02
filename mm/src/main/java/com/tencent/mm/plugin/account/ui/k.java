package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.cc.h;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;

public final class k implements i, MobileInputUI.b {
    protected String gwF = null;
    protected String kbO = "";
    protected int kbP = 2;
    private MobileInputUI knl;

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void a(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(128287);
        this.knl = mobileInputUI;
        mobileInputUI.knC.requestFocus();
        mobileInputUI.showVKB();
        this.gwF = mobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.kbO = mobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.kbP = mobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        String string = mobileInputUI.getString(R.string.g09);
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            string = string + h.jr(mobileInputUI);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.kaX.setVisibility(0);
        mobileInputUI.knB.setVisibility(0);
        mobileInputUI.knC.requestFocus();
        mobileInputUI.knE.setVisibility(0);
        mobileInputUI.knH.setVisibility(0);
        mobileInputUI.knH.setText(R.string.en5);
        AppMethodBeat.o(128287);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void start() {
        AppMethodBeat.i(128288);
        g.azz().a(132, this);
        AppMethodBeat.o(128288);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void stop() {
        AppMethodBeat.i(128289);
        g.azz().b(132, this);
        AppMethodBeat.o(128289);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void a(MobileInputUI.a aVar) {
        AppMethodBeat.i(128290);
        switch (aVar) {
            case GoNext:
                this.knl.knO = PhoneFormater.countryCodeWithPlus(this.knl.countryCode);
                this.knl.knP = this.knl.knB.getText().toString();
                String str = this.knl.knO + this.knl.knP;
                if (this.knl.kdn == null) {
                    MobileInputUI mobileInputUI = this.knl;
                    MobileInputUI mobileInputUI2 = this.knl;
                    this.knl.getString(R.string.zb);
                    mobileInputUI.kdn = com.tencent.mm.ui.base.h.a((Context) mobileInputUI2, this.knl.getString(R.string.fyo), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.k.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    g.azz().a(new z(str, 1, "", 0, ""), 0);
                    break;
                } else {
                    Log.d("MicroMsg.MobileInputRegLogic", "already checking ");
                    AppMethodBeat.o(128290);
                    return;
                }
        }
        AppMethodBeat.o(128290);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(128291);
        Log.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.knl.kdn != null) {
            this.knl.kdn.dismiss();
            this.knl.kdn = null;
        }
        if (qVar.getType() != 132) {
            AppMethodBeat.o(128291);
        } else if (i2 == 0 && i3 == 0) {
            if (((z) qVar).Vj() == 1) {
                Intent intent = new Intent();
                intent.putExtra("bindmcontact_mobile", this.knl.knO + " " + this.knl.knB.getText().toString());
                intent.putExtra("bindmcontact_shortmobile", this.knl.knB.getText().toString());
                intent.putExtra("country_name", this.knl.jbZ);
                intent.putExtra("couttry_code", this.knl.countryCode);
                intent.putExtra("mobile_verify_purpose", 4);
                intent.putExtra("regsetinfo_ticket", this.gwF);
                intent.putExtra("regsetinfo_NextStep", this.kbO);
                intent.putExtra("regsetinfo_NextStyle", this.kbP);
                intent.setClass(this.knl, MobileVerifyUI.class);
                MobileInputUI mobileInputUI = this.knl;
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(mobileInputUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                mobileInputUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(mobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.knl.finish();
            }
            AppMethodBeat.o(128291);
        } else if (com.tencent.mm.plugin.account.a.a.jRu.a(this.knl, i2, i3, str)) {
            AppMethodBeat.o(128291);
        } else {
            Toast.makeText(this.knl, this.knl.getString(R.string.af2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            AppMethodBeat.o(128291);
        }
    }
}
