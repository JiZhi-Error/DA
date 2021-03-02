package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;

public class l extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "clearBounceBackground";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78544);
        Log.i("MicroMsg.JsApiClearBounceBackground", "invokeInOwn");
        CONTEXT context = aVar.cta;
        context.mHandler.post(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE  
              (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0013: IGET  (r1v1 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v2 'context' CONTEXT) com.tencent.mm.plugin.webview.luggage.g.mHandler com.tencent.mm.sdk.platformtools.MMHandler)
              (wrap: com.tencent.mm.plugin.webview.luggage.g$13 : 0x0017: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.webview.luggage.g$13) = (r0v2 'context' CONTEXT) call: com.tencent.mm.plugin.webview.luggage.g.13.<init>(com.tencent.mm.plugin.webview.luggage.g):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.webview.luggage.jsapi.l.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.webview.luggage.g$13) = (r0v2 'context' CONTEXT) call: com.tencent.mm.plugin.webview.luggage.g.13.<init>(com.tencent.mm.plugin.webview.luggage.g):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.luggage.jsapi.l.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.luggage.g, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            this = this;
            r3 = 78544(0x132d0, float:1.10064E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.lang.String r0 = "MicroMsg.JsApiClearBounceBackground"
            java.lang.String r1 = "invokeInOwn"
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1)
            CONTEXT r0 = r5.cta
            com.tencent.mm.plugin.webview.luggage.g r0 = (com.tencent.mm.plugin.webview.luggage.g) r0
            com.tencent.mm.sdk.platformtools.MMHandler r1 = r0.mHandler
            com.tencent.mm.plugin.webview.luggage.g$13 r2 = new com.tencent.mm.plugin.webview.luggage.g$13
            r2.<init>()
            r1.post(r2)
            java.lang.String r0 = ""
            r1 = 0
            r5.c(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.luggage.jsapi.l.b(com.tencent.luggage.d.b$a):void");
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
