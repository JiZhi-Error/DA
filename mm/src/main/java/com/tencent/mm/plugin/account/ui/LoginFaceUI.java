package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
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

public class LoginFaceUI extends LoginHistoryUI {
    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128086);
        super.onCreate(bundle);
        if (this.kmm) {
            AppMethodBeat.o(128086);
            return;
        }
        this.loginType = 4;
        this.kmi.setVisibility(0);
        this.klQ.setVisibility(0);
        findViewById(R.id.c8s).setEnabled(false);
        ((TextView) findViewById(R.id.c_0)).setTextColor(getResources().getColorStateList(R.color.ag5));
        ((TextView) findViewById(R.id.c_0)).setBackgroundResource(getResources().getColor(R.color.ac_));
        this.klQ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginFaceUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(128084);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/LoginFaceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(11557, 2);
                Intent intent = new Intent();
                intent.putExtra("k_user_name", LoginFaceUI.this.kmc);
                intent.putExtra("k_purpose", 2);
                intent.putExtra("k_need_signature", true);
                c.b(LoginFaceUI.this.getContext(), "facedetect", ".ui.FaceDetectUI", intent, (int) TXLiteAVCode.EVT_CAMERA_CLOSE);
                a.a(this, "com/tencent/mm/plugin/account/ui/LoginFaceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128084);
            }
        });
        AppMethodBeat.o(128086);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI
    public final void bpf() {
        int i2 = -1;
        AppMethodBeat.i(128087);
        super.bpf();
        bpg();
        final t tVar = new t(this.kmc, this.kly, "", 0);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.kly == null ? -1 : this.kly.length());
        objArr[1] = Util.secPrint(this.kly);
        if (this.klt.kdq != null) {
            i2 = this.klt.kdq.length();
        }
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Util.secPrint(this.klt.kdq);
        Log.d("MicroMsg.LoginFaceUI", "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", objArr);
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginFaceUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(128085);
                g.azz().a(tVar);
                LoginFaceUI.this.bph();
                AppMethodBeat.o(128085);
            }
        });
        g.azz().a(tVar, 0);
        AppMethodBeat.o(128087);
    }
}
