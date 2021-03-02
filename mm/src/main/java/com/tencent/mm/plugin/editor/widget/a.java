package com.tencent.mm.plugin.editor.widget;

import android.content.DialogInterface;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.editor.model.a.j;
import com.tencent.mm.plugin.editor.model.a.m;
import com.tencent.mm.plugin.editor.model.c;
import com.tencent.mm.plugin.editor.model.nativenote.b.b;
import com.tencent.mm.plugin.editor.model.nativenote.spans.t;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.vfs.s;

public final class a implements com.tencent.mm.plugin.editor.model.b.a, b {
    public View psf;
    String qPr = "";
    public WeImageButton qTN;
    public WeImageButton qTO;
    public WeImageButton qTP;
    public WeImageButton qTQ;
    public LinearLayout qTR;
    public LinearLayout qTS;
    public LinearLayout qTT;
    public LinearLayout qTU;
    public LinearLayout qTV;
    public LinearLayout qTW;
    public boolean qTX = false;
    a qTY = this;
    boolean qTZ = false;
    boolean qUa = false;
    boolean qUb = false;
    boolean qUc = false;
    public boolean qUd;

    public a() {
        AppMethodBeat.i(181982);
        AppMethodBeat.o(181982);
    }

    @Override // com.tencent.mm.plugin.editor.model.b.a
    public final void cDi() {
        AppMethodBeat.i(181983);
        h.a(this.qTQ.getContext(), this.qTQ.getContext().getString(R.string.fwv), "", true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(181972);
                a.this.a((com.tencent.mm.plugin.editor.model.nativenote.b.a) null);
                AppMethodBeat.o(181972);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(181983);
    }

    @Override // com.tencent.mm.plugin.editor.model.b.a
    public final void cDh() {
        AppMethodBeat.i(181984);
        a((com.tencent.mm.plugin.editor.model.nativenote.b.a) null);
        AppMethodBeat.o(181984);
    }

    public final void a(com.tencent.mm.plugin.editor.model.nativenote.b.a aVar) {
        AppMethodBeat.i(181985);
        this.qTQ.setImageResource(R.drawable.t5);
        if (!this.qTX) {
            AppMethodBeat.o(181985);
            return;
        }
        this.qTX = false;
        c.cCZ().cDa();
        String cDb = c.cCZ().cDb();
        int i2 = (int) c.cCZ().duration;
        int AO = (int) com.tencent.mm.plugin.editor.b.AO((long) i2);
        int cDt = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDt();
        com.tencent.mm.plugin.editor.model.a.a Fw = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(cDt);
        if (!s.YS(cDb)) {
            Log.e("MicroMsg.EditorFooterPanel", "voicePath not exist, remove data from data list and ui.");
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().ae(cDt, false);
            if (aVar != null) {
                aVar.Ft(cDt);
            }
            j jVar = new j();
            jVar.content = "";
            jVar.qPA = true;
            jVar.qPG = false;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(cDt, jVar);
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().fx(cDt - 1, cDt + 1);
            AppMethodBeat.o(181985);
            return;
        }
        if (!(cDt == -1 || Fw == null || Fw.getType() != 4)) {
            ((m) Fw).qPX = Boolean.FALSE;
            ((m) Fw).type = 4;
            ((m) Fw).qPO = true;
            ((m) Fw).qPS = "";
            ((m) Fw).length = AO;
            ((m) Fw).qPR = com.tencent.mm.plugin.editor.b.J(MMApplicationContext.getContext(), AO).toString();
            ((m) Fw).mav = ao.cVg() + "/fav_fileicon_recording.png";
            ((m) Fw).dUs = cDb;
            ((m) Fw).dLu = i2;
            com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fy(cDt);
        }
        AppMethodBeat.o(181985);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.b
    public final void lh(boolean z) {
        AppMethodBeat.i(181986);
        this.qUc = z;
        this.qTW.setPressed(z);
        AppMethodBeat.o(181986);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.b
    public final void li(boolean z) {
        AppMethodBeat.i(181987);
        this.qTZ = z;
        this.qTS.setPressed(z);
        AppMethodBeat.o(181987);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.b
    public final void lj(boolean z) {
        AppMethodBeat.i(181988);
        this.qUa = z;
        this.qTT.setPressed(z);
        AppMethodBeat.o(181988);
    }

    @Override // com.tencent.mm.plugin.editor.model.nativenote.b.b
    public final void lk(boolean z) {
        AppMethodBeat.i(181989);
        this.qUb = z;
        this.qTV.setPressed(z);
        AppMethodBeat.o(181989);
    }

    static /* synthetic */ int a(a aVar) {
        AppMethodBeat.i(181990);
        if (aVar.psf == null || aVar.psf.getVisibility() == 8) {
            AppMethodBeat.o(181990);
            return 0;
        } else if (aVar.qTR.getVisibility() == 0) {
            AppMethodBeat.o(181990);
            return 3;
        } else {
            AppMethodBeat.o(181990);
            return 1;
        }
    }

    static /* synthetic */ void c(t tVar, Object obj) {
        AppMethodBeat.i(181991);
        if (com.tencent.mm.plugin.editor.model.nativenote.manager.j.cDP() != null) {
            com.tencent.mm.plugin.editor.model.nativenote.manager.j.cDP().b(tVar, obj);
        }
        AppMethodBeat.o(181991);
    }

    static /* synthetic */ void a(a aVar, final View view, final boolean z) {
        AppMethodBeat.i(181992);
        view.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.editor.widget.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(181973);
                view.setPressed(z);
                AppMethodBeat.o(181973);
            }
        }, 100);
        AppMethodBeat.o(181992);
    }

    static /* synthetic */ void b(com.tencent.mm.plugin.editor.model.nativenote.b.a aVar) {
        AppMethodBeat.i(181993);
        aVar.e(true, 50);
        aVar.Q(1, 0);
        AppMethodBeat.o(181993);
    }
}
