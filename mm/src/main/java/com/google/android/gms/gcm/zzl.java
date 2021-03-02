package com.google.android.gms.gcm;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;

public final class zzl {
    public static final zzl zzao = new zzl(0, 30, LocalCache.TIME_HOUR);
    private static final zzl zzap = new zzl(1, 30, LocalCache.TIME_HOUR);
    private final int zzaq;
    private final int zzar = 30;
    private final int zzas = LocalCache.TIME_HOUR;

    static {
        AppMethodBeat.i(3712);
        AppMethodBeat.o(3712);
    }

    private zzl(int i2, int i3, int i4) {
        this.zzaq = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzl)) {
            return false;
        }
        zzl zzl = (zzl) obj;
        return zzl.zzaq == this.zzaq && zzl.zzar == this.zzar && zzl.zzas == this.zzas;
    }

    public final int hashCode() {
        return (((((this.zzaq + 1) ^ 1000003) * 1000003) ^ this.zzar) * 1000003) ^ this.zzas;
    }

    public final String toString() {
        AppMethodBeat.i(3711);
        int i2 = this.zzaq;
        int i3 = this.zzar;
        String sb = new StringBuilder(74).append("policy=").append(i2).append(" initial_backoff=").append(i3).append(" maximum_backoff=").append(this.zzas).toString();
        AppMethodBeat.o(3711);
        return sb;
    }

    public final Bundle zzf(Bundle bundle) {
        AppMethodBeat.i(3710);
        bundle.putInt("retry_policy", this.zzaq);
        bundle.putInt("initial_backoff_seconds", this.zzar);
        bundle.putInt("maximum_backoff_seconds", this.zzas);
        AppMethodBeat.o(3710);
        return bundle;
    }

    public final int zzh() {
        return this.zzaq;
    }

    public final int zzi() {
        return this.zzar;
    }

    public final int zzj() {
        return this.zzas;
    }
}
