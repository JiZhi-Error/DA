package com.tencent.mm.plugin.game.model.a;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {

    /* renamed from: com.tencent.mm.plugin.game.model.a.a$a  reason: collision with other inner class name */
    public static class C1404a {
        boolean ohV = false;
        float xIk = 0.0f;
    }

    public static C1404a dWb() {
        AppMethodBeat.i(41660);
        Intent registerReceiver = MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        C1404a aVar = new C1404a();
        if (registerReceiver != null) {
            try {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                aVar.ohV = intExtra == 2 || intExtra == 5;
                aVar.xIk = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
            } catch (Exception e2) {
                Log.e("MicroMsg.BatteryHelper", "err:%s", e2.getMessage());
            }
        }
        AppMethodBeat.o(41660);
        return aVar;
    }
}
