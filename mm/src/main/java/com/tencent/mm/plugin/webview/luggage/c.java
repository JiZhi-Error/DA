package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.b;

public final class c extends b {
    public c(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.ui.statusbar.b, com.tencent.mm.ui.statusbar.c.a
    public final void yf(int i2) {
        AppMethodBeat.i(78193);
        if (i2 == 0) {
            AppMethodBeat.o(78193);
            return;
        }
        super.yf(i2);
        AppMethodBeat.o(78193);
    }
}
