package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;

/* access modifiers changed from: package-private */
public final class ag {
    final KeyPair bMC;
    final long bMD;

    @VisibleForTesting
    ag(KeyPair keyPair, long j2) {
        this.bMC = keyPair;
        this.bMD = j2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(4249);
        if (!(obj instanceof ag)) {
            AppMethodBeat.o(4249);
            return false;
        }
        ag agVar = (ag) obj;
        if (this.bMD != agVar.bMD || !this.bMC.getPublic().equals(agVar.bMC.getPublic()) || !this.bMC.getPrivate().equals(agVar.bMC.getPrivate())) {
            AppMethodBeat.o(4249);
            return false;
        }
        AppMethodBeat.o(4249);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(4250);
        int hashCode = Objects.hashCode(this.bMC.getPublic(), this.bMC.getPrivate(), Long.valueOf(this.bMD));
        AppMethodBeat.o(4250);
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public final String yv() {
        AppMethodBeat.i(4252);
        String encodeToString = Base64.encodeToString(this.bMC.getPrivate().getEncoded(), 11);
        AppMethodBeat.o(4252);
        return encodeToString;
    }

    /* access modifiers changed from: package-private */
    public final String zzq() {
        AppMethodBeat.i(4251);
        String encodeToString = Base64.encodeToString(this.bMC.getPublic().getEncoded(), 11);
        AppMethodBeat.o(4251);
        return encodeToString;
    }
}
