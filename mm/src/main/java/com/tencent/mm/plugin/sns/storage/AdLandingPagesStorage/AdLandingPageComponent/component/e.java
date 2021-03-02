package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.d;
import android.support.v4.widget.Space;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.widget.LinearLayout;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.aa;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.k.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class e extends m implements ScrollableLayout.a, ScrollableLayout.b {
    ScrollableLayout EbX;
    View EbY;
    BaseWebViewController EbZ;
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e Eca;
    a Ecb;
    private boolean Ecc = false;
    com.tencent.mm.plugin.webview.stub.b Ecd = new com.tencent.mm.plugin.webview.stub.b() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.stub.b
        public final String getCurrentUrl() {
            AppMethodBeat.i(202836);
            try {
                BaseWebViewController baseWebViewController = e.this.EbZ;
                if (baseWebViewController != null) {
                    String currentUrl = baseWebViewController.getCurrentUrl();
                    AppMethodBeat.o(202836);
                    return currentUrl;
                }
            } catch (Throwable th) {
                Log.e("AdLandingFloatWebView", "callback: getCurrentUrl failed");
            }
            AppMethodBeat.o(202836);
            return "";
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.stub.b
        public final String ePp() {
            AppMethodBeat.i(202837);
            try {
                BaseWebViewController baseWebViewController = e.this.EbZ;
                if (baseWebViewController != null) {
                    String str = baseWebViewController.IJP;
                    AppMethodBeat.o(202837);
                    return str;
                }
            } catch (Throwable th) {
                Log.e("AdLandingFloatWebView", "callback: getCommitUrl failed");
            }
            AppMethodBeat.o(202837);
            return "";
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.stub.b
        public final boolean a(final String str, final String str2, final Bundle bundle, final boolean z) {
            AppMethodBeat.i(202838);
            BaseWebViewController baseWebViewController = e.this.EbZ;
            if (baseWebViewController == null) {
                AppMethodBeat.o(202838);
            } else {
                try {
                    final h jsapi = baseWebViewController.getJsapi();
                    com.tencent.f.h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(202834);
                            try {
                                if (jsapi != null) {
                                    jsapi.a(str, str2, n.aN(bundle), z);
                                }
                                AppMethodBeat.o(202834);
                            } catch (Throwable th) {
                                Log.e("AdLandingFloatWebView", "In jsapi onHandleEnd method, it happens something unwanted!");
                                AppMethodBeat.o(202834);
                            }
                        }
                    });
                } catch (Throwable th) {
                    Log.e("AdLandingFloatWebView", "In onHandleEnd method, it happens something unwanted!");
                }
                AppMethodBeat.o(202838);
            }
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.stub.b
        public final Bundle j(int i2, Bundle bundle) {
            AppMethodBeat.i(202839);
            Bundle bundle2 = new Bundle();
            Context context = e.this.context;
            switch (i2) {
                case 101:
                    if (!(context == null || bundle == null)) {
                        try {
                            bundle.setClassLoader(context.getClassLoader());
                            Bundle bundle3 = bundle.getBundle("open_ui_with_webview_ui_extras");
                            String string = IntentUtil.getString(bundle, "open_ui_with_webview_ui_plugin_name");
                            String string2 = IntentUtil.getString(bundle, "open_ui_with_webview_ui_plugin_entry");
                            Context context2 = e.this.context;
                            Intent intent = new Intent();
                            if (bundle3 == null) {
                                bundle3 = new Bundle();
                            }
                            com.tencent.mm.br.c.b(context2, string, string2, intent.putExtras(bundle3));
                            break;
                        } catch (Throwable th) {
                            Log.e("AdLandingFloatWebView", "In invokeAsResult method, it happens something unwanted!");
                            break;
                        }
                    }
            }
            AppMethodBeat.o(202839);
            return bundle2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.stub.b
        public final boolean f(int i2, final Bundle bundle) {
            AppMethodBeat.i(202840);
            try {
                BaseWebViewController baseWebViewController = e.this.EbZ;
                if (baseWebViewController == null) {
                    AppMethodBeat.o(202840);
                } else {
                    final h jsapi = baseWebViewController.getJsapi();
                    final g gVar = baseWebViewController.mHi;
                    switch (i2) {
                        case 1006:
                            com.tencent.f.h.RTc.aV(new Runnable() {
                                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    boolean z = true;
                                    AppMethodBeat.i(202835);
                                    try {
                                        if (!bundle.containsKey("jsapi_preverify_fun_list") || gVar == null) {
                                            Object[] objArr = new Object[1];
                                            if (gVar == null) {
                                                z = false;
                                            }
                                            objArr[0] = Boolean.valueOf(z);
                                            Log.e("AdLandingFloatWebView", "has JSAPI_CONTROL_BYTES wvPerm %b", objArr);
                                        } else {
                                            gVar.aR(bundle);
                                        }
                                        jsapi.gaY();
                                        AppMethodBeat.o(202835);
                                    } catch (Throwable th) {
                                        Log.e("AdLandingFloatWebView", "In onCallback method, it happens something unwanted!");
                                        AppMethodBeat.o(202835);
                                    }
                                }
                            });
                            break;
                    }
                    AppMethodBeat.o(202840);
                }
            } catch (Throwable th) {
                Log.e("AdLandingFloatWebView", "In callback method, it happens something unwanted!");
                AppMethodBeat.o(202840);
            }
            return true;
        }
    };
    MMWebView iGY;
    private IListener<vf> iHq;

    public e(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e eVar, ViewGroup viewGroup) {
        super(context, eVar, viewGroup);
        AppMethodBeat.i(202853);
        try {
            this.Eca = eVar;
            if (this.iHq == null) {
                this.iHq = new IListener<vf>() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e.AnonymousClass3 */

                    {
                        AppMethodBeat.i(202842);
                        this.__eventId = vf.class.getName().hashCode();
                        AppMethodBeat.o(202842);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(vf vfVar) {
                        AppMethodBeat.i(202844);
                        boolean a2 = a(vfVar);
                        AppMethodBeat.o(202844);
                        return a2;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098  */
                    /* JADX WARNING: Removed duplicated region for block: B:84:0x01a5  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private boolean a(com.tencent.mm.g.a.vf r13) {
                        /*
                        // Method dump skipped, instructions count: 451
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e.AnonymousClass3.a(com.tencent.mm.g.a.vf):boolean");
                    }
                };
                this.iHq.alive();
            }
            AppMethodBeat.o(202853);
        } catch (Throwable th) {
            AppMethodBeat.o(202853);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(202854);
        try {
            if (this.EbZ == null) {
                String aPV = aPV(this.Eca.DXV);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", aPV);
                intent.putExtra("useJs", true);
                intent.putExtra("type", -255);
                intent.putExtra("geta8key_scene", 2);
                this.EbZ = ((aa) com.tencent.mm.kernel.g.af(aa.class)).a(this.iGY);
                this.EbZ.a(new j() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.webview.core.j
                    public final void ePr() {
                        AppMethodBeat.i(202841);
                        try {
                            e.this.EbZ.mHh.a(e.this.Ecd, e.this.EbZ.fZu());
                            AppMethodBeat.o(202841);
                        } catch (Throwable th) {
                            Log.e("AdLandingFloatWebView", "bind webview callback failed");
                            AppMethodBeat.o(202841);
                        }
                    }
                });
                this.iGY.setWebChromeClient(new MMWebView.b(new c((Activity) this.context, this.EbZ.mHi, this.Ecb)));
                this.EbZ.init();
                this.EbZ.aB(intent);
                Log.d("AdLandingFloatWebView", "url is ".concat(String.valueOf(aPV)));
            }
            AppMethodBeat.o(202854);
        } catch (Throwable th) {
            Log.e("AdLandingFloatWebView", "bind webview callback failed");
            AppMethodBeat.o(202854);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(202855);
        super.eXe();
        if (!this.Ecc) {
            this.Ecc = true;
            try {
                View view = this.contentView;
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalLayoutListener(new b());
                    }
                }
                AppMethodBeat.o(202855);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(202855);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final View eWY() {
        AppMethodBeat.i(202856);
        try {
            this.EbX = new ScrollableLayout(this.context);
            MMWebView mMWebView = null;
            if (k.bbp(this.Eca.DXV)) {
                mMWebView = MMWebView.a.kK(this.context);
            }
            if (mMWebView == null) {
                mMWebView = MMWebView.a.kL(this.context);
            }
            this.iGY = mMWebView;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.EbY = new Space(this.context);
            this.EbY.setLayoutParams(layoutParams);
            this.EbX.addView(this.EbY);
            this.Ecb = new a();
            this.EbX.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.EbX.setDescendantScrollStatusHunter(this);
            this.EbX.setOnScrollStatusListener(this);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            ScrollableLayout scrollableLayout = this.EbX;
            MMWebView mMWebView2 = this.iGY;
            try {
                scrollableLayout.addView(mMWebView2, layoutParams2);
                scrollableLayout.Fgd = mMWebView2;
            } catch (Throwable th) {
                Log.w("ScrollLinearLayout", "the addView has something wrong!");
            }
        } catch (Throwable th2) {
            Log.w("AdLandingFloatWebView", "the customLayout method has something wrong");
        }
        ScrollableLayout scrollableLayout2 = this.EbX;
        AppMethodBeat.o(202856);
        return scrollableLayout2;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXd() {
        AppMethodBeat.i(202857);
        super.eXd();
        try {
            Log.i("AdLandingFloatWebView", "the view is going to destroy");
            if (this.iHq != null) {
                this.iHq.dead();
            }
            if (this.EbZ != null) {
                this.EbZ.onDestroy();
            }
            if (this.iGY != null) {
                this.iGY.destroy();
            }
            AppMethodBeat.o(202857);
        } catch (Throwable th) {
            Log.w("AdLandingFloatWebView", "the destroy method has something wrong");
            AppMethodBeat.o(202857);
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout.b
    public final void aS(int i2, boolean z) {
        AppMethodBeat.i(202858);
        if (i2 == 0) {
            try {
                d W = d.W(this.context);
                Intent intent = new Intent("com.tencent.mm.adlanding.video.action.PAUSE_OR_RESUME");
                intent.putExtra("TRY_PAUSE_OR_RESUME", z ? 1 : 2);
                intent.putExtra("identity", this.context.hashCode());
                W.b(intent);
            } catch (Throwable th) {
                Log.w("AdLandingFloatWebView", "onScrollChanged method has something wrong");
                AppMethodBeat.o(202858);
                return;
            }
        }
        AppMethodBeat.o(202858);
    }

    static class c extends x {
        private Reference<Activity> Duf;
        private final a Ecb;
        private g Ecq;

        protected c(Activity activity, g gVar, a aVar) {
            AppMethodBeat.i(202848);
            this.Duf = new WeakReference(activity);
            this.Ecq = gVar;
            this.Ecb = aVar;
            AppMethodBeat.o(202848);
        }

        @Override // com.tencent.xweb.x
        public final void a(WebView webView, int i2) {
            AppMethodBeat.i(202849);
            Log.d("AdLandingFloatWebView", "onProgressChanged %d", Integer.valueOf(i2));
            AppMethodBeat.o(202849);
        }

        @Override // com.tencent.xweb.x
        public final void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
            AppMethodBeat.i(202850);
            Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt, origin = %s", str);
            try {
                final Activity activity = this.Duf.get();
                if (!e.aJ(activity) || callback == null) {
                    Log.w("AdLandingFloatWebView", "the activity is finished.");
                    AppMethodBeat.o(202850);
                } else if (com.tencent.mm.pluginsdk.permission.b.n(activity, "android.permission.ACCESS_FINE_LOCATION")) {
                    com.tencent.mm.ui.base.h.a((Context) activity, false, activity.getString(R.string.iz1, new Object[]{str}), activity.getString(R.string.iz2), activity.getString(R.string.x_), activity.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e.c.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(202846);
                            Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt ok");
                            try {
                                callback.invoke(str, true, true);
                                ap.aK(activity);
                                AppMethodBeat.o(202846);
                            } catch (Throwable th) {
                                Log.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                                AppMethodBeat.o(202846);
                            }
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e.c.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(202847);
                            Log.i("AdLandingFloatWebView", "onGeolocationPermissionsShowPrompt cancel");
                            try {
                                callback.invoke(str, false, false);
                                ap.aK(activity);
                                AppMethodBeat.o(202847);
                            } catch (Throwable th) {
                                Log.e("AdLandingFloatWebView", "GeolocationPermissions.Callback has something wrong!");
                                AppMethodBeat.o(202847);
                            }
                        }
                    });
                    AppMethodBeat.o(202850);
                } else {
                    Log.w("AdLandingFloatWebView", "the application has no geo permission.");
                    AppMethodBeat.o(202850);
                }
            } catch (Throwable th) {
                Log.w("AdLandingFloatWebView", "the application has no geo permission.");
                AppMethodBeat.o(202850);
            }
        }

        @Override // com.tencent.xweb.x
        public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, x.a aVar) {
            boolean z;
            Intent intent;
            Intent[] intentArr = null;
            AppMethodBeat.i(202851);
            try {
                Activity activity = this.Duf.get();
                if ((e.aJ(activity) && aVar.getMode() == 0) || aVar.getMode() == 1) {
                    if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                        Log.i("AdLandingFloatWebView", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                        AppMethodBeat.o(202851);
                        return true;
                    }
                    String str = aVar.getAcceptTypes()[0];
                    String str2 = "*";
                    if (aVar.isCaptureEnabled()) {
                        if ("image/*".equalsIgnoreCase(str)) {
                            str2 = "camera";
                        } else if ("video/*".equalsIgnoreCase(str)) {
                            str2 = "camcorder";
                        }
                    }
                    a aVar2 = this.Ecb;
                    g gVar = this.Ecq;
                    if (!e.aJ(activity)) {
                        Log.i("AdLandingFloatWebView", "activity is finished.");
                    } else if (gVar == null) {
                        Log.e("AdLandingFloatWebView", "openFileChooser fail, wvPerm is null");
                    } else if (!gVar.gdH().pP(56)) {
                        Log.e("AdLandingFloatWebView", "open file chooser failed, permission fail");
                    } else {
                        aVar2.Ecm = null;
                        aVar2.Ecn = valueCallback;
                        aVar2.Eco = str;
                        aVar2.Ecp = String.valueOf(System.currentTimeMillis());
                        if ("user".equalsIgnoreCase(str2) || "environment".equalsIgnoreCase(str2)) {
                            str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                        }
                        String str3 = aVar2.Ecp;
                        Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                        intent2.addCategory("android.intent.category.OPENABLE");
                        if (Util.isNullOrNil(str)) {
                            intent2.setType("*/*");
                        } else {
                            intent2.setType(str);
                        }
                        if (Util.isNullOrNil(str2)) {
                            if (com.tencent.mm.compatible.util.d.oE(16)) {
                                Log.i("MicroMsg.WebJSSDKUtil", "android API version is below 16.");
                                intentArr = new Intent[]{com.tencent.mm.plugin.webview.k.d.aYX(str3)};
                                z = false;
                            }
                            z = false;
                        } else if ("camera".equalsIgnoreCase(str2)) {
                            intentArr = new Intent[]{com.tencent.mm.plugin.webview.k.d.aYX(str3)};
                            z = false;
                        } else if ("camcorder".equalsIgnoreCase(str2)) {
                            intentArr = new Intent[]{com.tencent.mm.plugin.webview.k.d.gcV()};
                            z = false;
                        } else if ("microphone".equalsIgnoreCase(str2)) {
                            intentArr = new Intent[]{com.tencent.mm.plugin.webview.k.d.gcW()};
                            z = false;
                        } else {
                            if ("*".equalsIgnoreCase(str2) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2) || "false".equalsIgnoreCase(str2)) {
                                if (str.equalsIgnoreCase("image/*")) {
                                    intentArr = new Intent[]{com.tencent.mm.plugin.webview.k.d.aYX(str3)};
                                } else if (str.equalsIgnoreCase("audio/*")) {
                                    intentArr = new Intent[]{com.tencent.mm.plugin.webview.k.d.gcW()};
                                } else if (str.equalsIgnoreCase("video/*")) {
                                    intentArr = new Intent[]{com.tencent.mm.plugin.webview.k.d.gcV()};
                                }
                                if ("false".equalsIgnoreCase(str2) || "*".equalsIgnoreCase(str2)) {
                                    z = true;
                                }
                            }
                            z = false;
                        }
                        if (z || intentArr == null || intentArr.length == 0) {
                            intent = new Intent("android.intent.action.CHOOSER");
                            intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
                            intent.putExtra("android.intent.extra.TITLE", MMApplicationContext.getContext().getString(R.string.j0a));
                            intent.putExtra("android.intent.extra.INTENT", intent2);
                        } else {
                            intent = intentArr[0];
                        }
                        if (!com.tencent.mm.pluginsdk.permission.b.n(activity, "android.permission.CAMERA")) {
                            com.tencent.mm.pluginsdk.permission.b.b(activity, "android.permission.CAMERA", 119);
                            Log.e("AdLandingFloatWebView", "openFileChooser no Permission");
                        } else {
                            try {
                                activity.startActivityForResult(intent, 2003);
                            } catch (Exception e2) {
                                Log.e("AdLandingFloatWebView", "openFileChooser e = %s", e2);
                            }
                        }
                    }
                    AppMethodBeat.o(202851);
                    return true;
                }
            } catch (Throwable th) {
                Log.e("AdLandingFloatWebView", "onShowFileChooser has something wrong");
            }
            AppMethodBeat.o(202851);
            return false;
        }

        @Override // com.tencent.xweb.x
        public final boolean b(WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(202852);
            Log.d("AdLandingFloatWebView", "onJsConfirm");
            boolean b2 = super.b(webView, str, str2, jsResult);
            AppMethodBeat.o(202852);
            return b2;
        }

        @Override // com.tencent.xweb.x
        public final boolean a(WebView webView, String str, String str2, JsResult jsResult) {
            return false;
        }
    }

    static boolean aJ(Activity activity) {
        AppMethodBeat.i(202859);
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            AppMethodBeat.o(202859);
            return false;
        }
        AppMethodBeat.o(202859);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        ValueCallback<Uri> Ecm;
        ValueCallback<Uri[]> Ecn;
        String Eco;
        String Ecp;

        a() {
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        public final void onGlobalLayout() {
            View childAt;
            AppMethodBeat.i(202845);
            try {
                Log.i("AdLandingFloatWebView", "viewTreeObserver OnGlobalLayoutListener is called");
                View view = e.this.contentView;
                if (view != null && view.getViewTreeObserver().isAlive()) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    View rootView = view.getRootView();
                    if (rootView != null) {
                        view = rootView;
                    }
                    View findViewById = view.findViewById(R.id.j3f);
                    if ((findViewById instanceof ViewGroup) && ((ViewGroup) findViewById).getChildCount() > 0) {
                        View childAt2 = ((ViewGroup) findViewById).getChildAt(0);
                        if (childAt2 == null) {
                            AppMethodBeat.o(202845);
                            return;
                        }
                        View findViewById2 = childAt2.findViewById(R.id.bez);
                        if ((findViewById2 instanceof ViewGroup) && ((ViewGroup) findViewById2).getChildCount() > 0 && (childAt = ((ViewGroup) findViewById2).getChildAt(0)) != null) {
                            e eVar = e.this;
                            childAt.getWidth();
                            int height = childAt.getHeight();
                            if (!(eVar.EbY == null || eVar.EbX == null || eVar.iGY == null)) {
                                Log.d("AdLandingFloatWebView", "on event center information: the  height is ".concat(String.valueOf(height)));
                                Log.d("AdLandingFloatWebView", "on event center information: the  height of mPlaceHolderView is " + eVar.EbY.getHeight());
                                Log.d("AdLandingFloatWebView", "on event center information: the  height of mScrollableLayout is " + eVar.EbX.getHeight());
                                Log.d("AdLandingFloatWebView", "on event center information: the  height of mWebView is " + eVar.iGY.getHeight());
                                ViewGroup.LayoutParams layoutParams = eVar.EbY.getLayoutParams();
                                layoutParams.height = height;
                                eVar.EbY.setLayoutParams(layoutParams);
                                ViewGroup.LayoutParams layoutParams2 = eVar.iGY.getLayoutParams();
                                layoutParams2.height = eVar.YT(eVar.EbX.getHeight());
                                eVar.iGY.setLayoutParams(layoutParams2);
                                eVar.EbX.setMaxYScrollOffset(height);
                                eVar.EbX.requestLayout();
                            }
                        }
                    }
                }
                AppMethodBeat.o(202845);
            } catch (Throwable th) {
                AppMethodBeat.o(202845);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int YT(int i2) {
        AppMethodBeat.i(202860);
        try {
            int i3 = ap.ha(this.context)[1];
            if (i2 == i3 && ao.aQ(this.context)) {
                i2 = i3 - ao.aP(this.context);
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(202860);
        return i2;
    }

    private String aPV(String str) {
        AppMethodBeat.i(202861);
        try {
            ah fds = fds();
            if (fds != null && !TextUtils.isEmpty(str)) {
                String str2 = fds.DZW;
                if (TextUtils.isEmpty(str2)) {
                    str2 = fds.uxInfo;
                }
                if (!TextUtils.isEmpty(str2)) {
                    str = r.kb(str, str2);
                }
                str = com.tencent.mm.plugin.sns.ad.d.a.a.aND(str);
            }
        } catch (Throwable th) {
            Log.e("AdLandingFloatWebView", "fill url param occur error!");
        }
        AppMethodBeat.o(202861);
        return str;
    }
}
