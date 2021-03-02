package com.tencent.map.tools.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1394a = r.class.getSimpleName();

    static {
        AppMethodBeat.i(193536);
        AppMethodBeat.o(193536);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r8, byte[] r9) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.internal.r.a(java.lang.String, byte[]):byte[]");
    }

    public static byte[] a(String str) {
        AppMethodBeat.i(193535);
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.connect();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openConnection.getInputStream().read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    AppMethodBeat.o(193535);
                    return byteArray;
                }
            }
        } catch (Exception e2) {
            AppMethodBeat.o(193535);
            return null;
        }
    }
}
