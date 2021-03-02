package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaas {
    private static final zzaaq zzbto = zzuc();
    private static final zzaaq zzbtp = new zzaar();

    static {
        AppMethodBeat.i(40143);
        AppMethodBeat.o(40143);
    }

    static zzaaq zzua() {
        return zzbto;
    }

    static zzaaq zzub() {
        return zzbtp;
    }

    private static zzaaq zzuc() {
        AppMethodBeat.i(40142);
        try {
            zzaaq zzaaq = (zzaaq) Class.forName("com.google.a.bf").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.o(40142);
            return zzaaq;
        } catch (Exception e2) {
            AppMethodBeat.o(40142);
            return null;
        }
    }
}
