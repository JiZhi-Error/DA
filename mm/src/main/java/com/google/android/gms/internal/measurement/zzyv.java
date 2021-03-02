package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzyv {
    private static final Class<?> zzbqv = zzfh("libcore.io.Memory");
    private static final boolean zzbqw = (zzfh("org.robolectric.Robolectric") != null);

    static {
        AppMethodBeat.i(40337);
        AppMethodBeat.o(40337);
    }

    private static <T> Class<T> zzfh(String str) {
        AppMethodBeat.i(40336);
        try {
            Class<T> cls = (Class<T>) Class.forName(str);
            AppMethodBeat.o(40336);
            return cls;
        } catch (Throwable th) {
            AppMethodBeat.o(40336);
            return null;
        }
    }

    static boolean zzsv() {
        return zzbqv != null && !zzbqw;
    }

    static Class<?> zzsw() {
        return zzbqv;
    }
}
