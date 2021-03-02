package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum r {
    EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND(1),
    EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD(2),
    EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL(3);
    
    public int scene;

    public static r valueOf(String str) {
        AppMethodBeat.i(113872);
        r rVar = (r) Enum.valueOf(r.class, str);
        AppMethodBeat.o(113872);
        return rVar;
    }

    static {
        AppMethodBeat.i(113873);
        AppMethodBeat.o(113873);
    }

    private r(int i2) {
        this.scene = i2;
    }
}
