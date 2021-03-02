package com.tencent.mm.compatible.loader;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e {
    public static d b(Application application, String str) {
        AppMethodBeat.i(155843);
        try {
            d dVar = (d) MMApplicationContext.getContext().getClassLoader().loadClass(MMApplicationContext.getSourcePackageName() + str).newInstance();
            dVar.setApplication(application);
            AppMethodBeat.o(155843);
            return dVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e2, "", new Object[0]);
            AppMethodBeat.o(155843);
            return null;
        }
    }
}
