package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUSecurityQuestionAnswerUI extends WalletBaseUI {
    private WalletPayUSecurityQuestionView IuK;
    private WalletFormView IuL;
    private PayUSecurityQuestion IuM;
    private a IuN;
    private Button krs;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72221);
        super.onCreate(bundle);
        this.IuN = new a();
        this.IuK = (WalletPayUSecurityQuestionView) findViewById(R.id.g_x);
        this.IuL = (WalletFormView) findViewById(R.id.g_w);
        com.tencent.mm.wallet_core.ui.formview.a.g(this.IuL);
        this.krs = (Button) findViewById(R.id.g_v);
        this.IuL.setOnInputValidChangeListener(new WalletFormView.a() {
            /* class com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
            public final void onInputValidChange(boolean z) {
                boolean z2;
                AppMethodBeat.i(72219);
                a aVar = WalletPayUSecurityQuestionAnswerUI.this.IuN;
                if (WalletPayUSecurityQuestionAnswerUI.this.IuL.bql()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    WalletPayUSecurityQuestionAnswerUI.this.krs.setEnabled(true);
                    AppMethodBeat.o(72219);
                    return;
                }
                WalletPayUSecurityQuestionAnswerUI.this.krs.setEnabled(false);
                AppMethodBeat.o(72219);
            }
        });
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(72220);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionAnswerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletPayUSecurityQuestionAnswerUI.this.IuL.bql()) {
                    WalletPayUSecurityQuestionAnswerUI.this.getInput().putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.this.IuL.getText());
                    WalletPayUSecurityQuestionAnswerUI.this.getNetController().r(new Object[0]);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/security_question/ui/WalletPayUSecurityQuestionAnswerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72220);
            }
        });
        AppMethodBeat.o(72221);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72222);
        if (i2 == 0 && i3 == 0) {
            this.IuM = (PayUSecurityQuestion) getInput().getParcelable("key_security_question");
            Log.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
            if (this.IuM != null) {
                this.IuK.setQuestionText(this.IuM.desc);
            }
            this.IuL.eIj();
        }
        AppMethodBeat.o(72222);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bhm;
    }

    /* access modifiers changed from: protected */
    public class a {
        protected a() {
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }
}
