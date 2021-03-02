package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.f;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.y;
import java.nio.ByteBuffer;

public class c extends a {
    public c() {
        super((IJSRuntime.Config) null);
    }

    public c(byte b2) {
        super(new IJSRuntime.Config(null, null));
        AppMethodBeat.i(144158);
        AppMethodBeat.o(144158);
    }

    public c(IJSRuntime.Config config) {
        super(config);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.m.a
    public IJSRuntime g(IJSRuntime.Config config) {
        AppMethodBeat.i(144160);
        y c2 = f.c(config);
        AppMethodBeat.o(144160);
        return c2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.m.a
    public final m a(IJSRuntime iJSRuntime, int i2) {
        AppMethodBeat.i(144161);
        m iP = iJSRuntime.iP(i2);
        AppMethodBeat.o(144161);
        return iP;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.k, com.tencent.mm.plugin.appbrand.m.a, com.tencent.mm.plugin.appbrand.m.d
    public final void releaseDirectByteBuffer(ByteBuffer byteBuffer) {
    }

    public final void a(z zVar) {
        AppMethodBeat.i(144159);
        if (this.mNC != null) {
            m mVar = this.mNC;
            mVar.dpQ.r(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: INVOKE  
                  (wrap: com.tencent.mm.appbrand.v8.IJSRuntime : 0x000c: IGET  (r1v0 com.tencent.mm.appbrand.v8.IJSRuntime) = (r0v1 'mVar' com.tencent.mm.appbrand.v8.m) com.tencent.mm.appbrand.v8.m.dpQ com.tencent.mm.appbrand.v8.IJSRuntime)
                  (wrap: com.tencent.mm.appbrand.v8.m$9 : 0x0010: CONSTRUCTOR  (r2v0 com.tencent.mm.appbrand.v8.m$9) = (r0v1 'mVar' com.tencent.mm.appbrand.v8.m), (r5v0 'zVar' com.tencent.mm.plugin.appbrand.m.z) call: com.tencent.mm.appbrand.v8.m.9.<init>(com.tencent.mm.appbrand.v8.m, com.tencent.mm.plugin.appbrand.m.z):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.appbrand.v8.IJSRuntime.r(java.lang.Runnable):void in method: com.tencent.mm.plugin.appbrand.m.c.a(com.tencent.mm.plugin.appbrand.m.z):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r2v0 com.tencent.mm.appbrand.v8.m$9) = (r0v1 'mVar' com.tencent.mm.appbrand.v8.m), (r5v0 'zVar' com.tencent.mm.plugin.appbrand.m.z) call: com.tencent.mm.appbrand.v8.m.9.<init>(com.tencent.mm.appbrand.v8.m, com.tencent.mm.plugin.appbrand.m.z):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.m.c.a(com.tencent.mm.plugin.appbrand.m.z):void, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.appbrand.v8.m, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
                this = this;
                r3 = 144159(0x2331f, float:2.0201E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                com.tencent.mm.appbrand.v8.m r0 = r4.mNC
                if (r0 == 0) goto L_0x0016
                com.tencent.mm.appbrand.v8.m r0 = r4.mNC
                com.tencent.mm.appbrand.v8.IJSRuntime r1 = r0.dpQ
                com.tencent.mm.appbrand.v8.m$9 r2 = new com.tencent.mm.appbrand.v8.m$9
                r2.<init>(r5)
                r1.r(r2)
            L_0x0016:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.m.c.a(com.tencent.mm.plugin.appbrand.m.z):void");
        }
    }
