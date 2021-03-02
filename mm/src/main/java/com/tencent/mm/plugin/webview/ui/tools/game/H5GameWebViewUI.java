package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.a;

@a(19)
public class H5GameWebViewUI extends GameWebViewUI {
    private static final String JrI = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/gameloading/index.html");
    private int lastOrientation;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(211342);
        AppMethodBeat.o(211342);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(80952);
        super.onCreate(bundle);
        Log.i("MicroMsg.H5GameWebViewUI", "onCreate");
        this.Jio = false;
        this.lastOrientation = this.screenOrientation;
        AppMethodBeat.o(80952);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(80953);
        Log.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
        super.onNewIntent(intent);
        boolean booleanExtra = getIntent().getBooleanExtra("show_full_screen", false);
        setIntent(intent);
        String stringExtra = intent.getStringExtra("rawUrl");
        Log.d("MicroMsg.H5GameWebViewUI", "url = ".concat(String.valueOf(stringExtra)));
        if (!this.Jin.equals(stringExtra)) {
            if (stringExtra.startsWith(JrI)) {
                this.Jin = stringExtra;
            }
            if (!coX().equals(stringExtra)) {
                this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
                if (this.mHi == null) {
                    this.mHi = new g(new g.b() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.game.H5GameWebViewUI.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.webview.f.g.b
                        public final String fZK() {
                            AppMethodBeat.i(211340);
                            String url = H5GameWebViewUI.this.pGj.getUrl();
                            AppMethodBeat.o(211340);
                            return url;
                        }

                        @Override // com.tencent.mm.plugin.webview.f.g.b
                        public final String fZL() {
                            AppMethodBeat.i(211341);
                            String url = H5GameWebViewUI.this.pGj.getUrl();
                            AppMethodBeat.o(211341);
                            return url;
                        }
                    });
                } else {
                    this.mHi.a(stringExtra, null, null);
                }
                this.mHi.a((JsapiPermissionWrapper) getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper) getIntent().getParcelableExtra("hardcode_general_ctrl"));
                this.pGj.loadUrl("about:blank");
                this.IMH.aB(intent);
                AppMethodBeat.o(80953);
                return;
            }
            this.screenOrientation = this.lastOrientation;
            getIntent().putExtra("show_full_screen", booleanExtra);
            gfA();
        }
        AppMethodBeat.o(80953);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(80954);
        setMMOrientation();
        super.onResume();
        AppMethodBeat.o(80954);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean gfq() {
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI
    public final boolean cpz() {
        return false;
    }
}
