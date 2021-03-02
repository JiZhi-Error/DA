package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.bizui.a.b;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;

public class GameChattingRoomWebViewUI extends WebViewUI {
    private int JpM = 4;
    private int JpN = 5;
    final y.a JpO = new y.a() {
        /* class com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
        public final void a(boolean z, String str, int i2) {
            AppMethodBeat.i(80814);
            GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.this.JpM, new Intent());
            GameChattingRoomWebViewUI.this.finish();
            AppMethodBeat.o(80814);
        }
    };
    final y.a JpP = new y.a() {
        /* class com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI.AnonymousClass2 */

        @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
        public final void a(boolean z, String str, int i2) {
            AppMethodBeat.i(80815);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", GameChattingRoomWebViewUI.this.jumpUrl);
            GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.this.JpN, intent);
            GameChattingRoomWebViewUI.this.finish();
            AppMethodBeat.o(80815);
        }
    };
    private k JpQ = new k() {
        /* class com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.webview.core.k
        public final k.a o(WebView webView, final String str) {
            AppMethodBeat.i(211308);
            if (Util.isNullOrNil(str)) {
                k.a aVar = new k.a(false, false);
                AppMethodBeat.o(211308);
                return aVar;
            } else if (str.toLowerCase().startsWith("weixin://jump/") || str.toLowerCase().startsWith("weixin://scanqrcode/")) {
                h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        String string;
                        AppMethodBeat.i(211307);
                        GameChattingRoomWebViewUI gameChattingRoomWebViewUI = GameChattingRoomWebViewUI.this;
                        String str = str;
                        Log.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", str);
                        gameChattingRoomWebViewUI.jumpUrl = str;
                        String stringExtra = gameChattingRoomWebViewUI.getIntent().getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
                        if (stringExtra != null) {
                            String stringExtra2 = gameChattingRoomWebViewUI.getIntent().getStringExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
                            if (stringExtra2 == null) {
                                string = gameChattingRoomWebViewUI.getString(R.string.he);
                            } else {
                                string = gameChattingRoomWebViewUI.getString(R.string.b95, new Object[]{stringExtra2});
                            }
                            String string2 = gameChattingRoomWebViewUI.getString(R.string.b9b);
                            if (stringExtra.equals("action_create")) {
                                b.a(gameChattingRoomWebViewUI.mController, gameChattingRoomWebViewUI.getString(R.string.bjn), string, string2, gameChattingRoomWebViewUI.JpO, gameChattingRoomWebViewUI.JpP);
                                AppMethodBeat.o(211307);
                                return;
                            } else if (stringExtra.equals("action_join")) {
                                b.a(gameChattingRoomWebViewUI.mController, gameChattingRoomWebViewUI.getString(R.string.e_0), string, string2, gameChattingRoomWebViewUI.JpO, gameChattingRoomWebViewUI.JpP);
                            }
                        }
                        AppMethodBeat.o(211307);
                    }
                });
                k.a aVar2 = new k.a(true, true);
                AppMethodBeat.o(211308);
                return aVar2;
            } else {
                k.a aVar3 = new k.a(false, false);
                AppMethodBeat.o(211308);
                return aVar3;
            }
        }
    };
    String jumpUrl = "";

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameChattingRoomWebViewUI() {
        AppMethodBeat.i(80816);
        AppMethodBeat.o(80816);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final i cpO() {
        AppMethodBeat.i(211309);
        i cpO = super.cpO();
        cpO.a(this.JpQ);
        AppMethodBeat.o(211309);
        return cpO;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(211310);
        this.IMH.b(this.JpQ);
        super.onDestroy();
        AppMethodBeat.o(211310);
    }
}
