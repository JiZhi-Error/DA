package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkm extends zzaby<zzkm> {
    private static volatile zzkm[] zzasv;
    public Integer zzarl = null;
    public zzkr zzasw = null;
    public zzkr zzasx = null;
    public Boolean zzasy = null;

    public zzkm() {
        AppMethodBeat.i(2224);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2224);
    }

    public static zzkm[] zzlk() {
        if (zzasv == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasv == null) {
                    zzasv = new zzkm[0];
                }
            }
        }
        return zzasv;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2225);
        if (obj == this) {
            AppMethodBeat.o(2225);
            return true;
        } else if (!(obj instanceof zzkm)) {
            AppMethodBeat.o(2225);
            return false;
        } else {
            zzkm zzkm = (zzkm) obj;
            if (this.zzarl == null) {
                if (zzkm.zzarl != null) {
                    AppMethodBeat.o(2225);
                    return false;
                }
            } else if (!this.zzarl.equals(zzkm.zzarl)) {
                AppMethodBeat.o(2225);
                return false;
            }
            if (this.zzasw == null) {
                if (zzkm.zzasw != null) {
                    AppMethodBeat.o(2225);
                    return false;
                }
            } else if (!this.zzasw.equals(zzkm.zzasw)) {
                AppMethodBeat.o(2225);
                return false;
            }
            if (this.zzasx == null) {
                if (zzkm.zzasx != null) {
                    AppMethodBeat.o(2225);
                    return false;
                }
            } else if (!this.zzasx.equals(zzkm.zzasx)) {
                AppMethodBeat.o(2225);
                return false;
            }
            if (this.zzasy == null) {
                if (zzkm.zzasy != null) {
                    AppMethodBeat.o(2225);
                    return false;
                }
            } else if (!this.zzasy.equals(zzkm.zzasy)) {
                AppMethodBeat.o(2225);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkm.zzbww);
                AppMethodBeat.o(2225);
                return equals;
            } else if (zzkm.zzbww == null || zzkm.zzbww.isEmpty()) {
                AppMethodBeat.o(2225);
                return true;
            } else {
                AppMethodBeat.o(2225);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2226);
        int hashCode = (this.zzarl == null ? 0 : this.zzarl.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31);
        zzkr zzkr = this.zzasw;
        int i3 = hashCode * 31;
        int hashCode2 = zzkr == null ? 0 : zzkr.hashCode();
        zzkr zzkr2 = this.zzasx;
        int hashCode3 = ((this.zzasy == null ? 0 : this.zzasy.hashCode()) + (((zzkr2 == null ? 0 : zzkr2.hashCode()) + ((hashCode2 + i3) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i4 = hashCode3 + i2;
        AppMethodBeat.o(2226);
        return i4;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2228);
        int zza = super.zza();
        if (this.zzarl != null) {
            zza += zzabw.zzf(1, this.zzarl.intValue());
        }
        if (this.zzasw != null) {
            zza += zzabw.zzb(2, this.zzasw);
        }
        if (this.zzasx != null) {
            zza += zzabw.zzb(3, this.zzasx);
        }
        if (this.zzasy != null) {
            this.zzasy.booleanValue();
            zza += zzabw.zzaq(4) + 1;
        }
        AppMethodBeat.o(2228);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2227);
        if (this.zzarl != null) {
            zzabw.zze(1, this.zzarl.intValue());
        }
        if (this.zzasw != null) {
            zzabw.zza(2, this.zzasw);
        }
        if (this.zzasx != null) {
            zzabw.zza(3, this.zzasx);
        }
        if (this.zzasy != null) {
            zzabw.zza(4, this.zzasy.booleanValue());
        }
        super.zza(zzabw);
        AppMethodBeat.o(2227);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2229);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2229);
                    break;
                case 8:
                    this.zzarl = Integer.valueOf(zzabv.zzuy());
                    break;
                case 18:
                    if (this.zzasw == null) {
                        this.zzasw = new zzkr();
                    }
                    zzabv.zza(this.zzasw);
                    break;
                case 26:
                    if (this.zzasx == null) {
                        this.zzasx = new zzkr();
                    }
                    zzabv.zza(this.zzasx);
                    break;
                case 32:
                    this.zzasy = Boolean.valueOf(zzabv.zzux());
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2229);
                        break;
                    }
            }
        }
        return this;
    }
}
