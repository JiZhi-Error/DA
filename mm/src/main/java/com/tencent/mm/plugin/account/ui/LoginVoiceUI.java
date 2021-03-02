package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class LoginVoiceUI extends LoginHistoryUI {
    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128252);
        super.onCreate(bundle);
        super.setRequestedOrientation(1);
        if (this.kmm) {
            AppMethodBeat.o(128252);
            return;
        }
        this.loginType = 1;
        this.kmg.setVisibility(0);
        this.klP.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.klO.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.leftMargin = 0;
        this.klO.setLayoutParams(layoutParams);
        findViewById(R.id.j9p).setEnabled(false);
        ((TextView) findViewById(R.id.j9x)).setTextColor(getResources().getColorStateList(R.color.ag5));
        ((TextView) findViewById(R.id.j9x)).setBackgroundResource(getResources().getColor(R.color.ac_));
        this.klP.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginVoiceUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(128250);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/LoginVoiceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(11557, 2);
                Intent intent = new Intent();
                intent.putExtra("Kusername", LoginVoiceUI.this.kmc);
                intent.putExtra("kscene_type", 1);
                c.b(LoginVoiceUI.this.getContext(), "voiceprint", ".ui.VoiceLoginUI", intent, 1024);
                a.a(this, "com/tencent/mm/plugin/account/ui/LoginVoiceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128250);
            }
        });
        AppMethodBeat.o(128252);
    }

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI
    public final boolean bpi() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI
    public final void bpf() {
        int i2 = -1;
        AppMethodBeat.i(128253);
        super.bpf();
        bpg();
        final t tVar = new t(this.klt.account, this.kly, "", 0);
        tVar.PA(this.kly);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.kly == null ? -1 : this.kly.length());
        objArr[1] = Util.secPrint(this.kly);
        if (this.klt.kdq != null) {
            i2 = this.klt.kdq.length();
        }
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Util.secPrint(this.klt.kdq);
        Log.d("MicroMsg.LoginVoiceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", objArr);
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginVoiceUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(128251);
                g.azz().a(tVar);
                LoginVoiceUI.this.bph();
                AppMethodBeat.o(128251);
            }
        });
        g.azz().a(tVar, 0);
        AppMethodBeat.o(128253);
    }

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        com.tencent.mm.h.a Dk;
        AppMethodBeat.i(196875);
        super.initView();
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("key_errType", 0);
            int intExtra2 = getIntent().getIntExtra("key_errCode", 0);
            String stringExtra = getIntent().getStringExtra("key_errMsg");
            Log.i("MicroMsg.LoginVoiceUI", "initView,errType %d,errCode %d", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
            if (a.dK(intExtra, intExtra2) && (Dk = com.tencent.mm.h.a.Dk(stringExtra)) != null) {
                Dk.a(this, new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.plugin.account.ui.LoginVoiceUI.AnonymousClass3 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                    }
                });
            }
        }
        AppMethodBeat.o(196875);
    }
}
