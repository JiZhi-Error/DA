package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a>\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a>\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a>\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\r"}, hxF = {"debounce", "Lkotlin/Function1;", "T", "", "waitMs", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "destinationFunction", "throttleFirst", "skipMs", "throttleLatest", "intervalMs", "libcompatible_release"})
public final class ReactiveKt {
    public static /* synthetic */ b throttleLatest$default(long j2, ai aiVar, b bVar, int i2, Object obj) {
        AppMethodBeat.i(215515);
        if ((i2 & 1) != 0) {
            j2 = 300;
        }
        b throttleLatest = throttleLatest(j2, aiVar, bVar);
        AppMethodBeat.o(215515);
        return throttleLatest;
    }

    public static final <T> b<T, x> throttleLatest(long j2, ai aiVar, b<? super T, x> bVar) {
        AppMethodBeat.i(215514);
        p.h(aiVar, "coroutineScope");
        p.h(bVar, "destinationFunction");
        z.f fVar = new z.f();
        fVar.SYG = null;
        ReactiveKt$throttleLatest$1 reactiveKt$throttleLatest$1 = new ReactiveKt$throttleLatest$1(new z.f(), fVar, aiVar, j2, bVar);
        AppMethodBeat.o(215514);
        return reactiveKt$throttleLatest$1;
    }

    public static /* synthetic */ b debounce$default(long j2, ai aiVar, b bVar, int i2, Object obj) {
        AppMethodBeat.i(215517);
        if ((i2 & 1) != 0) {
            j2 = 300;
        }
        b debounce = debounce(j2, aiVar, bVar);
        AppMethodBeat.o(215517);
        return debounce;
    }

    public static final <T> b<T, x> debounce(long j2, ai aiVar, b<? super T, x> bVar) {
        AppMethodBeat.i(215516);
        p.h(aiVar, "coroutineScope");
        p.h(bVar, "destinationFunction");
        z.f fVar = new z.f();
        fVar.SYG = null;
        ReactiveKt$debounce$1 reactiveKt$debounce$1 = new ReactiveKt$debounce$1(fVar, aiVar, j2, bVar);
        AppMethodBeat.o(215516);
        return reactiveKt$debounce$1;
    }

    public static /* synthetic */ b throttleFirst$default(long j2, ai aiVar, b bVar, int i2, Object obj) {
        AppMethodBeat.i(215519);
        if ((i2 & 1) != 0) {
            j2 = 300;
        }
        b throttleFirst = throttleFirst(j2, aiVar, bVar);
        AppMethodBeat.o(215519);
        return throttleFirst;
    }

    public static final <T> b<T, x> throttleFirst(long j2, ai aiVar, b<? super T, x> bVar) {
        AppMethodBeat.i(215518);
        p.h(aiVar, "coroutineScope");
        p.h(bVar, "destinationFunction");
        z.f fVar = new z.f();
        fVar.SYG = null;
        ReactiveKt$throttleFirst$1 reactiveKt$throttleFirst$1 = new ReactiveKt$throttleFirst$1(fVar, aiVar, bVar, j2);
        AppMethodBeat.o(215518);
        return reactiveKt$throttleFirst$1;
    }
}
