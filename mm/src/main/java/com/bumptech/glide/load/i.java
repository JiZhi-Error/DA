package com.bumptech.glide.load;

import android.support.v4.e.a;
import com.bumptech.glide.g.b;
import com.bumptech.glide.load.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class i implements g {
    public final a<h<?>, Object> aFa = new b();

    public i() {
        AppMethodBeat.i(76856);
        AppMethodBeat.o(76856);
    }

    public final void a(i iVar) {
        AppMethodBeat.i(76857);
        this.aFa.a(iVar.aFa);
        AppMethodBeat.o(76857);
    }

    public final <T> T a(h<T> hVar) {
        AppMethodBeat.i(76858);
        if (this.aFa.containsKey(hVar)) {
            T t = (T) this.aFa.get(hVar);
            AppMethodBeat.o(76858);
            return t;
        }
        T t2 = hVar.aEX;
        AppMethodBeat.o(76858);
        return t2;
    }

    @Override // com.bumptech.glide.load.g
    public final boolean equals(Object obj) {
        AppMethodBeat.i(76859);
        if (obj instanceof i) {
            boolean equals = this.aFa.equals(((i) obj).aFa);
            AppMethodBeat.o(76859);
            return equals;
        }
        AppMethodBeat.o(76859);
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public final int hashCode() {
        AppMethodBeat.i(76860);
        int hashCode = this.aFa.hashCode();
        AppMethodBeat.o(76860);
        return hashCode;
    }

    @Override // com.bumptech.glide.load.g
    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(76861);
        for (int i2 = 0; i2 < this.aFa.size(); i2++) {
            h<?> keyAt = this.aFa.keyAt(i2);
            Object valueAt = this.aFa.valueAt(i2);
            h.a<T> aVar = keyAt.aEY;
            if (keyAt.aEZ == null) {
                keyAt.aEZ = keyAt.key.getBytes(g.aEV);
            }
            aVar.a(keyAt.aEZ, valueAt, messageDigest);
        }
        AppMethodBeat.o(76861);
    }

    public final String toString() {
        AppMethodBeat.i(76862);
        String str = "Options{values=" + this.aFa + '}';
        AppMethodBeat.o(76862);
        return str;
    }
}
