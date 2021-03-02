package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetExportSession;
import kotlin.l;

@l(hxD = {1, 1, 15})
public final /* synthetic */ class o {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        AppMethodBeat.i(216769);
        int[] iArr = new int[AssetExportSession.AssetExportSessionStatus.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting.ordinal()] = 1;
        $EnumSwitchMapping$0[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted.ordinal()] = 2;
        $EnumSwitchMapping$0[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled.ordinal()] = 3;
        $EnumSwitchMapping$0[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed.ordinal()] = 4;
        $EnumSwitchMapping$0[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusUnknown.ordinal()] = 5;
        AppMethodBeat.o(216769);
    }
}
