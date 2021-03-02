package com.tencent.e.e.b.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class b {
    public static String cU(byte[] bArr) {
        AppMethodBeat.i(138449);
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase(Locale.getDefault()));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(138449);
        return stringBuffer2;
    }

    public static byte[] ajV(String str) {
        AppMethodBeat.i(138450);
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = Integer.valueOf(str.substring(i2 * 2, (i2 * 2) + 2), 16).byteValue();
        }
        AppMethodBeat.o(138450);
        return bArr;
    }
}
