package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.storage.ca;

public final class n implements w {
    private final a jdD = new a((byte) 0);
    private h jdE;

    public n() {
        AppMethodBeat.i(116833);
        AppMethodBeat.o(116833);
    }

    static final class a extends com.tencent.mm.co.a<o> implements o {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.o
        public final void a(final cot cot, final ca caVar) {
            AppMethodBeat.i(116832);
            a(new a.AbstractC0297a<o>() {
                /* class com.tencent.mm.modelmulti.n.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(o oVar) {
                    AppMethodBeat.i(116831);
                    oVar.a(cot, caVar);
                    AppMethodBeat.o(116831);
                }
            });
            AppMethodBeat.o(116832);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.w
    public final String Z(ca caVar) {
        AppMethodBeat.i(116834);
        if (this.jdE != null) {
            String Z = this.jdE.Z(caVar);
            AppMethodBeat.o(116834);
            return Z;
        }
        AppMethodBeat.o(116834);
        return null;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.w
    public final void a(o oVar) {
        AppMethodBeat.i(116835);
        this.jdD.add(oVar);
        AppMethodBeat.o(116835);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.w
    public final void a(h hVar) {
        this.jdE = hVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.w
    public final o bdO() {
        return this.jdD;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.w
    public final void a(o.c cVar) {
        AppMethodBeat.i(187477);
        o.a(cVar);
        AppMethodBeat.o(187477);
    }
}
