package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.plugin.appbrand.report.quality.o;
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends a implements g {
    int lvW = 0;
    private Intent mIntent;
    private LaunchParcel mYY;

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.launching.e.a
    public final boolean d(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        Class<?> cls;
        AppMethodBeat.i(47438);
        try {
            cls = Class.forName(Util.nullAsNil(this.mIntent.getStringExtra("extra_launch_source_context")));
        } catch (Exception e2) {
            cls = null;
        }
        if (cls == null || !AppBrandUI.class.isAssignableFrom(cls)) {
            boolean d2 = super.d(appBrandInitConfigWC, appBrandStatObject);
            AppMethodBeat.o(47438);
            return d2;
        }
        AppMethodBeat.o(47438);
        return false;
    }

    public c(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        AppMethodBeat.i(47439);
        setBaseContext(appBrandLaunchProxyUI);
        this.mYV = false;
        AppMethodBeat.o(47439);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void H(Intent intent) {
        AppMethodBeat.i(47440);
        if (getBaseContext() != null && (getBaseContext() instanceof Activity)) {
            Activity activity = (Activity) getBaseContext();
            y.e(activity.getWindow());
            y.d(activity.getWindow(), true);
        }
        this.mIntent = intent;
        LaunchParcel launchParcel = (LaunchParcel) intent.getParcelableExtra("extra_launch_parcel");
        if (launchParcel == null) {
            finish();
            AppMethodBeat.o(47440);
            return;
        }
        this.mYY = launchParcel;
        String str = launchParcel.appId;
        if (Util.isNullOrNil(str)) {
            str = h.a(launchParcel);
        }
        String c2 = g.c(launchParcel, str);
        g.a(launchParcel, c2, str);
        w wVar = w.nHZ;
        w.b(launchParcel, c2);
        if (o.bVk()) {
            o oVar = o.nMe;
            o.eI(str, c2);
            com.tencent.mm.plugin.appbrand.keylogger.c.e(KSProcessWeAppLaunch.class, str);
            com.tencent.mm.plugin.appbrand.keylogger.c.a(KSProcessWeAppLaunch.class, str, String.format("Network:%s", NetStatusUtil.getNetTypeString(this)));
        }
        a(launchParcel, c2);
        AppMethodBeat.o(47440);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void onResume() {
        AppMethodBeat.i(47441);
        int i2 = this.lvW + 1;
        this.lvW = i2;
        if (i2 > 1) {
            bOj();
        }
        AppMethodBeat.o(47441);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void onPause() {
        AppMethodBeat.i(47442);
        bOj();
        AppMethodBeat.o(47442);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final void onDestroy() {
        AppMethodBeat.i(47443);
        super.bOc();
        AppMethodBeat.o(47443);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.e.g
    public final boolean bOi() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.launching.e.a
    public final void c(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(47444);
        if (!(this.mYY == null || this.mYY.mYO == null)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("KEY_PRECONDITION_RESULT", appBrandInitConfigWC);
            this.mYY.mYO.b(bundle);
        }
        if (appBrandInitConfigWC != null) {
            appBrandInitConfigWC.ldP = this.mIntent.getStringExtra("extra_launch_source_process_name");
        }
        super.c(appBrandInitConfigWC, appBrandStatObject);
        AppMethodBeat.o(47444);
    }

    private void bOj() {
        AppMethodBeat.i(47445);
        if (isFinishing() || bOh()) {
            AppMethodBeat.o(47445);
            return;
        }
        super.bOe();
        AppMethodBeat.o(47445);
    }
}
