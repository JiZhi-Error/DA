package kotlinx.coroutines;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.b;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH&J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\nH\u0017J \u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0011\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0002J\u0014\u0010\u0014\u001a\u00020\u00052\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\rH\u0017J\b\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, hxF = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", FacebookRequestErrorClassification.KEY_OTHER, "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"})
public abstract class ad extends kotlin.d.a implements e {
    public static final a TTQ = new a((byte) 0);

    public abstract void a(f fVar, Runnable runnable);

    @Override // kotlin.d.f.b, kotlin.d.a, kotlin.d.f
    public <E extends f.b> E get(f.c<E> cVar) {
        p.h(cVar, "key");
        if (cVar instanceof b) {
            if (((b) cVar).a(getKey())) {
                E e2 = (E) ((b) cVar).a(this);
                if (e2 instanceof f.b) {
                    return e2;
                }
            }
            return null;
        } else if (e.SXH == cVar) {
            return this;
        } else {
            return null;
        }
    }

    @Override // kotlin.d.a, kotlin.d.f
    public f minusKey(f.c<?> cVar) {
        p.h(cVar, "key");
        return cVar instanceof b ? (!((b) cVar).a(getKey()) || ((b) cVar).a(this) == null) ? this : g.SXK : e.SXH == cVar ? g.SXK : this;
    }

    public ad() {
        super(e.SXH);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"})
    public static final class a extends b<e, ad> {
        private a() {
            super(e.SXH, AnonymousClass1.TTR);
            AppMethodBeat.i(192323);
            AppMethodBeat.o(192323);
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public boolean hMH() {
        return true;
    }

    @Override // kotlin.d.e
    public final <T> d<T> c(d<? super T> dVar) {
        return new av(this, dVar);
    }

    @Override // kotlin.d.e
    public final void d(d<?> dVar) {
        if (dVar == null) {
            throw new t("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<*>");
        }
        Object obj = ((av) dVar)._reusableCancellableContinuation;
        if (!(obj instanceof l)) {
            obj = null;
        }
        l lVar = (l) obj;
        if (lVar != null) {
            lVar.hMx();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
