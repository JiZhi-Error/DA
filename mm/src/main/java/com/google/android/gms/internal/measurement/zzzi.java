package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzzi {
    private static volatile boolean zzbrm = false;
    private static final Class<?> zzbrn = zztd();
    static final zzzi zzbro = new zzzi(true);
    private final Map<Object, Object> zzbrp;

    static {
        AppMethodBeat.i(40358);
        AppMethodBeat.o(40358);
    }

    zzzi() {
        AppMethodBeat.i(40356);
        this.zzbrp = new HashMap();
        AppMethodBeat.o(40356);
    }

    private zzzi(boolean z) {
        AppMethodBeat.i(40357);
        this.zzbrp = Collections.emptyMap();
        AppMethodBeat.o(40357);
    }

    private static Class<?> zztd() {
        AppMethodBeat.i(40354);
        try {
            Class<?> cls = Class.forName("com.google.a.n");
            AppMethodBeat.o(40354);
            return cls;
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.o(40354);
            return null;
        }
    }

    public static zzzi zzte() {
        AppMethodBeat.i(40355);
        zzzi zztc = zzzh.zztc();
        AppMethodBeat.o(40355);
        return zztc;
    }
}
