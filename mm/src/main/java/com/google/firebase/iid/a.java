package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public final class a {
    public static KeyPair ym() {
        AppMethodBeat.i(4149);
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(EncryptUtil.KEY_ALGORITHM);
            instance.initialize(2048);
            KeyPair generateKeyPair = instance.generateKeyPair();
            AppMethodBeat.o(4149);
            return generateKeyPair;
        } catch (NoSuchAlgorithmException e2) {
            AssertionError assertionError = new AssertionError(e2);
            AppMethodBeat.o(4149);
            throw assertionError;
        }
    }
}
