package com.bumptech.glide.f;

import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class a implements g {
    private static final a aNJ = new a();

    static {
        AppMethodBeat.i(77705);
        AppMethodBeat.o(77705);
    }

    public static a qq() {
        return aNJ;
    }

    private a() {
    }

    public final String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.g
    public final void a(MessageDigest messageDigest) {
    }
}
