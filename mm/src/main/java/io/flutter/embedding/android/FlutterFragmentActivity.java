package io.flutter.embedding.android;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tavkit.component.TAVExporter;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.d;
import io.flutter.embedding.engine.a;
import io.flutter.view.FlutterMain;

public class FlutterFragmentActivity extends FragmentActivity implements e, f, k {
    private FlutterFragment SMQ;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // io.flutter.embedding.android.k
    public final j KF() {
        AppMethodBeat.i(215050);
        Drawable KG = KG();
        if (KG != null) {
            DrawableSplashScreen drawableSplashScreen = new DrawableSplashScreen(KG);
            AppMethodBeat.o(215050);
            return drawableSplashScreen;
        }
        AppMethodBeat.o(215050);
        return null;
    }

    private Drawable KG() {
        AppMethodBeat.i(215051);
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt("io.flutter.embedding.android.SplashScreenDrawable")) : null;
            if (valueOf == null) {
                AppMethodBeat.o(215051);
                return null;
            } else if (Build.VERSION.SDK_INT > 21) {
                Drawable drawable = getResources().getDrawable(valueOf.intValue(), getTheme());
                AppMethodBeat.o(215051);
                return drawable;
            } else {
                Drawable drawable2 = getResources().getDrawable(valueOf.intValue());
                AppMethodBeat.o(215051);
                return drawable2;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(215051);
            return null;
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPostResume() {
        AppMethodBeat.i(215052);
        super.onPostResume();
        this.SMQ.SMA.onPostResume();
        AppMethodBeat.o(215052);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(215053);
        this.SMQ.SMA.onNewIntent(intent);
        super.onNewIntent(intent);
        AppMethodBeat.o(215053);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(215054);
        this.SMQ.SMA.onBackPressed();
        AppMethodBeat.o(215054);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(215055);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.SMQ.onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(215055);
    }

    public void onUserLeaveHint() {
        AppMethodBeat.i(215056);
        this.SMQ.SMA.onUserLeaveHint();
        AppMethodBeat.o(215056);
    }

    public void onTrimMemory(int i2) {
        AppMethodBeat.i(215057);
        super.onTrimMemory(i2);
        this.SMQ.SMA.onTrimMemory(i2);
        AppMethodBeat.o(215057);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(215058);
        super.onActivityResult(i2, i3, intent);
        this.SMQ.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(215058);
    }

    private boolean hwm() {
        AppMethodBeat.i(215059);
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        AppMethodBeat.o(215059);
        return booleanExtra;
    }

    @Override // io.flutter.embedding.android.f
    public final a KP() {
        return null;
    }

    @Override // io.flutter.embedding.android.e
    public final void b(a aVar) {
    }

    @Override // io.flutter.embedding.android.e
    public final void c(a aVar) {
    }

    private String KL() {
        String dataString;
        AppMethodBeat.i(215060);
        if (!hwt() || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            String findAppBundlePath = FlutterMain.findAppBundlePath();
            AppMethodBeat.o(215060);
            return findAppBundlePath;
        }
        AppMethodBeat.o(215060);
        return dataString;
    }

    private String KK() {
        AppMethodBeat.i(215061);
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.Entrypoint") : null;
            if (string != null) {
                AppMethodBeat.o(215061);
                return string;
            }
            AppMethodBeat.o(215061);
            return "main";
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(215061);
            return "main";
        }
    }

    private String KM() {
        AppMethodBeat.i(215062);
        if (getIntent().hasExtra(TencentExtraKeys.LOCATION_KEY_ROUTE)) {
            String stringExtra = getIntent().getStringExtra(TencentExtraKeys.LOCATION_KEY_ROUTE);
            AppMethodBeat.o(215062);
            return stringExtra;
        }
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.InitialRoute") : null;
            if (string != null) {
                AppMethodBeat.o(215062);
                return string;
            }
            AppMethodBeat.o(215062);
            return FilePathGenerator.ANDROID_DIR_SEP;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(215062);
            return FilePathGenerator.ANDROID_DIR_SEP;
        }
    }

    private String KJ() {
        AppMethodBeat.i(215063);
        String stringExtra = getIntent().getStringExtra("cached_engine_id");
        AppMethodBeat.o(215063);
        return stringExtra;
    }

    private d.a KH() {
        AppMethodBeat.i(215064);
        if (getIntent().hasExtra("background_mode")) {
            d.a valueOf = d.a.valueOf(getIntent().getStringExtra("background_mode"));
            AppMethodBeat.o(215064);
            return valueOf;
        }
        d.a aVar = d.a.opaque;
        AppMethodBeat.o(215064);
        return aVar;
    }

    private boolean hwt() {
        AppMethodBeat.i(215065);
        if ((getApplicationInfo().flags & 2) != 0) {
            AppMethodBeat.o(215065);
            return true;
        }
        AppMethodBeat.o(215065);
        return false;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        FlutterFragment hws;
        AppMethodBeat.i(215049);
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
        if (KH() == d.a.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(609893468);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(frameLayout);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        }
        g supportFragmentManager = getSupportFragmentManager();
        this.SMQ = (FlutterFragment) supportFragmentManager.findFragmentByTag("flutter_fragment");
        if (this.SMQ == null) {
            d.a KH = KH();
            i iVar = KH == d.a.opaque ? i.surface : i.texture;
            l lVar = KH == d.a.opaque ? l.opaque : l.transparent;
            if (KJ() != null) {
                new StringBuilder("Creating FlutterFragment with cached engine:\nCached engine ID: ").append(KJ()).append("\nWill destroy engine when Activity is destroyed: ").append(hwm()).append("\nBackground transparency mode: ").append(KH).append("\nWill attach FlutterEngine to Activity: true");
                io.flutter.a.hwd();
                FlutterFragment.a bsZ = FlutterFragment.bsZ(KJ());
                bsZ.SML = iVar;
                bsZ.SMM = lVar;
                bsZ.SMN = true;
                bsZ.SMK = hwm();
                hws = bsZ.hws();
            } else {
                new StringBuilder("Creating FlutterFragment with new engine:\nBackground transparency mode: ").append(KH).append("\nDart entrypoint: ").append(KK()).append("\nInitial route: ").append(KM()).append("\nApp bundle path: ").append(KL()).append("\nWill attach FlutterEngine to Activity: true");
                io.flutter.a.hwd();
                FlutterFragment.b hwr = FlutterFragment.hwr();
                hwr.SxI = KK();
                hwr.SxJ = KM();
                hwr.SMO = KL();
                hwr.SMP = io.flutter.embedding.engine.d.bO(getIntent());
                hwr.SML = iVar;
                hwr.SMM = lVar;
                hwr.SMN = true;
                hws = hwr.hws();
            }
            this.SMQ = hws;
            supportFragmentManager.beginTransaction().a(609893468, this.SMQ, "flutter_fragment").commit();
        }
        AppMethodBeat.o(215049);
    }
}
