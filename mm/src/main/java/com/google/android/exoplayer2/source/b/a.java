package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class a implements g {
    private final byte[] bih;
    private final g bxs;
    private final byte[] bxt;
    private CipherInputStream bxu;

    public a(g gVar, byte[] bArr, byte[] bArr2) {
        this.bxs = gVar;
        this.bih = bArr;
        this.bxt = bArr2;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final long a(j jVar) {
        AppMethodBeat.i(62818);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.bih, "AES"), new IvParameterSpec(this.bxt));
                this.bxu = new CipherInputStream(new i(this.bxs, jVar), instance);
                AppMethodBeat.o(62818);
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(62818);
                throw runtimeException;
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            RuntimeException runtimeException2 = new RuntimeException(e3);
            AppMethodBeat.o(62818);
            throw runtimeException2;
        }
    }

    @Override // com.google.android.exoplayer2.h.g
    public final void close() {
        AppMethodBeat.i(62819);
        this.bxu = null;
        this.bxs.close();
        AppMethodBeat.o(62819);
    }

    @Override // com.google.android.exoplayer2.h.g
    public final int read(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(62820);
        com.google.android.exoplayer2.i.a.checkState(this.bxu != null);
        int read = this.bxu.read(bArr, i2, i3);
        if (read < 0) {
            AppMethodBeat.o(62820);
            return -1;
        }
        AppMethodBeat.o(62820);
        return read;
    }

    @Override // com.google.android.exoplayer2.h.g
    public final Uri getUri() {
        AppMethodBeat.i(62821);
        Uri uri = this.bxs.getUri();
        AppMethodBeat.o(62821);
        return uri;
    }
}
