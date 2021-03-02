package com.google.android.gms.common;

import com.google.android.gms.common.GoogleCertificates;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class zzb extends GoogleCertificates.CertData {
    private final byte[] zzbd;

    zzb(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        AppMethodBeat.i(5352);
        this.zzbd = bArr;
        AppMethodBeat.o(5352);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.GoogleCertificates.CertData
    public final byte[] getBytes() {
        return this.zzbd;
    }
}
