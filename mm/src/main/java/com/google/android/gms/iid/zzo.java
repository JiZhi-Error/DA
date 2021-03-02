package com.google.android.gms.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;

/* access modifiers changed from: package-private */
public final class zzo {
    private final KeyPair zzbw;
    private final long zzbx;

    @VisibleForTesting
    zzo(KeyPair keyPair, long j2) {
        this.zzbw = keyPair;
        this.zzbx = j2;
    }

    static /* synthetic */ String zzd(zzo zzo) {
        AppMethodBeat.i(2550);
        String zzo2 = zzo.zzo();
        AppMethodBeat.o(2550);
        return zzo2;
    }

    static /* synthetic */ String zze(zzo zzo) {
        AppMethodBeat.i(2551);
        String zzp = zzo.zzp();
        AppMethodBeat.o(2551);
        return zzp;
    }

    private final String zzo() {
        AppMethodBeat.i(2548);
        String encodeToString = Base64.encodeToString(this.zzbw.getPublic().getEncoded(), 11);
        AppMethodBeat.o(2548);
        return encodeToString;
    }

    private final String zzp() {
        AppMethodBeat.i(2549);
        String encodeToString = Base64.encodeToString(this.zzbw.getPrivate().getEncoded(), 11);
        AppMethodBeat.o(2549);
        return encodeToString;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2546);
        if (!(obj instanceof zzo)) {
            AppMethodBeat.o(2546);
            return false;
        }
        zzo zzo = (zzo) obj;
        if (this.zzbx != zzo.zzbx || !this.zzbw.getPublic().equals(zzo.zzbw.getPublic()) || !this.zzbw.getPrivate().equals(zzo.zzbw.getPrivate())) {
            AppMethodBeat.o(2546);
            return false;
        }
        AppMethodBeat.o(2546);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final long getCreationTime() {
        return this.zzbx;
    }

    /* access modifiers changed from: package-private */
    public final KeyPair getKeyPair() {
        return this.zzbw;
    }

    public final int hashCode() {
        AppMethodBeat.i(2547);
        int hashCode = Objects.hashCode(this.zzbw.getPublic(), this.zzbw.getPrivate(), Long.valueOf(this.zzbx));
        AppMethodBeat.o(2547);
        return hashCode;
    }
}
