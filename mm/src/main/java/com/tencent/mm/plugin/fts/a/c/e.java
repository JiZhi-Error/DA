package com.tencent.mm.plugin.fts.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.Comparator;

public final class e implements Comparator<m> {
    public static final e wXB = new e();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(m mVar, m mVar2) {
        m mVar3 = mVar;
        m mVar4 = mVar2;
        if (mVar4.timestamp < mVar3.timestamp) {
            return -1;
        }
        return mVar4.timestamp == mVar3.timestamp ? 0 : 1;
    }

    static {
        AppMethodBeat.i(131731);
        AppMethodBeat.o(131731);
    }
}
