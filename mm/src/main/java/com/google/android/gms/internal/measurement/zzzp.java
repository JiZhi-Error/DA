package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzzp implements zzaak {
    private static final zzzp zzbrx = new zzzp();

    static {
        AppMethodBeat.i(40374);
        AppMethodBeat.o(40374);
    }

    private zzzp() {
    }

    public static zzzp zztl() {
        return zzbrx;
    }

    @Override // com.google.android.gms.internal.measurement.zzaak
    public final boolean zzd(Class<?> cls) {
        AppMethodBeat.i(40372);
        boolean isAssignableFrom = zzzq.class.isAssignableFrom(cls);
        AppMethodBeat.o(40372);
        return isAssignableFrom;
    }

    @Override // com.google.android.gms.internal.measurement.zzaak
    public final zzaaj zze(Class<?> cls) {
        AppMethodBeat.i(40373);
        if (!zzzq.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
            AppMethodBeat.o(40373);
            throw illegalArgumentException;
        }
        try {
            zzaaj zzaaj = (zzaaj) zzzq.zzf(cls.asSubclass(zzzq.class)).zza(3, (Object) null, (Object) null);
            AppMethodBeat.o(40373);
            return zzaaj;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(cls.getName());
            RuntimeException runtimeException = new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e2);
            AppMethodBeat.o(40373);
            throw runtimeException;
        }
    }
}
