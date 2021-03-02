package com.tencent.mm.plugin.finder.live.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b*\u0003\n\r\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0013J\u001a\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001d\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001f\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u0006\u0010 \u001a\u00020\u0015J\u0006\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer;", "", "()V", "TAG", "", "acceptMicTimeoutTaskMap", "Ljava/util/HashMap;", "Ljava/lang/Runnable;", "Lkotlin/collections/HashMap;", "acceptPkMicTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptPkMicTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptPkMicTimeoutTask$1;", "applyMicTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyMicTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyMicTimeoutTask$1;", "applyPkMicTimeoutTask", "com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyPkMicTimeoutTask$1", "Lcom/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyPkMicTimeoutTask$1;", "timerImplInstance", "Lcom/tencent/mm/plugin/finder/live/model/mic/ILinkMicTimeoutTimer;", "release", "", "setupTimer", "timer", "startAcceptMicTimer", "micId", "delay", "", "startAcceptPkMicTimer", "startApplyMicPkTimer", "startApplyMicTimer", "stopAcceptMicTimer", "stopAcceptPkMicTimer", "stopApplyMicPkTimer", "stopApplyMicTimer", "plugin-finder_release"})
public final class b {
    private static final String TAG = TAG;
    private static final RunnableC1181b ULa = new RunnableC1181b();
    private static final HashMap<String, Runnable> ULb = new HashMap<>();
    private static final c ULc = new c();
    private static final a ULd = new a();
    private static a ULe;
    public static final b ULf = new b();

    static {
        AppMethodBeat.i(260539);
        AppMethodBeat.o(260539);
    }

    private b() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyMicTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.live.model.a.b$b  reason: collision with other inner class name */
    public static final class RunnableC1181b implements Runnable {
        RunnableC1181b() {
        }

        public final void run() {
            AppMethodBeat.i(260527);
            b bVar = b.ULf;
            a aVar = b.ULe;
            if (aVar != null) {
                aVar.onApplyMicTimeout();
                AppMethodBeat.o(260527);
                return;
            }
            AppMethodBeat.o(260527);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyPkMicTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
    public static final class c implements Runnable {
        c() {
        }

        public final void run() {
            AppMethodBeat.i(260528);
            b bVar = b.ULf;
            a aVar = b.ULe;
            if (aVar != null) {
                aVar.onApplyMicPkTimeout();
                AppMethodBeat.o(260528);
                return;
            }
            AppMethodBeat.o(260528);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$acceptPkMicTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
    public static final class a implements Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(260526);
            b bVar = b.ULf;
            a aVar = b.ULe;
            if (aVar != null) {
                aVar.onAcceptMicPkTimeout();
                AppMethodBeat.o(260526);
                return;
            }
            AppMethodBeat.o(260526);
        }
    }

    public static void a(a aVar) {
        AppMethodBeat.i(260530);
        p.h(aVar, "timer");
        ULe = aVar;
        AppMethodBeat.o(260530);
    }

    public static void release() {
        ULe = null;
    }

    public static void hTm() {
        AppMethodBeat.i(260531);
        Log.i(TAG, "startApplyMicTimer delay:60000");
        MMHandlerThread.postToMainThreadDelayed(ULa, Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(260531);
    }

    public static void hTn() {
        AppMethodBeat.i(260532);
        Log.i(TAG, "startApplyMicPkTimer delay:60000");
        MMHandlerThread.postToMainThreadDelayed(ULc, Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(260532);
    }

    public static void bxE(String str) {
        AppMethodBeat.i(260533);
        Log.i(TAG, "startAcceptMicTimer micId:" + str + " delay:10000");
        if (str != null) {
            d dVar = new d();
            dVar.hFz = str;
            ULb.put(str, dVar);
            MMHandlerThread.postToMainThreadDelayed(dVar, 10000);
            AppMethodBeat.o(260533);
            return;
        }
        AppMethodBeat.o(260533);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$startAcceptMicTimer$1$acceptMicTimeoutTask$1", "Ljava/lang/Runnable;", "micId", "", "getMicId", "()Ljava/lang/String;", "setMicId", "(Ljava/lang/String;)V", "run", "", "plugin-finder_release"})
    public static final class d implements Runnable {
        String hFz;

        d() {
        }

        public final void run() {
            AppMethodBeat.i(260529);
            b bVar = b.ULf;
            a aVar = b.ULe;
            if (aVar != null) {
                aVar.onAcceptMicTimeout(this.hFz);
                AppMethodBeat.o(260529);
                return;
            }
            AppMethodBeat.o(260529);
        }
    }

    public static void hTo() {
        AppMethodBeat.i(260534);
        Log.i(TAG, "startAcceptPkMicTimer delay:15000");
        MMHandlerThread.postToMainThreadDelayed(ULd, 15000);
        AppMethodBeat.o(260534);
    }

    public static void hTp() {
        AppMethodBeat.i(260535);
        Log.i(TAG, "stopApplyMicTimer");
        MMHandlerThread.removeRunnable(ULa);
        AppMethodBeat.o(260535);
    }

    public static void hTq() {
        AppMethodBeat.i(260536);
        Log.i(TAG, "stopApplyMicPkTimer");
        MMHandlerThread.removeRunnable(ULc);
        AppMethodBeat.o(260536);
    }

    public static void bxF(String str) {
        AppMethodBeat.i(260537);
        Log.i(TAG, "stopAcceptMicTimer micId:".concat(String.valueOf(str)));
        if (str != null) {
            MMHandlerThread.removeRunnable(ULb.get(str));
        }
        AppMethodBeat.o(260537);
    }

    public static void hTr() {
        AppMethodBeat.i(260538);
        Log.i(TAG, "stopAcceptPkMicTimer");
        MMHandlerThread.removeRunnable(ULd);
        AppMethodBeat.o(260538);
    }
}
