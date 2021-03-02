package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public final class o implements i, MobileVerifyUI.c {
    private String gwF = null;
    private String kbO = "";
    private int kbP = 2;
    private MobileVerifyUI koA;

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final void a(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.i(128419);
        this.koA = mobileVerifyUI;
        this.gwF = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.kbO = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.kbP = mobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        AppMethodBeat.o(128419);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final void start() {
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final void stop() {
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final boolean a(MobileVerifyUI.a aVar) {
        AppMethodBeat.i(128420);
        switch (aVar) {
            case GoNext:
                ka kaVar = new ka();
                kaVar.dOV.context = this.koA;
                EventCenter.instance.publish(kaVar);
                String str = kaVar.dOW.dOX;
                kb kbVar = new kb();
                EventCenter.instance.publish(kbVar);
                String str2 = kbVar.dOY.dOZ;
                g.azz().a(132, this);
                final z zVar = new z(this.koA.dSf, 2, this.koA.kbd.getText().toString().trim(), "", str, str2);
                g.azz().a(zVar, 0);
                MobileVerifyUI mobileVerifyUI = this.koA;
                MobileVerifyUI mobileVerifyUI2 = this.koA;
                this.koA.getString(R.string.zb);
                mobileVerifyUI.gtM = h.a((Context) mobileVerifyUI2, this.koA.getString(R.string.aey), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.ui.o.AnonymousClass2 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(128417);
                        g.azz().a(zVar);
                        g.azz().b(132, o.this);
                        AppMethodBeat.o(128417);
                    }
                });
                break;
            case DoSend:
                g.azz().a(132, this);
                g.azz().a(new z(this.koA.dSf, 1, "", 0, ""), 0);
                break;
            case DoProcessSMS:
                ka kaVar2 = new ka();
                kaVar2.dOV.context = this.koA;
                EventCenter.instance.publish(kaVar2);
                String str3 = kaVar2.dOW.dOX;
                kb kbVar2 = new kb();
                EventCenter.instance.publish(kbVar2);
                String str4 = kbVar2.dOY.dOZ;
                g.azz().a(132, this);
                final z zVar2 = new z(this.koA.dSf, 2, this.koA.kbd.getText().toString().trim(), "", str3, str4);
                g.azz().a(zVar2, 0);
                MobileVerifyUI mobileVerifyUI3 = this.koA;
                MobileVerifyUI mobileVerifyUI4 = this.koA;
                this.koA.getString(R.string.zb);
                mobileVerifyUI3.gtM = h.a((Context) mobileVerifyUI4, this.koA.getString(R.string.aey), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.ui.o.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(128416);
                        g.azz().a(zVar2);
                        g.azz().b(132, o.this);
                        AppMethodBeat.o(128416);
                    }
                });
                break;
        }
        AppMethodBeat.o(128420);
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(128421);
        Log.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.koA.gtM != null) {
            this.koA.gtM.dismiss();
            this.koA.gtM = null;
        }
        if (qVar.getType() == 132) {
            g.azz().b(132, this);
            if (((z) qVar).Vj() == 2 && i2 == 0 && i3 == 0) {
                a.unhold();
                boolean z = b.ik(this.koA).size() != 0;
                if (this.kbO == null || !this.kbO.contains("1") || !z) {
                    Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this.koA);
                    bZ.addFlags(67108864);
                    MobileVerifyUI mobileVerifyUI = this.koA;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                    com.tencent.mm.hellhoundlib.a.a.a(mobileVerifyUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mobileVerifyUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(mobileVerifyUI, "com/tencent/mm/plugin/account/ui/MobileVerifyQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    this.koA.kpe = 4;
                    this.koA.finish();
                    AppMethodBeat.o(128421);
                    return;
                }
                com.tencent.mm.plugin.b.a.bxl("R300_300_QQ");
                Intent intent = new Intent(this.koA, FindMContactAddUI.class);
                intent.addFlags(67108864);
                intent.putExtra("regsetinfo_ticket", this.gwF);
                intent.putExtra("regsetinfo_NextStep", this.kbO);
                intent.putExtra("regsetinfo_NextStyle", this.kbP);
                intent.putExtra("login_type", 1);
                Intent bZ2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(this.koA);
                bZ2.addFlags(67108864);
                MMWizardActivity.b(this.koA, intent, bZ2);
                this.koA.finish();
                AppMethodBeat.o(128421);
                return;
            }
            AppMethodBeat.o(128421);
        } else if (this.koA.n(i2, i3, str)) {
            AppMethodBeat.o(128421);
        } else {
            if (!(i2 == 0 && i3 == 0)) {
                Toast.makeText(this.koA, this.koA.getString(R.string.af2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            }
            AppMethodBeat.o(128421);
        }
    }
}
