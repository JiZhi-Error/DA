package com.tencent.mm.plugin.festival.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.finder.ah;
import com.tencent.mm.sdk.statemachine.State;
import kotlin.g.b.aa;
import kotlin.g.b.ag;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.d;

@l(hxD = {1, 1, 16})
final /* synthetic */ class ao extends ag {
    ao(ah.b bVar) {
        super(bVar);
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(262499);
        b bp = aa.bp(ah.b.class);
        AppMethodBeat.o(262499);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "stateWaitForPickLocation";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getStateWaitForPickLocation()Lcom/tencent/mm/sdk/statemachine/State;";
    }

    @Override // kotlin.l.l
    public final Object get() {
        AppMethodBeat.i(262500);
        State state = ((ah.b) this.SYl).UtQ;
        AppMethodBeat.o(262500);
        return state;
    }
}
