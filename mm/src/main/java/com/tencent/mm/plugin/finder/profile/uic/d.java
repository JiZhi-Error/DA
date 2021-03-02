package com.tencent.mm.plugin.finder.profile.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileMusicLoader;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(250426);
        int[] iArr = new int[FinderProfileMusicLoader.d.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[FinderProfileMusicLoader.d.LOADING.ordinal()] = 1;
        $EnumSwitchMapping$0[FinderProfileMusicLoader.d.LOADED.ordinal()] = 2;
        $EnumSwitchMapping$0[FinderProfileMusicLoader.d.FAILURE.ordinal()] = 3;
        int[] iArr2 = new int[FinderProfileMusicLoader.d.values().length];
        haE = iArr2;
        iArr2[FinderProfileMusicLoader.d.PRIVATE_LOCK.ordinal()] = 1;
        AppMethodBeat.o(250426);
    }
}
