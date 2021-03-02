package com.google.firebase.iid;

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
public final class aj implements ServiceConnection {
    final Messenger bMI;
    ao bMJ;
    @GuardedBy("this")
    final Queue<c<?>> bMK;
    @GuardedBy("this")
    final SparseArray<c<?>> bML;
    final /* synthetic */ ai bMM;
    @GuardedBy("this")
    int state;

    private aj(ai aiVar) {
        this.bMM = aiVar;
        AppMethodBeat.i(4256);
        this.state = 0;
        this.bMI = new Messenger(new Handler(Looper.getMainLooper(), new ak(this)));
        this.bMK = new ArrayDeque();
        this.bML = new SparseArray<>();
        AppMethodBeat.o(4256);
    }

    /* synthetic */ aj(ai aiVar, byte b2) {
        this(aiVar);
    }

    /* access modifiers changed from: package-private */
    public final boolean f(Message message) {
        AppMethodBeat.i(4258);
        int i2 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            new StringBuilder(41).append("Received response to request: ").append(i2);
        }
        synchronized (this) {
            try {
                c<?> cVar = this.bML.get(i2);
                if (cVar == null) {
                    new StringBuilder(50).append("Received response for unknown request: ").append(i2);
                } else {
                    this.bML.remove(i2);
                    zzu();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        cVar.a(new d(4, "Not supported by GmsCore"));
                    } else {
                        cVar.zzb(data);
                    }
                    AppMethodBeat.o(4258);
                }
            } finally {
                AppMethodBeat.o(4258);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void fz(int i2) {
        AppMethodBeat.i(4265);
        c<?> cVar = this.bML.get(i2);
        if (cVar != null) {
            new StringBuilder(31).append("Timing out request: ").append(i2);
            this.bML.remove(i2);
            cVar.a(new d(3, "Timed out waiting for response"));
            zzu();
        }
        AppMethodBeat.o(4265);
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(4259);
        Log.isLoggable("MessengerIpcClient", 2);
        if (iBinder == null) {
            zza(0, "Null service connection");
            AppMethodBeat.o(4259);
        } else {
            try {
                this.bMJ = new ao(iBinder);
                this.state = 2;
                zzt();
                AppMethodBeat.o(4259);
            } catch (RemoteException e2) {
                zza(0, e2.getMessage());
                AppMethodBeat.o(4259);
            }
        }
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(4261);
        Log.isLoggable("MessengerIpcClient", 2);
        zza(2, "Service disconnected");
        AppMethodBeat.o(4261);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzv() {
        AppMethodBeat.i(4264);
        if (this.state == 1) {
            zza(1, "Timed out while binding");
        }
        AppMethodBeat.o(4264);
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean b(c cVar) {
        boolean z = false;
        boolean z2 = true;
        synchronized (this) {
            AppMethodBeat.i(4257);
            switch (this.state) {
                case 0:
                    this.bMK.add(cVar);
                    if (this.state == 0) {
                        z = true;
                    }
                    Preconditions.checkState(z);
                    Log.isLoggable("MessengerIpcClient", 2);
                    this.state = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    if (!ConnectionTracker.getInstance().bindService(this.bMM.bLv, intent, this, 1)) {
                        zza(0, "Unable to bind to service");
                    } else {
                        this.bMM.bMF.schedule(new al(this), 30, TimeUnit.SECONDS);
                    }
                    AppMethodBeat.o(4257);
                    break;
                case 1:
                    this.bMK.add(cVar);
                    AppMethodBeat.o(4257);
                    break;
                case 2:
                    this.bMK.add(cVar);
                    zzt();
                    AppMethodBeat.o(4257);
                    break;
                case 3:
                case 4:
                    AppMethodBeat.o(4257);
                    z2 = false;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
                    AppMethodBeat.o(4257);
                    throw illegalStateException;
            }
        }
        return z2;
    }

    private final void zzt() {
        AppMethodBeat.i(4260);
        this.bMM.bMF.execute(new am(this));
        AppMethodBeat.o(4260);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i2, String str) {
        AppMethodBeat.i(4262);
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
                AppMethodBeat.o(4262);
                throw illegalStateException;
            case 1:
            case 2:
                Log.isLoggable("MessengerIpcClient", 2);
                this.state = 4;
                ConnectionTracker.getInstance().unbindService(this.bMM.bLv, this);
                d dVar = new d(i2, str);
                for (c<?> cVar : this.bMK) {
                    cVar.a(dVar);
                }
                this.bMK.clear();
                for (int i3 = 0; i3 < this.bML.size(); i3++) {
                    this.bML.valueAt(i3).a(dVar);
                }
                this.bML.clear();
                AppMethodBeat.o(4262);
                break;
            case 3:
                this.state = 4;
                AppMethodBeat.o(4262);
                break;
            case 4:
                AppMethodBeat.o(4262);
                break;
            default:
                IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
                AppMethodBeat.o(4262);
                throw illegalStateException2;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzu() {
        AppMethodBeat.i(4263);
        if (this.state == 2 && this.bMK.isEmpty() && this.bML.size() == 0) {
            Log.isLoggable("MessengerIpcClient", 2);
            this.state = 3;
            ConnectionTracker.getInstance().unbindService(this.bMM.bLv, this);
        }
        AppMethodBeat.o(4263);
    }
}
