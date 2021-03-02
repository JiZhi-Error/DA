package io.flutter.embedding.android;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tavkit.component.TAVExporter;
import io.flutter.embedding.android.c;
import io.flutter.embedding.android.d;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.d;
import io.flutter.plugin.platform.b;
import io.flutter.view.FlutterMain;

public class FlutterActivity extends HellActivity implements LifecycleOwner, c.a {
    protected c SMA;
    private LifecycleRegistry crq = new LifecycleRegistry(this);

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FlutterActivity() {
        AppMethodBeat.i(10028);
        AppMethodBeat.o(10028);
    }

    @Override // io.flutter.embedding.android.k, io.flutter.embedding.android.c.a
    public final j KF() {
        AppMethodBeat.i(10030);
        Drawable KG = KG();
        if (KG != null) {
            DrawableSplashScreen drawableSplashScreen = new DrawableSplashScreen(KG);
            AppMethodBeat.o(10030);
            return drawableSplashScreen;
        }
        AppMethodBeat.o(10030);
        return null;
    }

    private Drawable KG() {
        AppMethodBeat.i(10031);
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            int i2 = bundle != null ? bundle.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
            if (i2 == 0) {
                AppMethodBeat.o(10031);
                return null;
            } else if (Build.VERSION.SDK_INT > 21) {
                Drawable drawable = getResources().getDrawable(i2, getTheme());
                AppMethodBeat.o(10031);
                return drawable;
            } else {
                Drawable drawable2 = getResources().getDrawable(i2);
                AppMethodBeat.o(10031);
                return drawable2;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(10031);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AppMethodBeat.i(10032);
        super.onStart();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.SMA.onStart();
        AppMethodBeat.o(10032);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(10033);
        super.onResume();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.SMA.onResume();
        AppMethodBeat.o(10033);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPostResume() {
        AppMethodBeat.i(10034);
        super.onPostResume();
        this.SMA.onPostResume();
        AppMethodBeat.o(10034);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(10035);
        super.onPause();
        this.SMA.onPause();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        AppMethodBeat.o(10035);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onStop() {
        AppMethodBeat.i(10036);
        super.onStop();
        this.SMA.onStop();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        AppMethodBeat.o(10036);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(215110);
        super.onSaveInstanceState(bundle);
        this.SMA.onSaveInstanceState(bundle);
        AppMethodBeat.o(215110);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(10037);
        super.onDestroy();
        this.SMA.onDestroyView();
        this.SMA.onDetach();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        AppMethodBeat.o(10037);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(10038);
        this.SMA.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(10038);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(10039);
        super.onNewIntent(intent);
        this.SMA.onNewIntent(intent);
        AppMethodBeat.o(10039);
    }

    public void onBackPressed() {
        AppMethodBeat.i(10040);
        this.SMA.onBackPressed();
        AppMethodBeat.o(10040);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(10041);
        this.SMA.onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(10041);
    }

    public void onUserLeaveHint() {
        AppMethodBeat.i(10042);
        this.SMA.onUserLeaveHint();
        AppMethodBeat.o(10042);
    }

    public void onTrimMemory(int i2) {
        AppMethodBeat.i(10043);
        super.onTrimMemory(i2);
        this.SMA.onTrimMemory(i2);
        AppMethodBeat.o(10043);
    }

    @Override // io.flutter.embedding.android.c.a
    public Context getContext() {
        return this;
    }

    @Override // io.flutter.embedding.android.c.a
    public final Activity getActivity() {
        return this;
    }

    @Override // android.arch.lifecycle.LifecycleOwner, io.flutter.embedding.android.c.a
    public Lifecycle getLifecycle() {
        return this.crq;
    }

    @Override // io.flutter.embedding.android.c.a
    public final d hwl() {
        AppMethodBeat.i(10044);
        d bO = d.bO(getIntent());
        AppMethodBeat.o(10044);
        return bO;
    }

    @Override // io.flutter.embedding.android.c.a
    public final String KJ() {
        AppMethodBeat.i(10045);
        String stringExtra = getIntent().getStringExtra("cached_engine_id");
        AppMethodBeat.o(10045);
        return stringExtra;
    }

    @Override // io.flutter.embedding.android.c.a
    public final boolean hwm() {
        AppMethodBeat.i(10046);
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        if (KJ() != null || this.SMA.Syd) {
            AppMethodBeat.o(10046);
            return booleanExtra;
        }
        boolean booleanExtra2 = getIntent().getBooleanExtra("destroy_engine_with_activity", true);
        AppMethodBeat.o(10046);
        return booleanExtra2;
    }

    @Override // io.flutter.embedding.android.c.a
    public final String KK() {
        AppMethodBeat.i(10047);
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.Entrypoint") : null;
            if (string != null) {
                AppMethodBeat.o(10047);
                return string;
            }
            AppMethodBeat.o(10047);
            return "main";
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(10047);
            return "main";
        }
    }

    @Override // io.flutter.embedding.android.c.a
    public final String KM() {
        AppMethodBeat.i(10048);
        if (getIntent().hasExtra(TencentExtraKeys.LOCATION_KEY_ROUTE)) {
            String stringExtra = getIntent().getStringExtra(TencentExtraKeys.LOCATION_KEY_ROUTE);
            AppMethodBeat.o(10048);
            return stringExtra;
        }
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.InitialRoute") : null;
            if (string != null) {
                AppMethodBeat.o(10048);
                return string;
            }
            AppMethodBeat.o(10048);
            return FilePathGenerator.ANDROID_DIR_SEP;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(10048);
            return FilePathGenerator.ANDROID_DIR_SEP;
        }
    }

    @Override // io.flutter.embedding.android.c.a
    public final i hwn() {
        AppMethodBeat.i(215111);
        if (KH() == d.a.opaque) {
            i iVar = i.surface;
            AppMethodBeat.o(215111);
            return iVar;
        }
        i iVar2 = i.texture;
        AppMethodBeat.o(215111);
        return iVar2;
    }

    @Override // io.flutter.embedding.android.c.a
    public final l hwo() {
        AppMethodBeat.i(215112);
        if (KH() == d.a.opaque) {
            l lVar = l.opaque;
            AppMethodBeat.o(215112);
            return lVar;
        }
        l lVar2 = l.transparent;
        AppMethodBeat.o(215112);
        return lVar2;
    }

    private d.a KH() {
        AppMethodBeat.i(215113);
        if (getIntent().hasExtra("background_mode")) {
            d.a valueOf = d.a.valueOf(getIntent().getStringExtra("background_mode"));
            AppMethodBeat.o(215113);
            return valueOf;
        }
        d.a aVar = d.a.opaque;
        AppMethodBeat.o(215113);
        return aVar;
    }

    @Override // io.flutter.embedding.android.f, io.flutter.embedding.android.c.a
    public final a KP() {
        return null;
    }

    @Override // io.flutter.embedding.android.c.a
    public final b a(Activity activity, a aVar) {
        AppMethodBeat.i(10053);
        if (activity != null) {
            b bVar = new b(this, aVar.SOe);
            AppMethodBeat.o(10053);
            return bVar;
        }
        AppMethodBeat.o(10053);
        return null;
    }

    @Override // io.flutter.embedding.android.e, io.flutter.embedding.android.c.a
    public final void c(a aVar) {
    }

    @Override // io.flutter.embedding.android.c.a
    public final boolean hwp() {
        return true;
    }

    @Override // io.flutter.embedding.android.c.a
    public final void dLt() {
        AppMethodBeat.i(215115);
        if (Build.VERSION.SDK_INT >= 21) {
            reportFullyDrawn();
        }
        AppMethodBeat.o(215115);
    }

    @Override // io.flutter.embedding.android.c.a
    public final void dLu() {
    }

    @Override // io.flutter.embedding.android.c.a
    public final boolean hwq() {
        AppMethodBeat.i(215116);
        if (getIntent().hasExtra("enable_state_restoration")) {
            boolean booleanExtra = getIntent().getBooleanExtra("enable_state_restoration", false);
            AppMethodBeat.o(215116);
            return booleanExtra;
        } else if (KJ() != null) {
            AppMethodBeat.o(215116);
            return false;
        } else {
            AppMethodBeat.o(215116);
            return true;
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(10029);
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (activityInfo.metaData != null) {
                int i2 = activityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i2 != -1) {
                    setTheme(i2);
                }
            } else {
                io.flutter.a.hwd();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            io.flutter.a.hwg();
        }
        super.onCreate(bundle);
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.SMA = new c(this);
        this.SMA.hrO();
        this.SMA.onActivityCreated(bundle);
        if (KH() == d.a.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        setContentView(this.SMA.hrQ());
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        }
        AppMethodBeat.o(10029);
    }

    @Override // io.flutter.embedding.android.c.a
    public final String KL() {
        boolean z;
        String dataString;
        AppMethodBeat.i(10049);
        if ((getApplicationInfo().flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            String findAppBundlePath = FlutterMain.findAppBundlePath();
            AppMethodBeat.o(10049);
            return findAppBundlePath;
        }
        AppMethodBeat.o(10049);
        return dataString;
    }

    @Override // io.flutter.embedding.android.e, io.flutter.embedding.android.c.a
    public final void b(a aVar) {
        AppMethodBeat.i(215114);
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", a.class).invoke(null, aVar);
            AppMethodBeat.o(215114);
        } catch (Exception e2) {
            new StringBuilder("Tried to automatically register plugins with FlutterEngine (").append(aVar).append(") but could not find and invoke the GeneratedPluginRegistrant.");
            io.flutter.a.hwf();
            AppMethodBeat.o(215114);
        }
    }
}
