package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(231119);
        int[] iArr = new int[FileSelectorUI.f.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[FileSelectorUI.f.TYPE_TIME.ordinal()] = 1;
        $EnumSwitchMapping$0[FileSelectorUI.f.TYPE_FOLDER.ordinal()] = 2;
        $EnumSwitchMapping$0[FileSelectorUI.f.TYPE_FILE.ordinal()] = 3;
        AppMethodBeat.o(231119);
    }
}
