package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.h;

public class z implements com.tencent.mm.vending.c.b<y> {
    protected y Huc;
    public final d Hud;
    public final a Hue;
    public final b Huf;
    public final c Hug;

    public z() {
        this(new y());
        AppMethodBeat.i(68502);
        AppMethodBeat.o(68502);
    }

    private z(y yVar) {
        AppMethodBeat.i(68503);
        this.Hud = new d();
        this.Hue = new a();
        this.Huf = new b();
        this.Hug = new c();
        this.Huc = yVar;
        AppMethodBeat.o(68503);
    }

    public class d implements e<ddt, com.tencent.mm.vending.j.c<Integer, Integer>> {
        public d() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68501);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            y yVar = z.this.Huc;
            int intValue = ((Integer) cVar.get(0)).intValue();
            int intValue2 = ((Integer) cVar.get(1)).intValue();
            Log.i("MicroMsg.LqtPlanAddInteractor", "do pre add plan");
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new k(intValue, intValue2).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0040: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x0037: INVOKE  (r0v8 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.k : 0x0034: CONSTRUCTOR  (r4v1 com.tencent.mm.plugin.wallet.balance.model.lqt.k) = (r2v0 'intValue' int), (r0v7 'intValue2' int) call: com.tencent.mm.plugin.wallet.balance.model.lqt.k.<init>(int, int):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.k.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.y$1 : 0x003d: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.y$1) = (r1v0 'yVar' com.tencent.mm.plugin.wallet.balance.model.lqt.y), (r3v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.y.1.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.y, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.z.d.call(java.lang.Object):java.lang.Object, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003d: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.y$1) = (r1v0 'yVar' com.tencent.mm.plugin.wallet.balance.model.lqt.y), (r3v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.y.1.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.y, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.z.d.call(java.lang.Object):java.lang.Object, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.y, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r5 = 68501(0x10b95, float:9.599E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                com.tencent.mm.vending.j.c r7 = (com.tencent.mm.vending.j.c) r7
                com.tencent.mm.plugin.wallet.balance.model.lqt.z r0 = com.tencent.mm.plugin.wallet.balance.model.lqt.z.this
                com.tencent.mm.plugin.wallet.balance.model.lqt.y r1 = r0.Huc
                r0 = 0
                java.lang.Object r0 = r7.get(r0)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r2 = r0.intValue()
                r0 = 1
                java.lang.Object r0 = r7.get(r0)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                java.lang.String r3 = "MicroMsg.LqtPlanAddInteractor"
                java.lang.String r4 = "do pre add plan"
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                com.tencent.mm.vending.g.b r3 = com.tencent.mm.vending.g.g.hdx()
                r3.hdw()
                com.tencent.mm.plugin.wallet.balance.model.lqt.k r4 = new com.tencent.mm.plugin.wallet.balance.model.lqt.k
                r4.<init>(r2, r0)
                com.tencent.mm.co.f r0 = r4.aYI()
                com.tencent.mm.plugin.wallet.balance.model.lqt.y$1 r2 = new com.tencent.mm.plugin.wallet.balance.model.lqt.y$1
                r2.<init>(r3)
                r0.b(r2)
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.z.d.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }
    }

    public class a implements e<dn, h<String, String, String, String, Integer, Integer, Integer>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68497);
            h hVar = (h) obj;
            y yVar = z.this.Huc;
            int intValue = ((Integer) hVar.get(4)).intValue();
            int intValue2 = ((Integer) hVar.get(5)).intValue();
            int intValue3 = ((Integer) hVar.get(6)).intValue();
            Log.i("MicroMsg.LqtPlanAddInteractor", "do add plan");
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new a((String) hVar.get(0), (String) hVar.get(1), (String) hVar.get(2), (String) hVar.get(3), (long) intValue, intValue2, intValue3).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0068: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x005f: INVOKE  (r1v2 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.a : 0x005c: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.wallet.balance.model.lqt.a) = 
                  (wrap: java.lang.String : 0x0011: CHECK_CAST (r2v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x000d: INVOKE  (r2v0 java.lang.Object) = (r13v1 'hVar' com.tencent.mm.vending.j.h), (0 int) type: VIRTUAL call: com.tencent.mm.vending.j.b.get(int):java.lang.Object))
                  (wrap: java.lang.String : 0x0018: CHECK_CAST (r3v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0014: INVOKE  (r3v0 java.lang.Object) = (r13v1 'hVar' com.tencent.mm.vending.j.h), (1 int) type: VIRTUAL call: com.tencent.mm.vending.j.c.get(int):java.lang.Object))
                  (wrap: java.lang.String : 0x001f: CHECK_CAST (r4v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x001b: INVOKE  (r4v0 java.lang.Object) = (r13v1 'hVar' com.tencent.mm.vending.j.h), (2 int) type: VIRTUAL call: com.tencent.mm.vending.j.d.get(int):java.lang.Object))
                  (wrap: java.lang.String : 0x0026: CHECK_CAST (r5v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0022: INVOKE  (r5v0 java.lang.Object) = (r13v1 'hVar' com.tencent.mm.vending.j.h), (3 int) type: VIRTUAL call: com.tencent.mm.vending.j.e.get(int):java.lang.Object))
                  (wrap: long : 0x005b: CAST (r6v1 long) = (long) (r6v0 'intValue' int))
                  (r8v0 'intValue2' int)
                  (r9v0 'intValue3' int)
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.a.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, int, int):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.a.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.y$2 : 0x0065: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.wallet.balance.model.lqt.y$2) = (r10v0 'yVar' com.tencent.mm.plugin.wallet.balance.model.lqt.y), (r0v15 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.y.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.y, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.z.a.call(java.lang.Object):java.lang.Object, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0065: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.wallet.balance.model.lqt.y$2) = (r10v0 'yVar' com.tencent.mm.plugin.wallet.balance.model.lqt.y), (r0v15 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.y.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.y, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.z.a.call(java.lang.Object):java.lang.Object, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.y, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
            // Method dump skipped, instructions count: 112
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.z.a.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }
    }

    public class b implements e<cqy, h<Integer, String, String, String, Integer, Integer, String>> {
        public b() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68498);
            h hVar = (h) obj;
            y yVar = z.this.Huc;
            int intValue = ((Integer) hVar.get(4)).intValue();
            Log.i("MicroMsg.LqtPlanAddInteractor", "do add plan");
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new h(((Integer) hVar.get(0)).intValue(), (String) hVar.get(1), (String) hVar.get(2), (String) hVar.get(3), (long) intValue, ((Integer) hVar.get(5)).intValue(), (String) hVar.get(6)).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0068: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x005f: INVOKE  (r1v2 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.h : 0x005c: CONSTRUCTOR  (r1v1 com.tencent.mm.plugin.wallet.balance.model.lqt.h) = 
                  (wrap: int : 0x0013: INVOKE  (r2v0 int) = 
                  (wrap: java.lang.Integer : 0x0011: CHECK_CAST (r0v3 java.lang.Integer) = (java.lang.Integer) (wrap: java.lang.Object : 0x000d: INVOKE  (r0v2 java.lang.Object) = (r13v1 'hVar' com.tencent.mm.vending.j.h), (0 int) type: VIRTUAL call: com.tencent.mm.vending.j.b.get(int):java.lang.Object))
                 type: VIRTUAL call: java.lang.Integer.intValue():int)
                  (wrap: java.lang.String : 0x001c: CHECK_CAST (r3v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0018: INVOKE  (r3v0 java.lang.Object) = (r13v1 'hVar' com.tencent.mm.vending.j.h), (1 int) type: VIRTUAL call: com.tencent.mm.vending.j.c.get(int):java.lang.Object))
                  (wrap: java.lang.String : 0x0023: CHECK_CAST (r4v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x001f: INVOKE  (r4v0 java.lang.Object) = (r13v1 'hVar' com.tencent.mm.vending.j.h), (2 int) type: VIRTUAL call: com.tencent.mm.vending.j.d.get(int):java.lang.Object))
                  (wrap: java.lang.String : 0x002a: CHECK_CAST (r5v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0026: INVOKE  (r5v0 java.lang.Object) = (r13v1 'hVar' com.tencent.mm.vending.j.h), (3 int) type: VIRTUAL call: com.tencent.mm.vending.j.e.get(int):java.lang.Object))
                  (wrap: long : 0x005b: CAST (r6v1 long) = (long) (r6v0 'intValue' int))
                  (wrap: int : 0x003e: INVOKE  (r8v0 int) = 
                  (wrap: java.lang.Integer : 0x003c: CHECK_CAST (r0v12 java.lang.Integer) = (java.lang.Integer) (wrap: java.lang.Object : 0x0038: INVOKE  (r0v11 java.lang.Object) = (r13v1 'hVar' com.tencent.mm.vending.j.h), (5 int) type: VIRTUAL call: com.tencent.mm.vending.j.g.get(int):java.lang.Object))
                 type: VIRTUAL call: java.lang.Integer.intValue():int)
                  (wrap: java.lang.String : 0x0047: CHECK_CAST (r9v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0043: INVOKE  (r9v0 java.lang.Object) = (r13v1 'hVar' com.tencent.mm.vending.j.h), (6 int) type: VIRTUAL call: com.tencent.mm.vending.j.h.get(int):java.lang.Object))
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.h.<init>(int, java.lang.String, java.lang.String, java.lang.String, long, int, java.lang.String):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.h.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.y$3 : 0x0065: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.y$3) = (r10v0 'yVar' com.tencent.mm.plugin.wallet.balance.model.lqt.y), (r0v15 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.y.3.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.y, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.z.b.call(java.lang.Object):java.lang.Object, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0065: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.y$3) = (r10v0 'yVar' com.tencent.mm.plugin.wallet.balance.model.lqt.y), (r0v15 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.y.3.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.y, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.z.b.call(java.lang.Object):java.lang.Object, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.y, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
            // Method dump skipped, instructions count: 112
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.z.b.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }
    }

    public class c implements e<dgx, com.tencent.mm.vending.j.d<Integer, Integer, Integer>> {
        public c() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68500);
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            y yVar = z.this.Huc;
            int intValue = ((Integer) dVar.get(0)).intValue();
            int intValue2 = ((Integer) dVar.get(1)).intValue();
            int intValue3 = ((Integer) dVar.get(2)).intValue();
            Log.i("MicroMsg.LqtPlanAddInteractor", "doPlanOrderList");
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new CgiLqtPlanOrderList(intValue, intValue2, intValue3).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x0042: INVOKE  (r0v11 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList : 0x003f: CONSTRUCTOR  (r5v1 com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList) = (r2v0 'intValue' int), (r3v0 'intValue2' int), (r0v10 'intValue3' int) call: com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList.<init>(int, int, int):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.y$4 : 0x0048: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.y$4) = (r1v0 'yVar' com.tencent.mm.plugin.wallet.balance.model.lqt.y), (r4v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.y.4.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.y, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.z.c.call(java.lang.Object):java.lang.Object, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0048: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.y$4) = (r1v0 'yVar' com.tencent.mm.plugin.wallet.balance.model.lqt.y), (r4v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.y.4.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.y, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.z.c.call(java.lang.Object):java.lang.Object, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.y, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r6 = 68500(0x10b94, float:9.5989E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                com.tencent.mm.vending.j.d r8 = (com.tencent.mm.vending.j.d) r8
                com.tencent.mm.plugin.wallet.balance.model.lqt.z r0 = com.tencent.mm.plugin.wallet.balance.model.lqt.z.this
                com.tencent.mm.plugin.wallet.balance.model.lqt.y r1 = r0.Huc
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
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                java.lang.String r4 = "MicroMsg.LqtPlanAddInteractor"
                java.lang.String r5 = "doPlanOrderList"
                com.tencent.mm.sdk.platformtools.Log.i(r4, r5)
                com.tencent.mm.vending.g.b r4 = com.tencent.mm.vending.g.g.hdx()
                r4.hdw()
                com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList r5 = new com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList
                r5.<init>(r2, r3, r0)
                com.tencent.mm.co.f r0 = r5.aYI()
                com.tencent.mm.plugin.wallet.balance.model.lqt.y$4 r2 = new com.tencent.mm.plugin.wallet.balance.model.lqt.y$4
                r2.<init>(r4)
                r0.b(r2)
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.z.c.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }

        public final com.tencent.mm.vending.g.c<dgx> aH(int i2, int i3, int i4) {
            AppMethodBeat.i(213854);
            com.tencent.mm.vending.g.c<dgx> c2 = g.h(Integer.valueOf(i2), Integer.valueOf(i3), 6).c(this);
            AppMethodBeat.o(213854);
            return c2;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ y bmc() {
        return this.Huc;
    }
}
