package com.tencent.mm.splash;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

/* access modifiers changed from: package-private */
public final class i extends HellActivity {
    public String NMc;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    i() {
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(40672);
        super.onCreate(bundle);
        h.c("WxSplash.SplashHackActivity", "onCreate", new Object[0]);
        setVisible(false);
        Intent intent = new Intent(this, h.gyp());
        intent.putExtra("hashcode", hashCode());
        startActivityForResult(intent, 100);
        overridePendingTransition(0, 0);
        AppMethodBeat.o(40672);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(40673);
        h.c("WxSplash.SplashHackActivity", "onNewIntent.", new Object[0]);
        if (h.NLE != null && h.NLE.n(intent)) {
            finish();
        }
        AppMethodBeat.o(40673);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onResume() {
        AppMethodBeat.i(40674);
        super.onResume();
        h.c("WxSplash.SplashHackActivity", "onResume", new Object[0]);
        AppMethodBeat.o(40674);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onPause() {
        AppMethodBeat.i(40675);
        h.c("WxSplash.SplashHackActivity", "onPause", new Object[0]);
        super.onPause();
        AppMethodBeat.o(40675);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public final void onDestroy() {
        AppMethodBeat.i(40676);
        h.c("WxSplash.SplashHackActivity", "onDestroy", new Object[0]);
        h.NLB.remove(this);
        setVisible(true);
        h.NLB.remove(this);
        super.onDestroy();
        AppMethodBeat.o(40676);
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(40677);
        if (i2 != 100) {
            finish();
            h.c("WxSplash.SplashHackActivity", "unknown request code.", new Object[0]);
        } else if (i3 != -100) {
            onBackPressed();
            AppMethodBeat.o(40677);
            return;
        }
        AppMethodBeat.o(40677);
    }
}
