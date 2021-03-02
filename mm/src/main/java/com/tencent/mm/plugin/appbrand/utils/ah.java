package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class ah {
    private int contextStart;
    private int crypt;
    private boolean header = true;
    private byte[] key;
    private byte[] out;
    private int padding;
    private byte[] plain;
    private int pos;
    private int preCrypt;
    private byte[] prePlain;
    private Random random = new Random();

    public ah() {
        AppMethodBeat.i(140861);
        AppMethodBeat.o(140861);
    }

    private static long C(byte[] bArr, int i2) {
        long j2 = 0;
        int i3 = i2 + 4;
        while (i2 < i3) {
            j2 = (j2 << 8) | ((long) (bArr[i2] & 255));
            i2++;
        }
        return j2 & Util.MAX_32BIT_VALUE;
    }

    private byte[] b(byte[] bArr, int i2, byte[] bArr2) {
        int i3;
        int i4 = 0;
        AppMethodBeat.i(140862);
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        byte[] bArr3 = new byte[8];
        if (i2 % 8 != 0 || i2 < 16) {
            AppMethodBeat.o(140862);
            return null;
        }
        this.prePlain = aQ(bArr);
        if (this.prePlain == null) {
            AppMethodBeat.o(140862);
            return null;
        }
        this.pos = this.prePlain[0] & 7;
        int i5 = (i2 - this.pos) - 10;
        if (i5 < 0) {
            AppMethodBeat.o(140862);
            return null;
        }
        for (int i6 = 0; i6 < 8; i6++) {
            bArr3[i6] = 0;
        }
        this.out = new byte[i5];
        this.preCrypt = 0;
        this.crypt = 8;
        this.contextStart = 8;
        this.pos++;
        this.padding = 1;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                this.pos++;
                this.padding++;
            }
            if (this.pos == 8) {
                if (!I(bArr, i2)) {
                    AppMethodBeat.o(140862);
                    return null;
                }
                bArr3 = bArr;
            }
        }
        byte[] bArr4 = bArr3;
        while (i5 != 0) {
            if (this.pos < 8) {
                this.out[i4] = (byte) (bArr4[(this.preCrypt + 0) + this.pos] ^ this.prePlain[this.pos]);
                i3 = i4 + 1;
                this.pos++;
                i5--;
            } else {
                i3 = i4;
            }
            if (this.pos == 8) {
                this.preCrypt = this.crypt - 8;
                if (!I(bArr, i2)) {
                    AppMethodBeat.o(140862);
                    return null;
                }
                i4 = i3;
                bArr4 = bArr;
            } else {
                i4 = i3;
            }
        }
        this.padding = 1;
        byte[] bArr5 = bArr4;
        while (this.padding < 8) {
            if (this.pos < 8) {
                if ((bArr5[(this.preCrypt + 0) + this.pos] ^ this.prePlain[this.pos]) != 0) {
                    AppMethodBeat.o(140862);
                    return null;
                }
                this.pos++;
            }
            if (this.pos == 8) {
                this.preCrypt = this.crypt;
                if (!I(bArr, i2)) {
                    AppMethodBeat.o(140862);
                    return null;
                }
                bArr5 = bArr;
            }
            this.padding++;
        }
        byte[] bArr6 = this.out;
        AppMethodBeat.o(140862);
        return bArr6;
    }

    public final byte[] decrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(140863);
        byte[] b2 = b(bArr, bArr.length, bArr2);
        AppMethodBeat.o(140863);
        return b2;
    }

    private byte[] a(byte[] bArr, int i2, byte[] bArr2) {
        int i3;
        AppMethodBeat.i(140864);
        this.plain = new byte[8];
        this.prePlain = new byte[8];
        this.pos = 1;
        this.padding = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        this.header = true;
        this.pos = (i2 + 10) % 8;
        if (this.pos != 0) {
            this.pos = 8 - this.pos;
        }
        this.out = new byte[(this.pos + i2 + 10)];
        this.plain[0] = (byte) ((this.random.nextInt() & 248) | this.pos);
        for (int i4 = 1; i4 <= this.pos; i4++) {
            this.plain[i4] = (byte) (this.random.nextInt() & 255);
        }
        this.pos++;
        for (int i5 = 0; i5 < 8; i5++) {
            this.prePlain[i5] = 0;
        }
        this.padding = 1;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                byte[] bArr3 = this.plain;
                int i6 = this.pos;
                this.pos = i6 + 1;
                bArr3[i6] = (byte) (this.random.nextInt() & 255);
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        int i7 = 0;
        int i8 = i2;
        while (i8 > 0) {
            if (this.pos < 8) {
                byte[] bArr4 = this.plain;
                int i9 = this.pos;
                this.pos = i9 + 1;
                i3 = i7 + 1;
                bArr4[i9] = bArr[i7];
                i8--;
            } else {
                i3 = i7;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
                i7 = i3;
            } else {
                i7 = i3;
            }
        }
        this.padding = 1;
        while (this.padding <= 7) {
            if (this.pos < 8) {
                byte[] bArr5 = this.plain;
                int i10 = this.pos;
                this.pos = i10 + 1;
                bArr5[i10] = 0;
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        byte[] bArr6 = this.out;
        AppMethodBeat.o(140864);
        return bArr6;
    }

    public final byte[] encrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(140865);
        byte[] a2 = a(bArr, bArr.length, bArr2);
        AppMethodBeat.o(140865);
        return a2;
    }

    private byte[] encipher(byte[] bArr) {
        AppMethodBeat.i(140866);
        int i2 = 16;
        try {
            long C = C(bArr, 0);
            long C2 = C(bArr, 4);
            long C3 = C(this.key, 0);
            long C4 = C(this.key, 4);
            long C5 = C(this.key, 8);
            long C6 = C(this.key, 12);
            long j2 = 0;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    j2 = (j2 + 2654435769L) & Util.MAX_32BIT_VALUE;
                    C = (C + ((((C2 << 4) + C3) ^ (C2 + j2)) ^ ((C2 >>> 5) + C4))) & Util.MAX_32BIT_VALUE;
                    C2 = (C2 + ((((C << 4) + C5) ^ (C + j2)) ^ ((C >>> 5) + C6))) & Util.MAX_32BIT_VALUE;
                    i2 = i3;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) C);
                    dataOutputStream.writeInt((int) C2);
                    dataOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(140866);
                    return byteArray;
                }
            }
        } catch (IOException e2) {
            AppMethodBeat.o(140866);
            return null;
        }
    }

    private byte[] aQ(byte[] bArr) {
        AppMethodBeat.i(140867);
        int i2 = 16;
        try {
            long C = C(bArr, 0);
            long C2 = C(bArr, 4);
            long C3 = C(this.key, 0);
            long C4 = C(this.key, 4);
            long C5 = C(this.key, 8);
            long C6 = C(this.key, 12);
            long j2 = 3816266640L;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    C2 = (C2 - ((((C << 4) + C5) ^ (C + j2)) ^ ((C >>> 5) + C6))) & Util.MAX_32BIT_VALUE;
                    C = (C - ((((C2 << 4) + C3) ^ (C2 + j2)) ^ ((C2 >>> 5) + C4))) & Util.MAX_32BIT_VALUE;
                    j2 = (j2 - 2654435769L) & Util.MAX_32BIT_VALUE;
                    i2 = i3;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) C);
                    dataOutputStream.writeInt((int) C2);
                    dataOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(140867);
                    return byteArray;
                }
            }
        } catch (IOException e2) {
            AppMethodBeat.o(140867);
            return null;
        }
    }

    private void encrypt8Bytes() {
        AppMethodBeat.i(140868);
        this.pos = 0;
        while (this.pos < 8) {
            if (this.header) {
                byte[] bArr = this.plain;
                int i2 = this.pos;
                bArr[i2] = (byte) (bArr[i2] ^ this.prePlain[this.pos]);
            } else {
                byte[] bArr2 = this.plain;
                int i3 = this.pos;
                bArr2[i3] = (byte) (bArr2[i3] ^ this.out[this.preCrypt + this.pos]);
            }
            this.pos++;
        }
        System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
        this.pos = 0;
        while (this.pos < 8) {
            byte[] bArr3 = this.out;
            int i4 = this.crypt + this.pos;
            bArr3[i4] = (byte) (bArr3[i4] ^ this.prePlain[this.pos]);
            this.pos++;
        }
        System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
        this.preCrypt = this.crypt;
        this.crypt += 8;
        this.pos = 0;
        this.header = false;
        AppMethodBeat.o(140868);
    }

    private boolean I(byte[] bArr, int i2) {
        AppMethodBeat.i(140869);
        this.pos = 0;
        while (this.pos < 8) {
            if (this.contextStart + this.pos >= i2) {
                AppMethodBeat.o(140869);
                return true;
            }
            byte[] bArr2 = this.prePlain;
            int i3 = this.pos;
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.crypt + 0) + this.pos]);
            this.pos++;
        }
        this.prePlain = aQ(this.prePlain);
        if (this.prePlain == null) {
            AppMethodBeat.o(140869);
            return false;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        AppMethodBeat.o(140869);
        return true;
    }
}
