package com.tencent.mm.loader.g;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 0*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u00010B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J#\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0002\u0010\u0017J-\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J#\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0002\u0010\u0017J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0006\u0010\u001e\u001a\u00020\u0013J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\u0013\u0010)\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020,H\u0002J\u0014\u0010-\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\tJ\u0013\u0010.\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u0014\u0010/\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\tR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00100\bX\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00100\bX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/loader/loader/LoaderCore;", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "configuration", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "(Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;)V", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "getConfiguration", "()Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "heavyWork", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "lightWork", "mPendingQueue", "Lcom/tencent/mm/loader/loader/LoaderPair;", "mRunningQueue", "addTask", "", "t", "(Lcom/tencent/mm/loader/loader/IWorkTask;)V", "callback", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;)V", "atHead", "", "(Lcom/tencent/mm/loader/loader/IWorkTask;Lcom/tencent/mm/loader/loader/LoaderCoreCallback;Z)V", "addTaskAtHead", "callInUI", "callPrepareInUI", "clean", "dispatch", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "execute", "runnable", "Ljava/lang/Runnable;", "executeHeavy", "initHeavyLoader", "initLoader", "isInRunningTask", "(Lcom/tencent/mm/loader/loader/IWorkTask;)Z", "logHead", "", "register", "removeTask", "unregister", "Companion", "libimageloader_release"})
public final class d<T extends c> implements b {
    public static final a ibc = new a((byte) 0);
    private final LinkedList<f<T>> hcR = new LinkedList<>();
    private a iaX;
    private a iaY;
    private final LinkedList<g<c, f<T>>> iaZ = new LinkedList<>();
    public final LinkedList<g<c, f<T>>> iba = new LinkedList<>();
    private final com.tencent.mm.loader.g.a.d ibb;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d ibd;
        final /* synthetic */ c ibe;
        final /* synthetic */ f ibf;
        final /* synthetic */ boolean ibg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, c cVar, f fVar, boolean z) {
            super(0);
            this.ibd = dVar;
            this.ibe = cVar;
            this.ibf = fVar;
            this.ibg = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Object obj;
            Object obj2;
            Iterator it = this.ibd.iaZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (p.j(((g) next).first.auK(), this.ibe.auK())) {
                    obj = next;
                    break;
                }
            }
            g gVar = (g) obj;
            if (gVar != null) {
                gVar.second = (B) this.ibf;
                Log.i("MicroMsg.Loader.DefaultTaskLoader", this.ibd.aJZ() + "this task already in task in mPendingQueue %s %s", this.ibe, this.ibe.auK());
            } else {
                Iterator it2 = this.ibd.iba.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    Object next2 = it2.next();
                    if (p.j(((g) next2).first.auK(), this.ibe.auK())) {
                        obj2 = next2;
                        break;
                    }
                }
                g gVar2 = (g) obj2;
                if (gVar2 != null) {
                    gVar2.second = (B) this.ibf;
                    Log.i("MicroMsg.Loader.DefaultTaskLoader", this.ibd.aJZ() + "this task already in task in mRunningQueue %s %s", this.ibe, this.ibe.auK());
                } else if (this.ibg) {
                    this.ibd.iaZ.addFirst(new g(this.ibe, this.ibf));
                } else {
                    this.ibd.iaZ.add(new g(this.ibe, this.ibf));
                }
            }
            this.ibd.aKb();
            return x.SXb;
        }
    }

    public d(com.tencent.mm.loader.g.a.d dVar) {
        p.h(dVar, "configuration");
        this.ibb = dVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final String aJZ() {
        return "name:" + this.ibb.name() + "_this:" + hashCode() + '_';
    }

    public final void a(f<T> fVar) {
        p.h(fVar, "callback");
        com.tencent.mm.ac.d.h(new f(this, fVar));
    }

    public final void b(f<T> fVar) {
        p.h(fVar, "callback");
        com.tencent.mm.ac.d.h(new h(this, fVar));
    }

    private final void aKa() {
        if (this.iaX == null) {
            this.iaX = this.ibb.aKd();
        }
    }

    public final void b(T t) {
        p.h(t, "t");
        a((c) t, (f) null, true);
    }

    public final void c(T t) {
        p.h(t, "t");
        a(t, null);
    }

    public final void a(T t, f<T> fVar) {
        p.h(t, "t");
        a((c) t, (f) fVar, false);
    }

    private void a(T t, f<T> fVar, boolean z) {
        p.h(t, "t");
        com.tencent.mm.ac.d.h(new b(this, t, fVar, z));
    }

    public final void d(T t) {
        p.h(t, "t");
        com.tencent.mm.ac.d.h(new g(this, t));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean aKb() {
        if (this.iaZ.size() <= 0) {
            Log.i("MicroMsg.Loader.DefaultTaskLoader", aJZ() + "DefaultTaskLoader mPendingQueue is empty");
            return false;
        } else if (this.iba.size() >= this.ibb.aKf()) {
            return false;
        } else {
            Log.i("MicroMsg.Loader.DefaultTaskLoader", aJZ() + "callPrepare RunningQueue " + this.iba.size() + " max_run_task " + this.ibb.aKf() + " mPendingQueue " + this.iaZ.size());
            g<c, f<T>> remove = this.iaZ.remove(0);
            p.g(remove, "mPendingQueue.removeAt(0)");
            g<c, f<T>> gVar = remove;
            this.iba.add(gVar);
            Log.i("MicroMsg.Loader.DefaultTaskLoader", "add task,mediaId:" + gVar.first.auK());
            if (!this.ibb.aKg().a(gVar.first)) {
                Log.w("MicroMsg.Loader.DefaultTaskLoader", aJZ() + " block retryStrategy " + gVar + ".first");
                B b2 = gVar.second;
                if (b2 != null) {
                    A a2 = gVar.first;
                    if (a2 == null) {
                        throw new t("null cannot be cast to non-null type T");
                    }
                    b2.a(a2, j.Block);
                }
                return true;
            }
            execute(new k(gVar.first, this, new c(this, gVar)));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "work", "kotlin.jvm.PlatformType", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "onTaskStatusCallback"})
    public static final class c implements k.a {
        final /* synthetic */ d ibd;
        final /* synthetic */ g ibh;

        c(d dVar, g gVar) {
            this.ibd = dVar;
            this.ibh = gVar;
        }

        @Override // com.tencent.mm.loader.g.k.a
        public final void b(final c cVar, final j jVar) {
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.loader.g.d.c.AnonymousClass1 */
                final /* synthetic */ c ibi;

                {
                    this.ibi = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Multi-variable search result rejected for r0v27, resolved type: B */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    Object obj;
                    Log.i("MicroMsg.Loader.DefaultTaskLoader", this.ibi.ibd.aJZ() + "workStatus change work " + cVar + " getStatus: " + jVar);
                    Log.i("MicroMsg.Loader.DefaultTaskLoader", "task end callback,mediaId:" + this.ibi.ibh.first.auK());
                    Iterator it = this.ibi.ibd.iba.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        Object next = it.next();
                        if (p.j(((g) next).first.auK(), cVar.auK())) {
                            obj = next;
                            break;
                        }
                    }
                    g gVar = (g) obj;
                    if (gVar != null) {
                        this.ibi.ibd.iba.remove(gVar);
                        B b2 = gVar.second;
                        if (b2 != 0) {
                            c cVar = cVar;
                            if (cVar == null) {
                                throw new t("null cannot be cast to non-null type T");
                            }
                            j jVar = jVar;
                            p.g(jVar, "status");
                            b2.a(cVar, jVar);
                        }
                    }
                    d dVar = this.ibi.ibd;
                    c cVar2 = cVar;
                    p.g(cVar2, "work");
                    j jVar2 = jVar;
                    p.g(jVar2, "status");
                    d.a(dVar, cVar2, jVar2);
                    j jVar3 = jVar;
                    if (jVar3 != null) {
                        switch (e.$EnumSwitchMapping$0[jVar3.ordinal()]) {
                            case 1:
                                Log.i("MicroMsg.Loader.DefaultTaskLoader", this.ibi.ibd.aJZ() + "workStat wait");
                                break;
                        }
                        return x.SXb;
                    }
                    this.ibi.ibd.aKb();
                    return x.SXb;
                }
            });
        }
    }

    public final void clean() {
        com.tencent.mm.ac.d.h(new C0405d(this));
    }

    @Override // com.tencent.mm.loader.g.b
    public final void execute(Runnable runnable) {
        p.h(runnable, "runnable");
        aKa();
        a aVar = this.iaX;
        if (aVar != null) {
            aVar.execute(runnable);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/loader/loader/LoaderCore$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d ibd;
        final /* synthetic */ f ibf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(d dVar, f fVar) {
            super(0);
            this.ibd = dVar;
            this.ibf = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            LinkedList linkedList = this.ibd.hcR;
            if (!(linkedList instanceof Collection) || !linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (p.j((f) it.next(), this.ibf)) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                this.ibd.hcR.add(this.ibf);
            }
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d ibd;
        final /* synthetic */ f ibf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(d dVar, f fVar) {
            super(0);
            this.ibd = dVar;
            this.ibf = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            this.ibd.hcR.remove(this.ibf);
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d ibd;
        final /* synthetic */ j ibk;
        final /* synthetic */ c ibl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar, c cVar, j jVar) {
            super(0);
            this.ibd = dVar;
            this.ibl = cVar;
            this.ibk = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.tencent.mm.loader.g.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            for (f fVar : this.ibd.hcR) {
                c cVar = this.ibl;
                if (cVar == null) {
                    throw new t("null cannot be cast to non-null type T");
                }
                fVar.a(cVar, this.ibk);
            }
            return x.SXb;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d ibd;
        final /* synthetic */ c ibe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(d dVar, c cVar) {
            super(0);
            this.ibd = dVar;
            this.ibe = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Object obj;
            Iterator it = this.ibd.iaZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (p.j(((g) next).first.auK(), this.ibe.auK())) {
                    obj = next;
                    break;
                }
            }
            g gVar = (g) obj;
            if (gVar != null) {
                this.ibd.iaZ.remove(gVar);
            }
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "Lcom/tencent/mm/loader/loader/IWorkTask;", "invoke"})
    /* renamed from: com.tencent.mm.loader.g.d$d  reason: collision with other inner class name */
    static final class C0405d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d ibd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0405d(d dVar) {
            super(0);
            this.ibd = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            this.ibd.iaZ.clear();
            this.ibd.iba.clear();
            return x.SXb;
        }
    }

    @Override // com.tencent.mm.loader.g.b
    public final void D(Runnable runnable) {
        p.h(runnable, "runnable");
        if (this.iaY == null) {
            this.iaY = this.ibb.aKe();
        }
        a aVar = this.iaY;
        if (aVar != null) {
            aVar.execute(runnable);
        }
    }

    public static final /* synthetic */ void a(d dVar, c cVar, j jVar) {
        com.tencent.mm.ac.d.h(new e(dVar, cVar, jVar));
    }
}
