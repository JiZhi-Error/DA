package com.tencent.mm.jni.utils;

public class UtilsJni {
    public static native byte[] AesGcmDecrypt(byte[] bArr, byte[] bArr2);

    public static native byte[] AesGcmDecryptWithUncompress(byte[] bArr, byte[] bArr2);

    public static native byte[] AesGcmEncrypt(byte[] bArr, byte[] bArr2);

    public static native byte[] AesGcmEncryptWithCompress(byte[] bArr, byte[] bArr2);

    public static native byte[] AxEcdhDecrypt(long j2, byte[] bArr);

    public static native byte[] AxEcdhEncrypt(long j2, byte[] bArr);

    public static native long CreateAxEcdhCryptoEngine(int i2, byte[] bArr, byte[] bArr2);

    public static native long CreateHybridEcdhCryptoEngine(int i2, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] DecryptAvatar(byte[] bArr);

    public static native byte[] Ecdh(byte[] bArr, byte[] bArr2);

    public static native byte[] EcdsaSign(byte[] bArr, byte[] bArr2);

    public static native int EcdsaVerify(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[][] GenEcdhKeyPair();

    public static native byte[][] GenEcdsaKeyPair();

    public static native byte[] HKDF(byte[] bArr, byte[] bArr2, String str, int i2);

    public static native byte[] HybridEcdhDecrypt(long j2, byte[] bArr);

    public static native byte[] HybridEcdhEncrypt(long j2, byte[] bArr);

    public static native void ReleaseAxEcdhCryptoEngine(long j2);

    public static native void ReleaseHybridEcdhCryptoEngine(long j2);

    public static native void ResetAxEcdhCryptoEngine(long j2);

    public static native void ResetHybridEcdhCryptoEngine(long j2);

    public static native byte[] cryptGenRandom(int i2);

    public static native int doEcdsaSHAVerify(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native int doEcdsaVerify(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[][] ecdsaGeneralOctKeyPair();

    public static native byte[] ecdsaSignWithOctKey(byte[] bArr, byte[] bArr2);

    public static native int ecdsaVerifyWithOctKey(byte[] bArr, byte[] bArr2, byte[] bArr3);
}
