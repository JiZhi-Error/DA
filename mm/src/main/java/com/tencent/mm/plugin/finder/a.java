package com.tencent.mm.plugin.finder;

import com.tencent.f.b;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.bk;
import kotlinx.coroutines.bm;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"FinderAsyncDefaultExecutor", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "getFinderAsyncDefaultExecutor", "()Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "FinderCoroutineDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getFinderCoroutineDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "coreSize", "", "getCoreSize", "()I", "plugin-finder_release"})
public final class a {
    private static final int tnJ = Runtime.getRuntime().availableProcessors();
    private static final bk tnK;
    private static final b tnL;

    static {
        AppMethodBeat.i(241825);
        i iVar = h.RTc;
        int i2 = tnJ;
        b a2 = iVar.a("FinderCoroutineDispatcher", i2, i2, new LinkedBlockingQueue());
        p.g(a2, "ThreadPool.INSTANCE.fork…  LinkedBlockingQueue()\n)");
        tnK = new bm(a2);
        i iVar2 = h.RTc;
        int i3 = tnJ;
        tnL = iVar2.a("FinderAsyncExecutor", i3, i3 * 2, new LinkedBlockingQueue());
        AppMethodBeat.o(241825);
    }

    public static final b cXm() {
        return tnL;
    }
}
