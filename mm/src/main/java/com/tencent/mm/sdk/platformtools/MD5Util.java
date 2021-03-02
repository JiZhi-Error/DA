package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    protected static ThreadLocal<MessageDigest> TLS_digest = new ThreadLocal<MessageDigest>() {
        /* class com.tencent.mm.sdk.platformtools.MD5Util.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public final MessageDigest initialValue() {
            AppMethodBeat.i(157608);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                AppMethodBeat.o(157608);
                return instance;
            } catch (NoSuchAlgorithmException e2) {
                RuntimeException runtimeException = new RuntimeException("Initialize MD5 failed.", e2);
                AppMethodBeat.o(157608);
                throw runtimeException;
            }
        }
    };
    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        AppMethodBeat.i(157614);
        AppMethodBeat.o(157614);
    }

    public static String getMD5String(String str) {
        AppMethodBeat.i(157610);
        String mD5String = getMD5String(str.getBytes());
        AppMethodBeat.o(157610);
        return mD5String;
    }

    public static String getMD5String(byte[] bArr) {
        AppMethodBeat.i(157611);
        String bufferToHex = bufferToHex(TLS_digest.get().digest(bArr));
        AppMethodBeat.o(157611);
        return bufferToHex;
    }

    private static String bufferToHex(byte[] bArr) {
        AppMethodBeat.i(230333);
        String bufferToHex = bufferToHex(bArr, 0, bArr.length);
        AppMethodBeat.o(230333);
        return bufferToHex;
    }

    private static String bufferToHex(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(230334);
        StringBuffer stringBuffer = new StringBuffer(i3 * 2);
        int i4 = i2 + i3;
        while (i2 < i4) {
            appendHexPair(bArr[i2], stringBuffer);
            i2++;
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(230334);
        return stringBuffer2;
    }

    private static void appendHexPair(byte b2, StringBuffer stringBuffer) {
        AppMethodBeat.i(157613);
        char c2 = hexDigits[(b2 & 240) >> 4];
        char c3 = hexDigits[b2 & 15];
        stringBuffer.append(c2);
        stringBuffer.append(c3);
        AppMethodBeat.o(157613);
    }

    public static boolean checkPassword(String str, String str2) {
        AppMethodBeat.i(230335);
        boolean equals = getMD5String(str).equals(str2);
        AppMethodBeat.o(230335);
        return equals;
    }

    @Deprecated
    public static String getFileMD5String(o oVar) {
        AppMethodBeat.i(230332);
        String a2 = g.a(oVar, ShareConstants.MD5_FILE_BUF_LENGTH);
        AppMethodBeat.o(230332);
        return a2;
    }
}
