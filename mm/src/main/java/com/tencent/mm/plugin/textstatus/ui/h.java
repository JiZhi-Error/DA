package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(216485);
        int[] iArr = new int[TextStatusEditActivity.b.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[TextStatusEditActivity.b.EDT_DESC.ordinal()] = 1;
        int[] iArr2 = new int[TextStatusEditActivity.b.values().length];
        haE = iArr2;
        iArr2[TextStatusEditActivity.b.MAIN.ordinal()] = 1;
        haE[TextStatusEditActivity.b.EDT_DESC.ordinal()] = 2;
        AppMethodBeat.o(216485);
    }
}
