package com.tencent.i.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.h.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private SharedPreferences Stv;

    public c(Context context) {
        AppMethodBeat.i(214827);
        try {
            this.Stv = context.getSharedPreferences("ts_" + d.V(d.SpV), 0);
            AppMethodBeat.o(214827);
        } catch (Throwable th) {
            AppMethodBeat.o(214827);
        }
    }
}
