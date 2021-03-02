package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
public final class zzh extends GmsClientSupervisor implements Handler.Callback {
    private final Handler mHandler;
    private final Context zzau;
    @GuardedBy("mConnectionStatus")
    private final HashMap<GmsClientSupervisor.ConnectionStatusConfig, zzi> zztr = new HashMap<>();
    private final ConnectionTracker zzts;
    private final long zztt;
    private final long zztu;

    zzh(Context context) {
        AppMethodBeat.i(4887);
        this.zzau = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzts = ConnectionTracker.getInstance();
        this.zztt = 5000;
        this.zztu = 300000;
        AppMethodBeat.o(4887);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean bindService(GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        AppMethodBeat.i(4888);
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zztr) {
            try {
                zzi zzi = this.zztr.get(connectionStatusConfig);
                if (zzi != null) {
                    this.mHandler.removeMessages(0, connectionStatusConfig);
                    if (!zzi.zza(serviceConnection)) {
                        zzi.zza(serviceConnection, str);
                        switch (zzi.getState()) {
                            case 1:
                                serviceConnection.onServiceConnected(zzi.getComponentName(), zzi.getBinder());
                                break;
                            case 2:
                                zzi.zzj(str);
                                break;
                        }
                    } else {
                        String valueOf = String.valueOf(connectionStatusConfig);
                        IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
                        AppMethodBeat.o(4888);
                        throw illegalStateException;
                    }
                } else {
                    zzi = new zzi(this, connectionStatusConfig);
                    zzi.zza(serviceConnection, str);
                    zzi.zzj(str);
                    this.zztr.put(connectionStatusConfig, zzi);
                }
                isBound = zzi.isBound();
            } finally {
                AppMethodBeat.o(4888);
            }
        }
        return isBound;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(4890);
        switch (message.what) {
            case 0:
                synchronized (this.zztr) {
                    try {
                        GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig = (GmsClientSupervisor.ConnectionStatusConfig) message.obj;
                        zzi zzi = this.zztr.get(connectionStatusConfig);
                        if (zzi != null && zzi.zzcv()) {
                            if (zzi.isBound()) {
                                zzi.zzk("GmsClientSupervisor");
                            }
                            this.zztr.remove(connectionStatusConfig);
                        }
                    } finally {
                        AppMethodBeat.o(4890);
                    }
                }
                return true;
            case 1:
                synchronized (this.zztr) {
                    try {
                        GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig2 = (GmsClientSupervisor.ConnectionStatusConfig) message.obj;
                        zzi zzi2 = this.zztr.get(connectionStatusConfig2);
                        if (zzi2 != null && zzi2.getState() == 3) {
                            String valueOf = String.valueOf(connectionStatusConfig2);
                            Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(valueOf).toString(), new Exception());
                            ComponentName componentName = zzi2.getComponentName();
                            if (componentName == null) {
                                componentName = connectionStatusConfig2.getComponentName();
                            }
                            zzi2.onServiceDisconnected(componentName == null ? new ComponentName(connectionStatusConfig2.getPackage(), "unknown") : componentName);
                        }
                    } finally {
                        AppMethodBeat.o(4890);
                    }
                }
                return true;
            default:
                AppMethodBeat.o(4890);
                return false;
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    @VisibleForTesting
    public final void resetForTesting() {
        AppMethodBeat.i(4891);
        synchronized (this.zztr) {
            try {
                for (zzi zzi : this.zztr.values()) {
                    this.mHandler.removeMessages(0, zzi.zza(zzi));
                    if (zzi.isBound()) {
                        zzi.zzk("GmsClientSupervisor");
                    }
                }
                this.zztr.clear();
            } finally {
                AppMethodBeat.o(4891);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void unbindService(GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str) {
        AppMethodBeat.i(4889);
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zztr) {
            try {
                zzi zzi = this.zztr.get(connectionStatusConfig);
                if (zzi == null) {
                    String valueOf = String.valueOf(connectionStatusConfig);
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
                    AppMethodBeat.o(4889);
                    throw illegalStateException;
                } else if (!zzi.zza(serviceConnection)) {
                    String valueOf2 = String.valueOf(connectionStatusConfig);
                    IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf2).toString());
                    AppMethodBeat.o(4889);
                    throw illegalStateException2;
                } else {
                    zzi.zzb(serviceConnection, str);
                    if (zzi.zzcv()) {
                        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, connectionStatusConfig), this.zztt);
                    }
                }
            } finally {
                AppMethodBeat.o(4889);
            }
        }
    }
}
