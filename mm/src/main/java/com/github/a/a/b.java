package com.github.a.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.embedding.engine.plugins.a.c;
import io.flutter.plugin.a.d;
import io.flutter.plugin.a.k;

public final class b implements a, io.flutter.embedding.engine.plugins.a.a {
    private a.b bbC;
    private a bbD;

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        this.bbC = bVar;
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        this.bbC = null;
    }

    @Override // io.flutter.embedding.engine.plugins.a.a
    public final void a(c cVar) {
        AppMethodBeat.i(199078);
        this.bbD = new a();
        a aVar = this.bbD;
        Activity activity = cVar.getActivity();
        io.flutter.plugin.a.c cVar2 = this.bbC.SOH;
        aVar.activity = activity;
        aVar.bbv = new k(cVar2, "sososdk.github.com/orientation");
        aVar.bbv.a(aVar);
        aVar.bbw = new d(cVar2, "sososdk.github.com/orientationEvent");
        aVar.bbw.a(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0039: INVOKE  
              (wrap: io.flutter.plugin.a.d : 0x0032: IGET  (r2v2 io.flutter.plugin.a.d) = (r0v1 'aVar' com.github.a.a.a) com.github.a.a.a.bbw io.flutter.plugin.a.d)
              (wrap: com.github.a.a.a$1 : 0x0036: CONSTRUCTOR  (r3v3 com.github.a.a.a$1) = (r0v1 'aVar' com.github.a.a.a), (r1v0 'activity' android.app.Activity) call: com.github.a.a.a.1.<init>(com.github.a.a.a, android.app.Activity):void type: CONSTRUCTOR)
             type: VIRTUAL call: io.flutter.plugin.a.d.a(io.flutter.plugin.a.d$c):void in method: com.github.a.a.b.a(io.flutter.embedding.engine.plugins.a.c):void, file: classes7.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0036: CONSTRUCTOR  (r3v3 com.github.a.a.a$1) = (r0v1 'aVar' com.github.a.a.a), (r1v0 'activity' android.app.Activity) call: com.github.a.a.a.1.<init>(com.github.a.a.a, android.app.Activity):void type: CONSTRUCTOR in method: com.github.a.a.b.a(io.flutter.embedding.engine.plugins.a.c):void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.github.a.a.a, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            this = this;
            r5 = 199078(0x309a6, float:2.78968E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.github.a.a.a r0 = new com.github.a.a.a
            r0.<init>()
            r6.bbD = r0
            com.github.a.a.a r0 = r6.bbD
            android.app.Activity r1 = r7.getActivity()
            io.flutter.embedding.engine.plugins.a$b r2 = r6.bbC
            io.flutter.plugin.a.c r2 = r2.SOH
            r0.activity = r1
            io.flutter.plugin.a.k r3 = new io.flutter.plugin.a.k
            java.lang.String r4 = "sososdk.github.com/orientation"
            r3.<init>(r2, r4)
            r0.bbv = r3
            io.flutter.plugin.a.k r3 = r0.bbv
            r3.a(r0)
            io.flutter.plugin.a.d r3 = new io.flutter.plugin.a.d
            java.lang.String r4 = "sososdk.github.com/orientationEvent"
            r3.<init>(r2, r4)
            r0.bbw = r3
            io.flutter.plugin.a.d r2 = r0.bbw
            com.github.a.a.a$1 r3 = new com.github.a.a.a$1
            r3.<init>(r1)
            r2.a(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.a.a.b.a(io.flutter.embedding.engine.plugins.a.c):void");
    }

    @Override // io.flutter.embedding.engine.plugins.a.a
    public final void sU() {
        AppMethodBeat.i(199079);
        if (this.bbD == null) {
            AppMethodBeat.o(199079);
            return;
        }
        a aVar = this.bbD;
        if (aVar.bbv != null) {
            aVar.bbv.a(null);
            aVar.bbv = null;
        }
        if (aVar.bbw != null) {
            aVar.bbw.a(null);
            aVar.bbw = null;
        }
        AppMethodBeat.o(199079);
    }

    @Override // io.flutter.embedding.engine.plugins.a.a
    public final void b(c cVar) {
        AppMethodBeat.i(199080);
        a(cVar);
        AppMethodBeat.o(199080);
    }

    @Override // io.flutter.embedding.engine.plugins.a.a
    public final void sV() {
        AppMethodBeat.i(199081);
        sU();
        AppMethodBeat.o(199081);
    }
}
