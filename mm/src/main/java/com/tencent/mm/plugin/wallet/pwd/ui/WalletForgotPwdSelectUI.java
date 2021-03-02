package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.se;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.smtt.sdk.TbsListener;

public class WalletForgotPwdSelectUI extends WalletBaseUI {
    private View HJw;
    private View HJx;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(WalletForgotPwdSelectUI walletForgotPwdSelectUI) {
        AppMethodBeat.i(69650);
        walletForgotPwdSelectUI.fPe();
        AppMethodBeat.o(69650);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69646);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        setMMTitleVisibility(8);
        this.HJw = findViewById(R.id.c8v);
        this.HJx = findViewById(R.id.a1i);
        this.HJw.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(69644);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdSelectUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletForgotPwdSelectUI.a(WalletForgotPwdSelectUI.this);
                a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdSelectUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69644);
            }
        });
        this.HJx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(69645);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdSelectUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WalletForgotPwdSelectUI.this.getProcess() != null) {
                    h.INSTANCE.a(15774, Integer.valueOf(WalletForgotPwdSelectUI.this.getProcess().dQL.getInt("key_forgot_scene", 1)), 3);
                }
                WalletForgotPwdSelectUI.b(WalletForgotPwdSelectUI.this);
                a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdSelectUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69645);
            }
        });
        AppMethodBeat.o(69646);
    }

    private void fPe() {
        AppMethodBeat.i(69647);
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "goToBankcard");
        getInput().putBoolean("key_select_bank_card", true);
        getProcess().a(this, 0, getInput());
        AppMethodBeat.o(69647);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69648);
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "onActivityResult, requestCode: %s, resultCode: %s, data: %s", Integer.valueOf(i2), Integer.valueOf(i3), intent);
        if (intent == null) {
            intent = new Intent();
        }
        int intExtra = intent.getIntExtra("err_code", 0);
        int intExtra2 = intent.getIntExtra("scene", 0);
        int intExtra3 = intent.getIntExtra("countFace", 0);
        long longExtra = intent.getLongExtra("totalTime", 0);
        int intExtra4 = intent.getIntExtra("err_type", 6);
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "errCode： ".concat(String.valueOf(intExtra)));
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "scene： ".concat(String.valueOf(intExtra2)));
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "countFace： ".concat(String.valueOf(intExtra3)));
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "totalTime： ".concat(String.valueOf(longExtra)));
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "errorType： ".concat(String.valueOf(intExtra4)));
        if (i2 == 233) {
            if (i3 == -1) {
                Log.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_OK");
                if (!(intent == null || intent.getExtras() == null)) {
                    String string = intent.getExtras().getString("token");
                    if (getProcess() != null && !Util.isNullOrNil(string)) {
                        h.INSTANCE.a(15774, Integer.valueOf(getProcess().dQL.getInt("key_forgot_scene", 1)), 4);
                        h.INSTANCE.a(15711, Integer.valueOf(intExtra2), 0, Integer.valueOf(intExtra3), Long.valueOf(longExtra), 1, 0, Integer.valueOf(intExtra));
                    }
                    getInput().putString("key_face_action_result_token", string);
                    getInput().putBoolean("key_is_set_pwd_after_face_action", true);
                    getProcess().a(this, 0, getInput());
                    finish();
                    AppMethodBeat.o(69648);
                    return;
                }
            } else {
                if (!(intent == null || intent.getExtras() == null)) {
                    String string2 = intent.getExtras().getString("click_other_verify_btn");
                    boolean z = !Util.isNullOrNil(string2) && string2.equalsIgnoreCase("yes");
                    Log.i("MicroMsg.WalletForgotPwdSelectUI", "isClickOtherVerify: %s", string2);
                    if (z) {
                        Log.i("MicroMsg.WalletForgotPwdSelectUI", "check face failed, click other verify");
                        if (getProcess() != null) {
                            h.INSTANCE.a(15774, Integer.valueOf(getProcess().dQL.getInt("key_forgot_scene", 1)), 5);
                            h.INSTANCE.a(15711, Integer.valueOf(intExtra2), 3, Integer.valueOf(intExtra3), Long.valueOf(longExtra), 1, Integer.valueOf(intExtra4), Integer.valueOf(intExtra));
                        }
                        fPe();
                    }
                }
                if (i3 == 0) {
                    Log.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_CANCELED");
                    if (getProcess() != null) {
                        h.INSTANCE.a(15774, Integer.valueOf(getProcess().dQL.getInt("key_forgot_scene", 1)), 6);
                        h.INSTANCE.a(15711, Integer.valueOf(intExtra2), 2, Integer.valueOf(intExtra3), Long.valueOf(longExtra), 1, 1, Integer.valueOf(intExtra));
                    }
                }
            }
        }
        AppMethodBeat.o(69648);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c8z;
    }

    static /* synthetic */ void a(WalletForgotPwdSelectUI walletForgotPwdSelectUI) {
        AppMethodBeat.i(69649);
        if (walletForgotPwdSelectUI.getProcess() != null) {
            h.INSTANCE.a(15774, Integer.valueOf(walletForgotPwdSelectUI.getProcess().dQL.getInt("key_forgot_scene", 1)), 2);
            h.INSTANCE.idkeyStat(917, 33, 1, false);
        }
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "gotToFaceCheck");
        se seVar = new se();
        seVar.dYI.dKq = walletForgotPwdSelectUI;
        seVar.dYI.scene = walletForgotPwdSelectUI.getInput().getInt("key_face_action_scene");
        seVar.dYI.packageName = walletForgotPwdSelectUI.getInput().getString("key_face_action_package");
        seVar.dYI.dYK = walletForgotPwdSelectUI.getInput().getString("key_face_action_package_sign");
        seVar.dYI.dYL = walletForgotPwdSelectUI.getString(R.string.id5);
        seVar.dYI.requestCode = TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
        EventCenter.instance.publish(seVar);
        AppMethodBeat.o(69649);
    }
}
