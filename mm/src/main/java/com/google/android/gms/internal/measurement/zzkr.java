package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class zzkr extends zzaby<zzkr> {
    public long[] zzauk = zzach.zzbxm;
    public long[] zzaul = zzach.zzbxm;

    public zzkr() {
        AppMethodBeat.i(2254);
        this.zzbww = null;
        this.zzbxh = -1;
        AppMethodBeat.o(2254);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2255);
        if (obj == this) {
            AppMethodBeat.o(2255);
            return true;
        } else if (!(obj instanceof zzkr)) {
            AppMethodBeat.o(2255);
            return false;
        } else {
            zzkr zzkr = (zzkr) obj;
            if (!zzacc.equals(this.zzauk, zzkr.zzauk)) {
                AppMethodBeat.o(2255);
                return false;
            } else if (!zzacc.equals(this.zzaul, zzkr.zzaul)) {
                AppMethodBeat.o(2255);
                return false;
            } else if (this.zzbww != null && !this.zzbww.isEmpty()) {
                boolean equals = this.zzbww.equals(zzkr.zzbww);
                AppMethodBeat.o(2255);
                return equals;
            } else if (zzkr.zzbww == null || zzkr.zzbww.isEmpty()) {
                AppMethodBeat.o(2255);
                return true;
            } else {
                AppMethodBeat.o(2255);
                return false;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(2256);
        int hashCode = ((this.zzbww == null || this.zzbww.isEmpty()) ? 0 : this.zzbww.hashCode()) + ((((((getClass().getName().hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + zzacc.hashCode(this.zzauk)) * 31) + zzacc.hashCode(this.zzaul)) * 31);
        AppMethodBeat.o(2256);
        return hashCode;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final int zza() {
        int i2;
        AppMethodBeat.i(2258);
        int zza = super.zza();
        if (this.zzauk == null || this.zzauk.length <= 0) {
            i2 = zza;
        } else {
            int i3 = 0;
            for (int i4 = 0; i4 < this.zzauk.length; i4++) {
                i3 += zzabw.zzao(this.zzauk[i4]);
            }
            i2 = zza + i3 + (this.zzauk.length * 1);
        }
        if (this.zzaul != null && this.zzaul.length > 0) {
            int i5 = 0;
            for (int i6 = 0; i6 < this.zzaul.length; i6++) {
                i5 += zzabw.zzao(this.zzaul[i6]);
            }
            i2 = i2 + i5 + (this.zzaul.length * 1);
        }
        AppMethodBeat.o(2258);
        return i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzaby, com.google.android.gms.internal.measurement.zzace
    public final void zza(zzabw zzabw) {
        AppMethodBeat.i(2257);
        if (this.zzauk != null && this.zzauk.length > 0) {
            for (int i2 = 0; i2 < this.zzauk.length; i2++) {
                zzabw.zza(1, this.zzauk[i2]);
            }
        }
        if (this.zzaul != null && this.zzaul.length > 0) {
            for (int i3 = 0; i3 < this.zzaul.length; i3++) {
                zzabw.zza(2, this.zzaul[i3]);
            }
        }
        super.zza(zzabw);
        AppMethodBeat.o(2257);
    }

    @Override // com.google.android.gms.internal.measurement.zzace
    public final /* synthetic */ zzace zzb(zzabv zzabv) {
        AppMethodBeat.i(2259);
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    AppMethodBeat.o(2259);
                    break;
                case 8:
                    int zzb = zzach.zzb(zzabv, 8);
                    int length = this.zzauk == null ? 0 : this.zzauk.length;
                    long[] jArr = new long[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzauk, 0, jArr, 0, length);
                    }
                    while (length < jArr.length - 1) {
                        jArr[length] = zzabv.zzuz();
                        zzabv.zzuw();
                        length++;
                    }
                    jArr[length] = zzabv.zzuz();
                    this.zzauk = jArr;
                    break;
                case 10:
                    int zzaf = zzabv.zzaf(zzabv.zzuy());
                    int position = zzabv.getPosition();
                    int i2 = 0;
                    while (zzabv.zzvc() > 0) {
                        zzabv.zzuz();
                        i2++;
                    }
                    zzabv.zzam(position);
                    int length2 = this.zzauk == null ? 0 : this.zzauk.length;
                    long[] jArr2 = new long[(i2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzauk, 0, jArr2, 0, length2);
                    }
                    while (length2 < jArr2.length) {
                        jArr2[length2] = zzabv.zzuz();
                        length2++;
                    }
                    this.zzauk = jArr2;
                    zzabv.zzal(zzaf);
                    break;
                case 16:
                    int zzb2 = zzach.zzb(zzabv, 16);
                    int length3 = this.zzaul == null ? 0 : this.zzaul.length;
                    long[] jArr3 = new long[(zzb2 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzaul, 0, jArr3, 0, length3);
                    }
                    while (length3 < jArr3.length - 1) {
                        jArr3[length3] = zzabv.zzuz();
                        zzabv.zzuw();
                        length3++;
                    }
                    jArr3[length3] = zzabv.zzuz();
                    this.zzaul = jArr3;
                    break;
                case 18:
                    int zzaf2 = zzabv.zzaf(zzabv.zzuy());
                    int position2 = zzabv.getPosition();
                    int i3 = 0;
                    while (zzabv.zzvc() > 0) {
                        zzabv.zzuz();
                        i3++;
                    }
                    zzabv.zzam(position2);
                    int length4 = this.zzaul == null ? 0 : this.zzaul.length;
                    long[] jArr4 = new long[(i3 + length4)];
                    if (length4 != 0) {
                        System.arraycopy(this.zzaul, 0, jArr4, 0, length4);
                    }
                    while (length4 < jArr4.length) {
                        jArr4[length4] = zzabv.zzuz();
                        length4++;
                    }
                    this.zzaul = jArr4;
                    zzabv.zzal(zzaf2);
                    break;
                default:
                    if (super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        AppMethodBeat.o(2259);
                        break;
                    }
            }
        }
        return this;
    }
}
