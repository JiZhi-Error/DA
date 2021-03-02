package com.tencent.mm.ui.g.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static a Qjt = null;

    public static void a(a aVar) {
        Qjt = aVar;
    }

    public static CharSequence a(Context context, CharSequence charSequence, int i2) {
        AppMethodBeat.i(159255);
        if (Qjt != null) {
            CharSequence a2 = Qjt.a(context, charSequence, i2);
            AppMethodBeat.o(159255);
            return a2;
        }
        AppMethodBeat.o(159255);
        return charSequence;
    }

    public static CharSequence c(Context context, CharSequence charSequence, float f2) {
        AppMethodBeat.i(159256);
        if (Qjt != null) {
            CharSequence c2 = Qjt.c(context, charSequence, f2);
            AppMethodBeat.o(159256);
            return c2;
        }
        AppMethodBeat.o(159256);
        return charSequence;
    }

    public static int db(String str, int i2) {
        AppMethodBeat.i(159257);
        if (Qjt != null) {
            int db = Qjt.db(str, i2);
            AppMethodBeat.o(159257);
            return db;
        }
        AppMethodBeat.o(159257);
        return i2;
    }
}
