package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkh extends zzaby<zzkh> {
    private static volatile zzkh[] zzase;
    public Integer zzarp = null;
    public String zzasf = null;
    public zzkf zzasg = null;

    public zzkh() {
        AppMethodBeat.i(2193);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2193);
    }

    public static zzkh[] zzlh() {
        if (zzase == null) {
            synchronized (zzacc.zzbxg) {
                if (zzase == null) {
                    zzase = new zzkh[0];
                }
            }
        }
        return zzase;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2194);
        if (obj == this) {
            AppMethodBeat.o(2194);
            return true;
        } else if (!(obj instanceof zzkh)) {
            AppMethodBeat.o(2194);
            return false;
        } else {
            zzkh zzkh = (zzkh) obj;
            if (this.zzarp == null) {
                if (zzkh.zzarp != null) {
                    AppMethodBeat.o(2194);
                    return false;
                }
            } else if (!this.zzarp.equals(zzkh.zzarp)) {
                AppMethodBeat.o(2194);
                return false;
            }
            if (this.zzasf == null) {
                if (zzkh.zzasf != null) {
                    AppMethodBeat.o(2194);
                    return false;
                }
            } else if (!this.zzasf.equals(zzkh.zzasf)) {
                AppMethodBeat.o(2194);
                return false;
            }
            if (this.zzasg == null) {
                if (zzkh.zzasg != null) {
                    AppMethodBeat.o(2194);
                    return false;
                }
            } else if (!this.zzasg.equals(zzkh.zzasg)) {
                AppMethodBeat.o(2194);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkh.zzbww);
                AppMethodBeat.o(2194);
                return equals;
            } else if (zzkh.zzbww == null || zzkh.zzbww.isEmpty()) {
                AppMethodBeat.o(2194);
                return true;
            } else {
                AppMethodBeat.o(2194);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2195);
        int hashCode = (this.zzasf == null ? 0 : this.zzasf.hashCode()) + (((this.zzarp == null ? 0 : this.zzarp.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31);
        zzkf zzkf = this.zzasg;
        int hashCode2 = ((zzkf == null ? 0 : zzkf.hashCode()) + (hashCode * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode2 + i2;
        AppMethodBeat.o(2195);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2197);
        int zza = super.zza();
        if (this.zzarp != null) {
            zza += zzabw.zzf(1, this.zzarp.intValue());
        }
        if (this.zzasf != null) {
            zza += zzabw.zzc(2, this.zzasf);
        }
        if (this.zzasg != null) {
            zza += zzabw.zzb(3, this.zzasg);
        }
        AppMethodBeat.o(2197);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2196);
        if (this.zzarp != null) {
            zzabw.zze(1, this.zzarp.intValue());
        }
        if (this.zzasf != null) {
            zzabw.zzb(2, this.zzasf);
        }
        if (this.zzasg != null) {
            zzabw.zza(3, this.zzasg);
        }
        super.zza(zzabw);
        AppMethodBeat.o(2196);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2198);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2198);
                    break;
                case 8:
                    this.zzarp = Integer.valueOf(zzabv.zzuy());
                    break;
                case 18:
                    this.zzasf = zzabv.readString();
                    break;
                case 26:
                    if (this.zzasg == null) {
                        this.zzasg = new zzkf();
                    }
                    zzabv.zza(this.zzasg);
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2198);
                        break;
                    }
            }
        }
        return this;
    }
}
