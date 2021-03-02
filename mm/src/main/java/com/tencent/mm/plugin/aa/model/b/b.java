package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.List;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a jTS;
    public final a jTT;

    public b() {
        this(new a());
        AppMethodBeat.i(63436);
        AppMethodBeat.o(63436);
    }

    private b(a aVar) {
        AppMethodBeat.i(63437);
        this.jTT = new a();
        this.jTS = aVar;
        AppMethodBeat.o(63437);
    }

    public class a implements e<d<List, String, Boolean>, c<Boolean, Integer>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2;
            com.tencent.mm.plugin.aa.model.cgi.c cVar;
            int i3 = 20;
            AppMethodBeat.i(63435);
            c cVar2 = (c) obj;
            a aVar = b.this.jTS;
            boolean booleanValue = ((Boolean) cVar2.get(0)).booleanValue();
            int intValue = ((Integer) cVar2.get(1)).intValue();
            if (!booleanValue || aVar.jTJ <= 0) {
                i2 = 20;
            } else {
                i2 = aVar.jTJ;
                aVar.jTJ = 0;
                aVar.jTO = false;
            }
            if (aVar.jTP == intValue) {
                i3 = i2;
            }
            aVar.jTP = intValue;
            Log.i("MicroMsg.AAQueryListInteractor", "getNextAAQueryPage, currentPageOffset: %s, force: %s", Integer.valueOf(aVar.jTJ), Boolean.valueOf(booleanValue));
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            if (aVar.jTO) {
                cVar = new com.tencent.mm.plugin.aa.model.cgi.c(i3, aVar.jTJ, intValue, aVar.jTK, aVar.jTL, aVar.jTM, aVar.jTN);
            } else {
                cVar = new com.tencent.mm.plugin.aa.model.cgi.c(i3, aVar.jTJ, intValue);
            }
            cVar.aYI().h(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0073: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x006a: INVOKE  (r0v11 com.tencent.mm.co.f) = (r0v10 'cVar' com.tencent.mm.plugin.aa.model.cgi.c) type: VIRTUAL call: com.tencent.mm.plugin.aa.model.cgi.c.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.aa.model.b.a$1 : 0x0070: CONSTRUCTOR  (r1v3 com.tencent.mm.plugin.aa.model.b.a$1) = (r8v0 'aVar' com.tencent.mm.plugin.aa.model.b.a), (r9v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.aa.model.b.a.1.<init>(com.tencent.mm.plugin.aa.model.b.a, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.h(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.aa.model.b.b.a.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0070: CONSTRUCTOR  (r1v3 com.tencent.mm.plugin.aa.model.b.a$1) = (r8v0 'aVar' com.tencent.mm.plugin.aa.model.b.a), (r9v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.aa.model.b.a.1.<init>(com.tencent.mm.plugin.aa.model.b.a, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.aa.model.b.b.a.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.aa.model.b.a, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
            // Method dump skipped, instructions count: 135
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.aa.model.b.b.a.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.ANY";
        }

        public final com.tencent.mm.vending.g.c<d<List, String, Boolean>> l(boolean z, int i2) {
            AppMethodBeat.i(63434);
            com.tencent.mm.vending.g.c<d<List, String, Boolean>> c2 = g.O(Boolean.valueOf(z), Integer.valueOf(i2)).c(this);
            AppMethodBeat.o(63434);
            return c2;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ a bmc() {
        return this.jTS;
    }
}
