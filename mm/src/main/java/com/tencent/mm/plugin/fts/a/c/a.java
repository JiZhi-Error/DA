package com.tencent.mm.plugin.fts.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.Comparator;

public final class a implements Comparator<m> {
    public static final a wXx = new a();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(m mVar, m mVar2) {
        int f2;
        AppMethodBeat.i(131724);
        m mVar3 = mVar;
        m mVar4 = mVar2;
        int i2 = mVar4.wWz - mVar3.wWz;
        if (i2 != 0) {
            AppMethodBeat.o(131724);
            return i2;
        } else if (mVar4.wWz < 50 || mVar3.wWz < 50 || (f2 = d.f(c.wUV, mVar3.wVW, mVar4.wVW)) == 0) {
            int i3 = mVar4.wXq - mVar3.wXq;
            if (i3 != 0) {
                AppMethodBeat.o(131724);
                return i3;
            } else if (mVar4.timestamp > mVar3.timestamp) {
                AppMethodBeat.o(131724);
                return 1;
            } else if (mVar4.timestamp < mVar3.timestamp) {
                AppMethodBeat.o(131724);
                return -1;
            } else {
                AppMethodBeat.o(131724);
                return 0;
            }
        } else {
            AppMethodBeat.o(131724);
            return f2;
        }
    }

    static {
        AppMethodBeat.i(131725);
        AppMethodBeat.o(131725);
    }
}
