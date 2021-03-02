package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;

public class ShortCutPermissionDetailUI extends WebViewUI {
    private long mStartTime = 0;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(21149);
        super.onStart();
        this.mStartTime = System.currentTimeMillis();
        AppMethodBeat.o(21149);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(21150);
        super.onNewIntent(intent);
        setIntent(intent);
        AppMethodBeat.o(21150);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(21151);
        super.onStop();
        Log.i("MicroMsg.ShortCutPermissionDetailUI", "onStop");
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("extra_app_id");
            int intExtra = intent.getIntExtra("extra_permission_and_jump_status", 0);
            h.INSTANCE.a(15786, Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(intExtra), 0, stringExtra);
        }
        this.mStartTime = 0;
        AppMethodBeat.o(21151);
    }
}
