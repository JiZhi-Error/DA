package com.tencent.mm.plugin.fts.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.Comparator;

public final class c implements Comparator<m> {
    public static final c wXz = new c();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(m mVar, m mVar2) {
        AppMethodBeat.i(131728);
        m mVar3 = mVar;
        m mVar4 = mVar2;
        int i2 = mVar3.wVW - mVar4.wVW;
        if (i2 != 0) {
            AppMethodBeat.o(131728);
            return i2;
        }
        int i3 = mVar3.wXh - mVar4.wXh;
        if (i3 != 0) {
            AppMethodBeat.o(131728);
            return i3;
        }
        int compareTo = mVar3.wXi.compareTo(mVar4.wXi);
        AppMethodBeat.o(131728);
        return compareTo;
    }

    static {
        AppMethodBeat.i(131729);
        AppMethodBeat.o(131729);
    }
}
