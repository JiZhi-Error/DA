package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wallet_payu.security_question.model.d;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionSettingUI extends WalletBaseUI {
    private WalletPayUSecurityQuestionView IuK;
    private WalletFormView IuL;
    private m IuP;
    private String IuQ = "";
    private a IuR;
    private Button krs;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72231);
        super.onCreate(bundle);
        this.IuP = new m(this);
        this.IuP.CL(true);
        this.IuP.HLX = new o.f() {
            /* class com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(72223);
                mVar.clear();
                ArrayList a2 = WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this);
                if (a2 != null) {
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        mVar.add(((PayUSecurityQuestion) a2.get(i2)).desc);
                    }
                }
                AppMethodBeat.o(72223);
            }
        };
        this.IuP.HLY = new o.g() {
            /* class com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(72224);
                WalletPayUSecurityQuestionSettingUI.this.IuK.setQuestionText(((PayUSecurityQuestion) WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this).get(i2)).desc);
                WalletPayUSecurityQuestionSettingUI.this.IuQ = ((PayUSecurityQuestion) WalletPayUSecurityQuestionSettingUI.a(WalletPayUSecurityQuestionSettingUI.this).get(i2)).id;
                WalletPayUSecurityQuestionSettingUI.this.IuL.eIj();
                a.a(WalletPayUSecurityQuestionSettingUI.this.IuR);
                AppMethodBeat.o(72224);
            }
        };
        this.IuR = new a();
        this.IuK = (WalletPayUSecurityQuestionView) findViewById(R.id.g_x);
        this.IuL = (WalletFormView) findViewById(R.id.g_w);
        com.tencent.mm.wallet_core.ui.formview.a.g(this.IuL);
        this.krs = (Button) findViewById(R.id.g_v);
        this.IuK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(72225);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletPayUSecurityQuestionSettingUI.this.IuP.iv();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72225);
            }
        });
        this.IuL.setOnInputValidChangeListener(new WalletFormView.a() {
            /* class com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.AnonymousClass4 */

            @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(72226);
                a.a(WalletPayUSecurityQuestionSettingUI.this.IuR);
                AppMethodBeat.o(72226);
            }
        });
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(72227);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletPayUSecurityQuestionSettingUI.this.IuR.fUD()) {
                    WalletPayUSecurityQuestionSettingUI.this.getInput().putString("key_question_id", WalletPayUSecurityQuestionSettingUI.this.IuQ);
                    WalletPayUSecurityQuestionSettingUI.this.getInput().putString("key_question_answer", WalletPayUSecurityQuestionSettingUI.this.IuL.getText());
                    com.tencent.mm.wallet_core.a.l(WalletPayUSecurityQuestionSettingUI.this, WalletPayUSecurityQuestionSettingUI.this.getInput());
                } else {
                    a.a(WalletPayUSecurityQuestionSettingUI.this.IuR);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72227);
            }
        });
        a.a(this.IuR);
        AppMethodBeat.o(72231);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(72232);
        super.onResume();
        AppMethodBeat.o(72232);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72233);
        if ((qVar instanceof d) && this.IuP.isShowing()) {
            this.IuP.dismiss();
        }
        AppMethodBeat.o(72233);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bhn;
    }

    /* access modifiers changed from: protected */
    public class a {
        protected a() {
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(72230);
            aVar.fUz();
            AppMethodBeat.o(72230);
        }

        private void fUz() {
            AppMethodBeat.i(72228);
            if (fUD()) {
                WalletPayUSecurityQuestionSettingUI.this.krs.setEnabled(true);
                AppMethodBeat.o(72228);
                return;
            }
            WalletPayUSecurityQuestionSettingUI.this.krs.setEnabled(false);
            AppMethodBeat.o(72228);
        }

        /* access modifiers changed from: protected */
        public final boolean fUD() {
            AppMethodBeat.i(72229);
            if (!WalletPayUSecurityQuestionSettingUI.this.IuK.bql() || !WalletPayUSecurityQuestionSettingUI.this.IuL.bql()) {
                AppMethodBeat.o(72229);
                return false;
            }
            AppMethodBeat.o(72229);
            return true;
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    static /* synthetic */ ArrayList a(WalletPayUSecurityQuestionSettingUI walletPayUSecurityQuestionSettingUI) {
        AppMethodBeat.i(72234);
        ArrayList parcelableArrayList = walletPayUSecurityQuestionSettingUI.getInput().getParcelableArrayList("key_security_question_list");
        AppMethodBeat.o(72234);
        return parcelableArrayList;
    }
}
