package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.d;

@a(3)
public class WalletOpenECardProxyUI extends WalletECardBaseUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBaseUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71792);
        super.onCreate(bundle);
        setContentViewVisibility(4);
        d process = getProcess();
        if (process != null) {
            int i2 = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq, 0);
            boolean z = getInput().getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpI, false);
            Log.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, isReuseExistCard: %s", Integer.valueOf(i2), Boolean.valueOf(z));
            if (z) {
                getNetController().r(2, Integer.valueOf(i2), Boolean.TRUE);
                AppMethodBeat.o(71792);
                return;
            }
            String string = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipr);
            Log.i("MicroMsg.WalletOpenECardProxyUI", "onCreate, openScene: %s, token==null:%s, isTokenInvalid: %s", Integer.valueOf(i2), Boolean.valueOf(Util.isNullOrNil(string)), Boolean.valueOf(getInput().getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.Ipt, false)));
            if (!Util.isNullOrNil(string)) {
                getNetController().r(1, Integer.valueOf(i2), string);
                AppMethodBeat.o(71792);
                return;
            }
            process.a(getContext(), 0, getInput());
            AppMethodBeat.o(71792);
            return;
        }
        Log.w("MicroMsg.WalletOpenECardProxyUI", "no process!!!");
        finish();
        AppMethodBeat.o(71792);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71793);
        Log.i("MicroMsg.WalletOpenECardProxyUI", "activity result, request:%s, result: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 != 1) {
            super.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(71793);
        } else if (i3 == -1) {
            setResult(0);
            d process = getProcess();
            if (process != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_process_result_code", 0);
                process.b(this, 0, bundle);
                AppMethodBeat.o(71793);
                return;
            }
            finish();
            AppMethodBeat.o(71793);
        } else {
            finish();
            AppMethodBeat.o(71793);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(71794);
        int intExtra = intent.getIntExtra("key_process_result_code", -1);
        boolean booleanExtra = intent.getBooleanExtra("key_process_is_end", false);
        Log.i("MicroMsg.WalletOpenECardProxyUI", "new intent, resultCode: %d, isEnd: %s", Integer.valueOf(intExtra), Boolean.valueOf(booleanExtra));
        if (intExtra == -1) {
            if (intent.getBooleanExtra("key_goto_lqt_detail", false)) {
                Log.i("MicroMsg.WalletOpenECardProxyUI", "jump to detail");
                Intent intent2 = new Intent();
                intent2.putExtra("key_account_type", 2);
                c.b(this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent2);
            }
            setResult(-1);
        } else {
            setResult(0);
        }
        d process = getProcess();
        if (booleanExtra) {
            finish();
            AppMethodBeat.o(71794);
            return;
        }
        if (process != null) {
            process.bA(getContext());
        }
        AppMethodBeat.o(71794);
    }
}
