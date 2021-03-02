package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.x;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "RVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
public final class NearbyVideoPresenter$refreshRV$1$backCache$1 extends q implements b<bo, Boolean> {
    public static final NearbyVideoPresenter$refreshRV$1$backCache$1 INSTANCE = new NearbyVideoPresenter$refreshRV$1$backCache$1();

    static {
        AppMethodBeat.i(249420);
        AppMethodBeat.o(249420);
    }

    NearbyVideoPresenter$refreshRV$1$backCache$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ Boolean invoke(bo boVar) {
        AppMethodBeat.i(249418);
        Boolean valueOf = Boolean.valueOf(invoke(boVar));
        AppMethodBeat.o(249418);
        return valueOf;
    }

    public final boolean invoke(bo boVar) {
        AppMethodBeat.i(249419);
        p.h(boVar, "RVFeed");
        if (!(boVar instanceof x)) {
            AppMethodBeat.o(249419);
            return true;
        }
        AppMethodBeat.o(249419);
        return false;
    }
}
