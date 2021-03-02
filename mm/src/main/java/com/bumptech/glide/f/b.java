package com.bumptech.glide.f;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class b implements g {
    private final Object object;

    public b(Object obj) {
        AppMethodBeat.i(77706);
        this.object = j.checkNotNull(obj, "Argument must not be null");
        AppMethodBeat.o(77706);
    }

    public final String toString() {
        AppMethodBeat.i(77707);
        String str = "ObjectKey{object=" + this.object + '}';
        AppMethodBeat.o(77707);
        return str;
    }

    @Override // com.bumptech.glide.load.g
    public final boolean equals(Object obj) {
        AppMethodBeat.i(77708);
        if (obj instanceof b) {
            boolean equals = this.object.equals(((b) obj).object);
            AppMethodBeat.o(77708);
            return equals;
        }
        AppMethodBeat.o(77708);
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public final int hashCode() {
        AppMethodBeat.i(77709);
        int hashCode = this.object.hashCode();
        AppMethodBeat.o(77709);
        return hashCode;
    }

    @Override // com.bumptech.glide.load.g
    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(77710);
        messageDigest.update(this.object.toString().getBytes(aEV));
        AppMethodBeat.o(77710);
    }
}
