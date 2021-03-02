package com.tencent.mm.plugin.performance.c;

import com.tencent.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(184661);
        int[] iArr = new int[f.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[f.CREATED.ordinal()] = 1;
        $EnumSwitchMapping$0[f.RUNNING.ordinal()] = 2;
        $EnumSwitchMapping$0[f.COMPLETE.ordinal()] = 3;
        $EnumSwitchMapping$0[f.CANCEL.ordinal()] = 4;
        $EnumSwitchMapping$0[f.THROW.ordinal()] = 5;
        AppMethodBeat.o(184661);
    }
}
