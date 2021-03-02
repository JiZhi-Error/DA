package c.t.m.sapp.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f82a = {84, 101, 110, 99, 101, 110, 116, 76, 111, 99, 97, 116, 105, 111, 110, 49};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f83b = new byte[0];

    public static Cipher a(String str, int i2) {
        AppMethodBeat.i(222998);
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i2, secretKeySpec, new IvParameterSpec(f82a));
        AppMethodBeat.o(222998);
        return instance;
    }

    public static String b(String str, String str2) {
        AppMethodBeat.i(223001);
        String a2 = a(str, str2, 1);
        AppMethodBeat.o(223001);
        return a2;
    }

    public static byte[] b(byte[] bArr, String str) {
        AppMethodBeat.i(223003);
        byte[] a2 = a(bArr, str, 1);
        AppMethodBeat.o(223003);
        return a2;
    }

    public static String a(String str, String str2, int i2) {
        byte[] bArr;
        AppMethodBeat.i(222999);
        if (i2 != 1 && i2 != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wrong mode.");
            AppMethodBeat.o(222999);
            throw illegalArgumentException;
        } else if (str == null || str.length() == 0) {
            AppMethodBeat.o(222999);
            return "";
        } else {
            if (i2 == 1) {
                try {
                    bArr = str.getBytes();
                } catch (Throwable th) {
                    AppMethodBeat.o(222999);
                    return "";
                }
            } else if (i2 == 2) {
                bArr = Base64.decode(str.getBytes(), 2);
            } else {
                bArr = null;
            }
            if (bArr == null || bArr.length == 0) {
                AppMethodBeat.o(222999);
                return "";
            }
            byte[] a2 = a(bArr, str2, i2);
            if (i2 == 1) {
                String encodeToString = Base64.encodeToString(a2, 2);
                AppMethodBeat.o(222999);
                return encodeToString;
            } else if (i2 == 2) {
                String str3 = new String(a2);
                AppMethodBeat.o(222999);
                return str3;
            } else {
                AppMethodBeat.o(222999);
                return null;
            }
        }
    }

    public static byte[] a(byte[] bArr, String str, int i2) {
        AppMethodBeat.i(223000);
        if (i2 != 1 && i2 != 2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("wrong mode.");
            AppMethodBeat.o(223000);
            throw illegalArgumentException;
        } else if (bArr == null || bArr.length == 0) {
            byte[] bArr2 = f83b;
            AppMethodBeat.o(223000);
            return bArr2;
        } else {
            try {
                Cipher a2 = a(str, i2);
                if (a2 == null) {
                    byte[] bArr3 = f83b;
                    AppMethodBeat.o(223000);
                    return bArr3;
                }
                byte[] doFinal = a2.doFinal(bArr);
                AppMethodBeat.o(223000);
                return doFinal;
            } catch (Throwable th) {
                byte[] bArr4 = f83b;
                AppMethodBeat.o(223000);
                return bArr4;
            }
        }
    }

    public static String a(String str, String str2) {
        AppMethodBeat.i(223002);
        String a2 = a(str, str2, 2);
        AppMethodBeat.o(223002);
        return a2;
    }

    public static byte[] a(byte[] bArr, String str) {
        AppMethodBeat.i(223004);
        byte[] a2 = a(bArr, str, 2);
        AppMethodBeat.o(223004);
        return a2;
    }
}
