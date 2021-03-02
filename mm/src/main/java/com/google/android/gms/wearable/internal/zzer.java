package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzer<T> {
    private final Map<T, zzhk<T>> zzeb = new HashMap();

    zzer() {
        AppMethodBeat.i(101262);
        AppMethodBeat.o(101262);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.wearable.internal.zzep] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.os.IBinder r12) {
        /*
        // Method dump skipped, instructions count: 217
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzer.zza(android.os.IBinder):void");
    }

    public final void zza(zzhg zzhg, BaseImplementation.ResultHolder<Status> resultHolder, T t) {
        AppMethodBeat.i(101265);
        synchronized (this.zzeb) {
            try {
                zzhk<T> remove = this.zzeb.remove(t);
                if (remove == null) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        String valueOf = String.valueOf(t);
                        new StringBuilder(String.valueOf(valueOf).length() + 25).append("remove Listener unknown: ").append(valueOf);
                    }
                    resultHolder.setResult(new Status(4002));
                    return;
                }
                remove.clear();
                if (Log.isLoggable("WearableClient", 2)) {
                    String valueOf2 = String.valueOf(t);
                    new StringBuilder(String.valueOf(valueOf2).length() + 24).append("service.removeListener: ").append(valueOf2);
                }
                ((zzep) zzhg.getService()).zza(new zzet(this.zzeb, t, resultHolder), new zzfw(remove));
                AppMethodBeat.o(101265);
            } finally {
                AppMethodBeat.o(101265);
            }
        }
    }

    public final void zza(zzhg zzhg, BaseImplementation.ResultHolder<Status> resultHolder, T t, zzhk<T> zzhk) {
        AppMethodBeat.i(101264);
        synchronized (this.zzeb) {
            try {
                if (this.zzeb.get(t) != null) {
                    if (Log.isLoggable("WearableClient", 2)) {
                        String valueOf = String.valueOf(t);
                        new StringBuilder(String.valueOf(valueOf).length() + 20).append("duplicate listener: ").append(valueOf);
                    }
                    resultHolder.setResult(new Status(4001));
                    return;
                }
                if (Log.isLoggable("WearableClient", 2)) {
                    String valueOf2 = String.valueOf(t);
                    new StringBuilder(String.valueOf(valueOf2).length() + 14).append("new listener: ").append(valueOf2);
                }
                this.zzeb.put(t, zzhk);
                try {
                    ((zzep) zzhg.getService()).zza(new zzes(this.zzeb, t, resultHolder), new zzd(zzhk));
                    AppMethodBeat.o(101264);
                } catch (RemoteException e2) {
                    if (Log.isLoggable("WearableClient", 3)) {
                        String valueOf3 = String.valueOf(t);
                        new StringBuilder(String.valueOf(valueOf3).length() + 39).append("addListener failed, removing listener: ").append(valueOf3);
                    }
                    this.zzeb.remove(t);
                    AppMethodBeat.o(101264);
                    throw e2;
                }
            } finally {
                AppMethodBeat.o(101264);
            }
        }
    }
}
