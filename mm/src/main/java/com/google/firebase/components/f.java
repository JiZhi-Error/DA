package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class f {
    final Class<?> bKM;
    final int bKN = 1;
    private final int bKO = 0;

    private f(Class<?> cls) {
        AppMethodBeat.i(4077);
        this.bKM = (Class) r.zza(cls, "Null dependency interface.");
        AppMethodBeat.o(4077);
    }

    @KeepForSdk
    public static f B(Class<?> cls) {
        AppMethodBeat.i(4078);
        f fVar = new f(cls);
        AppMethodBeat.o(4078);
        return fVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.bKM == fVar.bKM && this.bKN == fVar.bKN && this.bKO == fVar.bKO;
    }

    public final int hashCode() {
        AppMethodBeat.i(4079);
        int hashCode = ((((this.bKM.hashCode() ^ 1000003) * 1000003) ^ this.bKN) * 1000003) ^ this.bKO;
        AppMethodBeat.o(4079);
        return hashCode;
    }

    public final String toString() {
        boolean z = true;
        AppMethodBeat.i(4080);
        StringBuilder append = new StringBuilder("Dependency{interface=").append(this.bKM).append(", required=").append(this.bKN == 1).append(", direct=");
        if (this.bKO != 0) {
            z = false;
        }
        String sb = append.append(z).append("}").toString();
        AppMethodBeat.o(4080);
        return sb;
    }

    public final boolean ya() {
        return this.bKO == 0;
    }
}
