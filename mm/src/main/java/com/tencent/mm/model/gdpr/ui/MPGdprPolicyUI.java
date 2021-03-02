package com.tencent.mm.model.gdpr.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.webview.ui.tools.widget.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Locale;

@a(1)
public class MPGdprPolicyUI extends MMActivity {
    private static final String iGW = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s");
    private MMFalseProgressBar iGX;
    private MMWebView iGY;
    private com.tencent.mm.model.gdpr.a iGZ;
    private ResultReceiver iHa;
    private String mAppID;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(MPGdprPolicyUI mPGdprPolicyUI, boolean z) {
        AppMethodBeat.i(40106);
        mPGdprPolicyUI.fs(z);
        AppMethodBeat.o(40106);
    }

    static {
        AppMethodBeat.i(236428);
        AppMethodBeat.o(236428);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(40099);
        super.onCreate(bundle);
        try {
            if (getIntent() != null) {
                ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("MPGdprPolicyUI_KEY_RECEIVER");
                this.iHa = resultReceiver;
                if (resultReceiver != null) {
                    this.iGZ = com.tencent.mm.model.gdpr.a.La(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
                    if (this.iGZ == null) {
                        Log.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
                        fs(false);
                        finish();
                        AppMethodBeat.o(40099);
                        return;
                    }
                    this.mAppID = getIntent().getStringExtra("MPGdprPolicyUI_KEY_APPID");
                    AppMethodBeat.o(40099);
                    return;
                }
            }
            finish();
            AppMethodBeat.o(40099);
        } catch (Exception e2) {
            Log.e("MicroMsg.MPGdprPolicyUI", "onCreate get receiver ex = %s", e2);
            finish();
            AppMethodBeat.o(40099);
        }
    }

    private void fs(boolean z) {
        AppMethodBeat.i(40100);
        if (this.iHa != null) {
            this.iHa.send(z ? 1 : -1, null);
        }
        AppMethodBeat.o(40100);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(40101);
        super.finish();
        if (this.iHa != null) {
            fs(false);
            this.iHa = null;
        }
        AppMethodBeat.o(40101);
    }

    @Override // com.tencent.mm.ui.MMActivity
    @SuppressLint({"SetJavaScriptEnabled", "InlinedApi"})
    public void dealContentView(View view) {
        AppMethodBeat.i(40102);
        super.dealContentView(view);
        this.iGY = f.a.Jys.eK(this);
        this.iGY.getSettings().hsU();
        this.iGY.getSettings().setJavaScriptEnabled(true);
        this.iGY.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.iGY.getSettings().hsW();
        this.iGY.getSettings().setUserAgentString(p.a(getContext(), this.iGY.getSettings().getUserAgentString(), (p.a) e.M(p.a.class)));
        this.iGY.getView().setHorizontalScrollBarEnabled(false);
        this.iGY.getView().setVerticalScrollBarEnabled(false);
        this.iGY.getSettings().setBuiltInZoomControls(true);
        this.iGY.getSettings().setUseWideViewPort(true);
        this.iGY.getSettings().setLoadWithOverviewMode(true);
        this.iGY.getSettings().hsN();
        this.iGY.getSettings().hsM();
        this.iGY.getSettings().setGeolocationEnabled(true);
        this.iGY.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.iGY.getSettings().hsS();
        this.iGY.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        this.iGY.getSettings().hsR();
        this.iGY.getSettings().hsT();
        this.iGY.getSettings().setDatabasePath(b.aKA() + "databases/");
        Bundle bundle = new Bundle(1);
        bundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
        this.iGY.setWebViewClient(c.a.Jyr.a(this.iGY, new com.tencent.mm.plugin.webview.ui.tools.widget.e() {
            /* class com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.e
            public final boolean aXk() {
                AppMethodBeat.i(40092);
                MPGdprPolicyUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(40089);
                        MPGdprPolicyUI.this.finish();
                        AppMethodBeat.o(40089);
                    }
                });
                AppMethodBeat.o(40092);
                return true;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.e
            public final void aXl() {
                AppMethodBeat.i(40093);
                MPGdprPolicyUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(40090);
                        MPGdprPolicyUI.this.iGX.start();
                        AppMethodBeat.o(40090);
                    }
                });
                AppMethodBeat.o(40093);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.e
            public final void c(MMWebView mMWebView) {
                AppMethodBeat.i(40094);
                MPGdprPolicyUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.AnonymousClass1.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(40091);
                        MPGdprPolicyUI.this.iGX.finish();
                        AppMethodBeat.o(40091);
                    }
                });
                AppMethodBeat.o(40094);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.e
            public final boolean Lb(String str) {
                return false;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.d
            public final boolean f(int i2, Bundle bundle) {
                AppMethodBeat.i(40095);
                if (i2 == 200) {
                    boolean z = bundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
                    MPGdprPolicyUI.a(MPGdprPolicyUI.this, z);
                    MPGdprPolicyUI.this.iHa = null;
                    if (z && !Util.isNullOrNil(MPGdprPolicyUI.this.mAppID) && MPGdprPolicyUI.this.iGZ.iGQ != 0) {
                        com.tencent.mm.ak.c cVar = new com.tencent.mm.ak.c();
                        dwe dwe = new dwe();
                        dwe.dNI = MPGdprPolicyUI.this.mAppID;
                        dwe.scene = MPGdprPolicyUI.this.iGZ.iGQ;
                        d.a aVar = new d.a();
                        aVar.iLN = dwe;
                        aVar.iLO = new dwf();
                        aVar.funcId = 2734;
                        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
                        cVar.c(aVar.aXF());
                        cVar.aYI();
                    }
                }
                AppMethodBeat.o(40095);
                return false;
            }
        }, bundle));
        this.iGY.setWebChromeClient(a.C2003a.Jyq.a(this.iGY, new com.tencent.mm.plugin.webview.ui.tools.widget.b() {
            /* class com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.b
            public final boolean Lc(final String str) {
                AppMethodBeat.i(40097);
                MPGdprPolicyUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(40096);
                        MPGdprPolicyUI.this.setMMTitle(str);
                        AppMethodBeat.o(40096);
                    }
                });
                AppMethodBeat.o(40097);
                return true;
            }
        }));
        ((FrameLayout) view).addView(this.iGY, -1, -1);
        this.iGX = new MMFalseProgressBar(this);
        this.iGX.setProgressDrawable(com.tencent.mm.cb.a.l(this, R.drawable.aik));
        ((FrameLayout) view).addView(this.iGX, -1, com.tencent.mm.cb.a.fromDPToPix((Context) this, 3));
        AppMethodBeat.o(40102);
    }

    @Override // android.support.v7.app.AppCompatActivity
    public void onPostCreate(Bundle bundle) {
        AppMethodBeat.i(40103);
        super.onPostCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40098);
                MPGdprPolicyUI.this.finish();
                AppMethodBeat.o(40098);
                return true;
            }
        }, R.raw.actionbar_icon_dark_close);
        setActionbarColor(-1);
        this.iGY.loadUrl(String.format(Locale.US, iGW, this.iGZ.iGP, LocaleUtil.getCurrentLanguage(this), (String) g.aAh().azQ().get(274436, (Object) null)));
        AppMethodBeat.o(40103);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(40104);
        super.onDestroy();
        try {
            this.iGY.destroy();
        } catch (Exception e2) {
            Log.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", e2);
        } finally {
            this.iGY = null;
            AppMethodBeat.o(40104);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(40105);
        if (i2 != 4 || !this.iGY.canGoBack()) {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(40105);
            return onKeyDown;
        }
        this.iGY.goBack();
        AppMethodBeat.o(40105);
        return true;
    }
}
