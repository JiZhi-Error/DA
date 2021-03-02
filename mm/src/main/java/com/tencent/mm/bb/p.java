package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.sdk.event.IListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p {
    Map<Integer, Object<?>> jhs = new ConcurrentHashMap();
    public IListener jht = new IListener<yq>() {
        /* class com.tencent.mm.bb.p.AnonymousClass1 */

        {
            AppMethodBeat.i(161777);
            this.__eventId = yq.class.getName().hashCode();
            AppMethodBeat.o(161777);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yq yqVar) {
            AppMethodBeat.i(150831);
            p.this.jhs.get(Integer.valueOf(yqVar.eeU.packageType));
            AppMethodBeat.o(150831);
            return false;
        }
    };
    public IListener jhu = new IListener<cw>() {
        /* class com.tencent.mm.bb.p.AnonymousClass2 */

        {
            AppMethodBeat.i(161778);
            this.__eventId = cw.class.getName().hashCode();
            AppMethodBeat.o(161778);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(cw cwVar) {
            AppMethodBeat.i(150832);
            p.this.jhs.get(Integer.valueOf(cwVar.dFY.packageType));
            AppMethodBeat.o(150832);
            return false;
        }
    };

    public p() {
        AppMethodBeat.i(150833);
        AppMethodBeat.o(150833);
    }
}
