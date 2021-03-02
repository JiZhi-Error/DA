package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.cgi.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.f;

public final class h implements b<g> {
    protected g jSB;
    public final a jSC;

    public h() {
        this(new g());
        AppMethodBeat.i(63336);
        AppMethodBeat.o(63336);
    }

    private h(g gVar) {
        AppMethodBeat.i(63337);
        this.jSC = new a();
        this.jSB = gVar;
        AppMethodBeat.o(63337);
    }

    public final g bmk() {
        return this.jSB;
    }

    public class a implements e<c<String, String>, f<String, Long, Integer, String, String>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63335);
            f fVar = (f) obj;
            g gVar = h.this.jSB;
            String str = (String) fVar.get(0);
            long longValue = ((Long) fVar.get(1)).longValue();
            int intValue = ((Integer) fVar.get(2)).intValue();
            String str2 = (String) fVar.get(3);
            String str3 = (String) fVar.get(4);
            if (gVar.jSA) {
                Log.e("MicroMsg.AAPayLogic", "aaPay, isPaying!");
            } else {
                j jVar = new j(str, longValue, intValue, str2, str3);
                g.aAi();
                g.aAg().hqi.a(jVar, 0);
                gVar.jSi = com.tencent.mm.vending.g.g.hdH();
                gVar.jSA = true;
            }
            AppMethodBeat.o(63335);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ g bmc() {
        return this.jSB;
    }
}
