package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(19)
public class WalletSetPasswordUI extends WalletBaseUI {
    private TextView mPa;
    private TextView pYW;
    protected EditHintPasswdView ykY;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71234);
        super.onCreate(bundle);
        hideTitleView();
        initView();
        f.b(this, getInput(), 5);
        findViewById(R.id.b47).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(71232);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSetPasswordUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletSetPasswordUI.this.needConfirmFinish()) {
                    WalletSetPasswordUI.this.hideVKB();
                    WalletSetPasswordUI.this.showDialog(1000);
                } else {
                    WalletSetPasswordUI.this.finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSetPasswordUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71232);
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.afz));
            if (Build.VERSION.SDK_INT >= 23) {
                window.getDecorView().setSystemUiVisibility(8192);
            }
        }
        getContentView().setFitsSystemWindows(true);
        AppMethodBeat.o(71234);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String string;
        AppMethodBeat.i(71235);
        this.mPa = (TextView) findViewById(R.id.jhz);
        this.pYW = (TextView) findViewById(R.id.jhu);
        if (getInput().getBoolean("key_is_forgot_process", false) && !Util.isNullOrNil(getInput().getString("key_identity")) && getInput().getInt("key_id_type", -1) != -1 && !Util.isNullOrNil(getInput().getString("key_true_name"))) {
            this.pYW.setVisibility(4);
        }
        if (getProcess() != null && "ModifyPwdProcess".equals(getProcess().dKC())) {
            this.mPa.setText(R.string.ij1);
        } else if (getProcess() != null && "ResetPwdProcessByToken".equals(getProcess().dKC())) {
            String string2 = getInput().getString("key_pwd_title");
            String string3 = getInput().getString("key_pwd_desc");
            if (!Util.isNullOrNil(string2)) {
                this.mPa.setText(string2);
            }
            if (!Util.isNullOrNil(string3)) {
                this.pYW.setText(string3);
                this.pYW.setVisibility(0);
            }
        }
        if (getInput().getInt("key_err_code", 0) == -1002) {
            TextView textView = (TextView) findViewById(R.id.dyo);
            textView.setVisibility(0);
            if (z.aUo()) {
                string = getString(R.string.isq);
            } else {
                string = getString(R.string.isp);
            }
            textView.setText(string);
            getInput().putInt("key_err_code", 0);
        }
        this.ykY = (EditHintPasswdView) findViewById(R.id.dyp);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.ykY);
        findViewById(R.id.a4v).setVisibility(8);
        this.ykY.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI.AnonymousClass2 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(71233);
                if (z) {
                    String md5Value = WalletSetPasswordUI.this.ykY.getMd5Value();
                    Bundle bundle = new Bundle();
                    bundle.putString("key_new_pwd1", md5Value);
                    WalletSetPasswordUI.this.ykY.eIj();
                    com.tencent.mm.wallet_core.a.l(WalletSetPasswordUI.this, bundle);
                }
                AppMethodBeat.o(71233);
            }
        });
        setEditFocusListener(this.ykY, 0, false);
        AppMethodBeat.o(71235);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(71236);
        this.ykY.requestFocus();
        super.onResume();
        AppMethodBeat.o(71236);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ca3;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        AppMethodBeat.i(214247);
        if (getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a) {
            AppMethodBeat.o(214247);
            return false;
        }
        AppMethodBeat.o(214247);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}
