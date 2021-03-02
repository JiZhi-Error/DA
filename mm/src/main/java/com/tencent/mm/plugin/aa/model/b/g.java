package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.Log;

public class g implements com.tencent.mm.vending.c.b<f> {
    protected f jUj;
    public final d jUk;
    public final a jUl;
    public final e jUm;
    public final c jUn;
    public final b jUo;
    public final f jUp;

    public g() {
        this(new f());
        AppMethodBeat.i(63468);
        AppMethodBeat.o(63468);
    }

    private g(f fVar) {
        AppMethodBeat.i(63469);
        this.jUk = new d();
        this.jUl = new a();
        this.jUm = new e();
        this.jUn = new c();
        this.jUo = new b();
        this.jUp = new f();
        this.jUj = fVar;
        AppMethodBeat.o(63469);
    }

    public class d implements com.tencent.mm.vending.h.e<y, Void> {
        public d() {
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        public final com.tencent.mm.vending.g.c<y> bmq() {
            AppMethodBeat.i(63463);
            com.tencent.mm.vending.g.c<_Ret> c2 = com.tencent.mm.vending.g.g.hdG().c(this);
            AppMethodBeat.o(63463);
            return c2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63464);
            f fVar = g.this.jUj;
            String stringExtra = fVar.QYU.getStringExtra("bill_no");
            int intExtra = fVar.QYU.getIntExtra("enter_scene", 0);
            String stringExtra2 = fVar.QYU.getStringExtra("chatroom");
            String stringExtra3 = fVar.QYU.getStringExtra("key_sign");
            int intExtra2 = fVar.QYU.getIntExtra("key_ver", 0);
            Log.i("MicroMsg.PaylistAAInteractor", "getPayListDetail, billNo: %s, scene: %s, chatRoom: %s", stringExtra, Integer.valueOf(intExtra), stringExtra2);
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.b(stringExtra, Integer.valueOf(intExtra), stringExtra2, stringExtra3, Integer.valueOf(intExtra2)).c(fVar.jUf.jSk));
            AppMethodBeat.o(63464);
            return null;
        }
    }

    public class a implements com.tencent.mm.vending.h.e<r, com.tencent.mm.vending.j.c<Long, String>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2;
            AppMethodBeat.i(63459);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            f fVar = g.this.jUj;
            long longValue = ((Long) cVar.get(0)).longValue();
            String str = (String) cVar.get(1);
            String stringExtra = fVar.QYU.getStringExtra("bill_no");
            String stringExtra2 = fVar.QYU.getStringExtra("chatroom");
            if (fVar.QYU.getIntExtra("enter_scene", 0) == 1) {
                i2 = com.tencent.mm.plugin.aa.model.a.jSa;
            } else {
                i2 = com.tencent.mm.plugin.aa.model.a.jSb;
            }
            Log.i("MicroMsg.PaylistAAInteractor", "aaPay, payAmount: %s, billNo: %s, chatroom: %s，desc:%s", Long.valueOf(longValue), stringExtra, stringExtra2, str);
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.b(stringExtra, Long.valueOf(longValue), Integer.valueOf(i2), stringExtra2, str).c(fVar.jUg.jSC));
            AppMethodBeat.o(63459);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        public final com.tencent.mm.vending.g.c<r> j(long j2, String str) {
            AppMethodBeat.i(212951);
            com.tencent.mm.vending.g.c<r> c2 = com.tencent.mm.vending.g.g.O(Long.valueOf(j2), str).c(this);
            AppMethodBeat.o(212951);
            return c2;
        }
    }

    public class e implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.d<String, String, String>> {
        public e() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63466);
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            f fVar = g.this.jUj;
            i.c((String) dVar.get(1), fVar.QYU.getStringExtra("chatroom"), fVar.QYU.getStringExtra("bill_no"), (String) dVar.get(0), (String) dVar.get(2));
            Void r0 = QZL;
            AppMethodBeat.o(63466);
            return r0;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        public final com.tencent.mm.vending.g.c<Void> w(String str, String str2, String str3) {
            AppMethodBeat.i(63465);
            com.tencent.mm.vending.g.c<Void> c2 = com.tencent.mm.vending.g.g.h(str, str2, str3).c(this);
            AppMethodBeat.o(63465);
            return c2;
        }
    }

    public class c implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.d<Long, String, String>> {
        public c() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63462);
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            f fVar = g.this.jUj;
            com.tencent.mm.vending.g.b hdx = com.tencent.mm.vending.g.g.hdx();
            String stringExtra = fVar.QYU.getStringExtra("bill_no");
            int intExtra = fVar.QYU.getIntExtra("enter_scene", 0);
            String stringExtra2 = fVar.QYU.getStringExtra("chatroom");
            hdx.hdw();
            new com.tencent.mm.plugin.aa.model.cgi.a(stringExtra, ((Long) dVar.get(0)).longValue(), intExtra, stringExtra2, (String) dVar.get(1), (String) dVar.get(2)).aYI().h(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0055: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x004c: INVOKE  (r0v9 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.aa.model.cgi.a : 0x0049: CONSTRUCTOR  (r0v8 com.tencent.mm.plugin.aa.model.cgi.a) = 
                  (r1v1 'stringExtra' java.lang.String)
                  (wrap: long : 0x0013: INVOKE  (r2v0 long) = 
                  (wrap: java.lang.Long : 0x0011: CHECK_CAST (r0v2 java.lang.Long) = (java.lang.Long) (wrap: java.lang.Object : 0x000d: INVOKE  (r0v1 java.lang.Object) = (r12v1 'dVar' com.tencent.mm.vending.j.d), (0 int) type: VIRTUAL call: com.tencent.mm.vending.j.b.get(int):java.lang.Object))
                 type: VIRTUAL call: java.lang.Long.longValue():long)
                  (r4v1 'intExtra' int)
                  (r5v2 'stringExtra2' java.lang.String)
                  (wrap: java.lang.String : 0x001c: CHECK_CAST (r6v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x0018: INVOKE  (r6v0 java.lang.Object) = (r12v1 'dVar' com.tencent.mm.vending.j.d), (1 int) type: VIRTUAL call: com.tencent.mm.vending.j.c.get(int):java.lang.Object))
                  (wrap: java.lang.String : 0x0023: CHECK_CAST (r7v1 java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x001f: INVOKE  (r7v0 java.lang.Object) = (r12v1 'dVar' com.tencent.mm.vending.j.d), (2 int) type: VIRTUAL call: com.tencent.mm.vending.j.d.get(int):java.lang.Object))
                 call: com.tencent.mm.plugin.aa.model.cgi.a.<init>(java.lang.String, long, int, java.lang.String, java.lang.String, java.lang.String):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.aa.model.cgi.a.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.aa.model.b.f$1 : 0x0052: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.aa.model.b.f$1) = (r8v0 'fVar' com.tencent.mm.plugin.aa.model.b.f), (r9v0 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.aa.model.b.f.1.<init>(com.tencent.mm.plugin.aa.model.b.f, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.h(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.aa.model.b.g.c.call(java.lang.Object):java.lang.Object, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0052: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.aa.model.b.f$1) = (r8v0 'fVar' com.tencent.mm.plugin.aa.model.b.f), (r9v0 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.aa.model.b.f.1.<init>(com.tencent.mm.plugin.aa.model.b.f, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.aa.model.b.g.c.call(java.lang.Object):java.lang.Object, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.aa.model.b.f, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r10 = 63462(0xf7e6, float:8.8929E-41)
                r5 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r10)
                com.tencent.mm.vending.j.d r12 = (com.tencent.mm.vending.j.d) r12
                com.tencent.mm.plugin.aa.model.b.g r0 = com.tencent.mm.plugin.aa.model.b.g.this
                com.tencent.mm.plugin.aa.model.b.f r8 = r0.jUj
                java.lang.Object r0 = r12.get(r5)
                java.lang.Long r0 = (java.lang.Long) r0
                long r2 = r0.longValue()
                r0 = 1
                java.lang.Object r6 = r12.get(r0)
                java.lang.String r6 = (java.lang.String) r6
                r0 = 2
                java.lang.Object r7 = r12.get(r0)
                java.lang.String r7 = (java.lang.String) r7
                com.tencent.mm.vending.g.b r9 = com.tencent.mm.vending.g.g.hdx()
                com.tencent.mm.vending.d.a r0 = r8.QYU
                java.lang.String r1 = "bill_no"
                java.lang.String r1 = r0.getStringExtra(r1)
                com.tencent.mm.vending.d.a r0 = r8.QYU
                java.lang.String r4 = "enter_scene"
                int r4 = r0.getIntExtra(r4, r5)
                com.tencent.mm.vending.d.a r0 = r8.QYU
                java.lang.String r5 = "chatroom"
                java.lang.String r5 = r0.getStringExtra(r5)
                r9.hdw()
                com.tencent.mm.plugin.aa.model.cgi.a r0 = new com.tencent.mm.plugin.aa.model.cgi.a
                r0.<init>(r1, r2, r4, r5, r6, r7)
                com.tencent.mm.co.f r0 = r0.aYI()
                com.tencent.mm.plugin.aa.model.b.f$1 r1 = new com.tencent.mm.plugin.aa.model.b.f$1
                r1.<init>(r9)
                r0.h(r1)
                java.lang.Void r0 = com.tencent.mm.plugin.aa.model.b.g.c.QZL
                com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.aa.model.b.g.c.call(java.lang.Object):java.lang.Object");
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        public final com.tencent.mm.vending.g.c<Void> b(long j2, String str, String str2) {
            AppMethodBeat.i(63461);
            com.tencent.mm.vending.g.c<Void> c2 = com.tencent.mm.vending.g.g.h(Long.valueOf(j2), str, str2).c(this);
            AppMethodBeat.o(63461);
            return c2;
        }
    }

    public class b implements com.tencent.mm.vending.h.e<Boolean, Void> {
        public b() {
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63460);
            f fVar = g.this.jUj;
            String stringExtra = fVar.QYU.getStringExtra("bill_no");
            int intExtra = fVar.QYU.getIntExtra("enter_scene", 0);
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.h(stringExtra, Integer.valueOf(intExtra), fVar.QYU.getStringExtra("chatroom")).c(fVar.jUh.jSG));
            AppMethodBeat.o(63460);
            return null;
        }
    }

    public class f implements com.tencent.mm.vending.h.e<Boolean, Void> {
        public f() {
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63467);
            f fVar = g.this.jUj;
            String stringExtra = fVar.QYU.getStringExtra("bill_no");
            String stringExtra2 = fVar.QYU.getStringExtra("chatroom");
            int intExtra = fVar.QYU.getIntExtra("enter_scene", 0);
            Log.i("MicroMsg.PaylistAAInteractor", "urgeAAPay");
            com.tencent.mm.vending.g.b hdx = com.tencent.mm.vending.g.g.hdx();
            hdx.hdw();
            new com.tencent.mm.plugin.aa.model.cgi.b(stringExtra, stringExtra2, intExtra).aYI().h(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: INVOKE  
                  (wrap: com.tencent.mm.co.f : 0x003b: INVOKE  (r1v2 com.tencent.mm.co.f) = 
                  (wrap: com.tencent.mm.plugin.aa.model.cgi.b : 0x0038: CONSTRUCTOR  (r5v2 com.tencent.mm.plugin.aa.model.cgi.b) = (r1v1 'stringExtra' java.lang.String), (r2v2 'stringExtra2' java.lang.String), (r3v2 'intExtra' int) call: com.tencent.mm.plugin.aa.model.cgi.b.<init>(java.lang.String, java.lang.String, int):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.aa.model.cgi.b.aYI():com.tencent.mm.co.f)
                  (wrap: com.tencent.mm.plugin.aa.model.b.f$2 : 0x0041: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.aa.model.b.f$2) = (r0v1 'fVar' com.tencent.mm.plugin.aa.model.b.f), (r4v2 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.aa.model.b.f.2.<init>(com.tencent.mm.plugin.aa.model.b.f, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.co.f.h(com.tencent.mm.vending.c.a):com.tencent.mm.co.f in method: com.tencent.mm.plugin.aa.model.b.g.f.call(java.lang.Object):java.lang.Object, file: classes3.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0041: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.aa.model.b.f$2) = (r0v1 'fVar' com.tencent.mm.plugin.aa.model.b.f), (r4v2 'hdx' com.tencent.mm.vending.g.b) call: com.tencent.mm.plugin.aa.model.b.f.2.<init>(com.tencent.mm.plugin.aa.model.b.f, com.tencent.mm.vending.g.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.aa.model.b.g.f.call(java.lang.Object):java.lang.Object, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.aa.model.b.f, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r6 = 63467(0xf7eb, float:8.8936E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                com.tencent.mm.plugin.aa.model.b.g r0 = com.tencent.mm.plugin.aa.model.b.g.this
                com.tencent.mm.plugin.aa.model.b.f r0 = r0.jUj
                com.tencent.mm.vending.d.a r1 = r0.QYU
                java.lang.String r2 = "bill_no"
                java.lang.String r1 = r1.getStringExtra(r2)
                com.tencent.mm.vending.d.a r2 = r0.QYU
                java.lang.String r3 = "chatroom"
                java.lang.String r2 = r2.getStringExtra(r3)
                com.tencent.mm.vending.d.a r3 = r0.QYU
                java.lang.String r4 = "enter_scene"
                r5 = 0
                int r3 = r3.getIntExtra(r4, r5)
                java.lang.String r4 = "MicroMsg.PaylistAAInteractor"
                java.lang.String r5 = "urgeAAPay"
                com.tencent.mm.sdk.platformtools.Log.i(r4, r5)
                com.tencent.mm.vending.g.b r4 = com.tencent.mm.vending.g.g.hdx()
                r4.hdw()
                com.tencent.mm.plugin.aa.model.cgi.b r5 = new com.tencent.mm.plugin.aa.model.cgi.b
                r5.<init>(r1, r2, r3)
                com.tencent.mm.co.f r1 = r5.aYI()
                com.tencent.mm.plugin.aa.model.b.f$2 r2 = new com.tencent.mm.plugin.aa.model.b.f$2
                r2.<init>(r4)
                r1.h(r2)
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.aa.model.b.g.f.call(java.lang.Object):java.lang.Object");
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ f bmc() {
        return this.jUj;
    }
}
