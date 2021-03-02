package com.tencent.mm.plugin.finder.preload.tabPreload;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.os.SystemClock;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.tabPreload.a;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bbk;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u0001:\u0004efghB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0019J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020 H\u0016J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020;H\u0002J\u0010\u0010?\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010@\u001a\u00020\u00192\u0006\u0010>\u001a\u00020;2\u0006\u0010A\u001a\u00020BH\u0016J\u001a\u0010C\u001a\u00020\u00192\u0006\u0010>\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020\bH\u0016J\b\u0010E\u001a\u00020FH\u0017J\u0018\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003H\u0017J\b\u0010J\u001a\u00020FH\u0017J\b\u0010K\u001a\u00020FH\u0017J\u001a\u0010L\u001a\u00020F2\u0006\u0010I\u001a\u00020\u00032\b\u0010M\u001a\u0004\u0018\u00010NH\u0017J\b\u0010O\u001a\u00020FH\u0017J\b\u0010P\u001a\u00020FH\u0017J\b\u0010Q\u001a\u00020FH\u0017J\u0018\u0010R\u001a\u00020F2\u0006\u0010S\u001a\u00020\u00032\u0006\u0010T\u001a\u00020UH\u0017J?\u0010V\u001a\u00020F2\u0006\u0010>\u001a\u00020;2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2!\u0010W\u001a\u001d\u0012\u0013\u0012\u00110Y¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020F0XH\u0016J(\u0010]\u001a\u00020F2\u0006\u0010^\u001a\u00020\u00192\u0006\u0010_\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010`\u001a\u00020 H\u0002J\u0012\u0010a\u001a\u0004\u0018\u00010B2\u0006\u0010_\u001a\u00020\u0003H\u0007J\u0018\u0010b\u001a\u00020F2\u0006\u0010A\u001a\u00020B2\u0006\u0010>\u001a\u00020;H\u0002J\u0010\u0010c\u001a\u00020F2\u0006\u0010>\u001a\u00020;H\u0002J\n\u0010d\u001a\u00020\b*\u00020UR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00060\fR\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b/\u00100R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006i"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;", "", "tabType", "", "core", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "(ILcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "getCache", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "getCore", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/FinderStreamTabPreloadCore;", "isBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isInFindMoreFriendTab", "isInFinder", "", "()Z", "setInFinder", "(Z)V", "isLoading", "setLoading", "lastExitFindMoreFriendTab", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "outSideTimeoutRunnable", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "getOutSideTimeoutRunnable", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "preloadVideoWorker", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "preloadVideoWorker$delegate", "Lkotlin/Lazy;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "getRedDotManager", "()Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "redDotManager$delegate", "getTabType", "()I", "timer", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "getTimer", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer;", "clear", "isRecycle", "getOutTimeOutPreloadSource", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getOuterTime", "getPullType", "source", "getReportKey", "isAcceptCgiBack", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "isValid", "log", "performBackground", "", "performChangeEnterTargetTab", "lastTab", "targetTab", "performEnterFindMoreFriendTab", "performEnterFinder", "performEnterFinderLoad", "intent", "Landroid/content/Intent;", "performExitFindMoreFriendTab", "performExitFinder", "performForeground", "performServerConfigChanged", "fromTabType", "serverConfig", "Lcom/tencent/mm/protocal/protobuf/FinderStreamPrefechTimeIntervalConf;", "preload", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "Lkotlin/ParameterName;", "name", "ret", "report", "isHasCache", "pullType", "overCount", "requestCache", "setCache", "updateCacheStatus", SharePatchInfo.FINGER_PRINT, "Cache", "CacheTime", "PreloadSource", "Ret", "plugin-finder_release"})
public abstract class f {
    public final String TAG = ("Finder.TabPreloadWorker#" + this.dLS);
    public final int dLS;
    final ReentrantLock dgE = new ReentrantLock();
    final Condition dgF = this.dgE.newCondition();
    volatile boolean isLoading;
    final kotlin.f tGg = kotlin.g.ah(new h(this));
    long uUZ;
    public boolean uVa;
    public final a uVb = new a(this.TAG);
    final AtomicBoolean uVc = new AtomicBoolean(true);
    final AtomicBoolean uVd = new AtomicBoolean(false);
    private final kotlin.f uVe = kotlin.g.ah(i.uVD);
    public final a.AbstractRunnableC1255a uVf = new e(this);
    public final a uVg = new a(this.dLS);
    public final FinderStreamTabPreloadCore uVh;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "", "(Ljava/lang/String;I)V", "LOADING", "DISABLE", "INVALID", "OK", "plugin-finder_release"})
    public enum d {
        LOADING,
        DISABLE,
        INVALID,
        OK;

        static {
            AppMethodBeat.i(249597);
            AppMethodBeat.o(249597);
        }

        public static d valueOf(String str) {
            AppMethodBeat.i(249599);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(249599);
            return dVar;
        }
    }

    private final com.tencent.mm.plugin.finder.extension.reddot.f getRedDotManager() {
        return (com.tencent.mm.plugin.finder.extension.reddot.f) this.uVe.getValue();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.preload.tabPreload.f$f  reason: collision with other inner class name */
    public static final class C1257f extends q implements kotlin.g.a.b<d, x> {
        final /* synthetic */ f uVn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1257f(f fVar) {
            super(1);
            this.uVn = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(d dVar) {
            AppMethodBeat.i(249602);
            d dVar2 = dVar;
            p.h(dVar2, "ret");
            Log.i(this.uVn.TAG, "performEnterFinderLoad: ret = " + dVar2 + ", tabType = " + this.uVn.dLS);
            x xVar = x.SXb;
            AppMethodBeat.o(249602);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "feed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$requestCache$1$1"})
    public static final class j extends q implements kotlin.g.a.b<FinderObject, Boolean> {
        final /* synthetic */ FinderTabStreamUnreadVM uVE;
        final /* synthetic */ z.f uVF;
        final /* synthetic */ f uVn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderTabStreamUnreadVM finderTabStreamUnreadVM, f fVar, z.f fVar2) {
            super(1);
            this.uVE = finderTabStreamUnreadVM;
            this.uVn = fVar;
            this.uVF = fVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(FinderObject finderObject) {
            boolean z;
            AppMethodBeat.i(249609);
            FinderObject finderObject2 = finderObject;
            FinderTabStreamUnreadVM finderTabStreamUnreadVM = this.uVE;
            long j2 = finderObject2.id;
            if (finderTabStreamUnreadVM.wuL.Gz(j2) || finderTabStreamUnreadVM.wuK.Gz(j2) || finderTabStreamUnreadVM.wuM.Gz(j2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.i(this.uVn.TAG, "requestCache: remove read feed, id = " + finderObject2.id);
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(249609);
            return valueOf;
        }
    }

    public f(int i2, FinderStreamTabPreloadCore finderStreamTabPreloadCore) {
        p.h(finderStreamTabPreloadCore, "core");
        this.dLS = i2;
        this.uVh = finderStreamTabPreloadCore;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OutSideRedDot", "InsideRedDot", "OutSideTimeout", "InsideConfigNotify", "OutSideJumpHot", "EnterLoad", "plugin-finder_release"})
    public enum c {
        OutSideRedDot(1),
        InsideRedDot(2),
        OutSideTimeout(3),
        InsideConfigNotify(4),
        OutSideJumpHot(5),
        EnterLoad(6);
        
        final int value;

        public static c valueOf(String str) {
            AppMethodBeat.i(249596);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(249596);
            return cVar;
        }

        private c(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(249594);
            AppMethodBeat.o(249594);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$outSideTimeoutRunnable$1", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/ExpiredTimer$TimeRunnable;", "run", "", "plugin-finder_release"})
    public static final class e extends a.AbstractRunnableC1255a {
        final /* synthetic */ f uVn;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Ret;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<d, x> {
            final /* synthetic */ e uVA;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(e eVar) {
                super(1);
                this.uVA = eVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(d dVar) {
                AppMethodBeat.i(249600);
                d dVar2 = dVar;
                p.h(dVar2, "ret");
                if (dVar2 == d.INVALID || dVar2 == d.OK) {
                    this.uVA.uVn.uVb.a(this.uVA, this.uVA.uVn.dlK(), "outSideTimeoutRunnable");
                }
                x xVar = x.SXb;
                AppMethodBeat.o(249600);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(f fVar) {
            this.uVn = fVar;
        }

        public final void run() {
            AppMethodBeat.i(249601);
            Log.i(this.uVn.TAG, "outSideTimeoutRunnable run... isInFinder=" + this.uVn.uVa);
            if (!this.uVn.uVa) {
                this.uVn.a(this.uVn.dlJ(), null, new a(this));
            }
            AppMethodBeat.o(249601);
        }
    }

    public long dlK() {
        com.tencent.mm.plugin.finder.extension.reddot.f redDotManager = getRedDotManager();
        getRedDotManager();
        return FinderStreamTabPreloadCore.al(this.dLS, redDotManager.asW(com.tencent.mm.plugin.finder.extension.reddot.f.Ix(this.dLS)) != null);
    }

    public c dlJ() {
        return c.OutSideTimeout;
    }

    public void gc(int i2, int i3) {
        Log.i(this.TAG, "[performChangeEnterTargetTab] lastTab=" + i2 + " targetTab=" + i3);
    }

    public void a(int i2, bcy bcy) {
        p.h(bcy, "serverConfig");
        String str = this.TAG;
        StringBuilder append = new StringBuilder("[performServerConfigChanged] fromTabType=").append(i2).append(" serverConfig=");
        p.h(bcy, "$this$print");
        Log.i(str, append.append("[" + bcy.LMf + ", " + bcy.LMg + ", " + bcy.LMh + ", " + bcy.LMi + ", " + bcy.LMj + ", " + bcy.LMk + ", " + bcy.LMl + ", " + bcy.LMm + ", " + bcy.LMn + ", " + bcy.LMo + ", " + bcy.LMp + ", " + bcy.LMq + ", " + bcy.LMr + ", " + bcy.LMs + ", " + bcy.LMt + ", " + bcy.LMu + ", " + bcy.LMv + ']').toString());
    }

    public boolean a(c cVar, String str) {
        p.h(cVar, "source");
        p.h(str, "log");
        Log.i(this.TAG, "[isValid] isInFindMoreFriendTab=" + this.uVd + " isBackground=" + this.uVc + " isInFinder=" + this.uVa + " source=" + cVar + ' ' + str);
        return (cVar == c.OutSideRedDot || cVar == c.OutSideJumpHot || cVar == c.OutSideTimeout || cVar == c.EnterLoad) ? !this.uVa && this.uVd.get() && !this.uVc.get() : this.uVa && this.uVd.get() && !this.uVc.get();
    }

    public void a(c cVar, Intent intent, kotlin.g.a.b<? super d, x> bVar) {
        int i2;
        boolean z;
        com.tencent.mm.bw.b bVar2;
        LinkedList linkedList;
        int i3;
        boolean z2;
        String str;
        String str2;
        String str3;
        LinkedList linkedList2;
        com.tencent.mm.bw.b bVar3;
        p.h(cVar, "source");
        p.h(bVar, "call");
        if (this.isLoading) {
            Log.w(this.TAG, "isLoading=true");
            bVar.invoke(d.LOADING);
        } else if (!FinderStreamTabPreloadCore.a(cVar)) {
            Log.w(this.TAG, "isEnable=false source=".concat(String.valueOf(cVar)));
            bVar.invoke(d.DISABLE);
        } else if (!a((f) cVar, (c) "")) {
            Log.w(this.TAG, "isValid=false source=".concat(String.valueOf(cVar)));
            bVar.invoke(d.INVALID);
        } else {
            this.dgE.lock();
            try {
                this.isLoading = true;
                if (cVar == c.OutSideRedDot || cVar == c.OutSideTimeout) {
                    i2 = 6;
                } else if (cVar == c.InsideRedDot) {
                    i2 = 7;
                } else if (cVar == c.InsideConfigNotify) {
                    i2 = 5;
                } else if (cVar == c.OutSideJumpHot) {
                    i2 = 8;
                } else if (cVar == c.EnterLoad) {
                    i2 = 0;
                } else {
                    i2 = 6;
                }
                if (this.uVg.uVi != null) {
                    z = true;
                } else {
                    z = false;
                }
                aa.f fVar = this.uVg.uVi;
                if (fVar == null || (bVar3 = fVar.lastBuffer) == null) {
                    com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh, "MMKernel.storage()");
                    ao azQ = aAh.azQ();
                    y yVar = y.vXH;
                    Object obj = azQ.get(y.LK(this.dLS), "");
                    if (obj == null) {
                        throw new t("null cannot be cast to non-null type kotlin.String");
                    }
                    bVar2 = com.tencent.mm.bw.b.cD(Util.decodeHexString((String) obj));
                } else {
                    bVar2 = bVar3;
                }
                aa.f fVar2 = this.uVg.uVi;
                if (fVar2 == null || (linkedList2 = fVar2.object) == null) {
                    linkedList = new LinkedList();
                } else {
                    linkedList = new LinkedList(linkedList2);
                }
                if (i2 == 0 && (this.dLS == 1 || this.dLS == 3)) {
                    y yVar2 = y.vXH;
                    y yVar3 = y.vXH;
                    e.a aVar = com.tencent.mm.plugin.finder.feed.model.internal.e.tYB;
                    List a2 = y.a(y.a(yVar3, e.a.IO(this.dLS).value, null, 0, true, this.dLS, 6), BaseFinderFeed.class);
                    y yVar4 = y.vXH;
                    List<BaseFinderFeed> u = y.u(a2, this.dLS);
                    ArrayList arrayList = new ArrayList(kotlin.a.j.a(u, 10));
                    Iterator<T> it = u.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().feedObject.getFeedObject());
                    }
                    linkedList.addAll(arrayList);
                    String str4 = this.TAG;
                    StringBuilder append = new StringBuilder("[preload] tabType=").append(this.dLS).append(", unreadList=").append(linkedList.size()).append(" first=");
                    FinderObject finderObject = (FinderObject) kotlin.a.j.kv(linkedList);
                    Log.i(str4, append.append(com.tencent.mm.ac.d.zs(finderObject != null ? finderObject.id : 0)).toString());
                }
                nM(true);
                bbn bbn = new bbn();
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                bbn.tCE = com.tencent.mm.plugin.finder.report.k.Kw(this.dLS);
                if (cVar == c.EnterLoad) {
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    bbn.sGE = FinderReporterUIC.a.MG(this.dLS);
                    if (intent == null || (str = intent.getStringExtra("key_context_id")) == null) {
                        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                        str = com.tencent.mm.plugin.finder.report.k.doc();
                    }
                    bbn.sGQ = str;
                    String cMD = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
                    if (cMD == null) {
                        cMD = "";
                    }
                    bbn.sessionId = cMD;
                    if (intent == null || (str2 = intent.getStringExtra("key_extra_info")) == null) {
                        str2 = "";
                    }
                    bbn.extraInfo = str2;
                    if (intent == null || (str3 = intent.getStringExtra("key_enter_source_info")) == null) {
                        str3 = "";
                    }
                    bbn.sGH = str3;
                }
                String str5 = this.TAG;
                StringBuilder append2 = new StringBuilder("[preload] tabType=").append(this.dLS).append(", hasCache=").append(z).append(", consumeFlag=");
                if (z) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                Log.i(str5, append2.append(i3).append(", unread list size=").append(linkedList.size()).append(", pullType=").append(i2).append(", source=").append(cVar).append(", cache=").append(this.uVg).toString());
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(this.dLS) + 11, 1, false);
                new aa(this.dLS, i2, bVar2, bbn, linkedList, true).a((com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a>) null, new g(this, z, cVar, bVar));
                if (cVar == c.EnterLoad) {
                    com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
                    h.a Kd = com.tencent.mm.plugin.finder.report.h.Kd(this.dLS);
                    if (Kd != null) {
                        if (!Kd.ZA || Kd.vev) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            Kd = null;
                        }
                        if (Kd != null) {
                            Kd.vfh = 1;
                        }
                    }
                }
            } finally {
                this.dgE.unlock();
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J8\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$preload$2", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "interceptors", "", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "plugin-finder_release"})
    public static final class g implements aa.b {
        final /* synthetic */ kotlin.g.a.b twV;
        final /* synthetic */ boolean uVB;
        final /* synthetic */ c uVC;
        final /* synthetic */ f uVn;

        g(f fVar, boolean z, c cVar, kotlin.g.a.b bVar) {
            this.uVn = fVar;
            this.uVB = z;
            this.uVC = cVar;
            this.twV = bVar;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.aa.b
        public final boolean cXU() {
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.aa.b
        public final boolean a(dpc dpc) {
            AppMethodBeat.i(249603);
            p.h(dpc, "resp");
            AppMethodBeat.o(249603);
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.aa.b
        public final void a(bcz bcz) {
            AppMethodBeat.i(249604);
            p.h(bcz, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            if (this.uVB) {
                bcz.LMw = 0;
                AppMethodBeat.o(249604);
                return;
            }
            bcz.LMw = 1;
            AppMethodBeat.o(249604);
        }

        @Override // com.tencent.mm.plugin.finder.cgi.aa.b
        public final void a(int i2, int i3, String str, aa.f fVar, List<? extends com.tencent.mm.plugin.finder.cgi.interceptor.f> list) {
            AppMethodBeat.i(249605);
            p.h(fVar, "resp");
            p.h(list, "interceptors");
            this.uVn.dgE.lock();
            if (i2 == 0 && i3 == 0) {
                try {
                    this.uVn.uVg.uVk.clear();
                    if (!this.uVn.a(this.uVC, fVar)) {
                        Log.i(this.uVn.TAG, "[onCgiBack] tabType=" + this.uVn.dLS + " throw this preload, size=" + fVar.object.size() + " cache=" + this.uVn.uVg);
                    } else if (!fVar.object.isEmpty()) {
                        f fVar2 = this.uVn;
                        c cVar = this.uVC;
                        fVar2.uVg.uVi = fVar;
                        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        if (com.tencent.mm.plugin.finder.storage.c.dsm()) {
                            LinkedList linkedList = fVar.object;
                            p.g(linkedList, "resp.`object`");
                            FinderObject finderObject = (FinderObject) kotlin.a.j.kt(linkedList);
                            if (finderObject != null) {
                                FinderItem.a aVar = FinderItem.Companion;
                                y yVar = y.vXH;
                                FinderItem a2 = FinderItem.a.a(finderObject, y.LL(fVar2.dLS));
                                c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                                BaseFinderFeed s = c.a.s(a2);
                                LinkedList linkedList2 = new LinkedList();
                                linkedList2.addAll(s.feedObject.getMediaList());
                                o oVar = new o(s, kotlin.a.j.v((Collection) linkedList2));
                                LinkedList linkedList3 = new LinkedList();
                                linkedList3.add(oVar);
                                s.feedObject.setReplaceLongVideoToNormal(y.a(y.vXH, fVar2.dLS, 0, 2));
                                FeedData.a aVar3 = FeedData.Companion;
                                ((com.tencent.mm.plugin.finder.preload.worker.b) fVar2.tGg.getValue()).a(FeedData.a.i(s.feedObject), kotlin.a.j.v((Collection) linkedList3), 0);
                            }
                        }
                        MediaPreloadCore.a aVar4 = MediaPreloadCore.uTV;
                        if (MediaPreloadCore.dlF()) {
                            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                            if (com.tencent.mm.plugin.finder.storage.c.dsm()) {
                                com.tencent.mm.ac.d.h(new k(cVar));
                            }
                        }
                        Log.i(this.uVn.TAG, "[onCgiBack] tabType=" + this.uVn.dLS + " preload successfully! size=" + fVar.object.size() + " cache=" + this.uVn.uVg);
                    } else {
                        Log.e(this.uVn.TAG, "[onCgiBack] tabType=" + this.uVn.dLS + " preload fail! list is empty! cache=" + this.uVn.uVg);
                    }
                } catch (Throwable th) {
                    f.b(this.uVn, this.uVC);
                    this.twV.invoke(d.OK);
                    if (fVar.LMO != null) {
                        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh, "MMKernel.storage()");
                        ao azQ = aAh.azQ();
                        ar.a aVar5 = ar.a.USERINFO_FINDER_TIMELINE_PRELOAD_REFRESH_CONFIG_STRING_SYNC;
                        bcy bcy = fVar.LMO;
                        azQ.set(aVar5, Util.encodeHexString(bcy != null ? bcy.toByteArray() : null));
                        this.uVn.a(this.uVn.dLS, FinderStreamTabPreloadCore.dlI());
                    }
                    this.uVn.isLoading = false;
                    this.uVn.dgF.signalAll();
                    this.uVn.dgE.unlock();
                    AppMethodBeat.o(249605);
                    throw th;
                }
            } else {
                this.uVn.nM(true);
                Log.e(this.uVn.TAG, "[onCgiBack] tabType=" + this.uVn.dLS + " preload fail! errType=" + i2 + " errCode=" + i3 + " cache=" + this.uVn.uVg);
            }
            f.b(this.uVn, this.uVC);
            this.twV.invoke(d.OK);
            if (fVar.LMO != null) {
                com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                ao azQ2 = aAh2.azQ();
                ar.a aVar6 = ar.a.USERINFO_FINDER_TIMELINE_PRELOAD_REFRESH_CONFIG_STRING_SYNC;
                bcy bcy2 = fVar.LMO;
                azQ2.set(aVar6, Util.encodeHexString(bcy2 != null ? bcy2.toByteArray() : null));
                this.uVn.a(this.uVn.dLS, FinderStreamTabPreloadCore.dlI());
            }
            this.uVn.isLoading = false;
            this.uVn.dgF.signalAll();
            this.uVn.dgE.unlock();
            AppMethodBeat.o(249605);
        }
    }

    public boolean a(c cVar, aa.f fVar) {
        p.h(cVar, "source");
        p.h(fVar, "resp");
        return true;
    }

    /* JADX INFO: finally extract failed */
    public final aa.f JP(int i2) {
        boolean z;
        String str = this.TAG;
        StringBuilder append = new StringBuilder("[request] scene=").append(this.dLS).append(", isPreloading:").append(this.isLoading).append(" cache=").append(this.uVg).append(" isLocked=").append(this.dgE.isLocked()).append(" fakeWaitForRefresh=");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        Log.i(str, append.append(com.tencent.mm.plugin.finder.storage.c.dty().value().longValue()).append("ms ").toString());
        this.dgE.lock();
        try {
            if (this.isLoading) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.dgF.await(1, TimeUnit.MINUTES);
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                long longValue = com.tencent.mm.plugin.finder.storage.c.dty().value().longValue() - (SystemClock.uptimeMillis() - uptimeMillis);
                Log.i(this.TAG, "requestCache: loading delay = ".concat(String.valueOf(longValue)));
                if (longValue > 0) {
                    this.dgF.await(longValue, TimeUnit.MILLISECONDS);
                }
            } else if (this.uVg.uVi != null) {
                String str2 = this.TAG;
                StringBuilder sb = new StringBuilder("requestCache: force wait ");
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                Log.i(str2, sb.append(com.tencent.mm.plugin.finder.storage.c.dty().value().longValue()).append(LocaleUtil.MALAY).toString());
                Condition condition = this.dgF;
                com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                condition.await(com.tencent.mm.plugin.finder.storage.c.dty().value().longValue(), TimeUnit.MILLISECONDS);
            }
            this.dgE.unlock();
            z.f fVar = new z.f();
            fVar.SYG = (T) this.uVg.uVi;
            if (!(this.uVg.uVj == c.EnterLoad)) {
                T t = fVar.SYG;
                if (t != null) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
                    p.g(viewModel, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
                    LinkedList linkedList = ((aa.f) t).object;
                    p.g(linkedList, "it.`object`");
                    com.tencent.mm.ac.d.a(linkedList, (kotlin.g.a.b) new j((FinderTabStreamUnreadVM) viewModel, this, fVar));
                    int size = ((aa.f) t).object.size();
                    com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (size < com.tencent.mm.plugin.finder.storage.c.hUQ().value().intValue()) {
                        Log.w(this.TAG, "requestCache: cache after filter read feed is less than 3, abandon it");
                        nM(true);
                        fVar.SYG = null;
                    }
                }
                if (fVar.SYG != null) {
                    z = true;
                } else {
                    z = false;
                }
                int i3 = this.dLS;
                long j2 = this.uVg.uVl;
                if (i2 == 0) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(i3) + 1, 1, false);
                    if (!z) {
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(i3) + 2, 1, false);
                    } else {
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(i3) + 3, 1, false);
                    }
                } else if (i2 == 1) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(i3) + 4, 1, false);
                    if (!z) {
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(i3) + 5, 1, false);
                    } else {
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(i3) + 6, 1, false);
                    }
                }
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(i3) + 7, 1, false);
                if (!z) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(i3) + 8, 1, false);
                } else {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(i3) + 9, 1, false);
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1421, JQ(i3) + 10, 1 + j2, false);
                }
                if (fVar.SYG != null) {
                    int i4 = this.uVg.dLS;
                    T t2 = fVar.SYG;
                    new com.tencent.mm.plugin.finder.cgi.g(i4, t2 != null ? ((aa.f) t2).lastBuffer : null).aYI();
                }
            }
            nM(false);
            return fVar.SYG;
        } catch (Throwable th) {
            this.dgE.unlock();
            throw th;
        }
    }

    public final boolean nM(boolean z) {
        LinkedList linkedList;
        LinkedList<FinderObject> linkedList2;
        this.dgE.lock();
        try {
            boolean z2 = this.uVg.uVi != null;
            if (z) {
                LinkedList linkedList3 = new LinkedList();
                aa.f fVar = this.uVg.uVi;
                if (!(fVar == null || (linkedList2 = fVar.object) == null)) {
                    for (FinderObject finderObject : linkedList2) {
                        FinderItem.a aVar = FinderItem.Companion;
                        p.g(finderObject, LocaleUtil.ITALIAN);
                        y yVar = y.vXH;
                        FinderItem a2 = FinderItem.a.a(finderObject, y.LL(this.dLS));
                        c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                        linkedList3.add(c.a.s(a2));
                    }
                }
                aa.f fVar2 = this.uVg.uVi;
                if (!(fVar2 == null || (linkedList = fVar2.object) == null)) {
                    this.uVg.uVk.addAll(linkedList);
                    this.uVg.uVl++;
                }
                y yVar2 = y.vXH;
                int i2 = this.dLS;
                LinkedList linkedList4 = linkedList3;
                bbn bbn = new bbn();
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                bbn.tCE = com.tencent.mm.plugin.finder.report.k.Kw(this.dLS);
                y.a(i2, linkedList4, bbn);
            } else {
                this.uVg.uVl = 0;
            }
            if (z2) {
                Log.i(this.TAG, "[clear] tabType=" + this.dLS + " cache=" + this.uVg + " isRecycle=" + z);
            }
            this.uVg.uVi = null;
            this.uVg.uVj = null;
            return z2;
        } finally {
            this.dgE.unlock();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "", "lastTime", "", "(J)V", "getLastTime", "()J", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class b {
        private final long hwQ;

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof b) && this.hwQ == ((b) obj).hwQ);
        }

        public final int hashCode() {
            long j2 = this.hwQ;
            return (int) (j2 ^ (j2 >>> 32));
        }

        public final String toString() {
            AppMethodBeat.i(249593);
            String str = "CacheTime(lastTime=" + this.hwQ + ")";
            AppMethodBeat.o(249593);
            return str;
        }

        public b(long j2) {
            this.hwQ = j2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020'*\u00020%2\u0006\u0010+\u001a\u00020)R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$Cache;", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker;I)V", "lastTime", "", "getLastTime", "()J", "setLastTime", "(J)V", "overCount", "getOverCount", "setOverCount", "records", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$CacheTime;", "recycledList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getRecycledList", "()Ljava/util/LinkedList;", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "getResp", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "setResp", "(Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;)V", "source", "Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "getSource", "()Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;", "setSource", "(Lcom/tencent/mm/plugin/finder/preload/tabPreload/TabPreloadWorker$PreloadSource;)V", "getTabType", "()I", "restoreTime", "Lcom/tencent/mm/protocal/protobuf/FinderRefreshPreloadCacheList;", "storeTime", "", "toString", "", SharePatchInfo.FINGER_PRINT, "tag", "plugin-finder_release"})
    public final class a {
        final int dLS;
        long hwQ;
        public aa.f uVi;
        c uVj;
        final LinkedList<FinderObject> uVk = new LinkedList<>();
        long uVl;
        final ConcurrentHashMap<Integer, b> uVm = new ConcurrentHashMap<>();

        public a(int i2) {
            AppMethodBeat.i(249592);
            this.dLS = i2;
            bbl dlL = dlL();
            LinkedList<bbk> linkedList = dlL.LKS;
            p.g(linkedList, "refreshPreloadCacheList.caches");
            ArrayList<bbk> arrayList = new ArrayList();
            for (T t : linkedList) {
                if (t.dLS == this.dLS) {
                    arrayList.add(t);
                }
            }
            for (bbk bbk : arrayList) {
                this.uVm.put(Integer.valueOf(bbk.source), new b(bbk.iVn));
            }
            a(dlL, "build");
            AppMethodBeat.o(249592);
        }

        public final String toString() {
            Integer num;
            AppMethodBeat.i(249589);
            StringBuilder append = new StringBuilder("[").append(this.uVj).append(", resp=");
            aa.f fVar = this.uVi;
            if (fVar != null) {
                num = Integer.valueOf(fVar.hashCode());
            } else {
                num = null;
            }
            StringBuilder append2 = append.append(num).append(", lastTime=").append(this.hwQ).append(", overCount=").append(this.uVl).append(", recycledList=");
            LinkedList<FinderObject> linkedList = this.uVk;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList, 10));
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.mm.ac.d.zs(it.next().id));
            }
            String sb = append2.append(arrayList).append(']').toString();
            AppMethodBeat.o(249589);
            return sb;
        }

        /* access modifiers changed from: package-private */
        public final bbl dlL() {
            AppMethodBeat.i(249590);
            bbl bbl = new bbl();
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_TIMELINE_PRELOAD_REFRESH_CACHE_STRING, "");
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(249590);
                throw tVar;
            }
            String str = (String) obj;
            if (str.length() > 0) {
                try {
                    bbl.parseFrom(Util.decodeHexString(str));
                } catch (Exception e2) {
                    Log.printErrStackTrace(f.this.TAG, e2, "", new Object[0]);
                    com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(ar.a.USERINFO_FINDER_TIMELINE_PRELOAD_REFRESH_CACHE_STRING, (Object) null);
                }
            }
            AppMethodBeat.o(249590);
            return bbl;
        }

        public final void a(bbl bbl, String str) {
            AppMethodBeat.i(249591);
            p.h(bbl, "$this$print");
            p.h(str, "tag");
            String str2 = f.this.TAG;
            StringBuilder append = new StringBuilder("[FinderRefreshPreloadCacheList#print] tag=").append(str).append(' ');
            LinkedList<bbk> linkedList = bbl.LKS;
            p.g(linkedList, "this.caches");
            ArrayList arrayList = new ArrayList();
            for (T t : linkedList) {
                if (t.dLS == this.dLS) {
                    arrayList.add(t);
                }
            }
            ArrayList<bbk> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
            for (bbk bbk : arrayList2) {
                arrayList3.add(bbk.dLS + ':' + bbk.source + "=>" + bbk.iVn);
            }
            Log.i(str2, append.append(arrayList3).toString());
            AppMethodBeat.o(249591);
        }
    }

    private static long JQ(int i2) {
        switch (i2) {
            case 1:
                return 20;
            case 2:
                return 60;
            case 3:
            default:
                return 0;
            case 4:
                return 40;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "invoke"})
    static final class i extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.extension.reddot.f> {
        public static final i uVD = new i();

        static {
            AppMethodBeat.i(249608);
            AppMethodBeat.o(249608);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.extension.reddot.f invoke() {
            AppMethodBeat.i(249607);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.f redDotManager = ((PluginFinder) ah).getRedDotManager();
            AppMethodBeat.o(249607);
            return redDotManager;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "invoke"})
    static final class h extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.worker.b> {
        final /* synthetic */ f uVn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(f fVar) {
            super(0);
            this.uVn = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.preload.worker.b invoke() {
            AppMethodBeat.i(249606);
            com.tencent.mm.plugin.finder.preload.worker.b bVar = new com.tencent.mm.plugin.finder.preload.worker.b(((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel(), "tab=" + this.uVn.dLS);
            AppMethodBeat.o(249606);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c uVC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(c cVar) {
            super(0);
            this.uVC = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(249610);
            if (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                u.makeText(MMApplicationContext.getContext(), "hit preload cache. source:" + this.uVC, 1).show();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(249610);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(f fVar, c cVar) {
        T t;
        boolean z;
        fVar.uVg.uVj = cVar;
        a aVar = fVar.uVg;
        p.h(cVar, "source");
        aVar.hwQ = cl.aWA();
        aVar.uVm.put(Integer.valueOf(cVar.value), new b(aVar.hwQ));
        bbl dlL = aVar.dlL();
        LinkedList<bbk> linkedList = dlL.LKS;
        p.g(linkedList, "list.caches");
        Iterator<T> it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (next.source == cVar.value) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 == null) {
            t2 = new bbk();
            dlL.LKS.add(t2);
        }
        t2.source = cVar.value;
        t2.iVn = aVar.hwQ;
        t2.dLS = aVar.dLS;
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_TIMELINE_PRELOAD_REFRESH_CACHE_STRING, Util.encodeHexString(dlL.toByteArray()));
        aVar.a(dlL, "storeTime");
    }
}
