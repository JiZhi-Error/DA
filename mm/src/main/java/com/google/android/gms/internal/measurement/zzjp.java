package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class zzjp extends zzhg implements zzec {
    protected final zzjr zzajp;

    zzjp(zzjr zzjr) {
        super(zzjr.zzla());
        AppMethodBeat.i(1951);
        Preconditions.checkNotNull(zzjr);
        this.zzajp = zzjr;
        AppMethodBeat.o(1951);
    }

    public zzeb zziw() {
        AppMethodBeat.i(1953);
        zzeb zziw = this.zzajp.zziw();
        AppMethodBeat.o(1953);
        return zziw;
    }

    public zzei zzix() {
        AppMethodBeat.i(1952);
        zzei zzix = this.zzajp.zzix();
        AppMethodBeat.o(1952);
        return zzix;
    }
}
