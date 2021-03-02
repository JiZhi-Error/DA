package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.g.b;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import org.json.JSONObject;

public final class d extends b {
    public static final int CTRL_INDEX = 687;
    public static final String NAME = "operateMediaTrack";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.x.b
    public final void a(final c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46760);
        Log.i("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaTrack", "hy: %s %s", NAME, jSONObject.toString());
        String optString = jSONObject.optString("operationType");
        if (optString.equalsIgnoreCase("get")) {
            String optString2 = jSONObject.optString("source");
            if (Util.isNullOrNil(optString2)) {
                cVar.i(i2, h(String.format("fail: parmas error %s", jSONObject.toString()), null));
                AppMethodBeat.o(46760);
                return;
            }
            try {
                jSONObject.put("filePath", aa.z(cVar.getRuntime().OK().VY(optString2).her()));
                b d2 = d(cVar);
                d2.luO.postToWorker(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0081: INVOKE  
                      (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x007a: IGET  (r2v12 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v25 'd2' com.tencent.mm.plugin.appbrand.game.g.b) com.tencent.mm.plugin.appbrand.game.g.b.luO com.tencent.mm.sdk.platformtools.MMHandler)
                      (wrap: com.tencent.mm.plugin.appbrand.game.g.b$4 : 0x007e: CONSTRUCTOR  (r3v6 com.tencent.mm.plugin.appbrand.game.g.b$4) = 
                      (r0v25 'd2' com.tencent.mm.plugin.appbrand.game.g.b)
                      (r10v0 'jSONObject' org.json.JSONObject)
                      (wrap: com.tencent.mm.plugin.appbrand.jsapi.x.d$1 : 0x0077: CONSTRUCTOR  (r1v19 com.tencent.mm.plugin.appbrand.jsapi.x.d$1) = 
                      (r8v0 'this' com.tencent.mm.plugin.appbrand.jsapi.x.d A[IMMUTABLE_TYPE, THIS])
                      (r9v0 'cVar' com.tencent.mm.plugin.appbrand.service.c A[SKIP_ARG])
                      (r11v0 'i2' int A[SKIP_ARG])
                     call: com.tencent.mm.plugin.appbrand.jsapi.x.d.1.<init>(com.tencent.mm.plugin.appbrand.jsapi.x.d, com.tencent.mm.plugin.appbrand.service.c, int):void type: CONSTRUCTOR)
                     call: com.tencent.mm.plugin.appbrand.game.g.b.4.<init>(com.tencent.mm.plugin.appbrand.game.g.b, org.json.JSONObject, com.tencent.mm.plugin.appbrand.game.g.d):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.postToWorker(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.jsapi.x.d.a(com.tencent.mm.plugin.appbrand.service.c, org.json.JSONObject, int):void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007e: CONSTRUCTOR  (r3v6 com.tencent.mm.plugin.appbrand.game.g.b$4) = 
                      (r0v25 'd2' com.tencent.mm.plugin.appbrand.game.g.b)
                      (r10v0 'jSONObject' org.json.JSONObject)
                      (wrap: com.tencent.mm.plugin.appbrand.jsapi.x.d$1 : 0x0077: CONSTRUCTOR  (r1v19 com.tencent.mm.plugin.appbrand.jsapi.x.d$1) = 
                      (r8v0 'this' com.tencent.mm.plugin.appbrand.jsapi.x.d A[IMMUTABLE_TYPE, THIS])
                      (r9v0 'cVar' com.tencent.mm.plugin.appbrand.service.c A[SKIP_ARG])
                      (r11v0 'i2' int A[SKIP_ARG])
                     call: com.tencent.mm.plugin.appbrand.jsapi.x.d.1.<init>(com.tencent.mm.plugin.appbrand.jsapi.x.d, com.tencent.mm.plugin.appbrand.service.c, int):void type: CONSTRUCTOR)
                     call: com.tencent.mm.plugin.appbrand.game.g.b.4.<init>(com.tencent.mm.plugin.appbrand.game.g.b, org.json.JSONObject, com.tencent.mm.plugin.appbrand.game.g.d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.jsapi.x.d.a(com.tencent.mm.plugin.appbrand.service.c, org.json.JSONObject, int):void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 28 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.game.g.b, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 34 more
                    */
                /*
                // Method dump skipped, instructions count: 353
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.x.d.a(com.tencent.mm.plugin.appbrand.service.c, org.json.JSONObject, int):void");
            }
        }
