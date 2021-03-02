package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cr.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.plugin.appbrand.ui.recommend.k;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.Locale;

@i
public final class AppBrandLauncherUI extends MMActivity implements com.tencent.mm.plugin.appbrand.ui.launcher.a {
    public static int nTJ = MMApplicationContext.getContext().getResources().getColor(R.color.a2r);
    public static final int nTK = ac.kEM;
    private int enterScene;
    private int nTL = -1;
    private boolean nTM;
    private RecentsFolderActivityContext nTN;
    private boolean nTO = false;
    public t.d nTP;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ Fragment a(AppBrandLauncherUI appBrandLauncherUI) {
        AppMethodBeat.i(48651);
        Fragment bWZ = appBrandLauncherUI.bWZ();
        AppMethodBeat.o(48651);
        return bWZ;
    }

    static {
        AppMethodBeat.i(48653);
        AppMethodBeat.o(48653);
    }

    enum a {
        WebSearch,
        More,
        StarList;

        public static a valueOf(String str) {
            AppMethodBeat.i(48635);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(48635);
            return aVar;
        }

        static {
            AppMethodBeat.i(48636);
            AppMethodBeat.o(48636);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.launcher.a
    public final void iI(boolean z) {
        AppMethodBeat.i(48637);
        if (this.nTN != null) {
            this.nTN.iI(z);
        }
        if (z && this.nTP != null) {
            this.nTP.kVm[4] = "1";
        }
        AppMethodBeat.o(48637);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(48640);
        super.onCreateBeforeSetContentView();
        getWindow().setSoftInputMode(3);
        AppMethodBeat.o(48640);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        long j2;
        AppMethodBeat.i(48641);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(48641);
        } else if (!com.tencent.mm.plugin.appbrand.appusage.i.bxK()) {
            finish();
            AppMethodBeat.o(48641);
        } else {
            Lifecycle lifecycle = getLifecycle();
            f fVar = f.nGV;
            lifecycle.addObserver(f.b(this));
            this.enterScene = getIntent().getIntExtra("extra_enter_scene", -1);
            boolean booleanExtra = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
            Log.i("MicroMsg.AppBrandLauncherUI", "onCreate showRecentsListTagOnTop:%b", Boolean.valueOf(booleanExtra));
            i iVar = i.nTZ;
            if (!i.VQ().getBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", false) || booleanExtra) {
                i iVar2 = i.nTZ;
                boolean z = i.VQ().getBoolean("KEY_FORCE_NATIVE_LAUNCHER", false);
                this.nTM = getIntent().getBooleanExtra("extra_show_recommend", false);
                boolean bYR = c.bYR();
                setTitleBarDoubleClickListener(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(48623);
                        if (AppBrandLauncherUI.this.activityHasDestroyed() || AppBrandLauncherUI.this.isFinishing()) {
                            AppMethodBeat.o(48623);
                            return;
                        }
                        Fragment a2 = AppBrandLauncherUI.a(AppBrandLauncherUI.this);
                        if (a2 == null) {
                            AppMethodBeat.o(48623);
                            return;
                        }
                        a2.bXb();
                        AppMethodBeat.o(48623);
                    }
                });
                setMMTitle(getResources().getString(R.string.ko));
                setBackBtn(new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.AnonymousClass2 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(48624);
                        AppBrandLauncherUI.this.onBackPressed();
                        AppMethodBeat.o(48624);
                        return true;
                    }
                }, R.raw.actionbar_icon_dark_back);
                if (com.tencent.mm.plugin.appbrand.y.a.bVo()) {
                    addIconOptionMenu(a.WebSearch.ordinal(), R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.AnonymousClass3 */

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.i(48626);
                            ((com.tencent.mm.plugin.websearch.api.i) g.af(com.tencent.mm.plugin.websearch.api.i.class)).a(MMApplicationContext.getContext(), new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(48625);
                                    int i2 = AppBrandLauncherUI.this.enterScene == 13 ? 52 : 201;
                                    AppBrandLauncherUI appBrandLauncherUI = AppBrandLauncherUI.this;
                                    com.tencent.mm.plugin.appbrand.c.a aVar = com.tencent.mm.plugin.appbrand.c.a.INSTANCE;
                                    appBrandLauncherUI.startActivityForResult(com.tencent.mm.plugin.appbrand.c.a.M(AppBrandLauncherUI.this, i2), 1);
                                    AppMethodBeat.o(48625);
                                }
                            });
                            AppMethodBeat.o(48626);
                            return true;
                        }
                    }, new View.OnLongClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.AnonymousClass4 */

                        public final boolean onLongClick(View view) {
                            AppMethodBeat.i(48628);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                            if (WeChatEnvironment.hasDebugger()) {
                                final AppBrandLauncherUI appBrandLauncherUI = AppBrandLauncherUI.this;
                                h.a(appBrandLauncherUI, appBrandLauncherUI.getResources().getString(R.string.a0n), "", "", Integer.MAX_VALUE, new h.b() {
                                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.AnonymousClass4.AnonymousClass1 */

                                    @Override // com.tencent.mm.ui.base.h.b
                                    public final boolean onFinish(CharSequence charSequence) {
                                        AppMethodBeat.i(48627);
                                        if (!TextUtils.isEmpty(charSequence)) {
                                            String charSequence2 = charSequence.toString();
                                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                            appBrandStatObject.scene = 1001;
                                            com.tencent.mm.plugin.appbrand.launching.e.f.mZp.a(appBrandLauncherUI, "", charSequence2, null, 0, 0, appBrandStatObject, null, null);
                                            AppMethodBeat.o(48627);
                                            return true;
                                        }
                                        AppMethodBeat.o(48627);
                                        return false;
                                    }
                                });
                                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                                AppMethodBeat.o(48628);
                                return true;
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                            AppMethodBeat.o(48628);
                            return false;
                        }
                    });
                }
                nTJ = getContext().getResources().getColor(R.color.a2r);
                setActionbarColor(nTJ);
                findViewById(16908290).setBackgroundColor(nTJ);
                Log.i("MicroMsg.AppBrandLauncherUI", "mShowRecommend:%b, recommendDataState:%b, isForceOpenNativeLauncherUI:%b", Boolean.valueOf(this.nTM), Boolean.valueOf(bYR), Boolean.valueOf(z));
                if (!this.nTM || !bYR || z || booleanExtra) {
                    Lifecycle lifecycle2 = getLifecycle();
                    RecentsFolderActivityContext recentsFolderActivityContext = new RecentsFolderActivityContext(this);
                    this.nTN = recentsFolderActivityContext;
                    lifecycle2.addObserver(recentsFolderActivityContext);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(465, 0, 1, false);
                    if (!com.tencent.mm.plugin.appbrand.y.a.bVo()) {
                        Log.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        Object obj = g.aAh().azQ().get(ar.a.USERINFO_WXA_SEARCH_INPUT_HINT_UPDATE_TIME_LONG_SYNC, (Object) null);
                        if (obj == null || !(obj instanceof Long)) {
                            j2 = 0;
                        } else {
                            j2 = ((Long) obj).longValue();
                        }
                        String language = Locale.getDefault().getLanguage();
                        Object obj2 = g.aAh().azQ().get(ar.a.USERINFO_WXA_SEARCH_INPUT_HINT_LANG_STRING_SYNC, (Object) null);
                        if (currentTimeMillis - j2 >= Util.MILLSECONDS_OF_HOUR || obj2 == null || !obj2.equals(language)) {
                            g.aAg().hqi.a(new com.tencent.mm.plugin.appbrand.r.b(), 0);
                        }
                        Log.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", obj2, language, Long.valueOf(j2), Long.valueOf(currentTimeMillis));
                    }
                    d.hiy();
                    if (t.byd()) {
                        this.nTP = new t.d();
                    }
                    t.byf();
                    com.tencent.mm.plugin.appbrand.appusage.i.bxL();
                    AppMethodBeat.o(48641);
                    return;
                }
                bXa();
                AppMethodBeat.o(48641);
                return;
            }
            Log.i("MicroMsg.AppBrandLauncherUI", "onCreate isForceOpenWeUseFakeNative=TRUE");
            bXa();
            AppMethodBeat.o(48641);
        }
    }

    private void bXa() {
        AppMethodBeat.i(180388);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_BRIGHT;
        finish();
        overridePendingTransition(0, 0);
        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
        if (com.tencent.mm.protocal.d.KyO >= 654314752) {
            gVar.kHx = new k();
            Log.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, wechatNativeExtraData=%s", gVar.kHx.bua());
        } else {
            String format = String.format("?showOrderEntrance=%d", 1);
            gVar.kHw = format;
            Log.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, enterPath:%s", format);
        }
        i iVar = i.nTZ;
        String bXd = i.bXd();
        gVar.username = "wxb6d22f922f37b35a".equals(bXd) ? "gh_b489f391e008@app" : "gh_9bd4ec2ab601@app";
        gVar.appId = bXd;
        gVar.iOo = 0;
        gVar.version = 0;
        gVar.scene = appBrandStatObject.scene;
        ((r) g.af(r.class)).a(MMApplicationContext.getContext(), gVar);
        this.nTO = true;
        AppMethodBeat.o(180388);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(48642);
        if (isFinishing()) {
            AppMethodBeat.o(48642);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(48642);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(48644);
        super.onStop();
        if (this.nTO) {
            finish();
            overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(48644);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(48645);
        super.onDestroy();
        q.clearData();
        if (this.nTP != null) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14113, this.nTP.kVm);
            this.nTP = null;
        }
        com.tencent.mm.kiss.a.b.aBi();
        AppMethodBeat.o(48645);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(48646);
        super.onActivityResult(i2, i3, intent);
        this.nTL = i2;
        if (i3 == -1 && i2 == 1) {
            String stringExtra = intent.getStringExtra("key_session_id");
            int intExtra = intent.getIntExtra("ftsbizscene", 0);
            Log.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", stringExtra, com.tencent.mm.modelappbrand.b.iIn);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13929, stringExtra, com.tencent.mm.modelappbrand.b.iIn, 2, Integer.valueOf(intExtra));
        }
        AppMethodBeat.o(48646);
    }

    @Override // android.app.Activity
    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(48647);
        setMMTitle(charSequence);
        AppMethodBeat.o(48647);
    }

    @Override // android.app.Activity
    public final void setTitle(int i2) {
        AppMethodBeat.i(48648);
        setMMTitle(i2);
        AppMethodBeat.o(48648);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(48649);
        finish();
        AppMethodBeat.o(48649);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(48650);
        super.startActivityForResult(intent, i2, bundle);
        Fragment bWZ = bWZ();
        if (bWZ != null) {
            bWZ.a(intent, i2);
        }
        AppMethodBeat.o(48650);
    }

    public static abstract class Fragment extends android.support.v4.app.Fragment {
        private final MMHandler kAn = new MMHandler(Looper.getMainLooper());
        public View mContentView;
        public int mScene;
        public String nTU;

        public abstract int getLayoutId();

        public abstract void initView();

        public void bXb() {
        }

        /* access modifiers changed from: protected */
        public void a(Intent intent, int i2) {
        }

        public void setScene(int i2) {
            this.mScene = i2;
        }

        public final View getContentView() {
            return this.mContentView;
        }

        @Override // android.support.v4.app.Fragment
        @SuppressLint({"ResourceType"})
        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            if (getLayoutId() < 0) {
                this.mContentView = new FrameLayout(viewGroup.getContext());
            } else {
                this.mContentView = layoutInflater.inflate(getLayoutId(), (ViewGroup) null);
            }
            initView();
            return this.mContentView;
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroy() {
            super.onDestroy();
            this.kAn.removeCallbacksAndMessages(null);
        }

        public final void postOnUiThread(Runnable runnable) {
            this.kAn.post(runnable);
        }

        public final void runOnUiThread(Runnable runnable) {
            FragmentActivity activity = getActivity();
            if (activity != null && !activity.isDestroyed()) {
                activity.runOnUiThread(runnable);
            }
        }

        public final <T extends View> T bXc() {
            return (T) this.mContentView.findViewById(16908298);
        }
    }

    private Fragment bWZ() {
        AppMethodBeat.i(48638);
        android.support.v4.app.Fragment findFragmentById = super.getSupportFragmentManager().findFragmentById(16908290);
        if (findFragmentById == null || !(findFragmentById instanceof Fragment)) {
            AppMethodBeat.o(48638);
            return null;
        }
        Fragment fragment = (Fragment) findFragmentById;
        AppMethodBeat.o(48638);
        return fragment;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        int i2;
        AppMethodBeat.i(48643);
        if (this.nTL > 0) {
            if (this.nTL == 1) {
                i2 = 7;
            } else if (this.nTL == 2) {
                i2 = 6;
            } else if (this.nTL == 3) {
                i2 = 9;
            } else {
                i2 = this.nTL == 4 ? 12 : 4;
            }
            this.nTL = 0;
            Fragment fragment = (Fragment) super.getSupportFragmentManager().findFragmentById(16908290);
            if (fragment != null) {
                fragment.setScene(i2);
            }
        }
        super.onResume();
        int i3 = this.enterScene == 13 ? 52 : 201;
        String aXE = com.tencent.mm.modelappbrand.b.aXE();
        ai.LX(0);
        ai.cM(i3, aXE);
        AppMethodBeat.o(48643);
    }
}
