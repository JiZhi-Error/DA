package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;

public final class MMProtocalJni {
    public static native byte[] aesDecrypt(byte[] bArr, byte[] bArr2);

    public static native int aesDecryptFile(String str, String str2, byte[] bArr);

    public static native byte[] aesEncrypt(byte[] bArr, byte[] bArr2);

    public static native int computerKeyWithAllStr(int i2, byte[] bArr, byte[] bArr2, PByteArray pByteArray, int i3);

    public static native byte[] decodeSecureNotifyData(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr2);

    public static native void genClientCheckKVRes(int i2, String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, PByteArray pByteArray);

    public static native int genSignature(int i2, byte[] bArr, byte[] bArr2);

    public static native int generateECKey(int i2, PByteArray pByteArray, PByteArray pByteArray2);

    public static native boolean mergeSyncKey(byte[] bArr, byte[] bArr2, PByteArray pByteArray);

    public static native boolean pack(byte[] bArr, PByteArray pByteArray, byte[] bArr2, int i2, byte[] bArr3, String str, int i3, int i4, int i5, byte[] bArr4, byte[] bArr5, int i6, int i7, int i8, int i9);

    public static native boolean packDoubleHybrid(PByteArray pByteArray, byte[] bArr, String str, int i2, int i3, int i4, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, int i5, int i6);

    public static native boolean packHybrid(PByteArray pByteArray, byte[] bArr, String str, int i2, int i3, int i4, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, int i5, int i6);

    public static native boolean packHybridEcdh(PByteArray pByteArray, byte[] bArr, String str, int i2, int i3, int i4, byte[] bArr2, int i5, int i6, int i7);

    public static native boolean rsaPublicEncrypt(byte[] bArr, PByteArray pByteArray, byte[] bArr2, byte[] bArr3);

    public static native boolean rsaPublicEncryptPemkey(byte[] bArr, PByteArray pByteArray, byte[] bArr2);

    public static native boolean setClientPackVersion(int i2);

    public static native void setDeviceTypeId(int i2);

    public static native void setIsLite(boolean z);

    public static native boolean setProtocalJniLogLevel(int i2);

    public static native boolean unpack(PByteArray pByteArray, byte[] bArr, byte[] bArr2, PByteArray pByteArray2, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4);

    public static native boolean verifySyncKey(byte[] bArr);

    private MMProtocalJni() {
    }
}
