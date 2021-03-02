package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfu {
    private long value;
    private boolean zzakp;
    private final /* synthetic */ zzfr zzakq;
    private final long zzakr;
    private final String zzny;

    public zzfu(zzfr zzfr, String str, long j2) {
        this.zzakq = zzfr;
        AppMethodBeat.i(1486);
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
        this.zzakr = j2;
        AppMethodBeat.o(1486);
    }

    public final long get() {
        AppMethodBeat.i(1487);
        if (!this.zzakp) {
            this.zzakp = true;
            this.value = zzfr.zza(this.zzakq).getLong(this.zzny, this.zzakr);
        }
        long j2 = this.value;
        AppMethodBeat.o(1487);
        return j2;
    }

    public final void set(long j2) {
        AppMethodBeat.i(1488);
        SharedPreferences.Editor edit = zzfr.zza(this.zzakq).edit();
        edit.putLong(this.zzny, j2);
        edit.apply();
        this.value = j2;
        AppMethodBeat.o(1488);
    }
}
