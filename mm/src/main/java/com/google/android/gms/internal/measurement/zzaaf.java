package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaaf implements zzaak {
    private zzaak[] zzbtf;

    zzaaf(zzaak... zzaakArr) {
        this.zzbtf = zzaakArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzaak
    public final boolean zzd(Class<?> cls) {
        AppMethodBeat.i(40126);
        for (zzaak zzaak : this.zzbtf) {
            if (zzaak.zzd(cls)) {
                AppMethodBeat.o(40126);
                return true;
            }
        }
        AppMethodBeat.o(40126);
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzaak
    public final zzaaj zze(Class<?> cls) {
        AppMethodBeat.i(40127);
        zzaak[] zzaakArr = this.zzbtf;
        for (zzaak zzaak : zzaakArr) {
            if (zzaak.zzd(cls)) {
                zzaaj zze = zzaak.zze(cls);
                AppMethodBeat.o(40127);
                return zze;
            }
        }
        String valueOf = String.valueOf(cls.getName());
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
        AppMethodBeat.o(40127);
        throw unsupportedOperationException;
    }
}
