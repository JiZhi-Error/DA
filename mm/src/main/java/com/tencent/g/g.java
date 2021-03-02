package com.tencent.g;

import com.tencent.g.b.a;
import com.tencent.g.b.b;
import com.tencent.g.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g implements b {
    private f SoY;
    d SoZ;
    b Spa;
    a Spb;
    int mReferenceCount = 0;
    int mState;

    public g(f fVar, d dVar) {
        this.SoY = fVar;
        this.SoZ = dVar;
    }

    @Override // com.tencent.g.b.b
    public final void start() {
        AppMethodBeat.i(62798);
        this.SoY.a(this);
        AppMethodBeat.o(62798);
    }
}
