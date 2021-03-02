package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzes<T> extends zzgm<Status> {
    private WeakReference<Map<T, zzhk<T>>> zzec;
    private WeakReference<T> zzed;

    zzes(Map<T, zzhk<T>> map, T t, BaseImplementation.ResultHolder<Status> resultHolder) {
        super(resultHolder);
        AppMethodBeat.i(101266);
        this.zzec = new WeakReference<>(map);
        this.zzed = new WeakReference<>(t);
        AppMethodBeat.o(101266);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.android.gms.common.api.Status */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(Status status) {
        AppMethodBeat.i(101267);
        Map<T, zzhk<T>> map = this.zzec.get();
        T t = this.zzed.get();
        if (!(status.getStatus().isSuccess() || map == null || t == null)) {
            synchronized (map) {
                try {
                    zzhk<T> remove = map.remove(t);
                    if (remove != null) {
                        remove.clear();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(101267);
                    throw th;
                }
            }
        }
        zza((Object) status);
        AppMethodBeat.o(101267);
    }
}
