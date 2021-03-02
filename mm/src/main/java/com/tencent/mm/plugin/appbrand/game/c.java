package com.tencent.mm.plugin.appbrand.game;

import com.tencent.luggage.game.d.a.a.a;
import com.tencent.luggage.sdk.b.a.c.f;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c extends com.tencent.mm.plugin.appbrand.service.c {
    public c() {
        super(new a.b());
        AppMethodBeat.i(45083);
        AppMethodBeat.o(45083);
    }

    public final MBRuntime bCX() {
        AppMethodBeat.i(226614);
        f fVar = this.cBj;
        if (fVar instanceof a) {
            e magicBrush = ((a) fVar).cwa.getMagicBrush();
            AppMethodBeat.o(226614);
            return magicBrush;
        }
        AppMethodBeat.o(226614);
        return null;
    }
}
