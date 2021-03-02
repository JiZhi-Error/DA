package com.tencent.mm.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.service.c;

public class FirstCrashUploadBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(196102);
        Log.i("MicroMsg.FirstCrashUploadBroadcastReceiver", "onReceive()");
        intent.setClassName(context, MMApplicationContext.getSourcePackageName() + ".crash.CrashUploaderService");
        c.a(intent, "cuploader", true, new Intent().setClassName(context, MMApplicationContext.getSourcePackageName() + ".crash.CuploaderProcessServicer"));
        AppMethodBeat.o(196102);
    }
}
