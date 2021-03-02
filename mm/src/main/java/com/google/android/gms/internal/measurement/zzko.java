package com.google.android.gms.internal.measurement;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzko extends zzaby<zzko> {
    private static volatile zzko[] zzatd;
    public String name = null;
    public String zzajf = null;
    private Float zzarb = null;
    public Double zzarc = null;
    public Long zzate = null;

    public zzko() {
        AppMethodBeat.i(2236);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2236);
    }

    public static zzko[] zzlm() {
        if (zzatd == null) {
            synchronized (zzacc.zzbxg) {
                if (zzatd == null) {
                    zzatd = new zzko[0];
                }
            }
        }
        return zzatd;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2237);
        if (obj == this) {
            AppMethodBeat.o(2237);
            return true;
        } else if (!(obj instanceof zzko)) {
            AppMethodBeat.o(2237);
            return false;
        } else {
            zzko zzko = (zzko) obj;
            if (this.name == null) {
                if (zzko.name != null) {
                    AppMethodBeat.o(2237);
                    return false;
                }
            } else if (!this.name.equals(zzko.name)) {
                AppMethodBeat.o(2237);
                return false;
            }
            if (this.zzajf == null) {
                if (zzko.zzajf != null) {
                    AppMethodBeat.o(2237);
                    return false;
                }
            } else if (!this.zzajf.equals(zzko.zzajf)) {
                AppMethodBeat.o(2237);
                return false;
            }
            if (this.zzate == null) {
                if (zzko.zzate != null) {
                    AppMethodBeat.o(2237);
                    return false;
                }
            } else if (!this.zzate.equals(zzko.zzate)) {
                AppMethodBeat.o(2237);
                return false;
            }
            if (this.zzarb == null) {
                if (zzko.zzarb != null) {
                    AppMethodBeat.o(2237);
                    return false;
                }
            } else if (!this.zzarb.equals(zzko.zzarb)) {
                AppMethodBeat.o(2237);
                return false;
            }
            if (this.zzarc == null) {
                if (zzko.zzarc != null) {
                    AppMethodBeat.o(2237);
                    return false;
                }
            } else if (!this.zzarc.equals(zzko.zzarc)) {
                AppMethodBeat.o(2237);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzko.zzbww);
                AppMethodBeat.o(2237);
                return equals;
            } else if (zzko.zzbww == null || zzko.zzbww.isEmpty()) {
                AppMethodBeat.o(2237);
                return true;
            } else {
                AppMethodBeat.o(2237);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2238);
        int hashCode = ((this.zzarc == null ? 0 : this.zzarc.hashCode()) + (((this.zzarb == null ? 0 : this.zzarb.hashCode()) + (((this.zzate == null ? 0 : this.zzate.hashCode()) + (((this.zzajf == null ? 0 : this.zzajf.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(2238);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2240);
        int zza = super.zza();
        if (this.name != null) {
            zza += zzabw.zzc(1, this.name);
        }
        if (this.zzajf != null) {
            zza += zzabw.zzc(2, this.zzajf);
        }
        if (this.zzate != null) {
            zza += zzabw.zzc(3, this.zzate.longValue());
        }
        if (this.zzarb != null) {
            this.zzarb.floatValue();
            zza += zzabw.zzaq(4) + 4;
        }
        if (this.zzarc != null) {
            this.zzarc.doubleValue();
            zza += zzabw.zzaq(5) + 8;
        }
        AppMethodBeat.o(2240);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2239);
        if (this.name != null) {
            zzabw.zzb(1, this.name);
        }
        if (this.zzajf != null) {
            zzabw.zzb(2, this.zzajf);
        }
        if (this.zzate != null) {
            zzabw.zzb(3, this.zzate.longValue());
        }
        if (this.zzarb != null) {
            zzabw.zza(4, this.zzarb.floatValue());
        }
        if (this.zzarc != null) {
            zzabw.zza(5, this.zzarc.doubleValue());
        }
        super.zza(zzabw);
        AppMethodBeat.o(2239);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2241);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2241);
                    break;
                case 10:
                    this.name = zzabv.readString();
                    break;
                case 18:
                    this.zzajf = zzabv.readString();
                    break;
                case 24:
                    this.zzate = Long.valueOf(zzabv.zzuz());
                    break;
                case 37:
                    this.zzarb = Float.valueOf(Float.intBitsToFloat(zzabv.zzva()));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    this.zzarc = Double.valueOf(Double.longBitsToDouble(zzabv.zzvb()));
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2241);
                        break;
                    }
            }
        }
        return this;
    }
}
