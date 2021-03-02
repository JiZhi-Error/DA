package oicq.wlogin_sdk.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static byte[] a(byte[] bArr, int i2, byte[] bArr2) {
        int i3;
        AppMethodBeat.i(88196);
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, 0, bArr3, 0, i2);
        a aVar = new a();
        int length = bArr3.length;
        aVar.plain = new byte[8];
        aVar.prePlain = new byte[8];
        aVar.pos = 1;
        aVar.padding = 0;
        aVar.preCrypt = 0;
        aVar.crypt = 0;
        aVar.key = bArr2;
        aVar.header = true;
        aVar.pos = (length + 10) % 8;
        if (aVar.pos != 0) {
            aVar.pos = 8 - aVar.pos;
        }
        aVar.out = new byte[(aVar.pos + length + 10)];
        aVar.plain[0] = (byte) ((aVar.random.nextInt() & 248) | aVar.pos);
        for (int i4 = 1; i4 <= aVar.pos; i4++) {
            aVar.plain[i4] = (byte) (aVar.random.nextInt() & 255);
        }
        aVar.pos++;
        for (int i5 = 0; i5 < 8; i5++) {
            aVar.prePlain[i5] = 0;
        }
        aVar.padding = 1;
        while (aVar.padding <= 2) {
            if (aVar.pos < 8) {
                byte[] bArr4 = aVar.plain;
                int i6 = aVar.pos;
                aVar.pos = i6 + 1;
                bArr4[i6] = (byte) (aVar.random.nextInt() & 255);
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
        }
        int i7 = 0;
        while (length > 0) {
            if (aVar.pos < 8) {
                byte[] bArr5 = aVar.plain;
                int i8 = aVar.pos;
                aVar.pos = i8 + 1;
                i3 = i7 + 1;
                bArr5[i8] = bArr3[i7];
                length--;
            } else {
                i3 = i7;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
            i7 = i3;
        }
        aVar.padding = 1;
        while (aVar.padding <= 7) {
            if (aVar.pos < 8) {
                byte[] bArr6 = aVar.plain;
                int i9 = aVar.pos;
                aVar.pos = i9 + 1;
                bArr6[i9] = 0;
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                aVar.encrypt8Bytes();
            }
        }
        byte[] bArr7 = aVar.out;
        AppMethodBeat.o(88196);
        return bArr7;
    }

    public static byte[] decrypt(byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4;
        AppMethodBeat.i(88197);
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr, i2, bArr3, 0, i3);
        a aVar = new a();
        int length = bArr3.length;
        aVar.preCrypt = 0;
        aVar.crypt = 0;
        aVar.key = bArr2;
        byte[] bArr4 = new byte[8];
        if (length % 8 != 0 || length < 16) {
            AppMethodBeat.o(88197);
            return null;
        }
        aVar.prePlain = aVar.aQ(bArr3);
        aVar.pos = aVar.prePlain[0] & 7;
        int i5 = (length - aVar.pos) - 10;
        if (i5 < 0) {
            AppMethodBeat.o(88197);
            return null;
        }
        for (int i6 = 0; i6 < 8; i6++) {
            bArr4[i6] = 0;
        }
        aVar.out = new byte[i5];
        aVar.preCrypt = 0;
        aVar.crypt = 8;
        aVar.contextStart = 8;
        aVar.pos++;
        aVar.padding = 1;
        while (aVar.padding <= 2) {
            if (aVar.pos < 8) {
                aVar.pos++;
                aVar.padding++;
            }
            if (aVar.pos == 8) {
                if (!aVar.I(bArr3, length)) {
                    AppMethodBeat.o(88197);
                    return null;
                }
                bArr4 = bArr3;
            }
        }
        int i7 = 0;
        byte[] bArr5 = bArr4;
        while (i5 != 0) {
            if (aVar.pos < 8) {
                aVar.out[i7] = (byte) (bArr5[(aVar.preCrypt + 0) + aVar.pos] ^ aVar.prePlain[aVar.pos]);
                i4 = i7 + 1;
                aVar.pos++;
                i5--;
            } else {
                i4 = i7;
            }
            if (aVar.pos == 8) {
                aVar.preCrypt = aVar.crypt - 8;
                if (!aVar.I(bArr3, length)) {
                    AppMethodBeat.o(88197);
                    return null;
                }
                i7 = i4;
                bArr5 = bArr3;
            } else {
                i7 = i4;
            }
        }
        aVar.padding = 1;
        byte[] bArr6 = bArr5;
        while (aVar.padding < 8) {
            if (aVar.pos < 8) {
                if ((bArr6[(aVar.preCrypt + 0) + aVar.pos] ^ aVar.prePlain[aVar.pos]) != 0) {
                    AppMethodBeat.o(88197);
                    return null;
                }
                aVar.pos++;
            }
            if (aVar.pos == 8) {
                aVar.preCrypt = aVar.crypt;
                if (!aVar.I(bArr3, length)) {
                    AppMethodBeat.o(88197);
                    return null;
                }
                bArr6 = bArr3;
            }
            aVar.padding++;
        }
        byte[] bArr7 = aVar.out;
        AppMethodBeat.o(88197);
        return bArr7;
    }
}
