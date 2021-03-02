package com.tencent.mm.plugin.fts.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import java.util.Comparator;

public final class d implements Comparator<m> {
    public static final d wXA = new d();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(m mVar, m mVar2) {
        m mVar3 = mVar;
        m mVar4 = mVar2;
        if (mVar3.timestamp > mVar4.timestamp) {
            return -1;
        }
        if (mVar3.timestamp < mVar4.timestamp) {
            return 1;
        }
        if (mVar3.wVW < mVar4.wVW) {
            return 1;
        }
        if (mVar3.wVW <= mVar4.wVW) {
            return 0;
        }
        return -1;
    }

    static {
        AppMethodBeat.i(131730);
        AppMethodBeat.o(131730);
    }
}
