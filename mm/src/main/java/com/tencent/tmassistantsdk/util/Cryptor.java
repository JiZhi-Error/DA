package com.tencent.tmassistantsdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class Cryptor {
    protected int contextStart;
    protected int crypt;
    protected boolean header = true;
    protected byte[] key;
    protected byte[] out;
    protected int padding;
    protected byte[] plain;
    protected int pos;
    protected int preCrypt;
    protected byte[] prePlain;
    protected Random random = new Random();

    public Cryptor() {
        AppMethodBeat.i(102470);
        AppMethodBeat.o(102470);
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(102471);
        byte[] decrypt = decrypt(bArr, 0, bArr.length, bArr2);
        AppMethodBeat.o(102471);
        return decrypt;
    }

    public byte[] decrypt(byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4;
        AppMethodBeat.i(102472);
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        byte[] bArr3 = new byte[(i2 + 8)];
        if (i3 % 8 != 0 || i3 < 16) {
            AppMethodBeat.o(102472);
            return null;
        }
        this.prePlain = decipher(bArr, i2);
        this.pos = this.prePlain[0] & 7;
        int i5 = (i3 - this.pos) - 10;
        if (i5 < 0) {
            AppMethodBeat.o(102472);
            return null;
        }
        for (int i6 = i2; i6 < bArr3.length; i6++) {
            bArr3[i6] = 0;
        }
        this.out = new byte[i5];
        this.preCrypt = 0;
        this.crypt = 8;
        this.contextStart = 8;
        this.pos++;
        this.padding = 1;
        byte[] bArr4 = bArr3;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                this.pos++;
                this.padding++;
            }
            if (this.pos == 8) {
                if (!decrypt8Bytes(bArr, i2, i3)) {
                    AppMethodBeat.o(102472);
                    return null;
                }
                bArr4 = bArr;
            }
        }
        int i7 = 0;
        byte[] bArr5 = bArr4;
        while (i5 != 0) {
            if (this.pos < 8) {
                this.out[i7] = (byte) (bArr5[(this.preCrypt + i2) + this.pos] ^ this.prePlain[this.pos]);
                i4 = i7 + 1;
                this.pos++;
                i5--;
            } else {
                i4 = i7;
            }
            if (this.pos == 8) {
                this.preCrypt = this.crypt - 8;
                if (!decrypt8Bytes(bArr, i2, i3)) {
                    AppMethodBeat.o(102472);
                    return null;
                }
                i7 = i4;
                bArr5 = bArr;
            } else {
                i7 = i4;
            }
        }
        this.padding = 1;
        byte[] bArr6 = bArr5;
        while (this.padding < 8) {
            if (this.pos < 8) {
                if ((bArr6[(this.preCrypt + i2) + this.pos] ^ this.prePlain[this.pos]) != 0) {
                    AppMethodBeat.o(102472);
                    return null;
                }
                this.pos++;
            }
            if (this.pos == 8) {
                this.preCrypt = this.crypt;
                if (!decrypt8Bytes(bArr, i2, i3)) {
                    AppMethodBeat.o(102472);
                    return null;
                }
                bArr6 = bArr;
            }
            this.padding++;
        }
        byte[] bArr7 = this.out;
        AppMethodBeat.o(102472);
        return bArr7;
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(102473);
        byte[] encrypt = encrypt(bArr, 0, bArr.length, bArr2);
        AppMethodBeat.o(102473);
        return encrypt;
    }

    public byte[] encrypt(byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4;
        AppMethodBeat.i(102474);
        this.plain = new byte[8];
        this.prePlain = new byte[8];
        this.pos = 1;
        this.padding = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        this.header = true;
        this.pos = (i3 + 10) % 8;
        if (this.pos != 0) {
            this.pos = 8 - this.pos;
        }
        this.out = new byte[(this.pos + i3 + 10)];
        this.plain[0] = (byte) ((rand() & 248) | this.pos);
        for (int i5 = 1; i5 <= this.pos; i5++) {
            this.plain[i5] = (byte) (rand() & 255);
        }
        this.pos++;
        for (int i6 = 0; i6 < 8; i6++) {
            this.prePlain[i6] = 0;
        }
        this.padding = 1;
        while (this.padding <= 2) {
            if (this.pos < 8) {
                byte[] bArr3 = this.plain;
                int i7 = this.pos;
                this.pos = i7 + 1;
                bArr3[i7] = (byte) (rand() & 255);
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        int i8 = i2;
        int i9 = i3;
        while (i9 > 0) {
            if (this.pos < 8) {
                byte[] bArr4 = this.plain;
                int i10 = this.pos;
                this.pos = i10 + 1;
                i4 = i8 + 1;
                bArr4[i10] = bArr[i8];
                i9--;
            } else {
                i4 = i8;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
                i8 = i4;
            } else {
                i8 = i4;
            }
        }
        this.padding = 1;
        while (this.padding <= 7) {
            if (this.pos < 8) {
                byte[] bArr5 = this.plain;
                int i11 = this.pos;
                this.pos = i11 + 1;
                bArr5[i11] = 0;
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        byte[] bArr6 = this.out;
        AppMethodBeat.o(102474);
        return bArr6;
    }

    private byte[] encipher(byte[] bArr) {
        AppMethodBeat.i(102475);
        int i2 = 16;
        try {
            long unsignedInt = getUnsignedInt(bArr, 0, 4);
            long unsignedInt2 = getUnsignedInt(bArr, 4, 4);
            long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
            long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
            long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
            long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
            long j2 = 0;
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    j2 = (j2 + 2654435769L) & Util.MAX_32BIT_VALUE;
                    unsignedInt = (unsignedInt + ((((unsignedInt2 << 4) + unsignedInt3) ^ (unsignedInt2 + j2)) ^ ((unsignedInt2 >>> 5) + unsignedInt4))) & Util.MAX_32BIT_VALUE;
                    unsignedInt2 = (unsignedInt2 + ((((unsignedInt << 4) + unsignedInt5) ^ (unsignedInt + j2)) ^ ((unsignedInt >>> 5) + unsignedInt6))) & Util.MAX_32BIT_VALUE;
                    i2 = i3;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) unsignedInt);
                    dataOutputStream.writeInt((int) unsignedInt2);
                    dataOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(102475);
                    return byteArray;
                }
            }
        } catch (IOException e2) {
            AppMethodBeat.o(102475);
            return null;
        }
    }

    private byte[] decipher(byte[] bArr, int i2) {
        AppMethodBeat.i(102476);
        int i3 = 16;
        try {
            long unsignedInt = getUnsignedInt(bArr, i2, 4);
            long unsignedInt2 = getUnsignedInt(bArr, i2 + 4, 4);
            long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
            long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
            long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
            long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
            long j2 = 3816266640L;
            while (true) {
                int i4 = i3 - 1;
                if (i3 > 0) {
                    unsignedInt2 = (unsignedInt2 - ((((unsignedInt << 4) + unsignedInt5) ^ (unsignedInt + j2)) ^ ((unsignedInt >>> 5) + unsignedInt6))) & Util.MAX_32BIT_VALUE;
                    unsignedInt = (unsignedInt - ((((unsignedInt2 << 4) + unsignedInt3) ^ (unsignedInt2 + j2)) ^ ((unsignedInt2 >>> 5) + unsignedInt4))) & Util.MAX_32BIT_VALUE;
                    j2 = (j2 - 2654435769L) & Util.MAX_32BIT_VALUE;
                    i3 = i4;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) unsignedInt);
                    dataOutputStream.writeInt((int) unsignedInt2);
                    dataOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(102476);
                    return byteArray;
                }
            }
        } catch (IOException e2) {
            AppMethodBeat.o(102476);
            return null;
        }
    }

    private byte[] decipher(byte[] bArr) {
        AppMethodBeat.i(102477);
        byte[] decipher = decipher(bArr, 0);
        AppMethodBeat.o(102477);
        return decipher;
    }

    private void encrypt8Bytes() {
        AppMethodBeat.i(102478);
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
        AppMethodBeat.o(102478);
    }

    private boolean decrypt8Bytes(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(102479);
        this.pos = 0;
        while (this.pos < 8) {
            if (this.contextStart + this.pos >= i3) {
                AppMethodBeat.o(102479);
                return true;
            }
            byte[] bArr2 = this.prePlain;
            int i4 = this.pos;
            bArr2[i4] = (byte) (bArr2[i4] ^ bArr[(this.crypt + i2) + this.pos]);
            this.pos++;
        }
        this.prePlain = decipher(this.prePlain);
        if (this.prePlain == null) {
            AppMethodBeat.o(102479);
            return false;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        AppMethodBeat.o(102479);
        return true;
    }

    private int rand() {
        AppMethodBeat.i(102480);
        int nextInt = this.random.nextInt();
        AppMethodBeat.o(102480);
        return nextInt;
    }

    private static long getUnsignedInt(byte[] bArr, int i2, int i3) {
        int i4;
        long j2 = 0;
        if (i3 > 8) {
            i4 = i2 + 8;
        } else {
            i4 = i2 + i3;
        }
        while (i2 < i4) {
            j2 = (j2 << 8) | ((long) (bArr[i2] & 255));
            i2++;
        }
        return (j2 >>> 32) | (Util.MAX_32BIT_VALUE & j2);
    }
}
