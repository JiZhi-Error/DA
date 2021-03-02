package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.n;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class k {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(120435);
        int[] iArr = new int[n.a.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[n.a.FavSelfStoryGalleryMulti.ordinal()] = 1;
        $EnumSwitchMapping$0[n.a.FavSelfStoryGallery.ordinal()] = 2;
        $EnumSwitchMapping$0[n.a.FavOtherStoryGallery.ordinal()] = 3;
        $EnumSwitchMapping$0[n.a.MultiUserGallery.ordinal()] = 4;
        $EnumSwitchMapping$0[n.a.HistoryGallery.ordinal()] = 5;
        AppMethodBeat.o(120435);
    }
}
