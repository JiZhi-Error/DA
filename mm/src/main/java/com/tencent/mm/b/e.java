package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class e {
    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return 0;
        }
        try {
            byte[] bArr = new byte[4096];
            long j2 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return j2;
                }
                outputStream.write(bArr, 0, read);
                j2 += (long) read;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.FileOperation", "copyStream error: %s", e2.getMessage());
            return 0;
        }
    }

    public static void f(String... strArr) {
        for (int i2 = 0; i2 <= 0; i2++) {
            String str = strArr[0];
            o oVar = new o(str);
            if (!oVar.exists() && (!oVar.mkdirs() || !oVar.isDirectory())) {
                Log.e("MicroMsg.FileOperation", "batchMkDirs mkdir error. %s", str);
            }
        }
    }

    public static final boolean a(o oVar) {
        o[] het;
        if (!(oVar.exists() && oVar.isDirectory() && (het = oVar.het()) != null)) {
            return false;
        }
        for (o oVar2 : het) {
            oVar2.delete();
        }
        return true;
    }

    public static byte[] readFromStream(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        int i2 = 0;
        while (true) {
            try {
                i2 = inputStream.read(bArr, 0, 1024);
            } catch (IOException e2) {
            }
            if (i2 <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }
}
