package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.co;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"})
public final class y {
    private static final u TWj = new u("ZERO");
    private static final m<Object, f.b, Object> TWk = a.TWo;
    private static final m<co<?>, f.b, co<?>> TWl = b.TWp;
    private static final m<ab, f.b, ab> TWm = d.TWr;
    private static final m<ab, f.b, ab> TWn = c.TWq;

    static {
        AppMethodBeat.i(118075);
        AppMethodBeat.o(118075);
    }

    public static final Object d(f fVar) {
        AppMethodBeat.i(118072);
        Object fold = fVar.fold(0, TWk);
        if (fold == null) {
            p.hyc();
        }
        AppMethodBeat.o(118072);
        return fold;
    }

    public static final Object a(f fVar, Object obj) {
        Object obj2;
        AppMethodBeat.i(118073);
        if (obj == null) {
            obj2 = d(fVar);
        } else {
            obj2 = obj;
        }
        if (obj2 == 0) {
            u uVar = TWj;
            AppMethodBeat.o(118073);
            return uVar;
        } else if (obj2 instanceof Integer) {
            Object fold = fVar.fold(new ab(fVar, ((Number) obj2).intValue()), TWm);
            AppMethodBeat.o(118073);
            return fold;
        } else if (obj2 == null) {
            t tVar = new t("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            AppMethodBeat.o(118073);
            throw tVar;
        } else {
            Object b2 = ((co) obj2).b(fVar);
            AppMethodBeat.o(118073);
            return b2;
        }
    }

    public static final void b(f fVar, Object obj) {
        AppMethodBeat.i(118074);
        if (obj == TWj) {
            AppMethodBeat.o(118074);
        } else if (obj instanceof ab) {
            ((ab) obj).f2994i = 0;
            fVar.fold(obj, TWn);
            AppMethodBeat.o(118074);
        } else {
            Object fold = fVar.fold(null, TWl);
            if (fold == null) {
                t tVar = new t("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
                AppMethodBeat.o(118074);
                throw tVar;
            }
            ((co) fold).fR(obj);
            AppMethodBeat.o(118074);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<no name provided>", "", "countOrElement", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    static final class a extends q implements m<Object, f.b, Object> {
        public static final a TWo = new a();

        static {
            AppMethodBeat.i(118112);
            AppMethodBeat.o(118112);
        }

        a() {
            super(2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ Object invoke(Object obj, f.b bVar) {
            Object obj2;
            AppMethodBeat.i(118111);
            f.b bVar2 = bVar;
            if (bVar2 instanceof co) {
                if (!(obj instanceof Integer)) {
                    obj2 = null;
                } else {
                    obj2 = obj;
                }
                Integer num = (Integer) obj2;
                int intValue = num != null ? num.intValue() : 1;
                if (intValue == 0) {
                    AppMethodBeat.o(118111);
                    return bVar2;
                }
                Integer valueOf = Integer.valueOf(intValue + 1);
                AppMethodBeat.o(118111);
                return valueOf;
            }
            AppMethodBeat.o(118111);
            return obj;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<no name provided>", "Lkotlinx/coroutines/ThreadContextElement;", "found", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    static final class b extends q implements m<co<?>, f.b, co<?>> {
        public static final b TWp = new b();

        static {
            AppMethodBeat.i(118106);
            AppMethodBeat.o(118106);
        }

        b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* bridge */ /* synthetic */ co<?> invoke(co<?> coVar, f.b bVar) {
            AppMethodBeat.i(118105);
            co<?> coVar2 = coVar;
            f.b bVar2 = bVar;
            if (coVar2 != null) {
                AppMethodBeat.o(118105);
                return coVar2;
            }
            co coVar3 = (co) (!(bVar2 instanceof co) ? null : bVar2);
            AppMethodBeat.o(118105);
            return coVar3;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    static final class d extends q implements m<ab, f.b, ab> {
        public static final d TWr = new d();

        static {
            AppMethodBeat.i(118110);
            AppMethodBeat.o(118110);
        }

        d() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ ab invoke(ab abVar, f.b bVar) {
            AppMethodBeat.i(118109);
            ab abVar2 = abVar;
            f.b bVar2 = bVar;
            if (bVar2 instanceof co) {
                Object b2 = ((co) bVar2).b(abVar2.TTt);
                Object[] objArr = abVar2.TWt;
                int i2 = abVar2.f2994i;
                abVar2.f2994i = i2 + 1;
                objArr[i2] = b2;
            }
            AppMethodBeat.o(118109);
            return abVar2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    static final class c extends q implements m<ab, f.b, ab> {
        public static final c TWq = new c();

        static {
            AppMethodBeat.i(118079);
            AppMethodBeat.o(118079);
        }

        c() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ ab invoke(ab abVar, f.b bVar) {
            AppMethodBeat.i(118078);
            ab abVar2 = abVar;
            f.b bVar2 = bVar;
            if (bVar2 instanceof co) {
                Object[] objArr = abVar2.TWt;
                int i2 = abVar2.f2994i;
                abVar2.f2994i = i2 + 1;
                ((co) bVar2).fR(objArr[i2]);
            }
            AppMethodBeat.o(118078);
            return abVar2;
        }
    }
}
