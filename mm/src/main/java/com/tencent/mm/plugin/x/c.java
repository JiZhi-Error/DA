package com.tencent.mm.plugin.x;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    INSTANCE;
    
    public final SparseArray<b> DlT = new SparseArray<>();

    private c(String str) {
        AppMethodBeat.i(151582);
        AppMethodBeat.o(151582);
    }

    public static c valueOf(String str) {
        AppMethodBeat.i(151581);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(151581);
        return cVar;
    }

    static {
        AppMethodBeat.i(151584);
        AppMethodBeat.o(151584);
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(151583);
        this.DlT.put(bVar.getType(), bVar);
        AppMethodBeat.o(151583);
        return true;
    }

    public static boolean XE(int i2) {
        return i2 == 1 || i2 == 3;
    }
}
