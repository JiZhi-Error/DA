package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkg extends zzaby<zzkg> {
    public Integer zzarz = null;
    public Boolean zzasa = null;
    public String zzasb = null;
    public String zzasc = null;
    public String zzasd = null;

    public zzkg() {
        AppMethodBeat.i(2186);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2186);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzkg zzd(com.google.android.gms.internal.measurement.zzabv r8) {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkg.zzd(com.google.android.gms.internal.measurement.zzabv):com.google.android.gms.internal.measurement.zzkg");
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2187);
        if (obj == this) {
            AppMethodBeat.o(2187);
            return true;
        } else if (!(obj instanceof zzkg)) {
            AppMethodBeat.o(2187);
            return false;
        } else {
            zzkg zzkg = (zzkg) obj;
            if (this.zzarz == null) {
                if (zzkg.zzarz != null) {
                    AppMethodBeat.o(2187);
                    return false;
                }
            } else if (!this.zzarz.equals(zzkg.zzarz)) {
                AppMethodBeat.o(2187);
                return false;
            }
            if (this.zzasa == null) {
                if (zzkg.zzasa != null) {
                    AppMethodBeat.o(2187);
                    return false;
                }
            } else if (!this.zzasa.equals(zzkg.zzasa)) {
                AppMethodBeat.o(2187);
                return false;
            }
            if (this.zzasb == null) {
                if (zzkg.zzasb != null) {
                    AppMethodBeat.o(2187);
                    return false;
                }
            } else if (!this.zzasb.equals(zzkg.zzasb)) {
                AppMethodBeat.o(2187);
                return false;
            }
            if (this.zzasc == null) {
                if (zzkg.zzasc != null) {
                    AppMethodBeat.o(2187);
                    return false;
                }
            } else if (!this.zzasc.equals(zzkg.zzasc)) {
                AppMethodBeat.o(2187);
                return false;
            }
            if (this.zzasd == null) {
                if (zzkg.zzasd != null) {
                    AppMethodBeat.o(2187);
                    return false;
                }
            } else if (!this.zzasd.equals(zzkg.zzasd)) {
                AppMethodBeat.o(2187);
                return false;
            }
            if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkg.zzbww);
                AppMethodBeat.o(2187);
                return equals;
            } else if (zzkg.zzbww == null || zzkg.zzbww.isEmpty()) {
                AppMethodBeat.o(2187);
                return true;
            } else {
                AppMethodBeat.o(2187);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(2188);
        int hashCode = ((this.zzasd == null ? 0 : this.zzasd.hashCode()) + (((this.zzasc == null ? 0 : this.zzasc.hashCode()) + (((this.zzasb == null ? 0 : this.zzasb.hashCode()) + (((this.zzasa == null ? 0 : this.zzasa.hashCode()) + (((this.zzarz == null ? 0 : this.zzarz.intValue()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i2 = this.zzbww.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(2188);
        return i3;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        AppMethodBeat.i(2190);
        int zza = super.zza();
        if (this.zzarz != null) {
            zza += zzabw.zzf(1, this.zzarz.intValue());
        }
        if (this.zzasa != null) {
            this.zzasa.booleanValue();
            zza += zzabw.zzaq(2) + 1;
        }
        if (this.zzasb != null) {
            zza += zzabw.zzc(3, this.zzasb);
        }
        if (this.zzasc != null) {
            zza += zzabw.zzc(4, this.zzasc);
        }
        if (this.zzasd != null) {
            zza += zzabw.zzc(5, this.zzasd);
        }
        AppMethodBeat.o(2190);
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2189);
        if (this.zzarz != null) {
            zzabw.zze(1, this.zzarz.intValue());
        }
        if (this.zzasa != null) {
            zzabw.zza(2, this.zzasa.booleanValue());
        }
        if (this.zzasb != null) {
            zzabw.zzb(3, this.zzasb);
        }
        if (this.zzasc != null) {
            zzabw.zzb(4, this.zzasc);
        }
        if (this.zzasd != null) {
            zzabw.zzb(5, this.zzasd);
        }
        super.zza(zzabw);
        AppMethodBeat.o(2189);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2192);
        zzkg zzd = zzd(zzabv);
        AppMethodBeat.o(2192);
        return zzd;
    }
}
