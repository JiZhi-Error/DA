package com.tencent.mm.ui.g.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static b Qjr = null;

    public static void a(b bVar) {
        Qjr = bVar;
    }

    public static void c(ImageView imageView, String str) {
        AppMethodBeat.i(142751);
        if (Qjr != null) {
            Qjr.c(imageView, str);
        }
        AppMethodBeat.o(142751);
    }

    public static void d(ImageView imageView, String str) {
        AppMethodBeat.i(164172);
        if (Qjr != null) {
            Qjr.d(imageView, str);
        }
        AppMethodBeat.o(164172);
    }
}
