package com.tencent.mm.plugin.finder.viewmodel.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.g.b.t;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.d;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class a extends t {
    public a(FinderCommentDrawerUIC finderCommentDrawerUIC) {
        super(finderCommentDrawerUIC);
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(255438);
        b bp = aa.bp(FinderCommentDrawerUIC.class);
        AppMethodBeat.o(255438);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "drawer";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getDrawer()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;";
    }

    @Override // kotlin.l.l
    public final Object get() {
        return ((FinderCommentDrawerUIC) this.SYl).tLT;
    }
}
