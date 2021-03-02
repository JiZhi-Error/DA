package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends IListener<ul> implements i {
    private ul pQD;

    public a() {
        AppMethodBeat.i(161192);
        this.__eventId = ul.class.getName().hashCode();
        AppMethodBeat.o(161192);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ul ulVar) {
        AppMethodBeat.i(112573);
        boolean a2 = a(ulVar);
        AppMethodBeat.o(112573);
        return a2;
    }

    private boolean a(ul ulVar) {
        AppMethodBeat.i(112570);
        if (!g.aAc()) {
            Log.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
            AppMethodBeat.o(112570);
            return false;
        } else if (ulVar instanceof ul) {
            this.pQD = ulVar;
            String str = this.pQD.eaM.eaO;
            String str2 = this.pQD.eaM.eaP;
            int i2 = this.pQD.eaM.eaQ;
            if (TextUtils.isEmpty(str)) {
                Log.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
                ctc();
                AppMethodBeat.o(112570);
                return false;
            }
            g.aAg().hqi.a(1037, this);
            Log.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i2)));
            g.aAg().hqi.a(new o(str, i2, "", str2, "", "", 0, 0, null), 0);
            AppMethodBeat.o(112570);
            return true;
        } else {
            AppMethodBeat.o(112570);
            return false;
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112571);
        if (qVar instanceof o) {
            ul.b bVar = new ul.b();
            Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + i3 + " errmsg" + str);
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
                o oVar = (o) qVar;
                int i4 = oVar.pTZ;
                String str2 = oVar.pTY;
                String str3 = oVar.pUa;
                if (i4 == 0) {
                    Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
                    bVar.isSuccess = true;
                    CardInfo cardInfo = new CardInfo();
                    f.a(cardInfo, str2);
                    if (!TextUtils.isEmpty(cardInfo.field_card_id)) {
                        bVar.eaO = cardInfo.field_card_id;
                    } else {
                        Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
                        bVar.eaO = "";
                    }
                    am.ctV().putValue("key_accept_card_info", cardInfo);
                } else {
                    Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + i4 + " retMsg" + str3);
                    bVar.isSuccess = false;
                }
            } else {
                Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
                bVar.isSuccess = false;
            }
            g.aAg().hqi.b(1037, this);
            this.pQD.eaN = bVar;
            ctc();
        }
        AppMethodBeat.o(112571);
    }

    private void ctc() {
        AppMethodBeat.i(112572);
        if (this.pQD.callback != null) {
            this.pQD.callback.run();
        }
        this.pQD = null;
        AppMethodBeat.o(112572);
    }
}
