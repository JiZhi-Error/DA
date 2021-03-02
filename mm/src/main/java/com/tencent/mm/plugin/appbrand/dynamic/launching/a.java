package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.a.b;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.protocal.protobuf.ffa;
import java.util.concurrent.Callable;

public final class a implements Callable<j> {
    final String appId;
    final int appVersion;
    final int dMe;
    final int loG;
    final String loH;
    final int scene;

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ j call() {
        AppMethodBeat.i(121399);
        j bCh = bCh();
        AppMethodBeat.o(121399);
        return bCh;
    }

    public a(String str, int i2, int i3, int i4, int i5, String str2) {
        this.appId = str;
        this.dMe = i2;
        this.appVersion = i3;
        this.scene = i4;
        this.loG = i5;
        this.loH = str2;
    }

    public final j bCh() {
        boolean z;
        AppMethodBeat.i(121398);
        j jVar = new j();
        jVar.field_appId = this.appId;
        i buE = ((b) g.af(b.class)).buE();
        if (buE == null) {
            AppMethodBeat.o(121398);
            return null;
        }
        ffa ffa = new ffa();
        ffa.MjZ = com.tencent.mm.plugin.appbrand.dynamic.k.b.wq(this.dMe);
        ffa.KSa = this.appVersion;
        ffa.NAo = this.loG;
        ffa.Scene = this.scene;
        ffa.NAp = 0;
        if (buE.a(jVar, "appId", "pkgType", "widgetType")) {
            if (jVar.field_jsApiInfo != null) {
                z = true;
            } else {
                z = false;
            }
            if (z && jVar.field_launchAction != null && 1 == jVar.field_launchAction.KCD && jVar.field_versionInfo != null && jVar.field_versionInfo.KSa >= this.appVersion) {
                com.tencent.mm.ch.a.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0175: INVOKE  
                      (wrap: com.tencent.mm.plugin.appbrand.dynamic.g.a$1 : 0x0172: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.appbrand.dynamic.g.a$1) = 
                      (wrap: com.tencent.mm.plugin.appbrand.dynamic.g.a : 0x016d: CONSTRUCTOR  (r0v62 com.tencent.mm.plugin.appbrand.dynamic.g.a) = 
                      (wrap: java.lang.String : 0x016b: IGET  (r2v2 java.lang.String) = (r10v0 'this' com.tencent.mm.plugin.appbrand.dynamic.launching.a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.dynamic.launching.a.appId java.lang.String)
                      false
                      (r4v0 'ffa' com.tencent.mm.protocal.protobuf.ffa)
                     call: com.tencent.mm.plugin.appbrand.dynamic.g.a.<init>(java.lang.String, boolean, com.tencent.mm.protocal.protobuf.ffa):void type: CONSTRUCTOR)
                     call: com.tencent.mm.plugin.appbrand.dynamic.g.a.1.<init>(com.tencent.mm.plugin.appbrand.dynamic.g.a):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.mm.ch.a.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.dynamic.launching.a.bCh():com.tencent.mm.plugin.appbrand.widget.j, file: classes3.dex
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
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0172: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.appbrand.dynamic.g.a$1) = 
                      (wrap: com.tencent.mm.plugin.appbrand.dynamic.g.a : 0x016d: CONSTRUCTOR  (r0v62 com.tencent.mm.plugin.appbrand.dynamic.g.a) = 
                      (wrap: java.lang.String : 0x016b: IGET  (r2v2 java.lang.String) = (r10v0 'this' com.tencent.mm.plugin.appbrand.dynamic.launching.a A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.dynamic.launching.a.appId java.lang.String)
                      false
                      (r4v0 'ffa' com.tencent.mm.protocal.protobuf.ffa)
                     call: com.tencent.mm.plugin.appbrand.dynamic.g.a.<init>(java.lang.String, boolean, com.tencent.mm.protocal.protobuf.ffa):void type: CONSTRUCTOR)
                     call: com.tencent.mm.plugin.appbrand.dynamic.g.a.1.<init>(com.tencent.mm.plugin.appbrand.dynamic.g.a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.dynamic.launching.a.bCh():com.tencent.mm.plugin.appbrand.widget.j, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 28 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.dynamic.g.a, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 34 more
                    */
                /*
                // Method dump skipped, instructions count: 382
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.launching.a.bCh():com.tencent.mm.plugin.appbrand.widget.j");
            }
        }
