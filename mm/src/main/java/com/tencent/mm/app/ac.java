package com.tencent.mm.app;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class ac {
    static final Bundle bO(Context context) {
        AppMethodBeat.i(123475);
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            AppMethodBeat.o(123475);
            return bundle;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.SetupBaseBuildInfo", e2, "", new Object[0]);
            AppMethodBeat.o(123475);
            return null;
        }
    }
}
