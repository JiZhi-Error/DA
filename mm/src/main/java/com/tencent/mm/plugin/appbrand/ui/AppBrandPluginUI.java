package com.tencent.mm.plugin.appbrand.ui;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.af.e;
import com.tencent.mm.plugin.appbrand.af.g;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;

@a(1)
public class AppBrandPluginUI extends AppBrandUI {
    @Override // com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48674);
        super.onCreate(bundle);
        AppMethodBeat.o(48674);
    }

    @Override // android.support.v7.app.AppCompatActivity
    public void onPostCreate(Bundle bundle) {
        AppMethodBeat.i(227627);
        super.onPostCreate(bundle);
        bXj();
        AppMethodBeat.o(227627);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(48675);
        super.onResume();
        bXj();
        AppMethodBeat.o(48675);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(48676);
        super.onPause();
        if (bXk()) {
            f.e(false, true, true);
        }
        AppMethodBeat.o(48676);
    }

    private void bXj() {
        AppMethodBeat.i(227628);
        if (bXk()) {
            y.a(getWindow(), true, false);
            f.e(true, true, true);
            b.a(this, null);
        }
        AppMethodBeat.o(227628);
    }

    private boolean bXk() {
        AppMethodBeat.i(48677);
        boolean an = g.an(this.mRuntimeContainer == null ? null : this.mRuntimeContainer.getActiveRuntime());
        AppMethodBeat.o(48677);
        return an;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandUI
    public void onEnterAnimationComplete() {
        AppBrandRuntime appBrandRuntime = null;
        AppMethodBeat.i(48678);
        super.onEnterAnimationComplete();
        if (bXl()) {
            if (this.mRuntimeContainer != null) {
                appBrandRuntime = this.mRuntimeContainer.getActiveRuntime();
            }
            if (appBrandRuntime != null) {
                appBrandRuntime.gs(false);
            }
            AppMethodBeat.o(48678);
            return;
        }
        Log.i("MicroMsg.AppBrandPluginUI", "onEnterAnimationComplete convert PluginUI to translucent");
        b.a(this, null);
        Log.i("MicroMsg.AppBrandPluginUI", "onEnter convertActivityToTranslucent");
        AppMethodBeat.o(48678);
    }

    private boolean bXl() {
        AppMethodBeat.i(162169);
        if (bXk()) {
            AppMethodBeat.o(162169);
            return false;
        }
        AppBrandRuntime activeRuntime = this.mRuntimeContainer == null ? null : this.mRuntimeContainer.getActiveRuntime();
        if (!(activeRuntime instanceof q) || !((q) activeRuntime).bsC().kHM) {
            try {
                ActivityManager.RunningTaskInfo currentTaskInfo = Util.getCurrentTaskInfo(this, getTaskId());
                if (!(currentTaskInfo == null || currentTaskInfo.baseActivity == null)) {
                    if (currentTaskInfo.baseActivity.equals(getComponentName())) {
                        Log.i("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return true, task.baseActivity=self, keep PluginUI opaque");
                        AppMethodBeat.o(162169);
                        return true;
                    }
                    String[] strArr = {"WXBizEntryActivity", "AppBrandLaunchProxyUI"};
                    for (int i2 = 0; i2 < 2; i2++) {
                        String str = strArr[i2];
                        if (currentTaskInfo.baseActivity.getShortClassName().endsWith(str)) {
                            Log.i("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return true, task.baseActivity=[%s], keep PluginUI opaque", str);
                            AppMethodBeat.o(162169);
                            return true;
                        }
                    }
                }
                Object[] objArr = new Object[1];
                objArr[0] = (currentTaskInfo == null || currentTaskInfo.baseActivity == null) ? BuildConfig.COMMAND : currentTaskInfo.baseActivity.getShortClassName();
                Log.i("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return false, task.baseActivity=[%s]", objArr);
                AppMethodBeat.o(162169);
                return false;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandPluginUI", "shouldKeepPluginUIOpaque return false, get e=%s", e2);
                AppMethodBeat.o(162169);
                return false;
            }
        } else {
            AppMethodBeat.o(162169);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandUI
    public final void h(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(48679);
        if (m.a(this, appBrandInitConfigWC, appBrandStatObject)) {
            b.a(this, null);
            Log.i("MicroMsg.AppBrandPluginUI", "init convertActivityToTranslucent");
            AppMethodBeat.o(48679);
            return;
        }
        AppBrandInitConfigWC bsC = bsC();
        if (com.tencent.mm.plugin.appbrand.utils.b.afF(this.ldT)) {
            super.overridePendingTransition(0, 0);
            AppMethodBeat.o(48679);
        } else if (bXk()) {
            e.b(this, appBrandInitConfigWC);
            AppMethodBeat.o(48679);
        } else if (appBrandInitConfigWC.kHL.isEnable()) {
            if (appBrandInitConfigWC.kHL.lfn == HalfScreenConfig.a.POPUP) {
                overridePendingTransition(R.anim.ae, 0);
                AppMethodBeat.o(48679);
                return;
            }
            super.overridePendingTransition(this.ogk.ogm, 0);
            AppMethodBeat.o(48679);
        } else if (bsC != null && bsC.leg) {
            super.h(appBrandInitConfigWC, appBrandStatObject);
            AppMethodBeat.o(48679);
        } else if (!bsC.lei || bsC.ldN) {
            super.overridePendingTransition(this.ogk.ogm, this.ogk.ogn);
            AppMethodBeat.o(48679);
        } else {
            super.h(appBrandInitConfigWC, appBrandStatObject);
            AppMethodBeat.o(48679);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandUI
    public final void M(Intent intent) {
        AppMethodBeat.i(48680);
        try {
            AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) intent.getParcelableExtra("key_appbrand_init_config");
            AppBrandStatObject appBrandStatObject = (AppBrandStatObject) intent.getParcelableExtra("key_appbrand_stat_object");
            if (appBrandInitConfigWC == null || appBrandStatObject == null) {
                AppMethodBeat.o(48680);
                return;
            }
            h(appBrandInitConfigWC, appBrandStatObject);
            AppMethodBeat.o(48680);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandPluginUI", e2, "resumeAnim caught exception", new Object[0]);
            AppMethodBeat.o(48680);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandUI, com.tencent.mm.ui.MMFragmentActivity
    public void initActivityCloseAnimation() {
        AppMethodBeat.i(48681);
        HalfScreenConfig bZi = bZi();
        if (bZi == null || !bZi.isEnable()) {
            AppBrandInitConfigWC bsC = bsC();
            if (bsC != null && bsC.leg) {
                overridePendingTransition(R.anim.ab, R.anim.ac);
                AppMethodBeat.o(48681);
            } else if (!bsC.lei || bsC.ldN) {
                super.overridePendingTransition(this.ogk.ogo, this.ogk.ogp);
                AppMethodBeat.o(48681);
            } else {
                overridePendingTransition(R.anim.ab, R.anim.ac);
                AppMethodBeat.o(48681);
            }
        } else if (bZi.lfn == HalfScreenConfig.a.POPUP || bZi.lfq.lfD == HalfScreenConfig.a.POPUP) {
            overridePendingTransition(0, R.anim.ac);
            AppMethodBeat.o(48681);
        } else {
            super.overridePendingTransition(0, this.ogk.ogp);
            AppMethodBeat.o(48681);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandUI
    public final void N(Intent intent) {
        AppMethodBeat.i(48683);
        super.N(intent);
        AppBrandRuntime activeRuntime = this.mRuntimeContainer == null ? null : this.mRuntimeContainer.getActiveRuntime();
        if (activeRuntime != null && (AppBrandRuntimeWCAccessible.D(activeRuntime) || ((AppBrandInitConfigWC) activeRuntime.OU()).kHL.isEnable())) {
            activeRuntime.gs(true);
            activeRuntime.kAM = new ap() {
                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.ap
                public final void vC(int i2) {
                    AppMethodBeat.i(48673);
                    if (1 == i2) {
                        Log.i("MicroMsg.AppBrandPluginUI", "load convertActivityToTranslucent");
                        b.a(AppBrandPluginUI.this, null);
                    }
                    AppMethodBeat.o(48673);
                }
            };
        }
        AppMethodBeat.o(48683);
    }
}
