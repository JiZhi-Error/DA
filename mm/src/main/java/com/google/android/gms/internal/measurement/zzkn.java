package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkn extends zzaby<zzkn> {
    private static volatile zzkn[] zzasz;
    public Integer count = null;
    public String name = null;
    public zzko[] zzata = zzko.zzlm();
    public Long zzatb = null;
    public Long zzatc = null;

    public zzkn() {
        AppMethodBeat.i(2230);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2230);
    }

    public static zzkn[] zzll() {
        if (zzasz == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasz == null) {
                    zzasz = new zzkn[0];
                }
            }
        }
        return zzasz;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2231);
        if (obj == this) {
            AppMethodBeat.o(2231);
            return true;
        } else if (!(obj instanceof zzkn)) {
            AppMethodBeat.o(2231);
            return false;
        } else {
            zzkn zzkn = (zzkn) obj;
            if (!zzacc.equals(this.zzata, zzkn.zzata)) {
                AppMethodBeat.o(2231);
                return false;
            }
            if (this.name == null) {
                if (zzkn.name != null) {
                    AppMethodBeat.o(2231);
                    return false;
                }
            } else if (!this.name.equals(zzkn.name)) {
                AppMethodBeat.o(2231);
                return false;
            }
            if (this.zzatb == null) {
                if (zzkn.zzatb != null) {
                    AppMethodBeat.o(2231);
                    return false;
                }
            } else if (!this.zzatb.equals(zzkn.zzatb)) {
                AppMethodBeat.o(2231);
                return false;
            }
            if (this.zzatc == null) {
                if (zzkn.zzatc != null) {
                    AppMethodBeat.o(2231);
                    return false;
                }
            } else if (!this.zzatc.equals(zzkn.zzatc)) {
                AppMethodBeat.o(2231);
                return false;
            }
            if (this.count == null) {
                if (zzkn.count != null) {
                    AppMethodBeat.o(2231);
                    return false;
                }
            } else if (!this.count.equals(zzkn.count)) {
                AppMethodBeat.o(2231);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkn.zzbww);
                AppMethodBeat.o(2231);
                return equals;
            } else if (zzkn.zzbww == null || zzkn.zzbww.isEmpty()) {
                AppMethodBeat.o(2231);
                return true;
            } else {
                AppMethodBeat.o(2231);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2232);
        int hashCode = ((this.count == null ? 0 : this.count.hashCode()) + (((this.zzatc == null ? 0 : this.zzatc.hashCode()) + (((this.zzatb == null ? 0 : this.zzatb.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + zzacc.hashCode(this.zzata)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(2232);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2234);
        int zza = super.zza();
        if (this.zzata != null && this.zzata.length > 0) {
            for (int i2 = 0; i2 < this.zzata.length; i2++) {
                zzko zzko = this.zzata[i2];
                if (zzko != null) {
                    zza += zzabw.zzb(1, zzko);
                }
            }
        }
        if (this.name != null) {
            zza += zzabw.zzc(2, this.name);
        }
        if (this.zzatb != null) {
            zza += zzabw.zzc(3, this.zzatb.longValue());
        }
        if (this.zzatc != null) {
            zza += zzabw.zzc(4, this.zzatc.longValue());
        }
        if (this.count != null) {
            zza += zzabw.zzf(5, this.count.intValue());
        }
        AppMethodBeat.o(2234);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2233);
        if (this.zzata != null && this.zzata.length > 0) {
            for (int i2 = 0; i2 < this.zzata.length; i2++) {
                zzko zzko = this.zzata[i2];
                if (zzko != null) {
                    zzabw.zza(1, zzko);
                }
            }
        }
        if (this.name != null) {
            zzabw.zzb(2, this.name);
        }
        if (this.zzatb != null) {
            zzabw.zzb(3, this.zzatb.longValue());
        }
        if (this.zzatc != null) {
            zzabw.zzb(4, this.zzatc.longValue());
        }
        if (this.count != null) {
            zzabw.zze(5, this.count.intValue());
        }
        super.zza(zzabw);
        AppMethodBeat.o(2233);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2235);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2235);
                    break;
                case 10:
                    int zzb = zzach.zzb(zzabv, 10);
                    int length = this.zzata == null ? 0 : this.zzata.length;
                    zzko[] zzkoArr = new zzko[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzata, 0, zzkoArr, 0, length);
                    }
                    while (length < zzkoArr.length - 1) {
                        zzkoArr[length] = new zzko();
                        zzabv.zza(zzkoArr[length]);
                        zzabv.zzuw();
                        length++;
                    }
                    zzkoArr[length] = new zzko();
                    zzabv.zza(zzkoArr[length]);
                    this.zzata = zzkoArr;
                    break;
                case 18:
                    this.name = zzabv.readString();
                    break;
                case 24:
                    this.zzatb = Long.valueOf(zzabv.zzuz());
                    break;
                case 32:
                    this.zzatc = Long.valueOf(zzabv.zzuz());
                    break;
                case 40:
                    this.count = Integer.valueOf(zzabv.zzuy());
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2235);
                        break;
                    }
            }
        }
        return this;
    }
}
