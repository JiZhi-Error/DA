package com.tencent.mm.plugin.game.commlib.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BatteryManager {
    public static boolean xvy;
    public static BatteryChangedReceiver xvz;

    public static class BatteryChangedReceiver extends BroadcastReceiver {
        private BatteryChangedReceiver() {
        }

        public /* synthetic */ BatteryChangedReceiver(byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(201265);
            if (intent == null) {
                AppMethodBeat.o(201265);
            } else if ("android.intent.action.BATTERY_OKAY".equals(intent.getAction())) {
                BatteryManager.xvy = false;
                AppMethodBeat.o(201265);
            } else {
                if ("android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                    BatteryManager.xvy = true;
                }
                AppMethodBeat.o(201265);
            }
        }
    }
}
