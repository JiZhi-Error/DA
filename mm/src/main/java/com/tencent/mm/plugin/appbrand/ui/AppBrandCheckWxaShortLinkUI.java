package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher;
import com.tencent.mm.plugin.appbrand.shortlink.WxaShortLinkLaunchErrorCode;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.a;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0014J\b\u0010\u0011\u001a\u00020\nH\u0014J&\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u0018H\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\u0016\u0010\u001a\u001a\u00020\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u0018H\u0002J\n\u0010\u001b\u001a\u00020\u001c*\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "isTimeout", "Ljava/util/concurrent/atomic/AtomicBoolean;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "timeOutChecker", "Ljava/lang/Runnable;", "cancelTimeoutChecking", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "parseLinkAndLaunch", "url", "", "scene", "Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;", "ui", "Ljava/lang/ref/WeakReference;", "showProgressDialog", "startCheckTimeout", "toCgiScene", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandCheckWxaShortLinkUI extends MMActivity {
    public static final a nSr = new a((byte) 0);
    private HashMap _$_findViewCache;
    private q gut;
    private Runnable nSp;
    private AtomicBoolean nSq = new AtomicBoolean(false);

    static {
        AppMethodBeat.i(229468);
        AppMethodBeat.o(229468);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(229471);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(229471);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(229470);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(229470);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.b<WxaShortLinkLaunchErrorCode, x> {
        final /* synthetic */ WeakReference nSu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(WeakReference weakReference) {
            super(1);
            this.nSu = weakReference;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(WxaShortLinkLaunchErrorCode wxaShortLinkLaunchErrorCode) {
            AppMethodBeat.i(229460);
            p.h(wxaShortLinkLaunchErrorCode, LocaleUtil.ITALIAN);
            AppBrandCheckWxaShortLinkUI appBrandCheckWxaShortLinkUI = (AppBrandCheckWxaShortLinkUI) this.nSu.get();
            if (appBrandCheckWxaShortLinkUI != null) {
                appBrandCheckWxaShortLinkUI.finish();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(229460);
            return xVar;
        }
    }

    public AppBrandCheckWxaShortLinkUI() {
        AppMethodBeat.i(229467);
        AppMethodBeat.o(229467);
    }

    public static final /* synthetic */ void b(AppBrandCheckWxaShortLinkUI appBrandCheckWxaShortLinkUI) {
        AppMethodBeat.i(229469);
        appBrandCheckWxaShortLinkUI.bWS();
        AppMethodBeat.o(229469);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bn;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String str;
        boolean z;
        AppMethodBeat.i(229462);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("url") : null;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra("scene");
        } else {
            str = null;
        }
        String str2 = stringExtra;
        if (str2 == null || n.aL(str2)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            String str3 = str;
            if (!(str3 == null || str3.length() == 0)) {
                Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "start check short link");
                WeakReference weakReference = new WeakReference(this);
                t.b valueOf = t.b.valueOf(str);
                this.nSp = new d(this, weakReference);
                MMHandlerThread.postToMainThreadDelayed(this.nSp, 10000);
                q qVar = this.gut;
                if (qVar != null) {
                    qVar.dismiss();
                }
                this.gut = q.a(getContext(), getString(R.string.a06), true, 3, null);
                q qVar2 = this.gut;
                if (qVar2 != null) {
                    qVar2.setCancelable(false);
                }
                new b(this, valueOf, weakReference).a(this, stringExtra, new c(weakReference));
                AppMethodBeat.o(229462);
                return;
            }
        }
        setResult(-1, new Intent());
        finish();
        Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "url empty or invalid scene, finish");
        AppMethodBeat.o(229462);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J;\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\rH\u0014J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000eH\u0014¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$parseLinkAndLaunch$1", "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher;", "getBusinessType", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/CgiCheckWxaShortLink$TYPE;", "getShortLinkCgiCache", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "launch", "", "ctx", "Landroid/content/Context;", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/plugin/appbrand/shortlink/AbsWxaShortLinkLauncher$WxaShortLinkLaunchParams;", "launchResultCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "onLinkDecodeDone", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
    public static final class b extends AbsWxaShortLinkLauncher {
        final /* synthetic */ AppBrandCheckWxaShortLinkUI nSs;
        final /* synthetic */ t.b nSt;
        final /* synthetic */ WeakReference nSu;

        b(AppBrandCheckWxaShortLinkUI appBrandCheckWxaShortLinkUI, t.b bVar, WeakReference weakReference) {
            this.nSs = appBrandCheckWxaShortLinkUI;
            this.nSt = bVar;
            this.nSu = weakReference;
        }

        @Override // com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher
        public final com.tencent.mm.plugin.appbrand.shortlink.a bVy() {
            return com.tencent.mm.plugin.appbrand.shortlink.b.nNN;
        }

        @Override // com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher
        public final void a(Context context, AbsWxaShortLinkLauncher.WxaShortLinkLaunchParams wxaShortLinkLaunchParams, kotlin.g.a.b<? super Boolean, x> bVar) {
            AppMethodBeat.i(229457);
            p.h(context, "ctx");
            p.h(wxaShortLinkLaunchParams, NativeProtocol.WEB_DIALOG_PARAMS);
            p.h(bVar, "launchResultCallback");
            g gVar = new g();
            gVar.appId = wxaShortLinkLaunchParams.appId;
            gVar.kHw = wxaShortLinkLaunchParams.path;
            gVar.version = wxaShortLinkLaunchParams.version;
            gVar.iOo = wxaShortLinkLaunchParams.iOo;
            gVar.kHQ = wxaShortLinkLaunchParams.kHQ;
            gVar.scene = this.nSt.Kss;
            gVar.kHz = this.nSt.Kst;
            Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "launchWxa  appId=" + gVar.appId + " \nenterPath=" + gVar.kHw + " \nversion=" + gVar.version + " \nversionType=" + gVar.iOo + " \nshortLink=" + gVar.kHQ + " \nscene=" + gVar.scene + " \nprescene=" + gVar.kHz + '\n');
            ((r) com.tencent.mm.kernel.g.af(r.class)).a(context, gVar);
            bVar.invoke(Boolean.TRUE);
            AppMethodBeat.o(229457);
        }

        @Override // com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher
        public final a.b bVx() {
            AppMethodBeat.i(229458);
            a.b a2 = AppBrandCheckWxaShortLinkUI.a(this.nSt);
            AppMethodBeat.o(229458);
            return a2;
        }

        @Override // com.tencent.mm.plugin.appbrand.shortlink.AbsWxaShortLinkLauncher
        public final boolean a(Activity activity, boolean z) {
            AppMethodBeat.i(229459);
            p.h(activity, "ctx");
            super.a(activity, z);
            AppBrandCheckWxaShortLinkUI appBrandCheckWxaShortLinkUI = (AppBrandCheckWxaShortLinkUI) this.nSu.get();
            if (appBrandCheckWxaShortLinkUI == null) {
                AppMethodBeat.o(229459);
                return false;
            } else if (appBrandCheckWxaShortLinkUI.nSq.get()) {
                Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "CgiCheckWxaShortLink  callback , timeout, ignore cgi result");
                AppMethodBeat.o(229459);
                return false;
            } else {
                AppBrandCheckWxaShortLinkUI.b(this.nSs);
                q qVar = this.nSs.gut;
                if (qVar != null) {
                    qVar.dismiss();
                }
                if (!z) {
                    Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "CgiCheckWxaShortLink  CGI fail , go to fail H5 page");
                    Intent intent = new Intent();
                    ae aeVar = ae.SYK;
                    String format = String.format("https://mp.weixin.qq.com/mp/waerrpage?appid=wx40f8626ddf43d362&type=tips&title=%s&msg=%s#wechat_redirect", Arrays.copyOf(new Object[]{com.tencent.mm.compatible.util.q.encode(activity.getString(R.string.a3m), MimeTypeUtil.ContentType.DEFAULT_CHARSET), com.tencent.mm.compatible.util.q.encode(activity.getString(R.string.a3l), MimeTypeUtil.ContentType.DEFAULT_CHARSET)}, 2));
                    p.g(format, "java.lang.String.format(format, *args)");
                    intent.putExtra("rawUrl", format);
                    intent.putExtra("forceHideShare", true);
                    com.tencent.mm.br.c.b(this.nSs.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(229459);
                return true;
            }
        }
    }

    private final void bWS() {
        AppMethodBeat.i(229463);
        Runnable runnable = this.nSp;
        if (runnable != null) {
            MMHandlerThread.removeRunnable(runnable);
            AppMethodBeat.o(229463);
            return;
        }
        AppMethodBeat.o(229463);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ AppBrandCheckWxaShortLinkUI nSs;
        final /* synthetic */ WeakReference nSu;

        d(AppBrandCheckWxaShortLinkUI appBrandCheckWxaShortLinkUI, WeakReference weakReference) {
            this.nSs = appBrandCheckWxaShortLinkUI;
            this.nSu = weakReference;
        }

        public final void run() {
            AppMethodBeat.i(229461);
            Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "check short link timeout");
            this.nSs.nSq.set(true);
            u.makeText(this.nSs, this.nSs.getContext().getString(R.string.a3n), 1).show();
            AppBrandCheckWxaShortLinkUI appBrandCheckWxaShortLinkUI = (AppBrandCheckWxaShortLinkUI) this.nSu.get();
            if (appBrandCheckWxaShortLinkUI != null) {
                appBrandCheckWxaShortLinkUI.finish();
                AppMethodBeat.o(229461);
                return;
            }
            AppMethodBeat.o(229461);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(229464);
        super.onResume();
        y.e(getWindow());
        y.d(getWindow(), false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        com.tencent.mm.ui.base.b.a(this, null);
        AppMethodBeat.o(229464);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(229465);
        Log.i("MicroMsg.AppBrandCheckWxaShortLinkUI", "onDestroy");
        bWS();
        q qVar = this.gut;
        if (qVar != null) {
            qVar.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.o(229465);
    }

    public static a.b a(t.b bVar) {
        AppMethodBeat.i(229466);
        p.h(bVar, "$this$toCgiScene");
        switch (e.$EnumSwitchMapping$0[bVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                a.b bVar2 = a.b.BusinessTypeWxaBase;
                AppMethodBeat.o(229466);
                return bVar2;
            case 12:
                a.b bVar3 = a.b.BusinessTypeVideoAct;
                AppMethodBeat.o(229466);
                return bVar3;
            default:
                if (BuildInfo.IS_FLAVOR_RED) {
                    Error error = new Error(bVar.name() + " can not convert into CgiCheckWxaShortLink.TYPE");
                    AppMethodBeat.o(229466);
                    throw error;
                }
                a.b bVar4 = a.b.BusinessTypeNone;
                AppMethodBeat.o(229466);
                return bVar4;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion;", "", "()V", "CHECK_RESULT_TIMEOUT_MILL_SECOND", "", "KEY_SCENE", "", "KEY_URL", "PARSE_FAIL_TIP_URL", "TAG", "startCheckLink", "", "context", "Landroid/content/Context;", "url", "scene", "Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final void a(Context context, String str, t.b bVar) {
        AppMethodBeat.i(229472);
        p.h(context, "context");
        p.h(str, "url");
        p.h(bVar, "scene");
        if (!n.aL(str)) {
            Intent intent = new Intent(context, AppBrandCheckWxaShortLinkUI.class);
            intent.putExtra("url", str);
            intent.putExtra("scene", bVar.name());
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/ui/AppBrandCheckWxaShortLinkUI$Companion", "startCheckLink", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(229472);
    }
}
