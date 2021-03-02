package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.util.j;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class k {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(247251);
        int[] iArr = new int[j.b.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[j.b.NORMAL.ordinal()] = 1;
        $EnumSwitchMapping$0[j.b.SINGLE_CLICK.ordinal()] = 2;
        $EnumSwitchMapping$0[j.b.CONTINUOUS_CLICKING.ordinal()] = 3;
        $EnumSwitchMapping$0[j.b.LONG_CLICK.ordinal()] = 4;
        int[] iArr2 = new int[j.b.values().length];
        haE = iArr2;
        iArr2[j.b.NORMAL.ordinal()] = 1;
        haE[j.b.SINGLE_CLICK.ordinal()] = 2;
        haE[j.b.CONTINUOUS_CLICKING.ordinal()] = 3;
        haE[j.b.LONG_CLICK.ordinal()] = 4;
        AppMethodBeat.o(247251);
    }
}
