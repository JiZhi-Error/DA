package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.luckymoney.a.d;
import com.tencent.mm.plugin.wxpay.a.a;

public class as extends a implements af {
    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(163320);
        if (ab.IN(this.dom.getTalkerUserName())) {
            ((a) g.ah(a.class)).doRedPacketPreviewLoading(this.dom.Pwc.getContext(), this.dom.Pwc.getContext().getIntent().getStringExtra("key_red_packet_preview_url"));
            d.bFT();
        }
        AppMethodBeat.o(163320);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(163321);
        super.gOK();
        ((a) g.ah(a.class)).onExitRedPacketPreviewChatting();
        d.xV(3);
        d.resetSession();
        AppMethodBeat.o(163321);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIo() {
        AppMethodBeat.i(163322);
        super.gIo();
        d.xV(3);
        d.resetSession();
        AppMethodBeat.o(163322);
    }
}
