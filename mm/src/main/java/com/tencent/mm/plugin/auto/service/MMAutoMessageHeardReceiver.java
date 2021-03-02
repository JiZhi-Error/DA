package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.auto.a.a;
import com.tencent.mm.plugin.auto.a.b;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;

public class MMAutoMessageHeardReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(21161);
        String stringExtra = IntentUtil.getStringExtra(intent, "key_username");
        if (stringExtra == null) {
            AppMethodBeat.o(21161);
            return;
        }
        Log.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", stringExtra);
        if (!g.aAi().hrr || !g.aAf().azp()) {
            Log.e("MicroMsg.auto.MMAutoMessageHeardReceiver", "kernel or account not ready.");
            AppMethodBeat.o(21161);
        } else if (!a.ceB()) {
            AppMethodBeat.o(21161);
        } else if (!a.ceC()) {
            Log.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "not open car mode");
            AppMethodBeat.o(21161);
        } else if (!a.ceD()) {
            Log.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "not install auto app");
            AppMethodBeat.o(21161);
        } else {
            b bVar = b.oIG;
            b.Bt(2);
            bg.aVF();
            c.aST().bka(stringExtra);
            AppMethodBeat.o(21161);
        }
    }
}
