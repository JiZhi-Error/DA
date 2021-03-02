package com.tencent.liteav.basic.license;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f410a = "#PART#".getBytes();

    static {
        AppMethodBeat.i(222178);
        AppMethodBeat.o(222178);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(222176);
        PrivateKey generatePrivate = KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("RSA/None/PKCS1Padding");
        instance.init(2, generatePrivate);
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.o(222176);
        return doFinal;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        boolean z;
        int i2;
        AppMethodBeat.i(222177);
        int length = f410a.length;
        if (length <= 0) {
            byte[] a2 = a(bArr, bArr2);
            AppMethodBeat.o(222177);
            return a2;
        }
        int length2 = bArr.length;
        ArrayList<Byte> arrayList = new ArrayList(1024);
        int i3 = 0;
        int i4 = 0;
        while (i3 < length2) {
            byte b2 = bArr[i3];
            if (i3 == length2 - 1) {
                byte[] bArr3 = new byte[(length2 - i4)];
                System.arraycopy(bArr, i4, bArr3, 0, bArr3.length);
                byte[] a3 = a(bArr3, bArr2);
                for (byte b3 : a3) {
                    arrayList.add(Byte.valueOf(b3));
                }
                i4 = i3 + length;
                i3 = i4 - 1;
                z = false;
            } else {
                if (b2 == f410a[0]) {
                    if (length <= 1) {
                        z = true;
                    } else if (i3 + length < length2) {
                        int i5 = 1;
                        z = false;
                        while (i5 < length && f410a[i5] == bArr[i3 + i5]) {
                            if (i5 == length - 1) {
                                z = true;
                            }
                            i5++;
                        }
                    }
                }
                z = false;
            }
            if (z) {
                byte[] bArr4 = new byte[(i3 - i4)];
                System.arraycopy(bArr, i4, bArr4, 0, bArr4.length);
                byte[] a4 = a(bArr4, bArr2);
                for (byte b4 : a4) {
                    arrayList.add(Byte.valueOf(b4));
                }
                int i6 = i3 + length;
                i2 = i6 - 1;
                i4 = i6;
            } else {
                i2 = i3;
            }
            i3 = i2 + 1;
        }
        byte[] bArr5 = new byte[arrayList.size()];
        int i7 = 0;
        for (Byte b5 : arrayList) {
            bArr5[i7] = b5.byteValue();
            i7++;
        }
        AppMethodBeat.o(222177);
        return bArr5;
    }
}
