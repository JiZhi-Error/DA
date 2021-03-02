package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends e implements a {
    private String dQC = this.intent.getStringExtra("free_wifi_passowrd");

    public f(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.i(24880);
        Log.i("MicroMsg.FreeWifi.ProtocolFour", "sessionKey=%s, step=%d, desc=Data retrieved. password=%s", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.dQC);
        AppMethodBeat.o(24880);
    }

    @Override // com.tencent.mm.plugin.freewifi.e.a
    public final void connect() {
        AppMethodBeat.i(24881);
        final c cVar = new c(this.ssid, this.wPy, this.dQC);
        j.dNl();
        j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.e.f.AnonymousClass1 */

            public final void run() {
                boolean z;
                AppMethodBeat.i(24879);
                c cVar = cVar;
                c.AnonymousClass1 r3 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r3v0 'r3' com.tencent.mm.plugin.freewifi.c$1) = 
                      (r2v0 'cVar' com.tencent.mm.plugin.freewifi.c)
                      (wrap: com.tencent.mm.plugin.freewifi.e.f$1$1 : 0x000b: CONSTRUCTOR  (r0v0 com.tencent.mm.plugin.freewifi.e.f$1$1) = (r9v0 'this' com.tencent.mm.plugin.freewifi.e.f$1 A[IMMUTABLE_TYPE, THIS]) call: com.tencent.mm.plugin.freewifi.e.f.1.1.<init>(com.tencent.mm.plugin.freewifi.e.f$1):void type: CONSTRUCTOR)
                     call: com.tencent.mm.plugin.freewifi.c.1.<init>(com.tencent.mm.plugin.freewifi.c, com.tencent.mm.plugin.freewifi.c$a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.freewifi.e.f.1.run():void, file: classes8.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.freewifi.c, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 14 more
                    */
                /*
                // Method dump skipped, instructions count: 346
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.e.f.AnonymousClass1.run():void");
            }
        });
        AppMethodBeat.o(24881);
    }
}
