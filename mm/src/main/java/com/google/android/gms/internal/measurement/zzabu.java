package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum zzabu {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzyw.zzbqx),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzbwn;

    static {
        AppMethodBeat.i(40220);
        AppMethodBeat.o(40220);
    }

    private zzabu(Object obj) {
        this.zzbwn = obj;
    }
}
