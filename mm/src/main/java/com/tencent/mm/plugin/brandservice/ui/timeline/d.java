package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.sdk.event.IListener;

public final class d {
    IListener lEl = new IListener<mx>() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.d.AnonymousClass1 */

        {
            AppMethodBeat.i(160483);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(160483);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(5903);
            switch (mxVar.dSE.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    d.this.prW.cmy();
                    break;
            }
            AppMethodBeat.o(5903);
            return false;
        }
    };
    g prW;

    public d(g gVar) {
        AppMethodBeat.i(5904);
        this.prW = gVar;
        AppMethodBeat.o(5904);
    }
}
