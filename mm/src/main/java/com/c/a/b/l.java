package com.c.a.b;

import com.c.a.b.a.a;
import com.c.a.c.e;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class l {
    static final /* synthetic */ boolean $assertionsDisabled = (!l.class.desiredAssertionStatus());
    public static final i cpC = new j(k.UNKNOWN);
    final a cpD;
    ArrayList<g> cpE = new ArrayList<>();
    g cpF;
    private e<c> cpG = new e<>();
    private int[] cpH;
    long cpI = Util.MAX_32BIT_VALUE;

    public l(a aVar) {
        this.cpD = aVar;
        g(0, BuildConfig.KINDA_DEFAULT);
    }

    public final g g(int i2, String str) {
        g hs = hs(i2);
        if (hs == null) {
            hs = new g(i2, str);
            hs.coS = this;
            this.cpE.add(hs);
        }
        this.cpF = hs;
        return this.cpF;
    }

    private g hs(int i2) {
        for (int i3 = 0; i3 < this.cpE.size(); i3++) {
            if (this.cpE.get(i3).mId == i2) {
                return this.cpE.get(i3);
            }
        }
        return null;
    }

    public final Collection<j> Kn() {
        return this.cpE.get(0).coN;
    }

    public final n hq(int i2) {
        return this.cpF.hq(i2);
    }

    public final n bS(int i2, int i3) {
        return this.cpF.bS(i2, i3);
    }

    public final void a(j jVar) {
        this.cpF.a(jVar);
        jVar.cpb = this.cpF;
    }

    public final o hr(int i2) {
        return this.cpF.hr(i2);
    }

    public final void ht(int i2) {
        int i3 = -1;
        for (int i4 = 0; i4 < p.values().length; i4++) {
            i3 = Math.max(p.values()[i4].mId, i3);
        }
        if ($assertionsDisabled || (i3 > 0 && i3 <= p.LONG.mId)) {
            this.cpH = new int[(i3 + 1)];
            Arrays.fill(this.cpH, -1);
            for (int i5 = 0; i5 < p.values().length; i5++) {
                this.cpH[p.values()[i5].mId] = p.values()[i5].mSize;
            }
            this.cpH[p.OBJECT.mId] = i2;
            this.cpI = -1 >>> ((8 - i2) << 3);
            return;
        }
        throw new AssertionError();
    }

    public final int b(p pVar) {
        return this.cpH[pVar.mId];
    }

    public final void a(long j2, i iVar) {
        this.cpF.a(j2, iVar);
        iVar.cpb = this.cpF;
    }

    public final i aR(long j2) {
        for (int i2 = 0; i2 < this.cpE.size(); i2++) {
            i aN = this.cpE.get(i2).aN(j2);
            if (aN != null) {
                return aN;
            }
        }
        return aS(j2);
    }

    public final c aS(long j2) {
        for (int i2 = 0; i2 < this.cpE.size(); i2++) {
            c aO = this.cpE.get(i2).aO(j2);
            if (aO != null) {
                return aO;
            }
        }
        return null;
    }

    public final c cJ(String str) {
        for (int i2 = 0; i2 < this.cpE.size(); i2++) {
            c cI = this.cpE.get(i2).cI(str);
            if (cI != null) {
                return cI;
            }
        }
        return null;
    }

    public final void Ko() {
        c cJ = cJ("java.lang.Class");
        int i2 = cJ != null ? cJ.coE : 0;
        Iterator<g> it = this.cpE.iterator();
        while (it.hasNext()) {
            g next = it.next();
            for (c cVar : next.coQ.values()) {
                c Kd = cVar.Kd();
                if (Kd != null) {
                    Kd.coH.add(cVar);
                }
                int i3 = i2;
                for (d dVar : cVar.coD) {
                    i3 += b(dVar.cow);
                }
                cVar.mSize = i3;
            }
            ArrayList<i> arrayList = new ArrayList(next.coR.size());
            next.coR.a(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006a: INVOKE  
                  (wrap: com.c.a.c.k<com.c.a.b.i> : 0x0063: IGET  (r2v2 com.c.a.c.k<com.c.a.b.i>) = (r0v5 'next' com.c.a.b.g) com.c.a.b.g.coR com.c.a.c.k)
                  (wrap: com.c.a.b.g$1 : 0x0067: CONSTRUCTOR  (r5v0 com.c.a.b.g$1) = (r0v5 'next' com.c.a.b.g), (r1v3 'arrayList' java.util.ArrayList<com.c.a.b.i>) call: com.c.a.b.g.1.<init>(com.c.a.b.g, java.util.ArrayList):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.c.a.c.k.a(com.c.a.c.s):boolean in method: com.c.a.b.l.Ko():void, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0067: CONSTRUCTOR  (r5v0 com.c.a.b.g$1) = (r0v5 'next' com.c.a.b.g), (r1v3 'arrayList' java.util.ArrayList<com.c.a.b.i>) call: com.c.a.b.g.1.<init>(com.c.a.b.g, java.util.ArrayList):void type: CONSTRUCTOR in method: com.c.a.b.l.Ko():void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.c.a.b.g, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
            // Method dump skipped, instructions count: 178
            */
            throw new UnsupportedOperationException("Method not decompiled: com.c.a.b.l.Ko():void");
        }

        public final void Kp() {
            String Kf = c.Kf();
            ArrayList<c> arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.cpE.size(); i2++) {
                arrayList.addAll(this.cpE.get(i2).coQ.az(Kf));
            }
            ArrayList<c> arrayList2 = new ArrayList();
            for (c cVar : arrayList) {
                arrayList2.addAll(cVar.Kg());
            }
            for (c cVar2 : arrayList2) {
                cVar2.coF = true;
                this.cpG.add(cVar2);
            }
        }
    }
