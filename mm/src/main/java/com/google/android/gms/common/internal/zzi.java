package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class zzi implements ServiceConnection {
    private ComponentName mComponentName;
    private int mState = 2;
    private IBinder zzry;
    private final Set<ServiceConnection> zztv = new HashSet();
    private boolean zztw;
    private final GmsClientSupervisor.ConnectionStatusConfig zztx;
    private final /* synthetic */ zzh zzty;

    public zzi(zzh zzh, GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig) {
        this.zzty = zzh;
        AppMethodBeat.i(4892);
        this.zztx = connectionStatusConfig;
        AppMethodBeat.o(4892);
    }

    public final IBinder getBinder() {
        return this.zzry;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean isBound() {
        return this.zztw;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(4893);
        synchronized (this.zzty.zztr) {
            try {
                this.zzty.mHandler.removeMessages(1, this.zztx);
                this.zzry = iBinder;
                this.mComponentName = componentName;
                for (ServiceConnection serviceConnection : this.zztv) {
                    serviceConnection.onServiceConnected(componentName, iBinder);
                }
                this.mState = 1;
            } finally {
                AppMethodBeat.o(4893);
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(4894);
        synchronized (this.zzty.zztr) {
            try {
                this.zzty.mHandler.removeMessages(1, this.zztx);
                this.zzry = null;
                this.mComponentName = componentName;
                for (ServiceConnection serviceConnection : this.zztv) {
                    serviceConnection.onServiceDisconnected(componentName);
                }
                this.mState = 2;
            } finally {
                AppMethodBeat.o(4894);
            }
        }
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        AppMethodBeat.i(4897);
        this.zzty.zzts.logConnectService(this.zzty.zzau, serviceConnection, str, this.zztx.getStartServiceIntent(this.zzty.zzau));
        this.zztv.add(serviceConnection);
        AppMethodBeat.o(4897);
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        AppMethodBeat.i(4899);
        boolean contains = this.zztv.contains(serviceConnection);
        AppMethodBeat.o(4899);
        return contains;
    }

    public final void zzb(ServiceConnection serviceConnection, String str) {
        AppMethodBeat.i(4898);
        this.zzty.zzts.logDisconnectService(this.zzty.zzau, serviceConnection);
        this.zztv.remove(serviceConnection);
        AppMethodBeat.o(4898);
    }

    public final boolean zzcv() {
        AppMethodBeat.i(4900);
        boolean isEmpty = this.zztv.isEmpty();
        AppMethodBeat.o(4900);
        return isEmpty;
    }

    public final void zzj(String str) {
        AppMethodBeat.i(4895);
        this.mState = 3;
        this.zztw = this.zzty.zzts.bindService(this.zzty.zzau, str, this.zztx.getStartServiceIntent(this.zzty.zzau), this, this.zztx.getBindFlags());
        if (this.zztw) {
            this.zzty.mHandler.sendMessageDelayed(this.zzty.mHandler.obtainMessage(1, this.zztx), this.zzty.zztu);
            AppMethodBeat.o(4895);
            return;
        }
        this.mState = 2;
        try {
            this.zzty.zzts.unbindService(this.zzty.zzau, this);
            AppMethodBeat.o(4895);
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(4895);
        }
    }

    public final void zzk(String str) {
        AppMethodBeat.i(4896);
        this.zzty.mHandler.removeMessages(1, this.zztx);
        this.zzty.zzts.unbindService(this.zzty.zzau, this);
        this.zztw = false;
        this.mState = 2;
        AppMethodBeat.o(4896);
    }
}
