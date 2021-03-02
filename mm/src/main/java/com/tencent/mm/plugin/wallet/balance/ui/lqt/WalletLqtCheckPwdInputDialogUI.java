package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

@a(3)
public class WalletLqtCheckPwdInputDialogUI extends WalletBaseUI {
    private String HuD;
    private String HuW = "";
    private WcPayCashierDialog HuX;
    private String mTitle = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(68784);
        super.onCreate(bundle);
        setContentViewVisibility(4);
        this.mTitle = getIntent().getStringExtra("lqt_fetch_pwd_title");
        this.HuW = getIntent().getStringExtra("lqt_fetch_pwd_money");
        this.HuD = getIntent().getStringExtra("lqt_redeem_listid");
        Log.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s, redeemListId: %s", Util.nullAsNil(this.HuW), Util.nullAsNil(this.mTitle), this.HuD);
        if (Util.isNullOrNil(this.mTitle) || Util.isNullOrNil(this.HuW)) {
            z = false;
        }
        if (!z) {
            h.a(getContext(), (int) R.string.ijv, 0, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(68781);
                    WalletLqtCheckPwdInputDialogUI.this.finish();
                    AppMethodBeat.o(68781);
                }
            });
            AppMethodBeat.o(68784);
            return;
        }
        getWindow().setBackgroundDrawableResource(R.color.ac_);
        d.INSTANCE.asyncReportPaySecurityInfoThroughCgi();
        showDialog();
        AppMethodBeat.o(68784);
    }

    private void showDialog() {
        AppMethodBeat.i(68785);
        if (this.HuX != null && this.HuX.isShowing()) {
            this.HuX.dismiss();
        }
        this.HuW = f.D(Util.getDouble(this.HuW, 0.0d));
        this.HuX = new WcPayCashierDialog(getContext());
        this.HuX.a(this.mTitle, this.HuW, "", (List<egf>) null);
        this.HuX.IlX = new WcPayCashierDialog.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a
            public final void a(String str, FavorPayInfo favorPayInfo, Bankcard bankcard) {
                AppMethodBeat.i(68782);
                Intent intent = new Intent();
                intent.putExtra("lqt_fetch_enc_pwd", str);
                intent.putExtra("lqt_redeem_listid", WalletLqtCheckPwdInputDialogUI.this.HuD);
                WalletLqtCheckPwdInputDialogUI.this.setResult(-1, intent);
                WalletLqtCheckPwdInputDialogUI.this.finish();
                AppMethodBeat.o(68782);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a
            public final void onCancel() {
                AppMethodBeat.i(68783);
                Log.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
                WalletLqtCheckPwdInputDialogUI.this.finish();
                AppMethodBeat.o(68783);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a
            public final void fNc() {
            }
        };
        this.HuX.show();
        addDialog(this.HuX);
        AppMethodBeat.o(68785);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void cleanUiData(int i2) {
        AppMethodBeat.i(68786);
        if (i2 == 0) {
            finish();
            AppMethodBeat.o(68786);
            return;
        }
        if (i2 == 1) {
            showDialog();
        }
        AppMethodBeat.o(68786);
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
