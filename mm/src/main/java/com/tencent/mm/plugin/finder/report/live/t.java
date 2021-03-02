package com.tencent.mm.plugin.finder.report.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.live.s;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class t {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(251181);
        int[] iArr = new int[s.p.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[s.p.LIVE_AUDIENCE_CLICK_FEED_CARD_AVATAR_LIVING.ordinal()] = 1;
        $EnumSwitchMapping$0[s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM.ordinal()] = 2;
        $EnumSwitchMapping$0[s.p.LIVE_AUDIENCE_CLICK_SINGLE_AVATAR.ordinal()] = 3;
        $EnumSwitchMapping$0[s.p.LIVE_AUDIENCE_CLICK_AVATAR_LIVING.ordinal()] = 4;
        $EnumSwitchMapping$0[s.p.LIVE_AUDIENCE_CLICK_LIVE_FEED_AVATAR_LIVING.ordinal()] = 5;
        $EnumSwitchMapping$0[s.p.LIVE_AUDIENCE_CLICK_FEED_AVATAR_LIVING.ordinal()] = 6;
        int[] iArr2 = new int[s.ak.values().length];
        haE = iArr2;
        iArr2[s.ak.CLICK_LIST_ITEM_USER.ordinal()] = 1;
        haE[s.ak.EXPOSE_USER_FINDER_HALF_BOARD.ordinal()] = 2;
        haE[s.ak.CLICK_PRIVATE_MSG_USER.ordinal()] = 3;
        haE[s.ak.CLICK_FOLLOW_USER.ordinal()] = 4;
        haE[s.ak.CLICK_ENTER_USER_PROFILE.ordinal()] = 5;
        AppMethodBeat.o(251181);
    }
}
