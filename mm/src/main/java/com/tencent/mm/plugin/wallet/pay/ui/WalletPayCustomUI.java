package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletPayCustomUI extends WalletBaseUI {
    protected r HGx;
    private String HGy = "";
    private boolean HGz = false;
    private int mScene = 0;
    private String mTitle = "";
    private eig yjZ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69364);
        super.onCreate(bundle);
        setContentViewVisibility(8);
        this.HGy = getIntent().getStringExtra("INTENT_PAYFEE");
        this.mTitle = getIntent().getStringExtra("INTENT_TITLE");
        this.HGz = getIntent().getIntExtra("INTENT_CAN_TOUCH", 0) == 1;
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_TOKENMESS");
        this.yjZ = new eig();
        try {
            this.yjZ.parseFrom(byteArrayExtra);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletPayCustomUI", e2, "", new Object[0]);
        }
        Log.i("MicroMsg.WalletPayCustomUI", "mTokeMess packageex:%s busi_id:%s sign:%s can_use_touch %s mPayFee %s mTitle %s", this.yjZ.Nhw, this.yjZ.GaP, this.yjZ.sign, Boolean.valueOf(this.HGz), this.HGy, this.mTitle);
        this.HGx = r.a(this, this.mTitle, this.HGy, "", this.HGz, new r.b() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.r.b
            public final void h(String str, boolean z, String str2) {
                AppMethodBeat.i(69361);
                WalletPayCustomUI.this.doSceneProgress(new ab(str, WalletPayCustomUI.this.yjZ.Nhx, WalletPayCustomUI.this.yjZ.Nhw, WalletPayCustomUI.this.yjZ.sign, WalletPayCustomUI.this.yjZ.qcK, WalletPayCustomUI.this.yjZ.GaP, z ? 1 : 0, str2, ""), true);
                AppMethodBeat.o(69361);
            }
        }, new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(69362);
                WalletPayCustomUI.this.finish();
                AppMethodBeat.o(69362);
            }
        }, new r.a() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.r.a
            public final void ezC() {
                AppMethodBeat.i(69363);
                WalletPayCustomUI.this.finish();
                AppMethodBeat.o(69363);
            }
        });
        AppMethodBeat.o(69364);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69365);
        super.onResume();
        AppMethodBeat.o(69365);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(69366);
        super.onPause();
        AppMethodBeat.o(69366);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69367);
        super.onDestroy();
        AppMethodBeat.o(69367);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69368);
        Log.i("MicroMsg.WalletPayCustomUI", "errorType %s errCode %s, errmsg %s, scene %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if (qVar instanceof ab) {
            if (i2 == 0 && i3 == 0) {
                Intent intent = new Intent();
                intent.putExtra("INTENT_RESULT_TOKEN", ((ab) qVar).HQm);
                intent.putExtras(getIntent());
                setResult(-1, intent);
            }
            finish();
        }
        AppMethodBeat.o(69368);
        return false;
    }
}
