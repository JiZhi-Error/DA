package com.tencent.mm.plugin.performance.c;

import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Printer;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.f.d;
import com.tencent.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.app.p;
import com.tencent.mm.booter.aa;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.performance.watchdogs.ThreadWatchDog;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.g.b.q;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000­\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0005\u0016\u0019&25\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0005OPQRSB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020?H\u0002J\b\u0010A\u001a\u00020?H\u0002J\u0012\u0010B\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010E\u001a\u00020?2\b\u0010F\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010G\u001a\u00020?2\b\u0010F\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010H\u001a\u00020?2\u0006\u0010I\u001a\u00020\u0012H\u0016J\u0012\u0010J\u001a\u00020?2\b\u0010K\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010L\u001a\u00020?2\u0006\u0010M\u001a\u00020\u0012J\b\u0010N\u001a\u00020?H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000RN\u0010\u001c\u001aB\u0012\u0004\u0012\u00020\t\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001f0\u001e0\u001dj \u0012\u0004\u0012\u00020\t\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001f0\u001e` X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0004¢\u0006\u0004\n\u0002\u0010'R6\u0010(\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001f0)j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001f`*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0004¢\u0006\u0004\n\u0002\u00103R\u0010\u00104\u001a\u000205X\u0004¢\u0006\u0004\n\u0002\u00106R\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002080\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler;", "Lcom/tencent/mm/app/IAppForegroundListener;", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver$IOnScreenshotTakenListener;", "Lcom/tencent/mm/app/IPhoneScreenListener;", "()V", "aboutUITimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "batteryRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "blowoutCount", "", "checkQueue", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "existThreadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "isNeedReport", "", "lastCheckTime", "", "looperPrepareMonitor", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1;", "mainLooperListener", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1;", "maxBlowoutCount", "methodInfoMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "Lkotlin/collections/HashMap;", "otherTaskCount", "Ljava/util/concurrent/atomic/AtomicLong;", "otherThreadTime", "otherTime", "runCallback", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1;", "runnableMethodInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "runningCount", "screenShotObserver", "Lcom/tencent/mm/pluginsdk/model/ScreenshotObserver;", "screenShotObserver2", "screenShotPath", "screenShotPath2", "taskPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1;", "threadPrinter", "com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1;", "timeRecord", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "uiBusyConcurrent", "", "uiTaskCount", "uiThreadTime", "uiTime", "checkExpiredTask", "", "dumpThreadPool", "dumpUIAbout", "getStackTrace", "thread", "Ljava/lang/Thread;", "onAppBackground", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "onAppForeground", "onScreen", "isScreenOff", "onScreenshotTaken", "path", WeChatBrands.Business.GROUP_OPEN, "isProcessMain", "reportStatistics", "BatteryRecord", "CheckInfo", "Companion", "ReportType", "TimeRecord", "plugin-performance_release"})
public final class a implements o, p, v.a {
    private static final kotlin.f AVu = kotlin.g.ah(d.AVx);
    public static final c AVv = new c((byte) 0);
    public static boolean cWq;
    private final AtomicInteger AUU = new AtomicInteger();
    private final AtomicInteger AUV = new AtomicInteger();
    private final ConcurrentHashMap<String, b> AUW = new ConcurrentHashMap<>();
    private final boolean AUX;
    private final ConcurrentHashMap<String, C1571a> AUY;
    private final ConcurrentHashMap<String, f> AUZ;
    private volatile int AVa;
    private int AVb;
    private AtomicLong AVc;
    private AtomicLong AVd;
    private AtomicLong AVe;
    private AtomicLong AVf;
    private AtomicLong AVg;
    private AtomicLong AVh;
    private int[] AVi;
    public final n AVj;
    public final i AVk;
    public final m AVl;
    private final ArrayList<Pair<String, String>> AVm;
    private final String AVn;
    private final String AVo;
    private final v AVp;
    private final v AVq;
    private final j AVr;
    public final MTimerHandler AVs;
    private final l AVt;
    private long lastCheckTime;
    private final HashMap<String, List<Pair<String, String>>> sAe;

    public a() {
        int i2;
        AppMethodBeat.i(184683);
        if (com.tencent.mm.protocal.d.KyP || com.tencent.mm.protocal.d.KyQ) {
            i2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_threadpool_profiler_report_release, 10);
        } else {
            i2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_threadpool_profiler_report_alpha, 100000);
        }
        int nextInt = new Random().nextInt(100000);
        boolean z = i2 >= nextInt;
        Log.i("ThreadPool.Profiler", "[isNeedReport] rand=" + i2 + " test=" + nextInt + " isEnable=" + z + " isRelease=" + com.tencent.mm.protocal.d.KyP + " isTest=" + com.tencent.mm.protocal.d.KyQ);
        this.AUX = z;
        this.AUY = new ConcurrentHashMap<>(100);
        this.AUZ = new ConcurrentHashMap<>(100);
        this.AVc = new AtomicLong();
        this.AVd = new AtomicLong();
        this.AVe = new AtomicLong();
        this.AVf = new AtomicLong();
        this.AVg = new AtomicLong();
        this.AVh = new AtomicLong();
        this.AVi = new int[2];
        this.AVj = new n(this);
        this.AVk = new i(this);
        this.AVl = new m(this);
        this.sAe = new HashMap<>();
        this.AVm = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        kotlin.g.b.p.g(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
        this.AVn = sb.append(externalStorageDirectory.getPath()).append(File.separator).append(Environment.DIRECTORY_PICTURES).append(File.separator).append("Screenshots").append(File.separator).toString();
        StringBuilder sb2 = new StringBuilder();
        File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
        kotlin.g.b.p.g(externalStorageDirectory2, "Environment.getExternalStorageDirectory()");
        this.AVo = sb2.append(externalStorageDirectory2.getPath()).append(File.separator).append(Environment.DIRECTORY_DCIM).append(File.separator).append("Screenshots").append(File.separator).toString();
        this.AVp = new v(this.AVn, this);
        this.AVq = new v(this.AVo, this);
        this.AVr = new j(this);
        this.AVs = new MTimerHandler(com.tencent.f.j.a.bqt("ThreadPool.Profiler"), (MTimerHandler.CallBack) new g(this), true);
        this.AVt = new l(this);
        AppMethodBeat.o(184683);
    }

    public static final /* synthetic */ void k(a aVar) {
        AppMethodBeat.i(184686);
        aVar.eCA();
        AppMethodBeat.o(184686);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$ReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_EXPIRED", "TYPE_CONTROL", "TYPE_REJECT", "TYPE_TIMEOUT", "TYPE_STATISTICS_COUNT_BLOWOUT", "TYPE_STATISTICS_UI_TIME", "TYPE_STATISTICS_UI_THREAD_TIME", "TYPE_STATISTICS_UI_TIME_RADIO", "TYPE_STATISTICS_OTHER_TIME", "TYPE_STATISTICS_OTHER_THREAD_TIME", "TYPE_STATISTICS_OTHER_TIME_RADIO", "TYPE_STATISTICS_THREAD_COUNT", "TYPE_STATISTICS_UI_OTHER_AVERAGE", "TYPE_STATISTICS_MAX_COUNT_BLOWOUT", "TYPE_STATISTICS_TASK_THREAD_TIME", "TYPE_LOOPER_PREPARE", "plugin-performance_release"})
    public enum e {
        TYPE_EXPIRED(1),
        TYPE_CONTROL(2),
        TYPE_REJECT(3),
        TYPE_TIMEOUT(4),
        TYPE_STATISTICS_COUNT_BLOWOUT(5),
        TYPE_STATISTICS_UI_TIME(6),
        TYPE_STATISTICS_UI_THREAD_TIME(7),
        TYPE_STATISTICS_UI_TIME_RADIO(8),
        TYPE_STATISTICS_OTHER_TIME(9),
        TYPE_STATISTICS_OTHER_THREAD_TIME(10),
        TYPE_STATISTICS_OTHER_TIME_RADIO(11),
        TYPE_STATISTICS_THREAD_COUNT(12),
        TYPE_STATISTICS_UI_OTHER_AVERAGE(13),
        TYPE_STATISTICS_MAX_COUNT_BLOWOUT(14),
        TYPE_STATISTICS_TASK_THREAD_TIME(15),
        TYPE_LOOPER_PREPARE(16);
        
        final int value;

        public static e valueOf(String str) {
            AppMethodBeat.i(184659);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(184659);
            return eVar;
        }

        private e(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(184657);
            AppMethodBeat.o(184657);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$Companion;", "", "()V", "CHECK_EXPIRED_TIME", "", "CHECK_TIMEOUT_TIME", "DELAY_REPORT", "", "EXPIRED_TIME", "KV_NORMAL_ID", "KV_STATISTICS_ID", "LOOP_PRINT", "TAG", "", "TAG_EXECUTE", "TOP_OF_BLOWOUT_COUNT", "getTOP_OF_BLOWOUT_COUNT", "()I", "TOP_OF_BLOWOUT_COUNT$delegate", "Lkotlin/Lazy;", "VERSION", "isDebug", "", "plugin-performance_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(184684);
        AppMethodBeat.o(184684);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "", "isMain", "", "time", "", "threadTime", "state", "", "(ZJJI)V", "()Z", "getState", "()I", "setState", "(I)V", "getThreadTime", "()J", "setThreadTime", "(J)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-performance_release"})
    public static final class f {
        private final boolean AVP;
        long AVw;
        private int state;
        long time;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    if (!(this.AVP == fVar.AVP && this.time == fVar.time && this.AVw == fVar.AVw && this.state == fVar.state)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            boolean z = this.AVP;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            long j2 = this.time;
            long j3 = this.AVw;
            return (((((i2 * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.state;
        }

        public final String toString() {
            AppMethodBeat.i(184660);
            String str = "TimeRecord(isMain=" + this.AVP + ", time=" + this.time + ", threadTime=" + this.AVw + ", state=" + this.state + ")";
            AppMethodBeat.o(184660);
            return str;
        }

        private f(boolean z, long j2, long j3) {
            this.AVP = z;
            this.time = j2;
            this.AVw = j3;
            this.state = 0;
        }

        public /* synthetic */ f(boolean z, long j2, long j3, byte b2) {
            this(z, j2, j3);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\b\u0010\u001d\u001a\u00020\u0007H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "", "threadTime", "", "count", "", "name", "", "(JILjava/lang/String;)V", "getCount", "()I", "setCount", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getThreadTime", "()J", "setThreadTime", "(J)V", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-performance_release"})
    /* renamed from: com.tencent.mm.plugin.performance.c.a$a  reason: collision with other inner class name */
    public static final class C1571a {
        long AVw = 0;
        int count = 0;
        String name;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
            if (kotlin.g.b.p.j(r5.name, r6.name) != false) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 185181(0x2d35d, float:2.59494E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0026
                boolean r0 = r6 instanceof com.tencent.mm.plugin.performance.c.a.C1571a
                if (r0 == 0) goto L_0x002b
                com.tencent.mm.plugin.performance.c.a$a r6 = (com.tencent.mm.plugin.performance.c.a.C1571a) r6
                long r0 = r5.AVw
                long r2 = r6.AVw
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x002b
                int r0 = r5.count
                int r1 = r6.count
                if (r0 != r1) goto L_0x002b
                java.lang.String r0 = r5.name
                java.lang.String r1 = r6.name
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002b
            L_0x0026:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x002a:
                return r0
            L_0x002b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x002a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.c.a.C1571a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(185180);
            long j2 = this.AVw;
            int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + this.count) * 31;
            String str = this.name;
            int hashCode = (str != null ? str.hashCode() : 0) + i2;
            AppMethodBeat.o(185180);
            return hashCode;
        }

        public C1571a(String str) {
            kotlin.g.b.p.h(str, "name");
            AppMethodBeat.i(185179);
            this.name = str;
            AppMethodBeat.o(185179);
        }

        public final String toString() {
            AppMethodBeat.i(185178);
            String str = "{name=" + this.name + " threadTime=" + this.AVw + " count=" + this.count + '}';
            AppMethodBeat.o(185178);
            return str;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class h<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(185182);
            int a2 = kotlin.b.a.a(Long.valueOf(t2.AVw), Long.valueOf(t.AVw));
            AppMethodBeat.o(185182);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$threadPrinter$1", "Lcom/tencent/threadpool/Printer$ThreadPrinter;", "onExit", "", "thread", "Ljava/lang/Thread;", "name", "", "id", "", "onInterrupt", "onStart", "plugin-performance_release"})
    public static final class n implements d.f {
        final /* synthetic */ a AVQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(a aVar) {
            this.AVQ = aVar;
        }

        @Override // com.tencent.f.d.f
        public final void a(Thread thread, String str, long j2) {
            AppMethodBeat.i(184674);
            kotlin.g.b.p.h(thread, "thread");
            kotlin.g.b.p.h(str, "name");
            Log.i("ThreadPool.Profiler", "[onInterrupt] name=" + str + " id=" + j2);
            AppMethodBeat.o(184674);
        }

        @Override // com.tencent.f.d.f
        public final void b(Thread thread, String str, long j2) {
            AppMethodBeat.i(184675);
            kotlin.g.b.p.h(thread, "thread");
            kotlin.g.b.p.h(str, "name");
            Log.i("ThreadPool.Profiler", "[onThreadStart] name=" + str + " id=" + j2);
            this.AVQ.AUV.incrementAndGet();
            AppMethodBeat.o(184675);
        }

        @Override // com.tencent.f.d.f
        public final void c(Thread thread, String str, long j2) {
            AppMethodBeat.i(184676);
            kotlin.g.b.p.h(thread, "thread");
            kotlin.g.b.p.h(str, "name");
            Log.i("ThreadPool.Profiler", "[onThreadExit] name=" + str + " id=" + j2);
            this.AVQ.AUV.decrementAndGet();
            AppMethodBeat.o(184676);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, hxF = {"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$looperPrepareMonitor$1", "Lcom/tencent/threadpool/ThreadModuleBoot$ILooperPrepareMonitor;", "isResetLooper", "", "()Z", "reportMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getReportMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "isHookResetLooper", "isOpenCheck", "isThrowException", "onLooperPreparedAtTask", "", "thread", "Ljava/lang/Thread;", "task", "plugin-performance_release"})
    public static final class i implements g.b {
        final /* synthetic */ a AVQ;
        private final boolean AVR;
        private final ConcurrentHashMap<String, String> uUF = new ConcurrentHashMap<>();

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(a aVar) {
            this.AVQ = aVar;
            AppMethodBeat.i(200991);
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_threadpool_hook_looper_enable, true);
            Log.w("ThreadPool.Profiler", "[isHookResetLooper] ".concat(String.valueOf(a2)));
            this.AVR = a2;
            AppMethodBeat.o(200991);
        }

        @Override // com.tencent.f.g.b
        public final boolean eCC() {
            return true;
        }

        @Override // com.tencent.f.g.b
        public final boolean eCD() {
            return this.AVR;
        }

        @Override // com.tencent.f.g.b
        public final void a(Thread thread, String str) {
            AppMethodBeat.i(200990);
            kotlin.g.b.p.h(thread, "thread");
            kotlin.g.b.p.h(str, "task");
            if (this.AVQ.AUX) {
                String e2 = new kotlin.n.k("[0-9]\\d*").e(str, "?");
                if (!this.uUF.contains(e2)) {
                    String str2 = "task=" + e2 + ' ' + thread;
                    Log.w("ThreadPool.Profiler", "[onLooperPreparedAtTask] ".concat(String.valueOf(str2)));
                    com.tencent.mm.plugin.report.e.INSTANCE.a(18762, Integer.valueOf(e.TYPE_LOOPER_PREPARE.value), str2, str, 17, MMApplicationContext.getProcessName());
                    this.uUF.put(e2, String.valueOf(thread));
                }
            }
            AppMethodBeat.o(200990);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J)\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "", "time", "", "thread", "Ljava/lang/Thread;", "type", "", "(JLjava/lang/Thread;I)V", "count", "getCount", "()I", "setCount", "(I)V", "getThread", "()Ljava/lang/Thread;", "setThread", "(Ljava/lang/Thread;)V", "getTime", "()J", "setTime", "(J)V", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-performance_release"})
    public static final class b {
        int count;
        Thread thread;
        long time;
        int type;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
            if (r5.type == r6.type) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 184652(0x2d14c, float:2.58753E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0026
                boolean r0 = r6 instanceof com.tencent.mm.plugin.performance.c.a.b
                if (r0 == 0) goto L_0x002b
                com.tencent.mm.plugin.performance.c.a$b r6 = (com.tencent.mm.plugin.performance.c.a.b) r6
                long r0 = r5.time
                long r2 = r6.time
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x002b
                java.lang.Thread r0 = r5.thread
                java.lang.Thread r1 = r6.thread
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002b
                int r0 = r5.type
                int r1 = r6.type
                if (r0 != r1) goto L_0x002b
            L_0x0026:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x002a:
                return r0
            L_0x002b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x002a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.performance.c.a.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(184651);
            long j2 = this.time;
            int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            Thread thread2 = this.thread;
            int hashCode = (((thread2 != null ? thread2.hashCode() : 0) + i2) * 31) + this.type;
            AppMethodBeat.o(184651);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(184650);
            String str = "CheckInfo(time=" + this.time + ", thread=" + this.thread + ", type=" + this.type + ")";
            AppMethodBeat.o(184650);
            return str;
        }

        public /* synthetic */ b(long j2) {
            this(j2, 0);
        }

        public b(long j2, int i2) {
            this.time = j2;
            this.thread = null;
            this.type = i2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J@\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J0\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¨\u0006\u0019"}, hxF = {"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$taskPrinter$1", "Lcom/tencent/threadpool/Printer$TaskPrinter;", "error", "", "key", "", "hash", "", "e", "", SharePatchInfo.FINGER_PRINT, "state", "Lcom/tencent/threadpool/State;", "time", "", "costThreadMs", "pool", "isLogging", "", "rejected", "isShutdown", "shutdown", "wait", "runningCount", "waitFor", "plugin-performance_release"})
    public static final class m implements d.e {
        final /* synthetic */ a AVQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        m(a aVar) {
            this.AVQ = aVar;
        }

        @Override // com.tencent.f.d.e
        public final void a(String str, int i2, com.tencent.f.f fVar, long j2, long j3, String str2, boolean z) {
            String str3;
            String str4;
            String obj;
            AppMethodBeat.i(185183);
            kotlin.g.b.p.h(str, "key");
            kotlin.g.b.p.h(fVar, "state");
            kotlin.g.b.p.h(str2, "pool");
            if (this.AVQ.AUX && fVar == com.tencent.f.f.COMPLETE) {
                if (kotlin.n.n.a(str, '@', 0, false, 6) >= 0) {
                    str3 = str;
                } else {
                    str3 = null;
                }
                if (str3 == null || (obj = str3.subSequence(0, kotlin.n.n.a((CharSequence) str3, '@', 0, false, 6)).toString()) == null) {
                    str4 = str;
                } else {
                    str4 = obj;
                }
                C1571a aVar = (C1571a) this.AVQ.AUY.get(str4);
                if (aVar == null) {
                    C1571a aVar2 = new C1571a(str4);
                    this.AVQ.AUY.put(str4, aVar2);
                    aVar = aVar2;
                }
                kotlin.g.b.p.g(aVar, "batteryRecord[keyRecord]… record\n                }");
                aVar.count++;
                if (aVar.count % 2 == 1) {
                    aVar.AVw++;
                }
                aVar.AVw += j3;
            }
            if (!z) {
                AppMethodBeat.o(185183);
                return;
            }
            switch (b.$EnumSwitchMapping$0[fVar.ordinal()]) {
                case 1:
                    long j4 = j2 < 0 ? 0 : j2 / TimeUtil.SECOND_TO_US;
                    if (this.AVQ.AUX) {
                        this.AVQ.AUW.put(str + '@' + i2, new b(SystemClock.uptimeMillis() + j4));
                    }
                    Log.i("ThreadPool.Execute", "=== " + str + '@' + i2 + " state=" + fVar + " delay=" + j4 + LocaleUtil.MALAY);
                    AppMethodBeat.o(185183);
                    return;
                case 2:
                    if (this.AVQ.AUX) {
                        b bVar = (b) this.AVQ.AUW.get(str + '@' + i2);
                        if (bVar != null) {
                            bVar.thread = Thread.currentThread();
                        }
                        this.AVQ.AUW.remove(str + '@' + i2);
                    }
                    Log.i("ThreadPool.Execute", ">>> " + str + '@' + i2 + " state=" + fVar + ' ' + str2);
                    AppMethodBeat.o(185183);
                    return;
                case 3:
                    String str5 = "<<< " + str + '@' + i2 + " state=" + fVar + " cost=" + j2 + "ms/" + j3 + "ms " + str2;
                    Log.i("ThreadPool.Execute", str5);
                    if (this.AVQ.AUX && j2 >= 600000) {
                        com.tencent.mm.plugin.report.e.INSTANCE.a(18762, Integer.valueOf(e.TYPE_TIMEOUT.value), str5, str, 17, MMApplicationContext.getProcessName());
                        AppMethodBeat.o(185183);
                        return;
                    }
                case 4:
                    if (this.AVQ.AUX) {
                        this.AVQ.AUW.remove(str + '@' + i2);
                    }
                    Log.i("ThreadPool.Execute", "||| " + str + '@' + i2 + " state=" + fVar);
                    AppMethodBeat.o(185183);
                    return;
                case 5:
                    if (this.AVQ.AUX) {
                        this.AVQ.AUW.remove(str + '@' + i2);
                    }
                    Log.i("ThreadPool.Execute", "*** " + str + '@' + i2 + " state=" + fVar);
                    break;
            }
            AppMethodBeat.o(185183);
        }

        @Override // com.tencent.f.d.e
        public final void a(String str, int i2, Throwable th) {
            AppMethodBeat.i(184670);
            kotlin.g.b.p.h(str, "key");
            kotlin.g.b.p.h(th, "e");
            Log.e("ThreadPool.Profiler", str + '@' + i2 + ' ' + th);
            AppMethodBeat.o(184670);
        }

        @Override // com.tencent.f.d.e
        public final void a(String str, int i2, int i3, long j2, String str2) {
            AppMethodBeat.i(184671);
            kotlin.g.b.p.h(str, "key");
            kotlin.g.b.p.h(str2, "pool");
            String str3 = "[wait] " + str + '@' + i2 + " runningCount=" + i3 + " waitFor=" + (j2 / 100000) + "ms " + str2;
            Log.w("ThreadPool.Profiler", str3);
            com.tencent.mm.plugin.report.e.INSTANCE.a(18762, Integer.valueOf(e.TYPE_CONTROL.value), str3, str, 17, MMApplicationContext.getProcessName());
            AppMethodBeat.o(184671);
        }

        @Override // com.tencent.f.d.e
        public final void g(String str, int i2, String str2) {
            AppMethodBeat.i(184672);
            kotlin.g.b.p.h(str, "key");
            kotlin.g.b.p.h(str2, "pool");
            String str3 = "[rejected] " + str + ' ' + str2 + " isShutdown=true";
            Log.w("ThreadPool.Profiler", str3);
            if (this.AVQ.AUX) {
                this.AVQ.AUW.remove(str + '@' + i2);
                com.tencent.mm.plugin.report.e.INSTANCE.a(18762, Integer.valueOf(e.TYPE_REJECT.value), str3, str, 17, MMApplicationContext.getProcessName());
            }
            AppMethodBeat.o(184672);
        }

        @Override // com.tencent.f.d.e
        public final void shutdown() {
            AppMethodBeat.i(184673);
            Log.w("ThreadPool.Profiler", "shutdown");
            this.AVQ.AUW.clear();
            AppMethodBeat.o(184673);
        }
    }

    @Override // com.tencent.mm.app.p
    public final void cM(boolean z) {
        boolean z2;
        String str;
        String str2;
        int i2;
        CharSequence subSequence;
        boolean z3;
        AppMethodBeat.i(184677);
        if (!z) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.lastCheckTime >= 900000 && this.AUX) {
                LinkedList<String> linkedList = new LinkedList();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, b> entry : this.AUW.entrySet()) {
                    if (SystemClock.uptimeMillis() - entry.getValue().time < Util.MILLSECONDS_OF_MINUTE || entry.getValue().type != 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                boolean z4 = false;
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    Object key = entry2.getKey();
                    String str3 = kotlin.n.n.a((String) key, '@', 0, false, 6) >= 0 ? key : null;
                    if (str3 == null || (subSequence = str3.subSequence(0, kotlin.n.n.a((CharSequence) str3, '@', 0, false, 6))) == null) {
                        str = (String) entry2.getKey();
                    } else {
                        str = subSequence;
                    }
                    Object key2 = entry2.getKey();
                    String str4 = kotlin.n.n.a((String) key2, '#', 0, false, 6) >= 0 ? key2 : null;
                    if (str4 == null || (str2 = str4.subSequence(0, kotlin.n.n.a((CharSequence) str4, '#', 0, false, 6))) == null) {
                        str2 = (String) entry2.getKey();
                    }
                    com.tencent.f.j.a bqu = com.tencent.f.j.a.bqu(str2.toString());
                    com.tencent.f.j.d hmG = bqu != null ? bqu.hmG() : null;
                    String str5 = ((String) entry2.getKey()) + " has expired " + (SystemClock.uptimeMillis() - ((b) entry2.getValue()).time) + "ms size=" + (hmG != null ? Integer.valueOf(hmG.size()) : null) + " queue is null=" + (hmG == null) + " isRunning=" + (hmG != null ? Boolean.valueOf(hmG.isRunning()) : null);
                    Log.e("ThreadPool.Profiler", str5);
                    if (hmG == null) {
                        i2 = 0;
                    } else if (hmG.isRunning()) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    com.tencent.mm.plugin.report.e.INSTANCE.a(18762, Integer.valueOf(e.TYPE_EXPIRED.value), str5, str, 17, MMApplicationContext.getProcessName(), Integer.valueOf(i2));
                    linkedList.add(entry2.getKey());
                    z4 = true;
                }
                ConcurrentLinkedQueue<WeakReference<com.tencent.f.b>> concurrentLinkedQueue = com.tencent.f.b.RSA;
                kotlin.g.b.p.g(concurrentLinkedQueue, "ForkThreadPoolExecutor.sGlobalForkThreadPool");
                Iterator<T> it = concurrentLinkedQueue.iterator();
                boolean z5 = z4;
                while (it.hasNext()) {
                    com.tencent.f.b bVar = (com.tencent.f.b) it.next().get();
                    if (bVar != null) {
                        String name = bVar.getName();
                        int completedTaskCount = (int) bVar.getCompletedTaskCount();
                        int size = bVar.getQueue().size();
                        b bVar2 = this.AUW.get(name);
                        if (bVar2 == null) {
                            b bVar3 = new b(SystemClock.uptimeMillis(), 1);
                            kotlin.g.b.p.g(name, "key");
                            this.AUW.put(name, bVar3);
                            bVar2 = bVar3;
                        }
                        kotlin.g.b.p.g(bVar2, "checkQueue[key] ?: run {…eckInfo\n                }");
                        int i3 = completedTaskCount - bVar2.count;
                        if (completedTaskCount <= 0 || size <= 0 || i3 != 0 || SystemClock.uptimeMillis() - bVar2.time < Util.MILLSECONDS_OF_MINUTE) {
                            bVar2.time = SystemClock.uptimeMillis();
                            z2 = z5;
                        } else {
                            String str6 = "[ForkThreadPoolExecutor] " + name + " has expired " + (SystemClock.uptimeMillis() - bVar2.time) + "ms " + bVar;
                            Log.e("ThreadPool.Profiler", str6);
                            com.tencent.mm.plugin.report.e.INSTANCE.a(18762, Integer.valueOf(e.TYPE_EXPIRED.value), str6, name, 17, MMApplicationContext.getProcessName());
                            linkedList.add(name);
                            z2 = true;
                        }
                        bVar2.count = completedTaskCount;
                        z5 = z2;
                    }
                }
                if (z5) {
                    eCz();
                }
                for (String str7 : linkedList) {
                    this.AUW.remove(str7);
                }
                try {
                    if (this.AUY.values().size() > 1) {
                        Collection<C1571a> values = this.AUY.values();
                        kotlin.g.b.p.g(values, "batteryRecord.values");
                        int i4 = 0;
                        for (Object obj : kotlin.a.j.a((Iterable) values, (Comparator) new h()).subList(0, kotlin.k.j.na(30, this.AUY.values().size() - 1))) {
                            int i5 = i4 + 1;
                            if (i4 < 0) {
                                kotlin.a.j.hxH();
                            }
                            C1571a aVar = (C1571a) obj;
                            Log.i("ThreadPool.Profiler", "[batteryRecord]#" + i4 + ' ' + aVar);
                            com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_TASK_THREAD_TIME.value), Long.valueOf(aVar.AVw), MMApplicationContext.getProcessName(), aVar.name, Integer.valueOf(aVar.count));
                            i4 = i5;
                        }
                        this.AUY.clear();
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("ThreadPool.Profiler", e2, "", new Object[0]);
                }
                this.lastCheckTime = uptimeMillis;
            }
        }
        AppMethodBeat.o(184677);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppForeground(String str) {
        AppMethodBeat.i(184678);
        if (!cWq) {
            AppMethodBeat.o(184678);
            return;
        }
        this.AVp.startWatching();
        this.AVq.startWatching();
        AppMethodBeat.o(184678);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppBackground(String str) {
        AppMethodBeat.i(184679);
        if (!cWq) {
            AppMethodBeat.o(184679);
            return;
        }
        this.AVp.stopWatching();
        this.AVq.stopWatching();
        AppMethodBeat.o(184679);
    }

    @Override // com.tencent.mm.pluginsdk.model.v.a
    public final void eCy() {
        AppMethodBeat.i(184680);
        if (!cWq) {
            AppMethodBeat.o(184680);
            return;
        }
        com.tencent.mm.ac.c cVar = new com.tencent.mm.ac.c("ThreadPool.Profiler#onScreenshotTaken");
        eCz();
        cVar.aBw();
        AppMethodBeat.o(184680);
    }

    private final void eCz() {
        AppMethodBeat.i(184681);
        StringBuilder sb = new StringBuilder(" \n[RunningTask]\n");
        kotlin.g.b.p.g(sb, "StringBuilder(\" \\n[RunningTask]\").append(\"\\n\")");
        Map<String, Integer> hmd = com.tencent.f.h.RTd.hmd();
        kotlin.g.b.p.g(hmd, "ThreadPool.PROFILE.dumpRunningTask()");
        for (Map.Entry<String, Integer> entry : hmd.entrySet()) {
            StringBuilder append = sb.append("\t").append(entry.getKey()).append(" => ");
            Integer value = entry.getValue();
            kotlin.g.b.p.g(value, "it.value");
            append.append(value.intValue()).append("\n");
        }
        Log.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(sb)));
        kotlin.n.n.h(sb);
        sb.append(" \n[WaitingTask]\n");
        Map<String, List<Pair<String, Integer>>> hme = com.tencent.f.h.RTd.hme();
        kotlin.g.b.p.g(hme, "ThreadPool.PROFILE.dumpWaitingTask()");
        for (Map.Entry<String, List<Pair<String, Integer>>> entry2 : hme.entrySet()) {
            sb.append("# ").append(entry2.getKey()).append("\n");
            List<Pair<String, Integer>> value2 = entry2.getValue();
            kotlin.g.b.p.g(value2, "entry.value");
            for (T t : value2) {
                StringBuilder append2 = sb.append("\t|* ").append((String) ((Pair) t).first).append(" => ");
                Object obj = ((Pair) t).second;
                kotlin.g.b.p.g(obj, "it.second");
                append2.append(((Number) obj).intValue()).append("\n");
            }
        }
        Log.i("ThreadPool.Profiler", "[dumpThreadPool] ".concat(String.valueOf(sb)));
        Log.i("ThreadPool.Profiler", "[dumpThreadPool] Alive Thread Count = " + this.AUV.get() + " Global Running Count = " + this.AUU.get() + " maxRunningCount=" + this.AVa);
        eCA();
        AppMethodBeat.o(184681);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$open$1", "Ljava/lang/Runnable;", "run", "", "plugin-performance_release"})
    public static final class k implements Runnable {
        final /* synthetic */ a AVQ;
        final /* synthetic */ MMHandler AVT;

        public k(a aVar, MMHandler mMHandler) {
            this.AVQ = aVar;
            this.AVT = mMHandler;
        }

        public final void run() {
            AppMethodBeat.i(184665);
            a.a(this.AVQ);
            this.AVT.postDelayed(this, 1800000);
            AppMethodBeat.o(184665);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$mainLooperListener$1", "Landroid/util/Printer;", "record", "Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "getRecord", "()Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;", "setRecord", "(Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TimeRecord;)V", "onDispatchEnd", "", "x", "", "onDispatchStart", "println", "plugin-performance_release"})
    public static final class j implements Printer {
        final /* synthetic */ a AVQ;
        private f AVS = new f(true, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte) 0);

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(a aVar) {
            this.AVQ = aVar;
            AppMethodBeat.i(184664);
            AppMethodBeat.o(184664);
        }

        public final void println(String str) {
            AppMethodBeat.i(184663);
            kotlin.g.b.p.h(str, "x");
            if (str.charAt(0) == '>') {
                kotlin.g.b.p.h(str, "x");
                this.AVS.time = SystemClock.uptimeMillis();
                this.AVS.AVw = SystemClock.currentThreadTimeMillis();
                int i2 = this.AVQ.AUU.get();
                if (i2 > 0) {
                    int[] iArr = this.AVQ.AVi;
                    iArr[0] = i2 + iArr[0];
                    int[] iArr2 = this.AVQ.AVi;
                    iArr2[1] = iArr2[1] + 1;
                }
                AppMethodBeat.o(184663);
                return;
            }
            if (str.charAt(0) == '<') {
                kotlin.g.b.p.h(str, "x");
                f fVar = this.AVS;
                long uptimeMillis = SystemClock.uptimeMillis() - fVar.time;
                long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - fVar.AVw;
                this.AVQ.AVf.addAndGet(uptimeMillis);
                this.AVQ.AVg.addAndGet(currentThreadTimeMillis);
                this.AVQ.AVh.incrementAndGet();
            }
            AppMethodBeat.o(184663);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class g implements MTimerHandler.CallBack {
        final /* synthetic */ a AVQ;

        g(a aVar) {
            this.AVQ = aVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(184662);
            a.k(this.AVQ);
            AppMethodBeat.o(184662);
            return true;
        }
    }

    private final void eCA() {
        AppMethodBeat.i(184682);
        Log.i("ThreadPool.Profiler", "[dumpThreadPool]\n averageUITime=" + ((((float) this.AVf.get()) * 1.0f) / ((float) this.AVh.get())) + " averageUIThreadTime=" + ((((float) this.AVg.get()) * 1.0f) / ((float) this.AVh.get())) + '\n' + "averageOtherTime=" + ((((float) this.AVc.get()) * 1.0f) / ((float) this.AVe.get())) + " averageOtherThreadTime=" + ((((float) this.AVd.get()) * 1.0f) / ((float) this.AVe.get())) + '\n' + "uiTaskCount=" + this.AVh.get() + " otherTaskCount=" + this.AVe.get() + '\n' + "uiBusyConcurrent=" + this.AVi[1] + " averageUIConcurrent=" + ((((float) this.AVi[0]) * 1.0f) / ((float) this.AVi[1])) + " concurrentRadio=" + ((((float) this.AVi[1]) * 1.0f) / ((float) this.AVh.get())));
        AppMethodBeat.o(184682);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JE\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J8\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$runCallback$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "mainThreadId", "", "getMainThreadId", "()J", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-performance_release"})
    public static final class l implements com.tencent.mm.hellhoundlib.a.c {
        final /* synthetic */ a AVQ;
        private final long AVU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        l(a aVar) {
            this.AVQ = aVar;
            AppMethodBeat.i(184668);
            Looper mainLooper = Looper.getMainLooper();
            kotlin.g.b.p.g(mainLooper, "Looper.getMainLooper()");
            Thread thread = mainLooper.getThread();
            kotlin.g.b.p.g(thread, "Looper.getMainLooper().thread");
            this.AVU = thread.getId();
            AppMethodBeat.o(184668);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            int i2;
            AppMethodBeat.i(184666);
            kotlin.g.b.p.h(str, "className");
            int incrementAndGet = this.AVQ.AUU.incrementAndGet();
            if (incrementAndGet > this.AVQ.AVb) {
                this.AVQ.AVb = incrementAndGet;
            }
            c cVar = a.AVv;
            kotlin.f fVar = a.AVu;
            c cVar2 = a.AVv;
            if (incrementAndGet > ((Number) fVar.getValue()).intValue()) {
                this.AVQ.AVa++;
            }
            long j2 = this.AVU;
            Thread currentThread = Thread.currentThread();
            kotlin.g.b.p.g(currentThread, "Thread.currentThread()");
            if (j2 != currentThread.getId()) {
                ConcurrentHashMap concurrentHashMap = this.AVQ.AUZ;
                StringBuilder append = new StringBuilder().append(str);
                if (obj != null) {
                    i2 = obj.hashCode();
                } else {
                    i2 = 0;
                }
                concurrentHashMap.put(append.append(i2).toString(), new f(false, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis(), (byte) 0));
            }
            AppMethodBeat.o(184666);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
            AppMethodBeat.i(200992);
            kotlin.g.b.p.h(str, "className");
            this.AVQ.AUU.decrementAndGet();
            long j2 = this.AVU;
            Thread currentThread = Thread.currentThread();
            kotlin.g.b.p.g(currentThread, "Thread.currentThread()");
            if (j2 != currentThread.getId()) {
                f fVar = (f) this.AVQ.AUZ.remove(str + (obj != null ? obj.hashCode() : 0));
                if (fVar != null) {
                    long uptimeMillis = SystemClock.uptimeMillis() - fVar.time;
                    this.AVQ.AVd.addAndGet(SystemClock.currentThreadTimeMillis() - fVar.AVw);
                    this.AVQ.AVc.addAndGet(uptimeMillis);
                    this.AVQ.AVe.incrementAndGet();
                    AppMethodBeat.o(200992);
                    return;
                }
            }
            AppMethodBeat.o(200992);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Integer> {
        public static final d AVx = new d();

        static {
            AppMethodBeat.i(184654);
            AppMethodBeat.o(184654);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(184653);
            Integer valueOf = Integer.valueOf(aa.a.MAIN_PROCESS.akY() + aa.a.MAIN_PROCESS.akZ());
            AppMethodBeat.o(184653);
            return valueOf;
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(184685);
        String processName = MMApplicationContext.getProcessName();
        com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_COUNT_BLOWOUT.value), Integer.valueOf(aVar.AVa), processName);
        aVar.AVa = 0;
        com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_MAX_COUNT_BLOWOUT.value), Integer.valueOf(aVar.AVb), processName);
        aVar.AVb = 0;
        com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_UI_TIME.value), Long.valueOf(aVar.AVf.get()), processName);
        com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_UI_THREAD_TIME.value), Long.valueOf(aVar.AVg.get()), processName);
        com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_UI_TIME_RADIO.value), Integer.valueOf((int) ((100.0f * ((float) aVar.AVg.get())) / ((float) aVar.AVf.get()))), processName);
        com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_OTHER_THREAD_TIME.value), Long.valueOf(aVar.AVd.get()), processName);
        com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_OTHER_TIME.value), Long.valueOf(aVar.AVc.get()), processName);
        com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_OTHER_TIME_RADIO.value), Integer.valueOf((int) ((100.0f * ((float) aVar.AVd.get())) / ((float) aVar.AVc.get()))), processName);
        com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_THREAD_COUNT.value), Integer.valueOf(ThreadWatchDog.getJavaThreadCount()));
        com.tencent.mm.plugin.report.e.INSTANCE.a(18883, 17, Integer.valueOf(e.TYPE_STATISTICS_UI_OTHER_AVERAGE.value), Integer.valueOf((int) ((100.0f * ((float) aVar.AVi[0])) / ((float) aVar.AVi[1]))), processName);
        AppMethodBeat.o(184685);
    }
}
