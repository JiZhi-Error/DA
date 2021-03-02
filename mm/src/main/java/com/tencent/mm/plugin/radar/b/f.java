package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.e;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(138562);
        int[] iArr = new int[e.f.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[e.f.Stopped.ordinal()] = 1;
        $EnumSwitchMapping$0[e.f.Locating.ordinal()] = 2;
        $EnumSwitchMapping$0[e.f.RadarSearching.ordinal()] = 3;
        $EnumSwitchMapping$0[e.f.Waiting.ordinal()] = 4;
        AppMethodBeat.o(138562);
    }
}
