package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.j;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import java.util.Iterator;
import org.json.JSONObject;

public class p extends bs {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "dispatchEvent";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
        AppMethodBeat.i(78548);
        JSONObject jSONObject = aVar.ctb.csi;
        String optString = jSONObject.optString("eventName");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        Iterator<s> it = j.gbV().iterator();
        while (it.hasNext()) {
            it.next().ctS.a(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: INVOKE  
                  (wrap: com.tencent.luggage.d.p : 0x002c: IGET  (r0v7 com.tencent.luggage.d.p) = 
                  (wrap: com.tencent.luggage.d.s : 0x0026: INVOKE  (r0v5 com.tencent.luggage.d.s) = (r3v0 'it' java.util.Iterator<com.tencent.luggage.d.s>) type: INTERFACE call: java.util.Iterator.next():java.lang.Object)
                 com.tencent.luggage.d.s.ctS com.tencent.luggage.d.p)
                  (wrap: com.tencent.mm.plugin.webview.luggage.a.c$1 : 0x0030: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.webview.luggage.a.c$1) = (r1v1 'optString' java.lang.String), (r2v1 'optJSONObject' org.json.JSONObject) call: com.tencent.mm.plugin.webview.luggage.a.c.1.<init>(java.lang.String, org.json.JSONObject):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.luggage.d.p.a(com.tencent.luggage.d.d):void in method: com.tencent.mm.plugin.webview.luggage.jsapi.p.b(com.tencent.luggage.d.b$a):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0030: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.webview.luggage.a.c$1) = (r1v1 'optString' java.lang.String), (r2v1 'optJSONObject' org.json.JSONObject) call: com.tencent.mm.plugin.webview.luggage.a.c.1.<init>(java.lang.String, org.json.JSONObject):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.luggage.jsapi.p.b(com.tencent.luggage.d.b$a):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.luggage.a.c, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
                this = this;
                r5 = 78548(0x132d4, float:1.10069E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                com.tencent.luggage.bridge.k r0 = r7.ctb
                org.json.JSONObject r0 = r0.csi
                java.lang.String r1 = "eventName"
                java.lang.String r1 = r0.optString(r1)
                java.lang.String r2 = "data"
                org.json.JSONObject r2 = r0.optJSONObject(r2)
                java.util.LinkedList r0 = com.tencent.mm.plugin.webview.luggage.j.gbV()
                java.util.Iterator r3 = r0.iterator()
            L_0x0020:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x0037
                java.lang.Object r0 = r3.next()
                com.tencent.luggage.d.s r0 = (com.tencent.luggage.d.s) r0
                com.tencent.luggage.d.p r0 = r0.ctS
                com.tencent.mm.plugin.webview.luggage.a.c$1 r4 = new com.tencent.mm.plugin.webview.luggage.a.c$1
                r4.<init>(r1, r2)
                r0.a(r4)
                goto L_0x0020
            L_0x0037:
                java.lang.String r0 = ""
                r1 = 0
                r7.c(r0, r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.luggage.jsapi.p.b(com.tencent.luggage.d.b$a):void");
        }
    }
