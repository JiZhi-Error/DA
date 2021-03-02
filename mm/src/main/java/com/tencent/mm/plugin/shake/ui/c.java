package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

/* access modifiers changed from: package-private */
public final class c {
    MTimerHandler timer = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.shake.ui.c.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(28377);
            c.this.eUS();
            AppMethodBeat.o(28377);
            return false;
        }
    }, false);
    View view;

    public c(View view2) {
        AppMethodBeat.i(28378);
        this.view = view2;
        AppMethodBeat.o(28378);
    }

    public final void eUS() {
        AppMethodBeat.i(28379);
        if (this.view != null) {
            this.view.setKeepScreenOn(false);
        }
        AppMethodBeat.o(28379);
    }
}
