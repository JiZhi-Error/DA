package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzabk {
    private static final zzabk zzbuj = new zzabk(0, new int[0], new Object[0], false);
    private int count;
    private int zzbrz;
    private int[] zzbuk;
    private Object[] zzbul;
    private boolean zzbum;

    static {
        AppMethodBeat.i(40204);
        AppMethodBeat.o(40204);
    }

    private zzabk() {
        this(0, new int[8], new Object[8], true);
        AppMethodBeat.i(40203);
        AppMethodBeat.o(40203);
    }

    private zzabk(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.zzbrz = -1;
        this.count = 0;
        this.zzbuk = iArr;
        this.zzbul = objArr;
        this.zzbum = z;
    }

    public static zzabk zzuq() {
        return zzbuj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj instanceof zzabk;
    }

    public final int hashCode() {
        return 506991;
    }
}
