package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.task.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0007H\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIAccountReleaseHandler;", "", "()V", "TAG", "", "processForegroundImportance", "", "", "[Ljava/lang/Integer;", "getSerializedUin", "handleAccountRelease", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "finishHandler", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskUIController$FinishAllHandler;", "plugin-appbrand-integration_release"})
public final class q {
    private static final Integer[] nXq = {100, 200};
    public static final q nXr = new q();

    static {
        AppMethodBeat.i(51149);
        AppMethodBeat.o(51149);
    }

    private q() {
    }

    public static final int bXC() {
        AppMethodBeat.i(175219);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
        if (sharedPreferences != null) {
            int i2 = sharedPreferences.getInt("default_uin", 0);
            AppMethodBeat.o(175219);
            return i2;
        }
        AppMethodBeat.o(175219);
        return 0;
    }

    public static void a(Activity activity, k.a aVar) {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        AppMethodBeat.i(51148);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(aVar, "finishHandler");
        try {
            runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (RemoteException e2) {
            runningAppProcessInfo = null;
        }
        a aVar2 = new a(aVar, activity);
        if (runningAppProcessInfo == null || !org.apache.commons.b.a.contains(nXq, Integer.valueOf(runningAppProcessInfo.importance))) {
            Log.i("MicroMsg.AppBrandUIAccountReleaseHandler", "finish directly importance[" + (runningAppProcessInfo != null ? runningAppProcessInfo.importance : -1) + ']');
            aVar2.invoke();
            AppMethodBeat.o(51148);
            return;
        }
        com.tencent.mm.plugin.appbrand.ipc.a.a(activity, new AccountReleaseProxyUILaunchRequest(), new b(aVar2), new Intent().addFlags(67108864));
        AppMethodBeat.o(51148);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"doFinish", "", "invoke"})
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ Activity msB;
        final /* synthetic */ k.a nXs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(k.a aVar, Activity activity) {
            super(0);
            this.nXs = aVar;
            this.msB = activity;
        }

        @Override // kotlin.g.a.a
        public final void invoke() {
            AppMethodBeat.i(51146);
            this.nXs.proceed();
            this.msB.finish();
            AppMethodBeat.o(51146);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    public static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult> implements AppBrandProxyUIProcessTask.b<AccountReleaseProxyUILaunchResult> {
        final /* synthetic */ a nXt;

        b(a aVar) {
            this.nXt = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
        public final /* synthetic */ void a(AccountReleaseProxyUILaunchResult accountReleaseProxyUILaunchResult) {
            AppMethodBeat.i(51147);
            this.nXt.invoke();
            AppMethodBeat.o(51147);
        }
    }
}
