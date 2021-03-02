package com.tencent.mm.plugin.eggspring.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.eggspring.c.a;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(194581);
        int[] iArr = new int[a.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[a.Succeed.ordinal()] = 1;
        $EnumSwitchMapping$0[a.qUZ.ordinal()] = 2;
        $EnumSwitchMapping$0[a.Denied.ordinal()] = 3;
        $EnumSwitchMapping$0[a.FatalError.ordinal()] = 4;
        AppMethodBeat.o(194581);
    }
}
