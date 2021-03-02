package com.tencent.mm.ui.g.b;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private static b Qjs = null;

    public static void a(b bVar) {
        Qjs = bVar;
    }

    public static Drawable nl(String str, String str2) {
        AppMethodBeat.i(142752);
        if (Qjs != null) {
            a fP = Qjs.fP(str, str2);
            if (fP instanceof Drawable) {
                Drawable drawable = (Drawable) fP;
                AppMethodBeat.o(142752);
                return drawable;
            }
            AppMethodBeat.o(142752);
            return null;
        }
        AppMethodBeat.o(142752);
        return null;
    }
}
