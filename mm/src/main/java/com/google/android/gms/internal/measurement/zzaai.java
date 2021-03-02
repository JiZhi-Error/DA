package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaai {
    private static final zzaag zzbtg = zztv();
    private static final zzaag zzbth = new zzaah();

    static {
        AppMethodBeat.i(40129);
        AppMethodBeat.o(40129);
    }

    static zzaag zztt() {
        return zzbtg;
    }

    static zzaag zztu() {
        return zzbth;
    }

    private static zzaag zztv() {
        AppMethodBeat.i(40128);
        try {
            zzaag zzaag = (zzaag) Class.forName("com.google.a.aq").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.o(40128);
            return zzaag;
        } catch (Exception e2) {
            AppMethodBeat.o(40128);
            return null;
        }
    }
}
