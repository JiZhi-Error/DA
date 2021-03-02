package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public final class zziw implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzii zzape;
    private volatile boolean zzapk;
    private volatile zzff zzapl;

    protected zziw(zzii zzii) {
        this.zzape = zzii;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(1862);
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.zzapl = null;
                this.zzape.zzgd().zzc(new zziz(this, (zzey) this.zzapl.getService()));
            } catch (DeadObjectException | IllegalStateException e2) {
                this.zzapl = null;
                this.zzapk = false;
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(1862);
                throw th;
            }
        }
        AppMethodBeat.o(1862);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AppMethodBeat.i(1864);
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzfg zzjo = this.zzape.zzacw.zzjo();
        if (zzjo != null) {
            zzjo.zzip().zzg("Service connection failed", connectionResult);
        }
        synchronized (this) {
            try {
                this.zzapk = false;
                this.zzapl = null;
            } catch (Throwable th) {
                AppMethodBeat.o(1864);
                throw th;
            }
        }
        this.zzape.zzgd().zzc(new zzjb(this));
        AppMethodBeat.o(1864);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        AppMethodBeat.i(1863);
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zzape.zzge().zzis().log("Service connection suspended");
        this.zzape.zzgd().zzc(new zzja(this));
        AppMethodBeat.o(1863);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r6, android.os.IBinder r7) {
        /*
        // Method dump skipped, instructions count: 182
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zziw.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(1860);
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zzape.zzge().zzis().log("Service disconnected");
        this.zzape.zzgd().zzc(new zziy(this, componentName));
        AppMethodBeat.o(1860);
    }

    public final void zzc(Intent intent) {
        AppMethodBeat.i(1858);
        this.zzape.zzab();
        Context context = this.zzape.getContext();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            try {
                if (this.zzapk) {
                    this.zzape.zzge().zzit().log("Connection attempt already in progress");
                    return;
                }
                this.zzape.zzge().zzit().log("Using local app measurement service");
                this.zzapk = true;
                instance.bindService(context, intent, this.zzape.zzaox, 129);
                AppMethodBeat.o(1858);
            } finally {
                AppMethodBeat.o(1858);
            }
        }
    }

    public final void zzkh() {
        AppMethodBeat.i(1861);
        this.zzape.zzab();
        Context context = this.zzape.getContext();
        synchronized (this) {
            try {
                if (this.zzapk) {
                    this.zzape.zzge().zzit().log("Connection attempt already in progress");
                } else if (this.zzapl != null) {
                    this.zzape.zzge().zzit().log("Already awaiting connection attempt");
                    AppMethodBeat.o(1861);
                } else {
                    this.zzapl = new zzff(context, Looper.getMainLooper(), this, this);
                    this.zzape.zzge().zzit().log("Connecting to remote service");
                    this.zzapk = true;
                    this.zzapl.checkAvailabilityAndConnect();
                    AppMethodBeat.o(1861);
                }
            } finally {
                AppMethodBeat.o(1861);
            }
        }
    }
}
