package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\r\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010JH\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0001\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00152\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, hxF = {"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"})
public class as<T> extends a<T> implements ar<T> {

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, hxF = {"await", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"})
    @f(c = "kotlinx.coroutines.DeferredCoroutine", f = "Builders.common.kt", hxM = {99}, m = "await$suspendImpl")
    public static final class a extends d {
        Object L$0;
        final /* synthetic */ as TUi;
        int label;
        /* synthetic */ Object result;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(as asVar, kotlin.d.d dVar) {
            super(dVar);
            this.TUi = asVar;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(118042);
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object a2 = as.a(this.TUi, this);
            AppMethodBeat.o(118042);
            return a2;
        }
    }

    @Override // kotlinx.coroutines.ar
    public final Object g(kotlin.d.d<? super T> dVar) {
        AppMethodBeat.i(118059);
        Object a2 = a(this, dVar);
        AppMethodBeat.o(118059);
        return a2;
    }

    public as(kotlin.d.f fVar, boolean z) {
        super(fVar, z);
        AppMethodBeat.i(118061);
        AppMethodBeat.o(118061);
    }

    @Override // kotlinx.coroutines.ar
    public final T hMS() {
        AppMethodBeat.i(192516);
        Object hNm = hNm();
        if (!(!(hNm instanceof bp))) {
            IllegalStateException illegalStateException = new IllegalStateException("This job has not completed yet".toString());
            AppMethodBeat.o(192516);
            throw illegalStateException;
        } else if (hNm instanceof v) {
            Throwable th = ((v) hNm).cause;
            AppMethodBeat.o(192516);
            throw th;
        } else {
            T t = (T) cb.gd(hNm);
            AppMethodBeat.o(192516);
            return t;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object a(kotlinx.coroutines.as r8, kotlin.d.d r9) {
        /*
        // Method dump skipped, instructions count: 186
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.as.a(kotlinx.coroutines.as, kotlin.d.d):java.lang.Object");
    }
}
