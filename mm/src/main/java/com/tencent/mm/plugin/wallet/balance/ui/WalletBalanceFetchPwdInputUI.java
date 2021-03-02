package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletBalanceFetchPwdInputUI extends WalletBaseUI {
    private String HuW = "";
    private WcPayCashierDialog HuX;
    private String lem;
    private String mTitle = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(68559);
        super.onCreate(bundle);
        setContentViewVisibility(4);
        this.mTitle = getInput().getString("key_pwd_cash_title");
        this.HuW = getInput().getString("key_pwd_cash_money");
        this.lem = getInput().getString("key_report_session_id");
        Log.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: money : %s, title : %s", Util.nullAsNil(this.HuW), Util.nullAsNil(this.mTitle));
        if (Util.isNullOrNil(this.mTitle) || Util.isNullOrNil(this.HuW)) {
            z = false;
        }
        if (!z) {
            h.a(getContext(), (int) R.string.ijv, 0, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68556);
                    WalletBalanceFetchPwdInputUI.this.finish();
                    AppMethodBeat.o(68556);
                }
            });
            AppMethodBeat.o(68559);
            return;
        }
        d.INSTANCE.asyncReportPaySecurityInfoThroughCgi();
        showDialog();
        AppMethodBeat.o(68559);
    }

    @Override // com.tencent.mm.wallet_core.d.f, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onSceneEnd(int i2, int i3, String str, q qVar, boolean z) {
        AppMethodBeat.i(68560);
        super.onSceneEnd(i2, i3, str, qVar, z);
        if (qVar instanceof b) {
            setAuthState(false);
        }
        AppMethodBeat.o(68560);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void showDialog() {
        /*
        // Method dump skipped, instructions count: 316
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI.showDialog():void");
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void cleanUiData(int i2) {
        AppMethodBeat.i(68562);
        if (i2 == 0) {
            finish();
            AppMethodBeat.o(68562);
            return;
        }
        if (i2 == 1) {
            showDialog();
        }
        AppMethodBeat.o(68562);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
