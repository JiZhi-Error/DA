package com.tencent.mm.plugin.textstatus;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.a;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(216019);
        int[] iArr = new int[a.b.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[a.b.CONVERSATION_LIST.ordinal()] = 1;
        $EnumSwitchMapping$0[a.b.CONTACT_LIST.ordinal()] = 2;
        $EnumSwitchMapping$0[a.b.GROUP_CHAT.ordinal()] = 3;
        $EnumSwitchMapping$0[a.b.SNS_FEED.ordinal()] = 4;
        $EnumSwitchMapping$0[a.b.SNS_COMMENT.ordinal()] = 5;
        $EnumSwitchMapping$0[a.b.SNS_NOTIFICATION.ordinal()] = 6;
        $EnumSwitchMapping$0[a.b.PLANET.ordinal()] = 7;
        AppMethodBeat.o(216019);
    }
}
