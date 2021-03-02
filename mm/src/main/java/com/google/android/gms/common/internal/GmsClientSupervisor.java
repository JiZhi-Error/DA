package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class GmsClientSupervisor {
    public static final int DEFAULT_BIND_FLAGS = 129;
    private static final Object zztm = new Object();
    private static GmsClientSupervisor zztn;

    /* access modifiers changed from: protected */
    public static final class ConnectionStatusConfig {
        private final ComponentName mComponentName;
        private final String zzto;
        private final String zztp;
        private final int zztq;

        public ConnectionStatusConfig(ComponentName componentName, int i2) {
            AppMethodBeat.i(4638);
            this.zzto = null;
            this.zztp = null;
            this.mComponentName = (ComponentName) Preconditions.checkNotNull(componentName);
            this.zztq = i2;
            AppMethodBeat.o(4638);
        }

        public ConnectionStatusConfig(String str, int i2) {
            AppMethodBeat.i(4636);
            this.zzto = Preconditions.checkNotEmpty(str);
            this.zztp = "com.google.android.gms";
            this.mComponentName = null;
            this.zztq = i2;
            AppMethodBeat.o(4636);
        }

        public ConnectionStatusConfig(String str, String str2, int i2) {
            AppMethodBeat.i(4637);
            this.zzto = Preconditions.checkNotEmpty(str);
            this.zztp = Preconditions.checkNotEmpty(str2);
            this.mComponentName = null;
            this.zztq = i2;
            AppMethodBeat.o(4637);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(4642);
            if (this == obj) {
                AppMethodBeat.o(4642);
                return true;
            } else if (!(obj instanceof ConnectionStatusConfig)) {
                AppMethodBeat.o(4642);
                return false;
            } else {
                ConnectionStatusConfig connectionStatusConfig = (ConnectionStatusConfig) obj;
                if (!Objects.equal(this.zzto, connectionStatusConfig.zzto) || !Objects.equal(this.zztp, connectionStatusConfig.zztp) || !Objects.equal(this.mComponentName, connectionStatusConfig.mComponentName) || this.zztq != connectionStatusConfig.zztq) {
                    AppMethodBeat.o(4642);
                    return false;
                }
                AppMethodBeat.o(4642);
                return true;
            }
        }

        public final String getAction() {
            return this.zzto;
        }

        public final int getBindFlags() {
            return this.zztq;
        }

        public final ComponentName getComponentName() {
            return this.mComponentName;
        }

        public final String getPackage() {
            return this.zztp;
        }

        public final Intent getStartServiceIntent(Context context) {
            AppMethodBeat.i(4640);
            Intent intent = this.zzto != null ? new Intent(this.zzto).setPackage(this.zztp) : new Intent().setComponent(this.mComponentName);
            AppMethodBeat.o(4640);
            return intent;
        }

        public final int hashCode() {
            AppMethodBeat.i(4641);
            int hashCode = Objects.hashCode(this.zzto, this.zztp, this.mComponentName, Integer.valueOf(this.zztq));
            AppMethodBeat.o(4641);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(4639);
            if (this.zzto == null) {
                String flattenToString = this.mComponentName.flattenToString();
                AppMethodBeat.o(4639);
                return flattenToString;
            }
            String str = this.zzto;
            AppMethodBeat.o(4639);
            return str;
        }
    }

    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (zztm) {
            if (zztn == null) {
                zztn = new zzh(context.getApplicationContext());
            }
        }
        return zztn;
    }

    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return bindService(new ConnectionStatusConfig(componentName, 129), serviceConnection, str);
    }

    /* access modifiers changed from: protected */
    public abstract boolean bindService(ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str);

    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return bindService(new ConnectionStatusConfig(str, 129), serviceConnection, str2);
    }

    public boolean bindService(String str, String str2, int i2, ServiceConnection serviceConnection, String str3) {
        return bindService(new ConnectionStatusConfig(str, str2, i2), serviceConnection, str3);
    }

    public boolean bindService(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return bindService(str, str2, 129, serviceConnection, str3);
    }

    @VisibleForTesting
    public abstract void resetForTesting();

    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        unbindService(new ConnectionStatusConfig(componentName, 129), serviceConnection, str);
    }

    /* access modifiers changed from: protected */
    public abstract void unbindService(ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str);

    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        unbindService(new ConnectionStatusConfig(str, 129), serviceConnection, str2);
    }

    public void unbindService(String str, String str2, int i2, ServiceConnection serviceConnection, String str3) {
        unbindService(new ConnectionStatusConfig(str, str2, i2), serviceConnection, str3);
    }

    public void unbindService(String str, String str2, ServiceConnection serviceConnection, String str3) {
        unbindService(str, str2, 129, serviceConnection, str3);
    }
}
