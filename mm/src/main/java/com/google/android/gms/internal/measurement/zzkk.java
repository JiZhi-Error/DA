package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkk extends zzaby<zzkk> {
    public String zzadm = null;
    public Long zzasp = null;
    private Integer zzasq = null;
    public zzkl[] zzasr = zzkl.zzlj();
    public zzkj[] zzass = zzkj.zzli();
    public zzkd[] zzast = zzkd.zzle();

    public zzkk() {
        AppMethodBeat.i(2212);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2212);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2213);
        if (obj == this) {
            AppMethodBeat.o(2213);
            return true;
        } else if (!(obj instanceof zzkk)) {
            AppMethodBeat.o(2213);
            return false;
        } else {
            zzkk zzkk = (zzkk) obj;
            if (this.zzasp == null) {
                if (zzkk.zzasp != null) {
                    AppMethodBeat.o(2213);
                    return false;
                }
            } else if (!this.zzasp.equals(zzkk.zzasp)) {
                AppMethodBeat.o(2213);
                return false;
            }
            if (this.zzadm == null) {
                if (zzkk.zzadm != null) {
                    AppMethodBeat.o(2213);
                    return false;
                }
            } else if (!this.zzadm.equals(zzkk.zzadm)) {
                AppMethodBeat.o(2213);
                return false;
            }
            if (this.zzasq == null) {
                if (zzkk.zzasq != null) {
                    AppMethodBeat.o(2213);
                    return false;
                }
            } else if (!this.zzasq.equals(zzkk.zzasq)) {
                AppMethodBeat.o(2213);
                return false;
            }
            if (!zzacc.equals(this.zzasr, zzkk.zzasr)) {
                AppMethodBeat.o(2213);
                return false;
            } else if (!zzacc.equals(this.zzass, zzkk.zzass)) {
                AppMethodBeat.o(2213);
                return false;
            } else if (!zzacc.equals(this.zzast, zzkk.zzast)) {
                AppMethodBeat.o(2213);
                return false;
            } else if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkk.zzbww);
                AppMethodBeat.o(2213);
                return equals;
            } else if (zzkk.zzbww == null || zzkk.zzbww.isEmpty()) {
                AppMethodBeat.o(2213);
                return true;
            } else {
                AppMethodBeat.o(2213);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2214);
        int hashCode = ((((((((this.zzasq == null ? 0 : this.zzasq.hashCode()) + (((this.zzadm == null ? 0 : this.zzadm.hashCode()) + (((this.zzasp == null ? 0 : this.zzasp.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31) + zzacc.hashCode(this.zzasr)) * 31) + zzacc.hashCode(this.zzass)) * 31) + zzacc.hashCode(this.zzast)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(2214);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2216);
        int zza = super.zza();
        if (this.zzasp != null) {
            zza += zzabw.zzc(1, this.zzasp.longValue());
        }
        if (this.zzadm != null) {
            zza += zzabw.zzc(2, this.zzadm);
        }
        if (this.zzasq != null) {
            zza += zzabw.zzf(3, this.zzasq.intValue());
        }
        if (this.zzasr != null && this.zzasr.length > 0) {
            int i2 = zza;
            for (int i3 = 0; i3 < this.zzasr.length; i3++) {
                zzkl zzkl = this.zzasr[i3];
                if (zzkl != null) {
                    i2 += zzabw.zzb(4, zzkl);
                }
            }
            zza = i2;
        }
        if (this.zzass != null && this.zzass.length > 0) {
            int i4 = zza;
            for (int i5 = 0; i5 < this.zzass.length; i5++) {
                zzkj zzkj = this.zzass[i5];
                if (zzkj != null) {
                    i4 += zzabw.zzb(5, zzkj);
                }
            }
            zza = i4;
        }
        if (this.zzast != null && this.zzast.length > 0) {
            for (int i6 = 0; i6 < this.zzast.length; i6++) {
                zzkd zzkd = this.zzast[i6];
                if (zzkd != null) {
                    zza += zzabw.zzb(6, zzkd);
                }
            }
        }
        AppMethodBeat.o(2216);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2215);
        if (this.zzasp != null) {
            zzabw.zzb(1, this.zzasp.longValue());
        }
        if (this.zzadm != null) {
            zzabw.zzb(2, this.zzadm);
        }
        if (this.zzasq != null) {
            zzabw.zze(3, this.zzasq.intValue());
        }
        if (this.zzasr != null && this.zzasr.length > 0) {
            for (int i2 = 0; i2 < this.zzasr.length; i2++) {
                zzkl zzkl = this.zzasr[i2];
                if (zzkl != null) {
                    zzabw.zza(4, zzkl);
                }
            }
        }
        if (this.zzass != null && this.zzass.length > 0) {
            for (int i3 = 0; i3 < this.zzass.length; i3++) {
                zzkj zzkj = this.zzass[i3];
                if (zzkj != null) {
                    zzabw.zza(5, zzkj);
                }
            }
        }
        if (this.zzast != null && this.zzast.length > 0) {
            for (int i4 = 0; i4 < this.zzast.length; i4++) {
                zzkd zzkd = this.zzast[i4];
                if (zzkd != null) {
                    zzabw.zza(6, zzkd);
                }
            }
        }
        super.zza(zzabw);
        AppMethodBeat.o(2215);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2217);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2217);
                    break;
                case 8:
                    this.zzasp = Long.valueOf(zzabv.zzuz());
                    break;
                case 18:
                    this.zzadm = zzabv.readString();
                    break;
                case 24:
                    this.zzasq = Integer.valueOf(zzabv.zzuy());
                    break;
                case 34:
                    int zzb = zzach.zzb(zzabv, 34);
                    int length = this.zzasr == null ? 0 : this.zzasr.length;
                    zzkl[] zzklArr = new zzkl[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzasr, 0, zzklArr, 0, length);
                    }
                    while (length < zzklArr.length - 1) {
                        zzklArr[length] = new zzkl();
                        zzabv.zza(zzklArr[length]);
                        zzabv.zzuw();
                        length++;
                    }
                    zzklArr[length] = new zzkl();
                    zzabv.zza(zzklArr[length]);
                    this.zzasr = zzklArr;
                    break;
                case 42:
                    int zzb2 = zzach.zzb(zzabv, 42);
                    int length2 = this.zzass == null ? 0 : this.zzass.length;
                    zzkj[] zzkjArr = new zzkj[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzass, 0, zzkjArr, 0, length2);
                    }
                    while (length2 < zzkjArr.length - 1) {
                        zzkjArr[length2] = new zzkj();
                        zzabv.zza(zzkjArr[length2]);
                        zzabv.zzuw();
                        length2++;
                    }
                    zzkjArr[length2] = new zzkj();
                    zzabv.zza(zzkjArr[length2]);
                    this.zzass = zzkjArr;
                    break;
                case 50:
                    int zzb3 = zzach.zzb(zzabv, 50);
                    int length3 = this.zzast == null ? 0 : this.zzast.length;
                    zzkd[] zzkdArr = new zzkd[(zzb3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzast, 0, zzkdArr, 0, length3);
                    }
                    while (length3 < zzkdArr.length - 1) {
                        zzkdArr[length3] = new zzkd();
                        zzabv.zza(zzkdArr[length3]);
                        zzabv.zzuw();
                        length3++;
                    }
                    zzkdArr[length3] = new zzkd();
                    zzabv.zza(zzkdArr[length3]);
                    this.zzast = zzkdArr;
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2217);
                        break;
                    }
            }
        }
        return this;
    }
}
