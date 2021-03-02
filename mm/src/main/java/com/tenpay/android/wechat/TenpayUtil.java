package com.tenpay.android.wechat;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Field;
import java.security.MessageDigest;

public class TenpayUtil {
    public static byte[] sm4EncryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.i(73255);
        if (bArr == null) {
            AppMethodBeat.o(73255);
            return null;
        }
        byte[] sm4BCDEncryptCBC = new Encrypt().sm4BCDEncryptCBC(bArr, bArr2, bArr3);
        AppMethodBeat.o(73255);
        return sm4BCDEncryptCBC;
    }

    public static byte[] sm4DecryptCBC(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.i(73256);
        if (bArr == null) {
            AppMethodBeat.o(73256);
            return null;
        }
        byte[] sm4BCDDecryptCBC = new Encrypt().sm4BCDDecryptCBC(bArr, bArr2, bArr3);
        AppMethodBeat.o(73256);
        return sm4BCDDecryptCBC;
    }

    public static String signWith3Des(String str) {
        AppMethodBeat.i(73257);
        if (str == null) {
            AppMethodBeat.o(73257);
            return null;
        }
        String desedeEncode = new Encrypt().desedeEncode(md5HexDigest(str));
        AppMethodBeat.o(73257);
        return desedeEncode;
    }

    public static String md5HexDigest(String str) {
        String str2;
        AppMethodBeat.i(73258);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i2 = 0;
            int i3 = 0;
            while (i2 < 16) {
                byte b2 = digest[i2];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                cArr2[i4] = cArr[b2 & 15];
                i2++;
                i3 = i4 + 1;
            }
            str2 = new String(cArr2);
        } catch (Exception e2) {
            str2 = null;
        }
        AppMethodBeat.o(73258);
        return str2;
    }

    public static final int[] getResourceDeclareStyleableIntArray(Context context, String str) {
        AppMethodBeat.i(73259);
        try {
            Field[] fields = Class.forName(context.getPackageName() + ".R$styleable").getFields();
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    int[] iArr = (int[]) field.get(null);
                    AppMethodBeat.o(73259);
                    return iArr;
                }
            }
            AppMethodBeat.o(73259);
            return null;
        } catch (Throwable th) {
            AppMethodBeat.o(73259);
            return null;
        }
    }

    public static final int getResourceDeclareStyleableIndex(Context context, String str) {
        int i2 = 0;
        AppMethodBeat.i(73260);
        try {
            Field[] fields = Class.forName(context.getPackageName() + ".R$styleable").getFields();
            int length = fields.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                Field field = fields[i3];
                if (field.getName().equals(str)) {
                    i2 = field.getInt(null);
                    AppMethodBeat.o(73260);
                    break;
                }
                i3++;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(73260);
        return i2;
    }

    public static boolean invalidateID(String str) {
        AppMethodBeat.i(73261);
        if (str == null) {
            AppMethodBeat.o(73261);
            return false;
        } else if (str.length() != 18) {
            AppMethodBeat.o(73261);
            return false;
        } else {
            int[] iArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
            char[] cArr = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
            int i2 = 0;
            for (int i3 = 0; i3 < str.length() - 1; i3++) {
                try {
                    i2 += Util.safeParseInt(str.substring(i3, i3 + 1)) * iArr[i3];
                } catch (NumberFormatException e2) {
                    AppMethodBeat.o(73261);
                    return false;
                }
            }
            int i4 = i2 % 11;
            char charAt = str.charAt(17);
            if (i4 == 2) {
                if (!(charAt == 'X' || charAt == 'x')) {
                    AppMethodBeat.o(73261);
                    return false;
                }
            } else if (charAt != cArr[i4]) {
                AppMethodBeat.o(73261);
                return false;
            }
            AppMethodBeat.o(73261);
            return true;
        }
    }
}
