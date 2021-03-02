package com.tencent.mm.plugin.appbrand.launching.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.am;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(228762);
        int[] iArr = new int[am.a.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[am.a.NONE.ordinal()] = 1;
        $EnumSwitchMapping$0[am.a.MISSING_PKG.ordinal()] = 2;
        $EnumSwitchMapping$0[am.a.NO_USE_RECENT.ordinal()] = 3;
        $EnumSwitchMapping$0[am.a.INVALID_FIELDS.ordinal()] = 4;
        $EnumSwitchMapping$0[am.a.VERSION_NOT_FOUND.ordinal()] = 5;
        $EnumSwitchMapping$0[am.a.PATH_NOT_FOUND.ordinal()] = 6;
        $EnumSwitchMapping$0[am.a.CMD_UPDATE_VERSION.ordinal()] = 7;
        $EnumSwitchMapping$0[am.a.ATTRS_NOT_FOUND.ordinal()] = 8;
        AppMethodBeat.o(228762);
    }
}
