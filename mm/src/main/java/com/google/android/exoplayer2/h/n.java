package com.google.android.exoplayer2.h;

import android.content.Context;
import com.google.android.exoplayer2.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n implements g.a {
    private final w<? super g> bEI;
    private final g.a bFp;
    private final Context context;

    public n(Context context2, String str, w<? super g> wVar) {
        this(context2, wVar, new p(str, wVar));
        AppMethodBeat.i(196066);
        AppMethodBeat.o(196066);
    }

    public n(Context context2, w<? super g> wVar, g.a aVar) {
        AppMethodBeat.i(93067);
        this.context = context2.getApplicationContext();
        this.bEI = wVar;
        this.bFp = aVar;
        AppMethodBeat.o(93067);
    }

    @Override // com.google.android.exoplayer2.h.g.a
    public final /* synthetic */ g wG() {
        AppMethodBeat.i(93068);
        m mVar = new m(this.context, this.bEI, this.bFp.wG());
        AppMethodBeat.o(93068);
        return mVar;
    }
}
