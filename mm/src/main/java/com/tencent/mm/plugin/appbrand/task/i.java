package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.af.g;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService1;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService2;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService3;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService4;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService1;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService2;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService3;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService4;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService1;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService2;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService3;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService4;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.plugin.appbrand.task.preload.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI4;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI4;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI00;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI01;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI02;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI03;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI04;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.af;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0002RSB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u001a\u0010\u001c\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u001d\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010!2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*H\u0002J,\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0002J\u0013\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070/H\u0016¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\u0010H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010,\u001a\u00020*2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010-\u001a\u00020*H\u0002J \u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u0007H\u0002J\u0010\u00106\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\nH\u0016J\b\u00107\u001a\u00020\u0005H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0014H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\u0012\u0010:\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010;\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010<\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010=\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010>\u001a\u00020\u0017H\u0016J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020E2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010F\u001a\u00020GH\u0016J\u0018\u0010C\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010F\u001a\u00020GH\u0016J*\u0010H\u001a\u00020\u00052\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010D\u001a\u00020E2\u0006\u0010K\u001a\u00020L2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010M\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u00105\u001a\u0004\u0018\u00010\u00072\b\u0010<\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010N\u001a\u00020\u00052\u0006\u0010F\u001a\u00020G2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010O\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010O\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010P\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010@\u001a\u00020AH\u0016J \u0010P\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010@\u001a\u00020A2\u0006\u0010Q\u001a\u00020*H\u0016¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2;", "Lcom/tencent/mm/plugin/appbrand/task/IAppBrandTaskManager;", "Lcom/tencent/mm/plugin/appbrand/task/IAppBrandTaskManager$InternalFunctions;", "()V", "clearDuplicatedApp", "", "appId", "", "closeTaskByAppId", "versionType", "", "findForegroundServiceClassByUIClassName", "Ljava/lang/Class;", "uiClassName", "findKeepAliveServiceClassByUIClassName", "findPersistentAppTask", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUIProcess;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "findTaskByAppIdAndClassName", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;", "cls", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "findTaskByClassName", "findTaskByClassNameWithType", "serviceType", "finishAllTask", "finishByPersistentTaskController", "finishTaskByAppId", "debugType", "getAliveInstanceId", "getAliveTaskIndentity", "Landroid/util/Pair;", "getAliveTaskRemoteController", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "getAllTaskUsingCommLibVersion", "", "getAvailableTaskToStartup", "getAvailableTaskToStartupImpl", "getPluginTaskToStartup", "isWeishiApp", "", "getStartStrategyAndTask", "isPluginTask", "startAsHalfScreen", "getTaskInfoList", "", "()[Ljava/lang/String;", "getWeishiTask", "interceptTargetTaskForPersistentApp", "isProcessMatchPersistentUsage", "task", "processName", "killAll", "killEmptyProcess", "moveToRear", "onNetworkChange", "onRuntimeFinish", "popPersistentApp", "controller", "preloadDelayedByClassName", "preloadType", "preloadPluginUIProcess", "scene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "removeApp", "startApp", "ctx", "Landroid/content/Context;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "startTargetActivity", "preLoadingLogic", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;", "intent", "Landroid/content/Intent;", "stashPersistentApp", "stripSceneNote", "taskAlive", "tryPreloadNextTaskProcess", "ignoreFrequencyLimit", "AppBrandTaskManagerFactory", "Companion", "plugin-appbrand-integration_release"})
public final class i implements p, p.a {
    private static LinkedList<m> nPK = new LinkedList<>();
    private static final ConcurrentHashMap<String, String> nPN = new ConcurrentHashMap<>();
    private static final LinkedList<m> nPW;
    private static final HashSet<String> nPX = new HashSet<>();
    private static final c nPY = new c(d.nQd);
    public static final b nPZ = new b((byte) 0);

    public static final LinkedList<m> bWj() {
        AppMethodBeat.i(229445);
        LinkedList<m> bWj = b.bWj();
        AppMethodBeat.o(229445);
        return bWj;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "hitLimitByCounter", "", "hitLimitByMemoryPressure", "invoke"})
    public static final class f extends q implements m<Boolean, Boolean, x> {
        final /* synthetic */ boolean nQf;
        final /* synthetic */ g nQg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(boolean z, g gVar) {
            super(2);
            this.nQf = z;
            this.nQg = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, Boolean bool2) {
            AppMethodBeat.i(229410);
            boolean booleanValue = bool.booleanValue();
            boolean booleanValue2 = bool2.booleanValue();
            if (!this.nQf) {
                e.a.C0800a aVar = e.a.nRc;
                com.tencent.mm.plugin.appbrand.task.preload.e.a(e.a.C0800a.A(this.nQg), booleanValue, booleanValue2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(229410);
            return xVar;
        }
    }

    private i() {
        AppMethodBeat.i(229443);
        if (BuildInfo.DEBUG || ((int) System.currentTimeMillis()) % 10 == 0) {
            c cVar = c.nOr;
            c.c(AnonymousClass1.nQa);
        }
        AppMethodBeat.o(229443);
    }

    public /* synthetic */ i(byte b2) {
        this();
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2$AppBrandTaskManagerFactory;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2;", "getINSTANCE", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2;", "plugin-appbrand-integration_release"})
    public static final class a {
        private static final i nQb = new i((byte) 0);
        public static final a nQc = new a();

        static {
            AppMethodBeat.i(229394);
            AppMethodBeat.o(229394);
        }

        private a() {
        }

        public static i bWk() {
            return nQb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000eH\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0002¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2$Companion;", "", "()V", "PERSISTENT_APPIDS_MAP", "Ljava/util/concurrent/ConcurrentHashMap;", "", "PERSISTENT_TASK_CONTROLLERS", "com/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2$Companion$PERSISTENT_TASK_CONTROLLERS$1", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2$Companion$PERSISTENT_TASK_CONTROLLERS$1;", "START_AS_HALF_SCREEN_APPS", "Ljava/util/HashSet;", "TAG", "TASK_LIST", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUIProcess;", "getTASK_LIST", "()Ljava/util/LinkedList;", "setTASK_LIST", "(Ljava/util/LinkedList;)V", "UNKNOWN_TYPE_EXCEPTION", "allRunningTask", "allRunningTask$annotations", "getAllRunningTask", "instance", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2;", "getInstance", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2;", "runningTaskList", "runningTaskList$annotations", "findTaskByAppId", "appId", "getAmountOfTasksUsedAs", "", "serviceType", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "getAvailableTaskToPreload", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;", "isReachedServiceTypeMaxLimit", "", "moveToFront", "", "task", "plugin-appbrand-integration_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static final /* synthetic */ m afn(String str) {
            AppMethodBeat.i(229407);
            m afm = afm(str);
            AppMethodBeat.o(229407);
            return afm;
        }

        static int s(g gVar) {
            AppMethodBeat.i(229402);
            int i2 = 0;
            Iterator it = i.nPK.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                kotlin.g.b.p.g(mVar, "uiTask");
                if (mVar.bWq() == gVar) {
                    i2++;
                } else {
                    i2 = i2;
                }
            }
            AppMethodBeat.o(229402);
            return i2;
        }

        static boolean t(g gVar) {
            AppMethodBeat.i(229403);
            int s = s(gVar);
            if (!(s <= gVar.nPG)) {
                String safeFormatString = Util.safeFormatString("TaskManager count the serviceType [%s] in TASK_LIST, count = [%d], but max limit = [%d]", gVar.name(), Integer.valueOf(s), Integer.valueOf(gVar.nPG));
                kotlin.g.b.p.g(safeFormatString, "Util.safeFormatString(\"T…nt, serviceType.maxLimit)");
                IllegalStateException illegalStateException = new IllegalStateException(safeFormatString.toString());
                AppMethodBeat.o(229403);
                throw illegalStateException;
            } else if (s == gVar.nPG) {
                AppMethodBeat.o(229403);
                return true;
            } else {
                AppMethodBeat.o(229403);
                return false;
            }
        }

        static m afm(String str) {
            AppMethodBeat.i(229405);
            Iterator<m> it = bWj().iterator();
            while (it.hasNext()) {
                m next = it.next();
                kotlin.g.b.p.g(next, "task");
                if (next.bWw().contains(str)) {
                    AppMethodBeat.o(229405);
                    return next;
                }
            }
            AppMethodBeat.o(229405);
            return null;
        }

        public static LinkedList<m> bWj() {
            LinkedList<m> linkedList;
            AppMethodBeat.i(229406);
            synchronized (i.nPW) {
                try {
                    linkedList = new LinkedList<>(i.nPW);
                } finally {
                    AppMethodBeat.o(229406);
                }
            }
            return linkedList;
        }

        static n u(g gVar) {
            Object obj;
            boolean z;
            Object obj2;
            boolean z2;
            AppMethodBeat.i(229404);
            synchronized (i.nPK) {
                try {
                    b bVar = i.nPZ;
                    if (t(gVar)) {
                        Log.i("MicroMsg.AppBrandTaskManagerV2", "tryPreloadNextTaskProcess serviceType = [%s] reachedMaxLimit", gVar);
                        return null;
                    }
                    b bVar2 = i.nPZ;
                    Iterator it = i.nPK.iterator();
                    while (it.hasNext()) {
                        m mVar = (m) it.next();
                        kotlin.g.b.p.g(mVar, "uiTask");
                        if (mVar.bWp() && mVar.bWq() == gVar) {
                            Log.i("MicroMsg.AppBrandTaskManagerV2", "getAvailableTaskToPreload found empty task[%s], which can be used as [%s]", mVar.bWo(), gVar);
                            m mVar2 = mVar;
                            AppMethodBeat.o(229404);
                            return mVar2;
                        }
                    }
                    if (gVar != g.WAGAME || !com.tencent.mm.plugin.appbrand.ui.p.bXv()) {
                        b bVar3 = i.nPZ;
                        Iterator it2 = i.nPK.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            Object next = it2.next();
                            m mVar3 = (m) next;
                            if (mVar3.bWq() == g.NIL && (mVar3.bWn() == null || mVar3.bWn() == g.WASERVICE || mVar3.bWn() == g.NIL)) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                obj = next;
                                break;
                            }
                        }
                        m mVar4 = (m) obj;
                        Object[] objArr = new Object[2];
                        objArr[0] = gVar;
                        objArr[1] = mVar4 == null ? BuildConfig.COMMAND : mVar4.bWr();
                        Log.i("MicroMsg.AppBrandTaskManagerV2", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", objArr);
                        m mVar5 = mVar4;
                        AppMethodBeat.o(229404);
                        return mVar5;
                    }
                    b bVar4 = i.nPZ;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj3 : i.nPK) {
                        if (((m) obj3).bWn() == g.WAGAME) {
                            arrayList.add(obj3);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    Iterator it3 = arrayList2.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        Object next2 = it3.next();
                        m mVar6 = (m) next2;
                        if (!MMApplicationContext.isProcessExist(mVar6.bWo()) || !mVar6.bWp()) {
                            z2 = false;
                            continue;
                        } else {
                            z2 = true;
                            continue;
                        }
                        if (z2) {
                            obj2 = next2;
                            break;
                        }
                    }
                    m mVar7 = (m) obj2;
                    if (mVar7 == null) {
                        mVar7 = (m) j.ks(arrayList2);
                    }
                    m mVar8 = mVar7;
                    AppMethodBeat.o(229404);
                    return mVar8;
                } finally {
                    AppMethodBeat.o(229404);
                }
            }
        }
    }

    static {
        AppMethodBeat.i(229444);
        if (com.tencent.mm.plugin.appbrand.ui.p.bXw()) {
            nPK.add(new m(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
            nPK.add(new m(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class, AppBrandPluginUI3.class));
            nPK.add(new m(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class, AppBrandPluginUI4.class));
            nPK.add(new m(AppBrandUI03.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
            nPK.add(new m(AppBrandUI04.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
        } else if (com.tencent.mm.plugin.appbrand.ui.p.bXv()) {
            nPK.add(new m(AppBrandUI00.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
            nPK.add(new m(AppBrandUI01.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
            nPK.add(new m(AppBrandUI02.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
            nPK.add(new m(AppBrandUI03.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
            nPK.add(new m(AppBrandUI04.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
            m mVar = new m(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class);
            m mVar2 = new m(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class, AppBrandForegroundNotificationService1.class, AppBrandProcessTriggerService1.class, AppBrandPreLoadingUI1.class, AppBrandPluginUI1.class);
            m mVar3 = new m(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class, AppBrandForegroundNotificationService2.class, AppBrandProcessTriggerService2.class, AppBrandPreLoadingUI2.class, AppBrandPluginUI2.class);
            m mVar4 = new m(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class, AppBrandPluginUI3.class);
            m mVar5 = new m(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class, AppBrandPluginUI4.class);
            mVar.y(g.WAGAME);
            mVar2.y(g.WAGAME);
            mVar3.y(g.WAGAME);
            mVar4.y(g.WAGAME);
            mVar5.y(g.WAGAME);
            int bVW = g.bVW();
            if (bVW > 0) {
                nPK.add(mVar);
            }
            if (bVW >= 2) {
                nPK.add(mVar2);
            }
            if (bVW >= 3) {
                nPK.add(mVar3);
            }
            if (bVW >= 4) {
                nPK.add(mVar4);
            }
            if (bVW >= 5) {
                nPK.add(mVar5);
            }
        } else {
            nPK.add(new m(AppBrandUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingUI.class, AppBrandPluginUI.class));
            nPK.add(new m(AppBrandUI1.class, AppBrandTaskPreloadReceiver1.class, AppBrandKeepAliveService1.class, AppBrandForegroundNotificationService1.class, AppBrandProcessTriggerService1.class, AppBrandPreLoadingUI1.class, AppBrandPluginUI1.class));
            nPK.add(new m(AppBrandUI2.class, AppBrandTaskPreloadReceiver2.class, AppBrandKeepAliveService2.class, AppBrandForegroundNotificationService2.class, AppBrandProcessTriggerService2.class, AppBrandPreLoadingUI2.class, AppBrandPluginUI2.class));
            nPK.add(new m(AppBrandUI3.class, AppBrandTaskPreloadReceiver3.class, AppBrandKeepAliveService3.class, AppBrandForegroundNotificationService3.class, AppBrandProcessTriggerService3.class, AppBrandPreLoadingUI3.class, AppBrandPluginUI3.class));
            nPK.add(new m(AppBrandUI4.class, AppBrandTaskPreloadReceiver4.class, AppBrandKeepAliveService4.class, AppBrandForegroundNotificationService4.class, AppBrandProcessTriggerService4.class, AppBrandPreLoadingUI4.class, AppBrandPluginUI4.class));
        }
        LinkedList<m> linkedList = new LinkedList<>();
        nPW = linkedList;
        linkedList.addAll(nPK);
        AppMethodBeat.o(229444);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/task/AppBrandTaskManagerV2$Companion$PERSISTENT_TASK_CONTROLLERS$1", "Ljava/util/concurrent/ConcurrentSkipListSet;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "add", "", "element", "plugin-appbrand-integration_release"})
    public static final class c extends ConcurrentSkipListSet<AppBrandRemoteTaskController> {
        c(Comparator comparator) {
            super(comparator);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.util.AbstractCollection, java.util.concurrent.ConcurrentSkipListSet, java.util.Collection, java.util.Set
        public final /* synthetic */ boolean add(AppBrandRemoteTaskController appBrandRemoteTaskController) {
            AppMethodBeat.i(229396);
            boolean b2 = b(appBrandRemoteTaskController);
            AppMethodBeat.o(229396);
            return b2;
        }

        public final /* bridge */ boolean contains(Object obj) {
            AppMethodBeat.i(229397);
            if (!(obj != null ? obj instanceof AppBrandRemoteTaskController : true)) {
                AppMethodBeat.o(229397);
                return false;
            }
            boolean contains = super.contains((AppBrandRemoteTaskController) obj);
            AppMethodBeat.o(229397);
            return contains;
        }

        public final /* bridge */ boolean remove(Object obj) {
            AppMethodBeat.i(229398);
            if (!(obj != null ? obj instanceof AppBrandRemoteTaskController : true)) {
                AppMethodBeat.o(229398);
                return false;
            }
            boolean remove = super.remove((AppBrandRemoteTaskController) obj);
            AppMethodBeat.o(229398);
            return remove;
        }

        public final boolean b(AppBrandRemoteTaskController appBrandRemoteTaskController) {
            boolean z;
            AppMethodBeat.i(229395);
            if (appBrandRemoteTaskController != null) {
                String appId = appBrandRemoteTaskController.getAppId();
                if (appId == null || appId.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    boolean add = super.add(appBrandRemoteTaskController);
                    AppMethodBeat.o(229395);
                    return add;
                }
            }
            Log.e("MicroMsg.AppBrandTaskManagerV2", "PERSISTENT_TASK_CONTROLLERS.add get invalid element, appId:" + (appBrandRemoteTaskController != null ? appBrandRemoteTaskController.getAppId() : null) + ", stack:" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(229395);
            return false;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.i(229399);
            int size = super.size();
            AppMethodBeat.o(229399);
            return size;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "kotlin.jvm.PlatformType", "o2", "compare"})
    static final class d<T> implements Comparator<AppBrandRemoteTaskController> {
        public static final d nQd = new d();

        static {
            AppMethodBeat.i(229401);
            AppMethodBeat.o(229401);
        }

        d() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AppBrandRemoteTaskController appBrandRemoteTaskController, AppBrandRemoteTaskController appBrandRemoteTaskController2) {
            AppMethodBeat.i(229400);
            AppBrandRemoteTaskController appBrandRemoteTaskController3 = appBrandRemoteTaskController;
            AppBrandRemoteTaskController appBrandRemoteTaskController4 = appBrandRemoteTaskController2;
            kotlin.g.b.p.g(appBrandRemoteTaskController3, "o1");
            String appId = appBrandRemoteTaskController3.getAppId();
            kotlin.g.b.p.g(appBrandRemoteTaskController4, "o2");
            String appId2 = appBrandRemoteTaskController4.getAppId();
            kotlin.g.b.p.g(appId2, "o2.appId");
            int compareTo = appId.compareTo(appId2);
            if (compareTo == 0) {
                int brf = appBrandRemoteTaskController3.brf() - appBrandRemoteTaskController4.brf();
                AppMethodBeat.o(229400);
                return brf;
            }
            AppMethodBeat.o(229400);
            return compareTo;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void a(String str, String str2, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.i(229411);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(229411);
            return;
        }
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        if (str2 == null) {
            kotlin.g.b.p.hyc();
        }
        nPN.put(str, str2);
        if (appBrandRemoteTaskController != null) {
            Log.i("MicroMsg.AppBrandTaskManagerV2", "stashPersistentApp, appId:" + str + ", processName:" + str2 + ", controller.id:" + appBrandRemoteTaskController.bjl());
            nPY.remove(appBrandRemoteTaskController);
            nPY.b(appBrandRemoteTaskController);
        }
        AppMethodBeat.o(229411);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void a(String str, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.i(229412);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(229412);
            return;
        }
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        nPN.remove(str);
        if (appBrandRemoteTaskController != null) {
            Log.i("MicroMsg.AppBrandTaskManagerV2", "popPersistentApp appId:" + str + " controller:" + appBrandRemoteTaskController + " stack:" + android.util.Log.getStackTraceString(new Throwable()));
            nPY.remove(appBrandRemoteTaskController);
        }
        AppMethodBeat.o(229412);
    }

    private static void ck(String str, int i2) {
        AppMethodBeat.i(229413);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(229413);
            return;
        }
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        Iterator it = nPY.iterator();
        kotlin.g.b.p.g(it, "PERSISTENT_TASK_CONTROLLERS.iterator()");
        LinkedList<AppBrandRemoteTaskController> linkedList = new LinkedList();
        while (it.hasNext()) {
            AppBrandRemoteTaskController appBrandRemoteTaskController = (AppBrandRemoteTaskController) it.next();
            if (kotlin.g.b.p.j(str, appBrandRemoteTaskController.getAppId()) && (i2 == appBrandRemoteTaskController.brf() || i2 < 0)) {
                appBrandRemoteTaskController.afa(str);
                linkedList.add(appBrandRemoteTaskController);
            }
        }
        for (AppBrandRemoteTaskController appBrandRemoteTaskController2 : linkedList) {
            nPY.remove(appBrandRemoteTaskController2);
        }
        AppMethodBeat.o(229413);
    }

    private static m k(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(229414);
        g j2 = g.j(appBrandInitConfigWC);
        if (nPN.containsKey(appBrandInitConfigWC.appId)) {
            String str = nPN.get(appBrandInitConfigWC.appId);
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(229414);
                return null;
            }
            Iterator<m> it = nPK.iterator();
            while (it.hasNext()) {
                m next = it.next();
                kotlin.g.b.p.g(next, "task");
                kotlin.g.b.p.g(j2, "type");
                if (str == null) {
                    kotlin.g.b.p.hyc();
                }
                if (a(next, j2, str)) {
                    AppMethodBeat.o(229414);
                    return next;
                }
            }
        }
        AppMethodBeat.o(229414);
        return null;
    }

    private static boolean a(m mVar, g gVar, String str) {
        AppMethodBeat.i(229415);
        if (!kotlin.g.b.p.j(mVar.bWo(), str) || (!(mVar.bWq() == gVar || mVar.bWq() == g.NIL) || !mVar.c(gVar))) {
            AppMethodBeat.o(229415);
            return false;
        }
        AppMethodBeat.o(229415);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final int g(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(229416);
        kotlin.g.b.p.h(appBrandInitConfigWC, "cfg");
        kotlin.g.b.p.h(appBrandStatObject, "stat");
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        int d2 = d(context, appBrandInitConfigWC, appBrandStatObject);
        AppMethodBeat.o(229416);
        return d2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r1.intValue() == r5) goto L_0x0037;
     */
    @Override // com.tencent.mm.plugin.appbrand.task.p
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cl(java.lang.String r4, int r5) {
        /*
            r3 = this;
            r2 = 229418(0x3802a, float:3.21483E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0013
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0012:
            return
        L_0x0013:
            if (r4 != 0) goto L_0x0018
            kotlin.g.b.p.hyc()
        L_0x0018:
            com.tencent.mm.plugin.appbrand.task.m r0 = com.tencent.mm.plugin.appbrand.task.i.b.afm(r4)
            if (r0 != 0) goto L_0x0025
            ck(r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0012
        L_0x0025:
            if (r5 < 0) goto L_0x0037
            java.lang.Integer r1 = r0.afo(r4)
            if (r1 != 0) goto L_0x0031
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0012
        L_0x0031:
            int r1 = r1.intValue()
            if (r1 != r5) goto L_0x0044
        L_0x0037:
            com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController r1 = r0.afq(r4)
            if (r1 == 0) goto L_0x0044
            com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController r0 = r0.afq(r4)
            r0.afa(r4)
        L_0x0044:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.task.i.cl(java.lang.String, int):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void bVX() {
        AppMethodBeat.i(229419);
        Iterator<m> it = b.bWj().iterator();
        while (it.hasNext()) {
            m next = it.next();
            kotlin.g.b.p.g(next, "task");
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : next.bWx()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.zl(4);
                }
            }
        }
        AppMethodBeat.o(229419);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void zn(int i2) {
        AppMethodBeat.i(229420);
        if (2 == i2) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            Iterator<m> it = b.bWj().iterator();
            while (it.hasNext()) {
                m next = it.next();
                kotlin.g.b.p.g(next, "task");
                if (!TextUtils.isEmpty(next.bWo())) {
                    if (next.bWp()) {
                        concurrentHashMap.putIfAbsent(next.bWo(), Boolean.TRUE);
                    } else {
                        String bWo = next.bWo();
                        kotlin.g.b.p.g(bWo, "task.uiProcessName");
                        Boolean bool = Boolean.FALSE;
                        kotlin.g.b.p.g(bool, "java.lang.Boolean.FALSE");
                        concurrentHashMap.put(bWo, bool);
                    }
                }
            }
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                String str = (String) entry.getKey();
                if (((Boolean) entry.getValue()).booleanValue()) {
                    Log.i("MicroMsg.AppBrandTaskManagerV2", "killAll SILENT_IF_INACTIVE kill process(%s)", str);
                    com.tencent.mm.modelappbrand.b.Lm(str);
                    com.tencent.mm.bv.a.cs(MMApplicationContext.getContext(), str);
                }
            }
            Log.i("MicroMsg.AppBrandTaskManagerV2", "killAll SILENT_IF_INACTIVE tryPreloadNextTaskProcess(both waservice and wagame)");
            a(g.WASERVICE, z.APPBRAND_PROCESS_RESTART, true);
            a(g.WAGAME, z.APPBRAND_PROCESS_RESTART, true);
            AppMethodBeat.o(229420);
            return;
        }
        Iterator<m> it2 = b.bWj().iterator();
        while (it2.hasNext()) {
            m next2 = it2.next();
            kotlin.g.b.p.g(next2, "task");
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : next2.bWx()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.zl(i2);
                }
            }
        }
        Iterator it3 = nPY.iterator();
        while (it3.hasNext()) {
            AppBrandRemoteTaskController appBrandRemoteTaskController2 = (AppBrandRemoteTaskController) it3.next();
            if (appBrandRemoteTaskController2 != null) {
                appBrandRemoteTaskController2.zl(i2);
            }
        }
        if (3 == i2) {
            nPY.clear();
        }
        AppMethodBeat.o(229420);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void afe(String str) {
        AppMethodBeat.i(229421);
        kotlin.g.b.p.h(str, "appId");
        Iterator<m> it = b.bWj().iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next.afq(str) != null) {
                kotlin.g.b.p.g(next, "task");
                Log.i("MicroMsg.AppBrandTaskManagerV2", "clearDuplicatedApp task:%s, appId:%s", next.bWr(), str);
                next.afq(str).afa(str);
            }
        }
        ck(str, -1);
        AppMethodBeat.o(229421);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void a(g gVar, z zVar) {
        AppMethodBeat.i(229422);
        kotlin.g.b.p.h(gVar, "serviceType");
        kotlin.g.b.p.h(zVar, "scene");
        z.a aVar = z.nMV;
        a(gVar, zVar, z.a.d(zVar));
        AppMethodBeat.o(229422);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void e(z zVar) {
        AppMethodBeat.i(229423);
        kotlin.g.b.p.h(zVar, "scene");
        a(g.WASERVICE, zVar);
        AppMethodBeat.o(229423);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void a(String str, g gVar) {
        AppMethodBeat.i(229424);
        kotlin.g.b.p.h(gVar, "preloadType");
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(229424);
            return;
        }
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        n c2 = c(str, gVar);
        if (c2 == null) {
            AppMethodBeat.o(229424);
            return;
        }
        h.RTc.n(new e(c2, gVar), 500);
        AppMethodBeat.o(229424);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ g lCF;
        final /* synthetic */ n nQe;

        e(n nVar, g gVar) {
            this.nQe = nVar;
            this.lCF = gVar;
        }

        public final void run() {
            AppMethodBeat.i(229409);
            if (this.nQe.bWq() == g.NIL && this.lCF != g.NIL) {
                b bVar = i.nPZ;
                if (b.s(this.lCF) < this.lCF.nPG) {
                    this.nQe.z(this.lCF);
                }
            }
            this.nQe.iB(com.tencent.mm.plugin.appbrand.ui.p.bXv());
            AppMethodBeat.o(229409);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void onNetworkChange() {
        AppMethodBeat.i(229425);
        Iterator<m> it = b.bWj().iterator();
        while (it.hasNext()) {
            m next = it.next();
            kotlin.g.b.p.g(next, "task");
            for (AppBrandRemoteTaskController appBrandRemoteTaskController : next.bWx()) {
                if (appBrandRemoteTaskController != null) {
                    appBrandRemoteTaskController.bVT();
                }
            }
        }
        AppMethodBeat.o(229425);
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final Class<?> aff(String str) {
        AppMethodBeat.i(229426);
        kotlin.g.b.p.h(str, "uiClassName");
        Iterator<m> it = b.bWj().iterator();
        while (it.hasNext()) {
            m next = it.next();
            kotlin.g.b.p.g(next, "task");
            if (!kotlin.g.b.p.j(next.bWr(), str)) {
                Class<? extends Activity> bWm = next.bWm();
                kotlin.g.b.p.g(bWm, "task.pluginUiClass");
                if (kotlin.g.b.p.j(bWm.getName(), str)) {
                }
            }
            Class<?> bWt = next.bWt();
            AppMethodBeat.o(229426);
            return bWt;
        }
        AppMethodBeat.o(229426);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final Class<?> afg(String str) {
        AppMethodBeat.i(229427);
        kotlin.g.b.p.h(str, "uiClassName");
        Iterator<m> it = b.bWj().iterator();
        while (it.hasNext()) {
            m next = it.next();
            kotlin.g.b.p.g(next, "task");
            if (!kotlin.g.b.p.j(next.bWr(), str)) {
                Class<? extends Activity> bWm = next.bWm();
                kotlin.g.b.p.g(bWm, "task.pluginUiClass");
                if (kotlin.g.b.p.j(bWm.getName(), str)) {
                }
            }
            Class<?> bWu = next.bWu();
            AppMethodBeat.o(229427);
            return bWu;
        }
        AppMethodBeat.o(229427);
        return null;
    }

    private static m x(g gVar) {
        T t;
        T t2;
        boolean z;
        T t3;
        T t4;
        boolean z2;
        T t5;
        boolean z3;
        AppMethodBeat.i(229428);
        synchronized (nPK) {
            try {
                Iterator<m> it = nPK.iterator();
                m mVar = null;
                while (true) {
                    if (!it.hasNext()) {
                        t = mVar;
                        break;
                    }
                    t = it.next();
                    kotlin.g.b.p.g(t, "uiTask");
                    if (t.bWp() && t.bWq() == gVar) {
                        if (mVar == null) {
                            mVar = t;
                        }
                        if (t.bWA() && (t.bWn() == null || t.bWn() == gVar)) {
                            break;
                        }
                    }
                    mVar = mVar;
                }
                if (t != null) {
                    Log.i("MicroMsg.AppBrandTaskManagerV2", "getAvailableTaskToStartup found empty task, which can be used as [%s], info [%s]", gVar, t);
                } else if (b.t(gVar)) {
                    Log.i("MicroMsg.AppBrandTaskManagerV2", "getAvailableTaskToStartup [%s] task reached maxLimit", gVar);
                    Iterator<T> it2 = nPK.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t5 = null;
                            break;
                        }
                        T next = it2.next();
                        if (next.bWq() == gVar) {
                            z3 = true;
                            continue;
                        } else {
                            z3 = false;
                            continue;
                        }
                        if (z3) {
                            t5 = next;
                            break;
                        }
                    }
                    if (t5 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    t = t5;
                } else {
                    if (gVar != g.WAGAME || !com.tencent.mm.plugin.appbrand.ui.p.bXv()) {
                        Iterator<T> it3 = nPK.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                t2 = null;
                                break;
                            }
                            T next2 = it3.next();
                            T t6 = next2;
                            if (t6.bWq() == g.NIL && (t6.bWn() == null || t6.bWn() == g.WASERVICE || t6.bWn() == g.NIL)) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                t2 = next2;
                                break;
                            }
                        }
                        t = t2;
                    } else {
                        Iterator<T> it4 = nPK.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                t4 = null;
                                break;
                            }
                            T next3 = it4.next();
                            T t7 = next3;
                            if (t7.bWq() == g.NIL && t7.bWn() == g.WAGAME) {
                                z2 = true;
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                            if (z2) {
                                t4 = next3;
                                break;
                            }
                        }
                        t = t4;
                    }
                    if (t != null) {
                        Log.i("MicroMsg.AppBrandTaskManagerV2", "getAvailableTaskToStartup found not used task, which can be used as [%s]", gVar);
                    } else {
                        Log.i("MicroMsg.AppBrandTaskManagerV2", "getAvailableTaskToStartup all full for [%s]", gVar);
                        Iterator<T> it5 = nPK.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                t3 = null;
                                break;
                            }
                            T next4 = it5.next();
                            if (next4.c(gVar)) {
                                t3 = next4;
                                break;
                            }
                        }
                        if (t3 == null) {
                            kotlin.g.b.p.hyc();
                        }
                        t = t3;
                    }
                }
            } finally {
                AppMethodBeat.o(229428);
            }
        }
        return t;
    }

    private static m bWg() {
        T t;
        T t2;
        boolean z;
        AppMethodBeat.i(229429);
        synchronized (nPK) {
            try {
                Iterator<T> it = nPK.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    T t3 = next;
                    String bWo = t3.bWo();
                    kotlin.g.b.p.g(bWo, "it.uiProcessName");
                    String bZR = g.bZR();
                    kotlin.g.b.p.g(bZR, "AppBrandWeishiUtil.getWeishiProcessName()");
                    if (!n.a((CharSequence) bWo, (CharSequence) bZR, true) || !t3.c(g.WASERVICE)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        t = next;
                        break;
                    }
                }
                if (t == null) {
                    kotlin.g.b.p.hyc();
                }
                t2 = t;
            } finally {
                AppMethodBeat.o(229429);
            }
        }
        return t2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
        if (r0.intValue() != r10) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController cm(java.lang.String r9, int r10) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.task.i.cm(java.lang.String, int):com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController");
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final boolean cn(String str, int i2) {
        AppMethodBeat.i(229431);
        kotlin.g.b.p.h(str, "appId");
        if (cm(str, i2) != null) {
            AppMethodBeat.o(229431);
            return true;
        }
        AppMethodBeat.o(229431);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final boolean afi(String str) {
        AppMethodBeat.i(229432);
        kotlin.g.b.p.h(str, "appId");
        boolean cn = cn(str, -1);
        AppMethodBeat.o(229432);
        return cn;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final Pair<String, Integer> afj(String str) {
        AppMethodBeat.i(229433);
        kotlin.g.b.p.h(str, "appId");
        AppBrandRemoteTaskController cm = cm(str, -1);
        if (cm == null) {
            AppMethodBeat.o(229433);
            return null;
        }
        Pair<String, Integer> create = Pair.create(cm.getAppId(), Integer.valueOf(cm.brf()));
        AppMethodBeat.o(229433);
        return create;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final String co(String str, int i2) {
        AppMethodBeat.i(229434);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(229434);
            return null;
        }
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        try {
            AppBrandRemoteTaskController cm = cm(str, i2);
            if (cm != null) {
                String aiv = cm.aiv();
                AppMethodBeat.o(229434);
                return aiv;
            }
        } catch (NullPointerException e2) {
            if (BuildInfo.IS_FLAVOR_RED) {
                NullPointerException nullPointerException = e2;
                AppMethodBeat.o(229434);
                throw nullPointerException;
            }
            Log.printErrStackTrace("MicroMsg.AppBrandTaskManagerV2", e2, "[NOT CRASH]getAliveInstanceId", new Object[0]);
        }
        AppMethodBeat.o(229434);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final int[] bVY() {
        AppMethodBeat.i(229435);
        LinkedList<m> bWj = b.bWj();
        int[] iArr = new int[bWj.size()];
        Iterator<m> it = bWj.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            m next = it.next();
            kotlin.g.b.p.g(next, "task");
            iArr[i2] = next.bWv();
            i2++;
        }
        AppMethodBeat.o(229435);
        return iArr;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p.a
    public final void b(n nVar) {
        AppMethodBeat.i(229436);
        kotlin.g.b.p.h(nVar, "task");
        synchronized (nPW) {
            try {
                LinkedList<m> linkedList = nPW;
                if (linkedList == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    AppMethodBeat.o(229436);
                    throw tVar;
                }
                af.eV(linkedList).remove(nVar);
                nPW.addLast((m) nVar);
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(229436);
            }
        }
        synchronized (nPK) {
            try {
                if (j.a((Iterable) nPK, (Object) nVar)) {
                    LinkedList<m> linkedList2 = nPK;
                    if (linkedList2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                        AppMethodBeat.o(229436);
                        throw tVar2;
                    }
                    af.eV(linkedList2).remove(nVar);
                    nPK.addLast((m) nVar);
                }
                x xVar2 = x.SXb;
            } finally {
                AppMethodBeat.o(229436);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p.a
    public final n a(String str, String str2, g gVar) {
        AppMethodBeat.i(229438);
        kotlin.g.b.p.h(gVar, "type");
        Iterator<m> it = b.bWj().iterator();
        while (it.hasNext()) {
            m next = it.next();
            if (next == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.task.AppBrandUIProcess");
                AppMethodBeat.o(229438);
                throw tVar;
            } else if (next.bWw().contains(str)) {
                if (!kotlin.g.b.p.j(next.bWr(), str2)) {
                    Class<? extends Activity> bWm = next.bWm();
                    kotlin.g.b.p.g(bWm, "task.pluginUiClass");
                    if (kotlin.g.b.p.j(bWm.getName(), str2)) {
                    }
                }
                m mVar = next;
                AppMethodBeat.o(229438);
                return mVar;
            }
        }
        AppMethodBeat.o(229438);
        return null;
    }

    private static n c(String str, g gVar) {
        AppMethodBeat.i(229439);
        Iterator<m> it = b.bWj().iterator();
        while (it.hasNext()) {
            m next = it.next();
            kotlin.g.b.p.g(next, "task");
            if (!kotlin.g.b.p.j(next.bWr(), str)) {
                Class<? extends Activity> bWm = next.bWm();
                kotlin.g.b.p.g(bWm, "task.pluginUiClass");
                if (!kotlin.g.b.p.j(bWm.getName(), str)) {
                    continue;
                }
            }
            if (next.c(gVar)) {
                m mVar = next;
                AppMethodBeat.o(229439);
                return mVar;
            }
        }
        if (BuildInfo.DEBUG) {
            IllegalStateException illegalStateException = new IllegalStateException("cls = [" + str + "],serviceType=[" + gVar.name() + ']');
            AppMethodBeat.o(229439);
            throw illegalStateException;
        }
        AppMethodBeat.o(229439);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p.a
    public final n b(String str, g gVar) {
        AppMethodBeat.i(229440);
        kotlin.g.b.p.h(gVar, "type");
        n c2 = c(str, gVar);
        AppMethodBeat.o(229440);
        return c2;
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p.a
    public final void a(g gVar, z zVar, boolean z) {
        AppMethodBeat.i(229441);
        kotlin.g.b.p.h(gVar, "serviceType");
        kotlin.g.b.p.h(zVar, "scene");
        if (!com.tencent.mm.plugin.appbrand.appusage.i.bxK() || com.tencent.mm.plugin.appbrand.task.preload.e.bWG() || gVar == g.NIL) {
            AppMethodBeat.o(229441);
            return;
        }
        int iF = com.tencent.mm.plugin.appbrand.task.preload.e.iF(g.WAGAME == gVar);
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(iF, zVar.nMT);
        e.a.C0800a aVar = e.a.nRc;
        int a2 = com.tencent.mm.plugin.appbrand.task.preload.e.a(e.a.C0800a.A(gVar), new f(z, gVar));
        if (z || a2 != -1) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(iF, zVar.nMU);
            if (z) {
                com.tencent.mm.plugin.appbrand.task.preload.a aVar2 = com.tencent.mm.plugin.appbrand.task.preload.a.nQO;
                a2 = com.tencent.mm.plugin.appbrand.task.preload.a.bWD();
                if (a2 == -2) {
                    a2 = 2;
                }
            }
            switch (j.$EnumSwitchMapping$0[gVar.ordinal()]) {
                case 1:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, 0);
                    break;
                case 2:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, 1);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("unknown service type");
                    AppMethodBeat.o(229441);
                    throw illegalStateException;
            }
            Log.i("MicroMsg.AppBrandTaskManagerV2", "tryPreloadNextTaskProcess serviceType[%s], scene[%s] preload level[%d]", gVar, zVar, Integer.valueOf(a2));
            n u = b.u(gVar);
            if (u != null) {
                u.z(gVar);
                u.R(a2, com.tencent.mm.plugin.appbrand.ui.p.bXv());
                if (a2 != 2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(915, 30);
                }
                switch (j.haE[gVar.ordinal()]) {
                    case 1:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, 3);
                        AppMethodBeat.o(229441);
                        return;
                    case 2:
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1144, 4);
                        AppMethodBeat.o(229441);
                        return;
                    default:
                        IllegalStateException illegalStateException2 = new IllegalStateException("unknown service type");
                        AppMethodBeat.o(229441);
                        throw illegalStateException2;
                }
            } else {
                AppMethodBeat.o(229441);
            }
        } else {
            Log.w("MicroMsg.AppBrandTaskManagerV2", "tryPreloadNextTaskProcess type[%s] scene[%s] hit interval limit", gVar, zVar);
            AppMethodBeat.o(229441);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p
    public final void Ue(String str) {
        AppMethodBeat.i(229442);
        Log.i("MicroMsg.AppBrandTaskManagerV2", "onRuntimeFinish appId=".concat(String.valueOf(str)));
        HashSet<String> hashSet = nPX;
        if (hashSet == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            AppMethodBeat.o(229442);
            throw tVar;
        }
        af.eV(hashSet).remove(str);
        AppMethodBeat.o(229442);
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x03a8  */
    @Override // com.tencent.mm.plugin.appbrand.task.p
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(android.content.Context r19, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC r20, com.tencent.mm.plugin.appbrand.report.AppBrandStatObject r21) {
        /*
        // Method dump skipped, instructions count: 1191
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.task.i.d(android.content.Context, com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC, com.tencent.mm.plugin.appbrand.report.AppBrandStatObject):int");
    }

    @Override // com.tencent.mm.plugin.appbrand.task.p.a
    public final void afk(String str) {
        AppMethodBeat.i(229437);
        kotlin.g.b.p.h(str, "appId");
        m afm = b.afm(str);
        if (afm != null) {
            afm.afk(str);
            if (afm.bWw().isEmpty()) {
                synchronized (nPW) {
                    try {
                        nPW.remove(afm);
                        nPW.addFirst(afm);
                        x xVar = x.SXb;
                    } finally {
                        AppMethodBeat.o(229437);
                    }
                }
                synchronized (nPK) {
                    try {
                        if (nPK.contains(afm)) {
                            nPK.remove(afm);
                            nPK.addFirst(afm);
                        }
                        x xVar2 = x.SXb;
                    } finally {
                        AppMethodBeat.o(229437);
                    }
                }
                return;
            }
        }
        AppMethodBeat.o(229437);
    }
}
