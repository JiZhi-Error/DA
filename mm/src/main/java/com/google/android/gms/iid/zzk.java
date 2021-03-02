package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class zzk implements ServiceConnection {
    private final Intent zzbl;
    private final ScheduledExecutorService zzbm;
    private final Queue<zzg> zzbn;
    private zzi zzbo;
    private boolean zzbp;
    private final Context zzk;

    public zzk(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
        AppMethodBeat.i(2523);
        AppMethodBeat.o(2523);
    }

    private zzk(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(2524);
        this.zzbn = new ArrayDeque();
        this.zzbp = false;
        this.zzk = context.getApplicationContext();
        this.zzbl = new Intent(str).setPackage(this.zzk.getPackageName());
        this.zzbm = scheduledExecutorService;
        AppMethodBeat.o(2524);
    }

    private final synchronized void zzl() {
        AppMethodBeat.i(2526);
        Log.isLoggable("EnhancedIntentService", 3);
        while (true) {
            if (this.zzbn.isEmpty()) {
                AppMethodBeat.o(2526);
                break;
            }
            Log.isLoggable("EnhancedIntentService", 3);
            if (this.zzbo != null && this.zzbo.isBinderAlive()) {
                Log.isLoggable("EnhancedIntentService", 3);
                this.zzbo.zzd(this.zzbn.poll());
            }
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            new StringBuilder(39).append("binder is dead. start connection? ").append(!this.zzbp);
        }
        if (!this.zzbp) {
            this.zzbp = true;
            try {
                if (ConnectionTracker.getInstance().bindService(this.zzk, this.zzbl, this, 65)) {
                    AppMethodBeat.o(2526);
                }
            } catch (SecurityException e2) {
            }
            while (!this.zzbn.isEmpty()) {
                this.zzbn.poll().finish();
            }
        }
        AppMethodBeat.o(2526);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(2527);
        synchronized (this) {
            try {
                this.zzbp = false;
                this.zzbo = (zzi) iBinder;
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    String valueOf = String.valueOf(componentName);
                    new StringBuilder(String.valueOf(valueOf).length() + 20).append("onServiceConnected: ").append(valueOf);
                }
                zzl();
            } finally {
                AppMethodBeat.o(2527);
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(2528);
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            new StringBuilder(String.valueOf(valueOf).length() + 23).append("onServiceDisconnected: ").append(valueOf);
        }
        zzl();
        AppMethodBeat.o(2528);
    }

    public final synchronized void zzd(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        AppMethodBeat.i(2525);
        Log.isLoggable("EnhancedIntentService", 3);
        this.zzbn.add(new zzg(intent, pendingResult, this.zzbm));
        zzl();
        AppMethodBeat.o(2525);
    }
}
