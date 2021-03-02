package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import rx.a.b;
import rx.b.a;
import rx.d;
import rx.f.c;
import rx.g;
import rx.i;

public final class g implements d.a<Long> {
    final TimeUnit UkI;
    final rx.g UkJ;
    final long jJj = 0;
    final long period = 1000;

    @Override // rx.b.b
    public final /* synthetic */ void cA(Object obj) {
        AppMethodBeat.i(90258);
        final i iVar = (i) obj;
        final g.a createWorker = this.UkJ.createWorker();
        iVar.b(createWorker);
        AnonymousClass1 r6 = new a() {
            /* class rx.internal.a.g.AnonymousClass1 */
            long RPO;

            @Override // rx.b.a
            public final void call() {
                AppMethodBeat.i(90257);
                try {
                    i iVar = iVar;
                    long j2 = this.RPO;
                    this.RPO = 1 + j2;
                    iVar.gL(Long.valueOf(j2));
                    AppMethodBeat.o(90257);
                } catch (Throwable th) {
                    b.a(th, iVar);
                    AppMethodBeat.o(90257);
                    throw th;
                }
            }
        };
        long j2 = this.jJj;
        long j3 = this.period;
        TimeUnit timeUnit = this.UkI;
        long nanos = timeUnit.toNanos(j3);
        long nanos2 = TimeUnit.MILLISECONDS.toNanos(createWorker.now());
        c cVar = new c();
        g.a.AnonymousClass1 r0 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0036: CONSTRUCTOR  (r0v2 'r0' rx.g$a$1) = 
              (r1v0 'createWorker' rx.g$a)
              (r2v2 'nanos2' long)
              (wrap: long : 0x002e: ARITH  (r4v1 long) = (wrap: long : 0x002a: INVOKE  (r4v0 long) = (r12v0 'timeUnit' java.util.concurrent.TimeUnit), (r10v0 'j2' long) type: VIRTUAL call: java.util.concurrent.TimeUnit.toNanos(long):long) + (r2v2 'nanos2' long))
              (r6v0 'r6' rx.internal.a.g$1)
              (r7v0 'cVar' rx.f.c)
              (r8v0 'nanos' long)
             call: rx.g.a.1.<init>(rx.g$a, long, long, rx.b.a, rx.f.c, long):void type: CONSTRUCTOR in method: rx.internal.a.g.cA(java.lang.Object):void, file: classes8.dex
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: rx.g, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            */
        /*
            this = this;
            r13 = 90258(0x16092, float:1.26478E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r13)
            rx.i r15 = (rx.i) r15
            rx.g r0 = r14.UkJ
            rx.g$a r1 = r0.createWorker()
            r15.b(r1)
            rx.internal.a.g$1 r6 = new rx.internal.a.g$1
            r6.<init>(r15, r1)
            long r10 = r14.jJj
            long r2 = r14.period
            java.util.concurrent.TimeUnit r12 = r14.UkI
            long r8 = r12.toNanos(r2)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r2 = r1.now()
            long r2 = r0.toNanos(r2)
            long r4 = r12.toNanos(r10)
            long r4 = r4 + r2
            rx.f.c r7 = new rx.f.c
            r7.<init>()
            rx.g$a$1 r0 = new rx.g$a$1
            r0.<init>(r2, r4, r6, r7, r8)
            rx.f.c r2 = new rx.f.c
            r2.<init>()
            r7.f(r2)
            rx.j r0 = r1.a(r0, r10, r12)
            r2.f(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.a.g.cA(java.lang.Object):void");
    }

    public g(long j2, long j3, TimeUnit timeUnit, rx.g gVar) {
        this.UkI = timeUnit;
        this.UkJ = gVar;
    }
}
