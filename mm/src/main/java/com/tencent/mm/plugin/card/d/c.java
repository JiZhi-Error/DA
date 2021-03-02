package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT(0),
    CARDCODEREFRESHACTION_SHOWING_TIMEOUT(1),
    CARDCODEREFRESHACTION_SNAPSHOT(2),
    CARDCODEREFRESHACTION_DOREFRESH(3),
    CARDCODEREFRESHACTION_ENTERFOREGROUND(4),
    CARDCODEREFRESHACTION_BANCODE(5),
    CARDCODEREFRESHACTION_UPDATECHANGE(6),
    CARDCODEREFRESHACTION_ENTERCHANGE(7);
    
    public int action = 0;

    public static c valueOf(String str) {
        AppMethodBeat.i(113752);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(113752);
        return cVar;
    }

    static {
        AppMethodBeat.i(113753);
        AppMethodBeat.o(113753);
    }

    private c(int i2) {
        this.action = i2;
    }
}
