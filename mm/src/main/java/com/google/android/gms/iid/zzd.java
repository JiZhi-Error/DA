package com.google.android.gms.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public final class zzd {
    public static KeyPair zzk() {
        AppMethodBeat.i(2516);
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(EncryptUtil.KEY_ALGORITHM);
            instance.initialize(2048);
            KeyPair generateKeyPair = instance.generateKeyPair();
            AppMethodBeat.o(2516);
            return generateKeyPair;
        } catch (NoSuchAlgorithmException e2) {
            AssertionError assertionError = new AssertionError(e2);
            AppMethodBeat.o(2516);
            throw assertionError;
        }
    }
}
