package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public class LoginSmsUI extends LoginHistoryUI {
    private static String TAG = "LoginSmsUI";
    private x kmF = new x();

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoginSmsUI() {
        AppMethodBeat.i(169135);
        AppMethodBeat.o(169135);
    }

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128196);
        super.onCreate(bundle);
        if (this.kmm) {
            AppMethodBeat.o(128196);
            return;
        }
        this.loginType = 3;
        if (!Util.isPhoneNumber(this.kmc).booleanValue() && Util.isPhoneNumber(this.klX).booleanValue()) {
            this.klL.setText(Ts(this.klX));
        }
        this.kmk.setVisibility(0);
        this.kmk.setInputType(3);
        this.kmk.setSendSmsBtnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginSmsUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(128191);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/LoginSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LoginSmsUI.a(LoginSmsUI.this, LoginSmsUI.this.klX);
                a.a(this, "com/tencent/mm/plugin/account/ui/LoginSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128191);
            }
        });
        this.kmk.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.LoginSmsUI.AnonymousClass2 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128192);
                if (LoginSmsUI.this.kmk.getText().toString().length() > 0) {
                    LoginSmsUI.this.klN.setEnabled(true);
                    AppMethodBeat.o(128192);
                    return;
                }
                LoginSmsUI.this.klN.setEnabled(false);
                AppMethodBeat.o(128192);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        if (this.kmk.getText().toString().length() > 0) {
            this.klN.setEnabled(true);
        } else {
            this.klN.setEnabled(false);
        }
        this.klN.setVisibility(0);
        this.klN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginSmsUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(128193);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/LoginSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LoginSmsUI.this.bpf();
                a.a(this, "com/tencent/mm/plugin/account/ui/LoginSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128193);
            }
        });
        AppMethodBeat.o(128196);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI
    public final void bpf() {
        AppMethodBeat.i(128197);
        super.bpf();
        if (isFinishing() || getWindow() == null) {
            Log.e(TAG, "LoginHistoryUI is finishing");
            AppMethodBeat.o(128197);
            return;
        }
        if (!Util.isNullOrNil(this.klX)) {
            this.klt.account = this.klX;
            hideVKB();
            this.kmF.b(this, new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.LoginSmsUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(169133);
                    LoginSmsUI.a(LoginSmsUI.this);
                    AppMethodBeat.o(169133);
                }
            });
        }
        AppMethodBeat.o(128197);
    }

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128198);
        super.onResume();
        g.azz().a(145, this);
        AppMethodBeat.o(128198);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(128199);
        super.onStop();
        g.azz().b(145, this);
        AppMethodBeat.o(128199);
    }

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128200);
        super.onDestroy();
        this.kmk.reset();
        AppMethodBeat.o(128200);
    }

    static /* synthetic */ void a(LoginSmsUI loginSmsUI, String str) {
        AppMethodBeat.i(128201);
        if (!Util.isNullOrNil(str)) {
            final com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(str, 13, "", 0, "");
            g.azz().a(aVar, 0);
            loginSmsUI.getString(R.string.zb);
            loginSmsUI.gtM = h.a((Context) loginSmsUI, loginSmsUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.LoginSmsUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(128194);
                    g.azz().a(aVar);
                    AppMethodBeat.o(128194);
                }
            });
        }
        AppMethodBeat.o(128201);
    }

    static /* synthetic */ void a(LoginSmsUI loginSmsUI) {
        AppMethodBeat.i(169136);
        loginSmsUI.bpg();
        final com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(loginSmsUI.klX, 17, loginSmsUI.kmk.getText().toString().trim(), 0, "");
        g.azz().a(aVar, 0);
        loginSmsUI.getString(R.string.zb);
        loginSmsUI.gtM = h.a((Context) loginSmsUI, loginSmsUI.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginSmsUI.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(169134);
                g.azz().a(aVar);
                AppMethodBeat.o(169134);
            }
        });
        AppMethodBeat.o(169136);
    }
}
