package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;

final class zzabe implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzaay zzbuf;
    private boolean zzbug;
    private Iterator<Map.Entry<K, V>> zzbuh;

    private zzabe(zzaay zzaay) {
        this.zzbuf = zzaay;
        this.pos = -1;
    }

    /* synthetic */ zzabe(zzaay zzaay, zzaaz zzaaz) {
        this(zzaay);
    }

    private final Iterator<Map.Entry<K, V>> zzup() {
        AppMethodBeat.i(40192);
        if (this.zzbuh == null) {
            this.zzbuh = this.zzbuf.zzbtz.entrySet().iterator();
        }
        Iterator<Map.Entry<K, V>> it = this.zzbuh;
        AppMethodBeat.o(40192);
        return it;
    }

    public final boolean hasNext() {
        AppMethodBeat.i(40190);
        if (this.pos + 1 < this.zzbuf.zzbty.size() || (!this.zzbuf.zzbtz.isEmpty() && zzup().hasNext())) {
            AppMethodBeat.o(40190);
            return true;
        }
        AppMethodBeat.o(40190);
        return false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        AppMethodBeat.i(40193);
        this.zzbug = true;
        int i2 = this.pos + 1;
        this.pos = i2;
        if (i2 < this.zzbuf.zzbty.size()) {
            Map.Entry entry = (Map.Entry) this.zzbuf.zzbty.get(this.pos);
            AppMethodBeat.o(40193);
            return entry;
        }
        Map.Entry entry2 = (Map.Entry) zzup().next();
        AppMethodBeat.o(40193);
        return entry2;
    }

    public final void remove() {
        AppMethodBeat.i(40191);
        if (!this.zzbug) {
            IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
            AppMethodBeat.o(40191);
            throw illegalStateException;
        }
        this.zzbug = false;
        zzaay.zza(this.zzbuf);
        if (this.pos < this.zzbuf.zzbty.size()) {
            zzaay zzaay = this.zzbuf;
            int i2 = this.pos;
            this.pos = i2 - 1;
            zzaay.zza(zzaay, i2);
            AppMethodBeat.o(40191);
            return;
        }
        zzup().remove();
        AppMethodBeat.o(40191);
    }
}
