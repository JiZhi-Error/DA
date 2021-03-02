package com.bumptech.glide.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* access modifiers changed from: package-private */
public final class c {
    static final Charset US_ASCII = Charset.forName("US-ASCII");
    static final Charset UTF_8 = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET);

    static {
        AppMethodBeat.i(100646);
        AppMethodBeat.o(100646);
    }

    static void r(File file) {
        AppMethodBeat.i(100644);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            IOException iOException = new IOException("not a readable directory: ".concat(String.valueOf(file)));
            AppMethodBeat.o(100644);
            throw iOException;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                r(file2);
            }
            if (!file2.delete()) {
                IOException iOException2 = new IOException("failed to delete file: ".concat(String.valueOf(file2)));
                AppMethodBeat.o(100644);
                throw iOException2;
            }
        }
        AppMethodBeat.o(100644);
    }

    static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(100645);
        try {
            closeable.close();
            AppMethodBeat.o(100645);
        } catch (RuntimeException e2) {
            AppMethodBeat.o(100645);
            throw e2;
        } catch (Exception e3) {
            AppMethodBeat.o(100645);
        }
    }
}
