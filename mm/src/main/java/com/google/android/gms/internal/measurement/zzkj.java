package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkj extends zzaby<zzkj> {
    private static volatile zzkj[] zzasl;
    public String name = null;
    public Boolean zzasm = null;
    public Boolean zzasn = null;
    public Integer zzaso = null;

    public zzkj() {
        AppMethodBeat.i(2206);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2206);
    }

    public static zzkj[] zzli() {
        if (zzasl == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasl == null) {
                    zzasl = new zzkj[0];
                }
            }
        }
        return zzasl;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2207);
        if (obj == this) {
            AppMethodBeat.o(2207);
            return true;
        } else if (!(obj instanceof zzkj)) {
            AppMethodBeat.o(2207);
            return false;
        } else {
            zzkj zzkj = (zzkj) obj;
            if (this.name == null) {
                if (zzkj.name != null) {
                    AppMethodBeat.o(2207);
                    return false;
                }
            } else if (!this.name.equals(zzkj.name)) {
                AppMethodBeat.o(2207);
                return false;
            }
            if (this.zzasm == null) {
                if (zzkj.zzasm != null) {
                    AppMethodBeat.o(2207);
                    return false;
                }
            } else if (!this.zzasm.equals(zzkj.zzasm)) {
                AppMethodBeat.o(2207);
                return false;
            }
            if (this.zzasn == null) {
                if (zzkj.zzasn != null) {
                    AppMethodBeat.o(2207);
                    return false;
                }
            } else if (!this.zzasn.equals(zzkj.zzasn)) {
                AppMethodBeat.o(2207);
                return false;
            }
            if (this.zzaso == null) {
                if (zzkj.zzaso != null) {
                    AppMethodBeat.o(2207);
                    return false;
                }
            } else if (!this.zzaso.equals(zzkj.zzaso)) {
                AppMethodBeat.o(2207);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkj.zzbww);
                AppMethodBeat.o(2207);
                return equals;
            } else if (zzkj.zzbww == null || zzkj.zzbww.isEmpty()) {
                AppMethodBeat.o(2207);
                return true;
            } else {
                AppMethodBeat.o(2207);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2208);
        int hashCode = ((this.zzaso == null ? 0 : this.zzaso.hashCode()) + (((this.zzasn == null ? 0 : this.zzasn.hashCode()) + (((this.zzasm == null ? 0 : this.zzasm.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(2208);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2210);
        int zza = super.zza();
        if (this.name != null) {
            zza += zzabw.zzc(1, this.name);
        }
        if (this.zzasm != null) {
            this.zzasm.booleanValue();
            zza += zzabw.zzaq(2) + 1;
        }
        if (this.zzasn != null) {
            this.zzasn.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        if (this.zzaso != null) {
            zza += zzabw.zzf(4, this.zzaso.intValue());
        }
        AppMethodBeat.o(2210);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2209);
        if (this.name != null) {
            zzabw.zzb(1, this.name);
        }
        if (this.zzasm != null) {
            zzabw.zza(2, this.zzasm.booleanValue());
        }
        if (this.zzasn != null) {
            zzabw.zza(3, this.zzasn.booleanValue());
        }
        if (this.zzaso != null) {
            zzabw.zze(4, this.zzaso.intValue());
        }
        super.zza(zzabw);
        AppMethodBeat.o(2209);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2211);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2211);
                    break;
                case 10:
                    this.name = zzabv.readString();
                    break;
                case 16:
                    this.zzasm = Boolean.valueOf(zzabv.zzux());
                    break;
                case 24:
                    this.zzasn = Boolean.valueOf(zzabv.zzux());
                    break;
                case 32:
                    this.zzaso = Integer.valueOf(zzabv.zzuy());
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2211);
                        break;
                    }
            }
        }
        return this;
    }
}
