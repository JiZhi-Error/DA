package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(140203);
        int[] iArr = new int[a.b.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[a.b.ChoreographerInJsThread.ordinal()] = 1;
        $EnumSwitchMapping$0[a.b.ChoreographerInMainThread.ordinal()] = 2;
        $EnumSwitchMapping$0[a.b.EglSurfaceSwapLocker.ordinal()] = 3;
        $EnumSwitchMapping$0[a.b.SchedulerLocker.ordinal()] = 4;
        $EnumSwitchMapping$0[a.b.NativeLocker.ordinal()] = 5;
        AppMethodBeat.o(140203);
    }
}
