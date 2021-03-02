package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVExporter;

@VisibleForTesting
public final class zzex<V> {
    private final zzws<V> zzaid;
    private final String zzny;

    private zzex(String str, zzws<V> zzws) {
        AppMethodBeat.i(1274);
        Preconditions.checkNotNull(zzws);
        this.zzaid = zzws;
        this.zzny = str;
        AppMethodBeat.o(1274);
    }

    static zzex<Double> zza(String str, double d2, double d3) {
        AppMethodBeat.i(1279);
        zzex<Double> zzex = new zzex<>(str, zzew.zzagc.zzb(str, -3.0d));
        AppMethodBeat.o(1279);
        return zzex;
    }

    static zzex<Long> zzb(String str, long j2, long j3) {
        AppMethodBeat.i(1277);
        zzex<Long> zzex = new zzex<>(str, zzew.zzagc.zze(str, j2));
        AppMethodBeat.o(1277);
        return zzex;
    }

    static zzex<Boolean> zzb(String str, boolean z, boolean z2) {
        AppMethodBeat.i(1275);
        zzex<Boolean> zzex = new zzex<>(str, zzew.zzagc.zzf(str, z));
        AppMethodBeat.o(1275);
        return zzex;
    }

    static zzex<Integer> zzc(String str, int i2, int i3) {
        AppMethodBeat.i(1278);
        zzex<Integer> zzex = new zzex<>(str, zzew.zzagc.zzd(str, i2));
        AppMethodBeat.o(1278);
        return zzex;
    }

    static zzex<String> zzd(String str, String str2, String str3) {
        AppMethodBeat.i(1276);
        zzex<String> zzex = new zzex<>(str, zzew.zzagc.zzv(str, str2));
        AppMethodBeat.o(1276);
        return zzex;
    }

    public final V get() {
        AppMethodBeat.i(TAVExporter.VIDEO_EXPORT_HEIGHT);
        V v = this.zzaid.get();
        AppMethodBeat.o(TAVExporter.VIDEO_EXPORT_HEIGHT);
        return v;
    }

    public final V get(V v) {
        AppMethodBeat.i(1281);
        if (v != null) {
            AppMethodBeat.o(1281);
            return v;
        }
        V v2 = this.zzaid.get();
        AppMethodBeat.o(1281);
        return v2;
    }

    public final String getKey() {
        return this.zzny;
    }
}
