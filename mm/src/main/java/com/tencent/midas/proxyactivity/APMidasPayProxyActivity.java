package com.tencent.midas.proxyactivity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginProxyActivity;

public class APMidasPayProxyActivity extends APPluginProxyActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.midas.plugin.APPluginProxyActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.midas.plugin.APPluginProxyActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(192799);
        super.onCreate(bundle);
        AppMethodBeat.o(192799);
    }

    @Override // com.tencent.midas.plugin.APPluginProxyActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(192800);
        APLog.i("APMidasPayProxyActivity", "onActivityResult requestCode:" + i2 + " resultCode:" + i3);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(192800);
    }
}
