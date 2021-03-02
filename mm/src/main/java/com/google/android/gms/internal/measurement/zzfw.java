package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfw {
    private String value;
    private boolean zzakp;
    private final /* synthetic */ zzfr zzakq;
    private final String zzakv = null;
    private final String zzny;

    public zzfw(zzfr zzfr, String str, String str2) {
        this.zzakq = zzfr;
        AppMethodBeat.i(1494);
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
        AppMethodBeat.o(1494);
    }

    public final void zzbs(String str) {
        AppMethodBeat.i(1496);
        if (zzka.zzs(str, this.value)) {
            AppMethodBeat.o(1496);
            return;
        }
        SharedPreferences.Editor edit = zzfr.zza(this.zzakq).edit();
        edit.putString(this.zzny, str);
        edit.apply();
        this.value = str;
        AppMethodBeat.o(1496);
    }

    public final String zzjg() {
        AppMethodBeat.i(1495);
        if (!this.zzakp) {
            this.zzakp = true;
            this.value = zzfr.zza(this.zzakq).getString(this.zzny, null);
        }
        String str = this.value;
        AppMethodBeat.o(1495);
        return str;
    }
}
