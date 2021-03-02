package com.tencent.mm.plugin.sns.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AdlandingRemoteServiceConnectedReceiver extends BroadcastReceiver {
    private Runnable dQN;

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(95411);
        if (!(intent == null || !"com.tencnet.mm.action.adlanding.connected".equals(intent.getAction()) || this.dQN == null)) {
            this.dQN.run();
        }
        AppMethodBeat.o(95411);
    }

    public static void a(d dVar) {
        AppMethodBeat.i(95412);
        dVar.b(new Intent("com.tencnet.mm.action.adlanding.connected"));
        AppMethodBeat.o(95412);
    }
}
