package com.tencent.mm.plugin.taskbar.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.p;
import com.tencent.mm.g.b.a.r;
import com.tencent.mm.g.b.a.s;

public final class a {
    public String FSr = "";
    public long oCb = 0;

    public final void I(int i2, int i3, String str) {
        AppMethodBeat.i(238102);
        p pVar = new p();
        pVar.ekH = pVar.x("session_id", this.FSr, true);
        pVar.ekR = (long) i2;
        pVar.ekS = (long) i3;
        pVar.ekT = pVar.x("content_id", str, true);
        pVar.bfK();
        AppMethodBeat.o(238102);
    }

    public final void a(int i2, int i3, int i4, String str, int i5) {
        AppMethodBeat.i(238103);
        r rVar = new r();
        rVar.ekH = rVar.x("session_id", this.FSr, true);
        rVar.ekV = rVar.x(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, String.valueOf(i2), true);
        rVar.ekW = (long) i3;
        rVar.ekX = (long) i4;
        rVar.ekT = rVar.x("content_id", str, true);
        rVar.ekU = (long) i5;
        rVar.bfK();
        AppMethodBeat.o(238103);
    }

    public final void J(int i2, int i3, String str) {
        AppMethodBeat.i(238104);
        s sVar = new s();
        sVar.ekH = sVar.x("session_id", this.FSr, true);
        sVar.ekY = (long) i2;
        sVar.ekR = (long) i3;
        sVar.ekZ = sVar.x("conent_list", str, true);
        sVar.bfK();
        AppMethodBeat.o(238104);
    }

    public static int Mm(int i2) {
        switch (i2) {
            case 1:
                return 1;
            case 2:
                return 4;
            case 3:
                return 6;
            case 4:
                return 5;
            case 6:
                return 10;
            case 21:
                return 9;
            case 22:
                return 8;
            default:
                return 0;
        }
    }
}
