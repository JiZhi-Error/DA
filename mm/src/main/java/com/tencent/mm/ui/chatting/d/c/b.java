package com.tencent.mm.ui.chatting.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.d.a;

public final class b extends a implements com.tencent.mm.ui.chatting.d.b.a {
    private a PvX;

    public b(a aVar) {
        this.PvX = aVar;
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void a(com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(35804);
        super.a(aVar);
        if (this.PvX != null) {
            this.PvX.a(aVar);
        }
        AppMethodBeat.o(35804);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35805);
        super.gOK();
        if (this.PvX != null) {
            this.PvX.gOK();
        }
        AppMethodBeat.o(35805);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIk() {
        AppMethodBeat.i(35806);
        if (gPo()) {
            this.PvX.gIk();
        }
        AppMethodBeat.o(35806);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35807);
        if (gPo()) {
            this.PvX.gIl();
        }
        AppMethodBeat.o(35807);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35808);
        if (gPo()) {
            this.PvX.gIm();
        }
        AppMethodBeat.o(35808);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(35809);
        if (gPo()) {
            this.PvX.cFx();
        }
        AppMethodBeat.o(35809);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35810);
        if (gPo()) {
            this.PvX.cFy();
        }
        AppMethodBeat.o(35810);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35811);
        if (gPo()) {
            this.PvX.gIn();
        }
        AppMethodBeat.o(35811);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIo() {
        AppMethodBeat.i(35812);
        if (gPo()) {
            this.PvX.gIo();
        }
        AppMethodBeat.o(35812);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.a
    public final void gPx() {
        AppMethodBeat.i(35813);
        if (gPo()) {
            this.PvX.gPx();
        }
        AppMethodBeat.o(35813);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.a
    public final void gRG() {
        AppMethodBeat.i(35814);
        if (gPo()) {
            this.PvX.gRG();
        }
        AppMethodBeat.o(35814);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.a
    public final String gRH() {
        AppMethodBeat.i(35815);
        if (gPo()) {
            String gRH = this.PvX.gRH();
            AppMethodBeat.o(35815);
            return gRH;
        }
        AppMethodBeat.o(35815);
        return null;
    }

    private boolean gPo() {
        AppMethodBeat.i(35816);
        if (Util.isNullOrNil(this.dom.getTalkerUserName())) {
            AppMethodBeat.o(35816);
            return false;
        } else if (ab.JB(this.dom.getTalkerUserName())) {
            AppMethodBeat.o(35816);
            return false;
        } else if (this.PvX != null) {
            AppMethodBeat.o(35816);
            return true;
        } else {
            AppMethodBeat.o(35816);
            return false;
        }
    }
}
