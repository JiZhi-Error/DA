package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

public class ContactQZoneWebView extends WebViewUI {
    private boolean JdM = false;
    private String JdN = "";
    private String eby = "";

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(79545);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.j4j));
        this.pGj.setWebViewClient(new ac() {
            /* class com.tencent.mm.plugin.webview.ui.tools.ContactQZoneWebView.AnonymousClass1 */

            @Override // com.tencent.xweb.ac
            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(79543);
                if (str.startsWith("weixin://viewimage/")) {
                    ContactQZoneWebView.this.bab(str);
                    webView.stopLoading();
                } else if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                    AppMethodBeat.o(79543);
                    return true;
                } else {
                    webView.loadUrl(str);
                }
                AppMethodBeat.o(79543);
                return true;
            }

            @Override // com.tencent.xweb.ac
            public final void b(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(79544);
                if (str.startsWith("weixin://viewimage/")) {
                    ContactQZoneWebView.this.bab(str);
                    webView.stopLoading();
                    AppMethodBeat.o(79544);
                } else if (str.equals(ContactQZoneWebView.this.eby)) {
                    Util.jump(ContactQZoneWebView.this, str);
                    webView.stopLoading();
                    AppMethodBeat.o(79544);
                } else {
                    super.b(webView, str, bitmap);
                    AppMethodBeat.o(79544);
                }
            }
        });
        this.pGj.loadUrl(coX());
        Log.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + coX());
        AppMethodBeat.o(79545);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(79546);
        super.onResume();
        this.JdM = false;
        AppMethodBeat.o(79546);
    }

    /* access modifiers changed from: package-private */
    public final void bab(String str) {
        AppMethodBeat.i(79547);
        if (this.JdM) {
            AppMethodBeat.o(79547);
            return;
        }
        this.JdM = true;
        String substring = str.substring(19);
        Log.d("MicroMsg.ContactQZoneWebView", "get url :".concat(String.valueOf(substring)));
        Intent intent = new Intent();
        intent.putExtra("nowUrl", substring);
        intent.putExtra("tweetid", Util.nullAsNil(getIntent().getStringExtra("tweetid")));
        intent.putExtra("htmlData", this.JdN);
        intent.putExtra("type", getIntent().getIntExtra("type", 0));
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", 4);
        bundle.putString("stat_url", fZM());
        intent.putExtra("_stat_obj", bundle);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/ContactQZoneWebView", "gotoImageView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/ContactQZoneWebView", "gotoImageView", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.webview.a.a.jRt.p(intent, this);
        AppMethodBeat.o(79547);
    }
}
