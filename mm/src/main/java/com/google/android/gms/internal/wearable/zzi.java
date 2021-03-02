package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzi extends zzn<zzi> {
    private static volatile zzi[] zzgb;
    public int type = 1;
    public zzj zzgc = null;

    public zzi() {
        AppMethodBeat.i(100674);
        this.zzhc = null;
        this.zzhl = -1;
        AppMethodBeat.o(100674);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.wearable.zzi zzb(com.google.android.gms.internal.wearable.zzk r8) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.wearable.zzi.zzb(com.google.android.gms.internal.wearable.zzk):com.google.android.gms.internal.wearable.zzi");
    }

    public static zzi[] zzi() {
        if (zzgb == null) {
            synchronized (zzr.zzhk) {
                if (zzgb == null) {
                    zzgb = new zzi[0];
                }
            }
        }
        return zzgb;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100675);
        if (obj == this) {
            AppMethodBeat.o(100675);
            return true;
        } else if (!(obj instanceof zzi)) {
            AppMethodBeat.o(100675);
            return false;
        } else {
            zzi zzi = (zzi) obj;
            if (this.type != zzi.type) {
                AppMethodBeat.o(100675);
                return false;
            }
            if (this.zzgc == null) {
                if (zzi.zzgc != null) {
                    AppMethodBeat.o(100675);
                    return false;
                }
            } else if (!this.zzgc.equals(zzi.zzgc)) {
                AppMethodBeat.o(100675);
                return false;
            }
            if (this.zzhc != null && !this.zzhc.isEmpty()) {
                boolean equals = this.zzhc.equals(zzi.zzhc);
                AppMethodBeat.o(100675);
                return equals;
            } else if (zzi.zzhc == null || zzi.zzhc.isEmpty()) {
                AppMethodBeat.o(100675);
                return true;
            } else {
                AppMethodBeat.o(100675);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(100676);
        int hashCode = ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.type;
        zzj zzj = this.zzgc;
        int hashCode2 = ((zzj == null ? 0 : zzj.hashCode()) + (hashCode * 31)) * 31;
        if (this.zzhc != null && !this.zzhc.isEmpty()) {
            i2 = this.zzhc.hashCode();
        }
        int i3 = hashCode2 + i2;
        AppMethodBeat.o(100676);
        return i3;
    }

    @Override // com.google.android.gms.internal.wearable.zzt
    public final /* synthetic */ zzt zza(zzk zzk) {
        AppMethodBeat.i(100680);
        zzi zzb = zzb(zzk);
        AppMethodBeat.o(100680);
        return zzb;
    }

    @Override // com.google.android.gms.internal.wearable.zzn, com.google.android.gms.internal.wearable.zzt
    public final void zza(zzl zzl) {
        AppMethodBeat.i(100677);
        zzl.zzd(1, this.type);
        if (this.zzgc != null) {
            zzl.zza(2, this.zzgc);
        }
        super.zza(zzl);
        AppMethodBeat.o(100677);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.wearable.zzn, com.google.android.gms.internal.wearable.zzt
    public final int zzg() {
        AppMethodBeat.i(100678);
        int zzg = super.zzg() + zzl.zze(1, this.type);
        if (this.zzgc != null) {
            zzg += zzl.zzb(2, this.zzgc);
        }
        AppMethodBeat.o(100678);
        return zzg;
    }
}
