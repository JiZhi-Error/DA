package com.tencent.mm.plugin.address.e;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class b {
    b() {
    }

    @TargetApi(11)
    public static void TF(String str) {
        AppMethodBeat.i(21054);
        ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.o(21054);
    }
}
