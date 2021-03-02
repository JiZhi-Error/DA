package com.tencent.mm.splash;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import java.util.Iterator;

public class SplashActivity extends HellActivity {
    private boolean NLX = false;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(SplashActivity splashActivity) {
        AppMethodBeat.i(40665);
        splashActivity.gys();
        AppMethodBeat.o(40665);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(40657);
        super.onCreate(bundle);
        h.a(this);
        h.c("WxSplash.SplashActivity", "onCreate", new Object[0]);
        if (!h.gyj()) {
            h.c("WxSplash.SplashActivity", "no need splash, finish", new Object[0]);
            gyt();
        }
        if (h.NLN != null) {
            h.NLN.r(this);
        }
        AppMethodBeat.o(40657);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(40658);
        super.onResume();
        h.c("WxSplash.SplashActivity", "onResume", new Object[0]);
        AppMethodBeat.o(40658);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(40659);
        h.c("WxSplash.SplashActivity", "onPause", new Object[0]);
        super.onPause();
        AppMethodBeat.o(40659);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(40660);
        h.b(this);
        h.c("WxSplash.SplashActivity", "onDestroy", new Object[0]);
        super.onDestroy();
        AppMethodBeat.o(40660);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(40661);
        if (h.NLE != null) {
            h.NLE.a(this, i2, strArr, iArr);
        }
        AppMethodBeat.o(40661);
    }

    private void gys() {
        AppMethodBeat.i(40662);
        e eVar = h.NLE;
        new Runnable() {
            /* class com.tencent.mm.splash.SplashActivity.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(40653);
                SplashActivity.c(SplashActivity.this);
                AppMethodBeat.o(40653);
            }
        };
        if (eVar.WX()) {
            gyu();
        }
        AppMethodBeat.o(40662);
    }

    public final void gyt() {
        AppMethodBeat.i(40663);
        if (h.NLE == null) {
            h.c("WxSplash.SplashActivity", "permissions delegate is null, call splash finish directly.", new Object[0]);
            gyu();
        } else if (!h.NLE.a(this, new Runnable() {
            /* class com.tencent.mm.splash.SplashActivity.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(40654);
                SplashActivity.c(SplashActivity.this);
                AppMethodBeat.o(40654);
            }
        })) {
            gys();
            AppMethodBeat.o(40663);
            return;
        }
        AppMethodBeat.o(40663);
    }

    private void gyu() {
        AppMethodBeat.i(40664);
        if (this.NLX) {
            AppMethodBeat.o(40664);
            return;
        }
        this.NLX = true;
        if (!isFinishing()) {
            setResult(-100);
            int intExtra = getIntent().getIntExtra("hashcode", 0);
            Iterator<i> it = h.NLB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i next = it.next();
                if (intExtra == next.hashCode()) {
                    h.a(next);
                    break;
                }
            }
            new Handler().postDelayed(new Runnable() {
                /* class com.tencent.mm.splash.SplashActivity.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(40655);
                    SplashActivity.this.finish();
                    SplashActivity.d(SplashActivity.this);
                    AppMethodBeat.o(40655);
                }
            }, 50);
        } else {
            onBackPressed();
        }
        new Handler().postDelayed(new Runnable() {
            /* class com.tencent.mm.splash.SplashActivity.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(40656);
                h.NLE = null;
                AppMethodBeat.o(40656);
            }
        }, 5000);
        AppMethodBeat.o(40664);
    }

    static /* synthetic */ void d(SplashActivity splashActivity) {
        AppMethodBeat.i(40666);
        splashActivity.overridePendingTransition(R.anim.f4, R.anim.f3);
        AppMethodBeat.o(40666);
    }
}
