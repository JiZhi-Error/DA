package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzzl {
    private static final zzzj<?> zzbrq = new zzzk();
    private static final zzzj<?> zzbrr = zztf();

    static {
        AppMethodBeat.i(40361);
        AppMethodBeat.o(40361);
    }

    private static zzzj<?> zztf() {
        AppMethodBeat.i(40359);
        try {
            zzzj<?> zzzj = (zzzj) Class.forName("com.google.a.t").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.o(40359);
            return zzzj;
        } catch (Exception e2) {
            AppMethodBeat.o(40359);
            return null;
        }
    }

    static zzzj<?> zztg() {
        return zzbrq;
    }

    static zzzj<?> zzth() {
        AppMethodBeat.i(40360);
        if (zzbrr == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Protobuf runtime is not correctly loaded.");
            AppMethodBeat.o(40360);
            throw illegalStateException;
        }
        zzzj<?> zzzj = zzbrr;
        AppMethodBeat.o(40360);
        return zzzj;
    }
}
