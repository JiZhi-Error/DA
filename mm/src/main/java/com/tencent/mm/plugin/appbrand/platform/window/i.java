package com.tencent.mm.plugin.appbrand.platform.window;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class i {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(219770);
        int[] iArr = new int[e.b.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[e.b.PORTRAIT.ordinal()] = 1;
        $EnumSwitchMapping$0[e.b.LANDSCAPE_SENSOR.ordinal()] = 2;
        $EnumSwitchMapping$0[e.b.LANDSCAPE_LOCKED.ordinal()] = 3;
        $EnumSwitchMapping$0[e.b.LANDSCAPE_LEFT.ordinal()] = 4;
        $EnumSwitchMapping$0[e.b.LANDSCAPE_RIGHT.ordinal()] = 5;
        $EnumSwitchMapping$0[e.b.UNSPECIFIED.ordinal()] = 6;
        AppMethodBeat.o(219770);
    }
}
