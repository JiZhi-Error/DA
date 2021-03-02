package com.tencent.mm.plugin.card.d;

import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class p {
    p() {
    }

    public static void TF(String str) {
        AppMethodBeat.i(113869);
        ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.o(113869);
    }
}
