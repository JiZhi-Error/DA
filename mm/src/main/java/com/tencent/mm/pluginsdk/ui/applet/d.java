package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class d implements x {
    @Override // com.tencent.mm.pluginsdk.ui.applet.x
    public final boolean beE(String str) {
        AppMethodBeat.i(124373);
        boolean DQ = g.DQ(str);
        AppMethodBeat.o(124373);
        return DQ;
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.x
    public final Object beF(String str) {
        AppMethodBeat.i(124374);
        k fB = ag.bal().fB(str);
        if (fB == null || Util.isNullOrNil(fB.field_userId) || !fB.field_userId.equals(str)) {
            fB = new k();
            fB.field_userId = str;
        }
        AppMethodBeat.o(124374);
        return fB;
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.x
    public final c beG(String str) {
        AppMethodBeat.i(124375);
        c.a aVar = new c.a();
        aVar.prefixPath = e.NN(str);
        aVar.jbf = true;
        aVar.hZF = true;
        aVar.jbq = R.raw.default_avatar;
        c bdv = aVar.bdv();
        AppMethodBeat.o(124375);
        return bdv;
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.x
    public final String dX(Object obj) {
        return ((k) obj).field_userName;
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.x
    public final String dY(Object obj) {
        return ((k) obj).field_headImageUrl;
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.x
    public final String dZ(Object obj) {
        return ((k) obj).field_userId;
    }
}
