package com.tencent.mm.app;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class ad extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    ad() {
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(160031);
        super.onCreate(bundle);
        Log.i("WxSplash.SuicideHackActivity", "onCreate");
        finish();
        AppMethodBeat.o(160031);
    }
}
