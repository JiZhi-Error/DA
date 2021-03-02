package com.tencent.mm.plugin.qqmail.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.qqmail.c;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
import java.util.HashMap;
import java.util.Map;

public class MailWebViewUI extends MMActivity {
    private c.a BwD = new c.a() {
        /* class com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.qqmail.c.a
        public final void onSuccess(final String str, Map map) {
            AppMethodBeat.i(123120);
            MailWebViewUI.this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(123118);
                    MailWebViewUI.a(MailWebViewUI.this, str);
                    AppMethodBeat.o(123118);
                }
            });
            AppMethodBeat.o(123120);
        }

        @Override // com.tencent.mm.plugin.qqmail.c.a
        public final void onError(int i2, final String str) {
            AppMethodBeat.i(123121);
            MailWebViewUI.this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.AnonymousClass1.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(123119);
                    Toast.makeText(MailWebViewUI.this, str, 0).show();
                    AppMethodBeat.o(123119);
                }
            });
            AppMethodBeat.o(123121);
        }
    };
    private String djt;
    private d gVN = new d(this);
    private MMHandler handler;
    private MMWebView pGj;
    private long ulj;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MailWebViewUI() {
        AppMethodBeat.i(123129);
        AppMethodBeat.o(123129);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(123130);
        super.onResume();
        WebView.enablePlatformNotifications();
        AppMethodBeat.o(123130);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(123131);
        super.onPause();
        WebView.disablePlatformNotifications();
        AppMethodBeat.o(123131);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bk3;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(123132);
        super.onCreate(bundle);
        this.handler = new MMHandler();
        initView();
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            setMMTitle(stringExtra);
        }
        this.gVN.connect(new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(123122);
                MailWebViewUI.b(MailWebViewUI.this);
                AppMethodBeat.o(123122);
            }
        });
        AppMethodBeat.o(123132);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(123133);
        this.pGj.stopLoading();
        super.onStop();
        AppMethodBeat.o(123133);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(123134);
        this.pGj.setVisibility(8);
        this.pGj.destroy();
        this.pGj = null;
        this.gVN.release();
        super.onDestroy();
        AppMethodBeat.o(123134);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(123135);
        Boolean valueOf = Boolean.valueOf(getIntent().getBooleanExtra("singleColumn", false));
        this.pGj = MMWebView.a.kL(getContext());
        this.pGj.setBackgroundDrawable(a.l(this, R.color.a2h));
        ((FrameLayout) findViewById(R.id.be3)).addView(this.pGj);
        this.pGj.getSettings().setJavaScriptEnabled(true);
        if (valueOf.booleanValue()) {
            MMWebView mMWebView = this.pGj;
            if (Build.VERSION.SDK_INT >= 8) {
                mMWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            }
        }
        this.pGj.getSettings().hsO();
        this.pGj.getSettings().setSupportZoom(true);
        this.pGj.getSettings().setBuiltInZoomControls(true);
        this.pGj.setWebViewClient(new ac() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.AnonymousClass3 */

            @Override // com.tencent.xweb.ac
            public final void a(WebView webView, float f2, float f3) {
                AppMethodBeat.i(123123);
                MailWebViewUI.this.pGj.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                AppMethodBeat.o(123123);
            }

            @Override // com.tencent.xweb.ac
            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(123124);
                if (str.startsWith("weixin://private/getcontentwidth/")) {
                    Log.d("MicroMsg.QQMail.WebViewUI", "shouldOverride, url is getContentWidth scheme, url = ".concat(String.valueOf(str)));
                    MailWebViewUI.b(MailWebViewUI.this, str);
                    AppMethodBeat.o(123124);
                } else {
                    webView.loadUrl(str);
                    AppMethodBeat.o(123124);
                }
                return true;
            }

            @Override // com.tencent.xweb.ac
            public final void b(WebView webView, String str) {
                AppMethodBeat.i(123125);
                super.b(webView, str);
                z.a(webView, "weixin://private/getcontentwidth/", "document.getElementsByTagName('html')[0].scrollWidth;");
                AppMethodBeat.o(123125);
            }
        });
        this.pGj.setWebChromeClient(new x() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.AnonymousClass4 */

            @Override // com.tencent.xweb.x
            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                AppMethodBeat.i(123126);
                String bfJ = z.bfJ(consoleMessage != null ? consoleMessage.message() : null);
                if (bfJ.startsWith("weixin://private/getcontentwidth/")) {
                    Log.d("MicroMsg.QQMail.WebViewUI", "onConsoleMessage, url is getContentWidth scheme, url = ".concat(String.valueOf(bfJ)));
                    MailWebViewUI.b(MailWebViewUI.this, bfJ);
                    AppMethodBeat.o(123126);
                    return true;
                }
                boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
                AppMethodBeat.o(123126);
                return onConsoleMessage;
            }
        });
        this.pGj.gYW();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(123127);
                MailWebViewUI.this.finish();
                AppMethodBeat.o(123127);
                return true;
            }
        });
        AppMethodBeat.o(123135);
    }

    static /* synthetic */ void a(MailWebViewUI mailWebViewUI, String str) {
        AppMethodBeat.i(123136);
        if (mailWebViewUI.pGj == null || str == null) {
            AppMethodBeat.o(123136);
        } else if (mailWebViewUI.djt == null) {
            mailWebViewUI.pGj.loadData(str, "text/html", ProtocolPackage.ServerEncoding);
            AppMethodBeat.o(123136);
        } else {
            mailWebViewUI.pGj.loadDataWithBaseURL(mailWebViewUI.djt, str, "text/html", ProtocolPackage.ServerEncoding, null);
            AppMethodBeat.o(123136);
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI) {
        AppMethodBeat.i(123137);
        String stringExtra = mailWebViewUI.getIntent().getStringExtra(ShareConstants.MEDIA_URI);
        String[] stringArrayExtra = mailWebViewUI.getIntent().getStringArrayExtra(NativeProtocol.WEB_DIALOG_PARAMS);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < stringArrayExtra.length; i2++) {
            int indexOf = stringArrayExtra[i2].indexOf("=");
            hashMap.put(stringArrayExtra[i2].substring(0, indexOf), stringArrayExtra[i2].substring(indexOf + 1));
        }
        mailWebViewUI.djt = mailWebViewUI.getIntent().getStringExtra("baseurl");
        String nullAs = Util.nullAs(mailWebViewUI.getIntent().getStringExtra(FirebaseAnalytics.b.METHOD), "get");
        if (nullAs == null || nullAs.length() == 0 || stringExtra == null || stringExtra.length() == 0) {
            Log.e("MicroMsg.QQMail.WebViewUI", "doSend invalid argument.");
            AppMethodBeat.o(123137);
            return;
        }
        c.b bVar = new c.b();
        bVar.BqM = false;
        Bundle bundle = new Bundle();
        bundle.putBoolean("qqmail_httpoptions_expired", bVar.BqK);
        bundle.putBoolean("qqmail_httpoptions_needcache", bVar.BqL);
        bundle.putBoolean("qqmail_httpoptions_needparse", bVar.BqM);
        try {
            if (nullAs.equals("get")) {
                mailWebViewUI.ulj = ((Long) new ReadMailProxy(mailWebViewUI.gVN, mailWebViewUI.BwD).REMOTE_CALL("get", stringExtra, hashMap, bundle)).longValue();
                AppMethodBeat.o(123137);
                return;
            }
            mailWebViewUI.ulj = ((Long) new ReadMailProxy(mailWebViewUI.gVN, mailWebViewUI.BwD).REMOTE_CALL("post", stringExtra, hashMap, bundle)).longValue();
            AppMethodBeat.o(123137);
        } catch (Exception e2) {
            Log.w("MicroMsg.QQMail.WebViewUI", "get/post, method = %s, ex = %s", nullAs, e2.getMessage());
            AppMethodBeat.o(123137);
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI, String str) {
        AppMethodBeat.i(123138);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.QQMail.WebViewUI", "dealGetContentWidthScheme fail, url is null");
            AppMethodBeat.o(123138);
            return;
        }
        String substring = str.substring(33);
        final int i2 = Util.getInt(substring, 480);
        Log.d("MicroMsg.QQMail.WebViewUI", "getContentWidth:".concat(String.valueOf(substring)));
        mailWebViewUI.pGj.post(new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.AnonymousClass6 */

            public final void run() {
                int width;
                AppMethodBeat.i(123128);
                View view = (View) MailWebViewUI.this.pGj.getParent();
                if (view != null && i2 > (width = view.getWidth())) {
                    int i2 = 10;
                    float f2 = ((float) width) / ((float) i2);
                    while (f2 < MailWebViewUI.this.pGj.getScale() && i2 - 1 > 0) {
                        MailWebViewUI.this.pGj.zoomOut();
                    }
                }
                AppMethodBeat.o(123128);
            }
        });
        AppMethodBeat.o(123138);
    }
}
