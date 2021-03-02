package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public class ao extends a implements af {
    private IListener lEl = new IListener<mx>() {
        /* class com.tencent.mm.ui.chatting.d.ao.AnonymousClass1 */

        {
            AppMethodBeat.i(161532);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(161532);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(35501);
            switch (mxVar.dSE.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    if (ao.this.dom != null) {
                        ao.this.dom.cmy();
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(35501);
            return false;
        }
    };

    public ao() {
        AppMethodBeat.i(35502);
        AppMethodBeat.o(35502);
    }

    private void gOL() {
        AppMethodBeat.i(35503);
        EventCenter.instance.removeListener(this.lEl);
        AppMethodBeat.o(35503);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35505);
        gOL();
        AppMethodBeat.o(35505);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35506);
        super.gOK();
        gOL();
        AppMethodBeat.o(35506);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35504);
        EventCenter.instance.addListener(this.lEl);
        AppMethodBeat.o(35504);
    }
}
