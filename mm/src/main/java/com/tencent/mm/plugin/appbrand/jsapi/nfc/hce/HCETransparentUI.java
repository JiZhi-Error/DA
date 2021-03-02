package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.Log;

@Deprecated
public class HCETransparentUI extends HellActivity {
    private ResultReceiver MU;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(136177);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(R.layout.au8);
        this.MU = (ResultReceiver) getIntent().getParcelableExtra("HCE_Result_Receiver");
        a.mht.a(this, this.MU);
        a.mht.resetStatus();
        AppMethodBeat.o(136177);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(136178);
        super.onResume();
        Log.i("MicroMsg.HCETransparentUI", "alvinluo onResume");
        overridePendingTransition(0, 0);
        a.mht.b(new ComponentName(this, HCEService.class.getCanonicalName()));
        a.mht.bHM();
        AppMethodBeat.o(136178);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(136179);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.HCETransparentUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        a.mht.xk(i2);
        AppMethodBeat.o(136179);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(136180);
        super.onPause();
        a.mht.dismissDialog();
        AppMethodBeat.o(136180);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(136181);
        super.onDestroy();
        AppMethodBeat.o(136181);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(136182);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(136182);
    }
}
