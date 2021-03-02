package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class e {
    public static String X(InputStream inputStream) {
        int read;
        AppMethodBeat.i(40583);
        d.j(inputStream, "Cannot get String from a null object");
        try {
            char[] cArr = new char[65536];
            StringBuilder sb = new StringBuilder();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            do {
                read = inputStreamReader.read(cArr, 0, 65536);
                if (read > 0) {
                    sb.append(cArr, 0, read);
                    continue;
                }
            } while (read >= 0);
            inputStreamReader.close();
            String sb2 = sb.toString();
            AppMethodBeat.o(40583);
            return sb2;
        } catch (IOException e2) {
            IllegalStateException illegalStateException = new IllegalStateException("Error while reading response body", e2);
            AppMethodBeat.o(40583);
            throw illegalStateException;
        }
    }
}
