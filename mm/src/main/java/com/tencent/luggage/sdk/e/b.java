package com.tencent.luggage.sdk.e;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.luggage.sdk.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.FutureTask;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u0006J!\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\n\"\u0006\b\u0000\u0010\u0010\u0018\u00012\u0006\u0010\u0011\u001a\u00020\tH\bJ\u0014\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0012\u0010\u0014\u001a\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\nR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R5\u0010\u0007\u001a&\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\bj\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, hxF = {"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "", "()V", "onFinishListeners", "Ljava/util/LinkedList;", "Lkotlin/Function0;", "", "preFetchTasks", "Ljava/util/HashMap;", "", "Lcom/tencent/luggage/sdk/tasks/AppBrandBasePreFetchTask;", "Lkotlin/collections/HashMap;", "getPreFetchTasks", "()Ljava/util/HashMap;", "finishAllTask", "getTask", "T", "key", "onFinish", "l", "startTask", "preFetchLaunchTask", "Companion", "luggage-wechat-full-sdk_release"})
public class b {
    public static final a cCA = new a((byte) 0);
    public final HashMap<Integer, a<?>> cCy = new HashMap<>();
    public final LinkedList<kotlin.g.a.a<x>> cCz = new LinkedList<>();

    static {
        AppMethodBeat.i(230044);
        AppMethodBeat.o(230044);
    }

    public b() {
        AppMethodBeat.i(230043);
        AppMethodBeat.o(230043);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection$Companion;", "", "()V", "TAG", "", "TASK_KEY_PROVIDE_WAWEBVIEW", "", "TASK_KEY_PROVIDE_WXSS", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void b(a<?> aVar) {
        AppMethodBeat.i(230042);
        p.h(aVar, "preFetchLaunchTask");
        this.cCy.put(Integer.valueOf(aVar.OY()), aVar);
        aVar.cCr = new FutureTask<>(new a.b(aVar));
        i iVar = h.RTc;
        FutureTask<T> futureTask = aVar.cCr;
        if (futureTask == null) {
            p.btv("futureTask");
        }
        iVar.aX(futureTask);
        AppMethodBeat.o(230042);
    }
}
