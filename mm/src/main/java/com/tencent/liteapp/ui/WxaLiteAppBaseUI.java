package com.tencent.liteapp.ui;

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
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ext.ui.SwipeBackActivity;
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

public class WxaLiteAppBaseUI extends SwipeBackActivity implements LifecycleOwner, b, a.AbstractC2229a {
    public static final String crl = d.a.opaque.name();
    protected String crm;
    protected a crn;
    protected WxaLiteAppInfo cro;
    protected boolean crp = false;
    private LifecycleRegistry crq = new LifecycleRegistry(this);

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WxaLiteAppBaseUI() {
        AppMethodBeat.i(197719);
        AppMethodBeat.o(197719);
    }

    static {
        AppMethodBeat.i(197749);
        AppMethodBeat.o(197749);
    }

    /* access modifiers changed from: protected */
    public View KE() {
        AppMethodBeat.i(197720);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(this.crn.hrQ(), new LinearLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(197720);
        return linearLayout;
    }

    @Override // io.flutter.embedding.android.k, com.tencent.wxa.ui.a.AbstractC2229a
    public final j KF() {
        AppMethodBeat.i(197722);
        Drawable KG = KG();
        if (KG != null) {
            DrawableSplashScreen drawableSplashScreen = new DrawableSplashScreen(KG);
            AppMethodBeat.o(197722);
            return drawableSplashScreen;
        }
        AppMethodBeat.o(197722);
        return null;
    }

    private Drawable KG() {
        Integer num;
        AppMethodBeat.i(197723);
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            if (bundle != null) {
                num = Integer.valueOf(bundle.getInt("io.flutter.embedding.android.SplashScreenDrawable"));
            } else {
                num = null;
            }
            if (num == null) {
                AppMethodBeat.o(197723);
                return null;
            } else if (Build.VERSION.SDK_INT > 21) {
                Drawable drawable = getResources().getDrawable(num.intValue(), getTheme());
                AppMethodBeat.o(197723);
                return drawable;
            } else {
                Drawable drawable2 = getResources().getDrawable(num.intValue());
                AppMethodBeat.o(197723);
                return drawable2;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(197723);
            return null;
        }
    }

    private d.a KH() {
        AppMethodBeat.i(197724);
        if (getIntent().hasExtra("background_mode")) {
            d.a valueOf = d.a.valueOf(getIntent().getStringExtra("background_mode"));
            AppMethodBeat.o(197724);
            return valueOf;
        }
        d.a aVar = d.a.opaque;
        AppMethodBeat.o(197724);
        return aVar;
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(197725);
        super.onStart();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.crn.onStart();
        AppMethodBeat.o(197725);
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(197726);
        super.onResume();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.crn.onResume();
        AppMethodBeat.o(197726);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onPostResume() {
        AppMethodBeat.i(197727);
        super.onPostResume();
        this.crn.onPostResume();
        AppMethodBeat.o(197727);
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(197728);
        super.onPause();
        this.crn.onPause();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        AppMethodBeat.o(197728);
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(197729);
        super.onStop();
        this.crn.onStop();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        AppMethodBeat.o(197729);
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(197730);
        super.onDestroy();
        this.crn.onDestroyView();
        this.crn.onDetach();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        AppMethodBeat.o(197730);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(197731);
        this.crn.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(197731);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(197732);
        super.onNewIntent(intent);
        this.crn.onNewIntent(intent);
        AppMethodBeat.o(197732);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(197733);
        this.crn.onBackPressed();
        AppMethodBeat.o(197733);
    }

    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(197734);
        this.crn.onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(197734);
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        AppMethodBeat.i(197735);
        this.crn.onUserLeaveHint();
        AppMethodBeat.o(197735);
    }

    public void onTrimMemory(int i2) {
        AppMethodBeat.i(197736);
        this.crn.onTrimMemory(i2);
        AppMethodBeat.o(197736);
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
        AppMethodBeat.i(197737);
        String stringExtra = getIntent().getStringExtra("cached_engine_id");
        AppMethodBeat.o(197737);
        return stringExtra;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KK() {
        AppMethodBeat.i(197738);
        if (getIntent().hasExtra("dart_entrypoint")) {
            String stringExtra = getIntent().getStringExtra("dart_entrypoint");
            AppMethodBeat.o(197738);
            return stringExtra;
        }
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.Entrypoint") : null;
            if (string != null) {
                AppMethodBeat.o(197738);
                return string;
            }
            AppMethodBeat.o(197738);
            return "main";
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(197738);
            return "main";
        }
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KM() {
        AppMethodBeat.i(197740);
        if (getIntent().hasExtra("initial_route")) {
            String stringExtra = getIntent().getStringExtra("initial_route");
            AppMethodBeat.o(197740);
            return stringExtra;
        }
        try {
            Bundle bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.InitialRoute") : null;
            if (string != null) {
                AppMethodBeat.o(197740);
                return string;
            }
            AppMethodBeat.o(197740);
            return FilePathGenerator.ANDROID_DIR_SEP;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(197740);
            return FilePathGenerator.ANDROID_DIR_SEP;
        }
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final FlutterView.b KN() {
        AppMethodBeat.i(197741);
        if (KH() == d.a.opaque) {
            FlutterView.b bVar = FlutterView.b.surface;
            AppMethodBeat.o(197741);
            return bVar;
        }
        FlutterView.b bVar2 = FlutterView.b.texture;
        AppMethodBeat.o(197741);
        return bVar2;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final FlutterView.c KO() {
        AppMethodBeat.i(197742);
        if (this.crp) {
            FlutterView.c cVar = FlutterView.c.transparent;
            AppMethodBeat.o(197742);
            return cVar;
        } else if (KH() == d.a.opaque) {
            FlutterView.c cVar2 = FlutterView.c.opaque;
            AppMethodBeat.o(197742);
            return cVar2;
        } else {
            FlutterView.c cVar3 = FlutterView.c.transparent;
            AppMethodBeat.o(197742);
            return cVar3;
        }
    }

    @Override // io.flutter.embedding.android.f, com.tencent.wxa.ui.a.AbstractC2229a
    public final io.flutter.embedding.engine.a KP() {
        AppMethodBeat.i(197743);
        io.flutter.embedding.engine.a aVar = c.hrH().SxF;
        AppMethodBeat.o(197743);
        return aVar;
    }

    @Override // com.tencent.wxa.b.b
    public String KQ() {
        AppMethodBeat.i(197744);
        if (!getIntent().hasExtra("activityId") || TextUtils.isEmpty(getIntent().getStringExtra("activityId"))) {
            if (TextUtils.isEmpty(this.crm)) {
                this.crm = String.format("%d-%d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()));
            }
            String str = this.crm;
            AppMethodBeat.o(197744);
            return str;
        }
        String stringExtra = getIntent().getStringExtra("activityId");
        AppMethodBeat.o(197744);
        return stringExtra;
    }

    @Override // com.tencent.wxa.b.b
    public String KR() {
        AppMethodBeat.i(197745);
        if (getIntent().hasExtra("name")) {
            String stringExtra = getIntent().getStringExtra("name");
            AppMethodBeat.o(197745);
            return stringExtra;
        }
        AppMethodBeat.o(197745);
        return "";
    }

    @Override // com.tencent.wxa.b.b
    public Map KS() {
        AppMethodBeat.i(197746);
        if (!getIntent().hasExtra(NativeProtocol.WEB_DIALOG_PARAMS) || !(getIntent().getSerializableExtra(NativeProtocol.WEB_DIALOG_PARAMS) instanceof com.tencent.wxa.d.a)) {
            AppMethodBeat.o(197746);
            return null;
        }
        Map map = ((com.tencent.wxa.d.a) getIntent().getSerializableExtra(NativeProtocol.WEB_DIALOG_PARAMS)).map;
        if (this.crp) {
            map.put("transparent", Boolean.valueOf(this.crp));
        }
        AppMethodBeat.o(197746);
        return map;
    }

    public final void KT() {
        AppMethodBeat.i(197747);
        if (getIntent().hasExtra("LiteApp")) {
            this.cro = (WxaLiteAppInfo) getIntent().getParcelableExtra("LiteApp");
        }
        AppMethodBeat.o(197747);
    }

    @Override // io.flutter.embedding.android.e, com.tencent.wxa.ui.a.AbstractC2229a
    public final void b(io.flutter.embedding.engine.a aVar) {
    }

    @Override // io.flutter.embedding.android.e
    public final void c(io.flutter.embedding.engine.a aVar) {
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(197721);
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (activityInfo.metaData != null) {
                int i2 = activityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i2 != -1) {
                    setTheme(i2);
                }
            } else {
                io.flutter.a.hwe();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            io.flutter.a.hwg();
        }
        super.onCreate(bundle);
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.crn = new a(this);
        this.crn.hrO();
        setContentView(KE());
        AppMethodBeat.o(197721);
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KL() {
        boolean z;
        String dataString;
        AppMethodBeat.i(197739);
        if ((getApplicationInfo().flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            String findAppBundlePath = FlutterMain.findAppBundlePath();
            AppMethodBeat.o(197739);
            return findAppBundlePath;
        }
        AppMethodBeat.o(197739);
        return dataString;
    }

    @Override // com.tencent.wxa.b.b
    public final void bP(boolean z) {
        AppMethodBeat.i(197748);
        this.hfl.setEnableGesture(!z);
        AppMethodBeat.o(197748);
    }
}
