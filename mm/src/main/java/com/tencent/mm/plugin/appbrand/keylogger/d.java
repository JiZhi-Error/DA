package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.b;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static final a mPh = new a();

    static {
        AppMethodBeat.i(221307);
        AppMethodBeat.o(221307);
    }

    static void a(String str, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar) {
        AppMethodBeat.i(221302);
        a aVar2 = mPh;
        aVar2.mPi.put(a.b(aVar.bMU(), str, aVar), Long.valueOf(System.currentTimeMillis()));
        b bMO = b.a.bMO();
        bMO.a(aVar.bMU(), 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: INVOKE  
              (r0v2 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b)
              (wrap: java.lang.String : 0x0021: INVOKE  (r1v2 java.lang.String) = (r6v0 'aVar' com.tencent.mm.plugin.appbrand.keylogger.base.a) type: INTERFACE call: com.tencent.mm.plugin.appbrand.keylogger.base.a.bMU():java.lang.String)
              (wrap: com.tencent.mm.plugin.appbrand.keylogger.b$3 : 0x0027: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.appbrand.keylogger.b$3) = 
              (r0v2 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b)
              (r5v0 'str' java.lang.String)
              (r6v0 'aVar' com.tencent.mm.plugin.appbrand.keylogger.base.a)
             call: com.tencent.mm.plugin.appbrand.keylogger.b.3.<init>(com.tencent.mm.plugin.appbrand.keylogger.b, java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.plugin.appbrand.keylogger.b.a(java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.b$b):void in method: com.tencent.mm.plugin.appbrand.keylogger.d.a(java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a):void, file: classes3.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.appbrand.keylogger.b$3) = 
              (r0v2 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b)
              (r5v0 'str' java.lang.String)
              (r6v0 'aVar' com.tencent.mm.plugin.appbrand.keylogger.base.a)
             call: com.tencent.mm.plugin.appbrand.keylogger.b.3.<init>(com.tencent.mm.plugin.appbrand.keylogger.b, java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.keylogger.d.a(java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.keylogger.b, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            r4 = 221302(0x36076, float:3.1011E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.mm.plugin.appbrand.keylogger.d$a r0 = com.tencent.mm.plugin.appbrand.keylogger.d.mPh
            java.lang.String r1 = r6.bMU()
            java.lang.String r1 = com.tencent.mm.plugin.appbrand.keylogger.d.a.b(r1, r5, r6)
            java.util.Map<java.lang.String, java.lang.Long> r0 = r0.mPi
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0.put(r1, r2)
            com.tencent.mm.plugin.appbrand.keylogger.b r0 = com.tencent.mm.plugin.appbrand.keylogger.b.a.bMO()
            java.lang.String r1 = r6.bMU()
            com.tencent.mm.plugin.appbrand.keylogger.b$3 r2 = new com.tencent.mm.plugin.appbrand.keylogger.b$3
            r2.<init>(r5, r6)
            r0.a(r1, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.keylogger.d.a(java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a):void");
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        final Map<String, Long> mPi = new ConcurrentHashMap();

        a() {
            AppMethodBeat.i(221297);
            AppMethodBeat.o(221297);
        }

        /* access modifiers changed from: package-private */
        public final long a(String str, String str2, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar) {
            AppMethodBeat.i(221298);
            String b2 = b(str, str2, aVar);
            if (this.mPi.containsKey(b2)) {
                Long l = this.mPi.get(b2);
                if (l == null) {
                    AppMethodBeat.o(221298);
                    return -1;
                }
                long currentTimeMillis = System.currentTimeMillis() - l.longValue();
                this.mPi.remove(b2);
                AppMethodBeat.o(221298);
                return currentTimeMillis;
            }
            AppMethodBeat.o(221298);
            return -1;
        }

        static String b(String str, String str2, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar) {
            AppMethodBeat.i(221299);
            String format = String.format("%s#%s#%s", str, str2, aVar.name());
            AppMethodBeat.o(221299);
            return format;
        }
    }

    static void ea(String str, String str2) {
        AppMethodBeat.i(221300);
        b bMO = b.a.bMO();
        bMO.a(str, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
              (r0v0 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b)
              (r3v0 'str' java.lang.String)
              (wrap: com.tencent.mm.plugin.appbrand.keylogger.b$1 : 0x000c: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.appbrand.keylogger.b$1) = (r0v0 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b), (r4v0 'str2' java.lang.String) call: com.tencent.mm.plugin.appbrand.keylogger.b.1.<init>(com.tencent.mm.plugin.appbrand.keylogger.b, java.lang.String):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.plugin.appbrand.keylogger.b.a(java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.b$b):void in method: com.tencent.mm.plugin.appbrand.keylogger.d.ea(java.lang.String, java.lang.String):void, file: classes3.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.appbrand.keylogger.b$1) = (r0v0 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b), (r4v0 'str2' java.lang.String) call: com.tencent.mm.plugin.appbrand.keylogger.b.1.<init>(com.tencent.mm.plugin.appbrand.keylogger.b, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.keylogger.d.ea(java.lang.String, java.lang.String):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.keylogger.b, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            r2 = 221300(0x36074, float:3.10107E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.mm.plugin.appbrand.keylogger.b r0 = com.tencent.mm.plugin.appbrand.keylogger.b.a.bMO()
            com.tencent.mm.plugin.appbrand.keylogger.b$1 r1 = new com.tencent.mm.plugin.appbrand.keylogger.b$1
            r1.<init>(r4)
            r0.a(r3, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.keylogger.d.ea(java.lang.String, java.lang.String):void");
    }

    static void eb(String str, String str2) {
        AppMethodBeat.i(221301);
        b bMO = b.a.bMO();
        bMO.a(str, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
              (r0v0 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b)
              (r3v0 'str' java.lang.String)
              (wrap: com.tencent.mm.plugin.appbrand.keylogger.b$2 : 0x000c: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.appbrand.keylogger.b$2) = (r0v0 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b), (r4v0 'str2' java.lang.String) call: com.tencent.mm.plugin.appbrand.keylogger.b.2.<init>(com.tencent.mm.plugin.appbrand.keylogger.b, java.lang.String):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.plugin.appbrand.keylogger.b.a(java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.b$b):void in method: com.tencent.mm.plugin.appbrand.keylogger.d.eb(java.lang.String, java.lang.String):void, file: classes3.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r1v0 com.tencent.mm.plugin.appbrand.keylogger.b$2) = (r0v0 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b), (r4v0 'str2' java.lang.String) call: com.tencent.mm.plugin.appbrand.keylogger.b.2.<init>(com.tencent.mm.plugin.appbrand.keylogger.b, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.keylogger.d.eb(java.lang.String, java.lang.String):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.keylogger.b, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            r2 = 221301(0x36075, float:3.10109E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.mm.plugin.appbrand.keylogger.b r0 = com.tencent.mm.plugin.appbrand.keylogger.b.a.bMO()
            com.tencent.mm.plugin.appbrand.keylogger.b$2 r1 = new com.tencent.mm.plugin.appbrand.keylogger.b$2
            r1.<init>(r4)
            r0.a(r3, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.keylogger.d.eb(java.lang.String, java.lang.String):void");
    }

    static void d(String str, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar) {
        AppMethodBeat.i(221303);
        b bMO = b.a.bMO();
        bMO.a(aVar.bMU(), 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001f: INVOKE  
              (r1v0 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b)
              (wrap: java.lang.String : 0x000a: INVOKE  (r6v0 java.lang.String) = (r9v0 'aVar' com.tencent.mm.plugin.appbrand.keylogger.base.a) type: INTERFACE call: com.tencent.mm.plugin.appbrand.keylogger.base.a.bMU():java.lang.String)
              (wrap: com.tencent.mm.plugin.appbrand.keylogger.b$5 : 0x001c: CONSTRUCTOR  (r0v1 com.tencent.mm.plugin.appbrand.keylogger.b$5) = 
              (r1v0 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b)
              (r8v0 'str' java.lang.String)
              (r9v0 'aVar' com.tencent.mm.plugin.appbrand.keylogger.base.a)
              (wrap: long : 0x0014: INVOKE  (r4v0 long) = 
              (wrap: com.tencent.mm.plugin.appbrand.keylogger.d$a : 0x000e: SGET  (r0v0 com.tencent.mm.plugin.appbrand.keylogger.d$a) =  com.tencent.mm.plugin.appbrand.keylogger.d.mPh com.tencent.mm.plugin.appbrand.keylogger.d$a)
              (wrap: java.lang.String : 0x0010: INVOKE  (r2v0 java.lang.String) = (r9v0 'aVar' com.tencent.mm.plugin.appbrand.keylogger.base.a) type: INTERFACE call: com.tencent.mm.plugin.appbrand.keylogger.base.a.bMU():java.lang.String)
              (r8v0 'str' java.lang.String)
              (r9v0 'aVar' com.tencent.mm.plugin.appbrand.keylogger.base.a)
             type: VIRTUAL call: com.tencent.mm.plugin.appbrand.keylogger.d.a.a(java.lang.String, java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a):long)
             call: com.tencent.mm.plugin.appbrand.keylogger.b.5.<init>(com.tencent.mm.plugin.appbrand.keylogger.b, java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a, long):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.plugin.appbrand.keylogger.b.a(java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.b$b):void in method: com.tencent.mm.plugin.appbrand.keylogger.d.d(java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a):void, file: classes3.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001c: CONSTRUCTOR  (r0v1 com.tencent.mm.plugin.appbrand.keylogger.b$5) = 
              (r1v0 'bMO' com.tencent.mm.plugin.appbrand.keylogger.b)
              (r8v0 'str' java.lang.String)
              (r9v0 'aVar' com.tencent.mm.plugin.appbrand.keylogger.base.a)
              (wrap: long : 0x0014: INVOKE  (r4v0 long) = 
              (wrap: com.tencent.mm.plugin.appbrand.keylogger.d$a : 0x000e: SGET  (r0v0 com.tencent.mm.plugin.appbrand.keylogger.d$a) =  com.tencent.mm.plugin.appbrand.keylogger.d.mPh com.tencent.mm.plugin.appbrand.keylogger.d$a)
              (wrap: java.lang.String : 0x0010: INVOKE  (r2v0 java.lang.String) = (r9v0 'aVar' com.tencent.mm.plugin.appbrand.keylogger.base.a) type: INTERFACE call: com.tencent.mm.plugin.appbrand.keylogger.base.a.bMU():java.lang.String)
              (r8v0 'str' java.lang.String)
              (r9v0 'aVar' com.tencent.mm.plugin.appbrand.keylogger.base.a)
             type: VIRTUAL call: com.tencent.mm.plugin.appbrand.keylogger.d.a.a(java.lang.String, java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a):long)
             call: com.tencent.mm.plugin.appbrand.keylogger.b.5.<init>(com.tencent.mm.plugin.appbrand.keylogger.b, java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a, long):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.keylogger.d.d(java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.keylogger.b, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            r7 = 221303(0x36077, float:3.10112E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            com.tencent.mm.plugin.appbrand.keylogger.b r1 = com.tencent.mm.plugin.appbrand.keylogger.b.a.bMO()
            java.lang.String r6 = r9.bMU()
            com.tencent.mm.plugin.appbrand.keylogger.d$a r0 = com.tencent.mm.plugin.appbrand.keylogger.d.mPh
            java.lang.String r2 = r9.bMU()
            long r4 = r0.a(r2, r8, r9)
            com.tencent.mm.plugin.appbrand.keylogger.b$5 r0 = new com.tencent.mm.plugin.appbrand.keylogger.b$5
            r2 = r8
            r3 = r9
            r0.<init>(r2, r3, r4)
            r1.a(r6, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.keylogger.d.d(java.lang.String, com.tencent.mm.plugin.appbrand.keylogger.base.a):void");
    }

    static void e(String str, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar) {
        AppMethodBeat.i(221304);
        b.a.bMO().a(aVar.bMU(), str, aVar, mPh.a(aVar.bMU(), str, aVar));
        AppMethodBeat.o(221304);
    }

    static void a(String str, com.tencent.mm.plugin.appbrand.keylogger.base.a aVar, long j2) {
        AppMethodBeat.i(221305);
        b.a.bMO().a(aVar.bMU(), str, aVar, j2);
        AppMethodBeat.o(221305);
    }

    public static void a(String str, com.tencent.mm.plugin.appbrand.keylogger.base.b bVar) {
        AppMethodBeat.i(221306);
        b bMO = b.a.bMO();
        if (bVar != null) {
            List<com.tencent.mm.plugin.appbrand.keylogger.base.b> list = bMO.mgp.get(str);
            if (list == null) {
                list = new LinkedList<>();
                bMO.mgp.put(str, list);
            }
            list.add(bVar);
        }
        AppMethodBeat.o(221306);
    }
}
