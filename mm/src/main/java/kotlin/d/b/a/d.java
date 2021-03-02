package kotlin.d.b.a;

import kotlin.d.e;
import kotlin.d.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\b\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"})
public abstract class d extends a {
    private final f _context;
    private transient kotlin.d.d<Object> intercepted;

    public d(kotlin.d.d<Object> dVar, f fVar) {
        super(dVar);
        this._context = fVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(kotlin.d.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }

    @Override // kotlin.d.d
    public f getContext() {
        f fVar = this._context;
        if (fVar == null) {
            p.hyc();
        }
        return fVar;
    }

    public final kotlin.d.d<Object> intercepted() {
        d dVar = this.intercepted;
        if (dVar == null) {
            e eVar = (e) getContext().get(e.SXH);
            dVar = eVar != null ? eVar.c(this) : this;
            this.intercepted = dVar;
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.d.b.a.a
    public void releaseIntercepted() {
        kotlin.d.d<?> dVar = this.intercepted;
        if (!(dVar == null || dVar == this)) {
            f.b bVar = getContext().get(e.SXH);
            if (bVar == null) {
                p.hyc();
            }
            ((e) bVar).d(dVar);
        }
        this.intercepted = c.SXW;
    }
}
