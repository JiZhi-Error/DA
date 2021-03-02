package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Result;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u000e:\u0002\u000b\fB\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR$\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, hxF = {"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""})
public final class c<T> {
    static final AtomicIntegerFieldUpdater TTw = AtomicIntegerFieldUpdater.newUpdater(c.class, "notCompletedCount");
    private final ar<T>[] TTx;
    volatile int notCompletedCount = this.TTx.length;

    static {
        AppMethodBeat.i(192500);
        AppMethodBeat.o(192500);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.ar<? extends T>[] */
    /* JADX WARN: Multi-variable type inference failed */
    public c(ar<? extends T>[] arVarArr) {
        AppMethodBeat.i(192499);
        this.TTx = arVarArr;
        AppMethodBeat.o(192499);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, hxF = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"})
    public final class b extends i {
        private final c<T>.a[] TTB;

        public b(c<T>.a[] aVarArr) {
            this.TTB = aVarArr;
        }

        public final void hMq() {
            AppMethodBeat.i(192399);
            for (c<T>.a aVar : this.TTB) {
                aVar.hMp().dispose();
            }
            AppMethodBeat.o(192399);
        }

        @Override // kotlinx.coroutines.j
        public final void y(Throwable th) {
            AppMethodBeat.i(192400);
            hMq();
            AppMethodBeat.o(192400);
        }

        public final String toString() {
            AppMethodBeat.i(192402);
            String str = "DisposeHandlersOnCancel[" + this.TTB + ']';
            AppMethodBeat.o(192402);
            return str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Throwable th) {
            AppMethodBeat.i(192401);
            hMq();
            x xVar = x.SXb;
            AppMethodBeat.o(192401);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00040\u001eB#\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR<\u0010\u0015\u001a\u000e\u0018\u00010\u000eR\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0012\u0010\u0010\u001a\u000e\u0018\u00010\u000eR\b\u0012\u0004\u0012\u00028\u00000\u000f8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, hxF = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/Job;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"})
    public final class a extends bz<bu> {
        public bc TTy;
        private final k<List<? extends T>> TTz;
        volatile Object _disposer = null;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.k<? super java.util.List<? extends T>> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(k<? super List<? extends T>> kVar, bu buVar) {
            super(buVar);
            this.TTz = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Throwable th) {
            AppMethodBeat.i(192379);
            y(th);
            x xVar = x.SXb;
            AppMethodBeat.o(192379);
            return xVar;
        }

        public final bc hMp() {
            AppMethodBeat.i(192377);
            bc bcVar = this.TTy;
            if (bcVar == null) {
                p.btv("handle");
            }
            AppMethodBeat.o(192377);
            return bcVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.concurrent.atomic.AtomicIntegerFieldUpdater */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.z
        public final void y(Throwable th) {
            AppMethodBeat.i(192378);
            if (th != null) {
                Object z = this.TTz.z(th);
                if (z != null) {
                    this.TTz.fN(z);
                    b bVar = (b) this._disposer;
                    if (bVar != null) {
                        bVar.hMq();
                        AppMethodBeat.o(192378);
                        return;
                    }
                    AppMethodBeat.o(192378);
                    return;
                }
            } else {
                if (c.TTw.decrementAndGet(c.this) == 0) {
                    k<List<? extends T>> kVar = this.TTz;
                    ar[] arVarArr = c.this.TTx;
                    ArrayList arrayList = new ArrayList(arVarArr.length);
                    for (ar arVar : arVarArr) {
                        arrayList.add(arVar.hMS());
                    }
                    Result.Companion companion = Result.Companion;
                    kVar.resumeWith(Result.m46constructorimpl(arrayList));
                }
            }
            AppMethodBeat.o(192378);
        }
    }
}
