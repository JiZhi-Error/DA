package com.tencent.e.e.b.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class a {
    public static byte[] cT(byte[] bArr) {
        AppMethodBeat.i(138448);
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(new String(b.ajV("4D4435")));
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (NoSuchAlgorithmException e2) {
        }
        AppMethodBeat.o(138448);
        return bArr2;
    }
}
