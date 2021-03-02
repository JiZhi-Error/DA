package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzg extends zzn<zzg> {
    public zzh[] zzfy = zzh.zzh();

    public zzg() {
        AppMethodBeat.i(100661);
        this.zzhc = null;
        this.zzhl = -1;
        AppMethodBeat.o(100661);
    }

    public static zzg zza(byte[] bArr) {
        AppMethodBeat.i(100666);
        zzg zzg = (zzg) zzt.zza(new zzg(), bArr, 0, bArr.length);
        AppMethodBeat.o(100666);
        return zzg;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100662);
        if (obj == this) {
            AppMethodBeat.o(100662);
            return true;
        } else if (!(obj instanceof zzg)) {
            AppMethodBeat.o(100662);
            return false;
        } else {
            zzg zzg = (zzg) obj;
            if (!zzr.equals(this.zzfy, zzg.zzfy)) {
                AppMethodBeat.o(100662);
                return false;
            } else if (this.zzhc != null && !this.zzhc.isEmpty()) {
                boolean equals = this.zzhc.equals(zzg.zzhc);
                AppMethodBeat.o(100662);
                return equals;
            } else if (zzg.zzhc == null || zzg.zzhc.isEmpty()) {
                AppMethodBeat.o(100662);
                return true;
            } else {
                AppMethodBeat.o(100662);
                return false;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(100663);
        int hashCode = ((this.zzhc == null || this.zzhc.isEmpty()) ? 0 : this.zzhc.hashCode()) + ((((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + zzr.hashCode(this.zzfy)) * 31);
        AppMethodBeat.o(100663);
        return hashCode;
    }

    @Override // com.google.android.gms.internal.wearable.zzt
    public final /* synthetic */ zzt zza(zzk zzk) {
        AppMethodBeat.i(100667);
        while (true) {
            int zzj = zzk.zzj();
            switch (zzj) {
                case 0:
                    AppMethodBeat.o(100667);
                    break;
                case 10:
                    int zzb = zzw.zzb(zzk, 10);
                    int length = this.zzfy == null ? 0 : this.zzfy.length;
                    zzh[] zzhArr = new zzh[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzfy, 0, zzhArr, 0, length);
                    }
                    while (length < zzhArr.length - 1) {
                        zzhArr[length] = new zzh();
                        zzk.zza(zzhArr[length]);
                        zzk.zzj();
                        length++;
                    }
                    zzhArr[length] = new zzh();
                    zzk.zza(zzhArr[length]);
                    this.zzfy = zzhArr;
                    break;
                default:
                    if (super.zza(zzk, zzj)) {
                        break;
                    } else {
                        AppMethodBeat.o(100667);
                        break;
                    }
            }
        }
        return this;
    }

    @Override // com.google.android.gms.internal.wearable.zzn, com.google.android.gms.internal.wearable.zzt
    public final void zza(zzl zzl) {
        AppMethodBeat.i(100664);
        if (this.zzfy != null && this.zzfy.length > 0) {
            for (int i2 = 0; i2 < this.zzfy.length; i2++) {
                zzh zzh = this.zzfy[i2];
                if (zzh != null) {
                    zzl.zza(1, zzh);
                }
            }
        }
        super.zza(zzl);
        AppMethodBeat.o(100664);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.wearable.zzn, com.google.android.gms.internal.wearable.zzt
    public final int zzg() {
        AppMethodBeat.i(100665);
        int zzg = super.zzg();
        if (this.zzfy != null && this.zzfy.length > 0) {
            for (int i2 = 0; i2 < this.zzfy.length; i2++) {
                zzh zzh = this.zzfy[i2];
                if (zzh != null) {
                    zzg += zzl.zzb(1, zzh);
                }
            }
        }
        AppMethodBeat.o(100665);
        return zzg;
    }
}
