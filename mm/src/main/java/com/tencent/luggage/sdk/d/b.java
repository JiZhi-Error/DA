package com.tencent.luggage.sdk.d;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.platform.window.a.c;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.k;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public class b extends AppBrandRuntimeContainer<d> {
    static /* synthetic */ AppBrandRuntime a(b bVar, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(169450);
        AppBrandRuntime e2 = bVar.e(appBrandInitConfig);
        AppMethodBeat.o(169450);
        return e2;
    }

    static /* synthetic */ void a(b bVar, AppBrandRuntime appBrandRuntime, AppBrandRuntime appBrandRuntime2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(169452);
        bVar.a(appBrandRuntime, appBrandRuntime2, appBrandInitConfig);
        AppMethodBeat.o(169452);
    }

    static /* synthetic */ void a(b bVar, AppBrandRuntime appBrandRuntime, AppBrandRuntime appBrandRuntime2, Runnable runnable) {
        AppMethodBeat.i(169455);
        super.b(appBrandRuntime, appBrandRuntime2, runnable);
        AppMethodBeat.o(169455);
    }

    static /* synthetic */ void a(b bVar, AppBrandRuntime appBrandRuntime, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(169453);
        bVar.b((AppBrandRuntime) null, appBrandRuntime, appBrandInitConfig);
        AppMethodBeat.o(169453);
    }

    static /* synthetic */ void a(b bVar, String str) {
        AppMethodBeat.i(229870);
        bVar.Ui(str);
        AppMethodBeat.o(229870);
    }

    static /* synthetic */ AppBrandRuntime b(b bVar, String str) {
        AppMethodBeat.i(169449);
        AppBrandRuntime Uh = bVar.Uh(str);
        AppMethodBeat.o(169449);
        return Uh;
    }

    static /* synthetic */ void b(b bVar, AppBrandRuntime appBrandRuntime, AppBrandRuntime appBrandRuntime2, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(169454);
        bVar.b(appBrandRuntime, appBrandRuntime2, appBrandInitConfig);
        AppMethodBeat.o(169454);
    }

    public b(k kVar, Class<? extends d> cls) {
        super(kVar, cls);
        AppMethodBeat.i(146890);
        AppMethodBeat.o(146890);
    }

    public final void a(final d dVar, final AppBrandInitConfigLU appBrandInitConfigLU, final AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(146891);
        if (appBrandInitConfigLU == null || appBrandStatObject == null) {
            AppMethodBeat.o(146891);
            return;
        }
        AndroidContextUtil.castActivityOrNull(this.mContext).runOnUiThread(new Runnable() {
            /* class com.tencent.luggage.sdk.d.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(169444);
                n.J(AndroidContextUtil.castActivityOrNull(b.this.mContext));
                if (dVar == null) {
                    b.a(b.this, appBrandInitConfigLU.appId);
                }
                d dVar = (d) b.b(b.this, appBrandInitConfigLU.appId);
                appBrandInitConfigLU.cyA = appBrandStatObject;
                if (dVar == null) {
                    dVar = (d) b.a(b.this, appBrandInitConfigLU);
                    b.a(b.this, dVar);
                    b.a(b.this, dVar, dVar, appBrandInitConfigLU);
                } else if (dVar == dVar) {
                    b.a(b.this, dVar, appBrandInitConfigLU);
                    b.this.onResume();
                } else {
                    b.b(b.this, dVar, dVar, appBrandInitConfigLU);
                }
                if (b.this.v(dVar)) {
                    if (dVar.brg() != null) {
                        dVar.gs(true);
                        AppMethodBeat.o(169444);
                        return;
                    }
                    dVar.gs(false);
                }
                AppMethodBeat.o(169444);
            }
        });
        AppMethodBeat.o(146891);
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
    public void b(final AppBrandRuntime appBrandRuntime, final AppBrandRuntime appBrandRuntime2, final Runnable runnable) {
        String str;
        AppMethodBeat.i(146893);
        Object[] objArr = new Object[6];
        if (appBrandRuntime == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = appBrandRuntime.mAppId;
        }
        objArr[0] = str;
        objArr[1] = appBrandRuntime2.mAppId;
        objArr[2] = Boolean.valueOf(appBrandRuntime2.SO);
        objArr[3] = Boolean.valueOf(appBrandRuntime2.brG());
        objArr[4] = Boolean.valueOf(this.kCg);
        objArr[5] = Integer.valueOf(getStackSize());
        Log.i("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "onRuntimeClose entered, in.appId[%s], out.appId[%s], out.isFinishing[%b], out.canDoCloseAnimation[%b], mIsActivityPaused[%b], stackSize[%d]", objArr);
        AnonymousClass4 r1 = new Runnable() {
            /* class com.tencent.luggage.sdk.d.b.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(169447);
                b.a(b.this, appBrandRuntime, appBrandRuntime2, runnable);
                AppMethodBeat.o(169447);
            }
        };
        if (this.kCg) {
            appBrandRuntime2.kAO = false;
        }
        if (!appBrandRuntime2.SO) {
            if (getStackSize() <= 1) {
                bY(true);
                AppMethodBeat.o(146893);
            } else if (appBrandRuntime2.brG()) {
                ((ah) e.M(ah.class)).a(appBrandRuntime, appBrandRuntime2, r1);
                AppMethodBeat.o(146893);
            } else {
                r1.run();
                AppMethodBeat.o(146893);
            }
        } else if (!v(appBrandRuntime2)) {
            r1.run();
            AppMethodBeat.o(146893);
        } else if (getStackSize() <= 1) {
            bY(false);
            AppMethodBeat.o(146893);
        } else if (appBrandRuntime2.brG()) {
            ((ah) e.M(ah.class)).a(appBrandRuntime, appBrandRuntime2, r1);
            AppMethodBeat.o(146893);
        } else {
            r1.run();
            AppMethodBeat.o(146893);
        }
    }

    public boolean OH() {
        AppMethodBeat.i(146894);
        if (getStackSize() <= 0) {
            bY(false);
            AppMethodBeat.o(146894);
            return true;
        }
        AppMethodBeat.o(146894);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer
    public final void onBackPressed() {
        AppMethodBeat.i(146895);
        if (OH()) {
            AppMethodBeat.o(146895);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(146895);
    }

    /* access modifiers changed from: protected */
    public void bY(boolean z) {
        AppMethodBeat.i(146892);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
        if (castActivityOrNull == null) {
            AppMethodBeat.o(146892);
            return;
        }
        if (!castActivityOrNull.isFinishing()) {
            boolean bsc = this.kCd.bsc();
            int stackSize = getStackSize();
            if (!bsc || !z) {
                castActivityOrNull.finish();
            } else {
                castActivityOrNull.moveTaskToBack(true);
            }
            if (stackSize <= 0) {
                castActivityOrNull.overridePendingTransition(0, 0);
                AppMethodBeat.o(146892);
                return;
            }
            ((ah) e.M(ah.class)).m(castActivityOrNull);
        }
        AppMethodBeat.o(146892);
    }

    static /* synthetic */ void a(b bVar, d dVar) {
        AppMethodBeat.i(169451);
        if (dVar == null || dVar.ON() == null) {
            AppMethodBeat.o(169451);
        } else if (dVar.brL()) {
            AppBrandInitConfigLU ON = dVar.ON();
            Activity activity = bVar.kCd.getActivity();
            if (activity == null || activity.isFinishing()) {
                AppMethodBeat.o(169451);
                return;
            }
            c bTY = bVar.bTY();
            if (bTY == null) {
                Log.e("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithSplashAd, appId:%s, orientation:%s, NULL orientationHandler", ON.appId, ON.cBG);
                AppMethodBeat.o(169451);
                return;
            }
            final String str = ON.appId;
            Log.i("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithSplashAd, appId:%s, config.Orientation:%s", ON.appId, ON.cBG);
            bTY.a(e.b.PORTRAIT, new e.a() {
                /* class com.tencent.luggage.sdk.d.b.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.platform.window.e.a
                public final void a(e.b bVar, boolean z) {
                    AppMethodBeat.i(169445);
                    Log.i("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithSplashAd, onOrientationChanged, appId[%s] orientation[%s] success[%b]", str, bVar, Boolean.valueOf(z));
                    AppMethodBeat.o(169445);
                }
            });
            AppMethodBeat.o(169451);
        } else {
            AppBrandInitConfigLU ON2 = dVar.ON();
            if (TextUtils.isEmpty(ON2.cBG) || !ON2.NA()) {
                AppMethodBeat.o(169451);
                return;
            }
            c bTY2 = bVar.bTY();
            if (bTY2 == null) {
                Log.e("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithoutAd appId[%s] orientation[%s], NULL orientationHandler", ON2.appId, ON2.cBG);
                AppMethodBeat.o(169451);
                return;
            }
            final String str2 = ON2.appId;
            Log.i("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithoutAd, appId:%s, config.Orientation:%s", ON2.appId, ON2.cBG);
            bTY2.a(e.b.h(ON2), new e.a() {
                /* class com.tencent.luggage.sdk.d.b.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.platform.window.e.a
                public final void a(e.b bVar, boolean z) {
                    AppMethodBeat.i(169446);
                    Log.i("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "tryRequestOrientationWithoutAd, onOrientationChanged, appId[%s] orientation[%s] success[%b]", str2, bVar, Boolean.valueOf(z));
                    AppMethodBeat.o(169446);
                }
            });
            AppMethodBeat.o(169451);
        }
    }
}
