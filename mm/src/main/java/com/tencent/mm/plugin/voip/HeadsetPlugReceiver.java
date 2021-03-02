package com.tencent.mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class HeadsetPlugReceiver extends BroadcastReceiver {
    private a GSI = null;

    public interface a {
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(114794);
        Log.d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", intent.getAction(), Integer.valueOf(intent.getIntExtra("state", 0)));
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.getIntExtra("state", 0) != 0) {
                intent.getIntExtra("state", 0);
            } else if (this.GSI != null) {
                AppMethodBeat.o(114794);
                return;
            }
        }
        AppMethodBeat.o(114794);
    }
}
