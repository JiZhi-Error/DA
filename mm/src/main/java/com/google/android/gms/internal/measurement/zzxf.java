package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
public final class zzxf {
    private final ConcurrentHashMap<zzxg, List<Throwable>> zzboa = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzbob = new ReferenceQueue<>();

    zzxf() {
        AppMethodBeat.i(40329);
        AppMethodBeat.o(40329);
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        AppMethodBeat.i(40330);
        Reference<? extends Throwable> poll = this.zzbob.poll();
        while (poll != null) {
            this.zzboa.remove(poll);
            poll = this.zzbob.poll();
        }
        List<Throwable> list = this.zzboa.get(new zzxg(th, null));
        AppMethodBeat.o(40330);
        return list;
    }
}
