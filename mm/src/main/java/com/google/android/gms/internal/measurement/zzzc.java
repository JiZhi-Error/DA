package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class zzzc extends zzzb {
    protected final byte[] zzbrc;

    zzzc(byte[] bArr) {
        this.zzbrc = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzyw
    public final boolean equals(Object obj) {
        AppMethodBeat.i(40345);
        if (obj == this) {
            AppMethodBeat.o(40345);
            return true;
        } else if (!(obj instanceof zzyw)) {
            AppMethodBeat.o(40345);
            return false;
        } else if (size() != ((zzyw) obj).size()) {
            AppMethodBeat.o(40345);
            return false;
        } else if (size() == 0) {
            AppMethodBeat.o(40345);
            return true;
        } else if (obj instanceof zzzc) {
            int zzsx = zzsx();
            int zzsx2 = ((zzzc) obj).zzsx();
            if (zzsx == 0 || zzsx2 == 0 || zzsx == zzsx2) {
                boolean zza = zza((zzzc) obj, 0, size());
                AppMethodBeat.o(40345);
                return zza;
            }
            AppMethodBeat.o(40345);
            return false;
        } else {
            boolean equals = obj.equals(this);
            AppMethodBeat.o(40345);
            return equals;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzyw
    public int size() {
        return this.zzbrc.length;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyw
    public final int zza(int i2, int i3, int i4) {
        AppMethodBeat.i(40347);
        int zza = zzzr.zza(i2, this.zzbrc, zzsy(), i4);
        AppMethodBeat.o(40347);
        return zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzzb
    public final boolean zza(zzyw zzyw, int i2, int i3) {
        AppMethodBeat.i(40346);
        if (i3 > zzyw.size()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i3).append(size()).toString());
            AppMethodBeat.o(40346);
            throw illegalArgumentException;
        } else if (i3 > zzyw.size()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: 0, ").append(i3).append(", ").append(zzyw.size()).toString());
            AppMethodBeat.o(40346);
            throw illegalArgumentException2;
        } else if (zzyw instanceof zzzc) {
            zzzc zzzc = (zzzc) zzyw;
            byte[] bArr = this.zzbrc;
            byte[] bArr2 = zzzc.zzbrc;
            int zzsy = zzsy() + i3;
            int zzsy2 = zzsy();
            int zzsy3 = zzzc.zzsy();
            while (zzsy2 < zzsy) {
                if (bArr[zzsy2] != bArr2[zzsy3]) {
                    AppMethodBeat.o(40346);
                    return false;
                }
                zzsy2++;
                zzsy3++;
            }
            AppMethodBeat.o(40346);
            return true;
        } else {
            boolean equals = zzyw.zzb(0, i3).equals(zzb(0, i3));
            AppMethodBeat.o(40346);
            return equals;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzyw
    public byte zzae(int i2) {
        return this.zzbrc[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzyw
    public final zzyw zzb(int i2, int i3) {
        AppMethodBeat.i(40344);
        int zzb = zzb(0, i3, size());
        if (zzb == 0) {
            zzyw zzyw = zzyw.zzbqx;
            AppMethodBeat.o(40344);
            return zzyw;
        }
        zzyz zzyz = new zzyz(this.zzbrc, zzsy(), zzb);
        AppMethodBeat.o(40344);
        return zzyz;
    }

    /* access modifiers changed from: protected */
    public int zzsy() {
        return 0;
    }
}
