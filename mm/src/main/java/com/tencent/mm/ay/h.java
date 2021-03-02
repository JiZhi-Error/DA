package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.css;

public final class h {
    public String dSF;
    public css jfy;
    public String jfz;

    public static h bv(String str, String str2) {
        AppMethodBeat.i(192715);
        h hVar = new h();
        hVar.dSF = str;
        hVar.jfy = null;
        hVar.jfz = str2;
        AppMethodBeat.o(192715);
        return hVar;
    }

    public static h a(String str, css css) {
        AppMethodBeat.i(192716);
        h hVar = new h();
        hVar.dSF = str;
        hVar.jfy = css;
        hVar.jfz = css != null ? css.jfz : "";
        AppMethodBeat.o(192716);
        return hVar;
    }
}
