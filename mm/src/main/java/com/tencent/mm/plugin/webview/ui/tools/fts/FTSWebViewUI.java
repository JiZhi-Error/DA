package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.websearch.api.ar;

public class FTSWebViewUI extends FTSBaseWebViewUI {
    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
    public final String getHint() {
        AppMethodBeat.i(80707);
        String string = getString(R.string.yn);
        AppMethodBeat.o(80707);
        return string;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
    public final void bXg() {
        AppMethodBeat.i(80708);
        super.bXg();
        ar.afz(((FTSBaseWebViewUI) this).scene);
        if (((FTSBaseWebViewUI) this).scene == 21) {
            ar.afB(17);
        }
        AppMethodBeat.o(80708);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onResume() {
        AppMethodBeat.i(80709);
        super.onResume();
        ar.fYm();
        AppMethodBeat.o(80709);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onPause() {
        AppMethodBeat.i(80710);
        super.onPause();
        ar.fYn();
        AppMethodBeat.o(80710);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(80711);
        super.onDestroy();
        ar.fYo();
        ar.fYp();
        if (((FTSBaseWebViewUI) this).scene == 21) {
            ar.afB(18);
        }
        AppMethodBeat.o(80711);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity
    public void onBackPressed() {
        AppMethodBeat.i(80712);
        super.onBackPressed();
        ggY();
        AppMethodBeat.o(80712);
    }

    @Override // com.tencent.mm.ui.search.b, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
    public void onClickCancelBtn(View view) {
        AppMethodBeat.i(80713);
        super.onClickCancelBtn(view);
        finish();
        AppMethodBeat.o(80713);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void gfR() {
        AppMethodBeat.i(80715);
        ggY();
        super.gfR();
        AppMethodBeat.o(80715);
    }

    private void ggY() {
        AppMethodBeat.i(80714);
        if (((FTSBaseWebViewUI) this).scene == 21) {
            ar.afB(19);
        }
        AppMethodBeat.o(80714);
    }
}
