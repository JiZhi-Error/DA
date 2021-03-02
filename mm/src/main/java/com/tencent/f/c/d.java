package com.tencent.f.c;

import android.os.HandlerThread;
import com.tencent.f.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends a {
    public static HandlerThread hz(String str, int i2) {
        AppMethodBeat.i(183237);
        HandlerThread hy = hy(str, i2);
        AppMethodBeat.o(183237);
        return hy;
    }

    public static HandlerThread hA(String str, int i2) {
        AppMethodBeat.i(183238);
        HandlerThread hy = hy(str, i2);
        AppMethodBeat.o(183238);
        return hy;
    }

    public static HandlerThread hB(String str, int i2) {
        AppMethodBeat.i(183239);
        HandlerThread hy = hy(str, i2);
        AppMethodBeat.o(183239);
        return hy;
    }

    public static HandlerThread hC(String str, int i2) {
        AppMethodBeat.i(183240);
        HandlerThread hy = hy(str, i2);
        AppMethodBeat.o(183240);
        return hy;
    }

    public static HandlerThread bqq(String str) {
        AppMethodBeat.i(183241);
        HandlerThread hy = hy(str, 5);
        AppMethodBeat.o(183241);
        return hy;
    }

    public static HandlerThread bqr(String str) {
        AppMethodBeat.i(183242);
        HandlerThread hy = hy(str, 5);
        AppMethodBeat.o(183242);
        return hy;
    }

    public static HandlerThread hD(String str, int i2) {
        AppMethodBeat.i(256671);
        HandlerThread hy = hy(str, i2);
        AppMethodBeat.o(256671);
        return hy;
    }

    public static Thread b(String str, Runnable runnable, int i2) {
        AppMethodBeat.i(183244);
        a.AnonymousClass2 r0 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: CONSTRUCTOR  (r0v0 'r0' com.tencent.f.c.a$2) = 
              (wrap: com.tencent.f.c.a$1 : 0x000a: CONSTRUCTOR  (r1v0 com.tencent.f.c.a$1) = (r6v0 'runnable' java.lang.Runnable) call: com.tencent.f.c.a.1.<init>(java.lang.Runnable):void type: CONSTRUCTOR)
              (wrap: java.lang.String : 0x0014: INVOKE  (r2v1 java.lang.String) = 
              ("[GT]")
              (wrap: java.lang.String : 0x0010: INVOKE  (r3v0 java.lang.String) = (r5v0 'str' java.lang.String) type: STATIC call: java.lang.String.valueOf(java.lang.Object):java.lang.String)
             type: VIRTUAL call: java.lang.String.concat(java.lang.String):java.lang.String)
             call: com.tencent.f.c.a.2.<init>(java.lang.Runnable, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.f.c.d.b(java.lang.String, java.lang.Runnable, int):java.lang.Thread, file: classes.dex
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.f.c.a, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            */
        /*
            r4 = 183244(0x2cbcc, float:2.5678E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.f.c.a$2 r0 = new com.tencent.f.c.a$2
            com.tencent.f.c.a$1 r1 = new com.tencent.f.c.a$1
            r1.<init>(r6)
            java.lang.String r2 = "[GT]"
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r2 = r2.concat(r3)
            r0.<init>(r1, r2)
            r1 = 1
            r2 = 10
            int r1 = android.support.v4.b.a.clamp(r7, r1, r2)
            r0.setPriority(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.f.c.d.b(java.lang.String, java.lang.Runnable, int):java.lang.Thread");
    }
}
