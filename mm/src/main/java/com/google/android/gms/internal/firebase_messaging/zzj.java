package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
public final class zzj {
    private final ConcurrentHashMap<zzk, List<Throwable>> zzh = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzi = new ReferenceQueue<>();

    zzj() {
        AppMethodBeat.i(4117);
        AppMethodBeat.o(4117);
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        AppMethodBeat.i(4118);
        Reference<? extends Throwable> poll = this.zzi.poll();
        while (poll != null) {
            this.zzh.remove(poll);
            poll = this.zzi.poll();
        }
        List<Throwable> list = this.zzh.get(new zzk(th, null));
        if (list != null) {
            AppMethodBeat.o(4118);
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzh.putIfAbsent(new zzk(th, this.zzi), vector);
        if (putIfAbsent == null) {
            AppMethodBeat.o(4118);
            return vector;
        }
        AppMethodBeat.o(4118);
        return putIfAbsent;
    }
}
