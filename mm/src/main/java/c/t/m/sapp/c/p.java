package c.t.m.sapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public static int f92a = 20000;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r8, byte[] r9) {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.sapp.c.p.a(java.lang.String, byte[]):byte[]");
    }

    public static byte[] a(String str) {
        AppMethodBeat.i(223019);
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
                    AppMethodBeat.o(223019);
                    return byteArray;
                }
            }
        } catch (Exception e2) {
            AppMethodBeat.o(223019);
            return null;
        }
    }
}
