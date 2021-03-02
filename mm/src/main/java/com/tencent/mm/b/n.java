package com.tencent.mm.b;

import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

public final class n {
    public static String fc(String str) {
        MessageDigest instance = MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        return bytesToHex(instance.digest(byteArrayOutputStream.toByteArray()));
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = bArr.length;
        char[] cArr2 = new char[(length * 2)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i3 + 1;
            cArr2[i3] = cArr[(b2 >>> 4) & 15];
            cArr2[i4] = cArr[b2 & 15];
            i2++;
            i3 = i4 + 1;
        }
        return new String(cArr2);
    }
}
