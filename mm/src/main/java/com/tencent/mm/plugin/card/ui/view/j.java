package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j extends g {
    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final boolean f(b bVar) {
        AppMethodBeat.i(113674);
        if (this.pQV == null) {
            Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            AppMethodBeat.o(113674);
            return true;
        } else if (bVar == null) {
            Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            AppMethodBeat.o(113674);
            return false;
        } else {
            String str = this.pQV.csR().code;
            String str2 = bVar.csR().code;
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || str.equals(str2)) {
                AppMethodBeat.o(113674);
                return false;
            }
            Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            AppMethodBeat.o(113674);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final String e(c cVar) {
        AppMethodBeat.i(113675);
        String str = this.pQV.csR().code;
        AppMethodBeat.o(113675);
        return str;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final ab cxB() {
        AppMethodBeat.i(113676);
        v vVar = new v(this, this.pQZ);
        AppMethodBeat.o(113676);
        return vVar;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final ab cxC() {
        AppMethodBeat.i(113677);
        f fVar = new f(this, this.pQZ);
        AppMethodBeat.o(113677);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final ab cxD() {
        AppMethodBeat.i(113678);
        t tVar = new t(this, this.pQZ);
        AppMethodBeat.o(113678);
        return tVar;
    }
}
