package com.tencent.mm.plugin.card.d;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class o {
    o() {
    }

    @TargetApi(11)
    public static void TF(String str) {
        AppMethodBeat.i(113868);
        ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.o(113868);
    }
}
