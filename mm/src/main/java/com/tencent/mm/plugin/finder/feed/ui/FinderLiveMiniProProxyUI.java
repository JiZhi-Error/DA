package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.live.viewmodel.d;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.b;
import java.util.HashMap;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0014J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\bH\u0014J\b\u0010\u001e\u001a\u00020\bH\u0014J\b\u0010\u001f\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0014J\b\u0010!\u001a\u00020\bH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveMiniProProxyUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkIntentState", "", "enableActivityAnimation", "", "finish", "getLayoutId", "", f.NAME, "context", "Landroid/content/Context;", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStart", "onStop", "setWindowStyle", "Companion", "plugin-finder_release"})
public final class FinderLiveMiniProProxyUI extends MMFinderUI {
    private static final int DEFAULT = 0;
    private static final String ubu = ubu;
    private static final String ubv = ubv;
    private static final int ubw = 1;
    private static final int ubx = 2;
    private static final int uby = 3;
    public static final a ubz = new a((byte) 0);
    final String TAG = "FinderLive.MiniProProxyUI";
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245387);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245387);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245386);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245386);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveMiniProProxyUI$Companion;", "", "()V", FinderLiveMiniProProxyUI.ubu, "", "getACTIVITY_PURPOSE", "()Ljava/lang/String;", "DEFAULT", "", "getDEFAULT", "()I", "FINISH_AND_MOVE_BACK", "getFINISH_AND_MOVE_BACK", "FINISH_WITH_CLEAR_TOP", "getFINISH_WITH_CLEAR_TOP", FinderLiveMiniProProxyUI.ubv, "getLUANCH_KEY", "LUANCH_MINI_PROGRAM", "getLUANCH_MINI_PROGRAM", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245385);
        AppMethodBeat.o(245385);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.af3;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245373);
        Log.i(this.TAG, "onCreate");
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(67108864);
            Window window = getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            decorView.setSystemUiVisibility(1792);
            getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = getWindow();
            p.g(window2, "window");
            window2.setStatusBarColor(0);
            Window window3 = getWindow();
            p.g(window3, "window");
            window3.setNavigationBarColor(0);
        }
        getWindow().setFormat(-3);
        getWindow().setSoftInputMode(51);
        com.tencent.mm.ui.base.b.a(this, new b(this));
        AppMethodBeat.o(245373);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onComplete"})
    static final class b implements b.AbstractC2081b {
        final /* synthetic */ FinderLiveMiniProProxyUI ubA;

        b(FinderLiveMiniProProxyUI finderLiveMiniProProxyUI) {
            this.ubA = finderLiveMiniProProxyUI;
        }

        @Override // com.tencent.mm.ui.base.b.AbstractC2081b
        public final void ei(boolean z) {
            AppMethodBeat.i(245372);
            Log.i(this.ubA.TAG, "convertActivityToTranslucent complete:".concat(String.valueOf(z)));
            AppMethodBeat.o(245372);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStart() {
        AppMethodBeat.i(245374);
        Log.i(this.TAG, "onStart");
        super.onStart();
        AppMethodBeat.o(245374);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(245375);
        Log.i(this.TAG, "onNewIntent");
        super.onNewIntent(intent);
        deb();
        AppMethodBeat.o(245375);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245376);
        Log.i(this.TAG, "onResume");
        super.onResume();
        deb();
        AppMethodBeat.o(245376);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(245377);
        Log.i(this.TAG, "onPause");
        super.onPause();
        AppMethodBeat.o(245377);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(245378);
        Log.i(this.TAG, "onStop");
        super.onStop();
        AppMethodBeat.o(245378);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245379);
        Log.i(this.TAG, "onDestroy");
        super.onDestroy();
        AppMethodBeat.o(245379);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(245380);
        Log.i(this.TAG, "finish");
        super.finish();
        AppMethodBeat.o(245380);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(245381);
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Log.i(this.TAG, "onConfigurationChanged orientation:" + configuration.orientation);
        AppMethodBeat.o(245381);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean enableActivityAnimation() {
        AppMethodBeat.i(245382);
        Intent intent = getIntent();
        if (intent == null || intent.getIntExtra(ubu, DEFAULT) != ubw) {
            boolean enableActivityAnimation = super.enableActivityAnimation();
            AppMethodBeat.o(245382);
            return enableActivityAnimation;
        }
        AppMethodBeat.o(245382);
        return false;
    }

    private final void b(Context context, g gVar) {
        AppMethodBeat.i(245383);
        Log.i(this.TAG, "launchMiniProgram appid:" + gVar.appId + ", path:" + gVar.kHw);
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(context, gVar);
        AppMethodBeat.o(245383);
    }

    private final void deb() {
        boolean z;
        Integer num = null;
        AppMethodBeat.i(245384);
        Intent intent = getIntent();
        Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra(ubu, DEFAULT)) : null;
        Log.i(this.TAG, "[checkIntentState] purpose = ".concat(String.valueOf(valueOf)));
        int i2 = ubw;
        if (valueOf != null && valueOf.intValue() == i2) {
            Intent intent2 = getIntent();
            if (intent2 != null) {
                num = Integer.valueOf(intent2.getIntExtra(ubv, 0));
            }
            d.a aVar = d.uCw;
            HashMap hashMap = d.uCv;
            if (hashMap == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                AppMethodBeat.o(245384);
                throw tVar;
            }
            g gVar = (g) af.fd(hashMap).remove(num);
            String str = this.TAG;
            StringBuilder append = new StringBuilder("[LUANCH_MINI_PROGRAM] key = ").append(num).append(",bundle is null:");
            if (gVar == null) {
                z = true;
            } else {
                z = false;
            }
            Log.i(str, append.append(z).toString());
            if (gVar != null) {
                b(this, gVar);
                AppMethodBeat.o(245384);
                return;
            }
            finish();
            AppMethodBeat.o(245384);
            return;
        }
        int i3 = ubx;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i4 = uby;
            if (valueOf != null && valueOf.intValue() == i4) {
                moveTaskToBack(true);
            }
        }
        finish();
        AppMethodBeat.o(245384);
    }
}
