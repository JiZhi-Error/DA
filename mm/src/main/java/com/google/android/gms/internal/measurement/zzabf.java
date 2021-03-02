package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzabf extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzaay zzbuf;

    private zzabf(zzaay zzaay) {
        this.zzbuf = zzaay;
    }

    /* synthetic */ zzabf(zzaay zzaay, zzaaz zzaaz) {
        this(zzaay);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* synthetic */ boolean add(Object obj) {
        AppMethodBeat.i(40199);
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            this.zzbuf.zza((Comparable) entry.getKey(), entry.getValue());
            AppMethodBeat.o(40199);
            return true;
        }
        AppMethodBeat.o(40199);
        return false;
    }

    public final void clear() {
        AppMethodBeat.i(40198);
        this.zzbuf.clear();
        AppMethodBeat.o(40198);
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(40196);
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzbuf.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 == value || (obj2 != null && obj2.equals(value))) {
            AppMethodBeat.o(40196);
            return true;
        }
        AppMethodBeat.o(40196);
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        AppMethodBeat.i(40194);
        zzabe zzabe = new zzabe(this.zzbuf, null);
        AppMethodBeat.o(40194);
        return zzabe;
    }

    public final boolean remove(Object obj) {
        AppMethodBeat.i(40197);
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            this.zzbuf.remove(entry.getKey());
            AppMethodBeat.o(40197);
            return true;
        }
        AppMethodBeat.o(40197);
        return false;
    }

    public final int size() {
        AppMethodBeat.i(40195);
        int size = this.zzbuf.size();
        AppMethodBeat.o(40195);
        return size;
    }
}
