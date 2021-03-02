package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzzx<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzbsv;

    public zzzx(Iterator<Map.Entry<K, Object>> it) {
        this.zzbsv = it;
    }

    public final boolean hasNext() {
        AppMethodBeat.i(40387);
        boolean hasNext = this.zzbsv.hasNext();
        AppMethodBeat.o(40387);
        return hasNext;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        AppMethodBeat.i(40389);
        Map.Entry<K, Object> next = this.zzbsv.next();
        if (next.getValue() instanceof zzzu) {
            zzzw zzzw = new zzzw(next);
            AppMethodBeat.o(40389);
            return zzzw;
        }
        AppMethodBeat.o(40389);
        return next;
    }

    public final void remove() {
        AppMethodBeat.i(40388);
        this.zzbsv.remove();
        AppMethodBeat.o(40388);
    }
}
