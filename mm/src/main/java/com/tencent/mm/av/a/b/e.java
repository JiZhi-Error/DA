package com.tencent.mm.av.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e implements m {
    @Override // com.tencent.mm.av.a.c.m
    public final boolean br(String str, String str2) {
        AppMethodBeat.i(130414);
        if (Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
            AppMethodBeat.o(130414);
            return false;
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            AppMethodBeat.o(130414);
            return false;
        } else {
            String bhK = s.bhK(str2);
            if (Util.isNullOrNil(bhK) || !bhK.equals(str)) {
                Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", bhK, str);
                AppMethodBeat.o(130414);
                return false;
            }
            Log.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
            AppMethodBeat.o(130414);
            return true;
        }
    }

    @Override // com.tencent.mm.av.a.c.m
    public final boolean j(String str, byte[] bArr) {
        AppMethodBeat.i(130415);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            AppMethodBeat.o(130415);
            return false;
        }
        String mD5String = MD5Util.getMD5String(bArr);
        if (Util.isNullOrNil(mD5String) || !mD5String.equals(str)) {
            Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", mD5String, str);
            AppMethodBeat.o(130415);
            return false;
        }
        Log.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        AppMethodBeat.o(130415);
        return true;
    }

    @Override // com.tencent.mm.av.a.c.m
    public final boolean a(String str, InputStream inputStream) {
        AppMethodBeat.i(130416);
        if (inputStream == null) {
            Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
            AppMethodBeat.o(130416);
            return false;
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
            AppMethodBeat.o(130416);
            return false;
        } else {
            try {
                inputStream.mark(inputStream.available());
                String mD5String = MD5Util.getMD5String(b(inputStream, true));
                inputStream.reset();
                if (Util.isNullOrNil(mD5String) || !mD5String.equals(str)) {
                    Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", mD5String, str);
                    AppMethodBeat.o(130416);
                    return false;
                }
                Log.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
                AppMethodBeat.o(130416);
                return true;
            } catch (Exception e2) {
                Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + e2.toString());
                AppMethodBeat.o(130416);
                return false;
            }
        }
    }

    public static byte[] r(InputStream inputStream) {
        AppMethodBeat.i(130417);
        byte[] b2 = b(inputStream, false);
        AppMethodBeat.o(130417);
        return b2;
    }

    public static byte[] b(InputStream inputStream, boolean z) {
        AppMethodBeat.i(130418);
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (!z) {
            inputStream.close();
        }
        AppMethodBeat.o(130418);
        return byteArray;
    }
}
