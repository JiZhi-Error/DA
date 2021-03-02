package com.tencent.midas.comm;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class APMD5 {
    public static String toMd5(byte[] bArr) {
        AppMethodBeat.i(193228);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            String parseByte2HexStr = parseByte2HexStr(instance.digest());
            AppMethodBeat.o(193228);
            return parseByte2HexStr;
        } catch (NoSuchAlgorithmException e2) {
            AppMethodBeat.o(193228);
            return null;
        }
    }

    public static String parseByte2HexStr(byte[] bArr) {
        AppMethodBeat.i(193229);
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(193229);
        return stringBuffer2;
    }
}
