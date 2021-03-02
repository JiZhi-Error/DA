package kotlin.d;

import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"})
public abstract class a implements f.b {
    private final f.c<?> key;

    public a(f.c<?> cVar) {
        p.h(cVar, "key");
        this.key = cVar;
    }

    @Override // kotlin.d.f
    public <R> R fold(R r, m<? super R, ? super f.b, ? extends R> mVar) {
        p.h(mVar, "operation");
        return (R) f.b.a.a(this, r, mVar);
    }

    @Override // kotlin.d.f.b, kotlin.d.f
    public <E extends f.b> E get(f.c<E> cVar) {
        p.h(cVar, "key");
        return (E) f.b.a.a(this, cVar);
    }

    @Override // kotlin.d.f.b
    public f.c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.d.f
    public f minusKey(f.c<?> cVar) {
        p.h(cVar, "key");
        return f.b.a.b(this, cVar);
    }

    @Override // kotlin.d.f
    public f plus(f fVar) {
        p.h(fVar, "context");
        return f.b.a.a(this, fVar);
    }
}
