package org.extra.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class c {

    public interface a {
        void a(Context context, String[] strArr, String str, File file, d dVar);
    }

    public interface b {
        void bvp(String str);

        String bvq(String str);

        String[] hPR();

        void loadLibrary(String str);

        String mapLibraryName(String str);
    }

    public static void loadLibrary(Context context, String str) {
        AppMethodBeat.i(236776);
        new d().dh(context, str);
        AppMethodBeat.o(236776);
    }
}
