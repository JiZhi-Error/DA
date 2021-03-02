package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.y;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class FinderLikedFeedContract$isOtherEnableFullScreenEnjoy$2 extends q implements a<Boolean> {
    public static final FinderLikedFeedContract$isOtherEnableFullScreenEnjoy$2 uXp = new FinderLikedFeedContract$isOtherEnableFullScreenEnjoy$2();

    static {
        AppMethodBeat.i(249801);
        AppMethodBeat.o(249801);
    }

    FinderLikedFeedContract$isOtherEnableFullScreenEnjoy$2() {
        super(0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ Boolean invoke() {
        AppMethodBeat.i(249800);
        y yVar = y.vXH;
        Boolean valueOf = Boolean.valueOf(y.isOtherEnableFullScreenEnjoy());
        AppMethodBeat.o(249800);
        return valueOf;
    }
}
