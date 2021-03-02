package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.mini.d;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(247525);
        int[] iArr = new int[d.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[d.STATE_NORMAL.ordinal()] = 1;
        $EnumSwitchMapping$0[d.STATE_DISCONNECT.ordinal()] = 2;
        $EnumSwitchMapping$0[d.STATE_FINISH.ordinal()] = 3;
        AppMethodBeat.o(247525);
    }
}
