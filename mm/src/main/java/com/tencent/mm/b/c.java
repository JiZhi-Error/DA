package com.tencent.mm.b;

import com.tencent.mm.pointers.PByteArray;

public final class c {
    public static int a(PByteArray pByteArray, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return 2;
        }
        if (bArr.length < 0 || bArr2.length <= 0) {
            return 2;
        }
        int length = 8 - (bArr.length % 8);
        int i2 = length == 0 ? 8 : length;
        byte[] bArr3 = new byte[(bArr.length + i2)];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr3[i3] = bArr[i3];
        }
        for (int i4 = 0; i4 < i2; i4++) {
            bArr3[bArr.length + i4] = (byte) i2;
        }
        pByteArray.value = new byte[(bArr.length + i2 + 32)];
        if (k.Using_DES(pByteArray.value, bArr3, (long) bArr3.length, bArr2.length, bArr2, 0) == 0) {
            return 11;
        }
        byte[] bArr4 = new byte[(bArr.length + i2 + 8)];
        for (int i5 = 0; i5 < bArr4.length; i5++) {
            bArr4[i5] = pByteArray.value[i5];
        }
        pByteArray.value = bArr4;
        return 0;
    }

    public static int b(PByteArray pByteArray, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return 2;
        }
        if (bArr.length < 0 || bArr2.length <= 0) {
            return 2;
        }
        int length = bArr.length;
        pByteArray.value = new byte[length];
        if (k.Using_DES(pByteArray.value, bArr, (long) length, bArr2.length, bArr2, 1) == 0) {
            return 12;
        }
        byte b2 = pByteArray.value[(length - 1) - 8];
        if (b2 <= 0 || b2 > 8) {
            return 12;
        }
        byte[] bArr3 = new byte[((length - b2) - 8)];
        for (int i2 = 0; i2 < bArr3.length; i2++) {
            bArr3[i2] = pByteArray.value[i2];
        }
        pByteArray.value = bArr3;
        return 0;
    }
}
