package com.tencent.magicbrush.handler;

import android.support.annotation.Keep;
import com.tencent.magicbrush.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

@Keep
public class MBCharsetHandler {
    private static final String TAG = "MicroMsg.MBCharsetHandler";

    @Keep
    public static byte[] encode(String str, String str2) {
        byte[] bArr = null;
        AppMethodBeat.i(139996);
        if (str == null) {
            AppMethodBeat.o(139996);
        } else {
            try {
                bArr = str.getBytes(str2);
            } catch (UnsupportedEncodingException e2) {
                c.C0193c.e(TAG, "MBCharsetHandler encode failed. [%s]", e2);
            }
            AppMethodBeat.o(139996);
        }
        return bArr;
    }

    @Keep
    static String decode(byte[] bArr, String str) {
        String str2;
        AppMethodBeat.i(139997);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(139997);
            return null;
        }
        try {
            str2 = new String(bArr, str);
        } catch (UnsupportedEncodingException e2) {
            c.C0193c.e(TAG, "UnsupportedDecoding [%s] [%s]", str, e2);
            str2 = null;
        }
        AppMethodBeat.o(139997);
        return str2;
    }
}
