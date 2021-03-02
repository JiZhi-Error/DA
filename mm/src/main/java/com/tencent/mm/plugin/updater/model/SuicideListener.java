package com.tencent.mm.plugin.updater.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class SuicideListener extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(194715);
        Log.i("Tinker.TinkerResponseProcessor", "do suicide");
        c.JYn.bV(MMApplicationContext.getContext());
        AppMethodBeat.o(194715);
    }
}
