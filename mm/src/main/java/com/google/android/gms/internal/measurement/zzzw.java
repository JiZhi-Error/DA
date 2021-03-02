package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class zzzw<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzzu> zzbsu;

    private zzzw(Map.Entry<K, zzzu> entry) {
        this.zzbsu = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        AppMethodBeat.i(40384);
        K key = this.zzbsu.getKey();
        AppMethodBeat.o(40384);
        return key;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        AppMethodBeat.i(40385);
        if (this.zzbsu.getValue() == null) {
            AppMethodBeat.o(40385);
            return null;
        }
        zzaal zzto = zzzu.zzto();
        AppMethodBeat.o(40385);
        return zzto;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        AppMethodBeat.i(40386);
        if (!(obj instanceof zzaal)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            AppMethodBeat.o(40386);
            throw illegalArgumentException;
        }
        zzaal zzc = this.zzbsu.getValue().zzc((zzaal) obj);
        AppMethodBeat.o(40386);
        return zzc;
    }
}
