package com.google.android.gms.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
public final class zzt implements ServiceConnection {
    @GuardedBy("this")
    int state;
    final Messenger zzcc;
    zzy zzcd;
    @GuardedBy("this")
    final Queue<zzz<?>> zzce;
    @GuardedBy("this")
    final SparseArray<zzz<?>> zzcf;
    final /* synthetic */ zzr zzcg;

    private zzt(zzr zzr) {
        this.zzcg = zzr;
        AppMethodBeat.i(2557);
        this.state = 0;
        this.zzcc = new Messenger(new Handler(Looper.getMainLooper(), new zzu(this)));
        this.zzce = new ArrayDeque();
        this.zzcf = new SparseArray<>();
        AppMethodBeat.o(2557);
    }

    private final void zzr() {
        AppMethodBeat.i(2561);
        this.zzcg.zzbz.execute(new zzw(this));
        AppMethodBeat.o(2561);
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(2560);
        Log.isLoggable("MessengerIpcClient", 2);
        if (iBinder == null) {
            zzd(0, "Null service connection");
            AppMethodBeat.o(2560);
        } else {
            try {
                this.zzcd = new zzy(iBinder);
                this.state = 2;
                zzr();
                AppMethodBeat.o(2560);
            } catch (RemoteException e2) {
                zzd(0, e2.getMessage());
                AppMethodBeat.o(2560);
            }
        }
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(2562);
        Log.isLoggable("MessengerIpcClient", 2);
        zzd(2, "Service disconnected");
        AppMethodBeat.o(2562);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(int i2, String str) {
        AppMethodBeat.i(2563);
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Disconnected: ".concat(valueOf);
            } else {
                new String("Disconnected: ");
            }
        }
        switch (this.state) {
            case 0:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(2563);
                throw illegalStateException;
            case 1:
            case 2:
                Log.isLoggable("MessengerIpcClient", 2);
                this.state = 4;
                ConnectionTracker.getInstance().unbindService(this.zzcg.zzk, this);
                zzaa zzaa = new zzaa(i2, str);
                for (zzz<?> zzz : this.zzce) {
                    zzz.zzd(zzaa);
                }
                this.zzce.clear();
                for (int i3 = 0; i3 < this.zzcf.size(); i3++) {
                    this.zzcf.valueAt(i3).zzd(zzaa);
                }
                this.zzcf.clear();
                AppMethodBeat.o(2563);
                break;
            case 3:
                this.state = 4;
                AppMethodBeat.o(2563);
                break;
            case 4:
                AppMethodBeat.o(2563);
                break;
            default:
                IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
                AppMethodBeat.o(2563);
                throw illegalStateException2;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(Message message) {
        AppMethodBeat.i(2559);
        int i2 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            new StringBuilder(41).append("Received response to request: ").append(i2);
        }
        synchronized (this) {
            try {
                zzz<?> zzz = this.zzcf.get(i2);
                if (zzz == null) {
                    new StringBuilder(50).append("Received response for unknown request: ").append(i2);
                } else {
                    this.zzcf.remove(i2);
                    zzs();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        zzz.zzd(new zzaa(4, "Not supported by GmsCore"));
                    } else {
                        zzz.zzh(data);
                    }
                    AppMethodBeat.o(2559);
                }
            } finally {
                AppMethodBeat.o(2559);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zze(zzz zzz) {
        boolean z = false;
        boolean z2 = true;
        synchronized (this) {
            AppMethodBeat.i(2558);
            switch (this.state) {
                case 0:
                    this.zzce.add(zzz);
                    if (this.state == 0) {
                        z = true;
                    }
                    Preconditions.checkState(z);
                    Log.isLoggable("MessengerIpcClient", 2);
                    this.state = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    if (!ConnectionTracker.getInstance().bindService(this.zzcg.zzk, intent, this, 1)) {
                        zzd(0, "Unable to bind to service");
                    } else {
                        this.zzcg.zzbz.schedule(new zzv(this), 30, TimeUnit.SECONDS);
                    }
                    AppMethodBeat.o(2558);
                    break;
                case 1:
                    this.zzce.add(zzz);
                    AppMethodBeat.o(2558);
                    break;
                case 2:
                    this.zzce.add(zzz);
                    zzr();
                    AppMethodBeat.o(2558);
                    break;
                case 3:
                case 4:
                    AppMethodBeat.o(2558);
                    z2 = false;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
                    AppMethodBeat.o(2558);
                    throw illegalStateException;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzg(int i2) {
        AppMethodBeat.i(2566);
        zzz<?> zzz = this.zzcf.get(i2);
        if (zzz != null) {
            new StringBuilder(31).append("Timing out request: ").append(i2);
            this.zzcf.remove(i2);
            zzz.zzd(new zzaa(3, "Timed out waiting for response"));
            zzs();
        }
        AppMethodBeat.o(2566);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzs() {
        AppMethodBeat.i(2564);
        if (this.state == 2 && this.zzce.isEmpty() && this.zzcf.size() == 0) {
            Log.isLoggable("MessengerIpcClient", 2);
            this.state = 3;
            ConnectionTracker.getInstance().unbindService(this.zzcg.zzk, this);
        }
        AppMethodBeat.o(2564);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzt() {
        AppMethodBeat.i(2565);
        if (this.state == 1) {
            zzd(1, "Timed out while binding");
        }
        AppMethodBeat.o(2565);
    }
}
