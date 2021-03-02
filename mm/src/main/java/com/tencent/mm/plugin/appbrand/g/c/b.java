package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c.b.e;
import rx.d;

public final class b {

    public static class a extends com.tencent.mm.plugin.appbrand.g.d.b<com.tencent.mm.plugin.appbrand.g.b.b> {
        private com.tencent.mm.plugin.appbrand.g.c.b.b lkx;
        private a lky = a.bBu();

        public a(com.tencent.mm.plugin.appbrand.g.c.b.b bVar) {
            AppMethodBeat.i(158950);
            this.lkx = bVar;
            AppMethodBeat.o(158950);
        }

        public final d<com.tencent.mm.plugin.appbrand.g.b.b> bBv() {
            AppMethodBeat.i(158951);
            d<com.tencent.mm.plugin.appbrand.g.b.b> a2 = d.a((d.a) 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  (r0v2 'a2' rx.d<com.tencent.mm.plugin.appbrand.g.b.b>) = 
                  (wrap: rx.d : 0x000f: INVOKE  (r0v1 rx.d) = 
                  (wrap: rx.d$a : ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$1 : 0x000c: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.appbrand.g.c.a$1) = 
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.appbrand.g.c.a) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.a.lky com.tencent.mm.plugin.appbrand.g.c.a)
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.b.b : 0x0008: IGET  (r1v0 com.tencent.mm.plugin.appbrand.g.c.b.b) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.a.lkx com.tencent.mm.plugin.appbrand.g.c.b.b)
                 call: com.tencent.mm.plugin.appbrand.g.c.a.1.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.c.b.b):void type: CONSTRUCTOR))
                 type: STATIC call: rx.d.a(rx.d$a):rx.d)
                  (wrap: rx.d$c : ?: CAST (rx.d$c) (wrap: rx.d$c<T, T> : 0x0013: IGET  (r1v1 rx.d$c<T, T>) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.d.b.llt rx.d$c))
                 type: VIRTUAL call: rx.d.a(rx.d$c):rx.d in method: com.tencent.mm.plugin.appbrand.g.c.b.a.bBv():rx.d<com.tencent.mm.plugin.appbrand.g.b.b>, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  (r0v1 rx.d) = 
                  (wrap: rx.d$a : ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$1 : 0x000c: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.appbrand.g.c.a$1) = 
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.appbrand.g.c.a) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.a.lky com.tencent.mm.plugin.appbrand.g.c.a)
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.b.b : 0x0008: IGET  (r1v0 com.tencent.mm.plugin.appbrand.g.c.b.b) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.a.lkx com.tencent.mm.plugin.appbrand.g.c.b.b)
                 call: com.tencent.mm.plugin.appbrand.g.c.a.1.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.c.b.b):void type: CONSTRUCTOR))
                 type: STATIC call: rx.d.a(rx.d$a):rx.d in method: com.tencent.mm.plugin.appbrand.g.c.b.a.bBv():rx.d<com.tencent.mm.plugin.appbrand.g.b.b>, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$1 : 0x000c: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.appbrand.g.c.a$1) = 
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.appbrand.g.c.a) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.a.lky com.tencent.mm.plugin.appbrand.g.c.a)
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.b.b : 0x0008: IGET  (r1v0 com.tencent.mm.plugin.appbrand.g.c.b.b) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.a.lkx com.tencent.mm.plugin.appbrand.g.c.b.b)
                 call: com.tencent.mm.plugin.appbrand.g.c.a.1.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.c.b.b):void type: CONSTRUCTOR) in method: com.tencent.mm.plugin.appbrand.g.c.b.a.bBv():rx.d<com.tencent.mm.plugin.appbrand.g.b.b>, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.appbrand.g.c.a$1) = 
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.appbrand.g.c.a) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.a.lky com.tencent.mm.plugin.appbrand.g.c.a)
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.b.b : 0x0008: IGET  (r1v0 com.tencent.mm.plugin.appbrand.g.c.b.b) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.a.lkx com.tencent.mm.plugin.appbrand.g.c.b.b)
                 call: com.tencent.mm.plugin.appbrand.g.c.a.1.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.c.b.b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.g.c.b.a.bBv():rx.d<com.tencent.mm.plugin.appbrand.g.b.b>, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:290)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 26 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.g.c.a, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 30 more
                */
            /*
                this = this;
                r3 = 158951(0x26ce7, float:2.22738E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                com.tencent.mm.plugin.appbrand.g.c.a r0 = r4.lky
                com.tencent.mm.plugin.appbrand.g.c.b.b r1 = r4.lkx
                com.tencent.mm.plugin.appbrand.g.c.a$1 r2 = new com.tencent.mm.plugin.appbrand.g.c.a$1
                r2.<init>(r1)
                rx.d r0 = rx.d.a(r2)
                rx.d$c<T, T> r1 = r4.llt
                rx.d r0 = r0.a(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.g.c.b.a.bBv():rx.d");
        }
    }

    public static class c extends com.tencent.mm.plugin.appbrand.g.d.b<Void> {
        com.tencent.mm.plugin.appbrand.g.a.d lkA;
        a lkB = a.bBu();

        public c(com.tencent.mm.plugin.appbrand.g.a.d dVar) {
            AppMethodBeat.i(158954);
            this.lkA = dVar;
            AppMethodBeat.o(158954);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.g.c.b$b  reason: collision with other inner class name */
    public static class C0582b extends com.tencent.mm.plugin.appbrand.g.d.b<e> {
        private a lky = a.bBu();
        private com.tencent.mm.plugin.appbrand.g.a.e lkz;

        public C0582b(com.tencent.mm.plugin.appbrand.g.a.e eVar) {
            AppMethodBeat.i(158952);
            this.lkz = eVar;
            AppMethodBeat.o(158952);
        }

        public final d<e> bBv() {
            AppMethodBeat.i(158953);
            d<e> a2 = d.a((d.a) 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  (r0v2 'a2' rx.d<com.tencent.mm.plugin.appbrand.g.c.b.e>) = 
                  (wrap: rx.d : 0x000f: INVOKE  (r0v1 rx.d) = 
                  (wrap: rx.d$a : ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$3 : 0x000c: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.appbrand.g.c.a$3) = 
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.appbrand.g.c.a) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.b.lky com.tencent.mm.plugin.appbrand.g.c.a)
                  (wrap: com.tencent.mm.plugin.appbrand.g.a.e : 0x0008: IGET  (r1v0 com.tencent.mm.plugin.appbrand.g.a.e) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.b.lkz com.tencent.mm.plugin.appbrand.g.a.e)
                 call: com.tencent.mm.plugin.appbrand.g.c.a.3.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.a.e):void type: CONSTRUCTOR))
                 type: STATIC call: rx.d.a(rx.d$a):rx.d)
                  (wrap: rx.d$c : ?: CAST (rx.d$c) (wrap: rx.d$c<T, T> : 0x0013: IGET  (r1v1 rx.d$c<T, T>) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.d.b.llt rx.d$c))
                 type: VIRTUAL call: rx.d.a(rx.d$c):rx.d in method: com.tencent.mm.plugin.appbrand.g.c.b.b.bBv():rx.d<com.tencent.mm.plugin.appbrand.g.c.b.e>, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  (r0v1 rx.d) = 
                  (wrap: rx.d$a : ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$3 : 0x000c: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.appbrand.g.c.a$3) = 
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.appbrand.g.c.a) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.b.lky com.tencent.mm.plugin.appbrand.g.c.a)
                  (wrap: com.tencent.mm.plugin.appbrand.g.a.e : 0x0008: IGET  (r1v0 com.tencent.mm.plugin.appbrand.g.a.e) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.b.lkz com.tencent.mm.plugin.appbrand.g.a.e)
                 call: com.tencent.mm.plugin.appbrand.g.c.a.3.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.a.e):void type: CONSTRUCTOR))
                 type: STATIC call: rx.d.a(rx.d$a):rx.d in method: com.tencent.mm.plugin.appbrand.g.c.b.b.bBv():rx.d<com.tencent.mm.plugin.appbrand.g.c.b.e>, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: CAST (rx.d$a) (wrap: com.tencent.mm.plugin.appbrand.g.c.a$3 : 0x000c: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.appbrand.g.c.a$3) = 
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.appbrand.g.c.a) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.b.lky com.tencent.mm.plugin.appbrand.g.c.a)
                  (wrap: com.tencent.mm.plugin.appbrand.g.a.e : 0x0008: IGET  (r1v0 com.tencent.mm.plugin.appbrand.g.a.e) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.b.lkz com.tencent.mm.plugin.appbrand.g.a.e)
                 call: com.tencent.mm.plugin.appbrand.g.c.a.3.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.a.e):void type: CONSTRUCTOR) in method: com.tencent.mm.plugin.appbrand.g.c.b.b.bBv():rx.d<com.tencent.mm.plugin.appbrand.g.c.b.e>, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.appbrand.g.c.a$3) = 
                  (wrap: com.tencent.mm.plugin.appbrand.g.c.a : 0x0006: IGET  (r0v0 com.tencent.mm.plugin.appbrand.g.c.a) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.b.lky com.tencent.mm.plugin.appbrand.g.c.a)
                  (wrap: com.tencent.mm.plugin.appbrand.g.a.e : 0x0008: IGET  (r1v0 com.tencent.mm.plugin.appbrand.g.a.e) = (r4v0 'this' com.tencent.mm.plugin.appbrand.g.c.b$b A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.g.c.b.b.lkz com.tencent.mm.plugin.appbrand.g.a.e)
                 call: com.tencent.mm.plugin.appbrand.g.c.a.3.<init>(com.tencent.mm.plugin.appbrand.g.c.a, com.tencent.mm.plugin.appbrand.g.a.e):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.g.c.b.b.bBv():rx.d<com.tencent.mm.plugin.appbrand.g.c.b.e>, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:290)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 26 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.g.c.a, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 30 more
                */
            /*
                this = this;
                r3 = 158953(0x26ce9, float:2.2274E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                com.tencent.mm.plugin.appbrand.g.c.a r0 = r4.lky
                com.tencent.mm.plugin.appbrand.g.a.e r1 = r4.lkz
                com.tencent.mm.plugin.appbrand.g.c.a$3 r2 = new com.tencent.mm.plugin.appbrand.g.c.a$3
                r2.<init>(r1)
                rx.d r0 = rx.d.a(r2)
                rx.d$c<T, T> r1 = r4.llt
                rx.d r0 = r0.a(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.g.c.b.C0582b.bBv():rx.d");
        }
    }
}
