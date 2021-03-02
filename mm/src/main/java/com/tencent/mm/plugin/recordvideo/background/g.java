package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.j;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(75229);
        int[] iArr = new int[j.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[j.OK.ordinal()] = 1;
        $EnumSwitchMapping$0[j.Wait.ordinal()] = 2;
        $EnumSwitchMapping$0[j.Fail.ordinal()] = 3;
        AppMethodBeat.o(75229);
    }
}
