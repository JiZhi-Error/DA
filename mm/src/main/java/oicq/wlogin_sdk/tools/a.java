package oicq.wlogin_sdk.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

/* access modifiers changed from: package-private */
public final class a {
    int contextStart;
    int crypt;
    boolean header = true;
    byte[] key;
    byte[] out;
    int padding;
    byte[] plain;
    int pos;
    int preCrypt;
    byte[] prePlain;
    Random random = new Random();

    a() {
        AppMethodBeat.i(88152);
        AppMethodBeat.o(88152);
    }

    private static long C(byte[] bArr, int i2) {
        long j2 = 0;
        int i3 = i2 + 4;
        while (i2 < i3) {
            j2 = (j2 << 8) | ((long) (bArr[i2] & 255));
            i2++;
        }
        return (j2 >>> 32) | (Util.MAX_32BIT_VALUE & j2);
    }

    private byte[] encipher(byte[] bArr) {
        AppMethodBeat.i(88153);
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
                if (i2 <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) C);
                    dataOutputStream.writeInt((int) C2);
                    dataOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(88153);
                    return byteArray;
                }
                j2 = (j2 + 2654435769L) & Util.MAX_32BIT_VALUE;
                C = (C + ((((C2 << 4) + C3) ^ (C2 + j2)) ^ ((C2 >>> 5) + C4))) & Util.MAX_32BIT_VALUE;
                C2 = (C2 + ((((C << 4) + C5) ^ (C + j2)) ^ ((C >>> 5) + C6))) & Util.MAX_32BIT_VALUE;
                i2 = i3;
            }
        } catch (IOException e2) {
            AppMethodBeat.o(88153);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] aQ(byte[] bArr) {
        AppMethodBeat.i(88154);
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
                if (i2 <= 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) C);
                    dataOutputStream.writeInt((int) C2);
                    dataOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(88154);
                    return byteArray;
                }
                C2 = (C2 - ((((C << 4) + C5) ^ (C + j2)) ^ ((C >>> 5) + C6))) & Util.MAX_32BIT_VALUE;
                C = (C - ((((C2 << 4) + C3) ^ (C2 + j2)) ^ ((C2 >>> 5) + C4))) & Util.MAX_32BIT_VALUE;
                j2 = (j2 - 2654435769L) & Util.MAX_32BIT_VALUE;
                i2 = i3;
            }
        } catch (IOException e2) {
            AppMethodBeat.o(88154);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void encrypt8Bytes() {
        AppMethodBeat.i(88155);
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
        AppMethodBeat.o(88155);
    }

    /* access modifiers changed from: package-private */
    public final boolean I(byte[] bArr, int i2) {
        AppMethodBeat.i(88156);
        this.pos = 0;
        while (this.pos < 8) {
            if (this.contextStart + this.pos >= i2) {
                AppMethodBeat.o(88156);
                return true;
            }
            byte[] bArr2 = this.prePlain;
            int i3 = this.pos;
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.crypt + 0) + this.pos]);
            this.pos++;
        }
        this.prePlain = aQ(this.prePlain);
        if (this.prePlain == null) {
            AppMethodBeat.o(88156);
            return false;
        }
        this.contextStart += 8;
        this.crypt += 8;
        this.pos = 0;
        AppMethodBeat.o(88156);
        return true;
    }
}
