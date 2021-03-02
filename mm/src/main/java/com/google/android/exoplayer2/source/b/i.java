package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i implements n {
    public final int byu;
    private final j byv;

    public i(j jVar, int i2) {
        this.byv = jVar;
        this.byu = i2;
    }

    @Override // com.google.android.exoplayer2.source.n
    public final boolean isReady() {
        AppMethodBeat.i(62861);
        j jVar = this.byv;
        int i2 = this.byu;
        if (jVar.bwd || (!jVar.vz() && jVar.bvQ[i2].bwO.vF())) {
            AppMethodBeat.o(62861);
            return true;
        }
        AppMethodBeat.o(62861);
        return false;
    }

    @Override // com.google.android.exoplayer2.source.n
    public final void vs() {
        AppMethodBeat.i(62862);
        this.byv.byx.vs();
        AppMethodBeat.o(62862);
    }

    @Override // com.google.android.exoplayer2.source.n
    public final int b(k kVar, e eVar, boolean z) {
        boolean z2;
        int i2;
        AppMethodBeat.i(62863);
        j jVar = this.byv;
        int i3 = this.byu;
        if (jVar.vz()) {
            AppMethodBeat.o(62863);
            return -3;
        }
        if (!jVar.byA.isEmpty()) {
            while (jVar.byA.size() > 1) {
                int i4 = jVar.byA.getFirst().uid;
                int i5 = 0;
                while (true) {
                    if (i5 >= jVar.bvQ.length) {
                        z2 = true;
                        break;
                    }
                    if (jVar.byF[i5]) {
                        l lVar = jVar.bvQ[i5].bwO;
                        int eD = lVar.eD(lVar.bwG);
                        if (lVar.vF()) {
                            i2 = lVar.bwB[eD];
                        } else {
                            i2 = lVar.bwM;
                        }
                        if (i2 == i4) {
                            z2 = false;
                            break;
                        }
                    }
                    i5++;
                }
                if (!z2) {
                    break;
                }
                jVar.byA.removeFirst();
            }
            f first = jVar.byA.getFirst();
            Format format = first.bxk;
            if (!format.equals(jVar.byB)) {
                b.a aVar = jVar.byl;
                int i6 = jVar.trackType;
                int i7 = first.bxl;
                Object obj = first.bxm;
                long j2 = first.bxn;
                if (aVar.bvb != null) {
                    aVar.handler.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x008d: INVOKE  
                          (wrap: android.os.Handler : 0x0086: IGET  (r10v0 android.os.Handler) = (r1v4 'aVar' com.google.android.exoplayer2.source.b$a) com.google.android.exoplayer2.source.b.a.handler android.os.Handler)
                          (wrap: com.google.android.exoplayer2.source.b$a$5 : 0x008a: CONSTRUCTOR  (r0v11 com.google.android.exoplayer2.source.b$a$5) = 
                          (r1v4 'aVar' com.google.android.exoplayer2.source.b$a)
                          (r2v2 'i6' int)
                          (r3v1 'format' com.google.android.exoplayer2.Format)
                          (r4v1 'i7' int)
                          (r5v1 'obj' java.lang.Object)
                          (r6v1 'j2' long)
                         call: com.google.android.exoplayer2.source.b.a.5.<init>(com.google.android.exoplayer2.source.b$a, int, com.google.android.exoplayer2.Format, int, java.lang.Object, long):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.google.android.exoplayer2.source.b.i.b(com.google.android.exoplayer2.k, com.google.android.exoplayer2.b.e, boolean):int, file: classes8.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x008a: CONSTRUCTOR  (r0v11 com.google.android.exoplayer2.source.b$a$5) = 
                          (r1v4 'aVar' com.google.android.exoplayer2.source.b$a)
                          (r2v2 'i6' int)
                          (r3v1 'format' com.google.android.exoplayer2.Format)
                          (r4v1 'i7' int)
                          (r5v1 'obj' java.lang.Object)
                          (r6v1 'j2' long)
                         call: com.google.android.exoplayer2.source.b.a.5.<init>(com.google.android.exoplayer2.source.b$a, int, com.google.android.exoplayer2.Format, int, java.lang.Object, long):void type: CONSTRUCTOR in method: com.google.android.exoplayer2.source.b.i.b(com.google.android.exoplayer2.k, com.google.android.exoplayer2.b.e, boolean):int, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 33 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.exoplayer2.source.b, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 39 more
                        */
                    /*
                    // Method dump skipped, instructions count: 166
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.i.b(com.google.android.exoplayer2.k, com.google.android.exoplayer2.b.e, boolean):int");
                }

                @Override // com.google.android.exoplayer2.source.n
                public final void Y(long j2) {
                    AppMethodBeat.i(62864);
                    j jVar = this.byv;
                    m mVar = jVar.bvQ[this.byu];
                    if (!jVar.bwd || j2 <= mVar.bwO.vy()) {
                        mVar.f(j2, true);
                        AppMethodBeat.o(62864);
                        return;
                    }
                    mVar.bwO.vH();
                    AppMethodBeat.o(62864);
                }
            }
