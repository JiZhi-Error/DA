package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
public final class zzm {
    private final ConcurrentHashMap<zzn, List<Throwable>> zzahj = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzahk = new ReferenceQueue<>();

    zzm() {
        AppMethodBeat.i(5517);
        AppMethodBeat.o(5517);
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        AppMethodBeat.i(5518);
        Reference<? extends Throwable> poll = this.zzahk.poll();
        while (poll != null) {
            this.zzahj.remove(poll);
            poll = this.zzahk.poll();
        }
        List<Throwable> list = this.zzahj.get(new zzn(th, null));
        if (list != null) {
            AppMethodBeat.o(5518);
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzahj.putIfAbsent(new zzn(th, this.zzahk), vector);
        if (putIfAbsent == null) {
            AppMethodBeat.o(5518);
            return vector;
        }
        AppMethodBeat.o(5518);
        return putIfAbsent;
    }
}
