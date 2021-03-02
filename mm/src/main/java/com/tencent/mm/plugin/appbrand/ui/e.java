package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.t;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(229456);
        int[] iArr = new int[t.b.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[t.b.SINGLE_CHATTING.ordinal()] = 1;
        $EnumSwitchMapping$0[t.b.GROUP_CHATTING.ordinal()] = 2;
        $EnumSwitchMapping$0[t.b.FAVORITE.ordinal()] = 3;
        $EnumSwitchMapping$0[t.b.TIME_LINE.ordinal()] = 4;
        $EnumSwitchMapping$0[t.b.CHATTING_RECORD_FROM_FAV.ordinal()] = 5;
        $EnumSwitchMapping$0[t.b.CHATTING_RECORD_FROM_SINGLE_CHAT.ordinal()] = 6;
        $EnumSwitchMapping$0[t.b.CHATTING_RECORD_FROM_GROUP_CHAT.ordinal()] = 7;
        $EnumSwitchMapping$0[t.b.NOTE_FROM_FAV.ordinal()] = 8;
        $EnumSwitchMapping$0[t.b.NOTE_FROM_SINGLE_CHAT.ordinal()] = 9;
        $EnumSwitchMapping$0[t.b.NOTE_FROM_GROUP_CHAT.ordinal()] = 10;
        $EnumSwitchMapping$0[t.b.NOTE_FROM_TIMELINE.ordinal()] = 11;
        $EnumSwitchMapping$0[t.b.FINDER.ordinal()] = 12;
        AppMethodBeat.o(229456);
    }
}
