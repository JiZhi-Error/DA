package com.tencent.mm.audio.mix.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c {
    protected static ThreadLocal<MessageDigest> TLS_digest = new ThreadLocal<MessageDigest>() {
        /* class com.tencent.mm.audio.mix.i.c.AnonymousClass1 */

        private static MessageDigest initialValue() {
            AppMethodBeat.i(136968);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                AppMethodBeat.o(136968);
                return instance;
            } catch (NoSuchAlgorithmException e2) {
                RuntimeException runtimeException = new RuntimeException("Initialize MD5 failed.", e2);
                AppMethodBeat.o(136968);
                throw runtimeException;
            }
        }
    };
    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        AppMethodBeat.i(136971);
        AppMethodBeat.o(136971);
    }

    @Deprecated
    public static String getMD5String(String str) {
        AppMethodBeat.i(136970);
        byte[] digest = TLS_digest.get().digest(str.getBytes());
        int length = digest.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i2 = length + 0;
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = digest[i3];
            char c2 = hexDigits[(b2 & 240) >> 4];
            char c3 = hexDigits[b2 & 15];
            stringBuffer.append(c2);
            stringBuffer.append(c3);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(136970);
        return stringBuffer2;
    }
}
