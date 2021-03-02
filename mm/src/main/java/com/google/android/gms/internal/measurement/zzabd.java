package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzabd implements Comparable<zzabd>, Map.Entry<K, V> {
    private V value;
    private final K zzbue;
    private final /* synthetic */ zzaay zzbuf;

    zzabd(zzaay zzaay, K k, V v) {
        this.zzbuf = zzaay;
        this.zzbue = k;
        this.value = v;
    }

    zzabd(zzaay zzaay, Map.Entry<K, V> entry) {
        this(zzaay, entry.getKey(), entry.getValue());
        AppMethodBeat.i(40183);
        AppMethodBeat.o(40183);
    }

    private static boolean equals(Object obj, Object obj2) {
        AppMethodBeat.i(40188);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(40188);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.o(40188);
            return true;
        } else {
            AppMethodBeat.o(40188);
            return false;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzabd zzabd) {
        AppMethodBeat.i(40189);
        int compareTo = ((Comparable) getKey()).compareTo((Comparable) zzabd.getKey());
        AppMethodBeat.o(40189);
        return compareTo;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(40185);
        if (obj == this) {
            AppMethodBeat.o(40185);
            return true;
        } else if (!(obj instanceof Map.Entry)) {
            AppMethodBeat.o(40185);
            return false;
        } else {
            Map.Entry entry = (Map.Entry) obj;
            if (!equals(this.zzbue, entry.getKey()) || !equals(this.value, entry.getValue())) {
                AppMethodBeat.o(40185);
                return false;
            }
            AppMethodBeat.o(40185);
            return true;
        }
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzbue;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(40186);
        int hashCode = this.zzbue == null ? 0 : this.zzbue.hashCode();
        if (this.value != null) {
            i2 = this.value.hashCode();
        }
        int i3 = hashCode ^ i2;
        AppMethodBeat.o(40186);
        return i3;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        AppMethodBeat.i(40184);
        zzaay.zza(this.zzbuf);
        V v2 = this.value;
        this.value = v;
        AppMethodBeat.o(40184);
        return v2;
    }

    public final String toString() {
        AppMethodBeat.i(40187);
        String valueOf = String.valueOf(this.zzbue);
        String valueOf2 = String.valueOf(this.value);
        String sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
        AppMethodBeat.o(40187);
        return sb;
    }
}
