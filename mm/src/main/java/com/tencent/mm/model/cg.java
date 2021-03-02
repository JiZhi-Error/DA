package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

@Deprecated
public class cg {
    static {
        AppMethodBeat.i(20396);
        cg.class.getClassLoader();
        j.Ed("tencentlocsapp");
        AppMethodBeat.o(20396);
    }

    public final synchronized boolean a(String str, bd bdVar) {
        AppMethodBeat.i(20394);
        y Il = y.Il(str);
        if (Il == null) {
            Il = y.a(str, new y((Class<? extends bd>) bdVar.getClass()));
        }
        Il.a(bdVar);
        AppMethodBeat.o(20394);
        return true;
    }

    public static bd KG(String str) {
        AppMethodBeat.i(20395);
        y Il = y.Il(str);
        if (Il == null) {
            AppMethodBeat.o(20395);
            return null;
        }
        bd aTV = Il.aTV();
        AppMethodBeat.o(20395);
        return aTV;
    }
}
