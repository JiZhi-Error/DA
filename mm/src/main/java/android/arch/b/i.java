package android.arch.b;

import android.arch.b.a;
import android.support.v7.h.c;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import java.util.List;

public abstract class i<T, VH extends RecyclerView.v> extends RecyclerView.a<VH> {
    private final a.AbstractC0002a<T> dC = new a.AbstractC0002a<T>() {
        /* class android.arch.b.i.AnonymousClass1 */
    };
    private final a<T> eX;

    protected i(c.AbstractC0051c<T> cVar) {
        this.eX = new a<>(this, cVar);
        this.eX.dC = this.dC;
    }

    public final void a(h<T> hVar) {
        a<T> aVar = this.eX;
        if (hVar != null) {
            if (aVar.dE == null && aVar.dF == null) {
                aVar.dD = hVar.ao();
            } else if (hVar.ao() != aVar.dD) {
                throw new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
            }
        }
        if (hVar != aVar.dE) {
            int i2 = aVar.dG + 1;
            aVar.dG = i2;
            if (hVar == null) {
                int itemCount = aVar.getItemCount();
                if (aVar.dE != null) {
                    aVar.dE.a(aVar.dH);
                    aVar.dE = null;
                } else if (aVar.dF != null) {
                    aVar.dF = null;
                }
                aVar.dz.k(0, itemCount);
            } else if (aVar.dE == null && aVar.dF == null) {
                aVar.dE = hVar;
                hVar.a((List) null, aVar.dH);
                aVar.dz.f(0, hVar.size());
            } else {
                if (aVar.dE != null) {
                    aVar.dE.a(aVar.dH);
                    aVar.dF = (h) aVar.dE.at();
                    aVar.dE = null;
                }
                if (aVar.dF == null || aVar.dE != null) {
                    throw new IllegalStateException("must be in snapshot state to diff");
                }
                aVar.dA.eE.execute(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a2: INVOKE  
                      (wrap: java.util.concurrent.Executor : 0x009a: IGET  (r6v1 java.util.concurrent.Executor) = 
                      (wrap: android.support.v7.f.a.a<T> : 0x0098: IGET  (r0v7 android.support.v7.f.a.a<T>) = (r1v0 'aVar' android.arch.b.a<T>) android.arch.b.a.dA android.support.v7.f.a.a)
                     android.support.v7.f.a.a.eE java.util.concurrent.Executor)
                      (wrap: android.arch.b.a$2 : 0x009f: CONSTRUCTOR  (r0v8 android.arch.b.a$2) = 
                      (r1v0 'aVar' android.arch.b.a<T>)
                      (wrap: android.arch.b.h<T> : 0x0090: IGET  (r2v0 android.arch.b.h<T>) = (r1v0 'aVar' android.arch.b.a<T>) android.arch.b.a.dF android.arch.b.h)
                      (wrap: android.arch.b.h : 0x0096: CHECK_CAST (r3v1 android.arch.b.h) = (android.arch.b.h) (wrap: java.util.List<T> : 0x0092: INVOKE  (r3v0 java.util.List<T>) = (r8v0 'hVar' android.arch.b.h<T>) type: VIRTUAL call: android.arch.b.h.at():java.util.List))
                      (r4v0 'i2' int)
                      (r8v0 'hVar' android.arch.b.h<T>)
                     call: android.arch.b.a.2.<init>(android.arch.b.a, android.arch.b.h, android.arch.b.h, int, android.arch.b.h):void type: CONSTRUCTOR)
                     type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: android.arch.b.i.a(android.arch.b.h<T>):void, file: classes8.dex
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
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009f: CONSTRUCTOR  (r0v8 android.arch.b.a$2) = 
                      (r1v0 'aVar' android.arch.b.a<T>)
                      (wrap: android.arch.b.h<T> : 0x0090: IGET  (r2v0 android.arch.b.h<T>) = (r1v0 'aVar' android.arch.b.a<T>) android.arch.b.a.dF android.arch.b.h)
                      (wrap: android.arch.b.h : 0x0096: CHECK_CAST (r3v1 android.arch.b.h) = (android.arch.b.h) (wrap: java.util.List<T> : 0x0092: INVOKE  (r3v0 java.util.List<T>) = (r8v0 'hVar' android.arch.b.h<T>) type: VIRTUAL call: android.arch.b.h.at():java.util.List))
                      (r4v0 'i2' int)
                      (r8v0 'hVar' android.arch.b.h<T>)
                     call: android.arch.b.a.2.<init>(android.arch.b.a, android.arch.b.h, android.arch.b.h, int, android.arch.b.h):void type: CONSTRUCTOR in method: android.arch.b.i.a(android.arch.b.h<T>):void, file: classes8.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 30 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: android.arch.b.a, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 36 more
                    */
                /*
                // Method dump skipped, instructions count: 166
                */
                throw new UnsupportedOperationException("Method not decompiled: android.arch.b.i.a(android.arch.b.h):void");
            }

            @Override // android.support.v7.widget.RecyclerView.a
            public final int getItemCount() {
                return this.eX.getItemCount();
            }
        }
