package com.tencent.mm.plugin.fts.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Comparator;

public final class b implements Comparator<m> {
    public static final b wXy = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(m mVar, m mVar2) {
        AppMethodBeat.i(131726);
        m mVar3 = mVar;
        m mVar4 = mVar2;
        int i2 = mVar4.wWz - mVar3.wWz;
        if (i2 != 0) {
            AppMethodBeat.o(131726);
            return i2;
        }
        int a2 = d.a(c.wUQ, mVar3.type, mVar4.type);
        if (a2 != 0) {
            AppMethodBeat.o(131726);
            return a2;
        }
        int f2 = d.f(c.wUV, mVar3.wVW, mVar4.wVW);
        if (f2 != 0) {
            AppMethodBeat.o(131726);
            return f2;
        }
        int i3 = mVar3.wXh - mVar4.wXh;
        if (i3 != 0) {
            AppMethodBeat.o(131726);
            return i3;
        } else if (mVar3.wVW == 11 || mVar3.wVW == 17 || mVar3.wVW == 18) {
            if (Util.isNullOrNil(mVar3.wXp)) {
                mVar3.wXp = d.ayo(mVar3.wVX);
                mVar3.wXp = mVar3.wXp.toLowerCase();
                if (!g.C(mVar3.wXp.charAt(0))) {
                    mVar3.wXp = "~" + mVar3.wXp;
                }
            }
            if (Util.isNullOrNil(mVar4.wXp)) {
                mVar4.wXp = d.ayo(mVar4.wVX);
                mVar4.wXp = mVar4.wXp.toLowerCase();
                if (!g.C(mVar4.wXp.charAt(0))) {
                    mVar4.wXp = "~" + mVar4.wXp;
                }
            }
            int compareToIgnoreCase = mVar3.wXp.compareToIgnoreCase(mVar4.wXp);
            AppMethodBeat.o(131726);
            return compareToIgnoreCase;
        } else {
            int compareToIgnoreCase2 = Util.nullAs(mVar3.wXi, "").compareToIgnoreCase(mVar4.wXi);
            AppMethodBeat.o(131726);
            return compareToIgnoreCase2;
        }
    }

    static {
        AppMethodBeat.i(131727);
        AppMethodBeat.o(131727);
    }
}
