package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.b.a;
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;

public final class c implements a, b {
    ImageButton JKA;
    LinearLayout JKB;
    LinearLayout JKC;
    LinearLayout JKD;
    LinearLayout JKE;
    LinearLayout JKF;
    c JKG = this;
    ImageButton JKv;
    LinearLayout JKw;
    ImageButton JKx;
    ImageButton JKy;
    ImageButton JKz;
    View kvj;
    String qPr = "";
    public boolean qTX = false;
    boolean qTZ = false;
    boolean qUa = false;
    boolean qUb = false;
    boolean qUc = false;

    public c() {
        AppMethodBeat.i(30825);
        AppMethodBeat.o(30825);
    }

    @Override // com.tencent.mm.plugin.wenote.model.b.a
    public final void cDi() {
        AppMethodBeat.i(30826);
        h.a(this.JKA.getContext(), this.JKA.getContext().getString(R.string.feg), "", true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(30815);
                c.this.a((com.tencent.mm.plugin.wenote.model.nativenote.b.a) null);
                AppMethodBeat.o(30815);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(30826);
    }

    @Override // com.tencent.mm.plugin.wenote.model.b.a
    public final void cDh() {
        AppMethodBeat.i(30827);
        a((com.tencent.mm.plugin.wenote.model.nativenote.b.a) null);
        AppMethodBeat.o(30827);
    }

    public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
        AppMethodBeat.i(30828);
        this.JKA.setImageResource(R.drawable.b5y);
        if (!this.qTX) {
            AppMethodBeat.o(30828);
            return;
        }
        this.qTX = false;
        k.gjD().cDa();
        String cDb = k.gjD().cDb();
        int i2 = (int) k.gjD().duration;
        int AO = (int) com.tencent.mm.bl.a.AO((long) i2);
        int cDt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDt();
        com.tencent.mm.plugin.wenote.model.a.c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(cDt);
        if (!s.YS(cDb)) {
            Log.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ae(cDt, false);
            if (aVar != null) {
                aVar.Ft(cDt);
            }
            i iVar = new i();
            iVar.content = "";
            iVar.qPA = true;
            iVar.qPG = false;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(cDt, iVar);
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fx(cDt - 1, cDt + 1);
            AppMethodBeat.o(30828);
            return;
        }
        if (!(cDt == -1 || ahp == null || ahp.getType() != 4)) {
            ((l) ahp).qPX = Boolean.FALSE;
            ((l) ahp).type = 4;
            ((l) ahp).qPO = true;
            ((l) ahp).qPS = "";
            ((l) ahp).length = AO;
            ((l) ahp).qPR = com.tencent.mm.bl.a.J(MMApplicationContext.getContext(), AO).toString();
            ((l) ahp).mav = ao.cVg() + "/fav_fileicon_recording.png";
            ((l) ahp).dUs = cDb;
            ((l) ahp).dLu = i2;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().Fy(cDt);
        }
        AppMethodBeat.o(30828);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.b
    public final void lh(boolean z) {
        AppMethodBeat.i(30829);
        this.qUc = z;
        this.JKB.setPressed(z);
        AppMethodBeat.o(30829);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.b
    public final void li(boolean z) {
        AppMethodBeat.i(30830);
        this.qTZ = z;
        this.JKC.setPressed(z);
        AppMethodBeat.o(30830);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.b
    public final void lj(boolean z) {
        AppMethodBeat.i(30831);
        this.qUa = z;
        this.JKD.setPressed(z);
        AppMethodBeat.o(30831);
    }

    @Override // com.tencent.mm.plugin.wenote.model.nativenote.b.b
    public final void lk(boolean z) {
        AppMethodBeat.i(30832);
        this.qUb = z;
        this.JKF.setPressed(z);
        AppMethodBeat.o(30832);
    }

    static /* synthetic */ int a(c cVar) {
        AppMethodBeat.i(30833);
        if (cVar.kvj == null || cVar.kvj.getVisibility() == 8) {
            AppMethodBeat.o(30833);
            return 0;
        } else if (cVar.JKw.getVisibility() == 0) {
            AppMethodBeat.o(30833);
            return 3;
        } else {
            AppMethodBeat.o(30833);
            return 1;
        }
    }

    static /* synthetic */ void c(t tVar, Object obj) {
        AppMethodBeat.i(30834);
        if (com.tencent.mm.plugin.wenote.model.nativenote.manager.k.gjR() != null) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.k.gjR().b(tVar, obj);
        }
        AppMethodBeat.o(30834);
    }

    static /* synthetic */ void a(c cVar, final View view, final boolean z) {
        AppMethodBeat.i(30835);
        view.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.c.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(30816);
                view.setPressed(z);
                AppMethodBeat.o(30816);
            }
        }, 100);
        AppMethodBeat.o(30835);
    }

    static /* synthetic */ void b(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
        AppMethodBeat.i(30836);
        aVar.e(true, 50);
        aVar.Q(1, 0);
        AppMethodBeat.o(30836);
    }
}
