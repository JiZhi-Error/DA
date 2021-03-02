package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public final class a {
    private static final a jij = new a();
    public long jii;

    static {
        AppMethodBeat.i(116858);
        AppMethodBeat.o(116858);
    }

    public a() {
        AppMethodBeat.i(116857);
        if (g.aAc()) {
            this.jii = z.aUd();
            AppMethodBeat.o(116857);
            return;
        }
        EventCenter.instance.add(new IListener<cp>() {
            /* class com.tencent.mm.be.a.AnonymousClass1 */

            {
                AppMethodBeat.i(161766);
                this.__eventId = cp.class.getName().hashCode();
                AppMethodBeat.o(161766);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(cp cpVar) {
                AppMethodBeat.i(116856);
                if (g.aAc()) {
                    a.this.jii = z.aUd();
                }
                AppMethodBeat.o(116856);
                return true;
            }
        });
        AppMethodBeat.o(116857);
    }

    public static a beA() {
        return jij;
    }
}
