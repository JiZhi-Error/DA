package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.g.b;
import com.tencent.mm.plugin.appbrand.game.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends b {
    public static final int CTRL_INDEX = 686;
    public static final String NAME = "operateMediaContainer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.x.b
    public final void a(final com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46755);
        Log.i("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaContainer", "hy: %s %s", NAME, jSONObject.toString());
        String optString = jSONObject.optString("operationType");
        if (optString.equalsIgnoreCase("create")) {
            b d2 = d(cVar);
            AnonymousClass1 r1 = new d<JSONObject>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.x.c.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                @Override // com.tencent.mm.plugin.appbrand.game.g.d
                public final /* synthetic */ void a(int i2, int i3, String str, JSONObject jSONObject) {
                    AppMethodBeat.i(46752);
                    JSONObject jSONObject2 = jSONObject;
                    try {
                        jSONObject2.put("errCode", i3);
                        jSONObject2.put("errMsg", c.this.getName() + ":" + str);
                        Log.i("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaContainer", "createMediaContainer result, %s", jSONObject2.toString());
                    } catch (JSONException e2) {
                    }
                    cVar.i(i2, jSONObject2.toString());
                    AppMethodBeat.o(46752);
                }
            };
            Log.i("MicroMsg.GameRecorderMgr", "hy: trigger createMediaContainer");
            d2.luO.postToWorker(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: INVOKE  
                  (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0042: IGET  (r2v15 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v29 'd2' com.tencent.mm.plugin.appbrand.game.g.b) com.tencent.mm.plugin.appbrand.game.g.b.luO com.tencent.mm.sdk.platformtools.MMHandler)
                  (wrap: com.tencent.mm.plugin.appbrand.game.g.b$3 : 0x0046: CONSTRUCTOR  (r3v7 com.tencent.mm.plugin.appbrand.game.g.b$3) = 
                  (r0v29 'd2' com.tencent.mm.plugin.appbrand.game.g.b)
                  (r10v0 'jSONObject' org.json.JSONObject)
                  (r1v23 'r1' com.tencent.mm.plugin.appbrand.jsapi.x.c$1)
                 call: com.tencent.mm.plugin.appbrand.game.g.b.3.<init>(com.tencent.mm.plugin.appbrand.game.g.b, org.json.JSONObject, com.tencent.mm.plugin.appbrand.game.g.d):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.postToWorker(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.jsapi.x.c.a(com.tencent.mm.plugin.appbrand.service.c, org.json.JSONObject, int):void, file: classes7.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0046: CONSTRUCTOR  (r3v7 com.tencent.mm.plugin.appbrand.game.g.b$3) = 
                  (r0v29 'd2' com.tencent.mm.plugin.appbrand.game.g.b)
                  (r10v0 'jSONObject' org.json.JSONObject)
                  (r1v23 'r1' com.tencent.mm.plugin.appbrand.jsapi.x.c$1)
                 call: com.tencent.mm.plugin.appbrand.game.g.b.3.<init>(com.tencent.mm.plugin.appbrand.game.g.b, org.json.JSONObject, com.tencent.mm.plugin.appbrand.game.g.d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.jsapi.x.c.a(com.tencent.mm.plugin.appbrand.service.c, org.json.JSONObject, int):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.game.g.b, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
            // Method dump skipped, instructions count: 375
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.x.c.a(com.tencent.mm.plugin.appbrand.service.c, org.json.JSONObject, int):void");
        }
    }
