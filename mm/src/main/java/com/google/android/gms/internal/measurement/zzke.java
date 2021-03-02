package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzke extends zzaby<zzke> {
    private static volatile zzke[] zzaro;
    public Integer zzarp = null;
    public String zzarq = null;
    public zzkf[] zzarr = zzkf.zzlg();
    private Boolean zzars = null;
    public zzkg zzart = null;

    public zzke() {
        AppMethodBeat.i(2174);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2174);
    }

    public static zzke[] zzlf() {
        if (zzaro == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaro == null) {
                    zzaro = new zzke[0];
                }
            }
        }
        return zzaro;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2175);
        if (obj == this) {
            AppMethodBeat.o(2175);
            return true;
        } else if (!(obj instanceof zzke)) {
            AppMethodBeat.o(2175);
            return false;
        } else {
            zzke zzke = (zzke) obj;
            if (this.zzarp == null) {
                if (zzke.zzarp != null) {
                    AppMethodBeat.o(2175);
                    return false;
                }
            } else if (!this.zzarp.equals(zzke.zzarp)) {
                AppMethodBeat.o(2175);
                return false;
            }
            if (this.zzarq == null) {
                if (zzke.zzarq != null) {
                    AppMethodBeat.o(2175);
                    return false;
                }
            } else if (!this.zzarq.equals(zzke.zzarq)) {
                AppMethodBeat.o(2175);
                return false;
            }
            if (!zzacc.equals(this.zzarr, zzke.zzarr)) {
                AppMethodBeat.o(2175);
                return false;
            }
            if (this.zzars == null) {
                if (zzke.zzars != null) {
                    AppMethodBeat.o(2175);
                    return false;
                }
            } else if (!this.zzars.equals(zzke.zzars)) {
                AppMethodBeat.o(2175);
                return false;
            }
            if (this.zzart == null) {
                if (zzke.zzart != null) {
                    AppMethodBeat.o(2175);
                    return false;
                }
            } else if (!this.zzart.equals(zzke.zzart)) {
                AppMethodBeat.o(2175);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzke.zzbww);
                AppMethodBeat.o(2175);
                return equals;
            } else if (zzke.zzbww == null || zzke.zzbww.isEmpty()) {
                AppMethodBeat.o(2175);
                return true;
            } else {
                AppMethodBeat.o(2175);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2176);
        int hashCode = (this.zzars == null ? 0 : this.zzars.hashCode()) + (((((this.zzarq == null ? 0 : this.zzarq.hashCode()) + (((this.zzarp == null ? 0 : this.zzarp.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31) + zzacc.hashCode(this.zzarr)) * 31);
        zzkg zzkg = this.zzart;
        int hashCode2 = ((zzkg == null ? 0 : zzkg.hashCode()) + (hashCode * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode2 + i2;
        AppMethodBeat.o(2176);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2178);
        int zza = super.zza();
        if (this.zzarp != null) {
            zza += zzabw.zzf(1, this.zzarp.intValue());
        }
        if (this.zzarq != null) {
            zza += zzabw.zzc(2, this.zzarq);
        }
        if (this.zzarr != null && this.zzarr.length > 0) {
            int i2 = zza;
            for (int i3 = 0; i3 < this.zzarr.length; i3++) {
                zzkf zzkf = this.zzarr[i3];
                if (zzkf != null) {
                    i2 += zzabw.zzb(3, zzkf);
                }
            }
            zza = i2;
        }
        if (this.zzars != null) {
            this.zzars.booleanValue();
            zza += zzabw.zzaq(4) + 1;
        }
        if (this.zzart != null) {
            zza += zzabw.zzb(5, this.zzart);
        }
        AppMethodBeat.o(2178);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2177);
        if (this.zzarp != null) {
            zzabw.zze(1, this.zzarp.intValue());
        }
        if (this.zzarq != null) {
            zzabw.zzb(2, this.zzarq);
        }
        if (this.zzarr != null && this.zzarr.length > 0) {
            for (int i2 = 0; i2 < this.zzarr.length; i2++) {
                zzkf zzkf = this.zzarr[i2];
                if (zzkf != null) {
                    zzabw.zza(3, zzkf);
                }
            }
        }
        if (this.zzars != null) {
            zzabw.zza(4, this.zzars.booleanValue());
        }
        if (this.zzart != null) {
            zzabw.zza(5, this.zzart);
        }
        super.zza(zzabw);
        AppMethodBeat.o(2177);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2179);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2179);
                    break;
                case 8:
                    this.zzarp = Integer.valueOf(zzabv.zzuy());
                    break;
                case 18:
                    this.zzarq = zzabv.readString();
                    break;
                case 26:
                    int zzb = zzach.zzb(zzabv, 26);
                    int length = this.zzarr == null ? 0 : this.zzarr.length;
                    zzkf[] zzkfArr = new zzkf[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzarr, 0, zzkfArr, 0, length);
                    }
                    while (length < zzkfArr.length - 1) {
                        zzkfArr[length] = new zzkf();
                        zzabv.zza(zzkfArr[length]);
                        zzabv.zzuw();
                        length++;
                    }
                    zzkfArr[length] = new zzkf();
                    zzabv.zza(zzkfArr[length]);
                    this.zzarr = zzkfArr;
                    break;
                case 32:
                    this.zzars = Boolean.valueOf(zzabv.zzux());
                    break;
                case 42:
                    if (this.zzart == null) {
                        this.zzart = new zzkg();
                    }
                    zzabv.zza(this.zzart);
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2179);
                        break;
                    }
            }
        }
        return this;
    }
}
