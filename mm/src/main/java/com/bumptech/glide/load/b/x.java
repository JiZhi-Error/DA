package com.bumptech.glide.load.b;

import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class x implements g {
    private static final com.bumptech.glide.g.g<Class<?>, byte[]> aIb = new com.bumptech.glide.g.g<>(50);
    private final b aCo;
    private final g aFO;
    private final g aFT;
    private final i aFV;
    private final Class<?> aIc;
    private final l<?> aId;
    private final int height;
    private final int width;

    static {
        AppMethodBeat.i(77055);
        AppMethodBeat.o(77055);
    }

    x(b bVar, g gVar, g gVar2, int i2, int i3, l<?> lVar, Class<?> cls, i iVar) {
        this.aCo = bVar;
        this.aFO = gVar;
        this.aFT = gVar2;
        this.width = i2;
        this.height = i3;
        this.aId = lVar;
        this.aIc = cls;
        this.aFV = iVar;
    }

    @Override // com.bumptech.glide.load.g
    public final boolean equals(Object obj) {
        AppMethodBeat.i(77051);
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.height != xVar.height || this.width != xVar.width || !k.h(this.aId, xVar.aId) || !this.aIc.equals(xVar.aIc) || !this.aFO.equals(xVar.aFO) || !this.aFT.equals(xVar.aFT) || !this.aFV.equals(xVar.aFV)) {
                AppMethodBeat.o(77051);
                return false;
            }
            AppMethodBeat.o(77051);
            return true;
        }
        AppMethodBeat.o(77051);
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public final int hashCode() {
        AppMethodBeat.i(77052);
        int hashCode = (((((this.aFO.hashCode() * 31) + this.aFT.hashCode()) * 31) + this.width) * 31) + this.height;
        if (this.aId != null) {
            hashCode = (hashCode * 31) + this.aId.hashCode();
        }
        int hashCode2 = (((hashCode * 31) + this.aIc.hashCode()) * 31) + this.aFV.hashCode();
        AppMethodBeat.o(77052);
        return hashCode2;
    }

    @Override // com.bumptech.glide.load.g
    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(77053);
        byte[] bArr = (byte[]) this.aCo.o(byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.width).putInt(this.height).array();
        this.aFT.a(messageDigest);
        this.aFO.a(messageDigest);
        messageDigest.update(bArr);
        if (this.aId != null) {
            this.aId.a(messageDigest);
        }
        this.aFV.a(messageDigest);
        byte[] bArr2 = aIb.get(this.aIc);
        if (bArr2 == null) {
            bArr2 = this.aIc.getName().getBytes(aEV);
            aIb.put(this.aIc, bArr2);
        }
        messageDigest.update(bArr2);
        this.aCo.put(bArr);
        AppMethodBeat.o(77053);
    }

    public final String toString() {
        AppMethodBeat.i(77054);
        String str = "ResourceCacheKey{sourceKey=" + this.aFO + ", signature=" + this.aFT + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.aIc + ", transformation='" + this.aId + '\'' + ", options=" + this.aFV + '}';
        AppMethodBeat.o(77054);
        return str;
    }
}
