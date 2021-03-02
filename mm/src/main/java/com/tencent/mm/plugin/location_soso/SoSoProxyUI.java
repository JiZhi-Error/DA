package com.tencent.mm.plugin.location_soso;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.tencentmap.mapsdk.map.MapActivity;

@a(19)
public class SoSoProxyUI extends MapActivity {
    protected static final String TAG = "MicroMsg.SoSoProxyUI";
    private com.tencent.mm.plugin.k.a basemapUI;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.tencentmap.mapsdk.map.MapActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.tencentmap.mapsdk.map.MapActivity
    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(56229);
        Log.i(TAG, "SoSoProxyUI onCreate");
        int intExtra = getIntent().getIntExtra("intent_map_key", -1);
        if (intExtra == 2) {
            requestWindowFeature(1);
        }
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        if (c.a.yOs == null) {
            try {
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(CrashReportFactory.foreground);
                if (bundle == null) {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = getClass().getSimpleName();
                objArr[3] = Integer.valueOf(hashCode());
                Log.e(TAG, "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]", objArr);
                finish();
            } catch (Throwable th) {
                Log.printErrStackTrace(TAG, th, "summerasyncinit finish:", new Object[0]);
            }
            h.INSTANCE.idkeyStat(598, 20, 1, false);
            AppMethodBeat.o(56229);
            return;
        }
        this.basemapUI = c.a.yOs.h(this, intExtra);
        if (this.basemapUI == null) {
            finish();
            AppMethodBeat.o(56229);
            return;
        }
        this.basemapUI.onCreate(bundle);
        AppMethodBeat.o(56229);
    }

    public void onBackPressed() {
        AppMethodBeat.i(56230);
        this.basemapUI.onBackPressed();
        AppMethodBeat.o(56230);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        AppMethodBeat.i(201734);
        super.setContentView(view);
        Log.d(TAG, "setContentView1 %s", Util.getStack());
        AppMethodBeat.o(201734);
    }

    @Override // android.app.Activity
    public void setContentView(int i2) {
        AppMethodBeat.i(201735);
        super.setContentView(i2);
        Log.d(TAG, "setContentView2 %s", Util.getStack());
        AppMethodBeat.o(201735);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(201736);
        super.setContentView(view, layoutParams);
        Log.d(TAG, "setContentView3 %s", Util.getStack());
        AppMethodBeat.o(201736);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(56231);
        if (this.basemapUI.dispatchTouchEvent(motionEvent)) {
            AppMethodBeat.o(56231);
            return true;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(56231);
        return dispatchTouchEvent;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(56232);
        if (this.basemapUI.dispatchKeyEvent(keyEvent)) {
            AppMethodBeat.o(56232);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(56232);
        return dispatchKeyEvent;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(56233);
        if (i2 == 82 && keyEvent.getAction() == 1) {
            this.basemapUI.edH();
            AppMethodBeat.o(56233);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(56233);
        return onKeyUp;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.tencentmap.mapsdk.map.MapActivity
    public void onResume() {
        AppMethodBeat.i(56234);
        super.onResume();
        this.basemapUI.onResume();
        AppMethodBeat.o(56234);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.tencentmap.mapsdk.map.MapActivity
    public void onPause() {
        AppMethodBeat.i(56235);
        super.onPause();
        this.basemapUI.onPause();
        AppMethodBeat.o(56235);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.tencentmap.mapsdk.map.MapActivity
    public void onDestroy() {
        AppMethodBeat.i(56236);
        if (this.basemapUI != null) {
            this.basemapUI.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(56236);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(56237);
        this.basemapUI.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(56237);
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.app.Activity
    public Object getSystemService(String str) {
        AppMethodBeat.i(56238);
        Object systemService = super.getSystemService(str);
        if (getAssets() == null || !"layout_inflater".equals(str)) {
            AppMethodBeat.o(56238);
            return systemService;
        }
        LayoutInflater b2 = aa.b((LayoutInflater) systemService);
        AppMethodBeat.o(56238);
        return b2;
    }

    public Resources getResources() {
        AppMethodBeat.i(56239);
        if (getAssets() == null || MMApplicationContext.getResources() == null) {
            Resources resources = super.getResources();
            AppMethodBeat.o(56239);
            return resources;
        }
        Resources resources2 = MMApplicationContext.getResources();
        AppMethodBeat.o(56239);
        return resources2;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(56240);
        super.finish();
        AppMethodBeat.o(56240);
    }
}
