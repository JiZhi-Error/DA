package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class EmojiStoreSearchWebViewUI extends BaseEmojiStoreSearchWebViewUI {
    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI
    public final void z(int i2, Bundle bundle) {
        AppMethodBeat.i(80478);
        Log.i("MicroMsg.emoji.EmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", Integer.valueOf(i2));
        super.z(i2, bundle);
        AppMethodBeat.o(80478);
    }
}
