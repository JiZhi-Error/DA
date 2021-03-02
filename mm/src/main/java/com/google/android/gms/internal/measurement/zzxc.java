package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzxc {
    private final String zzbnr;
    private final Uri zzbns;
    private final String zzbnt;
    private final String zzbnu;
    private final boolean zzbnv;
    private final boolean zzbnw;

    public zzxc(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    private zzxc(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
        this.zzbnr = null;
        this.zzbns = uri;
        this.zzbnt = str2;
        this.zzbnu = str3;
        this.zzbnv = false;
        this.zzbnw = false;
    }

    public final zzws<Double> zzb(String str, double d2) {
        AppMethodBeat.i(2297);
        zzws<Double> zzb = zzws.zzb(this, str, d2);
        AppMethodBeat.o(2297);
        return zzb;
    }

    public final zzws<Integer> zzd(String str, int i2) {
        AppMethodBeat.i(2296);
        zzws<Integer> zzb = zzws.zzb(this, str, i2);
        AppMethodBeat.o(2296);
        return zzb;
    }

    public final zzws<Long> zze(String str, long j2) {
        AppMethodBeat.i(2294);
        zzws<Long> zzb = zzws.zzb(this, str, j2);
        AppMethodBeat.o(2294);
        return zzb;
    }

    public final zzws<Boolean> zzf(String str, boolean z) {
        AppMethodBeat.i(2295);
        zzws<Boolean> zzb = zzws.zzb(this, str, z);
        AppMethodBeat.o(2295);
        return zzb;
    }

    public final zzws<String> zzv(String str, String str2) {
        AppMethodBeat.i(2298);
        zzws<String> zzb = zzws.zzb(this, str, str2);
        AppMethodBeat.o(2298);
        return zzb;
    }
}
