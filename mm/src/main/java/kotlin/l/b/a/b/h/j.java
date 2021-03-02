package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class j {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer bXp;

    public interface a {
        int getNumber();
    }

    public interface b<T extends a> {
        T aua(int i2);
    }

    public static String G(byte[] bArr) {
        AppMethodBeat.i(59479);
        try {
            String str = new String(bArr, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(59479);
            return str;
        } catch (UnsupportedEncodingException e2) {
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?", e2);
            AppMethodBeat.o(59479);
            throw runtimeException;
        }
    }

    static {
        AppMethodBeat.i(59480);
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        bXp = ByteBuffer.wrap(bArr);
        AppMethodBeat.o(59480);
    }

    public static boolean F(byte[] bArr) {
        AppMethodBeat.i(59478);
        boolean s = y.s(bArr, 0, bArr.length);
        AppMethodBeat.o(59478);
        return s;
    }
}
