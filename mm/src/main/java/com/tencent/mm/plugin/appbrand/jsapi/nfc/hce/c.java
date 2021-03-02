package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static String aL(byte[] bArr) {
        AppMethodBeat.i(136183);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(136183);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            int i2 = b2 & 15;
            int i3 = i2 + (i2 < 10 ? 48 : 55);
            int i4 = (b2 & 240) >> 4;
            sb.append((i4 < 10 ? 48 : 55) + i4);
            sb.append(i3);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(136183);
        return sb2;
    }
}
