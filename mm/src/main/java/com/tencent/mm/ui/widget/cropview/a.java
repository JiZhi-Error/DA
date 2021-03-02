package com.tencent.mm.ui.widget.cropview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(164383);
        int[] iArr = new int[CropLayout.e.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[CropLayout.e.CENTER_INSIDE.ordinal()] = 1;
        $EnumSwitchMapping$0[CropLayout.e.CENTER_CROP.ordinal()] = 2;
        $EnumSwitchMapping$0[CropLayout.e.ALIGN_START.ordinal()] = 3;
        int[] iArr2 = new int[CropLayout.e.values().length];
        haE = iArr2;
        iArr2[CropLayout.e.CENTER_INSIDE.ordinal()] = 1;
        haE[CropLayout.e.CENTER_CROP.ordinal()] = 2;
        haE[CropLayout.e.ALIGN_START.ordinal()] = 3;
        AppMethodBeat.o(164383);
    }
}
