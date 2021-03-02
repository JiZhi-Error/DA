package com.tencent.mm.plugin.finder.preload.tabPreload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u001e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "", "name", "", "(Ljava/lang/String;)V", "TAG", "getName", "()Ljava/lang/String;", "pauseRunnable", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "timer", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "pause", "", "runnable", "postDelayed", "delay", "", "tag", "resume", "", "stop", "TimeRunnable", "plugin-finder_release"})
public final class a {
    final String TAG = ("Finder.ExpiredTimer#" + this.name);
    private final String name;
    final MMHandler uOI;
    AtomicReference<AbstractRunnableC1255a> uUM;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "Ljava/lang/Runnable;", "()V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "time", "getTime", "setTime", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.preload.tabPreload.a$a  reason: collision with other inner class name */
    public static abstract class AbstractRunnableC1255a implements Runnable {
        long gY;
        long time = System.currentTimeMillis();
    }

    public a(String str) {
        p.h(str, "name");
        AppMethodBeat.i(249553);
        this.name = str;
        MMHandler mMHandler = new MMHandler(this.name);
        mMHandler.setLogging(false);
        this.uOI = mMHandler;
        this.uUM = new AtomicReference<>();
        AppMethodBeat.o(249553);
    }

    public final void a(AbstractRunnableC1255a aVar, long j2, String str) {
        AppMethodBeat.i(249551);
        p.h(aVar, "runnable");
        p.h(str, "tag");
        long max = Math.max(0L, j2);
        this.uOI.removeCallbacksAndMessages(null);
        aVar.gY = max;
        aVar.time = System.currentTimeMillis();
        this.uOI.postDelayed(aVar, max);
        Log.i(this.TAG, "[postDelayed] delay=" + aVar.gY + "ms hash=" + aVar.hashCode() + " tag=" + str);
        AppMethodBeat.o(249551);
    }

    public final AbstractRunnableC1255a aut(String str) {
        AppMethodBeat.i(249552);
        p.h(str, "tag");
        this.uUM.set(null);
        this.uOI.removeCallbacksAndMessages(null);
        Log.i(this.TAG, "[stop] tag=" + str + ", null");
        AppMethodBeat.o(249552);
        return null;
    }
}
