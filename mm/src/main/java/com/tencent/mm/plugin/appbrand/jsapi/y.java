package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ad;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class y {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(135568);
        int[] iArr = new int[ad.a.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[ad.a.LANDSCAPE.ordinal()] = 1;
        $EnumSwitchMapping$0[ad.a.REVERSE_LANDSCAPE.ordinal()] = 2;
        $EnumSwitchMapping$0[ad.a.PORTRAIT.ordinal()] = 3;
        AppMethodBeat.o(135568);
    }
}
