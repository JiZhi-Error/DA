package kotlin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.g.b.p;

public final class a {
    public static /* synthetic */ long f(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(259487);
        long e2 = e(inputStream, outputStream);
        AppMethodBeat.o(259487);
        return e2;
    }

    public static long e(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(129278);
        p.h(inputStream, "$this$copyTo");
        p.h(outputStream, "out");
        long j2 = 0;
        byte[] bArr = new byte[8192];
        int read = inputStream.read(bArr);
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j2 += (long) read;
            read = inputStream.read(bArr);
        }
        AppMethodBeat.o(129278);
        return j2;
    }

    public static final byte[] U(InputStream inputStream) {
        AppMethodBeat.i(129280);
        p.h(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        f(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        p.g(byteArray, "buffer.toByteArray()");
        AppMethodBeat.o(129280);
        return byteArray;
    }
}
