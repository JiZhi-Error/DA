package com.tencent.mm.plugin.address.e;

import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class c {
    c() {
    }

    public static void TF(String str) {
        AppMethodBeat.i(21055);
        ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.o(21055);
    }
}
