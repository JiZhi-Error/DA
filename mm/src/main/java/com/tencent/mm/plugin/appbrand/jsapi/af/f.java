package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.Toast;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.k;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.af.e;
import com.tencent.mm.plugin.appbrand.platform.window.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper;
import com.tencent.mm.plugin.webview.modeltools.d;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public class f implements View.OnCreateContextMenuListener, e.a {
    private String mGQ;
    private MMWebViewWithJsApi mHe;
    private b mHf;
    private a mHg;
    private com.tencent.mm.plugin.webview.stub.e mHh;
    private g mHi;
    private l mHj;
    private String mHk;
    private String mHl;
    int mHm;
    int mHn;
    h mHo;
    WebView.b mHp;
    WebView.b mHq;
    private final d mHr = new d();
    final e.c mHs;
    private com.tencent.mm.plugin.webview.d.h mHt;
    ScanCodeSheetItemLogic mHu;
    private m mHv = new m() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final boolean f(int i2, final Bundle bundle) {
            AppMethodBeat.i(21069);
            if (i2 == 110001) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(21068);
                        f fVar = f.this;
                        Bundle bundle = bundle;
                        Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onFetchQrCodeResp");
                        fVar.mHu.q(bundle.getInt("key_resp_ret", -1), bundle.getByteArray("key_resp_item_bytes"));
                        AppMethodBeat.o(21068);
                    }
                });
            }
            boolean f2 = super.f(i2, bundle);
            AppMethodBeat.o(21069);
            return f2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final Bundle j(int i2, Bundle bundle) {
            AppMethodBeat.i(21070);
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_webview_container_env", "miniProgram");
            switch (i2) {
                case 18:
                    Context f2 = f.f(f.this);
                    if (!(f2 instanceof Activity)) {
                        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "AC_GET_PUBLISHER_ID invalid context(%s) hash(%d) url(%s)", f2, Integer.valueOf(f.this.mHs.hashCode()), f.this.mHe.getUrl());
                        break;
                    } else {
                        bundle2.putString("KPublisherId", ((Activity) f2).getIntent().getStringExtra("KPublisherId"));
                        bundle2.putInt("getA8KeyScene", fWY());
                        bundle2.putString("url", f.this.mGQ);
                        break;
                    }
                case 87:
                    boolean gio = f.this.mHf.gio();
                    String coy = f.this.mHf.coy();
                    Map gip = f.this.mHf.gip();
                    if (gio) {
                        bundle2.putString("result", "not_return");
                        break;
                    } else {
                        bundle2.putString("full_url", Util.nullAsNil(coy));
                        if (gip != null && gip.size() != 0) {
                            bundle2.putInt("set_cookie", 1);
                            com.tencent.xweb.d.lA(MMApplicationContext.getContext());
                            com.tencent.xweb.c hsp = com.tencent.xweb.c.hsp();
                            for (String str : gip.keySet()) {
                                hsp.setCookie(Util.nullAsNil(coy), str + "=" + ((String) gip.get(str)));
                            }
                            com.tencent.xweb.d.hsr();
                            com.tencent.xweb.d.sync();
                            Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cookies:%s", hsp.getCookie(Util.nullAsNil(coy)));
                            break;
                        } else {
                            bundle2.putInt("set_cookie", 0);
                            break;
                        }
                    }
                    break;
                case 101:
                    bundle.setClassLoader(f.class.getClassLoader());
                    Context castActivityOrNull = AndroidContextUtil.castActivityOrNull(f.f(f.this));
                    if (castActivityOrNull == null) {
                        castActivityOrNull = f.f(f.this);
                    }
                    com.tencent.mm.br.c.b(castActivityOrNull, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")));
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX /*{ENCODED_INT: 139}*/:
                    try {
                        f.this.mHs.ah(new JSONObject(bundle.getString("info")));
                        break;
                    } catch (Exception e2) {
                        break;
                    }
                case 140:
                    bundle2.putInt("key_webview_preverify_info_scene", 1);
                    bundle2.putString("key_webview_preverify_info_source_appid", f.this.mHs.getAppId());
                    break;
                case 145:
                    bundle2.putStringArray("key_webview_apbrand_jsapi_report_args", f.this.mHs.getJsApiReportArgs());
                    break;
                case 302:
                    Context f3 = f.f(f.this);
                    if (!(f3 instanceof Activity)) {
                        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "AC_GET_OPEN_WEAPP_ACTIVITY_IPC_DELEGATE invalid context(%s) hash(%d) url(%s)", f3, Integer.valueOf(f.this.mHs.hashCode()), f.this.mHe.getUrl());
                        break;
                    } else {
                        bundle2.putParcelable("delegate", ActivityStarterIpcDelegate.aJ(f3));
                        break;
                    }
                case 4001:
                case 4002:
                case WearableStatusCodes.DATA_ITEM_TOO_LARGE:
                case WearableStatusCodes.INVALID_TARGET_NODE:
                case WearableStatusCodes.ASSET_UNAVAILABLE:
                case WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED:
                    k kVar = new k();
                    kVar.dCc.context = f.f(f.this);
                    kVar.dCc.actionCode = i2;
                    if (4003 == i2) {
                        kVar.dCc.dCe = bundle.getString("apdu");
                    } else if (4004 == i2) {
                        String string = bundle.getString("apdus");
                        boolean z = bundle.getBoolean("breakIfFail", true);
                        boolean z2 = bundle.getBoolean("breakIfTrue", false);
                        kVar.dCc.dCe = string;
                        kVar.dCc.dCf = z;
                        kVar.dCc.dCg = z2;
                    }
                    Log.i("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult actionCode: %d", Integer.valueOf(kVar.dCc.actionCode));
                    try {
                        NFCIPCHelper.NFCEventTransfer nFCEventTransfer = (NFCIPCHelper.NFCEventTransfer) XIPCInvoker.a(ToolsProcessIPCService.dkO, new NFCIPCHelper.NFCEventTransfer(kVar), NFCIPCHelper.a.class);
                        if (nFCEventTransfer == null || nFCEventTransfer.dCh == null) {
                            NFCIPCHelper.gdo();
                        } else {
                            kVar.dCd.dCh = nFCEventTransfer.dCh;
                        }
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.NFCIPCHelper", e3, "alvinluo nfcInvokeAsResult exception", new Object[0]);
                        NFCIPCHelper.gdo();
                    }
                    if (kVar.dCd.dCh != null) {
                        bundle2.putAll(kVar.dCd.dCh);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(21070);
            return bundle2;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void e(String str, String str2, int i2, int i3) {
            AppMethodBeat.i(21071);
            Log.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: ".concat(String.valueOf(str2)));
            if (f.this.mHo == null || str == null || !str.equals(f.this.mHo.Jbk)) {
                AppMethodBeat.o(21071);
                return;
            }
            boolean k = f.k(f.this);
            if (!k && i2 != 22) {
                AppMethodBeat.o(21071);
            } else if (!k || com.tencent.mm.plugin.scanner.g.ck(i2, str2)) {
                if (f.this.mHo != null) {
                    f.this.mHo.gdA();
                }
                f.this.mHm = i2;
                f.this.mHn = i3;
                if (str2 == null || f.this.mHj == null) {
                    AppMethodBeat.o(21071);
                    return;
                }
                f.c(f.this, str2);
                f.this.mHk = str2;
                if (f.this.mHj != null && f.this.mHj.QuS.isShowing()) {
                    f.b(f.this);
                }
                AppMethodBeat.o(21071);
            } else {
                f.this.mHk = null;
                AppMethodBeat.o(21071);
            }
        }
    };
    private h.c mHw = new h.c() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass8 */

        @Override // com.tencent.mm.plugin.webview.modeltools.h.c
        public final void abF(String str) {
            AppMethodBeat.i(21081);
            try {
                if (f.this.mHh != null) {
                    f.this.mHh.a(str, new int[]{3}, 0, 0);
                    AppMethodBeat.o(21081);
                    return;
                }
                Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
                AppMethodBeat.o(21081);
            } catch (RemoteException e2) {
                Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
                AppMethodBeat.o(21081);
            }
        }
    };

    static /* synthetic */ boolean a(f fVar, ContextMenu contextMenu, String str) {
        AppMethodBeat.i(227043);
        boolean a2 = fVar.a(contextMenu, str);
        AppMethodBeat.o(227043);
        return a2;
    }

    static /* synthetic */ Context f(f fVar) {
        AppMethodBeat.i(227040);
        Context context = fVar.getContext();
        AppMethodBeat.o(227040);
        return context;
    }

    static /* synthetic */ boolean k(f fVar) {
        AppMethodBeat.i(227041);
        boolean bLy = fVar.bLy();
        AppMethodBeat.o(227041);
        return bLy;
    }

    public f(e.c cVar) {
        AppMethodBeat.i(21102);
        this.mHs = cVar;
        this.mHe = (MMWebViewWithJsApi) cVar.getWebView();
        this.mHf = new b(this.mHe);
        this.mHg = new a(this.mHe);
        this.mHe.setWebViewClient(this.mHf);
        this.mHe.setWebChromeClient(this.mHg);
        this.mHe.setCleanOnDetached(false);
        this.mHu = new ScanCodeSheetItemLogic(getContext(), new ScanCodeSheetItemLogic.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a
            public final void bLz() {
                AppMethodBeat.i(21067);
                if (f.this.mHj != null && f.this.mHj.QuS.isShowing()) {
                    f.b(f.this);
                }
                AppMethodBeat.o(21067);
            }
        });
        this.mHj = new l(getContext());
        this.mHj.a(this.mHe, this, null);
        AppMethodBeat.o(21102);
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        AppMethodBeat.i(21103);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mHe.getContext());
        if (castActivityOrNull == null) {
            Context context = this.mHe.getContext();
            AppMethodBeat.o(21103);
            return context;
        }
        AppMethodBeat.o(21103);
        return castActivityOrNull;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.a
    public final void cleanup() {
        AppMethodBeat.i(21104);
        this.mHf.cleanup();
        a aVar = this.mHg;
        while (!aVar.Jyu.isEmpty()) {
            aVar.Jyu.pollFirst().cancel();
        }
        AppMethodBeat.o(21104);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.a
    public final void s(boolean z, int i2) {
        AppMethodBeat.i(21105);
        Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "notifyKeyboardStateChanged, shown[%b], height[%d]", Boolean.valueOf(z), Integer.valueOf(i2));
        com.tencent.mm.plugin.webview.d.h hVar = this.mHt;
        if (hVar != null) {
            if (!z) {
                i2 = 0;
            }
            hVar.afV(i2);
        }
        AppMethodBeat.o(21105);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.a
    public final void onForeground() {
        AppMethodBeat.i(21106);
        if (this.mHf.JpW != null) {
            this.mHf.JpW.yY(true);
        }
        AppMethodBeat.o(21106);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.a
    public final void onBackground() {
        AppMethodBeat.i(21107);
        if (this.mHf.JpW != null) {
            this.mHf.JpW.yY(false);
        }
        AppMethodBeat.o(21107);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.a
    public final int getBinderID() {
        AppMethodBeat.i(174923);
        int hashCode = this.mHf.iGY.hashCode();
        AppMethodBeat.o(174923);
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public class b extends com.tencent.mm.plugin.webview.ui.tools.widget.k {
        private com.tencent.mm.plugin.webview.ui.tools.c mHI;

        b(MMWebView mMWebView) {
            super(mMWebView);
            AppMethodBeat.i(180295);
            if (f.this.mHs.NA()) {
                this.JyE = new c(this.ctH);
            }
            AppMethodBeat.o(180295);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final boolean abG(String str) {
            AppMethodBeat.i(21088);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(21088);
                return true;
            } else if (URLUtil.isAboutUrl(str)) {
                AppMethodBeat.o(21088);
                return false;
            } else if (!URLUtil.isFileUrl(str)) {
                Uri parse = Uri.parse(str);
                if (Util.isNullOrNil(parse.getHost())) {
                    AppMethodBeat.o(21088);
                    return true;
                } else if (!parse.getHost().contains(com.tencent.luggage.h.h.Ph())) {
                    AppMethodBeat.o(21088);
                    return true;
                } else {
                    AppMethodBeat.o(21088);
                    return false;
                }
            } else {
                boolean equals = "file:///android_asset/jsapi/wxjs.js".equals(str);
                AppMethodBeat.o(21088);
                return equals;
            }
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final m bLB() {
            AppMethodBeat.i(21089);
            m mVar = f.this.mHv;
            AppMethodBeat.o(21089);
            return mVar;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void a(com.tencent.mm.plugin.webview.stub.e eVar, g gVar) {
            AppMethodBeat.i(227035);
            f.this.mHh = eVar;
            f.this.mHi = gVar;
            try {
                Bundle bundle = new Bundle();
                bundle.putString("key_webview_container_env", "miniProgram");
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("jsapiargs", bundle);
                eVar.a(20, bundle2, this.iGY.hashCode());
                AppMethodBeat.o(227035);
            } catch (RemoteException e2) {
                Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + e2.getMessage());
                AppMethodBeat.o(227035);
            }
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void cleanup() {
            AppMethodBeat.i(21091);
            super.cleanup();
            if (this.mHI != null) {
                this.mHI.detach();
            }
            AppMethodBeat.o(21091);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final boolean a(WebView webView, String str, boolean z) {
            AppMethodBeat.i(227036);
            Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "doUpdateVisitedHistory, view.url[%s], updatedUrl[%s], isReload[%b]", webView.getUrl(), str, Boolean.valueOf(z));
            String url = webView.getUrl();
            LinkedList linkedList = new LinkedList();
            String url2 = webView.getUrl();
            if (URLUtil.isAboutUrl(url2)) {
                linkedList.add(new IDKey(1097, 1, 1));
                linkedList.add(new IDKey(1097, 5, 1));
            } else if (Util.nullAsNil(url2).startsWith("file:///android_asset/")) {
                linkedList.add(new IDKey(1097, 3, 1));
                linkedList.add(new IDKey(1097, 5, 1));
            } else if (!URLUtil.isNetworkUrl(url2)) {
                linkedList.add(new IDKey(1097, 5, 1));
            }
            if (linkedList.size() > 0) {
                f.this.mHs.getReporter().H(new ArrayList<>(linkedList));
                url = str;
            }
            if (URLUtil.isAboutUrl(str)) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(new IDKey(1097, 2, 1));
                linkedList2.add(new IDKey(1097, 6, 1));
                f.this.mHs.getReporter().H(new ArrayList<>(linkedList2));
                AppMethodBeat.o(227036);
            } else if (Util.nullAsNil(str).startsWith("file:///android_asset/")) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(new IDKey(1097, 4, 1));
                linkedList3.add(new IDKey(1097, 6, 1));
                f.this.mHs.getReporter().H(new ArrayList<>(linkedList3));
                AppMethodBeat.o(227036);
            } else {
                if (!URLUtil.isNetworkUrl(str)) {
                    f.this.mHs.getReporter().xK(6);
                    url = webView.getUrl();
                }
                if (this.Jyz) {
                    av(url, false);
                } else if (this.IRi != null && !this.IRi.has(url)) {
                    Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "doUpdateVisitedHistory start geta8key, url = %s", url);
                    av(url, false);
                }
                AppMethodBeat.o(227036);
            }
            return true;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void av(String str, boolean z) {
            AppMethodBeat.i(227037);
            LinkedList linkedList = new LinkedList();
            if (URLUtil.isAboutUrl(str)) {
                linkedList.add(new IDKey(1097, 12, 1));
                linkedList.add(new IDKey(1097, 14, 1));
            } else if (Util.nullAsNil(str).startsWith("file:///android_asset/")) {
                linkedList.add(new IDKey(1097, 13, 1));
                linkedList.add(new IDKey(1097, 14, 1));
            } else if (!URLUtil.isNetworkUrl(str)) {
                linkedList.add(new IDKey(1097, 14, 1));
            }
            if (linkedList.size() > 0) {
                f.this.mHs.getReporter().H(new ArrayList<>(linkedList));
                Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startGetA8Key with invalid url[%s], force[%b]", str, Boolean.valueOf(z));
            } else {
                f.this.mHs.getReporter().xK(11);
            }
            super.av(str, z);
            AppMethodBeat.o(227037);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final boolean Lb(String str) {
            boolean z;
            AppMethodBeat.i(21092);
            if (str.startsWith("file:///android_asset")) {
                Log.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found %s", str);
                AppMethodBeat.o(21092);
                return true;
            } else if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse(str));
                Context context = this.iGY.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(21092);
                return true;
            } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                Intent intent2 = new Intent("android.intent.action.SENDTO");
                intent2.setData(Uri.parse(str));
                Context context2 = this.iGY.getContext();
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(21092);
                return true;
            } else {
                if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str) || Util.nullAsNil(str).startsWith("weixin")) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found unacceptable %s", str);
                    AppMethodBeat.o(21092);
                    return true;
                }
                AppMethodBeat.o(21092);
                return false;
            }
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k, com.tencent.xweb.ac
        public final void a(WebView webView, r rVar, SslError sslError) {
            AppMethodBeat.i(21093);
            String str = f.this.mGQ;
            if (str == null) {
                Log.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "urlStr == null, return");
                AppMethodBeat.o(21093);
                return;
            }
            if (this.mHI == null) {
                this.mHI = new com.tencent.mm.plugin.webview.ui.tools.c(this.ctH, this.iGY);
            }
            this.mHI.a(str, rVar, sslError);
            AppMethodBeat.o(21093);
        }

        @Override // com.tencent.xweb.ac
        public final void e(WebView webView, String str) {
            AppMethodBeat.i(227038);
            super.e(webView, str);
            f.this.mHs.abD(str);
            AppMethodBeat.o(227038);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void a(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(21094);
            f.this.mGQ = str;
            f.this.mHs.abC(str);
            AppMethodBeat.o(21094);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void f(WebView webView, String str) {
            AppMethodBeat.i(21095);
            f.this.mGQ = str;
            f.this.mHs.cW(str);
            AppMethodBeat.o(21095);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final int bLC() {
            AppMethodBeat.i(21096);
            if (f.this.mHs.bLu()) {
                AppMethodBeat.o(21096);
                return 55;
            }
            AppMethodBeat.o(21096);
            return 49;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final int bLD() {
            AppMethodBeat.i(21097);
            if (f.this.mHs.bLu()) {
                AppMethodBeat.o(21097);
                return 55;
            }
            AppMethodBeat.o(21097);
            return 49;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final String abH(String str) {
            AppMethodBeat.i(21098);
            if (f.this.mGQ == null || !f.this.mGQ.equals(str)) {
                String str2 = f.this.mGQ;
                AppMethodBeat.o(21098);
                return str2;
            }
            AppMethodBeat.o(21098);
            return "";
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void f(Bundle bundle, String str) {
            AppMethodBeat.i(21099);
            super.f(bundle, str);
            bundle.putString("geta8key_data_appid", f.this.mHs.getAppId());
            AppMethodBeat.o(21099);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k, com.tencent.xweb.ac
        public final void a(WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(21100);
            f.this.mHs.z(str2, i2, str);
            AppMethodBeat.o(21100);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void a(com.tencent.mm.plugin.webview.d.h hVar) {
            AppMethodBeat.i(227039);
            super.a(hVar);
            if (!(hVar == null || f.this.mHs == null)) {
                hVar.IRp = f.this.mHs.getAppId();
            }
            f.this.mHt = hVar;
            AppMethodBeat.o(227039);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends i {
        private C0601a mHE;
        private h.c mHF;

        a(MMWebViewWithJsApi mMWebViewWithJsApi) {
            super(mMWebViewWithJsApi);
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.af.f$a$a  reason: collision with other inner class name */
        final class C0601a implements a.AbstractC0786a {
            com.tencent.mm.plugin.appbrand.platform.window.a.a mHH;

            private C0601a() {
            }

            /* synthetic */ C0601a(a aVar, byte b2) {
                this();
            }

            @Override // com.tencent.mm.plugin.appbrand.platform.window.a.a.AbstractC0786a
            public final boolean xM(int i2) {
                AppMethodBeat.i(227031);
                if (f.this.mHs.getPageView().getFullscreenImpl() == null) {
                    AppMethodBeat.o(227031);
                    return false;
                }
                uninstall();
                f.this.mHs.getPageView().getFullscreenImpl().vH(d.a.yX(i2));
                AppMethodBeat.o(227031);
                return true;
            }

            /* access modifiers changed from: package-private */
            public final void uninstall() {
                AppMethodBeat.i(227032);
                if (this.mHH != null) {
                    this.mHH.b(this);
                }
                AppMethodBeat.o(227032);
            }
        }

        @Override // com.tencent.xweb.x
        public final boolean a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            AppMethodBeat.i(227033);
            if (f.this.mHs.bLr()) {
                if (this.mHE == null) {
                    this.mHE = new C0601a(this, (byte) 0);
                }
                C0601a aVar = this.mHE;
                Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(f.this.mHs.getPageView().getContext());
                if (castActivityOrNull instanceof com.tencent.mm.plugin.appbrand.platform.window.a.a) {
                    aVar.mHH = (com.tencent.mm.plugin.appbrand.platform.window.a.a) castActivityOrNull;
                    aVar.mHH.a(aVar);
                }
            }
            String appId = f.this.mHs.getAppId();
            AnonymousClass1 r1 = new h.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void a(h.d dVar) {
                    AppMethodBeat.i(227026);
                    if (dVar == h.d.LAUNCH_MINI_PROGRAM) {
                        leaveFullscreen();
                    }
                    AppMethodBeat.o(227026);
                }

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void bra() {
                    AppMethodBeat.i(227027);
                    leaveFullscreen();
                    AppMethodBeat.o(227027);
                }

                private void leaveFullscreen() {
                    AppMethodBeat.i(227028);
                    f.this.mHs.getWebView().leaveFullscreen();
                    AppMethodBeat.o(227028);
                }
            };
            this.mHF = r1;
            com.tencent.mm.plugin.appbrand.h.a(appId, r1);
            AppMethodBeat.o(227033);
            return false;
        }

        @Override // com.tencent.xweb.x
        public final boolean bLA() {
            AppMethodBeat.i(227034);
            if (this.mHE != null) {
                this.mHE.uninstall();
            }
            com.tencent.mm.plugin.appbrand.h.b(f.this.mHs.getAppId(), this.mHF);
            f.this.mHs.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(227029);
                    if (f.this.mHs.getPageView().getFullscreenImpl() != null) {
                        f.this.mHs.getPageView().getFullscreenImpl().btC();
                        com.tencent.mm.plugin.appbrand.page.a.d dVar = (com.tencent.mm.plugin.appbrand.page.a.d) f.this.mHs.getPageView().S(com.tencent.mm.plugin.appbrand.page.a.d.class);
                        if (dVar != null) {
                            dVar.a(null);
                        }
                    }
                    AppMethodBeat.o(227029);
                }
            });
            AppMethodBeat.o(227034);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.i, com.tencent.xweb.x
        public final void d(WebView webView, String str) {
            AppMethodBeat.i(21083);
            super.d(webView, str);
            f.this.mHs.abB(str);
            AppMethodBeat.o(21083);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.i
        public final void onClose() {
            AppMethodBeat.i(21084);
            f.this.mHs.bLs();
            AppMethodBeat.o(21084);
        }

        @Override // com.tencent.xweb.x
        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            AppMethodBeat.i(21085);
            a(valueCallback, (ValueCallback<Uri[]>) null, str, str2);
            AppMethodBeat.o(21085);
        }

        @Override // com.tencent.xweb.x
        public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, x.a aVar) {
            AppMethodBeat.i(21086);
            if (aVar.getMode() != 0) {
                AppMethodBeat.o(21086);
                return false;
            } else if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                AppMethodBeat.o(21086);
                return true;
            } else {
                String str = aVar.getAcceptTypes()[0];
                String str2 = "*";
                if (aVar.isCaptureEnabled()) {
                    if ("image/*".equalsIgnoreCase(str)) {
                        str2 = "camera";
                    } else if ("video/*".equalsIgnoreCase(str)) {
                        str2 = "camcorder";
                    }
                }
                a((ValueCallback<Uri>) null, valueCallback, str, str2);
                AppMethodBeat.o(21086);
                return true;
            }
        }

        private void a(ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
            AppMethodBeat.i(21087);
            Context f2 = f.f(f.this);
            if (!(f2 instanceof Activity)) {
                Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startFileChooser, invalid context(%s) hash(%d) url(%s)", f2, Integer.valueOf(f.this.mHs.hashCode()), f.this.mHe.getUrl());
                AppMethodBeat.o(21087);
                return;
            }
            final Activity activity = (Activity) f2;
            com.tencent.luggage.h.f.aK(activity).b(new f.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.a.AnonymousClass3 */

                @Override // com.tencent.luggage.h.f.c
                public final boolean c(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(227030);
                    boolean d2 = f.this.mHr.d(activity, i2, i3, intent);
                    AppMethodBeat.o(227030);
                    return d2;
                }
            });
            f.this.mHr.a(activity, f.this.mHi, valueCallback, valueCallback2, str, str2);
            AppMethodBeat.o(21087);
        }
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(21108);
        try {
            z = this.mHh.isSDCardAvailable();
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + e2.getMessage());
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(21108);
            return true;
        } else if (this.mHi == null) {
            AppMethodBeat.o(21108);
            return true;
        } else {
            contextMenu.setHeaderTitle(R.string.j4r);
            try {
                z2 = this.mHh.gdW();
            } catch (Exception e3) {
                Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", e3.getMessage());
                z2 = false;
            }
            boolean gtH = this.mHi.gdI().gtH();
            boolean gtI = this.mHi.gdI().gtI();
            Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", Boolean.valueOf(z2), Boolean.valueOf(gtH), Boolean.valueOf(gtI));
            if (z2 && gtH) {
                contextMenu.add(0, 0, 0, getContext().getString(R.string.ftk)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass4 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(21076);
                        try {
                            z.a(f.f(f.this), f.this.mHl, com.tencent.xweb.c.hsp().getCookie(f.this.mHl), f.this.mHh.isSDCardAvailable(), new z.a() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass4.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.ui.tools.z.a
                                public final void abE(String str) {
                                    AppMethodBeat.i(21075);
                                    if (Util.isNullOrNil(str)) {
                                        Log.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
                                        AppMethodBeat.o(21075);
                                        return;
                                    }
                                    f.d(f.this, str);
                                    AppMethodBeat.o(21075);
                                }
                            });
                        } catch (Exception e2) {
                            Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e2.getMessage());
                        }
                        AppMethodBeat.o(21076);
                        return true;
                    }
                });
            }
            contextMenu.add(0, 0, 0, getContext().getString(R.string.gau)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass5 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    boolean z;
                    AppMethodBeat.i(21077);
                    try {
                        z = f.this.mHh.isSDCardAvailable();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e2.getMessage());
                        z = false;
                    }
                    try {
                        Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick saveImage2SD with url[%s]", f.this.mHl);
                        z.b(f.f(f.this), f.this.mHl, com.tencent.xweb.c.hsp().getCookie(f.this.mHl), z);
                    } catch (Exception e3) {
                        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", e3.getMessage());
                    }
                    AppMethodBeat.o(21077);
                    return true;
                }
            });
            if (z2 && gtI) {
                contextMenu.add(0, 0, 0, getContext().getString(R.string.fn9)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass6 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(21079);
                        try {
                            boolean isSDCardAvailable = f.this.mHh.isSDCardAvailable();
                            String replaceAll = f.this.mHl.replaceAll("tp=webp", "");
                            z.a(f.f(f.this), replaceAll, com.tencent.xweb.c.hsp().getCookie(replaceAll), isSDCardAvailable, new z.a() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass6.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.ui.tools.z.a
                                public final void abE(String str) {
                                    AppMethodBeat.i(21078);
                                    f.e(f.this, str);
                                    AppMethodBeat.o(21078);
                                }
                            });
                        } catch (Exception e2) {
                            Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e2.getMessage());
                        }
                        AppMethodBeat.o(21079);
                        return true;
                    }
                });
            }
            this.mHj.QuS.setFooterView(null);
            if (this.mHk != null) {
                boolean bLy = bLy();
                boolean ca = com.tencent.mm.plugin.scanner.g.ca(this.mHm, this.mHk);
                if (bLy || ca) {
                    final String str2 = this.mHk;
                    if (ca) {
                        getContext().getString(R.string.fv5);
                    } else {
                        getContext().getString(R.string.gdg);
                    }
                    this.mHj.QuS.setFooterView(this.mHu.a(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass7 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(21080);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (f.this.mHj != null && f.this.mHj.QuS.isShowing()) {
                                f.this.mHj.dismiss();
                            }
                            f fVar = f.this;
                            String str = str2;
                            String str2 = f.this.mGQ;
                            String str3 = str;
                            int i2 = f.this.mHm;
                            int i3 = f.this.mHn;
                            if (str != null) {
                                Intent intent = new Intent();
                                intent.setClass(fVar.getContext(), WebviewScanImageActivity.class);
                                intent.putExtra("key_string_for_scan", str);
                                intent.putExtra("key_string_for_url", str2);
                                intent.putExtra("key_string_for_image_url", str3);
                                intent.putExtra("key_codetype_for_scan", i2);
                                intent.putExtra("key_codeversion_for_scan", i3);
                                if (fVar.mHs != null && !Util.isNullOrNil(fVar.mHs.getAppId())) {
                                    intent.putExtra("key_string_for_wxapp_id", fVar.mHs.getAppId());
                                }
                                Context context = fVar.getContext();
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(21080);
                        }
                    }, this.mHm, this.mHk, 10));
                    AppMethodBeat.o(21108);
                    return true;
                }
                this.mHk = null;
                AppMethodBeat.o(21108);
                return true;
            }
            AppMethodBeat.o(21108);
            return false;
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(21109);
        if (view instanceof android.webkit.WebView) {
            WebView.b hitTestResult = this.mHe.getHitTestResult();
            if (hitTestResult == null) {
                AppMethodBeat.o(21109);
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                boolean a2 = a(contextMenu, hitTestResult.mExtra);
                this.mHl = hitTestResult.mExtra;
                if (!a2 && this.mHi.gdI().gtD()) {
                    this.mHp = hitTestResult;
                    this.mHo = new com.tencent.mm.plugin.webview.modeltools.h();
                    this.mHo.a(this.mHe, this.mHw);
                }
            }
            AppMethodBeat.o(21109);
            return;
        }
        if (view instanceof MMWebView) {
            WebView.b hitTestResult2 = ((MMWebView) view).getHitTestResult();
            if (hitTestResult2 == null) {
                AppMethodBeat.o(21109);
                return;
            } else if (hitTestResult2.mType == 5 || hitTestResult2.mType == 8) {
                boolean a3 = a(contextMenu, hitTestResult2.mExtra);
                this.mHl = hitTestResult2.mExtra;
                if (!a3 && this.mHi.gdI().gtD()) {
                    this.mHq = hitTestResult2;
                    this.mHo = new com.tencent.mm.plugin.webview.modeltools.h();
                    this.mHo.a(this.mHe, this.mHw);
                }
            }
        }
        AppMethodBeat.o(21109);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.a
    public final void setCurrentUrl(String str) {
        this.mGQ = str;
    }

    private boolean bLy() {
        AppMethodBeat.i(21110);
        String str = this.mGQ;
        if (str == null || (!str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP) && !str.startsWith(HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP))) {
            AppMethodBeat.o(21110);
            return false;
        }
        AppMethodBeat.o(21110);
        return true;
    }

    class c extends ar {
        public c(Context context) {
            super(context);
        }

        @Override // com.tencent.mm.plugin.webview.model.ar
        public final WebResourceResponse a(String str, WebResourceRequest webResourceRequest, boolean z, com.tencent.mm.plugin.webview.stub.e eVar) {
            AppMethodBeat.i(180296);
            f.this.mHs.a(f.this.mGQ, webResourceRequest);
            WebResourceResponse a2 = super.a(str, webResourceRequest, z, eVar);
            AppMethodBeat.o(180296);
            return a2;
        }
    }

    static /* synthetic */ void b(f fVar) {
        AppMethodBeat.i(21111);
        fVar.mHs.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(21074);
                f.this.mHj.a(f.this.mHe, new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass3.AnonymousClass1 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(21072);
                        f.a(f.this, contextMenu, f.this.mHk);
                        AppMethodBeat.o(21072);
                    }
                }, null, new e.b() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.af.f.AnonymousClass3.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.widget.a.e.b
                    public final void onDismiss() {
                        AppMethodBeat.i(21073);
                        f.this.mHl = null;
                        f.this.mHk = null;
                        f.this.mHu.onDismiss();
                        if (!(f.this.mHo == null || f.this.mHh == null)) {
                            try {
                                f.this.mHh.aZZ(f.this.mHo.Jbk);
                                f.this.mHo.gdA();
                                AppMethodBeat.o(21073);
                                return;
                            } catch (Exception e2) {
                                Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cancel capture failed");
                            }
                        }
                        AppMethodBeat.o(21073);
                    }
                });
                AppMethodBeat.o(21074);
            }
        });
        AppMethodBeat.o(21111);
    }

    static /* synthetic */ void c(f fVar, String str) {
        AppMethodBeat.i(227042);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "processGetWXACodeNickName mResultOfImageUrl nil");
            AppMethodBeat.o(227042);
            return;
        }
        if (com.tencent.mm.plugin.scanner.g.ci(fVar.mHm, str)) {
            Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "processGetWXACodeNickName");
            Bundle bundle = new Bundle();
            try {
                bundle.putString("wxa_result", str);
                bundle.putInt("wxa_code_type", fVar.mHm);
                bundle.putInt("wxa_code_version", fVar.mHm);
                fVar.mHh.a(110000, bundle, fVar.mHe.hashCode());
                AppMethodBeat.o(227042);
                return;
            } catch (RemoteException e2) {
                Log.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "processGetWXACodeNickName exp:%s", e2.getLocalizedMessage());
            }
        }
        AppMethodBeat.o(227042);
    }

    static /* synthetic */ void d(f fVar, String str) {
        AppMethodBeat.i(227044);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
            intent.putExtra("Retr_Msg_Type", 4);
        }
        com.tencent.mm.br.c.f(fVar.getContext(), ".ui.transmit.MsgRetransmitUI", intent);
        AppMethodBeat.o(227044);
    }

    static /* synthetic */ void e(f fVar, String str) {
        AppMethodBeat.i(227045);
        try {
            if (fVar.mHh.aZX(str) == 0) {
                Toast.makeText(fVar.getContext(), fVar.getContext().getString(R.string.caf), 0).show();
            }
            AppMethodBeat.o(227045);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "favoriteUrl fail, ex = " + e2.getMessage());
            AppMethodBeat.o(227045);
        }
    }
}
