package com.tencent.midas.qq;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.plugin.APPluginInterfaceManager;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class APMidasQQWalletActivity extends HellActivity {
    private static final String TAG = "APMidasQQWalletActivity";

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(192797);
        super.onCreate(bundle);
        try {
            getIntent().getStringExtra("wxpay");
            try {
                requestWindowFeature(1);
                handleIntent(getIntent());
                finish();
                AppMethodBeat.o(192797);
            } catch (Throwable th) {
                finish();
                AppMethodBeat.o(192797);
            }
        } catch (Exception e2) {
            finish();
            AppMethodBeat.o(192797);
        }
    }

    private void handleIntent(Intent intent) {
        AppMethodBeat.i(192798);
        APLog.d(TAG, "handleIntent get called!");
        try {
            APPluginInterfaceManager.initPluginInterface(this, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_HANDLE_QQ_WALLET_INTENT, new Object[]{this, intent});
            AppMethodBeat.o(192798);
        } catch (Exception e2) {
            APLog.e(TAG, "handleIntent got exception = " + e2.toString());
            AppMethodBeat.o(192798);
        }
    }
}
