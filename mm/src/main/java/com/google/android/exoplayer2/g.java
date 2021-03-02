package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    @Deprecated
    public static v a(Context context, h hVar, m mVar) {
        AppMethodBeat.i(91886);
        v a2 = a(new d(context), hVar, mVar);
        AppMethodBeat.o(91886);
        return a2;
    }

    public static v a(Context context, h hVar) {
        AppMethodBeat.i(91887);
        v a2 = a(new d(context), hVar, new c());
        AppMethodBeat.o(91887);
        return a2;
    }

    public static v a(u uVar, h hVar, m mVar) {
        AppMethodBeat.i(91888);
        v vVar = new v(uVar, hVar, mVar);
        AppMethodBeat.o(91888);
        return vVar;
    }

    public static f a(r[] rVarArr, h hVar, m mVar) {
        AppMethodBeat.i(91889);
        h hVar2 = new h(rVarArr, hVar, mVar);
        AppMethodBeat.o(91889);
        return hVar2;
    }
}
