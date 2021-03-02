package com.tencent.mm.plugin.expt.j;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashSet;
import java.util.Iterator;

public final class a {
    private static a sLs;
    public IListener<fp> gmC = new IListener<fp>() {
        /* class com.tencent.mm.plugin.expt.j.a.AnonymousClass1 */

        {
            AppMethodBeat.i(220643);
            this.__eventId = fp.class.getName().hashCode();
            AppMethodBeat.o(220643);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(220644);
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.expt.j.a.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(220642);
                    Iterator<b> it = a.this.sLt.iterator();
                    while (it.hasNext()) {
                        it.next().axE();
                    }
                    AppMethodBeat.o(220642);
                }
            });
            AppMethodBeat.o(220644);
            return false;
        }
    };
    HashSet<b> sLt = new HashSet<>();

    public static a cSe() {
        AppMethodBeat.i(220645);
        if (sLs == null) {
            sLs = new a();
        }
        a aVar = sLs;
        AppMethodBeat.o(220645);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(220646);
        this.sLt.add(new c());
        this.sLt.add(new d());
        AppMethodBeat.o(220646);
    }
}
