package com.tencent.mm.plugin.festival.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.finder.ah;
import com.tencent.mm.sdk.statemachine.State;
import kotlin.g.b.aa;
import kotlin.g.b.ag;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.d;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final /* synthetic */ class aj extends ag {
    aj(ah.b bVar) {
        super(bVar);
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(262455);
        b bp = aa.bp(ah.b.class);
        AppMethodBeat.o(262455);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "stateExitScenario";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getStateExitScenario()Lcom/tencent/mm/sdk/statemachine/State;";
    }

    @Override // kotlin.l.l
    public final Object get() {
        AppMethodBeat.i(262456);
        State state = ((ah.b) this.SYl).UtO;
        AppMethodBeat.o(262456);
        return state;
    }
}
