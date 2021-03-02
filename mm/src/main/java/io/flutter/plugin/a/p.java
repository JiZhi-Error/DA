package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class p implements i<String> {
    private static final Charset RAF = Charset.forName("UTF8");
    public static final p SSt = new p();

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // io.flutter.plugin.a.i
    public final /* synthetic */ String J(ByteBuffer byteBuffer) {
        AppMethodBeat.i(9847);
        String P = P(byteBuffer);
        AppMethodBeat.o(9847);
        return P;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.flutter.plugin.a.i
    public final /* synthetic */ ByteBuffer eP(String str) {
        AppMethodBeat.i(9848);
        ByteBuffer btr = btr(str);
        AppMethodBeat.o(9848);
        return btr;
    }

    static {
        AppMethodBeat.i(9849);
        AppMethodBeat.o(9849);
    }

    private p() {
    }

    public static ByteBuffer btr(String str) {
        AppMethodBeat.i(9845);
        if (str == null) {
            AppMethodBeat.o(9845);
            return null;
        }
        byte[] bytes = str.getBytes(RAF);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        AppMethodBeat.o(9845);
        return allocateDirect;
    }

    public static String P(ByteBuffer byteBuffer) {
        byte[] bArr;
        int i2;
        AppMethodBeat.i(9846);
        if (byteBuffer == null) {
            AppMethodBeat.o(9846);
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i2 = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i2 = 0;
        }
        String str = new String(bArr, i2, remaining, RAF);
        AppMethodBeat.o(9846);
        return str;
    }
}
