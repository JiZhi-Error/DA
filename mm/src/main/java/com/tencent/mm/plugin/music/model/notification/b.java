package com.tencent.mm.plugin.music.model.notification;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import junit.framework.Assert;

public final class b {
    public MMMusicPlayerService AkZ;
    volatile boolean Ale = false;
    public IListener lEl;

    /* access modifiers changed from: package-private */
    public final synchronized void euJ() {
        AppMethodBeat.i(63120);
        if (this.AkZ == null || !this.Ale) {
            this.Ale = true;
            Intent intent = new Intent();
            intent.setClass(MMApplicationContext.getContext(), MMMusicPlayerService.class);
            Log.i("MicroMsg.Music.MMMusicNotificationHelper", "isOk:%b", Boolean.valueOf(MMApplicationContext.getContext().bindService(intent, new ServiceConnection() {
                /* class com.tencent.mm.plugin.music.model.notification.b.AnonymousClass2 */

                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    AppMethodBeat.i(63118);
                    Log.i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceConnected");
                    if (!(iBinder instanceof MMMusicPlayerService.a)) {
                        Log.e("MicroMsg.Music.MMMusicNotificationHelper", "service %s isn't MMMusicPlayerService, err, return", iBinder.getClass().getName());
                        Assert.assertTrue(false);
                        AppMethodBeat.o(63118);
                        return;
                    }
                    b.this.Ale = false;
                    b.this.AkZ = MMMusicPlayerService.this;
                    AppMethodBeat.o(63118);
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    AppMethodBeat.i(63119);
                    Log.i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceDisconnected");
                    b.this.Ale = false;
                    b.this.AkZ = null;
                    AppMethodBeat.o(63119);
                }
            }, 1)));
            AppMethodBeat.o(63120);
        } else {
            AppMethodBeat.o(63120);
        }
    }
}
