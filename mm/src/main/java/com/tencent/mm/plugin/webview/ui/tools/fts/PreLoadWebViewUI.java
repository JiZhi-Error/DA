package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.d.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.b;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class PreLoadWebViewUI extends WebViewUI {
    private int IFb = -1;
    boolean IRT;
    private i JoG;
    protected List<Runnable> JoH;
    private boolean JoI = false;
    protected String dVO;
    protected String sessionId;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sessionId = getIntent().getStringExtra("sessionId");
        this.dVO = Util.nullAs(getIntent().getStringExtra("subSessionId"), this.sessionId);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final i gfG() {
        return this.JoG;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final MMWebView cpy() {
        boolean z;
        Intent intent = getIntent();
        WebSearchWebView webSearchWebView = null;
        d dVar = null;
        if (intent != null) {
            this.IFb = intent.getIntExtra("key_preload_biz", -1);
            Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "getting preloaded  webview, biz %d", Integer.valueOf(this.IFb));
            b bVar = b.JpB;
            dVar = b.agX(this.IFb);
        }
        if (dVar != null) {
            this.JoG = dVar.IFj;
            webSearchWebView = dVar.Gqy;
        }
        if (webSearchWebView == null) {
            Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "no available preloaded webview");
            this.IRT = false;
            String coX = coX();
            if (!TextUtils.isEmpty(coX)) {
                z = Util.safeParseInt(Uri.parse(coX).getQueryParameter("isOpenPreload")) == 1;
            } else {
                z = false;
            }
            if (z) {
                h.INSTANCE.a(15005, Integer.valueOf(this.IFb), 4, 0);
            }
            WebSearchWebView webSearchWebView2 = new WebSearchWebView(this);
            webSearchWebView2.addJavascriptInterface(new a(this), "webSearchJSApi");
            return webSearchWebView2;
        }
        Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "use preloaded webview ,%s ", webSearchWebView.toString());
        this.IRT = true;
        webSearchWebView.aG(this);
        h.INSTANCE.a(15005, Integer.valueOf(this.IFb), 3, 0);
        return webSearchWebView;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public com.tencent.mm.plugin.webview.core.i cpO() {
        com.tencent.mm.plugin.webview.core.i cpO = super.cpO();
        if (cpO != null) {
            cpO.a(new j() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.webview.core.j
                public final void cpR() {
                    AppMethodBeat.i(211290);
                    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "onJsReady");
                    PreLoadWebViewUI.this.cpR();
                    AppMethodBeat.o(211290);
                }
            });
        }
        return cpO;
    }

    /* access modifiers changed from: protected */
    public void cpR() {
        Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "onJsReady");
        this.JoI = true;
        Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "sendOnUIInit isPreload:%s", Boolean.valueOf(this.IRT));
        aD(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(80728);
                if (PreLoadWebViewUI.this.IRT) {
                    PreLoadWebViewUI.this.ggQ();
                }
                PreLoadWebViewUI.this.IBw.b("onUiInit", PreLoadWebViewUI.this.ggZ(), null);
                AppMethodBeat.o(80728);
            }
        });
        if (!(this.JoH == null || this.JoH.isEmpty())) {
            ArrayList<Runnable> arrayList = new ArrayList(this.JoH);
            Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "jsapi ready callback, running jsapi count %d", Integer.valueOf(arrayList.size()));
            this.JoH.clear();
            for (Runnable runnable : arrayList) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean gfH() {
        return this.IRT;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> ggW() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void ggQ() {
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.plugin.webview.d.h getJsapi() {
        return this.IBw;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void geA() {
        int intExtra = getIntent().getIntExtra("webview_bg_color_rsID", -1);
        if (intExtra == -1 || getContentView() == null) {
            this.pGj.setBackgroundColor(getResources().getColor(R.color.afd));
            return;
        }
        setBackGroundColorResource(intExtra);
        getContentView().setBackgroundResource(intExtra);
        this.pGj.setBackgroundResource(17170445);
        this.Jic.setBackgroundResource(17170445);
        this.Jid.setBackgroundResource(17170445);
    }

    /* access modifiers changed from: protected */
    public final void aD(final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            aE(runnable);
        } else {
            com.tencent.f.h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(211291);
                    PreLoadWebViewUI.this.aE(runnable);
                    AppMethodBeat.o(211291);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void aE(Runnable runnable) {
        if (getJsapi() == null || !getJsapi().GBl || !this.JoI) {
            Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "jsapi not ready, waiting");
            if (this.JoH == null) {
                this.JoH = new ArrayList();
            }
            this.JoH.add(runnable);
            return;
        }
        runnable.run();
    }

    public final Map<String, Object> ggZ() {
        Map<String, Object> emptyMap;
        String coX = coX();
        if (!TextUtils.isEmpty(coX)) {
            HashMap hashMap = new HashMap();
            Uri parse = Uri.parse(coX);
            for (String str : parse.getQueryParameterNames()) {
                hashMap.put(str, parse.getQueryParameter(str));
            }
            emptyMap = hashMap;
        } else {
            emptyMap = Collections.emptyMap();
        }
        Map<String, Object> ggW = ggW();
        if (ggW != null) {
            emptyMap.putAll(ggW);
        }
        Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "buildOnUiInitParams %s", emptyMap.toString());
        return emptyMap;
    }
}
