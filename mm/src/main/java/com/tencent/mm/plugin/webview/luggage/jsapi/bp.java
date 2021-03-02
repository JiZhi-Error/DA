package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;

public class bp extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "showSmileyPanel";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        int i2 = 0;
        AppMethodBeat.i(78638);
        Log.i("MicroMsg.JsApiShowSmileyPanel", "invokeInOwn");
        CONTEXT context = aVar.cta;
        if (context.ITh != null) {
            if (Thread.currentThread().getId() == context.mHandler.getLooper().getThread().getId()) {
                i2 = context.ITh.giF();
            } else {
                i2 = ((Integer) 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0073: INVOKE  (r1v4 'i2' int) = 
                      (wrap: java.lang.Integer : 0x006d: CHECK_CAST (r0v12 java.lang.Integer) = (java.lang.Integer) (wrap: java.lang.Object : 0x0069: INVOKE  (r0v11 java.lang.Object) = 
                      (wrap: com.tencent.mm.plugin.webview.luggage.g$9 : 0x0064: CONSTRUCTOR  (r2v6 com.tencent.mm.plugin.webview.luggage.g$9) = (r0v2 'context' CONTEXT), (0 int) call: com.tencent.mm.plugin.webview.luggage.g.9.<init>(com.tencent.mm.plugin.webview.luggage.g, java.lang.Integer):void type: CONSTRUCTOR)
                      (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0067: IGET  (r0v10 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v2 'context' CONTEXT) com.tencent.mm.plugin.webview.luggage.g.mHandler com.tencent.mm.sdk.platformtools.MMHandler)
                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.SyncTask.exec(com.tencent.mm.sdk.platformtools.MMHandler):java.lang.Object))
                     type: VIRTUAL call: java.lang.Integer.intValue():int in method: com.tencent.mm.plugin.webview.luggage.jsapi.bp.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006d: CHECK_CAST (r0v12 java.lang.Integer) = (java.lang.Integer) (wrap: java.lang.Object : 0x0069: INVOKE  (r0v11 java.lang.Object) = 
                      (wrap: com.tencent.mm.plugin.webview.luggage.g$9 : 0x0064: CONSTRUCTOR  (r2v6 com.tencent.mm.plugin.webview.luggage.g$9) = (r0v2 'context' CONTEXT), (0 int) call: com.tencent.mm.plugin.webview.luggage.g.9.<init>(com.tencent.mm.plugin.webview.luggage.g, java.lang.Integer):void type: CONSTRUCTOR)
                      (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0067: IGET  (r0v10 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v2 'context' CONTEXT) com.tencent.mm.plugin.webview.luggage.g.mHandler com.tencent.mm.sdk.platformtools.MMHandler)
                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.SyncTask.exec(com.tencent.mm.sdk.platformtools.MMHandler):java.lang.Object) in method: com.tencent.mm.plugin.webview.luggage.jsapi.bp.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 24 more
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0069: INVOKE  (r0v11 java.lang.Object) = 
                      (wrap: com.tencent.mm.plugin.webview.luggage.g$9 : 0x0064: CONSTRUCTOR  (r2v6 com.tencent.mm.plugin.webview.luggage.g$9) = (r0v2 'context' CONTEXT), (0 int) call: com.tencent.mm.plugin.webview.luggage.g.9.<init>(com.tencent.mm.plugin.webview.luggage.g, java.lang.Integer):void type: CONSTRUCTOR)
                      (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0067: IGET  (r0v10 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v2 'context' CONTEXT) com.tencent.mm.plugin.webview.luggage.g.mHandler com.tencent.mm.sdk.platformtools.MMHandler)
                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.SyncTask.exec(com.tencent.mm.sdk.platformtools.MMHandler):java.lang.Object in method: com.tencent.mm.plugin.webview.luggage.jsapi.bp.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:290)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 30 more
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0064: CONSTRUCTOR  (r2v6 com.tencent.mm.plugin.webview.luggage.g$9) = (r0v2 'context' CONTEXT), (0 int) call: com.tencent.mm.plugin.webview.luggage.g.9.<init>(com.tencent.mm.plugin.webview.luggage.g, java.lang.Integer):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.luggage.jsapi.bp.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 34 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.luggage.g, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 40 more
                    */
                /*
                // Method dump skipped, instructions count: 128
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.luggage.jsapi.bp.b(com.tencent.luggage.d.b$a):void");
            }

            @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
            public final void a(Context context, String str, br.a aVar) {
            }
        }
