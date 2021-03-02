package com.tencent.mm.plugin.appbrand.launching;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u0012\u0013\u0014\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J*\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u0002`\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib;", "", "()V", "TAG", "", "runningTasks", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "obtainTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "waitFor", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "function", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "ITaskMap", "IWaitForCommLibTask", "Task", "TaskMapApi24", "TaskMapApiBase", "plugin-appbrand-integration_release"})
public final class g {
    private static final a mRu;
    public static final g mRv = new g();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "", "get", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "key", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
    public interface a {
        c B(q qVar);

        c C(q qVar);

        void a(q qVar, kotlin.g.a.a<c> aVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "", "interrupt", "", "plugin-appbrand-integration_release"})
    public interface b {
        void interrupt();
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "invoke"})
    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<c> {
        final /* synthetic */ q kAi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(q qVar) {
            super(0);
            this.kAi = qVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$1"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.b<ICommLibReader, x> {
            final /* synthetic */ f mRD;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(1);
                this.mRD = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(ICommLibReader iCommLibReader) {
                AppMethodBeat.i(50741);
                ICommLibReader iCommLibReader2 = iCommLibReader;
                p.h(iCommLibReader2, LocaleUtil.ITALIAN);
                this.mRD.kAi.a(iCommLibReader2);
                x xVar = x.SXb;
                AppMethodBeat.o(50741);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$obtainTask$1$1$2"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.luggage.sdk.g.d, x> {
            final /* synthetic */ f mRD;
            final /* synthetic */ c mRE;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(c cVar, f fVar) {
                super(1);
                this.mRE = cVar;
                this.mRD = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.luggage.sdk.g.d dVar) {
                AppMethodBeat.i(50743);
                com.tencent.luggage.sdk.g.d dVar2 = dVar;
                p.h(dVar2, "$receiver");
                dVar2.c(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.appbrand.launching.g.f.b.AnonymousClass1 */
                    final /* synthetic */ b mRF;

                    {
                        this.mRF = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(50742);
                        this.mRF.mRE.interrupt();
                        g gVar = g.mRv;
                        g.mRu.C(this.mRF.mRD.kAi);
                        Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "task(" + this.mRF.mRE.hashCode() + ") interrupted, appId=" + this.mRF.mRD.kAi.getAppId());
                        x xVar = x.SXb;
                        AppMethodBeat.o(50742);
                        return xVar;
                    }
                });
                x xVar = x.SXb;
                AppMethodBeat.o(50743);
                return xVar;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ c invoke() {
            AppMethodBeat.i(50744);
            c cVar = new c();
            Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "obtainTask create new instance(" + cVar.hashCode() + ") with appId(" + this.kAi.getAppId() + ')');
            cVar.w(new a(this));
            com.tencent.luggage.sdk.g.g gVar = com.tencent.luggage.sdk.g.g.cCM;
            com.tencent.luggage.sdk.g.g.a(this.kAi, new b(cVar, this));
            AppMethodBeat.o(50744);
            return cVar;
        }
    }

    static {
        e eVar;
        AppMethodBeat.i(50746);
        if (Build.VERSION.SDK_INT >= 24) {
            eVar = new d();
        } else {
            eVar = new e();
        }
        mRu = eVar;
        AppMethodBeat.o(50746);
    }

    private g() {
    }

    public static final b a(q qVar, kotlin.g.a.b<? super ICommLibReader, x> bVar) {
        AppMethodBeat.i(228617);
        p.h(qVar, "runtime");
        p.h(bVar, "function");
        if (qVar.bqZ() != null) {
            ICommLibReader bqZ = qVar.bqZ();
            p.g(bqZ, "runtime.libReader");
            bVar.invoke(bqZ);
            AppMethodBeat.o(228617);
            return null;
        }
        mRu.a(qVar, new f(qVar));
        c B = mRu.B(qVar);
        B.w(bVar);
        c cVar = B;
        AppMethodBeat.o(228617);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0002J\u001e\u0010\u0011\u001a\u00020\t2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$IWaitForCommLibTask;", "()V", "callbackContendGuard", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "", "Lcom/tencent/mm/plugin/appbrand/launching/NotifyInvoke;", "interrupted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadedLibReader", "taskStarted", "interrupt", "startTask", "waitFor", "function", "plugin-appbrand-integration_release"})
    public static final class c implements b {
        final ReentrantReadWriteLock mRA = new ReentrantReadWriteLock();
        volatile ICommLibReader mRw;
        final AtomicBoolean mRx = new AtomicBoolean(false);
        private final AtomicBoolean mRy = new AtomicBoolean(false);
        final ConcurrentLinkedDeque<kotlin.g.a.b<ICommLibReader, x>> mRz = new ConcurrentLinkedDeque<>();

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "invoke"})
        public static final class b extends kotlin.g.b.q implements kotlin.g.a.b<ICommLibReader, x> {
            final /* synthetic */ c mRB;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(c cVar) {
                super(1);
                this.mRB = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
                java.lang.StackOverflowError
                	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
                	at jadx.core.dex.instructions.InvokeNode.isSame(InvokeNode.java:77)
                	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
                	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
                	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
                	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
                */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader r8) {
                /*
                // Method dump skipped, instructions count: 134
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.g.c.b.invoke(java.lang.Object):java.lang.Object");
            }
        }

        public c() {
            AppMethodBeat.i(50731);
            AppMethodBeat.o(50731);
        }

        private final void bbZ() {
            AppMethodBeat.i(50729);
            Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "startTask instance(" + hashCode() + ") callbacks.size=" + this.mRz.size());
            b bVar = new b(this);
            ICommLibReader bvV = WxaCommLibRuntimeReader.bvV();
            if (bvV != null) {
                Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "task(" + hashCode() + ") getLoadedReader != NULL");
                bVar.invoke(bvV);
                AppMethodBeat.o(50729);
                return;
            }
            com.tencent.mm.ac.d.i(new a(this, bVar, Util.currentTicks()));
            AppMethodBeat.o(50729);
        }

        public final void w(kotlin.g.a.b<? super ICommLibReader, x> bVar) {
            kotlin.g.a.b<? super ICommLibReader, x> bVar2;
            AppMethodBeat.i(50730);
            p.h(bVar, "function");
            if (this.mRx.get()) {
                if (!(bVar instanceof d.a)) {
                    bVar2 = null;
                } else {
                    bVar2 = bVar;
                }
                d.a aVar = (d.a) bVar2;
                if (aVar != null) {
                    aVar.cn(null);
                    AppMethodBeat.o(50730);
                    return;
                }
                AppMethodBeat.o(50730);
            } else if (!this.mRy.getAndSet(true)) {
                this.mRz.addLast(bVar);
                bbZ();
                AppMethodBeat.o(50730);
            } else {
                ReentrantReadWriteLock.ReadLock readLock = this.mRA.readLock();
                readLock.lock();
                try {
                    if (this.mRw != null) {
                        ICommLibReader iCommLibReader = this.mRw;
                        if (iCommLibReader == null) {
                            p.hyc();
                        }
                        bVar.invoke(iCommLibReader);
                    } else {
                        this.mRz.addLast(bVar);
                    }
                    x xVar = x.SXb;
                } finally {
                    readLock.unlock();
                    AppMethodBeat.o(50730);
                }
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.g.b
        public final void interrupt() {
            AppMethodBeat.i(228616);
            this.mRx.set(true);
            while (!this.mRz.isEmpty()) {
                kotlin.g.a.b<ICommLibReader, x> poll = this.mRz.poll();
                if (!(poll instanceof d.a)) {
                    poll = null;
                }
                d.a aVar = (d.a) poll;
                if (aVar != null) {
                    aVar.cn(null);
                }
            }
            AppMethodBeat.o(228616);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ kotlin.g.a.b gWe;
            final /* synthetic */ long iiX;
            final /* synthetic */ c mRB;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, kotlin.g.a.b bVar, long j2) {
                super(0);
                this.mRB = cVar;
                this.gWe = bVar;
                this.iiX = j2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(50727);
                WxaCommLibRuntimeReader.bvU();
                this.gWe.invoke(WxaCommLibRuntimeReader.bvW());
                Log.i("MicroMsg.AppBrandRuntimeLaunchConditionForCommLib", "task(" + this.mRB.hashCode() + ") WxaCommLibRuntimeReader.loadOrFallback cost[" + (Util.currentTicks() - this.iiX) + ']');
                x xVar = x.SXb;
                AppMethodBeat.o(50727);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005H\u0016R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApiBase;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "Lkotlin/collections/HashMap;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
    static final class e implements a {
        private final HashMap<q, c> map = new HashMap<>();

        public e() {
            AppMethodBeat.i(50740);
            AppMethodBeat.o(50740);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.g.a
        public final void a(q qVar, kotlin.g.a.a<c> aVar) {
            AppMethodBeat.i(50737);
            p.h(qVar, "key");
            p.h(aVar, "function");
            synchronized (this.map) {
                try {
                    if (this.map.get(qVar) == null) {
                        this.map.put(qVar, aVar.invoke());
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(50737);
                }
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.g.a
        public final c B(q qVar) {
            c cVar;
            AppMethodBeat.i(50738);
            p.h(qVar, "key");
            synchronized (this.map) {
                try {
                    c cVar2 = this.map.get(qVar);
                    if (cVar2 == null) {
                        p.hyc();
                    }
                    cVar = cVar2;
                } catch (Throwable th) {
                    AppMethodBeat.o(50738);
                    throw th;
                }
            }
            p.g(cVar, "synchronized(map) { map[key]!! }");
            AppMethodBeat.o(50738);
            return cVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.g.a
        public final c C(q qVar) {
            c remove;
            AppMethodBeat.i(50739);
            p.h(qVar, "key");
            synchronized (this.map) {
                try {
                    remove = this.map.remove(qVar);
                } finally {
                    AppMethodBeat.o(50739);
                }
            }
            return remove;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$TaskMapApi24;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$ITaskMap;", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", "get", "key", "putIfAbsent", "", "function", "Lkotlin/Function0;", "remove", "plugin-appbrand-integration_release"})
    static final class d implements a {
        private final ConcurrentHashMap<q, c> cCB = new ConcurrentHashMap<>();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimeLaunchConditionForCommLib$Task;", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "apply"})
        static final class a<T, R> implements Function<q, c> {
            final /* synthetic */ kotlin.g.a.a mRC;

            a(kotlin.g.a.a aVar) {
                this.mRC = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // java.util.function.Function
            public final /* synthetic */ c apply(q qVar) {
                AppMethodBeat.i(50732);
                p.h(qVar, LocaleUtil.ITALIAN);
                c cVar = (c) this.mRC.invoke();
                AppMethodBeat.o(50732);
                return cVar;
            }
        }

        public d() {
            AppMethodBeat.i(50736);
            AppMethodBeat.o(50736);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.g.a
        public final void a(q qVar, kotlin.g.a.a<c> aVar) {
            AppMethodBeat.i(50733);
            p.h(qVar, "key");
            p.h(aVar, "function");
            this.cCB.computeIfAbsent(qVar, new a(aVar));
            AppMethodBeat.o(50733);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.g.a
        public final c B(q qVar) {
            AppMethodBeat.i(50734);
            p.h(qVar, "key");
            c cVar = this.cCB.get(qVar);
            if (cVar == null) {
                p.hyc();
            }
            p.g(cVar, "map[key]!!");
            c cVar2 = cVar;
            AppMethodBeat.o(50734);
            return cVar2;
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.g.a
        public final c C(q qVar) {
            AppMethodBeat.i(50735);
            p.h(qVar, "key");
            c remove = this.cCB.remove(qVar);
            AppMethodBeat.o(50735);
            return remove;
        }
    }
}
