package kotlin.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ResultKt;
import kotlin.d.b.a.i;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.a.m;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\b¢\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, hxF = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, hxG = 1)
public class c {
    public static final <R, T> d<x> a(m<? super R, ? super d<? super T>, ? extends Object> mVar, R r, d<? super T> dVar) {
        AppMethodBeat.i(129593);
        p.h(mVar, "$this$createCoroutineUnintercepted");
        p.h(dVar, "completion");
        p.h(dVar, "completion");
        if (mVar instanceof kotlin.d.b.a.a) {
            d<x> create = ((kotlin.d.b.a.a) mVar).create(r, dVar);
            AppMethodBeat.o(129593);
            return create;
        }
        f context = dVar.getContext();
        if (context == g.SXK) {
            if (dVar == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                AppMethodBeat.o(129593);
                throw tVar;
            }
            a aVar = new a(dVar, dVar, mVar, r);
            AppMethodBeat.o(129593);
            return aVar;
        } else if (dVar == null) {
            t tVar2 = new t("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            AppMethodBeat.o(129593);
            throw tVar2;
        } else {
            b bVar = new b(dVar, context, dVar, context, mVar, r);
            AppMethodBeat.o(129593);
            return bVar;
        }
    }

    public static final <T> d<T> e(d<? super T> dVar) {
        d<Object> intercepted;
        AppMethodBeat.i(129594);
        p.h(dVar, "$this$intercepted");
        kotlin.d.b.a.d dVar2 = (kotlin.d.b.a.d) (!(dVar instanceof kotlin.d.b.a.d) ? null : dVar);
        if (!(dVar2 == null || (intercepted = dVar2.intercepted()) == null)) {
            dVar = (d<T>) intercepted;
        }
        AppMethodBeat.o(129594);
        return (d<T>) dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class a extends i {
        final /* synthetic */ d SXS;
        final /* synthetic */ m SXT;
        final /* synthetic */ Object SXU;
        private int label;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, d dVar2, m mVar, Object obj) {
            super(dVar2);
            this.SXS = dVar;
            this.SXT = mVar;
            this.SXU = obj;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(129592);
            switch (this.label) {
                case 0:
                    this.label = 1;
                    ResultKt.throwOnFailure(obj);
                    a aVar = this;
                    m mVar = this.SXT;
                    if (mVar == null) {
                        t tVar = new t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        AppMethodBeat.o(129592);
                        throw tVar;
                    }
                    Object invoke = ((m) af.r(mVar, 2)).invoke(this.SXU, aVar);
                    AppMethodBeat.o(129592);
                    return invoke;
                case 1:
                    this.label = 2;
                    ResultKt.throwOnFailure(obj);
                    AppMethodBeat.o(129592);
                    return obj;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("This coroutine had already completed".toString());
                    AppMethodBeat.o(129592);
                    throw illegalStateException;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0014ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t¸\u0006\u0000"}, hxF = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class b extends kotlin.d.b.a.d {
        final /* synthetic */ d SXS;
        final /* synthetic */ m SXT;
        final /* synthetic */ Object SXU;
        final /* synthetic */ f SXV;
        private int label;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar, f fVar, d dVar2, f fVar2, m mVar, Object obj) {
            super(dVar2, fVar2);
            this.SXS = dVar;
            this.SXV = fVar;
            this.SXT = mVar;
            this.SXU = obj;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(129598);
            switch (this.label) {
                case 0:
                    this.label = 1;
                    ResultKt.throwOnFailure(obj);
                    b bVar = this;
                    m mVar = this.SXT;
                    if (mVar == null) {
                        t tVar = new t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        AppMethodBeat.o(129598);
                        throw tVar;
                    }
                    Object invoke = ((m) af.r(mVar, 2)).invoke(this.SXU, bVar);
                    AppMethodBeat.o(129598);
                    return invoke;
                case 1:
                    this.label = 2;
                    ResultKt.throwOnFailure(obj);
                    AppMethodBeat.o(129598);
                    return obj;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("This coroutine had already completed".toString());
                    AppMethodBeat.o(129598);
                    throw illegalStateException;
            }
        }
    }
}
