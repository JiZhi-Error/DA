package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.support.v4.view.u;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;

public final class r implements ah {
    static /* synthetic */ void b(AppBrandRuntime appBrandRuntime, int i2, Runnable runnable) {
        AppMethodBeat.i(48870);
        a(appBrandRuntime, i2, runnable);
        AppMethodBeat.o(48870);
    }

    private static int b(AppBrandStatObject appBrandStatObject) {
        if (appBrandStatObject == null) {
            return 0;
        }
        return appBrandStatObject.scene;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b7  */
    @Override // com.tencent.mm.plugin.appbrand.ui.ah
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r9, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig r10) {
        /*
        // Method dump skipped, instructions count: 244
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.r.a(android.app.Activity, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ah
    public final void m(Activity activity) {
        AppMethodBeat.i(48865);
        if (activity == null) {
            AppMethodBeat.o(48865);
            return;
        }
        Class[] clsArr = {AppBrandPluginUI.class};
        for (int i2 = 0; i2 <= 0; i2++) {
            if (clsArr[0].isInstance(activity)) {
                AppMethodBeat.o(48865);
                return;
            }
        }
        if (ao.gJN()) {
            activity.overridePendingTransition(0, R.anim.ac);
            AppMethodBeat.o(48865);
            return;
        }
        activity.overridePendingTransition(R.anim.ab, R.anim.ac);
        AppMethodBeat.o(48865);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ah
    public final void a(final AppBrandRuntime appBrandRuntime, final Runnable runnable, AppBrandRuntime appBrandRuntime2) {
        AppMethodBeat.i(227699);
        if (appBrandRuntime == null) {
            AppMethodBeat.o(227699);
            return;
        }
        a(appBrandRuntime, am(appBrandRuntime) ? MMFragmentActivity.a.ogm : R.anim.ae, new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.r.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(48861);
                if (appBrandRuntime instanceof q) {
                    ((q) appBrandRuntime).onEnterAnimationComplete();
                }
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(48861);
            }
        });
        if (appBrandRuntime2 != null) {
            a(appBrandRuntime2, am(appBrandRuntime) ? MMFragmentActivity.a.ogn : R.anim.s, (Runnable) null);
        }
        AppMethodBeat.o(227699);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.ah
    public final void a(AppBrandRuntime appBrandRuntime, AppBrandRuntime appBrandRuntime2, Runnable runnable) {
        AppMethodBeat.i(48867);
        if (appBrandRuntime2 == null) {
            AppMethodBeat.o(48867);
            return;
        }
        a(appBrandRuntime2, am(appBrandRuntime2) ? MMFragmentActivity.a.ogp : R.anim.ac, runnable);
        if (appBrandRuntime != null) {
            a(appBrandRuntime, am(appBrandRuntime2) ? MMFragmentActivity.a.ogo : R.anim.s, (Runnable) null);
        }
        AppMethodBeat.o(48867);
    }

    public static boolean am(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(48869);
        if (appBrandRuntime instanceof q) {
            q qVar = (q) appBrandRuntime;
            if (qVar.bsr() || qVar.ON().cyA.scene == 1099) {
                AppMethodBeat.o(48869);
                return true;
            }
            AppMethodBeat.o(48869);
            return false;
        }
        AppMethodBeat.o(48869);
        return false;
    }

    private static void a(final AppBrandRuntime appBrandRuntime, final int i2, final Runnable runnable) {
        AppMethodBeat.i(48868);
        if (!u.az(appBrandRuntime.kAt)) {
            appBrandRuntime.kAt.setWillNotDraw(true);
            appBrandRuntime.kAt.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.r.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(175084);
                    r.b(appBrandRuntime, i2, runnable);
                    AppMethodBeat.o(175084);
                }
            });
            AppMethodBeat.o(48868);
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), i2);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.r.AnonymousClass3 */

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(175085);
                if (runnable != null) {
                    MMHandlerThread.postToMainThread(runnable);
                }
                AppMethodBeat.o(175085);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(175086);
                appBrandRuntime.kAt.setWillNotDraw(false);
                AppMethodBeat.o(175086);
            }
        });
        appBrandRuntime.kAt.startAnimation(loadAnimation);
        AppMethodBeat.o(48868);
    }
}
