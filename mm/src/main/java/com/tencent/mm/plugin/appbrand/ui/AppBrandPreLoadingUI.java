package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.mc;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.ab;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0002GHB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020\u000bH\u0016J\b\u00102\u001a\u00020.H\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\b\u00104\u001a\u00020\u000bH\u0016J\b\u00105\u001a\u00020.H\u0002J\b\u00106\u001a\u00020.H\u0016J\u0012\u00107\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u000109H\u0014J\b\u0010:\u001a\u00020.H\u0014J\u0012\u0010;\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010<\u001a\u00020.H\u0014J\u0012\u0010=\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u000109H\u0014J\b\u0010>\u001a\u00020.H\u0014J\b\u0010?\u001a\u00020.H\u0002J$\u0010@\u001a\u00020.2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010/\u001a\u0004\u0018\u00010\u00172\u0006\u0010C\u001a\u00020\u0019H\u0016J\b\u0010D\u001a\u00020.H\u0002J\u0014\u0010E\u001a\u00020.*\u00020\u00172\u0006\u0010F\u001a\u00020\u0019H\u0002R\u0014\u0010\u0004\u001a\b\u0018\u00010\u0005R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b)\u0010\u001eR\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataFragmentActivity;", "Lcom/tencent/mm/plugin/appbrand/launching/IMMActivityResultInstrumentation;", "()V", "appBrandUIEnterAnimationCompleteEventListener", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$AppBrandUIEnterAnimationCompleteEventListener;", "appId", "", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "isBindServiceSuccess", "", "isCloseByUser", "<set-?>", "isForeground", "()Z", "setForeground", "(Z)V", "isForeground$delegate", "Lkotlin/properties/ReadWriteProperty;", "kv14576", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14576;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/content/Intent;", "pendingIntentKey", "", "pendingIntentTask", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "scene", "getScene", "()I", "scene$delegate", "Lkotlin/Lazy;", "serviceName", "splashView", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "getSplashView", "()Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "splashView$delegate", "targetUiName", "uiFlavor", "getUiFlavor", "uiFlavor$delegate", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "attach", "", "intent", "lifecycle", "canStartActivityForResult", "finish", "isNfcFilterEnabled", "isSupportNavigationSwipeBack", "mayRainbowBackgroundForTest", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onPause", "onRestoreInstanceState", "onResume", "report", "startActivityForResult", "onActResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "requestCode", "tryToInterruptPost", "clearFlags", "flags", "AppBrandUIEnterAnimationCompleteEventListener", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandPreLoadingUI extends MMSecDataFragmentActivity implements ab {
    static final /* synthetic */ k[] cLI = {aa.a(new v(aa.bp(AppBrandPreLoadingUI.class), "isForeground", "isForeground()Z"))};
    public static final c nUG = new c((byte) 0);
    private HashMap _$_findViewCache;
    private String appId = "";
    private final kotlin.f jCN;
    private WxaAttributes.WxaVersionInfo lgq;
    private final kotlin.i.c mKK;
    private int mZL;
    private b nUA;
    private n nUB;
    private String nUC;
    private com.tencent.mm.plugin.appbrand.loading.b nUD;
    private final kotlin.f nUE;
    private final kotlin.f nUF;
    private com.tencent.mm.plugin.appbrand.loading.e nUw;
    private Intent nUx;
    private boolean nUy;
    private boolean nUz;
    private String serviceName;

    static {
        AppMethodBeat.i(51126);
        AppMethodBeat.o(51126);
    }

    private final int bOs() {
        AppMethodBeat.i(51128);
        int intValue = ((Number) this.nUE.getValue()).intValue();
        AppMethodBeat.o(51128);
        return intValue;
    }

    private final ab bXm() {
        AppMethodBeat.i(51129);
        ab abVar = (ab) this.nUF.getValue();
        AppMethodBeat.o(51129);
        return abVar;
    }

    private final void setForeground(boolean z) {
        AppMethodBeat.i(51127);
        this.mKK.a(cLI[0], Boolean.valueOf(z));
        AppMethodBeat.o(51127);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(229493);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(229493);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(229492);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(229492);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
    public static final class a extends kotlin.i.b<Boolean> {
        final /* synthetic */ Object mKT;
        final /* synthetic */ AppBrandPreLoadingUI nUH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object obj, Object obj2, AppBrandPreLoadingUI appBrandPreLoadingUI) {
            super(obj2);
            this.mKT = obj;
            this.nUH = appBrandPreLoadingUI;
        }

        @Override // kotlin.i.b
        public final void a(k<?> kVar, Boolean bool, Boolean bool2) {
            AppMethodBeat.i(51117);
            p.h(kVar, "property");
            boolean booleanValue = bool2.booleanValue();
            boolean booleanValue2 = bool.booleanValue();
            if (booleanValue && !booleanValue2 && this.nUH.nUx != null) {
                AppBrandPreLoadingUI appBrandPreLoadingUI = this.nUH;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.nUH.nUx);
                com.tencent.mm.hellhoundlib.a.a.a(appBrandPreLoadingUI, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                appBrandPreLoadingUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(appBrandPreLoadingUI, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.nUH.nUx = null;
            }
            AppMethodBeat.o(51117);
        }
    }

    public AppBrandPreLoadingUI() {
        AppMethodBeat.i(51141);
        kotlin.i.a aVar = kotlin.i.a.SYL;
        Boolean bool = Boolean.TRUE;
        this.mKK = new a(bool, bool, this);
        this.mZL = -1;
        this.serviceName = "";
        this.nUB = new n();
        this.nUC = "";
        this.nUE = kotlin.g.ah(new i(this));
        this.jCN = kotlin.g.ah(new g(this));
        this.nUF = kotlin.g.ah(new h(this));
        AppMethodBeat.o(51141);
    }

    public static final /* synthetic */ void c(AppBrandPreLoadingUI appBrandPreLoadingUI) {
        AppMethodBeat.i(51142);
        appBrandPreLoadingUI.bXn();
        AppMethodBeat.o(51142);
    }

    public static final /* synthetic */ int g(AppBrandPreLoadingUI appBrandPreLoadingUI) {
        AppMethodBeat.i(51144);
        int bOs = appBrandPreLoadingUI.bOs();
        AppMethodBeat.o(51144);
        return bOs;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$Companion;", "", "()V", "KEY_SAVED_INTENT", "", "MMKV_KEY", "TAG", "plugin-appbrand-integration_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ab
    public final void a(MMActivity.a aVar, Intent intent, int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ab
    public final boolean bNd() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean isSupportNavigationSwipeBack() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean isNfcFilterEnabled() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(51131);
        super.onNewIntent(intent);
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onNewIntent: ");
        if (intent == null) {
            AppMethodBeat.o(51131);
            return;
        }
        this.nUx = null;
        this.nUy = false;
        d(intent, "onNewIntent");
        AppMethodBeat.o(51131);
    }

    private final void d(Intent intent, String str) {
        String str2;
        String str3;
        AppMethodBeat.i(175217);
        String stringExtra = intent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.icon");
        if (stringExtra == null) {
            str2 = "";
        } else {
            str2 = stringExtra;
        }
        String stringExtra2 = intent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.name");
        if (stringExtra2 == null) {
            str3 = "";
        } else {
            str3 = stringExtra2;
        }
        String stringExtra3 = intent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.appId");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.appId = stringExtra3;
        this.lgq = (WxaAttributes.WxaVersionInfo) intent.getParcelableExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo");
        String stringExtra4 = intent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        this.nUC = stringExtra4;
        this.mZL = intent.getIntExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", -1);
        com.tencent.mm.plugin.appbrand.loading.c.mZY.a(this.mZL, this);
        b bVar = this.nUA;
        if (bVar != null) {
            bVar.dead();
        }
        this.nUA = new b();
        b bVar2 = this.nUA;
        if (bVar2 == null) {
            p.hyc();
        }
        bVar2.alive();
        String stringExtra5 = intent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName");
        if (stringExtra5 == null) {
            stringExtra5 = "";
        }
        this.serviceName = stringExtra5;
        bXm().eo(str2, str3);
        if (bXm() instanceof ad) {
            ab bXm = bXm();
            if (bXm == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.IAppBrandLoadingSplashCloseable");
                AppMethodBeat.o(175217);
                throw tVar;
            }
            ((ad) bXm).C(new d(this));
        }
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + str + "]: uiFlavor = " + bOs() + ", iconUrl = " + str2 + ", name = " + str3);
        Intent intent2 = new Intent();
        intent2.setClassName(this, this.serviceName);
        this.nUD = new com.tencent.mm.plugin.appbrand.loading.b(this.mZL, "MicroMsg.AppBrand.AppBrandPreLoadingUI", new e(this, str));
        try {
            com.tencent.mm.plugin.appbrand.loading.b bVar3 = this.nUD;
            if (bVar3 == null) {
                p.hyc();
            }
            this.nUz = bindService(intent2, bVar3, 65);
            Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + str + "]: bind " + this.serviceName + " ret = " + this.nUz);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + str + "]: bindService fail", e2);
        }
        this.nUB = new n();
        this.nUB.bUO();
        AppMethodBeat.o(175217);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(51133);
        super.onResume();
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onResume: ");
        if (bOs() == 4) {
            if (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.yt(((Number) this.jCN.getValue()).intValue())) {
                overridePendingTransition(0, 0);
            } else {
                overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
            }
        }
        setForeground(true);
        AppMethodBeat.o(51133);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        MultiProcessMMKV VQ;
        Intent intent;
        AppMethodBeat.i(51134);
        requestWindowFeature(10);
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (!(bundle == null || (intent = (Intent) bundle.getParcelable("MicroMsg.AppBrandPreLoadingUI.intent")) == null)) {
            Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: saved intent != null");
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        FrameLayout frameLayout = new FrameLayout(this);
        setContentView(frameLayout);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if ((WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) && (VQ = com.tencent.mm.plugin.appbrand.app.f.kIs.VQ()) != null && VQ.getBoolean("enable_pre_loading_rainbow", false)) {
            f fVar = f.nUJ;
            bXm().yu(Color.rgb(((Number) fVar.invoke()).intValue(), ((Number) fVar.invoke()).intValue(), ((Number) fVar.invoke()).intValue()));
        }
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: ");
        Intent intent2 = getIntent();
        p.g(intent2, "intent");
        d(intent2, "onCreate");
        frameLayout.addView(bXm().getView(), layoutParams);
        BaseAppBrandUIClipped.d(this, android.support.v4.content.b.n(this, R.color.f3044b));
        AppMethodBeat.o(51134);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(51135);
        super.onPause();
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onPause: ");
        if (!this.nUy) {
            overridePendingTransition(0, 0);
        }
        setForeground(false);
        AppMethodBeat.o(51135);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(51136);
        this.nUy = true;
        bXn();
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onBackPressed: ");
        super.onBackPressed();
        AppMethodBeat.o(51136);
    }

    private final void bXn() {
        AppMethodBeat.i(51137);
        this.nUw = com.tencent.mm.plugin.appbrand.loading.c.mZY.yq(this.mZL);
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "tryToInterruptPost: interrupt #" + this.mZL + " successful");
        AppMethodBeat.o(51137);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(51138);
        if (isFinishing() || isDestroyed()) {
            AppMethodBeat.o(51138);
            return;
        }
        super.finish();
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "finish: isCloseByUser:" + this.nUy + ", appId:" + this.appId);
        if (this.nUy) {
            if (this.nUw != null) {
                com.tencent.mm.plugin.appbrand.loading.e eVar = this.nUw;
                if (eVar == null) {
                    p.hyc();
                }
                AppBrandInitConfigWC appBrandInitConfigWC = eVar.kEG;
                n nVar = this.nUB;
                com.tencent.mm.plugin.appbrand.loading.e eVar2 = this.nUw;
                if (eVar2 == null) {
                    p.hyc();
                }
                nVar.f(appBrandInitConfigWC, eVar2.cyA);
                this.nUB.report();
                QualitySession qualitySession = appBrandInitConfigWC.ldW;
                mc mcVar = new mc();
                mcVar.zp(qualitySession.kEY);
                mcVar.zq(qualitySession.appId);
                mcVar.vF((long) qualitySession.nLk);
                mcVar.a(mc.a.mq(qualitySession.nJE));
                mcVar.vG((long) qualitySession.apptype);
                mcVar.vI((long) qualitySession.scene);
                mcVar.zr(appBrandInitConfigWC.username);
                mcVar.aiY();
                mcVar.aiZ();
                mcVar.zs(com.tencent.mm.plugin.appbrand.report.i.getNetworkType(MMApplicationContext.getContext()));
                mcVar.vK(appBrandInitConfigWC.Ny() ? 1 : 0);
                mcVar.aja();
                mcVar.vJ(appBrandInitConfigWC.startTime);
                mcVar.aiX();
                mcVar.vH(mcVar.aiW() - mcVar.aiV());
                mcVar.ajb();
                mcVar.bfK();
                this.nUw = null;
            }
            if (bOs() == 5) {
                ((ah) com.tencent.luggage.a.e.M(ah.class)).m(this);
                AppMethodBeat.o(51138);
                return;
            }
            if (bOs() == 4) {
                super.overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
            }
            AppMethodBeat.o(51138);
            return;
        }
        View findViewById = findViewById(16908290);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        super.overridePendingTransition(0, 0);
        AppMethodBeat.o(51138);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(51139);
        super.onDestroy();
        Intent intent = new Intent();
        intent.setClassName(this, this.serviceName);
        if (this.nUz) {
            try {
                if (this.nUD != null) {
                    com.tencent.mm.plugin.appbrand.loading.b bVar = this.nUD;
                    if (bVar == null) {
                        p.hyc();
                    }
                    unbindService(bVar);
                }
                stopService(intent);
            } catch (Exception e2) {
                Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onDestroy: ", e2);
            }
        }
        b bVar2 = this.nUA;
        if (bVar2 != null) {
            bVar2.dead();
        }
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onDestroy: ");
        AppMethodBeat.o(51139);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$AppBrandUIEnterAnimationCompleteEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandUIEnterAnimationCompleteEvent;", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;)V", "callback", "", "event", "plugin-appbrand-integration_release"})
    public final class b extends IListener<com.tencent.mm.plugin.appbrand.service.d> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.plugin.appbrand.service.d dVar) {
            AppMethodBeat.i(51118);
            com.tencent.mm.plugin.appbrand.service.d dVar2 = dVar;
            if (dVar2 == null) {
                AppMethodBeat.o(51118);
            } else {
                Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "callback: eventHash=" + dVar2.hashCode() + ", targetUiName = " + AppBrandPreLoadingUI.this.nUC + ", received = " + dVar2.nMq.nMr);
                if (p.j(AppBrandPreLoadingUI.this.nUC, dVar2.nMq.nMr)) {
                    AppBrandPreLoadingUI.this.finish();
                }
                AppMethodBeat.o(51118);
            }
            return false;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(51140);
        super.onRestoreInstanceState(bundle);
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onRestoreInstanceState: pendingIntent = " + this.nUx);
        if (!(bundle == null || this.nUx == null)) {
            bundle.putParcelable("MicroMsg.AppBrandPreLoadingUI.intent", this.nUx);
        }
        AppMethodBeat.o(51140);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ AppBrandPreLoadingUI nUH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AppBrandPreLoadingUI appBrandPreLoadingUI) {
            super(0);
            this.nUH = appBrandPreLoadingUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(51125);
            Integer valueOf = Integer.valueOf(this.nUH.getIntent().getIntExtra("MicroMsg.AppBrandPreLoadingLogic.splashFlavor", 5));
            AppMethodBeat.o(51125);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ AppBrandPreLoadingUI nUH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(AppBrandPreLoadingUI appBrandPreLoadingUI) {
            super(0);
            this.nUH = appBrandPreLoadingUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(51123);
            Integer valueOf = Integer.valueOf(this.nUH.getIntent().getIntExtra("MicroMsg.AppBrandPreLoadingLogic.scene", 1000));
            AppMethodBeat.o(51123);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "invoke"})
    static final class h extends q implements kotlin.g.a.a<ab> {
        final /* synthetic */ AppBrandPreLoadingUI nUH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AppBrandPreLoadingUI appBrandPreLoadingUI) {
            super(0);
            this.nUH = appBrandPreLoadingUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppBrandInitConfigWC appBrandInitConfigWC;
            aa a2;
            AppMethodBeat.i(51124);
            AppBrandPreLoadingUI appBrandPreLoadingUI = this.nUH;
            if (AppBrandPreLoadingUI.g(this.nUH) == 4) {
                com.tencent.mm.plugin.appbrand.loading.e yp = com.tencent.mm.plugin.appbrand.loading.c.mZY.yp(this.nUH.mZL);
                if (yp == null || (appBrandInitConfigWC = yp.kEG) == null || (a2 = k.a(appBrandPreLoadingUI, appBrandInitConfigWC)) == null) {
                    m mVar = new m(appBrandPreLoadingUI, null, this.nUH.lgq);
                    AppMethodBeat.o(51124);
                    return mVar;
                }
                aa aaVar = a2;
                AppMethodBeat.o(51124);
                return aaVar;
            }
            AppBrandUILoadingSplash appBrandUILoadingSplash = new AppBrandUILoadingSplash(appBrandPreLoadingUI);
            AppMethodBeat.o(51124);
            return appBrandUILoadingSplash;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ AppBrandPreLoadingUI nUH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AppBrandPreLoadingUI appBrandPreLoadingUI) {
            super(0);
            this.nUH = appBrandPreLoadingUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(51119);
            this.nUH.nUy = true;
            AppBrandPreLoadingUI.c(this.nUH);
            this.nUH.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(51119);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ AppBrandPreLoadingUI nUH;
        final /* synthetic */ String nUI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppBrandPreLoadingUI appBrandPreLoadingUI, String str) {
            super(0);
            this.nUH = appBrandPreLoadingUI;
            this.nUI = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Intent intent;
            String str;
            AppMethodBeat.i(51120);
            com.tencent.mm.plugin.appbrand.loading.e yq = com.tencent.mm.plugin.appbrand.loading.c.mZY.yq(this.nUH.mZL);
            if (yq != null) {
                intent = yq.intent;
            } else {
                intent = null;
            }
            if (intent == null) {
                Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + this.nUI + "]: onProgressLoadSuccess and get a null intent");
            } else {
                AppBrandPreLoadingUI appBrandPreLoadingUI = this.nUH;
                ComponentName component = intent.getComponent();
                if (component == null || (str = component.getClassName()) == null) {
                    str = BuildConfig.COMMAND;
                }
                appBrandPreLoadingUI.nUC = str;
                Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onProgressLoadSuccess targetUiName:" + this.nUH.nUC + ", isForeground:" + AppBrandPreLoadingUI.e(this.nUH));
                if (AppBrandPreLoadingUI.e(this.nUH)) {
                    AppBrandPreLoadingUI appBrandPreLoadingUI2 = this.nUH;
                    Object clone = intent.clone();
                    if (clone == null) {
                        t tVar = new t("null cannot be cast to non-null type android.content.Intent");
                        AppMethodBeat.o(51120);
                        throw tVar;
                    }
                    Intent intent2 = (Intent) clone;
                    AppBrandPreLoadingUI.O(intent2);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(appBrandPreLoadingUI2, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$attach$2", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    appBrandPreLoadingUI2.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(appBrandPreLoadingUI2, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$attach$2", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else {
                    this.nUH.nUx = intent;
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(51120);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<Integer> {
        public static final f nUJ = new f();

        static {
            AppMethodBeat.i(51122);
            AppMethodBeat.o(51122);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(51121);
            Integer valueOf = Integer.valueOf(kotlin.j.d.Pf(System.currentTimeMillis()).nextInt(0, 255));
            AppMethodBeat.o(51121);
            return valueOf;
        }
    }

    public static final /* synthetic */ boolean e(AppBrandPreLoadingUI appBrandPreLoadingUI) {
        AppMethodBeat.i(51143);
        boolean booleanValue = ((Boolean) appBrandPreLoadingUI.mKK.a(cLI[0])).booleanValue();
        AppMethodBeat.o(51143);
        return booleanValue;
    }

    public static final /* synthetic */ void O(Intent intent) {
        AppMethodBeat.i(175218);
        intent.setFlags(intent.getFlags() & -268435457);
        AppMethodBeat.o(175218);
    }
}
