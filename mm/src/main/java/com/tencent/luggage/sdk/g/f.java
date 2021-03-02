package com.tencent.luggage.sdk.g;

import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(176451);
        int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
        $EnumSwitchMapping$0[ConsoleMessage.MessageLevel.LOG.ordinal()] = 2;
        $EnumSwitchMapping$0[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 3;
        $EnumSwitchMapping$0[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 4;
        $EnumSwitchMapping$0[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 5;
        AppMethodBeat.o(176451);
    }
}
