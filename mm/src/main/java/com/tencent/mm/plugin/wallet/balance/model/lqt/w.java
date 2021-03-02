package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abc;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class w implements com.tencent.mm.vending.c.b<v> {
    protected v HtT;
    public final b HtU;
    public final a HtV;
    public final d HtW;
    public final c HtX;

    public w() {
        this(new v());
        AppMethodBeat.i(68489);
        AppMethodBeat.o(68489);
    }

    private w(v vVar) {
        AppMethodBeat.i(68490);
        this.HtU = new b();
        this.HtV = new a();
        this.HtW = new d();
        this.HtX = new c();
        this.HtT = vVar;
        AppMethodBeat.o(68490);
    }

    public class b implements e<dhn, Void> {
        public b() {
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        public final com.tencent.mm.vending.g.c<dhn> bmq() {
            AppMethodBeat.i(68484);
            com.tencent.mm.vending.g.c<_Ret> c2 = g.hdG().c(this);
            AppMethodBeat.o(68484);
            return c2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68485);
            v vVar = w.this.HtT;
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new o().aYI().h(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001f: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x0016: INVOKE  (r2v1 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.o : 0x0013: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.wallet.balance.model.lqt.o) =  call: com.tencent.mm.plugin.wallet.balance.model.lqt.o.<init>():void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.o.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.v$1 : 0x001c: CONSTRUCTOR  (r3v0 com.tencent.mm.plugin.wallet.balance.model.lqt.v$1) = (r0v1 'vVar' com.tencent.mm.plugin.wallet.balance.model.lqt.v), (r1v0 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.v.1.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.v, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.h(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.w.b.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001c: CONSTRUCTOR  (r3v0 com.tencent.mm.plugin.wallet.balance.model.lqt.v$1) = (r0v1 'vVar' com.tencent.mm.plugin.wallet.balance.model.lqt.v), (r1v0 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.v.1.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.v, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.w.b.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.v, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r4 = 68485(0x10b85, float:9.5968E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                com.tencent.mm.plugin.wallet.balance.model.lqt.w r0 = com.tencent.mm.plugin.wallet.balance.model.lqt.w.this
                com.tencent.mm.plugin.wallet.balance.model.lqt.v r0 = r0.HtT
                com.tencent.mm.vending.g.b r1 = com.tencent.mm.vending.g.g.hdx()
                r1.hdw()
                com.tencent.mm.plugin.wallet.balance.model.lqt.o r2 = new com.tencent.mm.plugin.wallet.balance.model.lqt.o
                r2.<init>()
                com.tencent.mm.co.f r2 = r2.aYI()
                com.tencent.mm.plugin.wallet.balance.model.lqt.v$1 r3 = new com.tencent.mm.plugin.wallet.balance.model.lqt.v$1
                r3.<init>(r1)
                r2.h(r3)
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.w.b.call(java.lang.Object):java.lang.Object");
        }
    }

    public class a implements e<abc, com.tencent.mm.vending.j.c<String, Integer>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68483);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            v vVar = w.this.HtT;
            int intValue = ((Integer) cVar.get(1)).intValue();
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            Log.i("MicroMsg.LqtDetailInteractor", "closeAccount, accountType: %s", Integer.valueOf(intValue));
            new f((String) cVar.get(0), intValue).aYI().h(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x003b: INVOKE  (r0v3 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.f : 0x0038: CONSTRUCTOR  (r4v1 com.tencent.mm.plugin.wallet.balance.model.lqt.f) = 
                  (wrap: java.lang.String : 0x0012: CHECK_CAST (r0v2 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x000e: INVOKE  (r0v1 java.lang.Object) = (r11v1 'cVar' com.tencent.mm.vending.j.c), (0 int) type: VIRTUAL call: com.tencent.mm.vending.j.b.get(int):java.lang.Object))
                  (r1v2 'intValue' int)
                 call: com.tencent.mm.plugin.wallet.balance.model.lqt.f.<init>(java.lang.String, int):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.f.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.v$2 : 0x0041: CONSTRUCTOR  (r1v3 com.tencent.mm.plugin.wallet.balance.model.lqt.v$2) = (r2v0 'vVar' com.tencent.mm.plugin.wallet.balance.model.lqt.v), (r3v0 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.v.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.v, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.h(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.w.a.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0041: CONSTRUCTOR  (r1v3 com.tencent.mm.plugin.wallet.balance.model.lqt.v$2) = (r2v0 'vVar' com.tencent.mm.plugin.wallet.balance.model.lqt.v), (r3v0 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.v.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.v, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.w.a.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.v, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r9 = 68483(0x10b83, float:9.5965E-41)
                r6 = 1
                r8 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r9)
                com.tencent.mm.vending.j.c r11 = (com.tencent.mm.vending.j.c) r11
                com.tencent.mm.plugin.wallet.balance.model.lqt.w r0 = com.tencent.mm.plugin.wallet.balance.model.lqt.w.this
                com.tencent.mm.plugin.wallet.balance.model.lqt.v r2 = r0.HtT
                java.lang.Object r0 = r11.get(r8)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.Object r1 = r11.get(r6)
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                com.tencent.mm.vending.g.b r3 = com.tencent.mm.vending.g.g.hdx()
                r3.hdw()
                java.lang.String r4 = "MicroMsg.LqtDetailInteractor"
                java.lang.String r5 = "closeAccount, accountType: %s"
                java.lang.Object[] r6 = new java.lang.Object[r6]
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                r6[r8] = r7
                com.tencent.mm.sdk.platformtools.Log.i(r4, r5, r6)
                com.tencent.mm.plugin.wallet.balance.model.lqt.f r4 = new com.tencent.mm.plugin.wallet.balance.model.lqt.f
                r4.<init>(r0, r1)
                com.tencent.mm.co.f r0 = r4.aYI()
                com.tencent.mm.plugin.wallet.balance.model.lqt.v$2 r1 = new com.tencent.mm.plugin.wallet.balance.model.lqt.v$2
                r1.<init>(r3)
                r0.h(r1)
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r9)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.w.a.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    public class d implements e<cux, com.tencent.mm.vending.j.c<Integer, Integer>> {
        public d() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68488);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            v vVar = w.this.HtT;
            int intValue = ((Integer) cVar.get(0)).intValue();
            ((Integer) cVar.get(1)).intValue();
            Log.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem, accountType: %s", Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new j(intValue).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x003e: INVOKE  (r2v1 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.j : 0x003b: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.wallet.balance.model.lqt.j) = (r2v0 'intValue' int) call: com.tencent.mm.plugin.wallet.balance.model.lqt.j.<init>(int):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.j.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.v$3 : 0x0044: CONSTRUCTOR  (r3v2 com.tencent.mm.plugin.wallet.balance.model.lqt.v$3) = (r1v0 'vVar' com.tencent.mm.plugin.wallet.balance.model.lqt.v), (r0v6 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.v.3.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.v, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.w.d.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: CONSTRUCTOR  (r3v2 com.tencent.mm.plugin.wallet.balance.model.lqt.v$3) = (r1v0 'vVar' com.tencent.mm.plugin.wallet.balance.model.lqt.v), (r0v6 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.v.3.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.v, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.w.d.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.v, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r7 = 68488(0x10b88, float:9.5972E-41)
                r4 = 1
                r6 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
                com.tencent.mm.vending.j.c r9 = (com.tencent.mm.vending.j.c) r9
                com.tencent.mm.plugin.wallet.balance.model.lqt.w r0 = com.tencent.mm.plugin.wallet.balance.model.lqt.w.this
                com.tencent.mm.plugin.wallet.balance.model.lqt.v r1 = r0.HtT
                java.lang.Object r0 = r9.get(r6)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r2 = r0.intValue()
                java.lang.Object r0 = r9.get(r4)
                java.lang.Integer r0 = (java.lang.Integer) r0
                r0.intValue()
                java.lang.String r0 = "MicroMsg.LqtDetailInteractor"
                java.lang.String r3 = "lqtOnClickRedeem, accountType: %s"
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
                r4[r6] = r5
                com.tencent.mm.sdk.platformtools.Log.i(r0, r3, r4)
                com.tencent.mm.vending.g.b r0 = com.tencent.mm.vending.g.g.hdx()
                r0.hdw()
                com.tencent.mm.plugin.wallet.balance.model.lqt.j r3 = new com.tencent.mm.plugin.wallet.balance.model.lqt.j
                r3.<init>(r2)
                com.tencent.mm.co.f r2 = r3.aYI()
                com.tencent.mm.plugin.wallet.balance.model.lqt.v$3 r3 = new com.tencent.mm.plugin.wallet.balance.model.lqt.v$3
                r3.<init>(r0)
                r2.b(r3)
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.w.d.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }

        public final com.tencent.mm.vending.g.c<cux> aen(int i2) {
            AppMethodBeat.i(213853);
            com.tencent.mm.vending.g.c<cux> c2 = g.O(Integer.valueOf(i2), 1).c(this);
            AppMethodBeat.o(213853);
            return c2;
        }
    }

    public class c implements e<cuv, com.tencent.mm.vending.j.c<Integer, Integer>> {
        public c() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(68487);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            v vVar = w.this.HtT;
            int intValue = ((Integer) cVar.get(0)).intValue();
            int intValue2 = ((Integer) cVar.get(1)).intValue();
            Log.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase, accountType: %s", Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b hdx = g.hdx();
            hdx.hdw();
            new i(intValue, intValue2).aYI().b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0048: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x003f: INVOKE  (r0v6 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.i : 0x003c: CONSTRUCTOR  (r4v1 com.tencent.mm.plugin.wallet.balance.model.lqt.i) = (r2v0 'intValue' int), (r0v5 'intValue2' int) call: com.tencent.mm.plugin.wallet.balance.model.lqt.i.<init>(int, int):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.wallet.balance.model.lqt.i.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.v$4 : 0x0045: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.v$4) = (r1v0 'vVar' com.tencent.mm.plugin.wallet.balance.model.lqt.v), (r3v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.v.4.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.v, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.b(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.wallet.balance.model.lqt.w.c.call(java.lang.Object):java.lang.Object, file: classes6.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.wallet.balance.model.lqt.v$4) = (r1v0 'vVar' com.tencent.mm.plugin.wallet.balance.model.lqt.v), (r3v1 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.wallet.balance.model.lqt.v.4.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.v, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.model.lqt.w.c.call(java.lang.Object):java.lang.Object, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.v, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r8 = 68487(0x10b87, float:9.5971E-41)
                r5 = 1
                r7 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
                com.tencent.mm.vending.j.c r10 = (com.tencent.mm.vending.j.c) r10
                com.tencent.mm.plugin.wallet.balance.model.lqt.w r0 = com.tencent.mm.plugin.wallet.balance.model.lqt.w.this
                com.tencent.mm.plugin.wallet.balance.model.lqt.v r1 = r0.HtT
                java.lang.Object r0 = r10.get(r7)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r2 = r0.intValue()
                java.lang.Object r0 = r10.get(r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                java.lang.String r3 = "MicroMsg.LqtDetailInteractor"
                java.lang.String r4 = "lqtOnClickPurchase, accountType: %s"
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
                r5[r7] = r6
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4, r5)
                com.tencent.mm.vending.g.b r3 = com.tencent.mm.vending.g.g.hdx()
                r3.hdw()
                com.tencent.mm.plugin.wallet.balance.model.lqt.i r4 = new com.tencent.mm.plugin.wallet.balance.model.lqt.i
                r4.<init>(r2, r0)
                com.tencent.mm.co.f r0 = r4.aYI()
                com.tencent.mm.plugin.wallet.balance.model.lqt.v$4 r2 = new com.tencent.mm.plugin.wallet.balance.model.lqt.v$4
                r2.<init>(r3)
                r0.b(r2)
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.model.lqt.w.c.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.UI";
        }

        public final com.tencent.mm.vending.g.c<cuv> jP(int i2, int i3) {
            AppMethodBeat.i(68486);
            com.tencent.mm.vending.g.c<cuv> c2 = g.O(Integer.valueOf(i2), Integer.valueOf(i3)).c(this);
            AppMethodBeat.o(68486);
            return c2;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ v bmc() {
        return this.HtT;
    }
}
