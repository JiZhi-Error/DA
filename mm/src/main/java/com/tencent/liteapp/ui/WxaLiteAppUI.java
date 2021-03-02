package com.tencent.liteapp.ui;

import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.liteapp.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ext.ui.SwipeBackLayout;
import com.tencent.mm.ext.ui.e;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.wxa.c;
import com.tencent.wxa.c.a;
import com.tencent.wxa.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxaLiteAppUI extends WxaLiteAppBaseUI implements a, LiteAppCenter.ILiteAppUICallback {
    int FV = -1;
    public String appId = "";
    long appPtr = -1;
    private b crA;
    private final b.c crB = new b.c() {
        /* class com.tencent.liteapp.ui.WxaLiteAppUI.AnonymousClass1 */
        private int crC = 0;
        private boolean crD = false;

        @Override // com.tencent.liteapp.d.b.c
        public final void hF(int i2) {
            AppMethodBeat.i(197750);
            int[] iArr = new int[2];
            WxaLiteAppUI.this.mContentView.getLocationInWindow(iArr);
            this.crC = iArr[1] + i2;
            com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "keyboardStateChange h=%d mSavedKeyboardHeight=%d", Integer.valueOf(i2), Integer.valueOf(this.crC));
            if (this.crD) {
                d.G("notifyKeyboardChanged", e(true, this.crC));
            }
            AppMethodBeat.o(197750);
        }

        @Override // com.tencent.liteapp.d.b.c
        public final void bQ(boolean z) {
            AppMethodBeat.i(197751);
            this.crD = z;
            com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "keyboardStateChange shown=%b h=%d", Boolean.valueOf(z), Integer.valueOf(this.crC));
            d.G("notifyKeyboardChanged", e(z, this.crC));
            AppMethodBeat.o(197751);
        }

        @Override // com.tencent.liteapp.d.b.c
        public final int getHeight() {
            return this.crC;
        }

        private static Map e(boolean z, int i2) {
            AppMethodBeat.i(197752);
            HashMap hashMap = new HashMap();
            hashMap.put("shown", Boolean.valueOf(z));
            hashMap.put("height", Integer.valueOf(i2));
            AppMethodBeat.o(197752);
            return hashMap;
        }
    };
    boolean crr = true;
    int crs = -1;
    int crt = -1;
    boolean cru = false;
    boolean crv = false;
    long crw = -1;
    int crx = -1;
    int cry = -1;
    LiteAppCenter.PageInfo crz;
    FrameLayout mContentView;
    long pageId = -1;

    public WxaLiteAppUI() {
        AppMethodBeat.i(197757);
        AppMethodBeat.o(197757);
    }

    static /* synthetic */ void a(WxaLiteAppUI wxaLiteAppUI, int i2) {
        AppMethodBeat.i(197781);
        wxaLiteAppUI.hE(i2);
        AppMethodBeat.o(197781);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(197758);
        super.onConfigurationChanged(configuration);
        boolean isDarkMode = isDarkMode();
        if (isDarkMode != this.crv) {
            com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "DarkMode change %b", Boolean.valueOf(isDarkMode));
            this.crv = isDarkMode;
            LiteAppCenter.updateDarkMode(this.crv);
        }
        AppMethodBeat.o(197758);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.liteapp.ui.WxaLiteAppBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(197759);
        if (getIntent().hasExtra("bundle")) {
            Bundle bundleExtra = getIntent().getBundleExtra("bundle");
            if (bundleExtra != null && (bundleExtra.containsKey("nextAnimIn") || bundleExtra.containsKey("currentAnimOut"))) {
                this.crx = bundleExtra.getInt("nextAnimIn", 0);
                this.cry = bundleExtra.getInt("currentAnimOut", 0);
                overridePendingTransition(this.crx, R.anim.s);
            }
            if (bundleExtra.containsKey("transparent")) {
                this.crp = bundleExtra.getBoolean("transparent", false);
            }
        }
        if (c.hrH().SxE != null) {
            z = true;
        } else {
            a.i("WxaRouter.WxaRouter", "please setup wxa router config first!!", new Object[0]);
            z = false;
        }
        if (!z) {
            com.tencent.liteapp.b.b.w("WxaLiteApp.WxaLiteAppUI", "WxaRouter Config has no setup. finish.", new Object[0]);
            finish();
        }
        c.hrH().init();
        this.crv = isDarkMode();
        LiteAppCenter.updateDarkMode(this.crv);
        String stringExtra = getIntent().getStringExtra(SearchIntents.EXTRA_QUERY);
        String stringExtra2 = getIntent().getStringExtra("page");
        KT();
        if (this.cro != null) {
            this.appId = this.cro.appId;
            com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo", new Object[0]);
            com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo start showIndexView", new Object[0]);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (TextUtils.isEmpty(stringExtra2)) {
                this.crz = LiteAppCenter.showIndexView(this.cro.appId, this.cro.path, this.cro.crh, stringExtra);
            } else {
                this.crz = LiteAppCenter.showView(this.cro.appId, stringExtra2, stringExtra, this.cro.path, this.cro.crh);
            }
            com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo end showIndexView use %d", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
            if (this.crz != null) {
                this.appPtr = this.crz.appPtr;
                this.pageId = this.crz.pageId;
                this.crw = this.crz.appUuid;
                com.tencent.liteapp.b.b.d("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo pageInfo %s", this.crz.toString());
            } else {
                com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "Use WxaLiteAppInfo fail, pageInfo is null.", new Object[0]);
            }
        }
        Map KS = KS();
        if (KS != null) {
            if (KS.containsKey("startTime")) {
                Long.valueOf(KS.get("startTime").toString()).longValue();
                System.currentTimeMillis();
            }
            if (KS.containsKey("appId")) {
                this.appId = String.valueOf(KS.get("appId"));
            }
            if (KS.containsKey("appPtr")) {
                this.appPtr = Long.valueOf(KS.get("appPtr").toString()).longValue();
            }
            if (KS.containsKey("pageViewId")) {
                this.pageId = Long.valueOf(KS.get("pageViewId").toString()).longValue();
            }
            if (KS.containsKey("activityId")) {
                this.crw = Long.valueOf(KS.get("activityId").toString()).longValue();
            }
        }
        super.onCreate(bundle);
        if (KS != null) {
            int i2 = -1;
            if (KS.containsKey("flags")) {
                try {
                    i2 = Integer.parseInt(KS.get("flags").toString());
                } catch (Exception e2) {
                }
            }
            this.FV = i2;
        }
        getWindow().clearFlags(67108864);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(getResources().getColor(R.color.ac9));
        getWindow().clearFlags(201326592);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.ac9));
        getWindow().setFlags(TPMediaCodecProfileLevel.HEVCMainTierLevel62, TPMediaCodecProfileLevel.HEVCMainTierLevel62);
        if (Build.VERSION.SDK_INT > 28) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
        }
        this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.liteapp.ui.WxaLiteAppUI.AnonymousClass2 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(197753);
                WxaLiteAppUI.this.mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                WxaLiteAppUI.a(WxaLiteAppUI.this);
                AppMethodBeat.o(197753);
            }
        });
        this.crA = com.tencent.liteapp.d.a.bX(this.mContentView);
        b bVar = this.crA;
        b.c cVar = this.crB;
        if (cVar != null && !bVar.crY.contains(cVar)) {
            bVar.crY.add(cVar);
        }
        setRequestedOrientation(1);
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        this.hfl = (SwipeBackLayout) LayoutInflater.from(this).inflate(R.layout.cd1, viewGroup, false);
        this.hfl.init();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        View childAt = viewGroup.getChildAt(0);
        childAt.setBackgroundResource(17170445);
        viewGroup.removeView(childAt);
        this.hfl.addView(childAt);
        this.hfl.setContentView(childAt);
        viewGroup.addView(this.hfl);
        this.hfl.setSwipeGestureDelegate(this);
        AppMethodBeat.o(197759);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(197760);
        super.finish();
        if (this.cry >= 0) {
            overridePendingTransition(R.anim.s, this.cry);
        }
        AppMethodBeat.o(197760);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.liteapp.ui.WxaLiteAppBaseUI
    public final View KE() {
        AppMethodBeat.i(197761);
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "initView", new Object[0]);
        View KE = super.KE();
        this.mContentView = new com.tencent.liteapp.d.a(this, KE);
        this.mContentView.addView(KE, 0, new ViewGroup.LayoutParams(-1, -1));
        FrameLayout frameLayout = this.mContentView;
        AppMethodBeat.o(197761);
        return frameLayout;
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.liteapp.ui.WxaLiteAppBaseUI, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(197762);
        super.onStart();
        LiteAppCenter.setUICallback(this.appPtr, this);
        AppMethodBeat.o(197762);
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.liteapp.ui.WxaLiteAppBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(197763);
        super.onResume();
        AppMethodBeat.o(197763);
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.liteapp.ui.WxaLiteAppBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(197764);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        if (z) {
            hE(this.FV);
        }
        AppMethodBeat.o(197764);
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.liteapp.ui.WxaLiteAppBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(197765);
        super.onPause();
        AppMethodBeat.o(197765);
    }

    @Override // com.tencent.mm.ext.ui.SwipeBackActivity, com.tencent.liteapp.ui.WxaLiteAppBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(197766);
        if (this.crA != null) {
            b bVar = this.crA;
            b.c cVar = this.crB;
            if (cVar != null) {
                bVar.crY.remove(cVar);
            }
        }
        super.onDestroy();
        LiteAppCenter.unsetUICallback(this.appPtr, this);
        AppMethodBeat.o(197766);
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback
    public void setFlags(final int i2) {
        AppMethodBeat.i(197767);
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "setFlags %d old=%d", Integer.valueOf(i2), Integer.valueOf(this.FV));
        if (this.FV == i2) {
            AppMethodBeat.o(197767);
            return;
        }
        runOnUiThread(new Runnable() {
            /* class com.tencent.liteapp.ui.WxaLiteAppUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(197754);
                WxaLiteAppUI.a(WxaLiteAppUI.this, i2);
                AppMethodBeat.o(197754);
            }
        });
        AppMethodBeat.o(197767);
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback
    public boolean hasCutOut() {
        AppMethodBeat.i(197768);
        boolean aQ = e.aQ(this);
        AppMethodBeat.o(197768);
        return aQ;
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback
    public void showPage(final LiteAppCenter.PageInfo pageInfo) {
        AppMethodBeat.i(197769);
        runOnUiThread(new Runnable() {
            /* class com.tencent.liteapp.ui.WxaLiteAppUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(197755);
                WxaLiteAppUI.this.setFlags(pageInfo.flags);
                AppMethodBeat.o(197755);
            }
        });
        AppMethodBeat.o(197769);
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback, com.tencent.liteapp.ui.a
    public void navigateBack() {
        AppMethodBeat.i(197770);
        new Handler(getMainLooper()).post(new Runnable() {
            /* class com.tencent.liteapp.ui.WxaLiteAppUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(197756);
                WxaLiteAppUI.this.onBackPressed();
                AppMethodBeat.o(197756);
            }
        });
        AppMethodBeat.o(197770);
    }

    @Override // com.tencent.liteapp.ui.a
    public final void hD(int i2) {
        AppMethodBeat.i(197771);
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "inputLocationChange %d", Integer.valueOf(i2));
        this.mContentView.scrollTo(this.mContentView.getScrollX(), i2);
        AppMethodBeat.o(197771);
    }

    @Override // com.tencent.liteapp.ui.a
    public final void hideKeyboard() {
        AppMethodBeat.i(197772);
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mContentView.getWindowToken(), 0);
        AppMethodBeat.o(197772);
    }

    @Override // com.tencent.mm.plugin.lite.LiteAppCenter.ILiteAppUICallback
    public void onCheckSumFail(String str, List<String> list) {
    }

    private void hE(int i2) {
        int i3;
        AppMethodBeat.i(197773);
        this.FV = i2;
        this.cru = false;
        if (this.crs > 0) {
            getWindow().clearFlags(this.crs);
            this.crs = -1;
        }
        int i4 = 1792;
        if (i2 == 5) {
            i4 = 5892;
        } else if (i2 == 7) {
            i4 = 5894;
        }
        if (this.crv) {
            i3 = i4 & -8209;
        } else {
            i3 = i4 | 8208;
        }
        if (!(getWindow() == null || getWindow().getDecorView() == null)) {
            getWindow().getDecorView().setSystemUiVisibility(i3);
        }
        AppMethodBeat.o(197773);
    }

    @Override // com.tencent.liteapp.ui.a
    public final void KD() {
        AppMethodBeat.i(197774);
        this.crt = this.FV;
        hE(7);
        AppMethodBeat.o(197774);
    }

    @Override // com.tencent.liteapp.ui.a
    public final void KC() {
        AppMethodBeat.i(197775);
        hE(this.crt);
        AppMethodBeat.o(197775);
    }

    @Override // com.tencent.liteapp.ui.WxaLiteAppBaseUI, com.tencent.wxa.b.b
    public final String KQ() {
        AppMethodBeat.i(197776);
        com.tencent.liteapp.b.b.d("WxaLiteApp.WxaLiteAppUI", "getFlutterViewId %s", Long.valueOf(this.crw));
        String valueOf = String.valueOf(this.crw);
        AppMethodBeat.o(197776);
        return valueOf;
    }

    @Override // com.tencent.liteapp.ui.WxaLiteAppBaseUI, com.tencent.wxa.b.b
    public final String KR() {
        AppMethodBeat.i(197777);
        String valueOf = String.valueOf(this.pageId);
        AppMethodBeat.o(197777);
        return valueOf;
    }

    @Override // com.tencent.liteapp.ui.WxaLiteAppBaseUI, com.tencent.wxa.b.b
    public final Map KS() {
        AppMethodBeat.i(197778);
        if (this.crz != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("activityId", Long.valueOf(this.crz.appUuid));
            hashMap.put("appId", this.cro.appId);
            hashMap.put("appPtr", Long.valueOf(this.crz.appPtr));
            hashMap.put("pageViewId", Long.valueOf(this.crz.pageId));
            hashMap.put("basePath", this.crz.basePath);
            hashMap.put("pageRenderPtr", Long.valueOf(this.crz.renderId));
            hashMap.put("flags", Integer.valueOf(this.crz.flags));
            hashMap.put("startTime", Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(197778);
            return hashMap;
        }
        Map KS = super.KS();
        AppMethodBeat.o(197778);
        return KS;
    }

    public boolean isDarkMode() {
        AppMethodBeat.i(197779);
        boolean f2 = e.f(getResources());
        AppMethodBeat.o(197779);
        return f2;
    }

    static /* synthetic */ void a(WxaLiteAppUI wxaLiteAppUI) {
        AppMethodBeat.i(197780);
        Point az = e.az(wxaLiteAppUI.getContext());
        DisplayMetrics displayMetrics = wxaLiteAppUI.getContext().getResources().getDisplayMetrics();
        int i2 = az.x;
        int i3 = az.y;
        float f2 = displayMetrics.density;
        int aD = com.tencent.liteapp.d.e.aD(wxaLiteAppUI);
        LiteAppCenter.setDisplayParams(((float) i2) / f2, ((float) i3) / f2, ((float) az.x) / f2, ((float) az.y) / f2, displayMetrics.densityDpi, f2, (48.0f * f2) / f2, ((float) com.tencent.liteapp.d.e.ay(wxaLiteAppUI)) / f2, ((float) aD) / f2);
        com.tencent.liteapp.b.b.i("WxaLiteApp.WxaLiteAppUI", "updateLvCppDisplayParams SetDisplayParams w=%d h=%d screen=%d,%d densityDpi=%d density=%f", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(az.x), Integer.valueOf(az.y), Integer.valueOf(displayMetrics.densityDpi), Float.valueOf(displayMetrics.density));
        AppMethodBeat.o(197780);
    }
}
