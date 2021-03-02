package com.tencent.mm.plugin.finder.profile.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(250201);
        int[] iArr = new int[FinderProfileFeedLoader.State.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[FinderProfileFeedLoader.State.LOADING.ordinal()] = 1;
        $EnumSwitchMapping$0[FinderProfileFeedLoader.State.LOADED.ordinal()] = 2;
        $EnumSwitchMapping$0[FinderProfileFeedLoader.State.FAILURE.ordinal()] = 3;
        int[] iArr2 = new int[FinderProfileFeedLoader.State.values().length];
        haE = iArr2;
        iArr2[FinderProfileFeedLoader.State.PRIVATE_LOCK.ordinal()] = 1;
        haE[FinderProfileFeedLoader.State.DELETING.ordinal()] = 2;
        AppMethodBeat.o(250201);
    }
}
