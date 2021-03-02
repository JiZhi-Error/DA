package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

public final class zzkd extends zzaby<zzkd> {
    private static volatile zzkd[] zzark;
    public Integer zzarl = null;
    public zzkh[] zzarm = zzkh.zzlh();
    public zzke[] zzarn = zzke.zzlf();

    public zzkd() {
        AppMethodBeat.i(2168);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2168);
    }

    public static zzkd[] zzle() {
        if (zzark == null) {
            synchronized (zzacc.zzbxg) {
                if (zzark == null) {
                    zzark = new zzkd[0];
                }
            }
        }
        return zzark;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2169);
        if (obj == this) {
            AppMethodBeat.o(2169);
            return true;
        } else if (!(obj instanceof zzkd)) {
            AppMethodBeat.o(2169);
            return false;
        } else {
            zzkd zzkd = (zzkd) obj;
            if (this.zzarl == null) {
                if (zzkd.zzarl != null) {
                    AppMethodBeat.o(2169);
                    return false;
                }
            } else if (!this.zzarl.equals(zzkd.zzarl)) {
                AppMethodBeat.o(2169);
                return false;
            }
            if (!zzacc.equals(this.zzarm, zzkd.zzarm)) {
                AppMethodBeat.o(2169);
                return false;
            } else if (!zzacc.equals(this.zzarn, zzkd.zzarn)) {
                AppMethodBeat.o(2169);
                return false;
            } else if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkd.zzbww);
                AppMethodBeat.o(2169);
                return equals;
            } else if (zzkd.zzbww == null || zzkd.zzbww.isEmpty()) {
                AppMethodBeat.o(2169);
                return true;
            } else {
                AppMethodBeat.o(2169);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(TPCodecParamers.TP_PROFILE_H264_HIGH_422_INTRA);
        int hashCode = ((((((this.zzarl == null ? 0 : this.zzarl.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31) + zzacc.hashCode(this.zzarm)) * 31) + zzacc.hashCode(this.zzarn)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(TPCodecParamers.TP_PROFILE_H264_HIGH_422_INTRA);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2172);
        int zza = super.zza();
        if (this.zzarl != null) {
            zza += zzabw.zzf(1, this.zzarl.intValue());
        }
        if (this.zzarm != null && this.zzarm.length > 0) {
            int i2 = zza;
            for (int i3 = 0; i3 < this.zzarm.length; i3++) {
                zzkh zzkh = this.zzarm[i3];
                if (zzkh != null) {
                    i2 += zzabw.zzb(2, zzkh);
                }
            }
            zza = i2;
        }
        if (this.zzarn != null && this.zzarn.length > 0) {
            for (int i4 = 0; i4 < this.zzarn.length; i4++) {
                zzke zzke = this.zzarn[i4];
                if (zzke != null) {
                    zza += zzabw.zzb(3, zzke);
                }
            }
        }
        AppMethodBeat.o(2172);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2171);
        if (this.zzarl != null) {
            zzabw.zze(1, this.zzarl.intValue());
        }
        if (this.zzarm != null && this.zzarm.length > 0) {
            for (int i2 = 0; i2 < this.zzarm.length; i2++) {
                zzkh zzkh = this.zzarm[i2];
                if (zzkh != null) {
                    zzabw.zza(2, zzkh);
                }
            }
        }
        if (this.zzarn != null && this.zzarn.length > 0) {
            for (int i3 = 0; i3 < this.zzarn.length; i3++) {
                zzke zzke = this.zzarn[i3];
                if (zzke != null) {
                    zzabw.zza(3, zzke);
                }
            }
        }
        super.zza(zzabw);
        AppMethodBeat.o(2171);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2173);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2173);
                    break;
                case 8:
                    this.zzarl = Integer.valueOf(zzabv.zzuy());
                    break;
                case 18:
                    int zzb = zzach.zzb(zzabv, 18);
                    int length = this.zzarm == null ? 0 : this.zzarm.length;
                    zzkh[] zzkhArr = new zzkh[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzarm, 0, zzkhArr, 0, length);
                    }
                    while (length < zzkhArr.length - 1) {
                        zzkhArr[length] = new zzkh();
                        zzabv.zza(zzkhArr[length]);
                        zzabv.zzuw();
                        length++;
                    }
                    zzkhArr[length] = new zzkh();
                    zzabv.zza(zzkhArr[length]);
                    this.zzarm = zzkhArr;
                    break;
                case 26:
                    int zzb2 = zzach.zzb(zzabv, 26);
                    int length2 = this.zzarn == null ? 0 : this.zzarn.length;
                    zzke[] zzkeArr = new zzke[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzarn, 0, zzkeArr, 0, length2);
                    }
                    while (length2 < zzkeArr.length - 1) {
                        zzkeArr[length2] = new zzke();
                        zzabv.zza(zzkeArr[length2]);
                        zzabv.zzuw();
                        length2++;
                    }
                    zzkeArr[length2] = new zzke();
                    zzabv.zza(zzkeArr[length2]);
                    this.zzarn = zzkeArr;
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2173);
                        break;
                    }
            }
        }
        return this;
    }
}
