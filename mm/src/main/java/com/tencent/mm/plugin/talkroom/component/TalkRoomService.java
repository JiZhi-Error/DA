package com.tencent.mm.plugin.talkroom.component;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class TalkRoomService extends Service {
    private g FPx;

    static {
        AppMethodBeat.i(29430);
        Log.i("MicroMsg.TalkRoomService", new StringBuilder().append(Thread.currentThread().getId()).toString());
        AppMethodBeat.o(29430);
    }

    public void onCreate() {
        AppMethodBeat.i(29425);
        Log.d("MicroMsg.TalkRoomService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(9999, new Notification());
        }
        if (this.FPx == null) {
            this.FPx = new g();
        }
        AppMethodBeat.o(29425);
    }

    public void onDestroy() {
        AppMethodBeat.i(29426);
        Log.d("MicroMsg.TalkRoomService", "onDestroy~~~ threadID:" + Thread.currentThread());
        super.onDestroy();
        AppMethodBeat.o(29426);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(29427);
        Log.d("MicroMsg.TalkRoomService", "onUnbind~~~ threadID:" + Thread.currentThread());
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(29427);
        return onUnbind;
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(29428);
        Log.d("MicroMsg.TalkRoomService", "onBind~~~ threadID:" + Thread.currentThread());
        g gVar = this.FPx;
        AppMethodBeat.o(29428);
        return gVar;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.i(29429);
        Log.d("MicroMsg.TalkRoomService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
        AppMethodBeat.o(29429);
    }
}
