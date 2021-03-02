package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public class BakOldUSBReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(21811);
        try {
            String action = intent.getAction();
            if ("MMBakchatServiceStart".equalsIgnoreCase(action)) {
                c.startService(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService").putExtra("url", intent.getStringExtra("url")));
                Log.d("MicroMsg.BakOldUSBReceiver", "START_ACTION onReceive start end");
                AppMethodBeat.o(21811);
                return;
            }
            if ("MMBakchatServiceStop".equalsIgnoreCase(action)) {
                ag agVar = new ag();
                agVar.dDf.dDg = context;
                EventCenter.instance.publish(agVar);
                Log.d("MicroMsg.BakOldUSBReceiver", "STOP_ACTION onReceive stop end");
            }
            AppMethodBeat.o(21811);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BakOldUSBReceiver", e2, "onReceive:", new Object[0]);
            AppMethodBeat.o(21811);
        }
    }
}
