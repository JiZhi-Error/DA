package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
public final class u {
    private final BroadcastReceiver.PendingResult bMh;
    private final ScheduledFuture<?> bMi;
    final Intent intent;
    private boolean zzt = false;

    u(Intent intent2, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(4210);
        this.intent = intent2;
        this.bMh = pendingResult;
        this.bMi = scheduledExecutorService.schedule(new v(this, intent2), 9500, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(4210);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void finish() {
        AppMethodBeat.i(4211);
        if (!this.zzt) {
            this.bMh.finish();
            this.bMi.cancel(false);
            this.zzt = true;
        }
        AppMethodBeat.o(4211);
    }
}
