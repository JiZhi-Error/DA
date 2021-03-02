package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class bc extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "setBounceBackground";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78622);
        Log.i("MicroMsg.JsApiSetBounceBackground", "invokeInOwn");
        String optString = aVar.ctb.csi.optString("backgroundColor");
        if (Util.isNullOrNil(optString)) {
            aVar.c("invalid_data", null);
            AppMethodBeat.o(78622);
            return;
        }
        CONTEXT context = aVar.cta;
        context.mHandler.post(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0036: INVOKE  
              (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x002f: IGET  (r2v0 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v5 'context' CONTEXT) com.tencent.mm.plugin.webview.luggage.g.mHandler com.tencent.mm.sdk.platformtools.MMHandler)
              (wrap: com.tencent.mm.plugin.webview.luggage.g$14 : 0x0033: CONSTRUCTOR  (r3v0 com.tencent.mm.plugin.webview.luggage.g$14) = (r0v5 'context' CONTEXT), (r1v2 'optString' java.lang.String) call: com.tencent.mm.plugin.webview.luggage.g.14.<init>(com.tencent.mm.plugin.webview.luggage.g, java.lang.String):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.webview.luggage.jsapi.bc.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: CONSTRUCTOR  (r3v0 com.tencent.mm.plugin.webview.luggage.g$14) = (r0v5 'context' CONTEXT), (r1v2 'optString' java.lang.String) call: com.tencent.mm.plugin.webview.luggage.g.14.<init>(com.tencent.mm.plugin.webview.luggage.g, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.luggage.jsapi.bc.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.luggage.g, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 24 more
            */
        /*
            this = this;
            r5 = 0
            r4 = 78622(0x1331e, float:1.10173E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.String r0 = "MicroMsg.JsApiSetBounceBackground"
            java.lang.String r1 = "invokeInOwn"
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1)
            com.tencent.luggage.bridge.k r0 = r7.ctb
            org.json.JSONObject r0 = r0.csi
            java.lang.String r1 = "backgroundColor"
            java.lang.String r1 = r0.optString(r1)
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r1)
            if (r0 == 0) goto L_0x002b
            java.lang.String r0 = "invalid_data"
            r7.c(r0, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x002a:
            return
        L_0x002b:
            CONTEXT r0 = r7.cta
            com.tencent.mm.plugin.webview.luggage.g r0 = (com.tencent.mm.plugin.webview.luggage.g) r0
            com.tencent.mm.sdk.platformtools.MMHandler r2 = r0.mHandler
            com.tencent.mm.plugin.webview.luggage.g$14 r3 = new com.tencent.mm.plugin.webview.luggage.g$14
            r3.<init>(r1)
            r2.post(r3)
            java.lang.String r0 = ""
            r7.c(r0, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.luggage.jsapi.bc.b(com.tencent.luggage.d.b$a):void");
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
