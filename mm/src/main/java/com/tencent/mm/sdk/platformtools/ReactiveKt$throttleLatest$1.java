package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.au;
import kotlinx.coroutines.f;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "T", "param", "invoke", "(Ljava/lang/Object;)V"})
public final class ReactiveKt$throttleLatest$1 extends q implements b<T, x> {
    final /* synthetic */ ai $coroutineScope;
    final /* synthetic */ b $destinationFunction;
    final /* synthetic */ long $intervalMs;
    final /* synthetic */ z.f $latestParam;
    final /* synthetic */ z.f $throttleJob;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReactiveKt$throttleLatest$1(z.f fVar, z.f fVar2, ai aiVar, long j2, b bVar) {
        super(1);
        this.$latestParam = fVar;
        this.$throttleJob = fVar2;
        this.$coroutineScope = aiVar;
        this.$intervalMs = j2;
        this.$destinationFunction = bVar;
    }

    @Override // kotlin.g.a.b
    public final void invoke(T t) {
        AppMethodBeat.i(215513);
        this.$latestParam.SYG = t;
        T t2 = this.$throttleJob.SYG;
        if (t2 == null || t2.isCompleted()) {
            this.$throttleJob.SYG = (T) f.b(this.$coroutineScope, (kotlin.d.f) null, new AnonymousClass1(this, null), 3);
        }
        AppMethodBeat.o(215513);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.sdk.platformtools.ReactiveKt$throttleLatest$1$1", f = "Reactive.kt", hxM = {34}, m = "invokeSuspend")
    /* renamed from: com.tencent.mm.sdk.platformtools.ReactiveKt$throttleLatest$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends j implements m<ai, d<? super x>, Object> {
        Object L$0;
        int label;
        private ai p$;
        final /* synthetic */ ReactiveKt$throttleLatest$1 this$0;

        {
            this.this$0 = r2;
        }

        @Override // kotlin.d.b.a.a
        public final d<x> create(Object obj, d<?> dVar) {
            AppMethodBeat.i(215510);
            p.h(dVar, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, dVar);
            r0.p$ = (ai) obj;
            AppMethodBeat.o(215510);
            return r0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, d<? super x> dVar) {
            AppMethodBeat.i(215511);
            Object invokeSuspend = ((AnonymousClass1) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(215511);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(215509);
            a aVar = a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    long j2 = this.this$0.$intervalMs;
                    this.L$0 = aiVar;
                    this.label = 1;
                    if (au.a(j2, this) == aVar) {
                        AppMethodBeat.o(215509);
                        return aVar;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(215509);
                    throw illegalStateException;
            }
            this.this$0.$destinationFunction.invoke(this.this$0.$latestParam.SYG);
            x xVar = x.SXb;
            AppMethodBeat.o(215509);
            return xVar;
        }
    }
}