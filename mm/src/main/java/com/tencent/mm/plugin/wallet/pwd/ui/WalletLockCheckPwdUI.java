package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wallet.pwd.a.s;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

public class WalletLockCheckPwdUI extends WalletBaseUI {
    private w HCq;
    private EditHintPasswdView HKf;
    private int HKg = -1;
    private String Nl;
    private TextView mPa;
    private TextView pYW;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        AppMethodBeat.i(69724);
        walletLockCheckPwdUI.aeC(4);
        AppMethodBeat.o(69724);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69716);
        super.onCreate(bundle);
        hideTitleView();
        this.HKg = getIntent().getIntExtra("key_wallet_lock_type", -1);
        this.Nl = getIntent().getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        Log.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", Integer.valueOf(this.HKg), this.Nl);
        this.HKf = (EditHintPasswdView) findViewById(R.id.dyp);
        this.mPa = (TextView) findViewById(R.id.jhz);
        this.pYW = (TextView) findViewById(R.id.jhu);
        String stringExtra = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
        if (this.HKg == 2) {
            this.mPa.setText(R.string.ivu);
            if (this.Nl.equals("action.touchlock_need_verify_paypwd") && !Util.isNullOrNil(stringExtra)) {
                this.pYW.setText(stringExtra);
            }
        } else if (this.HKg == 1) {
            this.mPa.setText(R.string.ivv);
        }
        this.HKf.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI.AnonymousClass3 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(boolean z) {
                int i2 = 8;
                AppMethodBeat.i(69715);
                if (z) {
                    if (WalletLockCheckPwdUI.this.Nl == null) {
                        AppMethodBeat.o(69715);
                        return;
                    } else if (WalletLockCheckPwdUI.this.Nl.equals("action.close_wallet_lock")) {
                        WalletLockCheckPwdUI.c(WalletLockCheckPwdUI.this);
                        AppMethodBeat.o(69715);
                        return;
                    } else if (WalletLockCheckPwdUI.this.Nl.equals("action.verify_paypwd")) {
                        if (WalletLockCheckPwdUI.this.HKg == 1) {
                            i2 = 6;
                        } else if (WalletLockCheckPwdUI.this.HKg != 2) {
                            i2 = -1;
                        }
                        WalletLockCheckPwdUI.this.HCq = new w(WalletLockCheckPwdUI.this.HKf.getText(), i2, WalletLockCheckPwdUI.this.getPayReqKey());
                        WalletLockCheckPwdUI.this.doSceneForceProgress(WalletLockCheckPwdUI.this.HCq);
                        AppMethodBeat.o(69715);
                        return;
                    } else if (WalletLockCheckPwdUI.this.Nl.equals("action.touchlock_verify_by_paypwd")) {
                        WalletLockCheckPwdUI.this.doSceneForceProgress(new s(WalletLockCheckPwdUI.this.HKf.getText()));
                        AppMethodBeat.o(69715);
                        return;
                    } else if (WalletLockCheckPwdUI.this.Nl.equals("action.touchlock_need_verify_paypwd")) {
                        if (WalletLockCheckPwdUI.this.HKg != 2) {
                            i2 = -1;
                        }
                        WalletLockCheckPwdUI.this.HCq = new w(WalletLockCheckPwdUI.this.HKf.getText(), i2, WalletLockCheckPwdUI.this.getPayReqKey());
                        WalletLockCheckPwdUI.this.doSceneForceProgress(WalletLockCheckPwdUI.this.HCq);
                    }
                }
                AppMethodBeat.o(69715);
            }
        });
        setEditFocusListener(this.HKf, 0, false);
        this.HKf.hhY();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69713);
                Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
                WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this);
                AppMethodBeat.o(69713);
                return true;
            }
        });
        findViewById(R.id.b47).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(69714);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletLockCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
                WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this);
                a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletLockCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69714);
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
        AppMethodBeat.o(69716);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69717);
        super.onResume();
        if (this.HKf != null) {
            this.HKf.eIj();
        }
        AppMethodBeat.o(69717);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(69718);
        Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
        aeC(4);
        AppMethodBeat.o(69718);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onProgressFinish() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8l;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void cleanUiData(int i2) {
        AppMethodBeat.i(69719);
        super.cleanUiData(i2);
        this.HKf.eIj();
        AppMethodBeat.o(69719);
    }

    private void aeC(int i2) {
        AppMethodBeat.i(69720);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(69720);
    }

    private void P(int i2, String str, String str2) {
        AppMethodBeat.i(69721);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_token", str);
        intent.putExtra("key_type", str2);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(69721);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69722);
        Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof w) {
            w wVar = (w) qVar;
            if (i2 == 0 && i3 == 0) {
                if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action"))) {
                    Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
                    Intent intent = new Intent();
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.switch_on_pattern");
                    intent.putExtra("next_action", "next_action.switch_on_pattern");
                    intent.putExtra("token", wVar.token);
                    intent.putExtra("type", wVar.HPZ);
                    intent.putExtra("key_wallet_lock_type", this.HKg);
                    intent.setPackage(MMApplicationContext.getPackageName());
                    if (this.HKg == 2) {
                        intent.putExtra("key_pay_passwd", this.HKf.getText());
                    }
                    ww wwVar = new ww();
                    wwVar.edk.edm = intent;
                    wwVar.edk.dKq = this;
                    wwVar.edk.requestCode = 1;
                    EventCenter.instance.publish(wwVar);
                } else {
                    P(0, wVar.token, wVar.HPZ);
                }
                AppMethodBeat.o(69722);
                return true;
            } else if (i2 == 1000 && i3 == 3) {
                P(-1, null, null);
                AppMethodBeat.o(69722);
                return true;
            }
        } else if (qVar instanceof s) {
            if (i2 == 0 && i3 == 0) {
                aeC(0);
            } else {
                aeC(-1);
            }
            AppMethodBeat.o(69722);
            return true;
        } else if (qVar instanceof e) {
            if (i2 == 0 && i3 == 0) {
                aeC(0);
            } else {
                aeC(-1);
            }
        }
        AppMethodBeat.o(69722);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(69723);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        Log.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b", objArr);
        setResult(i3, intent);
        finish();
        AppMethodBeat.o(69723);
    }

    static /* synthetic */ void c(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        AppMethodBeat.i(69725);
        walletLockCheckPwdUI.doSceneForceProgress(new e(walletLockCheckPwdUI.HKf.getText()));
        AppMethodBeat.o(69725);
    }
}
