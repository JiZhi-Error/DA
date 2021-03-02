package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.af.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.e.e;
import com.tencent.mm.plugin.appbrand.launching.e.g;
import com.tencent.mm.plugin.appbrand.loading.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.statusbar.c;

@i
@a(7)
public final class AppBrandLaunchProxyUI extends MMSecDataFragmentActivity implements ab, c.a {
    private IListener<f> lEE = new IListener<f>() {
        /* class com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI.AnonymousClass2 */

        {
            AppMethodBeat.i(174929);
            this.__eventId = f.class.getName().hashCode();
            AppMethodBeat.o(174929);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(f fVar) {
            AppMethodBeat.i(174930);
            if (fVar != null) {
                Log.i("MicroMsg.AppBrandLaunchProxyUI", "[weishi] video play, close launch proxy ui");
                AppBrandLaunchProxyUI.this.finish();
            }
            AppMethodBeat.o(174930);
            return false;
        }
    };
    private g mQn;
    private View mQo;
    public final MMHandler mQp = new MMHandler(Looper.getMainLooper());
    public final Runnable mQq = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160601);
            AppMethodBeat.o(160601);
        }

        public final void run() {
            AppMethodBeat.i(174928);
            if (!AppBrandLaunchProxyUI.this.isDestroyed() && !AppBrandLaunchProxyUI.this.isFinishing() && AppBrandLaunchProxyUI.this.mQn != null && AppBrandLaunchProxyUI.this.mQn.bOi()) {
                try {
                    if (AppBrandLaunchProxyUI.this.mQo == null) {
                        View inflate = View.inflate(AppBrandLaunchProxyUI.this, R.layout.ba5, null);
                        ((FrameLayout) AppBrandLaunchProxyUI.this.findViewById(16908290)).addView(inflate, new FrameLayout.LayoutParams(-2, -2, 17));
                        ((TextView) inflate.findViewById(R.id.fgd)).setText(R.string.ekc);
                        AppBrandLaunchProxyUI.this.mQo = inflate;
                    } else {
                        AppBrandLaunchProxyUI.this.mQo.setVisibility(0);
                    }
                    AppBrandLaunchProxyUI.this.yf(AppBrandLaunchProxyUI.this.mQr);
                    AppMethodBeat.o(174928);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandLaunchProxyUI", "attach dialog View e=%s", e2);
                }
            }
            AppMethodBeat.o(174928);
        }
    };
    private int mQr = 0;
    private MMActivity.a onActResult = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandLaunchProxyUI() {
        AppMethodBeat.i(47052);
        AppMethodBeat.o(47052);
    }

    public static boolean G(Intent intent) {
        AppMethodBeat.i(47053);
        if (intent != null) {
            try {
                if (intent.getComponent() != null && intent.getComponent().getShortClassName().equals(".plugin.appbrand.launching.AppBrandLaunchProxyUI")) {
                    AppMethodBeat.o(47053);
                    return true;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(47053);
                return false;
            }
        }
        AppMethodBeat.o(47053);
        return false;
    }

    public static void a(Context context, String str, String str2, int i2, int i3, AppBrandStatObject appBrandStatObject, LaunchParamsOptional launchParamsOptional) {
        AppMethodBeat.i(227051);
        a(context, str, null, str2, i2, i3, appBrandStatObject, null, launchParamsOptional);
        AppMethodBeat.o(227051);
    }

    public static boolean a(Context context, String str, String str2, String str3, int i2, int i3, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        AppMethodBeat.i(47055);
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
            boolean a2 = com.tencent.mm.plugin.appbrand.launching.e.f.mZp.a(context, str, str2, str3, i2, i3, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
            AppMethodBeat.o(47055);
            return a2;
        }
        AppMethodBeat.o(47055);
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean isSupportNavigationSwipeBack() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean isNfcFilterEnabled() {
        return false;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        g eVar;
        AppMethodBeat.i(47056);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(47056);
            return;
        }
        setRequestedOrientation(-1);
        int intExtra = getIntent().getIntExtra("key_from_activity_requested_orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
        try {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getIntent().getParcelableExtra("extra_from_activity_window_attributes");
            if (layoutParams != null) {
                getWindow().setAttributes(layoutParams);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (getIntent().hasExtra("extra_from_activity_status_bar_color")) {
                    getWindow().setStatusBarColor(getIntent().getIntExtra("extra_from_activity_status_bar_color", 0));
                }
                if (getIntent().hasExtra("extra_from_activity_navigation_bar_color")) {
                    getWindow().setNavigationBarColor(getIntent().getIntExtra("extra_from_activity_navigation_bar_color", 0));
                }
            }
            ao.jV(this);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } catch (Exception e2) {
        }
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("extra_from_mm", true)) {
            eVar = new com.tencent.mm.plugin.appbrand.launching.e.c(this);
        } else if (intent.getBooleanExtra("extra_launch_weishi_video", false)) {
            eVar = new com.tencent.mm.plugin.appbrand.af.a(this);
        } else {
            eVar = new e(this);
        }
        this.mQn = eVar;
        if (this.mQn != null) {
            Log.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, uiDelegate %s", this.mQn.getClass().getSimpleName());
            this.mQn.H(getIntent());
            if (!isFinishing() && this.mQn.bOi()) {
                this.mQp.postDelayed(this.mQq, 500);
            }
            this.lEE.alive();
            AppMethodBeat.o(47056);
            return;
        }
        finish();
        AppMethodBeat.o(47056);
    }

    @Override // com.tencent.mm.ui.statusbar.c.a
    public final void yf(int i2) {
        AppMethodBeat.i(47057);
        if (isFinishing() || isDestroyed()) {
            AppMethodBeat.o(47057);
            return;
        }
        this.mQr = i2;
        if (this.mQo != null && (this.mQo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.mQo.getLayoutParams()).topMargin = i2;
            this.mQo.requestLayout();
        }
        AppMethodBeat.o(47057);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(47058);
        super.onResume();
        Log.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI onResume");
        if (this.mQn != null) {
            this.mQn.onResume();
            AppMethodBeat.o(47058);
            return;
        }
        super.finish();
        AppMethodBeat.o(47058);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(47059);
        super.onPause();
        Log.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI onPause");
        if (this.mQn != null) {
            this.mQn.onPause();
            AppMethodBeat.o(47059);
            return;
        }
        super.finish();
        AppMethodBeat.o(47059);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(47060);
        super.onDestroy();
        Log.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI onDestroy");
        this.mQp.removeCallbacksAndMessages(null);
        if (this.mQn != null) {
            this.mQn.onDestroy();
            if (this.mQn.bOi()) {
                try {
                    findViewById(16908290).setVisibility(4);
                } catch (NullPointerException e2) {
                }
            }
        }
        if (this.lEE != null) {
            this.lEE.dead();
        }
        a.C0745a aVar = com.tencent.mm.plugin.appbrand.loading.a.mZQ;
        ServiceConnection bOu = com.tencent.mm.plugin.appbrand.loading.a.bOu();
        if (bOu != null) {
            try {
                unbindService(bOu);
                a.C0745a aVar2 = com.tencent.mm.plugin.appbrand.loading.a.mZQ;
                com.tencent.mm.plugin.appbrand.loading.a.a((ServiceConnection) null);
                Log.i("MicroMsg.AppBrandLaunchProxyUI", "onDestroy: unbindService");
                AppMethodBeat.o(47060);
                return;
            } catch (Exception e3) {
                Log.d("MicroMsg.AppBrandLaunchProxyUI", "onDestroy: ", e3);
            }
        }
        AppMethodBeat.o(47060);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(47061);
        if (isFinishing()) {
            AppMethodBeat.o(47061);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(47061);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(47062);
        finish();
        AppMethodBeat.o(47062);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(47063);
        if (isFinishing() || isDestroyed()) {
            Log.w("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI finish() already finishing");
            AppMethodBeat.o(47063);
            return;
        }
        super.finish();
        Log.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI finish");
        AppMethodBeat.o(47063);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ab
    public final void a(MMActivity.a aVar, Intent intent, int i2) {
        AppMethodBeat.i(47064);
        this.onActResult = aVar;
        startActivityForResult(intent, i2);
        AppMethodBeat.o(47064);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(47065);
        super.onActivityResult(i2, i3, intent);
        if (this.onActResult != null) {
            this.onActResult.d(i2, i3, intent);
        }
        this.onActResult = null;
        AppMethodBeat.o(47065);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ab
    public final boolean bNd() {
        AppMethodBeat.i(47066);
        if (!isFinishing()) {
            AppMethodBeat.o(47066);
            return true;
        }
        AppMethodBeat.o(47066);
        return false;
    }
}
