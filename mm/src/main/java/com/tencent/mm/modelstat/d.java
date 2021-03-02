package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.BroadcastHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;

public final class d {
    private static d jnd;
    private a jnb = new a();
    private HashSet<String> jnc = new HashSet<>();

    /* access modifiers changed from: package-private */
    public static class a implements Application.ActivityLifecycleCallbacks {
        private int jnh;
        private int jnj;
        int jnk;
        int jnl;

        a() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            AppMethodBeat.i(151046);
            d.a(d.bgd(), 1, activity);
            AppMethodBeat.o(151046);
        }

        public final void onActivityStarted(Activity activity) {
            AppMethodBeat.i(151047);
            this.jnk++;
            Log.i("MicroMsg.ClickFlowStatSender", "started[%d]", Integer.valueOf(this.jnk));
            d.a(d.bgd(), 2, activity);
            AppMethodBeat.o(151047);
        }

        public final void onActivityResumed(Activity activity) {
            AppMethodBeat.i(151048);
            this.jnh++;
            Log.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", Integer.valueOf(this.jnh));
            d.a(d.bgd(), 3, activity);
            AppMethodBeat.o(151048);
        }

        public final void onActivityPaused(Activity activity) {
            AppMethodBeat.i(151049);
            this.jnj++;
            Log.i("MicroMsg.ClickFlowStatSender", "paused[%d]", Integer.valueOf(this.jnj));
            d.a(d.bgd(), 4, activity);
            f bgg = f.bgg();
            if (activity != null && (activity instanceof MMActivity)) {
                String name = activity.getClass().getName();
                long activityBrowseTimeMs = ((MMActivity) activity).getActivityBrowseTimeMs();
                bgg.J(name, activityBrowseTimeMs);
                Log.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", name, Long.valueOf(activityBrowseTimeMs), Integer.valueOf(bgg.jnY.size()));
            }
            AppMethodBeat.o(151049);
        }

        public final void onActivityStopped(Activity activity) {
            AppMethodBeat.i(151050);
            this.jnl++;
            Log.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", Integer.valueOf(this.jnl));
            d.a(d.bgd(), 5, activity);
            AppMethodBeat.o(151050);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
            AppMethodBeat.i(151051);
            d.a(d.bgd(), 6, activity);
            AppMethodBeat.o(151051);
        }
    }

    public static void h(Application application) {
        AppMethodBeat.i(151052);
        application.registerActivityLifecycleCallbacks(bgd().jnb);
        AppMethodBeat.o(151052);
    }

    public static boolean bgc() {
        AppMethodBeat.i(151053);
        a aVar = bgd().jnb;
        if (aVar.jnk > aVar.jnl) {
            AppMethodBeat.o(151053);
            return true;
        }
        AppMethodBeat.o(151053);
        return false;
    }

    public static void d(final int i2, final String str, final int i3) {
        AppMethodBeat.i(151054);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.modelstat.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(223641);
                Intent intent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
                intent.putExtra("opCode", i2);
                intent.putExtra("ui", str);
                intent.putExtra("uiHashCode", i3);
                intent.putExtra("nowMilliSecond", Util.nowMilliSecond());
                intent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
                BroadcastHelper.setIntentPackageName(intent);
                Context context = MMApplicationContext.getContext();
                if (context != null) {
                    if (MMApplicationContext.isMMProcess()) {
                        c.bgb().j(intent);
                    } else {
                        Log.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", intent, intent.getExtras());
                        context.sendBroadcast(intent);
                    }
                    intent.setAction("com.tencent.mm.Intent.ACTION_NET_STATS");
                    context.sendBroadcast(intent);
                }
                AppMethodBeat.o(223641);
            }
        });
        AppMethodBeat.o(151054);
    }

    private d() {
        AppMethodBeat.i(151055);
        this.jnc.add("com.tencent.mm.ui.LauncherUI");
        this.jnc.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
        this.jnc.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        this.jnc.add("com.tencent.mm.ui.conversation.BizConversationUI");
        this.jnc.add("com.tencent.mm.ui.chatting.ChattingUI");
        this.jnc.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
        this.jnc.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
        this.jnc.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
        this.jnc.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
        this.jnc.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
        this.jnc.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
        AppMethodBeat.o(151055);
    }

    public static d bgd() {
        AppMethodBeat.i(151056);
        if (jnd == null) {
            synchronized (d.class) {
                try {
                    if (jnd == null) {
                        jnd = new d();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(151056);
                    throw th;
                }
            }
        }
        d dVar = jnd;
        AppMethodBeat.o(151056);
        return dVar;
    }

    public static void m(String str, long j2, long j3) {
        AppMethodBeat.i(151057);
        if (com.tencent.mm.protocal.d.KyR || com.tencent.mm.protocal.d.KyQ) {
            Log.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j3 - j2));
            e.INSTANCE.kvStat(13393, "99999,0,0," + j2 + "," + j3 + "," + str);
        }
        AppMethodBeat.o(151057);
    }

    static /* synthetic */ void a(d dVar, int i2, Activity activity) {
        AppMethodBeat.i(151058);
        int hashCode = activity.hashCode();
        String className = activity.getComponentName().getClassName();
        boolean contains = dVar.jnc.contains(className);
        Log.v("MicroMsg.ClickFlowStatSender", "callback opCode:%d activity:%s hash:%d ignore:%s %s", Integer.valueOf(i2), className, Integer.valueOf(hashCode), Boolean.valueOf(contains), Util.getStack());
        if (!contains) {
            d(i2, className, hashCode);
        }
        AppMethodBeat.o(151058);
    }
}
