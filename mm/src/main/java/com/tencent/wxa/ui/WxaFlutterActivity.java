package com.tencent.wxa.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.wxa.b.b;
import com.tencent.wxa.c;
import com.tencent.wxa.ui.a;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.d;
import io.flutter.embedding.android.j;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class WxaFlutterActivity extends AppCompatActivity implements LifecycleOwner, b, a.AbstractC2229a {
    public static final String crl = d.a.opaque.name();
    public Toolbar azk;
    protected String crm;
    protected a crn;
    private LifecycleRegistry crq = new LifecycleRegistry(this);

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WxaFlutterActivity() {
        AppMethodBeat.i(206334);
        AppMethodBeat.o(206334);
    }

    static {
        AppMethodBeat.i(206362);
        AppMethodBeat.o(206362);
    }

    @Override // io.flutter.embedding.android.k, com.tencent.wxa.ui.a.AbstractC2229a
    public final j KF() {
        AppMethodBeat.i(206336);
        Drawable KG = KG();
        if (KG != null) {
            DrawableSplashScreen drawableSplashScreen = new DrawableSplashScreen(KG);
            AppMethodBeat.o(206336);
            return drawableSplashScreen;
        }
        AppMethodBeat.o(206336);
        return null;
    }

    private Drawable KG() {
        Integer num;
        AppMethodBeat.i(206337);
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            if (bundle != null) {
                num = Integer.valueOf(bundle.getInt("io.flutter.embedding.android.SplashScreenDrawable"));
            } else {
                num = null;
            }
            if (num == null) {
                AppMethodBeat.o(206337);
                return null;
            } else if (Build.VERSION.SDK_INT > 21) {
                Drawable drawable = getResources().getDrawable(num.intValue(), getTheme());
                AppMethodBeat.o(206337);
                return drawable;
            } else {
                Drawable drawable2 = getResources().getDrawable(num.intValue());
                AppMethodBeat.o(206337);
                return drawable2;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(206337);
            return null;
        }
    }

    private d.a KH() {
        AppMethodBeat.i(206338);
        if (getIntent().hasExtra("background_mode")) {
            d.a valueOf = d.a.valueOf(getIntent().getStringExtra("background_mode"));
            AppMethodBeat.o(206338);
            return valueOf;
        }
        d.a aVar = d.a.opaque;
        AppMethodBeat.o(206338);
        return aVar;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(206339);
        super.onStart();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.crn.onStart();
        AppMethodBeat.o(206339);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(206340);
        super.onResume();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.crn.onResume();
        AppMethodBeat.o(206340);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onPostResume() {
        AppMethodBeat.i(206341);
        super.onPostResume();
        this.crn.onPostResume();
        AppMethodBeat.o(206341);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(206342);
        super.onPause();
        this.crn.onPause();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        AppMethodBeat.o(206342);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(206343);
        super.onStop();
        this.crn.onStop();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        AppMethodBeat.o(206343);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(206344);
        super.onDestroy();
        this.crn.onDestroyView();
        this.crn.onDetach();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        AppMethodBeat.o(206344);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(206345);
        this.crn.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(206345);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(206346);
        super.onNewIntent(intent);
        this.crn.onNewIntent(intent);
        AppMethodBeat.o(206346);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(206347);
        this.crn.onBackPressed();
        AppMethodBeat.o(206347);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(206348);
        this.crn.onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(206348);
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        AppMethodBeat.i(206349);
        this.crn.onUserLeaveHint();
        AppMethodBeat.o(206349);
    }

    public void onTrimMemory(int i2) {
        AppMethodBeat.i(206350);
        this.crn.onTrimMemory(i2);
        AppMethodBeat.o(206350);
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public Context getContext() {
        return this;
    }

    @Override // com.tencent.wxa.b.b, com.tencent.wxa.ui.a.AbstractC2229a
    public final Activity getActivity() {
        return this;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final b KI() {
        return this;
    }

    @Override // android.support.v4.app.SupportActivity, android.arch.lifecycle.LifecycleOwner, com.tencent.wxa.ui.a.AbstractC2229a, android.support.v4.app.FragmentActivity
    public Lifecycle getLifecycle() {
        return this.crq;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KJ() {
        AppMethodBeat.i(206351);
        String stringExtra = getIntent().getStringExtra("cached_engine_id");
        AppMethodBeat.o(206351);
        return stringExtra;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KK() {
        AppMethodBeat.i(206352);
        if (getIntent().hasExtra("dart_entrypoint")) {
            String stringExtra = getIntent().getStringExtra("dart_entrypoint");
            AppMethodBeat.o(206352);
            return stringExtra;
        }
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.Entrypoint") : null;
            if (string != null) {
                AppMethodBeat.o(206352);
                return string;
            }
            AppMethodBeat.o(206352);
            return "main";
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(206352);
            return "main";
        }
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KM() {
        AppMethodBeat.i(206354);
        if (getIntent().hasExtra("initial_route")) {
            String stringExtra = getIntent().getStringExtra("initial_route");
            AppMethodBeat.o(206354);
            return stringExtra;
        }
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.InitialRoute") : null;
            if (string != null) {
                AppMethodBeat.o(206354);
                return string;
            }
            AppMethodBeat.o(206354);
            return FilePathGenerator.ANDROID_DIR_SEP;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(206354);
            return FilePathGenerator.ANDROID_DIR_SEP;
        }
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final FlutterView.b KN() {
        AppMethodBeat.i(206355);
        if (KH() == d.a.opaque) {
            FlutterView.b bVar = FlutterView.b.surface;
            AppMethodBeat.o(206355);
            return bVar;
        }
        FlutterView.b bVar2 = FlutterView.b.texture;
        AppMethodBeat.o(206355);
        return bVar2;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final FlutterView.c KO() {
        AppMethodBeat.i(206356);
        if (KH() == d.a.opaque) {
            FlutterView.c cVar = FlutterView.c.opaque;
            AppMethodBeat.o(206356);
            return cVar;
        }
        FlutterView.c cVar2 = FlutterView.c.transparent;
        AppMethodBeat.o(206356);
        return cVar2;
    }

    @Override // io.flutter.embedding.android.f, com.tencent.wxa.ui.a.AbstractC2229a
    public final io.flutter.embedding.engine.a KP() {
        AppMethodBeat.i(206357);
        io.flutter.embedding.engine.a aVar = c.hrH().SxF;
        AppMethodBeat.o(206357);
        return aVar;
    }

    @Override // com.tencent.wxa.b.b
    public final void bP(boolean z) {
        AppMethodBeat.i(206358);
        com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivity", "setIsPopGestureEnabled value:%b", Boolean.valueOf(z));
        AppMethodBeat.o(206358);
    }

    @Override // com.tencent.wxa.b.b
    public final String KQ() {
        AppMethodBeat.i(206359);
        if (!getIntent().hasExtra("activityId") || TextUtils.isEmpty(getIntent().getStringExtra("activityId"))) {
            if (TextUtils.isEmpty(this.crm)) {
                this.crm = String.format("%d-%d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()));
            }
            String str = this.crm;
            AppMethodBeat.o(206359);
            return str;
        }
        String stringExtra = getIntent().getStringExtra("activityId");
        AppMethodBeat.o(206359);
        return stringExtra;
    }

    @Override // com.tencent.wxa.b.b
    public final String KR() {
        AppMethodBeat.i(206360);
        if (getIntent().hasExtra("name")) {
            String stringExtra = getIntent().getStringExtra("name");
            AppMethodBeat.o(206360);
            return stringExtra;
        }
        AppMethodBeat.o(206360);
        return "";
    }

    @Override // com.tencent.wxa.b.b
    public final Map KS() {
        AppMethodBeat.i(206361);
        if (!getIntent().hasExtra(NativeProtocol.WEB_DIALOG_PARAMS) || !(getIntent().getSerializableExtra(NativeProtocol.WEB_DIALOG_PARAMS) instanceof com.tencent.wxa.d.a)) {
            AppMethodBeat.o(206361);
            return null;
        }
        Map map = ((com.tencent.wxa.d.a) getIntent().getSerializableExtra(NativeProtocol.WEB_DIALOG_PARAMS)).map;
        AppMethodBeat.o(206361);
        return map;
    }

    @Override // io.flutter.embedding.android.e, com.tencent.wxa.ui.a.AbstractC2229a
    public final void b(io.flutter.embedding.engine.a aVar) {
    }

    @Override // io.flutter.embedding.android.e
    public final void c(io.flutter.embedding.engine.a aVar) {
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(206335);
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (activityInfo.metaData != null) {
                int i2 = activityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i2 != -1) {
                    setTheme(i2);
                }
            } else {
                com.tencent.wxa.c.a.d("FlutterActivity", "Using the launch theme as normal theme.", new Object[0]);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            com.tencent.wxa.c.a.e("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.", new Object[0]);
        }
        super.onCreate(bundle);
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.crn = new a(this);
        this.crn.hrO();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        Toolbar toolbar = new Toolbar(this);
        toolbar.setLayoutParams(new Toolbar.LayoutParams(-1));
        toolbar.mY();
        toolbar.setVisibility(8);
        this.azk = toolbar;
        if (this.azk != null) {
            linearLayout.addView(this.azk);
            setSupportActionBar(this.azk);
        }
        linearLayout.addView(this.crn.hrQ(), new LinearLayout.LayoutParams(-1, -1));
        setContentView(linearLayout);
        AppMethodBeat.o(206335);
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KL() {
        boolean z;
        String dataString;
        AppMethodBeat.i(206353);
        if ((getApplicationInfo().flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            String findAppBundlePath = FlutterMain.findAppBundlePath();
            AppMethodBeat.o(206353);
            return findAppBundlePath;
        }
        AppMethodBeat.o(206353);
        return dataString;
    }
}
