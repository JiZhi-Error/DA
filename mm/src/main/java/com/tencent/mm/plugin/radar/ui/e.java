package com.tencent.mm.plugin.radar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.e;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(138664);
        int[] iArr = new int[e.a.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[e.a.UnSelected.ordinal()] = 1;
        $EnumSwitchMapping$0[e.a.Selected.ordinal()] = 2;
        int[] iArr2 = new int[e.a.values().length];
        haE = iArr2;
        iArr2[e.a.Selected.ordinal()] = 1;
        haE[e.a.UnSelected.ordinal()] = 2;
        AppMethodBeat.o(138664);
    }
}
