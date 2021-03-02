package com.tencent.mm.plugin.festival.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.model.FestivalWishContextBundle;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final /* synthetic */ class bt {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] haE;

    static {
        AppMethodBeat.i(262852);
        int[] iArr = new int[FestivalWishContextBundle.a.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[FestivalWishContextBundle.a.GoSetState.ordinal()] = 1;
        $EnumSwitchMapping$0[FestivalWishContextBundle.a.NONE.ordinal()] = 2;
        int[] iArr2 = new int[b.c.values().length];
        haE = iArr2;
        iArr2[b.c.wLX.ordinal()] = 1;
        AppMethodBeat.o(262852);
    }
}
