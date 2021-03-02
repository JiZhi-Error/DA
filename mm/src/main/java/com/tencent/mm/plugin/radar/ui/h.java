package com.tencent.mm.plugin.radar.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.e;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class h {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;
    public static final /* synthetic */ int[] uqL;

    static {
        AppMethodBeat.i(138745);
        int[] iArr = new int[c.e.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[c.e.Stranger.ordinal()] = 1;
        $EnumSwitchMapping$0[c.e.NeedVerify.ordinal()] = 2;
        int[] iArr2 = new int[e.EnumC1621e.values().length];
        haE = iArr2;
        iArr2[e.EnumC1621e.SEARCHING.ordinal()] = 1;
        haE[e.EnumC1621e.SEARCH_RETRUN.ordinal()] = 2;
        haE[e.EnumC1621e.RALATIONCHAIN_RETRUN.ordinal()] = 3;
        int[] iArr3 = new int[e.EnumC1621e.values().length];
        uqL = iArr3;
        iArr3[e.EnumC1621e.SEARCHING.ordinal()] = 1;
        uqL[e.EnumC1621e.SEARCH_RETRUN.ordinal()] = 2;
        uqL[e.EnumC1621e.RALATIONCHAIN.ordinal()] = 3;
        uqL[e.EnumC1621e.RALATIONCHAIN_RETRUN.ordinal()] = 4;
        uqL[e.EnumC1621e.CREATING_CHAT.ordinal()] = 5;
        AppMethodBeat.o(138745);
    }
}
