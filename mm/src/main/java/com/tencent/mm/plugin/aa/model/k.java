package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public final class k implements com.tencent.mm.vending.c.b<j> {
    protected j jSF;
    public final b jSG;
    public final a jSH;

    public k() {
        this(new j());
        AppMethodBeat.i(63361);
        AppMethodBeat.o(63361);
    }

    private k(j jVar) {
        AppMethodBeat.i(63362);
        this.jSG = new b();
        this.jSH = new a();
        this.jSF = jVar;
        AppMethodBeat.o(63362);
    }

    public final j bmm() {
        return this.jSF;
    }

    public class b implements e<Boolean, d<String, Integer, String>> {
        public b() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63360);
            d dVar = (d) obj;
            j jVar = k.this.jSF;
            String str = (String) dVar.get(0);
            int intValue = ((Integer) dVar.get(1)).intValue();
            String str2 = (String) dVar.get(2);
            jVar.jSE = g.hdx();
            if (Util.isNullOrNil(str)) {
                jVar.jSE.ej(Boolean.FALSE);
            } else {
                com.tencent.mm.plugin.aa.model.cgi.e eVar = new com.tencent.mm.plugin.aa.model.cgi.e(str, intValue, str2);
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAg().hqi.a(eVar, 0);
                Log.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", str, Integer.valueOf(intValue));
                jVar.jSE = g.hdH();
            }
            AppMethodBeat.o(63360);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    public class a implements e<Boolean, com.tencent.mm.vending.j.e<String, Integer, String, Long>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63359);
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            j jVar = k.this.jSF;
            String str = (String) eVar.get(0);
            int intValue = ((Integer) eVar.get(1)).intValue();
            String str2 = (String) eVar.get(2);
            long longValue = ((Long) eVar.get(3)).longValue();
            jVar.jSE = g.hdx();
            jVar.msgId = longValue;
            if (Util.isNullOrNil(str)) {
                jVar.jSE.ej(Boolean.FALSE);
            } else {
                com.tencent.mm.plugin.aa.model.cgi.e eVar2 = new com.tencent.mm.plugin.aa.model.cgi.e(str, intValue, str2);
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAg().hqi.a(eVar2, 0);
                Log.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", str, Integer.valueOf(intValue));
                jVar.jSE = g.hdH();
            }
            AppMethodBeat.o(63359);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ j bmc() {
        return this.jSF;
    }
}
