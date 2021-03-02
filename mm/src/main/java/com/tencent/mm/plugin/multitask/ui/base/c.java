package com.tencent.mm.plugin.multitask.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.ui.base.b;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(200717);
        int[] iArr = new int[b.c.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[b.c.ANCHORED.ordinal()] = 1;
        $EnumSwitchMapping$0[b.c.COLLAPSED.ordinal()] = 2;
        $EnumSwitchMapping$0[b.c.EXPANDED.ordinal()] = 3;
        $EnumSwitchMapping$0[b.c.HIDDEN.ordinal()] = 4;
        int[] iArr2 = new int[b.c.values().length];
        haE = iArr2;
        iArr2[b.c.EXPANDED.ordinal()] = 1;
        haE[b.c.ANCHORED.ordinal()] = 2;
        haE[b.c.HIDDEN.ordinal()] = 3;
        AppMethodBeat.o(200717);
    }
}
