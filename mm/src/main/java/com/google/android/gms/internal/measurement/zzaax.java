package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaax {
    private static final Class<?> zzbtt = zzuh();
    private static final zzabj<?, ?> zzbtu = zzu(false);
    private static final zzabj<?, ?> zzbtv = zzu(true);
    private static final zzabj<?, ?> zzbtw = new zzabl();

    static {
        AppMethodBeat.i(40155);
        AppMethodBeat.o(40155);
    }

    public static void zzh(Class<?> cls) {
        AppMethodBeat.i(40151);
        if (zzzq.class.isAssignableFrom(cls) || zzbtt == null || zzbtt.isAssignableFrom(cls)) {
            AppMethodBeat.o(40151);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        AppMethodBeat.o(40151);
        throw illegalArgumentException;
    }

    private static zzabj<?, ?> zzu(boolean z) {
        AppMethodBeat.i(40152);
        try {
            Class<?> zzui = zzui();
            if (zzui == null) {
                AppMethodBeat.o(40152);
                return null;
            }
            zzabj<?, ?> zzabj = (zzabj) zzui.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
            AppMethodBeat.o(40152);
            return zzabj;
        } catch (Throwable th) {
            AppMethodBeat.o(40152);
            return null;
        }
    }

    public static zzabj<?, ?> zzue() {
        return zzbtu;
    }

    public static zzabj<?, ?> zzuf() {
        return zzbtv;
    }

    public static zzabj<?, ?> zzug() {
        return zzbtw;
    }

    private static Class<?> zzuh() {
        AppMethodBeat.i(40153);
        try {
            Class<?> cls = Class.forName("com.google.a.z");
            AppMethodBeat.o(40153);
            return cls;
        } catch (Throwable th) {
            AppMethodBeat.o(40153);
            return null;
        }
    }

    private static Class<?> zzui() {
        AppMethodBeat.i(40154);
        try {
            Class<?> cls = Class.forName("com.google.a.cf");
            AppMethodBeat.o(40154);
            return cls;
        } catch (Throwable th) {
            AppMethodBeat.o(40154);
            return null;
        }
    }
}
