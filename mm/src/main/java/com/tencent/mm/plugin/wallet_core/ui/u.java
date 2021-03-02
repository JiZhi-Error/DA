package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class u implements i {
    public b IkQ;
    private a IkR;
    public boolean dEF = false;

    public interface a {
        void cancel();

        void ehm();

        void ehn();
    }

    public interface b {
        int eho();

        Context getContext();
    }

    public final void onResume() {
        AppMethodBeat.i(71301);
        g.aAi();
        g.aAg().hqi.a(2541, this);
        g.aAi();
        g.aAg().hqi.a(2791, this);
        AppMethodBeat.o(71301);
    }

    public final void onPause() {
        AppMethodBeat.i(71302);
        g.aAi();
        g.aAg().hqi.b(2541, this);
        g.aAi();
        g.aAg().hqi.b(2791, this);
        AppMethodBeat.o(71302);
    }

    public final void ehm() {
        AppMethodBeat.i(71303);
        t tVar = new t();
        g.aAi();
        g.aAg().hqi.a(tVar, 0);
        if (this.IkR != null) {
            this.IkR.ehm();
        }
        AppMethodBeat.o(71303);
    }

    public final void cancel() {
        AppMethodBeat.i(71304);
        if (this.IkR != null) {
            this.IkR.cancel();
        }
        AppMethodBeat.o(71304);
    }

    public final void a(a aVar, boolean z) {
        AppMethodBeat.i(71305);
        this.IkR = aVar;
        g.aAi();
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        Log.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", Boolean.valueOf(booleanValue), Boolean.valueOf(z));
        if (booleanValue) {
            aVar.ehn();
            AppMethodBeat.o(71305);
        } else if (this.dEF) {
            Log.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", Boolean.valueOf(this.dEF));
            aVar.ehn();
            AppMethodBeat.o(71305);
        } else if (z) {
            this.dEF = true;
            j jVar = new j();
            g.aAi();
            g.aAg().hqi.a(jVar, 0);
            AppMethodBeat.o(71305);
        } else {
            aVar.ehn();
            AppMethodBeat.o(71305);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71306);
        if (!(qVar instanceof j)) {
            if (qVar instanceof t) {
                if (i2 == 0 && i3 == 0) {
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.TRUE);
                    Log.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
                } else {
                    AppMethodBeat.o(71306);
                    return;
                }
            }
            AppMethodBeat.o(71306);
        } else if (i2 == 0 && i3 == 0) {
            j jVar = (j) qVar;
            Log.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(ao.bJw()), jVar.HPH, Boolean.valueOf(jVar.HPI));
            if (!ao.bJw() || !jVar.HPI) {
                if (this.IkR != null) {
                    this.IkR.ehn();
                }
                AppMethodBeat.o(71306);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("agreement_content", jVar.HPH);
            c.b(this.IkQ.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", intent, this.IkQ.eho());
            AppMethodBeat.o(71306);
        } else {
            AppMethodBeat.o(71306);
        }
    }
}
