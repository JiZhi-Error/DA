package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

public class WebViewTestUI extends MMActivity {
    MMWebViewWithJsApi JhQ;
    private ac nsm = new ac() {
        /* class com.tencent.mm.plugin.webview.ui.tools.WebViewTestUI.AnonymousClass1 */

        @Override // com.tencent.xweb.ac
        public final void b(WebView webView, String str) {
            AppMethodBeat.i(80039);
            super.b(webView, str);
            AppMethodBeat.o(80039);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebViewTestUI() {
        AppMethodBeat.i(80040);
        AppMethodBeat.o(80040);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(80041);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("rawUrl");
        this.JhQ = MMWebViewWithJsApi.a.hZ(this);
        this.JhQ.setWebViewClient(this.nsm);
        setContentView(this.JhQ);
        this.JhQ.loadUrl(stringExtra);
        AppMethodBeat.o(80041);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
