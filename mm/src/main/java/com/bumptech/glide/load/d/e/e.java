package com.bumptech.glide.load.d.e;

import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.d.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends b<c> implements r {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.b.v
    public final Class<c> oV() {
        return c.class;
    }

    @Override // com.bumptech.glide.load.b.v
    public final int getSize() {
        AppMethodBeat.i(77503);
        g gVar = ((c) this.drawable).aLL.aLQ;
        int i2 = k.i(gVar.pO().getWidth(), gVar.pO().getHeight(), gVar.pO().getConfig()) + gVar.aLR.oi();
        AppMethodBeat.o(77503);
        return i2;
    }

    @Override // com.bumptech.glide.load.b.v
    public final void recycle() {
        AppMethodBeat.i(77504);
        ((c) this.drawable).stop();
        c cVar = (c) this.drawable;
        cVar.aHN = true;
        g gVar = cVar.aLL.aLQ;
        gVar.callbacks.clear();
        gVar.pQ();
        gVar.isRunning = false;
        if (gVar.aLV != null) {
            gVar.aDc.c(gVar.aLV);
            gVar.aLV = null;
        }
        if (gVar.aLX != null) {
            gVar.aDc.c(gVar.aLX);
            gVar.aLX = null;
        }
        if (gVar.aLZ != null) {
            gVar.aDc.c(gVar.aLZ);
            gVar.aLZ = null;
        }
        gVar.aLR.clear();
        gVar.aLW = true;
        AppMethodBeat.o(77504);
    }

    @Override // com.bumptech.glide.load.d.c.b, com.bumptech.glide.load.b.r
    public final void initialize() {
        AppMethodBeat.i(77505);
        ((c) this.drawable).pJ().prepareToDraw();
        AppMethodBeat.o(77505);
    }
}
