package com.tencent.mm.plugin.appbrand.openmaterial;

import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface j {
    public static final j nlj = new j() {
        /* class com.tencent.mm.plugin.appbrand.openmaterial.j.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.j
        public final void ae(Runnable runnable) {
            AppMethodBeat.i(194341);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                runnable.run();
                AppMethodBeat.o(194341);
                return;
            }
            h.RTc.aV(runnable);
            AppMethodBeat.o(194341);
        }
    };

    void ae(Runnable runnable);
}
