package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

@Deprecated
public final class HomeKeyMonitor {
    boolean szC;

    public class MonitorReceiver extends BroadcastReceiver {
        final /* synthetic */ HomeKeyMonitor szD;

        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            AppMethodBeat.i(121898);
            if (!this.szD.szC) {
                AppMethodBeat.o(121898);
                return;
            }
            this.szD.szC = false;
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) && (stringExtra = intent.getStringExtra("reason")) != null) {
                if (stringExtra.equals("homekey")) {
                    Log.i("HomeKeyMonitor", "habbyge-homeKey ------------------ %d", Integer.valueOf(Process.myPid()));
                    AppMethodBeat.o(121898);
                    return;
                } else if (stringExtra.equals("recentapps")) {
                    Log.i("HomeKeyMonitor", "habbyge-multiTaskKey ------------------ %d", Integer.valueOf(Process.myPid()));
                }
            }
            AppMethodBeat.o(121898);
        }
    }
}
