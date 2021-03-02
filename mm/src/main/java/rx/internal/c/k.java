package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.b;
import rx.e;
import rx.f.d;
import rx.g;
import rx.j;

public final class k extends g implements j {
    private static final j UmF = new j() {
        /* class rx.internal.c.k.AnonymousClass3 */

        @Override // rx.j
        public final void hQA() {
        }

        @Override // rx.j
        public final boolean hQB() {
            return false;
        }
    };
    private static final j UmG = d.hRn();
    private final g UmC;
    private final e<rx.d<rx.b>> UmD;
    private final j UmE;

    public k(rx.b.e<rx.d<rx.d<rx.b>>, rx.b> eVar, g gVar) {
        AppMethodBeat.i(90395);
        this.UmC = gVar;
        rx.e.c cVar = new rx.e.c();
        cVar.UoA = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: IPUT  
              (wrap: rx.e.a$1 : 0x0012: CONSTRUCTOR  (r1v0 rx.e.a$1) = (r0v0 'cVar' rx.e.c) call: rx.e.a.1.<init>(rx.e.c):void type: CONSTRUCTOR)
              (r0v0 'cVar' rx.e.c)
             rx.e.c.UoA rx.b.b in method: rx.internal.c.k.<init>(rx.b.e<rx.d<rx.d<rx.b>>, rx.b>, rx.g):void, file: classes8.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r1v0 rx.e.a$1) = (r0v0 'cVar' rx.e.c) call: rx.e.a.1.<init>(rx.e.c):void type: CONSTRUCTOR in method: rx.internal.c.k.<init>(rx.b.e<rx.d<rx.d<rx.b>>, rx.b>, rx.g):void, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: rx.e.a, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 18 more
            */
        /*
            this = this;
            r2 = 90395(0x1611b, float:1.2667E-40)
            r3.<init>()
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            r3.UmC = r5
            rx.e.c r0 = new rx.e.c
            r0.<init>()
            rx.e.a$1 r1 = new rx.e.a$1
            r1.<init>(r0)
            r0.UoA = r1
            rx.e.a r1 = new rx.e.a
            r1.<init>(r0, r0)
            rx.c.b r0 = new rx.c.b
            r0.<init>(r1)
            r3.UmD = r0
            rx.d r0 = r1.hQy()
            java.lang.Object r0 = r4.call(r0)
            rx.b r0 = (rx.b) r0
            rx.j r0 = r0.hQv()
            r3.UmE = r0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.c.k.<init>(rx.b.e, rx.g):void");
    }

    @Override // rx.j
    public final void hQA() {
        AppMethodBeat.i(90396);
        this.UmE.hQA();
        AppMethodBeat.o(90396);
    }

    @Override // rx.j
    public final boolean hQB() {
        AppMethodBeat.i(90397);
        boolean hQB = this.UmE.hQB();
        AppMethodBeat.o(90397);
        return hQB;
    }

    @Override // rx.g
    public final g.a createWorker() {
        AppMethodBeat.i(90398);
        final g.a createWorker = this.UmC.createWorker();
        rx.internal.a.a hQE = rx.internal.a.a.hQE();
        final rx.c.b bVar = new rx.c.b(hQE);
        rx.d<rx.b> a2 = hQE.a(new rx.b.e<c, rx.b>() {
            /* class rx.internal.c.k.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // rx.b.e
            public final /* synthetic */ rx.b call(c cVar) {
                AppMethodBeat.i(90387);
                final c cVar2 = cVar;
                rx.b a2 = rx.b.a(new b.a() {
                    /* class rx.internal.c.k.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // rx.b.b
                    public final /* synthetic */ void cA(b.c cVar) {
                        AppMethodBeat.i(90386);
                        b.c cVar2 = cVar;
                        cVar2.a(cVar2);
                        c.a(cVar2, createWorker);
                        cVar2.hQw();
                        AppMethodBeat.o(90386);
                    }
                });
                AppMethodBeat.o(90387);
                return a2;
            }
        });
        AnonymousClass2 r3 = new g.a() {
            /* class rx.internal.c.k.AnonymousClass2 */
            private final AtomicBoolean UmL = new AtomicBoolean();

            {
                AppMethodBeat.i(90388);
                AppMethodBeat.o(90388);
            }

            @Override // rx.j
            public final void hQA() {
                AppMethodBeat.i(90389);
                if (this.UmL.compareAndSet(false, true)) {
                    createWorker.hQA();
                    bVar.hQw();
                }
                AppMethodBeat.o(90389);
            }

            @Override // rx.j
            public final boolean hQB() {
                AppMethodBeat.i(90390);
                boolean z = this.UmL.get();
                AppMethodBeat.o(90390);
                return z;
            }

            @Override // rx.g.a
            public final j a(rx.b.a aVar, long j2, TimeUnit timeUnit) {
                AppMethodBeat.i(90391);
                a aVar2 = new a(aVar, j2, timeUnit);
                bVar.gL(aVar2);
                AppMethodBeat.o(90391);
                return aVar2;
            }

            @Override // rx.g.a
            public final j a(rx.b.a aVar) {
                AppMethodBeat.i(90392);
                b bVar = new b(aVar);
                bVar.gL(bVar);
                AppMethodBeat.o(90392);
                return bVar;
            }
        };
        this.UmD.gL(a2);
        AppMethodBeat.o(90398);
        return r3;
    }

    static {
        AppMethodBeat.i(90399);
        AppMethodBeat.o(90399);
    }

    static abstract class c extends AtomicReference<j> implements j {
        /* access modifiers changed from: protected */
        public abstract j a(g.a aVar);

        public c() {
            super(k.UmF);
        }

        @Override // rx.j
        public final boolean hQB() {
            return ((j) get()).hQB();
        }

        @Override // rx.j
        public final void hQA() {
            j jVar;
            j jVar2 = k.UmG;
            do {
                jVar = (j) get();
                if (jVar == k.UmG) {
                    return;
                }
            } while (!compareAndSet(jVar, jVar2));
            if (jVar != k.UmF) {
                jVar.hQA();
            }
        }

        static /* synthetic */ void a(c cVar, g.a aVar) {
            j jVar = (j) cVar.get();
            if (jVar != k.UmG && jVar == k.UmF) {
                j a2 = cVar.a(aVar);
                if (!cVar.compareAndSet(k.UmF, a2)) {
                    a2.hQA();
                }
            }
        }
    }

    static class b extends c {
        private final rx.b.a Umw;

        public b(rx.b.a aVar) {
            this.Umw = aVar;
        }

        /* access modifiers changed from: protected */
        @Override // rx.internal.c.k.c
        public final j a(g.a aVar) {
            AppMethodBeat.i(90393);
            j a2 = aVar.a(this.Umw);
            AppMethodBeat.o(90393);
            return a2;
        }
    }

    static class a extends c {
        private final TimeUnit UkI;
        private final rx.b.a Umw;
        private final long delayTime;

        public a(rx.b.a aVar, long j2, TimeUnit timeUnit) {
            this.Umw = aVar;
            this.delayTime = j2;
            this.UkI = timeUnit;
        }

        /* access modifiers changed from: protected */
        @Override // rx.internal.c.k.c
        public final j a(g.a aVar) {
            AppMethodBeat.i(90394);
            j a2 = aVar.a(this.Umw, this.delayTime, this.UkI);
            AppMethodBeat.o(90394);
            return a2;
        }
    }
}
