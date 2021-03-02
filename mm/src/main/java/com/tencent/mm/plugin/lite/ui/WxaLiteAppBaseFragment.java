package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.liteapp.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import com.tencent.wxa.b.b;
import com.tencent.wxa.c;
import com.tencent.wxa.ui.a;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.d;
import io.flutter.embedding.android.j;
import io.flutter.view.FlutterMain;
import java.util.HashMap;
import java.util.Map;

public class WxaLiteAppBaseFragment extends Fragment implements LifecycleOwner, a, b, a.AbstractC2229a {
    protected String crm;
    protected com.tencent.wxa.ui.a crn;
    HashMap<String, Object> mMap = new HashMap<>();
    String mName;
    View yFg;
    a yFh;

    @Override // com.tencent.wxa.b.b, android.support.v4.app.Fragment, com.tencent.wxa.ui.a.AbstractC2229a
    public final /* bridge */ /* synthetic */ Activity getActivity() {
        AppMethodBeat.i(198935);
        FragmentActivity activity = super.getActivity();
        AppMethodBeat.o(198935);
        return activity;
    }

    public WxaLiteAppBaseFragment() {
        AppMethodBeat.i(198908);
        AppMethodBeat.o(198908);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(198909);
        super.onCreate(bundle);
        this.crn = new com.tencent.wxa.ui.a(this);
        com.tencent.wxa.ui.a aVar = this.crn;
        getContext();
        aVar.hrO();
        Bundle arguments = getArguments();
        String string = arguments.getString("appId");
        LiteAppCenter.PageInfo showIndexView = LiteAppCenter.showIndexView(string, s.k(arguments.getString("pkgPath"), false), arguments.getString("signatureKey"), "");
        this.mMap.put("appId", string);
        this.mMap.put("appPtr", Long.valueOf(showIndexView.appPtr));
        this.mMap.put("pageViewId", Long.valueOf(showIndexView.pageId));
        this.mMap.put("basePath", showIndexView.basePath);
        this.mMap.put("pageRenderPtr", Long.valueOf(showIndexView.renderId));
        this.mMap.put("startTime", Long.valueOf(System.currentTimeMillis()));
        this.mName = Long.toString(showIndexView.pageId);
        AppMethodBeat.o(198909);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        AppMethodBeat.i(198910);
        Log.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "onAttach");
        super.onAttach(context);
        AppMethodBeat.o(198910);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        AppMethodBeat.i(198911);
        Log.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "onDetach");
        super.onDetach();
        AppMethodBeat.o(198911);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        AppMethodBeat.i(198912);
        Log.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "onStart");
        super.onStart();
        this.crn.onStart();
        AppMethodBeat.o(198912);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        AppMethodBeat.i(198913);
        super.onResume();
        this.crn.onResume();
        AppMethodBeat.o(198913);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        AppMethodBeat.i(198914);
        super.onPause();
        this.crn.onPause();
        AppMethodBeat.o(198914);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        AppMethodBeat.i(198915);
        super.onStop();
        this.crn.onStop();
        AppMethodBeat.o(198915);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        AppMethodBeat.i(198916);
        super.onDestroy();
        this.crn.onDestroyView();
        com.tencent.wxa.ui.a aVar = this.crn;
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onCloseView()", new Object[0]);
        aVar.Sye.hrN();
        this.crn.onDetach();
        AppMethodBeat.o(198916);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(198917);
        this.crn.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(198917);
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(198918);
        this.crn.onRequestPermissionsResult(i2, strArr, iArr);
        AppMethodBeat.o(198918);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(198919);
        this.yFg = this.crn.hrQ();
        this.yFg.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.lite.ui.WxaLiteAppBaseFragment.AnonymousClass1 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(198907);
                Point az = ao.az(WxaLiteAppBaseFragment.this.getContext());
                WxaLiteAppBaseFragment.this.yFg.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                DisplayMetrics displayMetrics = WxaLiteAppBaseFragment.this.getContext().getResources().getDisplayMetrics();
                int width = WxaLiteAppBaseFragment.this.yFg.getWidth();
                int height = WxaLiteAppBaseFragment.this.yFg.getHeight();
                float f2 = displayMetrics.density;
                float f3 = 48.0f * f2;
                LiteAppCenter.setDisplayParams(((float) width) / f2, ((float) height) / f2, ((float) az.x) / f2, ((float) az.y) / f2, displayMetrics.densityDpi, f2, f3 / f2, 0.0f, 0.0f);
                Log.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "SetDisplayParams w=%d h=%d screen=%d,%d actionBar=%f densityDpi=%d density=%f", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(az.x), Integer.valueOf(az.y), Float.valueOf(f3), Integer.valueOf(displayMetrics.densityDpi), Float.valueOf(displayMetrics.density));
                AppMethodBeat.o(198907);
            }
        });
        this.yFh = new a(getContext());
        this.yFh.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR));
        this.yFh.addView(this.yFg);
        a aVar = this.yFh;
        AppMethodBeat.o(198919);
        return aVar;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final b KI() {
        return this;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KJ() {
        AppMethodBeat.i(198920);
        String stringExtra = getActivity().getIntent().getStringExtra("cached_engine_id");
        AppMethodBeat.o(198920);
        return stringExtra;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KK() {
        AppMethodBeat.i(198921);
        if (getActivity().getIntent().hasExtra("dart_entrypoint")) {
            String stringExtra = getActivity().getIntent().getStringExtra("dart_entrypoint");
            AppMethodBeat.o(198921);
            return stringExtra;
        }
        try {
            Bundle bundle = getActivity().getPackageManager().getActivityInfo(getActivity().getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.Entrypoint") : null;
            if (string != null) {
                AppMethodBeat.o(198921);
                return string;
            }
            AppMethodBeat.o(198921);
            return "main";
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(198921);
            return "main";
        }
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KL() {
        AppMethodBeat.i(198922);
        String findAppBundlePath = FlutterMain.findAppBundlePath();
        AppMethodBeat.o(198922);
        return findAppBundlePath;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final String KM() {
        AppMethodBeat.i(198923);
        if (getActivity().getIntent().hasExtra("initial_route")) {
            String stringExtra = getActivity().getIntent().getStringExtra("initial_route");
            AppMethodBeat.o(198923);
            return stringExtra;
        }
        try {
            Bundle bundle = getActivity().getPackageManager().getActivityInfo(getActivity().getComponentName(), 128).metaData;
            String string = bundle != null ? bundle.getString("io.flutter.InitialRoute") : null;
            if (string != null) {
                AppMethodBeat.o(198923);
                return string;
            }
            AppMethodBeat.o(198923);
            return FilePathGenerator.ANDROID_DIR_SEP;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(198923);
            return FilePathGenerator.ANDROID_DIR_SEP;
        }
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final FlutterView.b KN() {
        AppMethodBeat.i(198924);
        if (KH() == d.a.opaque) {
            FlutterView.b bVar = FlutterView.b.surface;
            AppMethodBeat.o(198924);
            return bVar;
        }
        FlutterView.b bVar2 = FlutterView.b.texture;
        AppMethodBeat.o(198924);
        return bVar2;
    }

    @Override // com.tencent.wxa.ui.a.AbstractC2229a
    public final FlutterView.c KO() {
        AppMethodBeat.i(198925);
        if (KH() == d.a.opaque) {
            FlutterView.c cVar = FlutterView.c.opaque;
            AppMethodBeat.o(198925);
            return cVar;
        }
        FlutterView.c cVar2 = FlutterView.c.transparent;
        AppMethodBeat.o(198925);
        return cVar2;
    }

    @Override // io.flutter.embedding.android.f, com.tencent.wxa.ui.a.AbstractC2229a
    public final io.flutter.embedding.engine.a KP() {
        AppMethodBeat.i(198926);
        io.flutter.embedding.engine.a aVar = c.hrH().SxF;
        AppMethodBeat.o(198926);
        return aVar;
    }

    @Override // io.flutter.embedding.android.k, com.tencent.wxa.ui.a.AbstractC2229a
    public final j KF() {
        AppMethodBeat.i(198927);
        Drawable KG = KG();
        if (KG != null) {
            DrawableSplashScreen drawableSplashScreen = new DrawableSplashScreen(KG);
            AppMethodBeat.o(198927);
            return drawableSplashScreen;
        }
        AppMethodBeat.o(198927);
        return null;
    }

    private Drawable KG() {
        Integer num;
        AppMethodBeat.i(198928);
        try {
            Bundle bundle = getActivity().getPackageManager().getActivityInfo(getActivity().getComponentName(), 128).metaData;
            if (bundle != null) {
                num = Integer.valueOf(bundle.getInt("io.flutter.embedding.android.SplashScreenDrawable"));
            } else {
                num = null;
            }
            if (num == null) {
                AppMethodBeat.o(198928);
                return null;
            } else if (Build.VERSION.SDK_INT > 21) {
                Drawable drawable = getResources().getDrawable(num.intValue(), getActivity().getTheme());
                AppMethodBeat.o(198928);
                return drawable;
            } else {
                Drawable drawable2 = getResources().getDrawable(num.intValue());
                AppMethodBeat.o(198928);
                return drawable2;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(198928);
            return null;
        }
    }

    @Override // io.flutter.embedding.android.e, com.tencent.wxa.ui.a.AbstractC2229a
    public final void b(io.flutter.embedding.engine.a aVar) {
    }

    @Override // io.flutter.embedding.android.e
    public final void c(io.flutter.embedding.engine.a aVar) {
    }

    @Override // com.tencent.wxa.b.b
    public final String KQ() {
        AppMethodBeat.i(198929);
        if (!getActivity().getIntent().hasExtra("activityId") || Util.isNullOrNil(getActivity().getIntent().getStringExtra("activityId"))) {
            if (Util.isNullOrNil(this.crm)) {
                this.crm = String.format("%d-%d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()));
            }
            String str = this.crm;
            AppMethodBeat.o(198929);
            return str;
        }
        String stringExtra = getActivity().getIntent().getStringExtra("activityId");
        AppMethodBeat.o(198929);
        return stringExtra;
    }

    @Override // com.tencent.wxa.b.b
    public final String KR() {
        return this.mName;
    }

    @Override // com.tencent.wxa.b.b
    public final Map KS() {
        return this.mMap;
    }

    @Override // com.tencent.wxa.b.b
    public final void bP(boolean z) {
    }

    private d.a KH() {
        AppMethodBeat.i(198930);
        if (getActivity().getIntent().hasExtra("background_mode")) {
            d.a valueOf = d.a.valueOf(getActivity().getIntent().getStringExtra("background_mode"));
            AppMethodBeat.o(198930);
            return valueOf;
        }
        d.a aVar = d.a.opaque;
        AppMethodBeat.o(198930);
        return aVar;
    }

    @Override // com.tencent.liteapp.ui.a
    public final void hD(int i2) {
        AppMethodBeat.i(198931);
        Log.i("MicroMsg.LiteApp.WxaLiteAppBaseFragment", "inputLocationChange %d", Integer.valueOf(i2));
        View decorView = getActivity().getWindow().getDecorView();
        decorView.scrollTo(decorView.getScrollX(), i2);
        AppMethodBeat.o(198931);
    }

    @Override // com.tencent.liteapp.ui.a
    public final void hideKeyboard() {
        AppMethodBeat.i(198932);
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
        AppMethodBeat.o(198932);
    }

    @Override // com.tencent.liteapp.ui.a
    public final void KD() {
        AppMethodBeat.i(198933);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            getActivity().getWindow().setFlags(201327616, 201327616);
            View decorView = getActivity().getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4098);
            AppMethodBeat.o(198933);
            return;
        }
        getActivity().getWindow().setFlags(1024, 1024);
        AppMethodBeat.o(198933);
    }

    @Override // com.tencent.liteapp.ui.a
    public final void KC() {
        AppMethodBeat.i(198934);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            getActivity().getWindow().clearFlags(201327616);
            View decorView = getActivity().getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -3 & -4097);
            AppMethodBeat.o(198934);
            return;
        }
        getActivity().getWindow().clearFlags(1024);
        AppMethodBeat.o(198934);
    }

    @Override // com.tencent.liteapp.ui.a
    public void navigateBack() {
    }
}
