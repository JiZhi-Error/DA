package com.tencent.mm.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class aa {
    public static boolean bN(Context context) {
        AppMethodBeat.i(200818);
        try {
            if (!((Boolean) Class.forName(MMApplicationContext.getSourcePackageName() + ".recovery.RecoveryInitializer").getMethod(APMidasPluginInfo.LAUNCH_INTERFACE_INIT, Context.class).invoke(null, context)).booleanValue()) {
                AppMethodBeat.o(200818);
                return true;
            }
            AppMethodBeat.o(200818);
            return false;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.recovery.loader", th, "recovery init fail", new Object[0]);
            AppMethodBeat.o(200818);
            return false;
        }
    }
}
