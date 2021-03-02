package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;

public class ExceptionMonitorBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(32601);
        Log.i("MicroMsg.ExceptionMonitorBroadcastReceiver", "onReceive()");
        intent.setClass(context, ExceptionMonitorMMService.class);
        c.m(intent, "sandbox");
        AppMethodBeat.o(32601);
    }
}
