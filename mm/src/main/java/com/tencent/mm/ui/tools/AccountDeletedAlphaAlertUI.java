package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class AccountDeletedAlphaAlertUI extends MMActivity {
    private static AccountDeletedAlphaAlertUI QoE = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static AccountDeletedAlphaAlertUI gXm() {
        return QoE;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38935);
        super.onCreate(bundle);
        QoE = this;
        EventCenter.instance.publish(new ab());
        bg.hold();
        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(getIntent().getStringExtra("errmsg"));
        if (Dk != null) {
            Dk.a(this, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(38933);
                    AccountDeletedAlphaAlertUI.a(AccountDeletedAlphaAlertUI.this);
                    AppMethodBeat.o(38933);
                }
            }, null);
            AppMethodBeat.o(38935);
            return;
        }
        h.a((Context) this, getString(R.string.ev4), (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(38934);
                AccountDeletedAlphaAlertUI.a(AccountDeletedAlphaAlertUI.this);
                AppMethodBeat.o(38934);
            }
        });
        AppMethodBeat.o(38935);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(38936);
        if (equals(QoE)) {
            QoE = null;
        }
        super.onDestroy();
        AppMethodBeat.o(38936);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    static /* synthetic */ void a(AccountDeletedAlphaAlertUI accountDeletedAlphaAlertUI) {
        AppMethodBeat.i(38937);
        accountDeletedAlphaAlertUI.finish();
        t.ds(accountDeletedAlphaAlertUI);
        Intent intent = new Intent(accountDeletedAlphaAlertUI.getContext(), LauncherUI.class);
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        AppCompatActivity context = accountDeletedAlphaAlertUI.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/tools/AccountDeletedAlphaAlertUI", "kickOff", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/tools/AccountDeletedAlphaAlertUI", "kickOff", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(38937);
    }
}
