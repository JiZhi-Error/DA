package com.tencent.mm.kernel.a;

import com.tencent.mm.blink.b;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.kernel.a.b.e;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashSet;
import java.util.Iterator;

public abstract class d implements b {
    public e<Object> hsw = e.aAL();
    private final HashSet<String> hsx = new HashSet<>();

    @Override // com.tencent.mm.kernel.a.b
    public void VZ() {
        boolean aBb = g.aAe().azG().aBb();
        int min = (int) Math.min(Math.floor((aBb ? 1.5d : 1.0d) * ((double) n.getNumCores())), 6.0d);
        Log.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", Integer.valueOf(min));
        this.hsw.init(min);
        c aAu = c.aAu();
        aAu.hrS.a(b.class);
        aAu.hrR.a(com.tencent.mm.kernel.a.c.b.class);
        aAu.hrT.a(h.class, a.class, com.tencent.mm.kernel.api.e.class, at.class, c.class);
        com.tencent.mm.kernel.a.b.g gVar = aAu.hrT;
        gVar.hth = new Class[1];
        System.arraycopy(new Class[]{c.class}, 0, gVar.hth, 0, 1);
        g.aAe().azG().hqy.hrL = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0096: IPUT  
              (wrap: com.tencent.mm.kernel.a.c$1 : 0x0093: CONSTRUCTOR  (r2v8 com.tencent.mm.kernel.a.c$1) = (r1v3 'aAu' com.tencent.mm.kernel.a.c) call: com.tencent.mm.kernel.a.c.1.<init>(com.tencent.mm.kernel.a.c):void type: CONSTRUCTOR)
              (wrap: com.tencent.mm.kernel.a.a : 0x008f: IGET  (r0v18 com.tencent.mm.kernel.a.a) = 
              (wrap: com.tencent.mm.kernel.b.h : 0x0089: INVOKE  (r0v16 com.tencent.mm.kernel.b.h) = 
              (wrap: com.tencent.mm.kernel.d<com.tencent.mm.kernel.b.h> : 0x0085: INVOKE  (r0v15 com.tencent.mm.kernel.d<com.tencent.mm.kernel.b.h>) =  type: STATIC call: com.tencent.mm.kernel.g.aAe():com.tencent.mm.kernel.d)
             type: VIRTUAL call: com.tencent.mm.kernel.d.azG():com.tencent.mm.kernel.b.g)
             com.tencent.mm.kernel.b.g.hqy com.tencent.mm.kernel.a.a)
             com.tencent.mm.kernel.a.a.hrL com.tencent.mm.kernel.a.a.b in method: com.tencent.mm.kernel.a.d.VZ():void, file: classes4.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0093: CONSTRUCTOR  (r2v8 com.tencent.mm.kernel.a.c$1) = (r1v3 'aAu' com.tencent.mm.kernel.a.c) call: com.tencent.mm.kernel.a.c.1.<init>(com.tencent.mm.kernel.a.c):void type: CONSTRUCTOR in method: com.tencent.mm.kernel.a.d.VZ():void, file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.kernel.a.c, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 18 more
            */
        /*
        // Method dump skipped, instructions count: 163
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.a.d.VZ():void");
    }

    public static void al(Class<? extends f> cls) {
        g.aAd().ad(cls);
    }

    protected static void FW(String str) {
        g.aAd().FO(str);
    }

    /* access modifiers changed from: protected */
    public final void FX(String str) {
        this.hsx.add(str);
    }

    @Override // com.tencent.mm.kernel.a.b
    public final void aAs() {
        g.aAd().azE();
        this.hsw.prepare();
        for (e.c cVar : this.hsw.aAN()) {
            c.aAu().f(cVar.dli.getLooper());
        }
        com.tencent.mm.blink.a.CM("makeDependency");
    }

    @Override // com.tencent.mm.kernel.a.b
    public void a(com.tencent.mm.kernel.b.g gVar) {
        this.hsw.a(new e.b(), c.hsc, c.aAu().hrS, "configure-functional plugins");
        com.tencent.mm.blink.a.CM("configurePlugins");
        EventCenter.instance.publish(new po());
    }

    @Override // com.tencent.mm.kernel.a.b
    public final void aAt() {
        this.hsw.a(new e.b(), c.hsd, c.aAu().hrR, "task-functional plugins");
        com.tencent.mm.blink.a.CM("executeTasks");
    }

    @Override // com.tencent.mm.kernel.a.b
    public void b(com.tencent.mm.kernel.b.g gVar) {
        a.k("startup final step, account initialize... for parallels", new Object[0]);
        if (gVar.aBb()) {
            c aAu = c.aAu();
            for (f fVar : g.aAd().azF()) {
                aAu.bA(fVar);
            }
            if (g.aAf().azp()) {
                g.aAf().azf();
            }
        }
        com.tencent.mm.blink.a.CM("installPendingPlugins");
        long nanoTime = System.nanoTime();
        if (this.hsx.size() > 0) {
            Iterator<String> it = this.hsx.iterator();
            while (it.hasNext()) {
                g.aAi();
                g.aAd().x(it.next(), true);
            }
            this.hsx.clear();
            com.tencent.mm.blink.a.q("installPendingPlugins installed", nanoTime);
            g.aAi();
            g.aAd().azE();
            com.tencent.mm.blink.a.CM("installPendingPlugins dependency made.");
            EventCenter.instance.publish(new pp());
        }
        boolean Wm = Wm();
        boolean z = gVar.aBb() && g.aAf().azp();
        if (z && !Wm) {
            g.aAf().azr();
        }
        com.tencent.mm.blink.b ake = com.tencent.mm.blink.b.ake();
        Log.i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", Boolean.valueOf(Wm));
        if (Wm) {
            ake.a(b.EnumC0279b.Now);
        } else {
            MMHandlerThread.postToMainThreadDelayed(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ec: INVOKE  
                  (wrap: com.tencent.mm.blink.b$2 : 0x00e7: CONSTRUCTOR  (r1v2 com.tencent.mm.blink.b$2) = (r4v1 'ake' com.tencent.mm.blink.b) call: com.tencent.mm.blink.b.2.<init>(com.tencent.mm.blink.b):void type: CONSTRUCTOR)
                  (1000 long)
                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThreadDelayed(java.lang.Runnable, long):void in method: com.tencent.mm.kernel.a.d.b(com.tencent.mm.kernel.b.g):void, file: classes4.dex
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
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00e7: CONSTRUCTOR  (r1v2 com.tencent.mm.blink.b$2) = (r4v1 'ake' com.tencent.mm.blink.b) call: com.tencent.mm.blink.b.2.<init>(com.tencent.mm.blink.b):void type: CONSTRUCTOR in method: com.tencent.mm.kernel.a.d.b(com.tencent.mm.kernel.b.g):void, file: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.blink.b, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
            // Method dump skipped, instructions count: 240
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.a.d.b(com.tencent.mm.kernel.b.g):void");
        }

        public boolean Wm() {
            return true;
        }
    }
