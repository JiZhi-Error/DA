package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzh extends zzn<zzh> {
    private static volatile zzh[] zzfz;
    public String name = "";
    public zzi zzga = null;

    public zzh() {
        AppMethodBeat.i(100668);
        this.zzhc = null;
        this.zzhl = -1;
        AppMethodBeat.o(100668);
    }

    public static zzh[] zzh() {
        if (zzfz == null) {
            synchronized (zzr.zzhk) {
                if (zzfz == null) {
                    zzfz = new zzh[0];
                }
            }
        }
        return zzfz;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100669);
        if (obj == this) {
            AppMethodBeat.o(100669);
            return true;
        } else if (!(obj instanceof zzh)) {
            AppMethodBeat.o(100669);
            return false;
        } else {
            zzh zzh = (zzh) obj;
            if (this.name == null) {
                if (zzh.name != null) {
                    AppMethodBeat.o(100669);
                    return false;
                }
            } else if (!this.name.equals(zzh.name)) {
                AppMethodBeat.o(100669);
                return false;
            }
            if (this.zzga == null) {
                if (zzh.zzga != null) {
                    AppMethodBeat.o(100669);
                    return false;
                }
            } else if (!this.zzga.equals(zzh.zzga)) {
                AppMethodBeat.o(100669);
                return false;
            }
            if (this.zzhc != null && !this.zzhc.isEmpty()) {
                boolean equals = this.zzhc.equals(zzh.zzhc);
                AppMethodBeat.o(100669);
                return equals;
            } else if (zzh.zzhc == null || zzh.zzhc.isEmpty()) {
                AppMethodBeat.o(100669);
                return true;
            } else {
                AppMethodBeat.o(100669);
                return false;
            }
        }
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(100670);
        int hashCode = (this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31);
        zzi zzi = this.zzga;
        int hashCode2 = ((zzi == null ? 0 : zzi.hashCode()) + (hashCode * 31)) * 31;
        if (this.zzhc != null && !this.zzhc.isEmpty()) {
            i2 = this.zzhc.hashCode();
        }
        int i3 = hashCode2 + i2;
        AppMethodBeat.o(100670);
        return i3;
    }

    @Override // com.google.android.gms.internal.wearable.zzt
    public final /* synthetic */ zzt zza(zzk zzk) {
        AppMethodBeat.i(100673);
        while (true) {
            int zzj = zzk.zzj();
            switch (zzj) {
                case 0:
                    AppMethodBeat.o(100673);
                    break;
                case 10:
                    this.name = zzk.readString();
                    break;
                case 18:
                    if (this.zzga == null) {
                        this.zzga = new zzi();
                    }
                    zzk.zza(this.zzga);
                    break;
                default:
                    if (super.zza(zzk, zzj)) {
                        break;
                    } else {
                        AppMethodBeat.o(100673);
                        break;
                    }
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.wearable.zzn, com.google.android.gms.internal.wearable.zzt
    public final void zza(zzl zzl) {
        AppMethodBeat.i(100671);
        zzl.zza(1, this.name);
        if (this.zzga != null) {
            zzl.zza(2, this.zzga);
        }
        super.zza(zzl);
        AppMethodBeat.o(100671);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.wearable.zzn, com.google.android.gms.internal.wearable.zzt
    public final int zzg() {
        AppMethodBeat.i(100672);
        int zzg = super.zzg() + zzl.zzb(1, this.name);
        if (this.zzga != null) {
            zzg += zzl.zzb(2, this.zzga);
        }
        AppMethodBeat.o(100672);
        return zzg;
    }
}
