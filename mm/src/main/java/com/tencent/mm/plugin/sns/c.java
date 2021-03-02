package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends IListener<gd> {
    public c() {
        AppMethodBeat.i(160631);
        this.__eventId = gd.class.getName().hashCode();
        AppMethodBeat.o(160631);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(gd gdVar) {
        AppMethodBeat.i(94888);
        boolean a2 = a(gdVar);
        AppMethodBeat.o(94888);
        return a2;
    }

    private boolean a(final gd gdVar) {
        AppMethodBeat.i(94887);
        if (!(gdVar instanceof gd)) {
            Log.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
            AppMethodBeat.o(94887);
            return false;
        }
        aq.a faE = aj.faE();
        faE.a(gdVar.dJK.type, gdVar.dJK.username, new i.a() {
            /* class com.tencent.mm.plugin.sns.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.b.i.a
            public final void a(String str, boolean z, int i2, b bVar) {
                AppMethodBeat.i(94886);
                if (gdVar.dJK != null) {
                    gdVar.dJK.dJO.a(null);
                }
                AppMethodBeat.o(94886);
            }

            @Override // com.tencent.mm.plugin.sns.b.i.a
            public final void b(String str, boolean z, int i2, b bVar) {
            }

            @Override // com.tencent.mm.plugin.sns.b.i.a
            public final void a(String str, String str2, boolean z, int i2, b bVar) {
            }
        });
        faE.a(1, gdVar.dJK.username, gdVar.dJK.dJM, gdVar.dJK.dJN);
        AppMethodBeat.o(94887);
        return true;
    }
}
