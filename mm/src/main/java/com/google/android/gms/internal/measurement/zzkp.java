package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkp extends zzaby<zzkp> {
    public zzkq[] zzatf = zzkq.zzln();

    public zzkp() {
        AppMethodBeat.i(2242);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2242);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2243);
        if (obj == this) {
            AppMethodBeat.o(2243);
            return true;
        } else if (!(obj instanceof zzkp)) {
            AppMethodBeat.o(2243);
            return false;
        } else {
            zzkp zzkp = (zzkp) obj;
            if (!zzacc.equals(this.zzatf, zzkp.zzatf)) {
                AppMethodBeat.o(2243);
                return false;
            } else if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkp.zzbww);
                AppMethodBeat.o(2243);
                return equals;
            } else if (zzkp.zzbww == null || zzkp.zzbww.isEmpty()) {
                AppMethodBeat.o(2243);
                return true;
            } else {
                AppMethodBeat.o(2243);
                return false;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(2244);
        int hashCode = ((this.zzbww == null || this.zzbww.isEmpty()) ? 0 : this.zzbww.hashCode()) + ((((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + zzacc.hashCode(this.zzatf)) * 31);
        AppMethodBeat.o(2244);
        return hashCode;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2246);
        int zza = super.zza();
        if (this.zzatf != null && this.zzatf.length > 0) {
            for (int i2 = 0; i2 < this.zzatf.length; i2++) {
                zzkq zzkq = this.zzatf[i2];
                if (zzkq != null) {
                    zza += zzabw.zzb(1, zzkq);
                }
            }
        }
        AppMethodBeat.o(2246);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2245);
        if (this.zzatf != null && this.zzatf.length > 0) {
            for (int i2 = 0; i2 < this.zzatf.length; i2++) {
                zzkq zzkq = this.zzatf[i2];
                if (zzkq != null) {
                    zzabw.zza(1, zzkq);
                }
            }
        }
        super.zza(zzabw);
        AppMethodBeat.o(2245);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2247);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2247);
                    break;
                case 10:
                    int zzb = zzach.zzb(zzabv, 10);
                    int length = this.zzatf == null ? 0 : this.zzatf.length;
                    zzkq[] zzkqArr = new zzkq[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzatf, 0, zzkqArr, 0, length);
                    }
                    while (length < zzkqArr.length - 1) {
                        zzkqArr[length] = new zzkq();
                        zzabv.zza(zzkqArr[length]);
                        zzabv.zzuw();
                        length++;
                    }
                    zzkqArr[length] = new zzkq();
                    zzabv.zza(zzkqArr[length]);
                    this.zzatf = zzkqArr;
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2247);
                        break;
                    }
            }
        }
        return this;
    }
}
