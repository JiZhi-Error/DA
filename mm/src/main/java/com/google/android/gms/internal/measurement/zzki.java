package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzki extends zzaby<zzki> {
    public Integer zzash = null;
    public String zzasi = null;
    public Boolean zzasj = null;
    public String[] zzask = zzach.zzbxq;

    public zzki() {
        AppMethodBeat.i(2199);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2199);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzki zze(com.google.android.gms.internal.measurement.zzabv r9) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzki.zze(com.google.android.gms.internal.measurement.zzabv):com.google.android.gms.internal.measurement.zzki");
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2200);
        if (obj == this) {
            AppMethodBeat.o(2200);
            return true;
        } else if (!(obj instanceof zzki)) {
            AppMethodBeat.o(2200);
            return false;
        } else {
            zzki zzki = (zzki) obj;
            if (this.zzash == null) {
                if (zzki.zzash != null) {
                    AppMethodBeat.o(2200);
                    return false;
                }
            } else if (!this.zzash.equals(zzki.zzash)) {
                AppMethodBeat.o(2200);
                return false;
            }
            if (this.zzasi == null) {
                if (zzki.zzasi != null) {
                    AppMethodBeat.o(2200);
                    return false;
                }
            } else if (!this.zzasi.equals(zzki.zzasi)) {
                AppMethodBeat.o(2200);
                return false;
            }
            if (this.zzasj == null) {
                if (zzki.zzasj != null) {
                    AppMethodBeat.o(2200);
                    return false;
                }
            } else if (!this.zzasj.equals(zzki.zzasj)) {
                AppMethodBeat.o(2200);
                return false;
            }
            if (!zzacc.equals(this.zzask, zzki.zzask)) {
                AppMethodBeat.o(2200);
                return false;
            } else if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzki.zzbww);
                AppMethodBeat.o(2200);
                return equals;
            } else if (zzki.zzbww == null || zzki.zzbww.isEmpty()) {
                AppMethodBeat.o(2200);
                return true;
            } else {
                AppMethodBeat.o(2200);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2201);
        int hashCode = ((((this.zzasj == null ? 0 : this.zzasj.hashCode()) + (((this.zzasi == null ? 0 : this.zzasi.hashCode()) + (((this.zzash == null ? 0 : this.zzash.intValue()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31) + zzacc.hashCode(this.zzask)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(2201);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        int i2;
        AppMethodBeat.i(2203);
        int zza = super.zza();
        if (this.zzash != null) {
            zza += zzabw.zzf(1, this.zzash.intValue());
        }
        if (this.zzasi != null) {
            zza += zzabw.zzc(2, this.zzasi);
        }
        if (this.zzasj != null) {
            this.zzasj.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        if (this.zzask != null && this.zzask.length > 0) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < this.zzask.length) {
                String str = this.zzask[i3];
                if (str != null) {
                    i5++;
                    i2 = zzabw.zzfm(str) + i4;
                } else {
                    i2 = i4;
                }
                i3++;
                i4 = i2;
            }
            zza = zza + i4 + (i5 * 1);
        }
        AppMethodBeat.o(2203);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2202);
        if (this.zzash != null) {
            zzabw.zze(1, this.zzash.intValue());
        }
        if (this.zzasi != null) {
            zzabw.zzb(2, this.zzasi);
        }
        if (this.zzasj != null) {
            zzabw.zza(3, this.zzasj.booleanValue());
        }
        if (this.zzask != null && this.zzask.length > 0) {
            for (int i2 = 0; i2 < this.zzask.length; i2++) {
                String str = this.zzask[i2];
                if (str != null) {
                    zzabw.zzb(4, str);
                }
            }
        }
        super.zza(zzabw);
        AppMethodBeat.o(2202);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2205);
        zzki zze = zze(zzabv);
        AppMethodBeat.o(2205);
        return zze;
    }
}
