package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class ab implements com.tencent.mm.vending.c.b<aa> {
    protected aa Huj;
    public final b Huk;
    public final a Hul;

    public ab() {
        this(new aa());
        AppMethodBeat.i(68510);
        AppMethodBeat.o(68510);
    }

    private ab(aa aaVar) {
        AppMethodBeat.i(68511);
        this.Huk = new b();
        this.Hul = new a();
        this.Huj = aaVar;
        AppMethodBeat.o(68511);
    }

    public class b implements e<dbs, Void> {
        public b() {
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68509);
            aa aaVar = ab.this.Huj;
            Log.i("MicroMsg.LqtPlanHomeInteractor", "do plan index");
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new CgiLqtPlanIndex().aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0028: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x001f: INVOKE  (r2v2 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex : 0x001c: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex) =  call: com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.<init>():void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.aa$1 : 0x0025: CONSTRUCTOR  (r3v0 com.tencent.mm.plugin.wallet.balance.model.lqt.aa$1) = (r0v1 'aaVar' com.tencent.mm.plugin.wallet.balance.model.lqt.aa), (r1v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.aa.1.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.aa, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ab.b.call(java.lang.Object):java.lang.Object, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: CONSTRUCTOR  (r3v0 com.tencent.mm.plugin.wallet.balance.model.lqt.aa$1) = (r0v1 'aaVar' com.tencent.mm.plugin.wallet.balance.model.lqt.aa), (r1v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.aa.1.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.aa, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ab.b.call(java.lang.Object):java.lang.Object, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.aa, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r4 = 68509(0x10b9d, float:9.6002E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                com.tencent.mm.plugin.wallet.balance.model.lqt.ab r0 = com.tencent.mm.plugin.wallet.balance.model.lqt.ab.this
                com.tencent.mm.plugin.wallet.balance.model.lqt.aa r0 = r0.Huj
                java.lang.String r1 = "MicroMsg.LqtPlanHomeInteractor"
                java.lang.String r2 = "do plan index"
                com.tencent.mm.sdk.platformtools.Log.i(r1, r2)
                com.tencent.mm.vending.g.b r1 = com.tencent.mm.vending.g.g.hdx()
                r1.hdw()
                com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex r2 = new com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex
                r2.<init>()
                com.tencent.mm.co.f r2 = r2.aYI()
                com.tencent.mm.plugin.wallet.balance.model.lqt.aa$1 r3 = new com.tencent.mm.plugin.wallet.balance.model.lqt.aa$1
                r3.<init>(r1)
                r2.b(r3)
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.ab.b.call(java.lang.Object):java.lang.Object");
        }
    }

    public class a implements e<cmd, d<Integer, Integer, String>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68508);
            d dVar = (d) obj;
            aa aaVar = ab.this.Huj;
            Log.i("MicroMsg.LqtPlanHomeInteractor", "do oper plan");
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new g(((Integer) dVar.get(0)).intValue(), ((Integer) dVar.get(1)).intValue(), (String) dVar.get(2)).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x003e: INVOKE  (r0v10 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.g : 0x003b: CONSTRUCTOR  (r5v1 com.tencent.mm.plugin.wallet.balance.model.lqt.g) = 
                  (wrap: int : 0x0013: INVOKE  (r2v0 int) = 
                  (wrap: java.lang.Integer : 0x0011: CHECK_CAST (r0v3 java.lang.Integer) = (java.lang.Integer) (wrap: java.lang.Object : 0x000d: INVOKE  (r0v2 java.lang.Object) = (r8v1 'dVar' com.tencent.mm.vending.j.d), (0 int) type: VIRTUAL call: com.tencent.mm.vending.j.b.get(int):java.lang.Object))
                 type: VIRTUAL call: java.lang.Integer.intValue():int)
                  (wrap: int : 0x001e: INVOKE  (r3v0 int) = 
                  (wrap: java.lang.Integer : 0x001c: CHECK_CAST (r0v6 java.lang.Integer) = (java.lang.Integer) (wrap: java.lang.Object : 0x0018: INVOKE  (r0v5 java.lang.Object) = (r8v1 'dVar' com.tencent.mm.vending.j.d), (1 int) type: VIRTUAL call: com.tencent.mm.vending.j.c.get(int):java.lang.Object))
                 type: VIRTUAL call: java.lang.Integer.intValue():int)
                  (wrap: java.lang.String : 0x0027: CHECK_CAST (r0v9 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0023: INVOKE  (r0v8 java.lang.Object) = (r8v1 'dVar' com.tencent.mm.vending.j.d), (2 int) type: VIRTUAL call: com.tencent.mm.vending.j.d.get(int):java.lang.Object))
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.g.<init>(int, int, java.lang.String):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.g.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.aa$2 : 0x0044: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.aa$2) = (r1v0 'aaVar' com.tencent.mm.plugin.wallet.balance.model.lqt.aa), (r4v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.aa.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.aa, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ab.a.call(java.lang.Object):java.lang.Object, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.aa$2) = (r1v0 'aaVar' com.tencent.mm.plugin.wallet.balance.model.lqt.aa), (r4v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.aa.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.aa, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.ab.a.call(java.lang.Object):java.lang.Object, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.aa, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r6 = 68508(0x10b9c, float:9.6E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                com.tencent.mm.vending.j.d r8 = (com.tencent.mm.vending.j.d) r8
                com.tencent.mm.plugin.wallet.balance.model.lqt.ab r0 = com.tencent.mm.plugin.wallet.balance.model.lqt.ab.this
                com.tencent.mm.plugin.wallet.balance.model.lqt.aa r1 = r0.Huj
                r0 = 0
                java.lang.Object r0 = r8.get(r0)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r2 = r0.intValue()
                r0 = 1
                java.lang.Object r0 = r8.get(r0)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r3 = r0.intValue()
                r0 = 2
                java.lang.Object r0 = r8.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r4 = "MicroMsg.LqtPlanHomeInteractor"
                java.lang.String r5 = "do oper plan"
                com.tencent.mm.sdk.platformtools.Log.i(r4, r5)
                com.tencent.mm.vending.g.b r4 = com.tencent.mm.vending.g.g.hdx()
                r4.hdw()
                com.tencent.mm.plugin.wallet.balance.model.lqt.g r5 = new com.tencent.mm.plugin.wallet.balance.model.lqt.g
                r5.<init>(r2, r3, r0)
                com.tencent.mm.co.f r0 = r5.aYI()
                com.tencent.mm.plugin.wallet.balance.model.lqt.aa$2 r2 = new com.tencent.mm.plugin.wallet.balance.model.lqt.aa$2
                r2.<init>(r4)
                r0.b(r2)
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.ab.a.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ aa bmc() {
        return this.Huj;
    }
}
