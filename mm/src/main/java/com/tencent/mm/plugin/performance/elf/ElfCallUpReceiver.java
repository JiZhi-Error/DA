package com.tencent.mm.plugin.performance.elf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ElfCallUpReceiver extends BroadcastReceiver {
    public static int AUm = -1;

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(124973);
        Log.i("MicroMsg.ElfCallUpReceiver", "[onReceive] call up! ");
        if (getClass().getName().equals(intent.getAction())) {
            AUm = intent.getIntExtra("processId", 0);
        }
        AppMethodBeat.o(124973);
    }
}
