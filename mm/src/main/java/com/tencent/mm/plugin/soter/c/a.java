package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public enum a {
    IML;

    public static a valueOf(String str) {
        AppMethodBeat.i(145938);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(145938);
        return aVar;
    }

    static {
        AppMethodBeat.i(145940);
        AppMethodBeat.o(145940);
    }

    public static c a(Activity activity, j jVar, k kVar, Handler handler) {
        AppMethodBeat.i(145939);
        if ((jVar.FhV & 1) == 0 || !com.tencent.soter.core.a.fN(MMApplicationContext.getContext())) {
            Log.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", Byte.valueOf(jVar.FhV));
            AppMethodBeat.o(145939);
            return null;
        }
        b bVar = new b(new WeakReference(activity), jVar, kVar, handler);
        AppMethodBeat.o(145939);
        return bVar;
    }
}
