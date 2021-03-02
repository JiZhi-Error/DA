package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.xweb.WebView;

public class GameBaseWebViewUI extends WebViewUI {
    protected a JpK;
    private c xyK = new c() {
        /* class com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.game.c
        public final void an(Bundle bundle) {
            AppMethodBeat.i(80805);
            try {
                if (!(GameBaseWebViewUI.this.mHh == null || bundle == null)) {
                    GameBaseWebViewUI.this.mHh.j(96, bundle);
                }
                AppMethodBeat.o(80805);
            } catch (RemoteException e2) {
                AppMethodBeat.o(80805);
            }
        }
    };

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameBaseWebViewUI() {
        AppMethodBeat.i(80808);
        AppMethodBeat.o(80808);
    }

    /* access modifiers changed from: protected */
    public class a extends f {
        protected a() {
        }

        @Override // com.tencent.mm.plugin.webview.core.f
        public void i(WebView webView, String str) {
            AppMethodBeat.i(211305);
            GameBaseWebViewUI.this.xyK.Jqh.ghf();
            AppMethodBeat.o(211305);
        }

        @Override // com.tencent.mm.plugin.webview.core.f
        public void b(WebView webView, String str) {
            AppMethodBeat.i(211306);
            GameBaseWebViewUI.this.xyK.Jqh.LZ();
            AppMethodBeat.o(211306);
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void ba(Bundle bundle) {
        AppMethodBeat.i(80809);
        this.xyK.Jqh.bm(bundle);
        AppMethodBeat.o(80809);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(80810);
        super.onCreate(bundle);
        AppMethodBeat.o(80810);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(80811);
        this.xyK.Jqh.onResume();
        if (this.JpK != null) {
            a aVar = this.JpK;
            aVar.xyK.Jqh.onResume();
            aVar.xyL = System.currentTimeMillis();
        }
        super.onResume();
        AppMethodBeat.o(80811);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(80812);
        super.onPause();
        this.xyK.Jqh.onPause();
        if (this.JpK != null) {
            a aVar = this.JpK;
            aVar.xyK.Jqh.onPause();
            aVar.xyv.hhU += System.currentTimeMillis() - aVar.xyL;
            aVar.xyL = System.currentTimeMillis();
        }
        AppMethodBeat.o(80812);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(80813);
        c.a(c.this);
        if (this.JpK != null) {
            this.JpK.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(80813);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean bXi() {
        return true;
    }
}
