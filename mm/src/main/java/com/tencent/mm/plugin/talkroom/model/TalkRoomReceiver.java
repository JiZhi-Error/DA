package com.tencent.mm.plugin.talkroom.model;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class TalkRoomReceiver extends BroadcastReceiver {
    protected static void init() {
        AppMethodBeat.i(29472);
        MAlarmHandler.initAlarmBumper(new MAlarmHandler.IBumper() {
            /* class com.tencent.mm.plugin.talkroom.model.TalkRoomReceiver.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MAlarmHandler.IBumper
            public final void prepare() {
                AppMethodBeat.i(29470);
                TalkRoomReceiver.ch(MMApplicationContext.getContext());
                AppMethodBeat.o(29470);
            }

            @Override // com.tencent.mm.sdk.platformtools.MAlarmHandler.IBumper
            public final void cancel() {
                AppMethodBeat.i(29471);
                TalkRoomReceiver.ci(MMApplicationContext.getContext());
                AppMethodBeat.o(29471);
            }
        });
        AppMethodBeat.o(29472);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(29473);
        Log.i("MicroMsg.TalkRoomReceiver", "[ALARM NOTIFICATION] bump:".concat(String.valueOf(intent.getBooleanExtra("MMBoot_Bump", false))));
        ch(context);
        AppMethodBeat.o(29473);
    }

    public static void ch(Context context) {
        long j2 = 30000;
        AppMethodBeat.i(29474);
        long fire = MAlarmHandler.fire();
        Log.d("MicroMsg.TalkRoomReceiver", "bumper comes, next=".concat(String.valueOf(fire)));
        if (fire > 600000) {
            AppMethodBeat.o(29474);
            return;
        }
        if (fire >= 30000) {
            j2 = fire;
        }
        a(j2, context);
        AppMethodBeat.o(29474);
    }

    private static void a(long j2, Context context) {
        AppMethodBeat.i(29475);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Log.w("MicroMsg.TalkRoomReceiver", "reset bumper, interval:%d, now:%d", Long.valueOf(j2), Long.valueOf(elapsedRealtime));
        a.set(context, 107, 2, elapsedRealtime + j2, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 268435456);
        AppMethodBeat.o(29475);
    }

    public static void ci(Context context) {
        AppMethodBeat.i(29476);
        PendingIntent b2 = a.b(context, 107, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true));
        if (b2 != null) {
            a.cancel(context, 107, b2);
            b2.cancel();
        }
        AppMethodBeat.o(29476);
    }
}
