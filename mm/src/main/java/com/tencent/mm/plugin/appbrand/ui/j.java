package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.i;

public final class j {

    public static final class a extends i {
        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(48658);
            super.dismiss();
            AppMethodBeat.o(48658);
        }

        public a(Context context) {
            super(context, R.style.r);
        }

        @Override // com.tencent.mm.ui.base.i
        public final void dismiss() {
            AppMethodBeat.i(48657);
            if (MMHandlerThread.isMainThread()) {
                super.dismiss();
                AppMethodBeat.o(48657);
                return;
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.ui.j.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(48656);
                    a.a(a.this);
                    AppMethodBeat.o(48656);
                }
            });
            AppMethodBeat.o(48657);
        }
    }
}
