package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.lang.ref.WeakReference;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jv\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2:\u0010\r\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0013\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager;", "", "()V", "TAG", "", "initAdWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "webView", "publishId", "configMpAdAttrs", "Lkotlin/Function2;", "", "", "onPageFinsh", "Lcom/tencent/xweb/WebView;", "Lkotlin/ParameterName;", "name", "view", "url", "getA8KeyScene", "plugin-brandservice_release"})
public final class a {
    public static final a pHf = new a();

    static {
        AppMethodBeat.i(7036);
        AppMethodBeat.o(7036);
    }

    private a() {
    }

    public static MMWebViewWithJsApi a(MMWebViewWithJsApi mMWebViewWithJsApi, String str, m<? super String, ? super Integer, x> mVar, m<? super WebView, ? super String, x> mVar2, int i2) {
        AppMethodBeat.i(175497);
        p.h(mMWebViewWithJsApi, "webView");
        p.h(mVar, "configMpAdAttrs");
        p.h(mVar2, "onPageFinsh");
        z.f fVar = new z.f();
        Context context = mMWebViewWithJsApi.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
            AppMethodBeat.o(175497);
            throw tVar;
        }
        fVar.SYG = (T) new WeakReference((TmplShareWebViewToolUI) context);
        z.f fVar2 = new z.f();
        fVar2.SYG = (T) new WeakReference(mMWebViewWithJsApi);
        mMWebViewWithJsApi.setBackgroundColor(0);
        mMWebViewWithJsApi.setWebViewClient(new C0894a(new b(fVar, str, fVar2, mVar), i2, mVar2, mMWebViewWithJsApi, mMWebViewWithJsApi));
        Log.i("MicroMsg.AdWebViewManager", "init:".concat(String.valueOf(str)));
        AppMethodBeat.o(175497);
        return mMWebViewWithJsApi;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$callback$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "callback", "", "actionCode", "", "data", "Landroid/os/Bundle;", "handleMsg", "func", "", "param", "invokeAsResult", "plugin-brandservice_release"})
    public static final class b extends com.tencent.mm.plugin.webview.ui.tools.widget.m {
        final /* synthetic */ z.f pHk;
        final /* synthetic */ String pHl;
        final /* synthetic */ z.f pHm;
        final /* synthetic */ m pHn;

        b(z.f fVar, String str, z.f fVar2, m mVar) {
            this.pHk = fVar;
            this.pHl = str;
            this.pHm = fVar2;
            this.pHn = mVar;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final boolean f(int i2, Bundle bundle) {
            AppMethodBeat.i(7032);
            p.h(bundle, "data");
            Log.i("MicroMsg.AdWebViewManager", "callback:".concat(String.valueOf(i2)));
            boolean f2 = super.f(i2, bundle);
            AppMethodBeat.o(7032);
            return f2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final Bundle j(int i2, Bundle bundle) {
            AppMethodBeat.i(7033);
            Log.i("MicroMsg.AdWebViewManager", "invokeAsResult:".concat(String.valueOf(i2)));
            Bundle bundle2 = new Bundle();
            if (this.pHk.SYG.get() != null) {
                Object obj = this.pHk.SYG.get();
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
                    AppMethodBeat.o(7033);
                    throw tVar;
                } else if (!((TmplShareWebViewToolUI) obj).isFinishing()) {
                    switch (i2) {
                        case 101:
                            if (bundle == null) {
                                p.hyc();
                            }
                            bundle.setClassLoader(WebViewUI.class.getClassLoader());
                            Context context = (Context) this.pHk.SYG.get();
                            String string = bundle.getString("open_ui_with_webview_ui_plugin_name");
                            String string2 = bundle.getString("open_ui_with_webview_ui_plugin_entry");
                            Intent intent = new Intent();
                            Bundle bundle3 = bundle.getBundle("open_ui_with_webview_ui_extras");
                            if (bundle3 == null) {
                                p.hyc();
                            }
                            c.b(context, string, string2, intent.putExtras(bundle3).putExtra("KPublisherId", Util.nullAsNil(this.pHl)));
                            break;
                        case 201:
                            Object obj2 = this.pHk.SYG.get();
                            if (obj2 != null) {
                                TmplShareWebViewToolUI tmplShareWebViewToolUI = (TmplShareWebViewToolUI) obj2;
                                String string3 = bundle != null ? bundle.getString(NativeProtocol.WEB_DIALOG_ACTION) : null;
                                if (!p.j("sendMPPageData", string3)) {
                                    if (!p.j("closeAdWebview", string3)) {
                                        if (!p.j("adWebviewReady", string3)) {
                                            if (!p.j("dotWebViewReady", string3)) {
                                                if (!p.j("closeDotWebview", string3)) {
                                                    if (!p.j("hideDotWebview", string3)) {
                                                        if (!p.j("getMPVideoState", string3)) {
                                                            if (!p.j("setWebviewBackground", string3)) {
                                                                if (!p.j("opPlayer", string3)) {
                                                                    if (!p.j("setDotScriptData", string3)) {
                                                                        if (p.j("switchVideo", string3)) {
                                                                            tmplShareWebViewToolUI.Y(bundle);
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        tmplShareWebViewToolUI.ae(bundle);
                                                                        break;
                                                                    }
                                                                } else {
                                                                    tmplShareWebViewToolUI.af(bundle);
                                                                    break;
                                                                }
                                                            } else {
                                                                String string4 = bundle.getString("backgroundColor");
                                                                Log.i("MicroMsg.AdWebViewManager", "setWebviewBackground ".concat(String.valueOf(string4)));
                                                                int gw = e.gw(string4, 0);
                                                                if (this.pHm.SYG.get() != null) {
                                                                    Object obj3 = this.pHm.SYG.get();
                                                                    if (obj3 == null) {
                                                                        p.hyc();
                                                                    }
                                                                    ((View) obj3).setBackgroundColor(gw);
                                                                    break;
                                                                }
                                                            }
                                                        } else {
                                                            bundle2.putAll(tmplShareWebViewToolUI.cpH());
                                                            break;
                                                        }
                                                    } else {
                                                        tmplShareWebViewToolUI.ac(bundle);
                                                        break;
                                                    }
                                                } else {
                                                    tmplShareWebViewToolUI.ab(bundle);
                                                    break;
                                                }
                                            } else {
                                                tmplShareWebViewToolUI.ad(bundle);
                                                break;
                                            }
                                        } else {
                                            tmplShareWebViewToolUI.cpG();
                                            break;
                                        }
                                    } else {
                                        tmplShareWebViewToolUI.cpF();
                                        break;
                                    }
                                } else {
                                    tmplShareWebViewToolUI.aa(bundle);
                                    break;
                                }
                            } else {
                                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
                                AppMethodBeat.o(7033);
                                throw tVar2;
                            }
                            break;
                    }
                    AppMethodBeat.o(7033);
                    return bundle2;
                }
            }
            AppMethodBeat.o(7033);
            return bundle2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final Bundle fl(String str, String str2) {
            AppMethodBeat.i(7034);
            if (str != null) {
                switch (str.hashCode()) {
                    case -1083168262:
                        if (str.equals("configMpAdAttrs")) {
                            Log.i("MicroMsg.AdWebViewManager", "configMpAdAttrs:".concat(String.valueOf(str2)));
                            i iVar = new i(str2);
                            String string = iVar.getString("posInfo");
                            int i2 = iVar.getInt("webviewId");
                            m mVar = this.pHn;
                            p.g(string, "posInfo");
                            mVar.invoke(string, Integer.valueOf(i2));
                            Bundle bga = com.tencent.mm.protocal.c.bga("configMpAdAttrs:ok");
                            p.g(bga, "ConstantsJSAPIFunc.creat…ue, \"configMpAdAttrs:ok\")");
                            AppMethodBeat.o(7034);
                            return bga;
                        }
                        break;
                }
            }
            Bundle fl = super.fl(str, str2);
            p.g(fl, "super.handleMsg(func, param)");
            AppMethodBeat.o(7034);
            return fl;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J&\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewClient;", "getA8KeyScene", "", "getWebViewStubCallback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "mmOnPageFinished", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "mmOnPageStarted", "favicon", "Landroid/graphics/Bitmap;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a$a  reason: collision with other inner class name */
    public static final class C0894a extends k {
        final /* synthetic */ b pHg;
        final /* synthetic */ int pHh;
        final /* synthetic */ m pHi;
        final /* synthetic */ MMWebViewWithJsApi pHj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0894a(b bVar, int i2, m mVar, MMWebViewWithJsApi mMWebViewWithJsApi, MMWebView mMWebView) {
            super(mMWebView);
            this.pHg = bVar;
            this.pHh = i2;
            this.pHi = mVar;
            this.pHj = mMWebViewWithJsApi;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final com.tencent.mm.plugin.webview.ui.tools.widget.m bLB() {
            return this.pHg;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final int bLC() {
            return this.pHh;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void a(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(7029);
            super.a(webView, str, bitmap);
            if (webView == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMWebView");
                AppMethodBeat.o(7029);
                throw tVar;
            }
            com.tencent.mm.plugin.webview.model.a.e((MMWebView) webView);
            AppMethodBeat.o(7029);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void f(WebView webView, String str) {
            AppMethodBeat.i(7030);
            super.f(webView, str);
            this.pHi.invoke(webView, str);
            AppMethodBeat.o(7030);
        }
    }
}
