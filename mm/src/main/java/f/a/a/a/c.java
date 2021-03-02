package f.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

public final class c implements b {
    @Override // f.a.a.a.b
    public final byte[] zip(byte[] bArr) {
        AppMethodBeat.i(214849);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.finish();
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        AppMethodBeat.o(214849);
        return byteArray;
    }
}
