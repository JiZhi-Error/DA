package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzeq {
    final String name;
    final long zzafr;
    final long zzafs;
    final long zzaft;
    final long zzafu;
    final Long zzafv;
    final Long zzafw;
    final Boolean zzafx;
    final String zzti;

    zzeq(String str, String str2, long j2, long j3, long j4, long j5, Long l, Long l2, Boolean bool) {
        AppMethodBeat.i(1248);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkArgument(j2 >= 0);
        Preconditions.checkArgument(j3 >= 0);
        Preconditions.checkArgument(j5 >= 0);
        this.zzti = str;
        this.name = str2;
        this.zzafr = j2;
        this.zzafs = j3;
        this.zzaft = j4;
        this.zzafu = j5;
        this.zzafv = l;
        this.zzafw = l2;
        this.zzafx = bool;
        AppMethodBeat.o(1248);
    }

    /* access modifiers changed from: package-private */
    public final zzeq zza(Long l, Long l2, Boolean bool) {
        AppMethodBeat.i(1252);
        zzeq zzeq = new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, this.zzaft, this.zzafu, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
        AppMethodBeat.o(1252);
        return zzeq;
    }

    /* access modifiers changed from: package-private */
    public final zzeq zzac(long j2) {
        AppMethodBeat.i(1250);
        zzeq zzeq = new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, j2, this.zzafu, this.zzafv, this.zzafw, this.zzafx);
        AppMethodBeat.o(1250);
        return zzeq;
    }

    /* access modifiers changed from: package-private */
    public final zzeq zzad(long j2) {
        AppMethodBeat.i(1251);
        zzeq zzeq = new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, this.zzaft, j2, this.zzafv, this.zzafw, this.zzafx);
        AppMethodBeat.o(1251);
        return zzeq;
    }

    /* access modifiers changed from: package-private */
    public final zzeq zzie() {
        AppMethodBeat.i(1249);
        zzeq zzeq = new zzeq(this.zzti, this.name, this.zzafr + 1, this.zzafs + 1, this.zzaft, this.zzafu, this.zzafv, this.zzafw, this.zzafx);
        AppMethodBeat.o(1249);
        return zzeq;
    }
}
