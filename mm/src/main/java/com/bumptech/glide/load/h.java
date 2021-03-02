package com.bumptech.glide.load;

import com.bumptech.glide.g.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class h<T> {
    private static final a<Object> aEW = new a<Object>() {
        /* class com.bumptech.glide.load.h.AnonymousClass1 */

        @Override // com.bumptech.glide.load.h.a
        public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };
    final T aEX;
    final a<T> aEY;
    volatile byte[] aEZ;
    final String key;

    public interface a<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    static {
        AppMethodBeat.i(76855);
        AppMethodBeat.o(76855);
    }

    public static <T> h<T> Q(String str) {
        AppMethodBeat.i(76848);
        h<T> hVar = new h<>(str, null, aEW);
        AppMethodBeat.o(76848);
        return hVar;
    }

    public static <T> h<T> c(String str, T t) {
        AppMethodBeat.i(76849);
        h<T> hVar = new h<>(str, t, aEW);
        AppMethodBeat.o(76849);
        return hVar;
    }

    public static <T> h<T> a(String str, T t, a<T> aVar) {
        AppMethodBeat.i(76850);
        h<T> hVar = new h<>(str, t, aVar);
        AppMethodBeat.o(76850);
        return hVar;
    }

    private h(String str, T t, a<T> aVar) {
        AppMethodBeat.i(76851);
        this.key = j.checkNotEmpty(str);
        this.aEX = t;
        this.aEY = (a) j.checkNotNull(aVar, "Argument must not be null");
        AppMethodBeat.o(76851);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(76852);
        if (obj instanceof h) {
            boolean equals = this.key.equals(((h) obj).key);
            AppMethodBeat.o(76852);
            return equals;
        }
        AppMethodBeat.o(76852);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(76853);
        int hashCode = this.key.hashCode();
        AppMethodBeat.o(76853);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(76854);
        String str = "Option{key='" + this.key + '\'' + '}';
        AppMethodBeat.o(76854);
        return str;
    }
}
