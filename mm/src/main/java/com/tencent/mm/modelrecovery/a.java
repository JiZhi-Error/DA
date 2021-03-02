package com.tencent.mm.modelrecovery;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.RecoveryCrash;
import com.tencent.mm.recoveryv2.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static void de(Context context) {
        AppMethodBeat.i(231565);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, dump recovery status:");
        RecoveryCrash iI = RecoveryCrash.iI(context);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + iI.NBA.NBC);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + iI.NBx);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + iI.NBy);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "setting enable       = " + h.a.iN(context).mEnabled);
        h iM = h.iM(context);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 1  = " + iM.NBK);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "setting threshold 2  = " + iM.NBL);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "setting interval     = " + iM.NBM);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "setting min interval = " + iM.NBO);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "setting auto reset   = " + iM.NBP);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "setLaunchRecovery, main process will crash immediately");
        RecoveryCrash ajr = RecoveryCrash.iI(context).ajr(iM.NBK);
        ajr.NBx = System.currentTimeMillis();
        ajr.save();
        Log.w("MicroMsg.Recovery.RecoveryHelper", "setting new recovery status:");
        RecoveryCrash iI2 = RecoveryCrash.iI(context);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "crash count   = " + iI2.NBA.NBC);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "crash time    = " + iI2.NBx);
        Log.w("MicroMsg.Recovery.RecoveryHelper", "crash version = " + iI2.NBy);
        RuntimeException runtimeException = new RuntimeException("setLaunchRecovery");
        AppMethodBeat.o(231565);
        throw runtimeException;
    }
}
