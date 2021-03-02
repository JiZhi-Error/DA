package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletPayUStartOpenUI extends WalletBaseUI {
    private WalletPayUOpenIntroView Itn;
    private MMFormMobileInputView Ito;
    private EditText Itp;
    private EditText Itq;
    private Button Itr;
    private TextView Its;
    private TextView Itt;
    private String Itu;
    private String knP;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletPayUStartOpenUI walletPayUStartOpenUI) {
        AppMethodBeat.i(72043);
        walletPayUStartOpenUI.fUB();
        AppMethodBeat.o(72043);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72038);
        super.onCreate(bundle);
        this.knP = getInput().getString("key_mobile");
        this.Itu = getInput().getString("dial_code");
        if (Util.isNullOrNil(this.Itu)) {
            this.Itu = "27";
        }
        this.Itn = (WalletPayUOpenIntroView) findViewById(R.id.dzb);
        this.Itn.setPagerData(new d[]{new d(R.drawable.ck2, R.string.iov, R.string.iop), new d(R.drawable.ck3, R.string.iow, R.string.ioq), new d(R.drawable.ck4, R.string.iox, R.string.ior)});
        this.Ito = (MMFormMobileInputView) findViewById(R.id.i4l);
        this.Itr = (Button) findViewById(R.id.i4e);
        this.Itp = this.Ito.getCountryCodeEditText();
        this.Itq = this.Ito.getMobileNumberEditText();
        if (!Util.isNullOrNil(this.knP)) {
            this.Itq.setText(this.knP);
        }
        if (!Util.isNullOrNil(this.Itu)) {
            this.Itp.setText(this.Itu);
        }
        AnonymousClass1 r0 = new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(72036);
                WalletPayUStartOpenUI.a(WalletPayUStartOpenUI.this);
                AppMethodBeat.o(72036);
            }
        };
        this.Itq.addTextChangedListener(r0);
        this.Itp.addTextChangedListener(r0);
        this.Itr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(72037);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/create/ui/WalletPayUStartOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletPayUStartOpenUI.this.Ito.getVisibility() == 0) {
                    WalletPayUStartOpenUI.this.getInput().putString("key_mobile", WalletPayUStartOpenUI.this.knP);
                    WalletPayUStartOpenUI.this.getInput().putString("dial_code", WalletPayUStartOpenUI.this.Itu);
                }
                WalletPayUStartOpenUI.this.getNetController().r(new Object[0]);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/create/ui/WalletPayUStartOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72037);
            }
        });
        this.Its = (TextView) findViewById(R.id.i4j);
        c.a(this, this.Its);
        this.Itt = (TextView) findViewById(R.id.i4n);
        this.Itt.setText(ah.hhy());
        AppMethodBeat.o(72038);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(72039);
        super.onResume();
        fUB();
        AppMethodBeat.o(72039);
    }

    private String fOi() {
        AppMethodBeat.i(72040);
        if (this.Ito.getCountryCode().startsWith("+")) {
            String substring = this.Ito.getCountryCode().substring(1);
            AppMethodBeat.o(72040);
            return substring;
        }
        String countryCode = this.Ito.getCountryCode();
        AppMethodBeat.o(72040);
        return countryCode;
    }

    private boolean fUA() {
        AppMethodBeat.i(72041);
        if (Util.isNullOrNil(fOi()) || Util.isNullOrNil(this.Itq.getText().toString())) {
            AppMethodBeat.o(72041);
            return false;
        }
        AppMethodBeat.o(72041);
        return true;
    }

    private void fUB() {
        AppMethodBeat.i(72042);
        if (this.Ito.getVisibility() == 0) {
            if (fUA()) {
                this.Itu = fOi();
                this.knP = this.Ito.getMobileNumber();
                this.Itr.setEnabled(true);
                AppMethodBeat.o(72042);
                return;
            }
            this.Itr.setEnabled(false);
        }
        AppMethodBeat.o(72042);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bho;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }
}
