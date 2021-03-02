package com.tencent.mm.plugin.exdevice.service;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {
    public static boolean fd(Context context) {
        AppMethodBeat.i(23644);
        if (l.cK(context)) {
            Log.i("MicroMsg.exdevice.ExDeviceServiceHelper", "fully exited, no need to start service");
            AppMethodBeat.o(23644);
            return false;
        }
        Intent intent = new Intent(context, ExDeviceService.class);
        intent.setFlags(268435456);
        c.m(intent, "exdevice");
        AppMethodBeat.o(23644);
        return true;
    }
}
