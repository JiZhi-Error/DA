package com.tencent.mm.loader.e;

import com.tencent.mm.loader.d.c;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e implements c {
    public static byte[] r(InputStream inputStream) {
        return s(inputStream);
    }

    private static byte[] s(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArray;
            }
        }
    }
}
