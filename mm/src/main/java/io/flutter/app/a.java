package io.flutter.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVExporter;
import io.flutter.a.b;
import io.flutter.plugin.a.m;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import java.util.ArrayList;

public final class a implements b, m, FlutterView.b {
    private static final WindowManager.LayoutParams SLX = new WindowManager.LayoutParams(-1, -1);
    private final AbstractC2242a SLY;
    private FlutterView SLZ;
    private View SMa;
    private final Activity activity;

    /* renamed from: io.flutter.app.a$a  reason: collision with other inner class name */
    public interface AbstractC2242a {
    }

    static {
        AppMethodBeat.i(9669);
        AppMethodBeat.o(9669);
    }

    public a(Activity activity2, AbstractC2242a aVar) {
        AppMethodBeat.i(9648);
        this.activity = (Activity) b.checkNotNull(activity2);
        this.SLY = (AbstractC2242a) b.checkNotNull(aVar);
        AppMethodBeat.o(9648);
    }

    @Override // io.flutter.plugin.a.m
    public final boolean bsW(String str) {
        AppMethodBeat.i(9649);
        boolean bsW = this.SLZ.getPluginRegistry().bsW(str);
        AppMethodBeat.o(9649);
        return bsW;
    }

    @Override // io.flutter.plugin.a.m
    public final m.c bsX(String str) {
        AppMethodBeat.i(9650);
        m.c bsX = this.SLZ.getPluginRegistry().bsX(str);
        AppMethodBeat.o(9650);
        return bsX;
    }

    @Override // io.flutter.plugin.a.m.d
    public final boolean a(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(9651);
        boolean a2 = this.SLZ.getPluginRegistry().a(i2, strArr, iArr);
        AppMethodBeat.o(9651);
        return a2;
    }

    @Override // io.flutter.plugin.a.m.a
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(9652);
        boolean onActivityResult = this.SLZ.getPluginRegistry().onActivityResult(i2, i3, intent);
        AppMethodBeat.o(9652);
        return onActivityResult;
    }

    @Override // io.flutter.app.b
    public final void hwi() {
        String[] strArr;
        Drawable hwj;
        View view = null;
        AppMethodBeat.i(9653);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        }
        Intent intent = this.activity.getIntent();
        ArrayList arrayList = new ArrayList();
        if (intent.getBooleanExtra("trace-startup", false)) {
            arrayList.add("--trace-startup");
        }
        if (intent.getBooleanExtra("start-paused", false)) {
            arrayList.add("--start-paused");
        }
        if (intent.getBooleanExtra("disable-service-auth-codes", false)) {
            arrayList.add("--disable-service-auth-codes");
        }
        if (intent.getBooleanExtra("use-test-fonts", false)) {
            arrayList.add("--use-test-fonts");
        }
        if (intent.getBooleanExtra("enable-dart-profiling", false)) {
            arrayList.add("--enable-dart-profiling");
        }
        if (intent.getBooleanExtra("enable-software-rendering", false)) {
            arrayList.add("--enable-software-rendering");
        }
        if (intent.getBooleanExtra("skia-deterministic-rendering", false)) {
            arrayList.add("--skia-deterministic-rendering");
        }
        if (intent.getBooleanExtra("trace-skia", false)) {
            arrayList.add("--trace-skia");
        }
        if (intent.getBooleanExtra("trace-systrace", false)) {
            arrayList.add("--trace-systrace");
        }
        if (intent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
            arrayList.add("--dump-skp-on-shader-compilation");
        }
        if (intent.getBooleanExtra("cache-sksl", false)) {
            arrayList.add("--cache-sksl");
        }
        if (intent.getBooleanExtra("verbose-logging", false)) {
            arrayList.add("--verbose-logging");
        }
        int intExtra = intent.getIntExtra("observatory-port", 0);
        if (intExtra > 0) {
            arrayList.add("--observatory-port=" + Integer.toString(intExtra));
        }
        if (intent.getBooleanExtra("disable-service-auth-codes", false)) {
            arrayList.add("--disable-service-auth-codes");
        }
        if (intent.getBooleanExtra("endless-trace-buffer", false)) {
            arrayList.add("--endless-trace-buffer");
        }
        if (intent.hasExtra("dart-flags")) {
            arrayList.add("--dart-flags=" + intent.getStringExtra("dart-flags"));
        }
        if (!arrayList.isEmpty()) {
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        } else {
            strArr = null;
        }
        FlutterMain.ensureInitializationComplete(this.activity.getApplicationContext(), strArr);
        this.SLZ = null;
        if (this.SLZ == null) {
            this.SLZ = new FlutterView(this.activity, null, null);
            this.SLZ.setLayoutParams(SLX);
            this.activity.setContentView(this.SLZ);
            if (hwk().booleanValue() && (hwj = hwj()) != null) {
                view = new View(this.activity);
                view.setLayoutParams(SLX);
                view.setBackground(hwj);
            }
            this.SMa = view;
            if (!(this.SMa == null || this.SMa == null)) {
                this.activity.addContentView(this.SMa, SLX);
                this.SLZ.SWs.add(new FlutterView.a() {
                    /* class io.flutter.app.a.AnonymousClass1 */

                    @Override // io.flutter.view.FlutterView.a
                    public final void onFirstFrame() {
                        AppMethodBeat.i(9594);
                        a.this.SMa.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                            /* class io.flutter.app.a.AnonymousClass1.AnonymousClass1 */

                            public final void onAnimationEnd(Animator animator) {
                                AppMethodBeat.i(9623);
                                ((ViewGroup) a.this.SMa.getParent()).removeView(a.this.SMa);
                                a.this.SMa = null;
                                AppMethodBeat.o(9623);
                            }
                        });
                        a.this.SLZ.SWs.remove(this);
                        AppMethodBeat.o(9594);
                    }
                });
                this.activity.setTheme(16973833);
            }
        }
        if (bN(this.activity.getIntent())) {
            AppMethodBeat.o(9653);
            return;
        }
        String findAppBundlePath = FlutterMain.findAppBundlePath();
        if (findAppBundlePath != null) {
            bsY(findAppBundlePath);
        }
        AppMethodBeat.o(9653);
    }

    @Override // io.flutter.app.b
    public final void onPause() {
        AppMethodBeat.i(9655);
        Application application = (Application) this.activity.getApplicationContext();
        if (application instanceof FlutterApplication) {
            FlutterApplication flutterApplication = (FlutterApplication) application;
            if (this.activity.equals(flutterApplication.getCurrentActivity())) {
                flutterApplication.setCurrentActivity(null);
            }
        }
        if (this.SLZ != null) {
            this.SLZ.SNZ.hxc();
        }
        AppMethodBeat.o(9655);
    }

    @Override // io.flutter.app.b
    public final void onStart() {
        AppMethodBeat.i(9656);
        if (this.SLZ != null) {
            this.SLZ.SNZ.hxc();
        }
        AppMethodBeat.o(9656);
    }

    @Override // io.flutter.app.b
    public final void onResume() {
        AppMethodBeat.i(9657);
        Application application = (Application) this.activity.getApplicationContext();
        if (application instanceof FlutterApplication) {
            ((FlutterApplication) application).setCurrentActivity(this.activity);
        }
        AppMethodBeat.o(9657);
    }

    @Override // io.flutter.app.b
    public final void onStop() {
        AppMethodBeat.i(9658);
        this.SLZ.SNZ.hxe();
        AppMethodBeat.o(9658);
    }

    @Override // io.flutter.app.b
    public final void onPostResume() {
        AppMethodBeat.i(9659);
        if (this.SLZ != null) {
            this.SLZ.onPostResume();
        }
        AppMethodBeat.o(9659);
    }

    @Override // io.flutter.app.b
    public final void onDestroy() {
        AppMethodBeat.i(9660);
        Application application = (Application) this.activity.getApplicationContext();
        if (application instanceof FlutterApplication) {
            FlutterApplication flutterApplication = (FlutterApplication) application;
            if (this.activity.equals(flutterApplication.getCurrentActivity())) {
                flutterApplication.setCurrentActivity(null);
            }
        }
        if (this.SLZ != null) {
            if (this.SLZ.getPluginRegistry().a(this.SLZ.getFlutterNativeView())) {
                FlutterView flutterView = this.SLZ;
                if (flutterView.isAttached()) {
                    flutterView.getHolder().removeCallback(flutterView.SWp);
                    FlutterNativeView flutterNativeView = flutterView.SMd;
                    c cVar = flutterNativeView.SWe;
                    cVar.SMf.detach();
                    cVar.SMf.onDetachedFromJNI();
                    cVar.SMe = null;
                    cVar.mActivity = null;
                    flutterNativeView.SMe = null;
                    flutterView.SMd = null;
                }
                AppMethodBeat.o(9660);
                return;
            }
            this.SLZ.destroy();
        }
        AppMethodBeat.o(9660);
    }

    @Override // io.flutter.app.b
    public final boolean onBackPressed() {
        AppMethodBeat.i(9661);
        if (this.SLZ != null) {
            this.SLZ.SOc.dLr();
            AppMethodBeat.o(9661);
            return true;
        }
        AppMethodBeat.o(9661);
        return false;
    }

    @Override // io.flutter.app.b
    public final void onUserLeaveHint() {
        AppMethodBeat.i(9662);
        this.SLZ.getPluginRegistry().onUserLeaveHint();
        AppMethodBeat.o(9662);
    }

    public final void onTrimMemory(int i2) {
        AppMethodBeat.i(9663);
        if (i2 == 10) {
            this.SLZ.hxz();
        }
        AppMethodBeat.o(9663);
    }

    public final void onLowMemory() {
        AppMethodBeat.i(9664);
        this.SLZ.hxz();
        AppMethodBeat.o(9664);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    private boolean bN(Intent intent) {
        AppMethodBeat.i(9665);
        if ("android.intent.action.RUN".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(TencentExtraKeys.LOCATION_KEY_ROUTE);
            String dataString = intent.getDataString();
            if (dataString == null) {
                dataString = FlutterMain.findAppBundlePath();
            }
            if (stringExtra != null) {
                this.SLZ.setInitialRoute(stringExtra);
            }
            bsY(dataString);
            AppMethodBeat.o(9665);
            return true;
        }
        AppMethodBeat.o(9665);
        return false;
    }

    private void bsY(String str) {
        AppMethodBeat.i(9666);
        if (!this.SLZ.getFlutterNativeView().SWg) {
            io.flutter.view.b bVar = new io.flutter.view.b();
            bVar.SWi = str;
            bVar.SWj = "main";
            this.SLZ.a(bVar);
        }
        AppMethodBeat.o(9666);
    }

    private Drawable hwj() {
        Drawable drawable = null;
        AppMethodBeat.i(9667);
        TypedValue typedValue = new TypedValue();
        if (!this.activity.getTheme().resolveAttribute(16842836, typedValue, true)) {
            AppMethodBeat.o(9667);
        } else if (typedValue.resourceId == 0) {
            AppMethodBeat.o(9667);
        } else {
            try {
                drawable = this.activity.getResources().getDrawable(typedValue.resourceId);
                AppMethodBeat.o(9667);
            } catch (Resources.NotFoundException e2) {
                AppMethodBeat.o(9667);
            }
        }
        return drawable;
    }

    private Boolean hwk() {
        AppMethodBeat.i(9668);
        try {
            Bundle bundle = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 129).metaData;
            Boolean valueOf = Boolean.valueOf(bundle != null && bundle.getBoolean("io.flutter.app.android.SplashScreenUntilFirstFrame"));
            AppMethodBeat.o(9668);
            return valueOf;
        } catch (PackageManager.NameNotFoundException e2) {
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(9668);
            return bool;
        }
    }

    @Override // io.flutter.app.b
    public final void onNewIntent(Intent intent) {
        boolean z;
        AppMethodBeat.i(9654);
        if ((this.activity.getApplicationInfo().flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !bN(intent)) {
            this.SLZ.getPluginRegistry().onNewIntent(intent);
        }
        AppMethodBeat.o(9654);
    }
}
