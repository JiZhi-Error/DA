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
final /* synthetic */ class an extends ag {
    an(ah.b bVar) {
        super(bVar);
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(262492);
        b bp = aa.bp(ah.b.class);
        AppMethodBeat.o(262492);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "stateRunWishPostedAnimation";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getStateRunWishPostedAnimation()Lcom/tencent/mm/sdk/statemachine/State;";
    }

    @Override // kotlin.l.l
    public final Object get() {
        AppMethodBeat.i(262493);
        State state = ((ah.b) this.SYl).UtS;
        AppMethodBeat.o(262493);
        return state;
    }
}
