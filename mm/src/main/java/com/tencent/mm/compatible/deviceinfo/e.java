package com.tencent.mm.compatible.deviceinfo;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;

final class e implements d.a {
    e() {
    }

    public static d.a.C0301a d(Looper looper) {
        AppMethodBeat.i(155648);
        d.a.C0301a aVar = new d.a.C0301a();
        try {
            aVar.gGr = w.e(looper);
            aVar.dYT = 0;
            if (aVar.gGr == null) {
                AppMethodBeat.o(155648);
                return null;
            }
            AppMethodBeat.o(155648);
            return aVar;
        } catch (Exception e2) {
            AppMethodBeat.o(155648);
            return null;
        }
    }
}
