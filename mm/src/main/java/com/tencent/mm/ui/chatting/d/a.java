package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.d.b.n;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.m;

public class a extends l implements ag, m {
    protected com.tencent.mm.ui.chatting.e.a dom;

    @Override // com.tencent.mm.ui.chatting.d.ag
    public void a(com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(35067);
        this.dom = aVar;
        ((j) this.dom.bh(j.class)).a(this);
        ((n) this.dom.bh(n.class)).a(this);
        AppMethodBeat.o(35067);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag
    public void gOK() {
        AppMethodBeat.i(35068);
        ((j) this.dom.bh(j.class)).b(this);
        ((n) this.dom.bh(n.class)).b(this);
        AppMethodBeat.o(35068);
    }

    @Override // com.tencent.mm.ui.m
    public void gIk() {
    }

    @Override // com.tencent.mm.ui.m
    public void gIl() {
    }

    @Override // com.tencent.mm.ui.m
    public void gIm() {
    }

    @Override // com.tencent.mm.ui.m
    public void cFx() {
    }

    @Override // com.tencent.mm.ui.m
    public void cFy() {
    }

    @Override // com.tencent.mm.ui.m
    public void gIn() {
    }

    @Override // com.tencent.mm.ui.m
    public void gIo() {
    }
}
