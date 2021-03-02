package com.bumptech.glide.load.b;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class n implements g {
    private final Class<?> aDd;
    private final Object aDf;
    private final g aFT;
    private final i aFV;
    private final Class<?> aFX;
    private final Map<Class<?>, l<?>> aFZ;
    private int aHK;
    private final int height;
    private final int width;

    n(Object obj, g gVar, int i2, int i3, Map<Class<?>, l<?>> map, Class<?> cls, Class<?> cls2, i iVar) {
        AppMethodBeat.i(77001);
        this.aDf = j.checkNotNull(obj, "Argument must not be null");
        this.aFT = (g) j.checkNotNull(gVar, "Signature must not be null");
        this.width = i2;
        this.height = i3;
        this.aFZ = (Map) j.checkNotNull(map, "Argument must not be null");
        this.aFX = (Class) j.checkNotNull(cls, "Resource class must not be null");
        this.aDd = (Class) j.checkNotNull(cls2, "Transcode class must not be null");
        this.aFV = (i) j.checkNotNull(iVar, "Argument must not be null");
        AppMethodBeat.o(77001);
    }

    @Override // com.bumptech.glide.load.g
    public final boolean equals(Object obj) {
        AppMethodBeat.i(77002);
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (!this.aDf.equals(nVar.aDf) || !this.aFT.equals(nVar.aFT) || this.height != nVar.height || this.width != nVar.width || !this.aFZ.equals(nVar.aFZ) || !this.aFX.equals(nVar.aFX) || !this.aDd.equals(nVar.aDd) || !this.aFV.equals(nVar.aFV)) {
                AppMethodBeat.o(77002);
                return false;
            }
            AppMethodBeat.o(77002);
            return true;
        }
        AppMethodBeat.o(77002);
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public final int hashCode() {
        AppMethodBeat.i(77003);
        if (this.aHK == 0) {
            this.aHK = this.aDf.hashCode();
            this.aHK = (this.aHK * 31) + this.aFT.hashCode();
            this.aHK = (this.aHK * 31) + this.width;
            this.aHK = (this.aHK * 31) + this.height;
            this.aHK = (this.aHK * 31) + this.aFZ.hashCode();
            this.aHK = (this.aHK * 31) + this.aFX.hashCode();
            this.aHK = (this.aHK * 31) + this.aDd.hashCode();
            this.aHK = (this.aHK * 31) + this.aFV.hashCode();
        }
        int i2 = this.aHK;
        AppMethodBeat.o(77003);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(77004);
        String str = "EngineKey{model=" + this.aDf + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.aFX + ", transcodeClass=" + this.aDd + ", signature=" + this.aFT + ", hashCode=" + this.aHK + ", transformations=" + this.aFZ + ", options=" + this.aFV + '}';
        AppMethodBeat.o(77004);
        return str;
    }

    @Override // com.bumptech.glide.load.g
    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(77005);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(77005);
        throw unsupportedOperationException;
    }
}
