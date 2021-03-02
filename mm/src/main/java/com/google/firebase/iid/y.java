package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class y implements ServiceConnection {
    private final Context bLv;
    private final Intent bMn;
    private final ScheduledExecutorService bMo;
    private final Queue<u> bMp;
    private w bMq;
    private boolean bMr;

    public y(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
        AppMethodBeat.i(4214);
        AppMethodBeat.o(4214);
    }

    private y(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(4215);
        this.bMp = new ArrayDeque();
        this.bMr = false;
        this.bLv = context.getApplicationContext();
        this.bMn = new Intent(str).setPackage(this.bLv.getPackageName());
        this.bMo = scheduledExecutorService;
        AppMethodBeat.o(4215);
    }

    public final synchronized void a(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        AppMethodBeat.i(4216);
        Log.isLoggable("EnhancedIntentService", 3);
        this.bMp.add(new u(intent, pendingResult, this.bMo));
        zzc();
        AppMethodBeat.o(4216);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(4218);
        synchronized (this) {
            try {
                this.bMr = false;
                this.bMq = (w) iBinder;
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    String valueOf = String.valueOf(componentName);
                    new StringBuilder(String.valueOf(valueOf).length() + 20).append("onServiceConnected: ").append(valueOf);
                }
                zzc();
            } finally {
                AppMethodBeat.o(4218);
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(4219);
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            new StringBuilder(String.valueOf(valueOf).length() + 23).append("onServiceDisconnected: ").append(valueOf);
        }
        zzc();
        AppMethodBeat.o(4219);
    }

    private final synchronized void zzc() {
        AppMethodBeat.i(4217);
        Log.isLoggable("EnhancedIntentService", 3);
        while (true) {
            if (this.bMp.isEmpty()) {
                AppMethodBeat.o(4217);
                break;
            }
            Log.isLoggable("EnhancedIntentService", 3);
            if (this.bMq != null && this.bMq.isBinderAlive()) {
                Log.isLoggable("EnhancedIntentService", 3);
                u poll = this.bMp.poll();
                w wVar = this.bMq;
                if (Binder.getCallingUid() != Process.myUid()) {
                    SecurityException securityException = new SecurityException("Binding only allowed within app");
                    AppMethodBeat.o(4217);
                    throw securityException;
                }
                Log.isLoggable("EnhancedIntentService", 3);
                if (wVar.bMk.h(poll.intent)) {
                    poll.finish();
                } else {
                    Log.isLoggable("EnhancedIntentService", 3);
                    wVar.bMk.bMa.execute(new x(wVar, poll));
                }
            }
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            new StringBuilder(39).append("binder is dead. start connection? ").append(!this.bMr);
        }
        if (!this.bMr) {
            this.bMr = true;
            try {
                if (ConnectionTracker.getInstance().bindService(this.bLv, this.bMn, this, 65)) {
                    AppMethodBeat.o(4217);
                }
            } catch (SecurityException e2) {
            }
            while (!this.bMp.isEmpty()) {
                this.bMp.poll().finish();
            }
        }
        AppMethodBeat.o(4217);
    }
}
