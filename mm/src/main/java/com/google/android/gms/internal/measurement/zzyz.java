package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzyz extends zzzc {
    private final int zzbra;
    private final int zzbrb;

    zzyz(byte[] bArr, int i2, int i3) {
        super(bArr);
        AppMethodBeat.i(40342);
        zzb(i2, i2 + i3, bArr.length);
        this.zzbra = i2;
        this.zzbrb = i3;
        AppMethodBeat.o(40342);
    }

    @Override // com.google.android.gms.internal.measurement.zzyw, com.google.android.gms.internal.measurement.zzzc
    public final int size() {
        return this.zzbrb;
    }

    @Override // com.google.android.gms.internal.measurement.zzyw, com.google.android.gms.internal.measurement.zzzc
    public final byte zzae(int i2) {
        AppMethodBeat.i(40343);
        int size = size();
        if (((size - (i2 + 1)) | i2) >= 0) {
            byte b2 = this.zzbrc[this.zzbra + i2];
            AppMethodBeat.o(40343);
            return b2;
        } else if (i2 < 0) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(i2).toString());
            AppMethodBeat.o(40343);
            throw arrayIndexOutOfBoundsException;
        } else {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(i2).append(", ").append(size).toString());
            AppMethodBeat.o(40343);
            throw arrayIndexOutOfBoundsException2;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzzc
    public final int zzsy() {
        return this.zzbra;
    }
}
