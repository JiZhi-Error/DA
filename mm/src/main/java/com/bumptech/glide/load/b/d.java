package com.bumptech.glide.load.b;

import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

final class d implements g {
    private final g aFO;
    private final g aFT;

    d(g gVar, g gVar2) {
        this.aFO = gVar;
        this.aFT = gVar2;
    }

    @Override // com.bumptech.glide.load.g
    public final boolean equals(Object obj) {
        AppMethodBeat.i(76927);
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (!this.aFO.equals(dVar.aFO) || !this.aFT.equals(dVar.aFT)) {
                AppMethodBeat.o(76927);
                return false;
            }
            AppMethodBeat.o(76927);
            return true;
        }
        AppMethodBeat.o(76927);
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public final int hashCode() {
        AppMethodBeat.i(76928);
        int hashCode = (this.aFO.hashCode() * 31) + this.aFT.hashCode();
        AppMethodBeat.o(76928);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(76929);
        String str = "DataCacheKey{sourceKey=" + this.aFO + ", signature=" + this.aFT + '}';
        AppMethodBeat.o(76929);
        return str;
    }

    @Override // com.bumptech.glide.load.g
    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(76930);
        this.aFO.a(messageDigest);
        this.aFT.a(messageDigest);
        AppMethodBeat.o(76930);
    }
}
