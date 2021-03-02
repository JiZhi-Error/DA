package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.e;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class j {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(228445);
        int[] iArr = new int[e.f.a.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[e.f.a.SUCCESS.ordinal()] = 1;
        $EnumSwitchMapping$0[e.f.a.FAIL.ordinal()] = 2;
        $EnumSwitchMapping$0[e.f.a.CANCEL.ordinal()] = 3;
        AppMethodBeat.o(228445);
    }
}
