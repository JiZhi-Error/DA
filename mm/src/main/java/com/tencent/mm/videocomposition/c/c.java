package com.tencent.mm.videocomposition.c;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 15}, hxE = {"\u0000:\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u001a9\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r0\u0011¨\u0006\u0015"}, hxF = {"currentTicks", "", "stackTraceToString", "", "throwable", "", "ticksToNow", "before", "uiThread", "", "block", "Lkotlin/Function0;", "wxRemoveIf", "", "T", "Ljava/util/LinkedList;", "func", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "video_composition_release"})
public final class c {
    public static final void h(a<x> aVar) {
        AppMethodBeat.i(216871);
        p.h(aVar, "block");
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (p.j(currentThread, mainLooper.getThread())) {
            aVar.invoke();
            AppMethodBeat.o(216871);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new d(aVar));
        AppMethodBeat.o(216871);
    }
}
