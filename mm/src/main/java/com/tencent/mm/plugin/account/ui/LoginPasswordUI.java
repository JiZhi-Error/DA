package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.normsg.a.c;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public class LoginPasswordUI extends LoginHistoryUI {
    private static String TAG = "LoginPasswordUI";
    private String dYB = "";
    private x kmF = new x();

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoginPasswordUI() {
        AppMethodBeat.i(169130);
        AppMethodBeat.o(169130);
    }

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128182);
        super.onCreate(bundle);
        if (this.kmm) {
            AppMethodBeat.o(128182);
            return;
        }
        this.loginType = 2;
        this.kmj.setVisibility(0);
        this.klN.setVisibility(0);
        this.klM.setTypeface(Typeface.DEFAULT);
        this.klM.setTransformationMethod(new PasswordTransformationMethod());
        this.klM.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginPasswordUI.AnonymousClass1 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128176);
                if (i2 == 6 || i2 == 5) {
                    LoginPasswordUI.this.bpf();
                    AppMethodBeat.o(128176);
                    return true;
                }
                AppMethodBeat.o(128176);
                return false;
            }
        });
        this.klM.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginPasswordUI.AnonymousClass2 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128177);
                b bVar = new b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                a.b("com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (66 == i2 && keyEvent.getAction() == 0) {
                    LoginPasswordUI.this.bpf();
                    a.a(true, (Object) this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(128177);
                    return true;
                }
                a.a(false, (Object) this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$2", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(128177);
                return false;
            }
        });
        this.klM.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.LoginPasswordUI.AnonymousClass3 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128178);
                if (LoginPasswordUI.this.klM.getText().toString().length() > 0) {
                    LoginPasswordUI.this.klN.setEnabled(true);
                    AppMethodBeat.o(128178);
                    return;
                }
                LoginPasswordUI.this.klN.setEnabled(false);
                AppMethodBeat.o(128178);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        if (this.klM.getText().toString().length() > 0) {
            this.klN.setEnabled(true);
        } else {
            this.klN.setEnabled(false);
        }
        final boolean[] zArr = {false};
        this.klN.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginPasswordUI.AnonymousClass4 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(196865);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        zArr[0] = true;
                        LoginPasswordUI.this.dYB = c.TN(2);
                        d.INSTANCE.aA("ce_login_id", "<LoginByID>", LoginPasswordUI.this.dYB);
                        break;
                    case 1:
                    case 6:
                        d.INSTANCE.a("ce_login_id", motionEvent);
                        d.INSTANCE.aIQ("ce_login_id");
                        break;
                }
                AppMethodBeat.o(196865);
                return false;
            }
        });
        this.klN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginPasswordUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(196866);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/LoginPasswordUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (zArr[0]) {
                    zArr[0] = false;
                } else {
                    LoginPasswordUI.this.dYB = c.TN(2);
                    d.INSTANCE.aA("ce_login_id", "<LoginByID>", LoginPasswordUI.this.dYB);
                    d.INSTANCE.a("ce_login_id", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 65535));
                    d.INSTANCE.aIQ("ce_login_id");
                }
                LoginPasswordUI.this.bpf();
                a.a(this, "com/tencent/mm/plugin/account/ui/LoginPasswordUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196866);
            }
        });
        this.kjv = getIntent().getStringExtra("auth_ticket");
        if (!Util.isNullOrNil(this.kjv)) {
            this.klL.setText(Util.nullAsNil(g.bpk()));
            this.klM.setText(Util.nullAsNil(g.bpl()));
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.LoginPasswordUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(169128);
                    LoginPasswordUI.this.bpf();
                    AppMethodBeat.o(169128);
                }
            }, 500);
        }
        AppMethodBeat.o(128182);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI
    public final void bpf() {
        AppMethodBeat.i(128183);
        super.bpf();
        if (isFinishing() || getWindow() == null) {
            Log.e(TAG, "LoginHistoryUI is finishing");
            AppMethodBeat.o(128183);
            return;
        }
        this.klt.kdq = this.klM.getText().toString();
        if (this.klt.account.equals("")) {
            h.n(this, R.string.hvs, R.string.em8);
            AppMethodBeat.o(128183);
        } else if (this.klt.kdq.equals("")) {
            h.n(this, R.string.hvk, R.string.em8);
            AppMethodBeat.o(128183);
        } else {
            hideVKB();
            this.kmF.b(this, new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.LoginPasswordUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(196867);
                    LoginPasswordUI.b(LoginPasswordUI.this);
                    AppMethodBeat.o(196867);
                }
            });
            AppMethodBeat.o(128183);
        }
    }

    @Override // com.tencent.mm.plugin.account.ui.LoginHistoryUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        com.tencent.mm.h.a Dk;
        AppMethodBeat.i(196869);
        super.initView();
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("key_errType", 0);
            int intExtra2 = getIntent().getIntExtra("key_errCode", 0);
            String stringExtra = getIntent().getStringExtra("key_errMsg");
            Log.i(TAG, "initView,errType %d,errCode %d", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
            if (a.dK(intExtra, intExtra2) && (Dk = com.tencent.mm.h.a.Dk(stringExtra)) != null) {
                Dk.a(this, new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.plugin.account.ui.LoginPasswordUI.AnonymousClass9 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                    }
                });
            }
        }
        AppMethodBeat.o(196869);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(169131);
        this.kmF.a(this, i2, strArr, iArr);
        AppMethodBeat.o(169131);
    }

    static /* synthetic */ void b(LoginPasswordUI loginPasswordUI) {
        AppMethodBeat.i(196870);
        loginPasswordUI.bpg();
        final t tVar = new t(loginPasswordUI.klt.account, loginPasswordUI.klt.kdq, loginPasswordUI.kjv, 0);
        g.azz().a(tVar, 0);
        loginPasswordUI.getString(R.string.zb);
        loginPasswordUI.gtM = h.a((Context) loginPasswordUI, loginPasswordUI.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.LoginPasswordUI.AnonymousClass8 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(196868);
                g.azz().a(tVar);
                LoginPasswordUI.this.bph();
                AppMethodBeat.o(196868);
            }
        });
        AppMethodBeat.o(196870);
    }
}
