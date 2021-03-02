package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.p;

@a(gRF = s.class)
public class v extends a implements s {
    private long[] PgO = null;
    private boolean Ppw = false;
    private p Ppx = null;

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35297);
        this.Ppw = this.dom.Pwc.getBooleanExtra("expose_edit_mode", false).booleanValue();
        this.PgO = this.dom.Pwc.getArguments().getLongArray("expose_selected_ids");
        AppMethodBeat.o(35297);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35299);
        super.gIm();
        if (this.Ppx != null) {
            p pVar = this.Ppx;
            k kVar = (k) pVar.dom.bh(k.class);
            ((am) pVar.dom.bh(am.class)).gQW();
            kVar.gOz();
            kVar.gOt();
            if (pVar.PgO != null) {
                for (long j2 : pVar.PgO) {
                    kVar.Nu(j2);
                }
            }
            ChatFooter gPO = ((u) pVar.dom.bh(u.class)).gPO();
            if (gPO != null) {
                gPO.setVisibility(8);
            }
            ChatFooterCustom gPP = ((u) pVar.dom.bh(u.class)).gPP();
            if (gPP != null) {
                gPP.setVisibility(8);
            }
            ((com.tencent.mm.ui.chatting.d.b.p) pVar.dom.bh(com.tencent.mm.ui.chatting.d.b.p.class)).gPM();
            pVar.dom.hideVKB();
            ((aw) pVar.dom.bh(aw.class)).gRy();
            pVar.dom.BW(true);
        }
        AppMethodBeat.o(35299);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.s
    public final boolean gPN() {
        return this.Ppw;
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35298);
        if (this.Ppw && this.Ppx == null) {
            this.Ppx = new p(this.dom, this.PgO);
        }
        AppMethodBeat.o(35298);
    }
}
