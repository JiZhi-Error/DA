package kotlinx.a.c.a;

import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    private static final byte[] Uan;

    static {
        byte[] bArr = new byte[126];
        for (int i2 = 0; i2 <= 32; i2++) {
            bArr[i2] = JceStruct.STRUCT_END;
        }
        bArr[9] = 3;
        bArr[10] = 3;
        bArr[13] = 3;
        bArr[32] = 3;
        bArr[44] = 4;
        bArr[58] = 5;
        bArr[123] = 6;
        bArr[125] = 7;
        bArr[91] = 8;
        bArr[93] = 9;
        bArr[34] = 1;
        bArr[92] = 2;
        Uan = bArr;
    }

    public static final byte G(char c2) {
        if (c2 < '~') {
            return Uan[c2];
        }
        return 0;
    }

    public static final char awf(int i2) {
        if (i2 < 117) {
            return c.Uah[i2];
        }
        return 0;
    }

    public static final /* synthetic */ boolean o(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(225713);
        int length = str2.length();
        if (i3 != length) {
            AppMethodBeat.o(225713);
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i2 + i4) != str2.charAt(i4)) {
                AppMethodBeat.o(225713);
                return false;
            }
        }
        AppMethodBeat.o(225713);
        return true;
    }
}
