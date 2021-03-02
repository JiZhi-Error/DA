package io.flutter.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static String lO(Context context) {
        AppMethodBeat.i(214854);
        String path = context.getDir("flutter", 0).getPath();
        AppMethodBeat.o(214854);
        return path;
    }
}
