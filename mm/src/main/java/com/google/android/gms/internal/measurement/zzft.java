package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzft {
    private boolean value;
    private final boolean zzako = true;
    private boolean zzakp;
    private final /* synthetic */ zzfr zzakq;
    private final String zzny;

    public zzft(zzfr zzfr, String str, boolean z) {
        this.zzakq = zzfr;
        AppMethodBeat.i(1483);
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
        AppMethodBeat.o(1483);
    }

    public final boolean get() {
        AppMethodBeat.i(1484);
        if (!this.zzakp) {
            this.zzakp = true;
            this.value = zzfr.zza(this.zzakq).getBoolean(this.zzny, this.zzako);
        }
        boolean z = this.value;
        AppMethodBeat.o(1484);
        return z;
    }

    public final void set(boolean z) {
        AppMethodBeat.i(1485);
        SharedPreferences.Editor edit = zzfr.zza(this.zzakq).edit();
        edit.putBoolean(this.zzny, z);
        edit.apply();
        this.value = z;
        AppMethodBeat.o(1485);
    }
}
