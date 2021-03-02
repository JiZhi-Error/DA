package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.util.StringTokenizer;

public final class HexDumpUtils {
    public static byte[] bytesFromString(String str) {
        AppMethodBeat.i(5232);
        StringTokenizer stringTokenizer = new StringTokenizer(str, " \t\n");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (stringTokenizer.hasMoreTokens()) {
            try {
                byteArrayOutputStream.write(Integer.parseInt(stringTokenizer.nextToken(), 16) & 255);
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(5232);
                return null;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(5232);
        return byteArray;
    }

    public static String dump(byte[] bArr, int i2, int i3, boolean z) {
        AppMethodBeat.i(5231);
        if (bArr == null || bArr.length == 0 || i2 < 0 || i3 <= 0 || i2 + i3 > bArr.length) {
            AppMethodBeat.o(5231);
            return null;
        }
        int i4 = 57;
        if (z) {
            i4 = 75;
        }
        StringBuilder sb = new StringBuilder(i4 * (((i3 + 16) - 1) / 16));
        int i5 = 0;
        int i6 = 0;
        int i7 = i3;
        int i8 = i2;
        while (i7 > 0) {
            if (i5 == 0) {
                if (i3 < 65536) {
                    sb.append(String.format("%04X:", Integer.valueOf(i8)));
                    i6 = i8;
                } else {
                    sb.append(String.format("%08X:", Integer.valueOf(i8)));
                    i6 = i8;
                }
            } else if (i5 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i8] & 255)));
            int i9 = i7 - 1;
            int i10 = i5 + 1;
            if (z && (i10 == 16 || i9 == 0)) {
                int i11 = 16 - i10;
                if (i11 > 0) {
                    for (int i12 = 0; i12 < i11; i12++) {
                        sb.append("   ");
                    }
                }
                if (i11 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i13 = 0; i13 < i10; i13++) {
                    char c2 = (char) bArr[i6 + i13];
                    if (c2 < ' ' || c2 > '~') {
                        c2 = '.';
                    }
                    sb.append(c2);
                }
            }
            if (i10 == 16 || i9 == 0) {
                sb.append('\n');
                i5 = 0;
            } else {
                i5 = i10;
            }
            i8++;
            i7 = i9;
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(5231);
        return sb2;
    }
}
