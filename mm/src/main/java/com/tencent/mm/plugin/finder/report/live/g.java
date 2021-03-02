package com.tencent.mm.plugin.finder.report.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(250917);
        int[] iArr = new int[c.e.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[c.e.VISIABLE_ON_SCROLL.ordinal()] = 1;
        $EnumSwitchMapping$0[c.e.INVISIABLE_ON_SCROLL.ordinal()] = 2;
        $EnumSwitchMapping$0[c.e.VISIABLE_ON_RESUME.ordinal()] = 3;
        $EnumSwitchMapping$0[c.e.INVISIABLE_ON_PAUSE.ordinal()] = 4;
        $EnumSwitchMapping$0[c.e.EVENT_ON_DESTROY.ordinal()] = 5;
        int[] iArr2 = new int[c.values().length];
        haE = iArr2;
        iArr2[c.EVENT_ON_SCROLL.ordinal()] = 1;
        haE[c.EVENT_ON_SCROLL_HORIZONTAL.ordinal()] = 2;
        AppMethodBeat.o(250917);
    }
}
