package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzzh {
    private static final Class<?> zzbrl = zztb();

    static {
        AppMethodBeat.i(40353);
        AppMethodBeat.o(40353);
    }

    private static final zzzi zzfj(String str) {
        AppMethodBeat.i(40352);
        zzzi zzzi = (zzzi) zzbrl.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        AppMethodBeat.o(40352);
        return zzzi;
    }

    private static Class<?> zztb() {
        AppMethodBeat.i(40350);
        try {
            Class<?> cls = Class.forName("com.google.a.p");
            AppMethodBeat.o(40350);
            return cls;
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.o(40350);
            return null;
        }
    }

    public static zzzi zztc() {
        AppMethodBeat.i(40351);
        if (zzbrl != null) {
            try {
                zzzi zzfj = zzfj("getEmptyRegistry");
                AppMethodBeat.o(40351);
                return zzfj;
            } catch (Exception e2) {
            }
        }
        zzzi zzzi = zzzi.zzbro;
        AppMethodBeat.o(40351);
        return zzzi;
    }
}
