package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaap<T> implements zzaav<T> {
    private final zzaal zzbtk;
    private final zzabj<?, ?> zzbtl;
    private final boolean zzbtm;
    private final zzzj<?> zzbtn;

    private zzaap(zzabj<?, ?> zzabj, zzzj<?> zzzj, zzaal zzaal) {
        AppMethodBeat.i(40138);
        this.zzbtl = zzabj;
        this.zzbtm = zzzj.zza(zzaal);
        this.zzbtn = zzzj;
        this.zzbtk = zzaal;
        AppMethodBeat.o(40138);
    }

    static <T> zzaap<T> zza(zzabj<?, ?> zzabj, zzzj<?> zzzj, zzaal zzaal) {
        AppMethodBeat.i(40139);
        zzaap<T> zzaap = new zzaap<>(zzabj, zzzj, zzaal);
        AppMethodBeat.o(40139);
        return zzaap;
    }

    @Override // com.google.android.gms.internal.measurement.zzaav
    public final boolean equals(T t, T t2) {
        AppMethodBeat.i(40140);
        if (!this.zzbtl.zzu(t).equals(this.zzbtl.zzu(t2))) {
            AppMethodBeat.o(40140);
            return false;
        } else if (this.zzbtm) {
            boolean equals = this.zzbtn.zzs(t).equals(this.zzbtn.zzs(t2));
            AppMethodBeat.o(40140);
            return equals;
        } else {
            AppMethodBeat.o(40140);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaav
    public final int hashCode(T t) {
        AppMethodBeat.i(40141);
        int hashCode = this.zzbtl.zzu(t).hashCode();
        if (this.zzbtm) {
            hashCode = (hashCode * 53) + this.zzbtn.zzs(t).hashCode();
        }
        AppMethodBeat.o(40141);
        return hashCode;
    }
}
