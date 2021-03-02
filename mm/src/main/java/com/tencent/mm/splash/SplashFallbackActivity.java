package com.tencent.mm.splash;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.vfs.o;

public class SplashFallbackActivity extends HellActivity {
    private Runnable NLZ = new Runnable() {
        /* class com.tencent.mm.splash.SplashFallbackActivity.AnonymousClass1 */
        private long NMa = -1;

        public final void run() {
            AppMethodBeat.i(40667);
            if (this.NMa == -1) {
                this.NMa = System.currentTimeMillis();
            }
            if (SplashFallbackActivity.gyv()) {
                h.c("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone true", new Object[0]);
                SplashFallbackActivity.this.finish();
                SplashFallbackActivity.this.overridePendingTransition(R.anim.f4, R.anim.f2);
                AppMethodBeat.o(40667);
            } else if (System.currentTimeMillis() - this.NMa >= 80000) {
                h.c("MicroMsg.FallbackSplash", "checkIfMainProcessStartupDone timeout", new Object[0]);
                SplashFallbackActivity.this.finish();
                SplashFallbackActivity.this.overridePendingTransition(R.anim.f4, R.anim.f2);
                AppMethodBeat.o(40667);
            } else {
                SplashFallbackActivity.this.mHandler.postDelayed(SplashFallbackActivity.this.NLZ, 100);
                AppMethodBeat.o(40667);
            }
        }
    };
    private Handler mHandler;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SplashFallbackActivity() {
        AppMethodBeat.i(40668);
        AppMethodBeat.o(40668);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(40669);
        super.onCreate(bundle);
        h.c("MicroMsg.FallbackSplash", "onCreate", new Object[0]);
        HandlerThread handlerThread = new HandlerThread("splash-activity");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mHandler.postDelayed(this.NLZ, 100);
        AppMethodBeat.o(40669);
    }

    public void onBackPressed() {
        AppMethodBeat.i(40670);
        h.c("MicroMsg.FallbackSplash", "block onBackPressed", new Object[0]);
        AppMethodBeat.o(40670);
    }

    static /* synthetic */ boolean gyv() {
        AppMethodBeat.i(40671);
        String gya = a.gya();
        if (!new o(gya).exists()) {
            h.c("MicroMsg.FigLeaf", "dex opt dir not exists.", new Object[0]);
        } else if (new o(gya + "/main-process-blocking").exists()) {
            AppMethodBeat.o(40671);
            return false;
        }
        AppMethodBeat.o(40671);
        return true;
    }
}
