package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkl extends zzaby<zzkl> {
    private static volatile zzkl[] zzasu;
    public String value = null;
    public String zzny = null;

    public zzkl() {
        AppMethodBeat.i(2218);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2218);
    }

    public static zzkl[] zzlj() {
        if (zzasu == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasu == null) {
                    zzasu = new zzkl[0];
                }
            }
        }
        return zzasu;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2219);
        if (obj == this) {
            AppMethodBeat.o(2219);
            return true;
        } else if (!(obj instanceof zzkl)) {
            AppMethodBeat.o(2219);
            return false;
        } else {
            zzkl zzkl = (zzkl) obj;
            if (this.zzny == null) {
                if (zzkl.zzny != null) {
                    AppMethodBeat.o(2219);
                    return false;
                }
            } else if (!this.zzny.equals(zzkl.zzny)) {
                AppMethodBeat.o(2219);
                return false;
            }
            if (this.value == null) {
                if (zzkl.value != null) {
                    AppMethodBeat.o(2219);
                    return false;
                }
            } else if (!this.value.equals(zzkl.value)) {
                AppMethodBeat.o(2219);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkl.zzbww);
                AppMethodBeat.o(2219);
                return equals;
            } else if (zzkl.zzbww == null || zzkl.zzbww.isEmpty()) {
                AppMethodBeat.o(2219);
                return true;
            } else {
                AppMethodBeat.o(2219);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2220);
        int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.zzny == null ? 0 : this.zzny.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(2220);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2222);
        int zza = super.zza();
        if (this.zzny != null) {
            zza += zzabw.zzc(1, this.zzny);
        }
        if (this.value != null) {
            zza += zzabw.zzc(2, this.value);
        }
        AppMethodBeat.o(2222);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2221);
        if (this.zzny != null) {
            zzabw.zzb(1, this.zzny);
        }
        if (this.value != null) {
            zzabw.zzb(2, this.value);
        }
        super.zza(zzabw);
        AppMethodBeat.o(2221);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2223);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2223);
                    break;
                case 10:
                    this.zzny = zzabv.readString();
                    break;
                case 18:
                    this.value = zzabv.readString();
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2223);
                        break;
                    }
            }
        }
        return this;
    }
}
