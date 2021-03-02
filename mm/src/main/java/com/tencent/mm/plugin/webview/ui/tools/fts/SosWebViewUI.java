package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.g.b.a.av;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;

public class SosWebViewUI extends WebViewUI {
    private boolean Jpn = false;
    private int Jpo = 0;
    private String Jpp = "";
    private av Jpq = new av();
    private boolean Jpr = false;
    private int Jps = 0;
    private MMHandler Jpt = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.webview.ui.tools.fts.SosWebViewUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(80766);
            if (message.what == 0) {
                try {
                    SosWebViewUI.this.pGj.evaluateJavascript("javascript:window.SosJSApi.onHtmlContentReport('<body>'+document.getElementsByTagName('body')[0].innerHTML+'</body>');", null);
                    AppMethodBeat.o(80766);
                    return;
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.WebSearch.SosWebViewUI", th, "pageHandler", new Object[0]);
                }
            }
            AppMethodBeat.o(80766);
        }
    };
    private a Jpu = new a();
    private int mve = 0;
    private int subType = 0;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SosWebViewUI() {
        AppMethodBeat.i(80773);
        AppMethodBeat.o(80773);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String replace;
        boolean z = false;
        AppMethodBeat.i(80774);
        super.onCreate(bundle);
        this.pGj.addJavascriptInterface(new b(), "SosJSApi");
        this.mve = getIntent().getIntExtra("from_scence", 0);
        this.subType = getIntent().getIntExtra("subtype", 0);
        this.Jpp = getIntent().getStringExtra("rawUrl");
        String stringExtra = getIntent().getStringExtra("key_init_url");
        if (stringExtra != null) {
            z = true;
        }
        this.Jpr = z;
        if (this.Jpr) {
            this.Jpq.eqk = cl.aWA();
            av avVar = this.Jpq;
            avVar.eqx = avVar.x("InitUrl", stringExtra.replace(",", "!"), true);
            String stringExtra2 = getIntent().getStringExtra("key_search_query");
            if (stringExtra2 == null) {
                replace = "";
            } else {
                replace = stringExtra2.replace(",", "!");
            }
            av avVar2 = this.Jpq;
            avVar2.eqv = avVar2.x("Query", replace, true);
        }
        AppMethodBeat.o(80774);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void b(WebView webView, String str) {
        AppMethodBeat.i(211302);
        super.b(webView, str);
        if (this.Jpr) {
            this.Jps++;
        }
        AppMethodBeat.o(211302);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(80775);
        this.pGj.removeJavascriptInterface("SosJSApi");
        this.IMH.b(this.Jpu);
        this.IMH.b(this.Jpu.Jpw);
        if (this.Jpr) {
            this.Jpq.eqw = getActivityBrowseTimeMs();
            this.Jpq.eqy = (long) this.Jps;
            this.Jpq.bfK();
            Log.i("MicroMsg.WebSearch.SosWebViewUI", "FTSRelatedSugH5ReportStruct.report url : %s, enterTime : %d, stayTime : %d, getQuery : %s ,id : %d, pageChangeCount : %d.", this.Jpq.eqx, Long.valueOf(this.Jpq.eqk), Long.valueOf(this.Jpq.eqw), this.Jpq.eqv, 22251, Integer.valueOf(this.Jps));
        }
        super.onDestroy();
        AppMethodBeat.o(80775);
    }

    class a extends k {
        C1989a Jpw = new C1989a();

        a() {
            AppMethodBeat.i(211301);
            AppMethodBeat.o(211301);
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.SosWebViewUI$a$a  reason: collision with other inner class name */
        class C1989a extends f {
            C1989a() {
            }

            @Override // com.tencent.mm.plugin.webview.core.f
            public final void i(WebView webView, String str) {
                AppMethodBeat.i(211296);
                SosWebViewUI.this.Jpp = str;
                SosWebViewUI.this.Jpt.removeMessages(0);
                AppMethodBeat.o(211296);
            }

            @Override // com.tencent.mm.plugin.webview.core.f
            public final void b(WebView webView, String str) {
                AppMethodBeat.i(211297);
                super.b(webView, str);
                SosWebViewUI.this.Jpt.removeMessages(0);
                if (!SosWebViewUI.this.Jpn) {
                    SosWebViewUI.this.Jpt.sendEmptyMessageDelayed(0, 1000);
                }
                AppMethodBeat.o(211297);
            }

            @Override // com.tencent.mm.plugin.webview.core.f
            public final void a(WebView webView, int i2, String str, String str2) {
                AppMethodBeat.i(211298);
                super.a(webView, i2, str, str2);
                if (SosWebViewUI.this.Jpp != null && SosWebViewUI.this.Jpp.equals(str2)) {
                    Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedError %d %s", Integer.valueOf(i2), str);
                    SosWebViewUI.this.Jpo = i2;
                    SosWebViewUI.b(SosWebViewUI.this, "");
                }
                AppMethodBeat.o(211298);
            }

            @Override // com.tencent.mm.plugin.webview.core.f
            public final void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                String str;
                AppMethodBeat.i(211299);
                super.a(webView, webResourceRequest, webResourceResponse);
                if (SosWebViewUI.this.Jpp != null && SosWebViewUI.this.Jpp.equals(webResourceRequest.getUrl().toString())) {
                    SosWebViewUI.this.Jpo = webResourceResponse.mStatusCode;
                    if (SosWebViewUI.this.Jpo < 400 || SosWebViewUI.this.Jpo >= 600) {
                        Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError not report %s %d", webResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.this.Jpo));
                        AppMethodBeat.o(211299);
                        return;
                    }
                    try {
                        str = new String(e.readFromStream(webResourceResponse.mInputStream));
                    } catch (Throwable th) {
                        str = "";
                    }
                    Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedHttpError %s %d %s", webResourceRequest.getUrl().toString(), Integer.valueOf(SosWebViewUI.this.Jpo), str);
                    SosWebViewUI.b(SosWebViewUI.this, str);
                }
                AppMethodBeat.o(211299);
            }

            @Override // com.tencent.mm.plugin.webview.core.f
            public final void a(WebView webView, r rVar, SslError sslError) {
                AppMethodBeat.i(211300);
                super.a(webView, rVar, sslError);
                if (SosWebViewUI.this.Jpp != null && SosWebViewUI.this.Jpp.equals(sslError.getUrl())) {
                    Log.i("MicroMsg.WebSearch.SosWebViewUI", "onReceivedSslError");
                    SosWebViewUI.this.Jpo = -1;
                    SosWebViewUI.b(SosWebViewUI.this, "");
                }
                AppMethodBeat.o(211300);
            }
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final /* bridge */ /* synthetic */ f gai() {
            return this.Jpw;
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final i cpO() {
        AppMethodBeat.i(211303);
        i cpO = super.cpO();
        if (cpO != null) {
            cpO.a(this.Jpu);
        }
        AppMethodBeat.o(211303);
        return cpO;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean cpz() {
        AppMethodBeat.i(175839);
        if (!getIntent().getBooleanExtra("disable_minimize", false)) {
            AppMethodBeat.o(175839);
            return true;
        }
        AppMethodBeat.o(175839);
        return false;
    }

    class b {
        b() {
        }

        @JavascriptInterface
        public final void onHtmlContentReport(String str) {
            AppMethodBeat.i(80772);
            SosWebViewUI.b(SosWebViewUI.this, str);
            AppMethodBeat.o(80772);
        }
    }

    static /* synthetic */ void b(SosWebViewUI sosWebViewUI, String str) {
        AppMethodBeat.i(211304);
        if (!sosWebViewUI.Jpn && sosWebViewUI.mve != 0) {
            sosWebViewUI.Jpn = true;
            if (Util.isNullOrNil(sosWebViewUI.eam) || !sosWebViewUI.eam.startsWith("wes")) {
                AppMethodBeat.o(211304);
                return;
            }
            String[] split = sosWebViewUI.eam.split("#");
            if (split == null || split.length < 5) {
                AppMethodBeat.o(211304);
                return;
            }
            if (sosWebViewUI.Jpo == 0) {
                sosWebViewUI.Jpo = 200;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("deadlinks=1&scene=");
            stringBuffer.append(sosWebViewUI.mve);
            stringBuffer.append("&searchid=");
            stringBuffer.append(split[1]);
            stringBuffer.append("&businesstype=");
            stringBuffer.append(split[2]);
            stringBuffer.append("&docid=");
            stringBuffer.append(split[3]);
            stringBuffer.append("&subtype=");
            stringBuffer.append(sosWebViewUI.subType);
            stringBuffer.append("&contentlength=");
            stringBuffer.append(str.length());
            stringBuffer.append("&status=");
            stringBuffer.append(sosWebViewUI.Jpo);
            stringBuffer.append("&httpstatus=");
            stringBuffer.append(0);
            Log.i("MicroMsg.WebSearch.SosWebViewUI", "reportHtmlStatus %s", stringBuffer.toString());
            Bundle bundle = new Bundle();
            bundle.putString("reportString", stringBuffer.toString());
            try {
                sosWebViewUI.mHh.w(8, bundle);
                AppMethodBeat.o(211304);
                return;
            } catch (RemoteException e2) {
                Log.printErrStackTrace("MicroMsg.WebSearch.SosWebViewUI", e2, "reportHtmlStatus", new Object[0]);
            }
        }
        AppMethodBeat.o(211304);
    }
}
