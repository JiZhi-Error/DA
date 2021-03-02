package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
public final class zzh {
    private final ConcurrentHashMap<zzi, List<Throwable>> zzdf = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzdg = new ReferenceQueue<>();

    zzh() {
        AppMethodBeat.i(2580);
        AppMethodBeat.o(2580);
    }

    public final List<Throwable> zzd(Throwable th, boolean z) {
        AppMethodBeat.i(2581);
        Reference<? extends Throwable> poll = this.zzdg.poll();
        while (poll != null) {
            this.zzdf.remove(poll);
            poll = this.zzdg.poll();
        }
        List<Throwable> list = this.zzdf.get(new zzi(th, null));
        if (list != null) {
            AppMethodBeat.o(2581);
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzdf.putIfAbsent(new zzi(th, this.zzdg), vector);
        if (putIfAbsent == null) {
            AppMethodBeat.o(2581);
            return vector;
        }
        AppMethodBeat.o(2581);
        return putIfAbsent;
    }
}
