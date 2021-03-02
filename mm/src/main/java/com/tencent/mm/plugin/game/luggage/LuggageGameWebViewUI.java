package com.tencent.mm.plugin.game.luggage;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.m;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.r;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.game.luggage.g.e;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.game.luggage.g.j;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.lang.reflect.Field;

public class LuggageGameWebViewUI extends MMSecDataActivity implements f.e {
    protected e xwg;
    private int xwh = -1;
    private boolean xwi = true;
    protected com.tencent.mm.plugin.game.luggage.g.f xwj;

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        GameFloatLayerInfo gameFloatLayerInfo;
        boolean z2;
        AppMethodBeat.i(82996);
        super.onCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra("from_shortcut", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("from_game_tab", false);
        if (!booleanExtra) {
            if (!Util.isNullOrNil(getIntent().getStringExtra("float_ball_key"))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !booleanExtra2) {
                overridePendingTransition(MMFragmentActivity.a.OHB, MMFragmentActivity.a.OHC);
            }
        }
        AppBrandMainProcessService.a(new ActiveMainProcessTask());
        Log.i("MicroMsg.LuggageGameWebViewUI", "onCreate, startTime: %d, now: %d", Long.valueOf(getIntent().getLongExtra("start_activity_time", System.currentTimeMillis())), Long.valueOf(System.currentTimeMillis()));
        final String stringExtra = getIntent().getStringExtra("rawUrl");
        if (Util.isNullOrNil(stringExtra)) {
            Log.e("MicroMsg.LuggageGameWebViewUI", "url is null");
            AppMethodBeat.o(82996);
            return;
        }
        if (((q) g.af(q.class)).Vt()) {
            getIntent().putExtra("rawUrl", "http://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode");
            stringExtra = "http://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode";
        }
        GameWebPerformanceInfo Fd = GameWebPerformanceInfo.Fd(stringExtra);
        Fd.url = stringExtra;
        Fd.hhE = getIntent().getLongExtra("gamecenterui_createtime", 0);
        Fd.hhF = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        Fd.startTime = getIntent().getLongExtra("start_time", Fd.hhF);
        Fd.hhK = System.currentTimeMillis();
        Fd.hhv = 1;
        Fd.hhy = 1;
        Log.i("MicroMsg.LuggageGameWebViewUI", "url: %s, __Time__， startTime: %d, gamecenterCreate: %d,startWebUI: %d, webUICreate: %d", stringExtra, Long.valueOf(Fd.startTime), Long.valueOf(Fd.hhE), Long.valueOf(Fd.hhF), Long.valueOf(Fd.hhK));
        com.tencent.mm.plugin.webview.ui.tools.game.g.baJ(stringExtra);
        com.tencent.mm.plugin.webview.ui.tools.game.g.bC(stringExtra, System.currentTimeMillis());
        com.tencent.mm.plugin.webview.ui.tools.game.g.bB(stringExtra, System.currentTimeMillis());
        com.tencent.mm.plugin.webview.ui.tools.game.g.bK(stringExtra, Fd.startTime);
        if (Build.VERSION.SDK_INT >= 11) {
            getWindow().setFlags(TPMediaCodecProfileLevel.HEVCMainTierLevel62, TPMediaCodecProfileLevel.HEVCMainTierLevel62);
        }
        getWindow().setFormat(-3);
        this.xwg = new e(this);
        dTl();
        this.xwg.xxP = new e.a() {
            /* class com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.game.luggage.g.e.a
            public final void dTp() {
                AppMethodBeat.i(186830);
                if (LuggageGameWebViewUI.this.xwj != null) {
                    LuggageGameWebViewUI.this.xwj.setPageChanging(true);
                }
                AppMethodBeat.o(186830);
            }

            @Override // com.tencent.mm.plugin.game.luggage.g.e.a
            public final void dTq() {
                AppMethodBeat.i(186831);
                if (LuggageGameWebViewUI.this.xwj != null) {
                    LuggageGameWebViewUI.this.xwj.setPageChanging(false);
                }
                AppMethodBeat.o(186831);
            }

            @Override // com.tencent.mm.plugin.game.luggage.g.e.a
            public final boolean Lw() {
                AppMethodBeat.i(186832);
                if (LuggageGameWebViewUI.this.xwj != null) {
                    com.tencent.mm.plugin.game.luggage.g.f fVar = LuggageGameWebViewUI.this.xwj;
                    if (fVar.xxS != null) {
                        boolean Lw = fVar.xxS.Lw();
                        AppMethodBeat.o(186832);
                        return Lw;
                    }
                    AppMethodBeat.o(186832);
                    return true;
                }
                AppMethodBeat.o(186832);
                return true;
            }
        };
        this.xwg.a(new m() {
            /* class com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI.AnonymousClass2 */

            @Override // com.tencent.luggage.d.m
            public final h k(String str, Bundle bundle) {
                GameWebPerformanceInfo gameWebPerformanceInfo;
                AppMethodBeat.i(186833);
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("MicroMsg.LuggageGameWebViewUI", "getPage, __Time__，time = %d", Long.valueOf(currentTimeMillis));
                bundle.putInt("minimize_secene", 3);
                String string = bundle.getString("float_ball_key");
                boolean z = bundle.getBoolean("float_layer_page", false);
                if (LuggageGameWebViewUI.this.xwi || z || !Util.isNullOrNil(string) || LuggageGameWebViewUI.azC(str)) {
                    gameWebPerformanceInfo = GameWebPerformanceInfo.Fd(str);
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.game.g.baJ(str);
                    com.tencent.mm.plugin.webview.ui.tools.game.g.bC(str, currentTimeMillis);
                    com.tencent.mm.plugin.webview.ui.tools.game.g.bB(str, currentTimeMillis);
                    com.tencent.mm.plugin.webview.ui.tools.game.g.bK(str, currentTimeMillis);
                    gameWebPerformanceInfo = GameWebPerformanceInfo.Fe(str);
                }
                if (Util.isNullOrNil(gameWebPerformanceInfo.url)) {
                    Log.i("MicroMsg.LuggageGameWebViewUI", "new page, url: %s", str);
                    gameWebPerformanceInfo.url = str;
                    gameWebPerformanceInfo.hhK = currentTimeMillis;
                    gameWebPerformanceInfo.hhF = currentTimeMillis;
                    gameWebPerformanceInfo.startTime = currentTimeMillis;
                    gameWebPerformanceInfo.hhv = 1;
                }
                gameWebPerformanceInfo.hhM = currentTimeMillis;
                if (!z) {
                    LuggageGameWebViewUI.this.xwi = false;
                }
                i g2 = LuggageGameWebViewUI.this.g(bundle, str);
                AppMethodBeat.o(186833);
                return g2;
            }
        });
        GameWebViewLaunchParams gameWebViewLaunchParams = (GameWebViewLaunchParams) getIntent().getParcelableExtra("launchParams");
        if (gameWebViewLaunchParams == null || (gameFloatLayerInfo = gameWebViewLaunchParams.xvZ) == null) {
            z = false;
        } else {
            GameWebPerformanceInfo Fd2 = GameWebPerformanceInfo.Fd(gameFloatLayerInfo.url);
            Fd2.url = gameFloatLayerInfo.url;
            Fd2.hhE = getIntent().getLongExtra("gamecenterui_createtime", 0);
            Fd2.hhF = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
            Fd2.startTime = getIntent().getLongExtra("start_time", Fd2.hhF);
            Fd2.hhK = System.currentTimeMillis();
            Fd2.hhv = 1;
            Fd2.hhy = 1;
            com.tencent.mm.plugin.webview.ui.tools.game.g.bC(gameFloatLayerInfo.url, System.currentTimeMillis());
            Bundle bundle2 = new Bundle();
            bundle2.putString("rawUrl", gameFloatLayerInfo.url);
            bundle2.putBoolean("show_full_screen", gameFloatLayerInfo.xvW);
            bundle2.putInt("screen_orientation", gameFloatLayerInfo.orientation);
            bundle2.putBoolean("float_layer_page", true);
            bundle2.putBoolean("needAnimation", false);
            bundle2.putInt("customize_status_bar_color", getIntent().getIntExtra("customize_status_bar_color", 0));
            bundle2.putString("customize_status_bar_color", getIntent().getStringExtra("status_bar_style"));
            this.xwg.a(gameFloatLayerInfo.url, bundle2, false);
            z = true;
        }
        if (z) {
            Fd.hhC = 1;
            new Handler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(170128);
                    if (LuggageGameWebViewUI.this.isFinishing() || LuggageGameWebViewUI.this.activityHasDestroyed()) {
                        AppMethodBeat.o(170128);
                        return;
                    }
                    e eVar = LuggageGameWebViewUI.this.xwg;
                    String str = stringExtra;
                    Bundle extras = LuggageGameWebViewUI.this.getIntent().getExtras();
                    h k = eVar.ctp.k(str, extras);
                    if (k == null) {
                        Log.e("LuggagePageContainer", "No page specified for url %s", str);
                        AppMethodBeat.o(170128);
                        return;
                    }
                    eVar.ctl.addView(k.getContentView(), 0);
                    eVar.ctm.add(k);
                    k.g(str, extras);
                    k.Li();
                    eVar.Lp();
                    AppMethodBeat.o(170128);
                }
            }, 300);
        } else {
            this.xwg.h(stringExtra, getIntent().getExtras());
        }
        if (getIntent().getBooleanExtra("from_download_floagt_ball_shutdown_entrance", false)) {
            new Handler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(186834);
                    Intent intent = new Intent();
                    intent.putExtra("from_scene", 3);
                    ((c) g.af(c.class)).a(LuggageGameWebViewUI.this, intent, (a.c) null);
                    AppMethodBeat.o(186834);
                }
            }, 300);
        }
        f.cyc();
        AppMethodBeat.o(82996);
    }

    /* access modifiers changed from: protected */
    public void dTl() {
        AppMethodBeat.i(186835);
        setContentView(this.xwg.ctl);
        AppMethodBeat.o(186835);
    }

    /* access modifiers changed from: protected */
    public i g(Bundle bundle, String str) {
        AppMethodBeat.i(186836);
        String string = bundle.getString("float_ball_key");
        boolean z = bundle.getBoolean("float_layer_page", false);
        if (!Util.isNullOrNil(string)) {
            i iVar = new i(this.xwg.cts, r.a(getContext(), Integer.valueOf(com.tencent.mm.plugin.webview.luggage.r.aYv(string))), bundle);
            AppMethodBeat.o(186836);
            return iVar;
        } else if (z) {
            com.tencent.mm.plugin.game.luggage.g.a aVar = new com.tencent.mm.plugin.game.luggage.g.a(this.xwg.cts, bundle);
            AppMethodBeat.o(186836);
            return aVar;
        } else if (bundle.containsKey("game_tab_data")) {
            this.xwj = new com.tencent.mm.plugin.game.luggage.g.f(this.xwg.cts, bundle);
            dTo();
            com.tencent.mm.plugin.game.luggage.g.f fVar = this.xwj;
            AppMethodBeat.o(186836);
            return fVar;
        } else {
            p aI = h.aI(getContext(), str);
            if (aI != null) {
                j jVar = new j(this.xwg.cts, aI, bundle);
                AppMethodBeat.o(186836);
                return jVar;
            }
            i iVar2 = new i(this.xwg.cts, null, bundle);
            AppMethodBeat.o(186836);
            return iVar2;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity
    public void initSwipeBack() {
        AppMethodBeat.i(82997);
        fixStatusbar(false);
        super.initSwipeBack();
        AppMethodBeat.o(82997);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onCreateBeforeSetContentView() {
        AppMethodBeat.i(82998);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        supportRequestWindowFeature(9);
        AppMethodBeat.o(82998);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean noActionBar() {
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(82999);
        super.onResume();
        Log.i("MicroMsg.LuggageGameWebViewUI", "onResume, time: " + System.currentTimeMillis());
        this.xwg.onResume();
        AppMethodBeat.o(82999);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean supportNavigationSwipeBack() {
        AppMethodBeat.i(186837);
        if (!getIntent().getBooleanExtra("disable_game_tab_home_swipe", false)) {
            AppMethodBeat.o(186837);
            return true;
        }
        AppMethodBeat.o(186837);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(83000);
        super.onPause();
        Log.i("MicroMsg.LuggageGameWebViewUI", "onPause");
        hideVKB();
        h Ln = this.xwg.Ln();
        if (Ln != null) {
            Ln.Lj();
        }
        if (this.xwj != null) {
            com.tencent.mm.plugin.game.luggage.g.f fVar = this.xwj;
            Log.i("MicroMsg.GameTabWebPage", "computeFcp()");
            for (i iVar : fVar.xxQ.values()) {
                if (iVar != null) {
                    iVar.at(null);
                }
            }
        }
        AppMethodBeat.o(83000);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(83001);
        super.onDestroy();
        Log.i("MicroMsg.LuggageGameWebViewUI", "onDestroy");
        e.xwe = null;
        e.mHeaders = null;
        e.Nh = 0;
        this.xwg.destroy();
        com.tencent.mm.plugin.wepkg.event.c.clear();
        Log.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            Log.i("MicroMsg.LuggageGameWebViewUI", "fixInputMethodManagerLeak, imm");
            String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i2]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj != null && (obj instanceof View)) {
                        View view = (View) obj;
                        if (!(view.getContext() instanceof ContextWrapper)) {
                            if (view.getContext() != this) {
                                break;
                            }
                            declaredField.set(inputMethodManager, null);
                        } else if (((ContextWrapper) view.getContext()).getBaseContext() == this) {
                            declaredField.set(inputMethodManager, null);
                        }
                    }
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.LuggageGameWebViewUI", th, "", new Object[0]);
                }
            }
        }
        System.gc();
        f.remove();
        AppMethodBeat.o(83001);
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0017  */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r4 = this;
            r3 = 83002(0x1443a, float:1.1631E-40)
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.mm.plugin.game.luggage.g.e r1 = r4.xwg
            com.tencent.luggage.d.h r2 = r1.Ln()
            if (r2 == 0) goto L_0x002d
            boolean r2 = r2.Lk()
            if (r2 == 0) goto L_0x0021
        L_0x0015:
            if (r0 != 0) goto L_0x001d
            r4.dTn()
            r4.finish()
        L_0x001d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        L_0x0021:
            com.tencent.luggage.d.i$a<com.tencent.luggage.d.h> r2 = r1.ctm
            int r2 = r2.size()
            if (r2 <= r0) goto L_0x002d
            r1.Lo()
            goto L_0x0015
        L_0x002d:
            r0 = 0
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI.onBackPressed():void");
    }

    /* access modifiers changed from: protected */
    public void dTn() {
    }

    /* access modifiers changed from: protected */
    public void dTo() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(83003);
        AppMethodBeat.at(this, z);
        Log.i("MicroMsg.LuggageGameWebViewUI", "onWindowFocusChanged, hasFocus: %b, time: %d", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis()));
        super.onWindowFocusChanged(z);
        AppMethodBeat.o(83003);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(83004);
        super.onActivityResult(i2, i3, intent);
        this.xwg.cto.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(83004);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setMMOrientation() {
        AppMethodBeat.i(83005);
        if (this.xwh != -1) {
            setRequestedOrientation(this.xwh);
            AppMethodBeat.o(83005);
            return;
        }
        this.landscapeMode = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getBoolean("settings_landscape_mode", false);
        if (this.landscapeMode) {
            setRequestedOrientation(-1);
            AppMethodBeat.o(83005);
            return;
        }
        setRequestedOrientation(1);
        AppMethodBeat.o(83005);
    }

    static /* synthetic */ boolean azC(String str) {
        AppMethodBeat.i(83006);
        if (h.azD(str) != null) {
            AppMethodBeat.o(83006);
            return true;
        }
        AppMethodBeat.o(83006);
        return false;
    }
}
