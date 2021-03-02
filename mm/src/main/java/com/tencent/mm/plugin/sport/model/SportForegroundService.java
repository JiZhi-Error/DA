package com.tencent.mm.plugin.sport.model;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.vendor.MIUI;

public class SportForegroundService extends Service {
    private static boolean FjI;
    private MMHandler ndA;

    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(149337);
        Log.i("MicroMsg.Sport.SportForegroundService", "onStartCommand %d", Integer.valueOf(i3));
        if (d.oD(26)) {
            Notification.Builder builder = new Notification.Builder(getApplicationContext(), "reminder_channel_id");
            builder.setContentTitle(MMApplicationContext.getResources().getString(R.string.hdv)).setWhen(System.currentTimeMillis());
            startForeground(419430, builder.build());
            Log.i("MicroMsg.Sport.SportForegroundService", "onStartCommand startForeground");
            ((PluginSport) g.ah(PluginSport.class)).getPushSportStepDetector().fmp();
            this.ndA = new MMHandler(Looper.getMainLooper());
            this.ndA.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sport.model.SportForegroundService.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(149336);
                    SportForegroundService.fmF();
                    AppMethodBeat.o(149336);
                }
            }, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        }
        int onStartCommand = super.onStartCommand(intent, i2, i3);
        AppMethodBeat.o(149337);
        return onStartCommand;
    }

    public void onDestroy() {
        AppMethodBeat.i(149338);
        Log.i("MicroMsg.Sport.SportForegroundService", "onDestroy");
        if (this.ndA != null) {
            this.ndA.removeCallbacksAndMessages(null);
        }
        stopForeground(true);
        super.onDestroy();
        AppMethodBeat.o(149338);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void fmE() {
        AppMethodBeat.i(149339);
        if (d.oD(26)) {
            if (MIUI.ifMIUI()) {
                Log.i("MicroMsg.Sport.SportForegroundService", "miui, not need to start sport foreground");
                AppMethodBeat.o(149339);
                return;
            } else if (!FjI) {
                Log.i("MicroMsg.Sport.SportForegroundService", "startSportForegroundService");
                FjI = true;
                try {
                    MMApplicationContext.getContext().startForegroundService(new Intent(MMApplicationContext.getContext(), SportForegroundService.class));
                    AppMethodBeat.o(149339);
                    return;
                } catch (Exception e2) {
                }
            }
        }
        AppMethodBeat.o(149339);
    }

    public static void fmF() {
        AppMethodBeat.i(149340);
        if (d.oD(26)) {
            Log.i("MicroMsg.Sport.SportForegroundService", "stopSportForegroundService");
            FjI = false;
            try {
                MMApplicationContext.getContext().stopService(new Intent(MMApplicationContext.getContext(), SportForegroundService.class));
                AppMethodBeat.o(149340);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(149340);
    }

    public static boolean fmG() {
        return FjI;
    }
}
