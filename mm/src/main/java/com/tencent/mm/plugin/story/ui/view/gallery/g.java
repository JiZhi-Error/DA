package com.tencent.mm.plugin.story.ui.view.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.n;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(120383);
        int[] iArr = new int[n.a.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[n.a.MultiUserGallery.ordinal()] = 1;
        $EnumSwitchMapping$0[n.a.FavOtherStoryGallery.ordinal()] = 2;
        $EnumSwitchMapping$0[n.a.FavSelfStoryGalleryMulti.ordinal()] = 3;
        $EnumSwitchMapping$0[n.a.FavSelfStoryGallery.ordinal()] = 4;
        $EnumSwitchMapping$0[n.a.HistoryGallery.ordinal()] = 5;
        $EnumSwitchMapping$0[n.a.SingleGallery.ordinal()] = 6;
        $EnumSwitchMapping$0[n.a.ProfileGallery.ordinal()] = 7;
        AppMethodBeat.o(120383);
    }
}
