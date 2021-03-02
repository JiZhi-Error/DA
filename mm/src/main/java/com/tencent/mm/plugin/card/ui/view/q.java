package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q extends g {
    public String qdP = "";

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final boolean f(b bVar) {
        AppMethodBeat.i(113702);
        if (this.pQV == null) {
            Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            AppMethodBeat.o(113702);
            return true;
        } else if (bVar == null) {
            Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            AppMethodBeat.o(113702);
            return false;
        } else {
            String str = this.pQV.csR().code;
            String str2 = bVar.csR().code;
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || str.equals(str2)) {
                abz abz = this.pQV.csQ().Lfe;
                abz abz2 = bVar.csQ().Lfe;
                if ((abz == null && abz2 != null) || (abz != null && abz2 == null)) {
                    Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    AppMethodBeat.o(113702);
                    return true;
                } else if (abz != null && abz2 != null && abz.title != null && abz2.title != null && !abz.title.equals(abz2.title)) {
                    Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    AppMethodBeat.o(113702);
                    return true;
                } else if (abz != null && abz2 != null && abz.pRZ != null && abz2.pRZ != null && !abz.pRZ.equals(abz2.pRZ)) {
                    Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    AppMethodBeat.o(113702);
                    return true;
                } else if (!this.pQV.csK() || Util.isNullOrNil(this.qdP)) {
                    AppMethodBeat.o(113702);
                    return false;
                } else {
                    Log.i("MicroMsg.CardCodeView", "dynamicCode updated！");
                    AppMethodBeat.o(113702);
                    return true;
                }
            } else {
                Log.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
                AppMethodBeat.o(113702);
                return true;
            }
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final String e(c cVar) {
        AppMethodBeat.i(113703);
        if (!Util.isNullOrNil(this.pQV.csR().LcE)) {
            String str = this.pQV.csR().LcE;
            AppMethodBeat.o(113703);
            return str;
        } else if (!this.pQV.csK() || Util.isNullOrNil(this.qdP)) {
            String str2 = this.pQV.csR().code;
            AppMethodBeat.o(113703);
            return str2;
        } else {
            String str3 = this.qdP;
            AppMethodBeat.o(113703);
            return str3;
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final ab cxB() {
        AppMethodBeat.i(113704);
        s sVar = new s(this, this.pQZ);
        AppMethodBeat.o(113704);
        return sVar;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final ab cxC() {
        AppMethodBeat.i(113705);
        p pVar = new p(this, this.pQZ);
        AppMethodBeat.o(113705);
        return pVar;
    }

    @Override // com.tencent.mm.plugin.card.ui.view.g
    public final ab cxD() {
        AppMethodBeat.i(113706);
        r rVar = new r(this, this.pQZ);
        AppMethodBeat.o(113706);
        return rVar;
    }
}
