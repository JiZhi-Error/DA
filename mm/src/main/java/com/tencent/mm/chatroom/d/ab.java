package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ae;

public final class ab {
    public static void b(String str, int i2, int i3, int i4) {
        int i5;
        AppMethodBeat.i(184787);
        if (com.tencent.mm.model.ab.JO(str)) {
            i5 = 2;
        } else {
            i5 = 1;
        }
        ae aeVar = new ae();
        aeVar.enK = aeVar.x("roomusrname", str, true);
        aeVar.enL = (long) i2;
        aeVar.enM = (long) i5;
        aeVar.enN = (long) i3;
        aeVar.enO = (long) i4;
        aeVar.bfK();
        AppMethodBeat.o(184787);
    }
}
