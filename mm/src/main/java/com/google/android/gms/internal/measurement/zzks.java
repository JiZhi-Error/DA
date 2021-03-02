package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzks extends zzaby<zzks> {
    private static volatile zzks[] zzaum;
    public String name = null;
    public String zzajf = null;
    private Float zzarb = null;
    public Double zzarc = null;
    public Long zzate = null;
    public Long zzaun = null;

    public zzks() {
        AppMethodBeat.i(2260);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2260);
    }

    public static zzks[] zzlo() {
        if (zzaum == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaum == null) {
                    zzaum = new zzks[0];
                }
            }
        }
        return zzaum;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2261);
        if (obj == this) {
            AppMethodBeat.o(2261);
            return true;
        } else if (!(obj instanceof zzks)) {
            AppMethodBeat.o(2261);
            return false;
        } else {
            zzks zzks = (zzks) obj;
            if (this.zzaun == null) {
                if (zzks.zzaun != null) {
                    AppMethodBeat.o(2261);
                    return false;
                }
            } else if (!this.zzaun.equals(zzks.zzaun)) {
                AppMethodBeat.o(2261);
                return false;
            }
            if (this.name == null) {
                if (zzks.name != null) {
                    AppMethodBeat.o(2261);
                    return false;
                }
            } else if (!this.name.equals(zzks.name)) {
                AppMethodBeat.o(2261);
                return false;
            }
            if (this.zzajf == null) {
                if (zzks.zzajf != null) {
                    AppMethodBeat.o(2261);
                    return false;
                }
            } else if (!this.zzajf.equals(zzks.zzajf)) {
                AppMethodBeat.o(2261);
                return false;
            }
            if (this.zzate == null) {
                if (zzks.zzate != null) {
                    AppMethodBeat.o(2261);
                    return false;
                }
            } else if (!this.zzate.equals(zzks.zzate)) {
                AppMethodBeat.o(2261);
                return false;
            }
            if (this.zzarb == null) {
                if (zzks.zzarb != null) {
                    AppMethodBeat.o(2261);
                    return false;
                }
            } else if (!this.zzarb.equals(zzks.zzarb)) {
                AppMethodBeat.o(2261);
                return false;
            }
            if (this.zzarc == null) {
                if (zzks.zzarc != null) {
                    AppMethodBeat.o(2261);
                    return false;
                }
            } else if (!this.zzarc.equals(zzks.zzarc)) {
                AppMethodBeat.o(2261);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzks.zzbww);
                AppMethodBeat.o(2261);
                return equals;
            } else if (zzks.zzbww == null || zzks.zzbww.isEmpty()) {
                AppMethodBeat.o(2261);
                return true;
            } else {
                AppMethodBeat.o(2261);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2262);
        int hashCode = ((this.zzarc == null ? 0 : this.zzarc.hashCode()) + (((this.zzarb == null ? 0 : this.zzarb.hashCode()) + (((this.zzate == null ? 0 : this.zzate.hashCode()) + (((this.zzajf == null ? 0 : this.zzajf.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.zzaun == null ? 0 : this.zzaun.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(2262);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2264);
        int zza = super.zza();
        if (this.zzaun != null) {
            zza += zzabw.zzc(1, this.zzaun.longValue());
        }
        if (this.name != null) {
            zza += zzabw.zzc(2, this.name);
        }
        if (this.zzajf != null) {
            zza += zzabw.zzc(3, this.zzajf);
        }
        if (this.zzate != null) {
            zza += zzabw.zzc(4, this.zzate.longValue());
        }
        if (this.zzarb != null) {
            this.zzarb.floatValue();
            zza += zzabw.zzaq(5) + 4;
        }
        if (this.zzarc != null) {
            this.zzarc.doubleValue();
            zza += zzabw.zzaq(6) + 8;
        }
        AppMethodBeat.o(2264);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2263);
        if (this.zzaun != null) {
            zzabw.zzb(1, this.zzaun.longValue());
        }
        if (this.name != null) {
            zzabw.zzb(2, this.name);
        }
        if (this.zzajf != null) {
            zzabw.zzb(3, this.zzajf);
        }
        if (this.zzate != null) {
            zzabw.zzb(4, this.zzate.longValue());
        }
        if (this.zzarb != null) {
            zzabw.zza(5, this.zzarb.floatValue());
        }
        if (this.zzarc != null) {
            zzabw.zza(6, this.zzarc.doubleValue());
        }
        super.zza(zzabw);
        AppMethodBeat.o(2263);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2265);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2265);
                    break;
                case 8:
                    this.zzaun = Long.valueOf(zzabv.zzuz());
                    break;
                case 18:
                    this.name = zzabv.readString();
                    break;
                case 26:
                    this.zzajf = zzabv.readString();
                    break;
                case 32:
                    this.zzate = Long.valueOf(zzabv.zzuz());
                    break;
                case 45:
                    this.zzarb = Float.valueOf(Float.intBitsToFloat(zzabv.zzva()));
                    break;
                case 49:
                    this.zzarc = Double.valueOf(Double.longBitsToDouble(zzabv.zzvb()));
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2265);
                        break;
                    }
            }
        }
        return this;
    }
}
