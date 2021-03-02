package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class TransparentWebViewUI extends GameWebViewUI {
    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(79796);
        super.onCreate(bundle);
        if (this.screenOrientation == 1001) {
            this.screenOrientation = 0;
            if (this.Jii != null) {
                this.Jii.enable();
                AppMethodBeat.o(79796);
                return;
            }
        } else if (this.screenOrientation == 1002) {
            this.screenOrientation = 1;
            if (this.Jii != null) {
                this.Jii.enable();
            }
        }
        AppMethodBeat.o(79796);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI, com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z = true;
        AppMethodBeat.i(79797);
        super.initView();
        k kVar = this.JjI;
        k.geY();
        kVar.Jha = true;
        this.JjI.lcy = false;
        this.JjI.zh(true);
        this.JjI.agK(0);
        if (getIntent() == null || !getIntent().hasExtra("show_full_screen") || !getIntent().getBooleanExtra("show_full_screen", false)) {
            z = false;
        }
        if (z && this.Jif != null) {
            this.Jif.setCanMove(false);
        }
        AppMethodBeat.o(79797);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void geA() {
        AppMethodBeat.i(79798);
        setBackGroundColorResource(0);
        getContentView().setBackgroundResource(0);
        this.pGj.setBackgroundResource(17170445);
        this.pGj.setBackgroundColor(0);
        findViewById(R.id.jkw).setBackgroundResource(17170445);
        findViewById(R.id.h8y).setBackgroundResource(17170445);
        AppMethodBeat.o(79798);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI
    public final boolean cpz() {
        return false;
    }
}
