package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzzy {
    private static final zzzi zzbsw = zzzi.zzte();
    private zzyw zzbsx;
    private volatile zzaal zzbsy;
    private volatile zzyw zzbsz;

    static {
        AppMethodBeat.i(40392);
        AppMethodBeat.o(40392);
    }

    private final zzaal zzb(zzaal zzaal) {
        if (this.zzbsy == null) {
            synchronized (this) {
                if (this.zzbsy == null) {
                    try {
                        this.zzbsy = zzaal;
                        this.zzbsz = zzyw.zzbqx;
                    } catch (zzzt e2) {
                        this.zzbsy = zzaal;
                        this.zzbsz = zzyw.zzbqx;
                    }
                }
            }
        }
        return this.zzbsy;
    }

    private final zzyw zztp() {
        AppMethodBeat.i(40391);
        if (this.zzbsz != null) {
            zzyw zzyw = this.zzbsz;
            AppMethodBeat.o(40391);
            return zzyw;
        }
        synchronized (this) {
            try {
                if (this.zzbsz != null) {
                    return this.zzbsz;
                }
                if (this.zzbsy == null) {
                    this.zzbsz = zzyw.zzbqx;
                } else {
                    this.zzbsz = this.zzbsy.zztp();
                }
                zzyw zzyw2 = this.zzbsz;
                AppMethodBeat.o(40391);
                return zzyw2;
            } finally {
                AppMethodBeat.o(40391);
            }
        }
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(40390);
        if (this == obj) {
            AppMethodBeat.o(40390);
            return true;
        } else if (!(obj instanceof zzzy)) {
            AppMethodBeat.o(40390);
            return false;
        } else {
            zzzy zzzy = (zzzy) obj;
            zzaal zzaal = this.zzbsy;
            zzaal zzaal2 = zzzy.zzbsy;
            if (zzaal == null && zzaal2 == null) {
                boolean equals = zztp().equals(zzzy.zztp());
                AppMethodBeat.o(40390);
                return equals;
            } else if (zzaal != null && zzaal2 != null) {
                boolean equals2 = zzaal.equals(zzaal2);
                AppMethodBeat.o(40390);
                return equals2;
            } else if (zzaal != null) {
                boolean equals3 = zzaal.equals(zzzy.zzb(zzaal.zztz()));
                AppMethodBeat.o(40390);
                return equals3;
            } else {
                boolean equals4 = zzb(zzaal2.zztz()).equals(zzaal2);
                AppMethodBeat.o(40390);
                return equals4;
            }
        }
    }

    public int hashCode() {
        return 1;
    }

    public final zzaal zzc(zzaal zzaal) {
        zzaal zzaal2 = this.zzbsy;
        this.zzbsx = null;
        this.zzbsz = null;
        this.zzbsy = zzaal;
        return zzaal2;
    }
}
