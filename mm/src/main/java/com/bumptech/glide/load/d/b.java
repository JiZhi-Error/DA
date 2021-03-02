package com.bumptech.glide.load.d;

import android.content.Context;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class b<T> implements l<T> {
    private static final l<?> aKI = new b();

    static {
        AppMethodBeat.i(77347);
        AppMethodBeat.o(77347);
    }

    public static <T> b<T> px() {
        return (b) aKI;
    }

    private b() {
    }

    @Override // com.bumptech.glide.load.l
    public final v<T> a(Context context, v<T> vVar, int i2, int i3) {
        return vVar;
    }

    @Override // com.bumptech.glide.load.g
    public final void a(MessageDigest messageDigest) {
    }
}
