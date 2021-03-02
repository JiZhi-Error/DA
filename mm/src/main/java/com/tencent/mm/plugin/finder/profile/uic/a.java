package com.tencent.mm.plugin.finder.profile.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(250096);
        int[] iArr = new int[FinderAtFeedLoader.d.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[FinderAtFeedLoader.d.LOADING.ordinal()] = 1;
        $EnumSwitchMapping$0[FinderAtFeedLoader.d.LOADED.ordinal()] = 2;
        $EnumSwitchMapping$0[FinderAtFeedLoader.d.FAILURE.ordinal()] = 3;
        AppMethodBeat.o(250096);
    }
}
