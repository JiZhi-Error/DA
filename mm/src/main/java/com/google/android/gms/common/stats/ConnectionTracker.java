package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public class ConnectionTracker {
    private static final Object zztm = new Object();
    private static volatile ConnectionTracker zzyg;
    @VisibleForTesting
    private static boolean zzyh = false;
    private final List<String> zzyi = Collections.EMPTY_LIST;
    private final List<String> zzyj = Collections.EMPTY_LIST;
    private final List<String> zzyk = Collections.EMPTY_LIST;
    private final List<String> zzyl = Collections.EMPTY_LIST;

    static {
        AppMethodBeat.i(4981);
        AppMethodBeat.o(4981);
    }

    private ConnectionTracker() {
    }

    public static ConnectionTracker getInstance() {
        AppMethodBeat.i(4975);
        if (zzyg == null) {
            synchronized (zztm) {
                try {
                    if (zzyg == null) {
                        zzyg = new ConnectionTracker();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(4975);
                    throw th;
                }
            }
        }
        ConnectionTracker connectionTracker = zzyg;
        AppMethodBeat.o(4975);
        return connectionTracker;
    }

    @SuppressLint({"UntrackedBindService"})
    private static boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2, boolean z) {
        AppMethodBeat.i(4978);
        if (z) {
            ComponentName component = intent.getComponent();
            if (component == null ? false : ClientLibraryUtils.isPackageStopped(context, component.getPackageName())) {
                AppMethodBeat.o(4978);
                return false;
            }
        }
        boolean bindService = context.bindService(intent, serviceConnection, i2);
        AppMethodBeat.o(4978);
        return bindService;
    }

    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        AppMethodBeat.i(4979);
        boolean bindService = bindService(context, context.getClass().getName(), intent, serviceConnection, i2);
        AppMethodBeat.o(4979);
        return bindService;
    }

    public boolean bindService(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        AppMethodBeat.i(4976);
        boolean zza = zza(context, str, intent, serviceConnection, i2, true);
        AppMethodBeat.o(4976);
        return zza;
    }

    public boolean bindServiceAllowStoppedPackages(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        AppMethodBeat.i(4977);
        boolean zza = zza(context, str, intent, serviceConnection, i2, false);
        AppMethodBeat.o(4977);
        return zza;
    }

    public void logConnectService(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
    }

    public void logDisconnectService(Context context, ServiceConnection serviceConnection) {
    }

    public void logStartService(Service service, int i2) {
    }

    public void logStopService(Service service, int i2) {
    }

    @SuppressLint({"UntrackedBindService"})
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        AppMethodBeat.i(4980);
        context.unbindService(serviceConnection);
        AppMethodBeat.o(4980);
    }
}
