package kotlin.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0002¨\u0006\u0013"}, hxF = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", QLog.TAG_REPORTLEVEL_USER, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"})
public interface f {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, hxF = {"Lkotlin/coroutines/CoroutineContext$Key;", QLog.TAG_REPORTLEVEL_USER, "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"})
    public interface c<E extends b> {
    }

    <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar);

    <E extends b> E get(c<E> cVar);

    f minusKey(c<?> cVar);

    f plus(f fVar);

    @l(hxD = {1, 1, 16})
    public static final class a {

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
        /* renamed from: kotlin.d.f$a$a  reason: collision with other inner class name */
        public static final class C2262a extends q implements m<f, b, f> {
            public static final C2262a SXJ = new C2262a();

            static {
                AppMethodBeat.i(129622);
                AppMethodBeat.o(129622);
            }

            C2262a() {
                super(2);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ f invoke(f fVar, b bVar) {
                f cVar;
                AppMethodBeat.i(129621);
                f fVar2 = fVar;
                b bVar2 = bVar;
                p.h(fVar2, "acc");
                p.h(bVar2, "element");
                f minusKey = fVar2.minusKey(bVar2.getKey());
                if (minusKey == g.SXK) {
                    cVar = bVar2;
                } else {
                    e eVar = (e) minusKey.get(e.SXH);
                    if (eVar == null) {
                        cVar = new c(minusKey, bVar2);
                    } else {
                        f minusKey2 = minusKey.minusKey(e.SXH);
                        if (minusKey2 == g.SXK) {
                            cVar = new c(bVar2, eVar);
                        } else {
                            cVar = new c(new c(minusKey2, bVar2), eVar);
                        }
                    }
                }
                f fVar3 = cVar;
                AppMethodBeat.o(129621);
                return fVar3;
            }
        }

        public static f a(f fVar, f fVar2) {
            AppMethodBeat.i(129629);
            p.h(fVar2, "context");
            if (fVar2 == g.SXK) {
                AppMethodBeat.o(129629);
                return fVar;
            }
            f fVar3 = (f) fVar2.fold(fVar, C2262a.SXJ);
            AppMethodBeat.o(129629);
            return fVar3;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, hxF = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", QLog.TAG_REPORTLEVEL_USER, "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"})
    public interface b extends f {
        @Override // kotlin.d.f
        <E extends b> E get(c<E> cVar);

        c<?> getKey();

        @l(hxD = {1, 1, 16})
        public static final class a {
            public static f a(b bVar, f fVar) {
                AppMethodBeat.i(129628);
                p.h(fVar, "context");
                f a2 = a.a(bVar, fVar);
                AppMethodBeat.o(129628);
                return a2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.d.f$b */
            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E a(b bVar, c<E> cVar) {
                AppMethodBeat.i(129625);
                p.h(cVar, "key");
                if (p.j(bVar.getKey(), cVar)) {
                    AppMethodBeat.o(129625);
                    return bVar;
                }
                AppMethodBeat.o(129625);
                return null;
            }

            public static <R> R a(b bVar, R r, m<? super R, ? super b, ? extends R> mVar) {
                AppMethodBeat.i(129626);
                p.h(mVar, "operation");
                R r2 = (R) mVar.invoke(r, bVar);
                AppMethodBeat.o(129626);
                return r2;
            }

            public static f b(b bVar, c<?> cVar) {
                AppMethodBeat.i(129627);
                p.h(cVar, "key");
                if (p.j(bVar.getKey(), cVar)) {
                    g gVar = g.SXK;
                    AppMethodBeat.o(129627);
                    return gVar;
                }
                b bVar2 = bVar;
                AppMethodBeat.o(129627);
                return bVar2;
            }
        }
    }
}
