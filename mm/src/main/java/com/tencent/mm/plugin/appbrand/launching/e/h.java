package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.launching.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.plugin.appbrand.report.quality.o;
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class h extends a {
    private static long mZq = 0;

    @Override // com.tencent.mm.plugin.appbrand.launching.a
    public final boolean b(Context context, LaunchParcel launchParcel) {
        boolean z;
        AppBrandInitConfigWC Xa;
        AppMethodBeat.i(47462);
        String a2 = a(launchParcel);
        String c2 = g.c(launchParcel, a2);
        g.a(launchParcel, c2, a2);
        w wVar = w.nHZ;
        w.b(launchParcel, c2);
        if (o.bVk()) {
            o oVar = o.nMe;
            o.eI(a2, c2);
            c.e(KSProcessWeAppLaunch.class, a2);
            c.a(KSProcessWeAppLaunch.class, a2, String.format("Network:%s", NetStatusUtil.getNetTypeString(context)));
        }
        int i2 = launchParcel.iOo;
        if (!Util.isNullOrNil(a2) && i2 == 0 && com.tencent.mm.plugin.appbrand.task.h.bWb().cn(a2, i2) && (Xa = com.tencent.mm.plugin.appbrand.config.h.bzT().Xa(a2)) != null && Xa.eix == i2) {
            launchParcel.f(Xa);
            WeAppOpenUICallbackIPCProxy.c.a(Xa, launchParcel);
            Xa.ldR = launchParcel.ldR;
            Xa.ldQ = launchParcel.ldQ;
            Xa.launchMode = launchParcel.launchMode;
            Xa.kHG = launchParcel.kHG;
            Xa.ldW = new QualitySession(c2, Xa, launchParcel.mYK);
            Xa.dC(c2);
            Xa.ldW.nLm = false;
            Xa.kHI = launchParcel.kHI;
            if (launchParcel.mYQ != null) {
                Xa.lee = (WeAppOpenDeclarePromptBundle) launchParcel.mYQ;
            } else {
                Xa.lee = null;
            }
            Xa.cyy = false;
            Xa.kHL = launchParcel.kHL;
            Xa.kHM = launchParcel.kHM;
            Xa.kHQ = launchParcel.kHQ;
            i.b(context, Xa, launchParcel.mYK);
            w wVar2 = w.nHZ;
            w.h(Xa);
            AppMethodBeat.o(47462);
            return true;
        } else if (Math.abs(System.currentTimeMillis() - mZq) < 200) {
            Log.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
            AppMethodBeat.o(47462);
            return false;
        } else {
            mZq = Util.nowMilliSecond();
            Log.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", a2, Integer.valueOf(i2));
            if (launchParcel.cys == null || 4 != launchParcel.cys.leo) {
                z = false;
            } else {
                z = true;
            }
            boolean equalsIgnoreCase = "wxfe02ecfe70800f46".equalsIgnoreCase(a2);
            String str = "Token@" + h.class.hashCode() + "#" + System.nanoTime();
            boolean z2 = !equalsIgnoreCase;
            if (z) {
                z2 = false;
            }
            new d(context, str, z2).a(launchParcel, c2);
            Log.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", launchParcel.username, a2, launchParcel.mYK);
            Intent intent = new Intent(context, AppBrandLaunchProxyUI.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            } else {
                c(intent, (Activity) context);
            }
            intent.putExtra("extra_from_mm", true);
            intent.putExtra("extra_entry_token", str);
            if (!(!equalsIgnoreCase || launchParcel.mYL == null || launchParcel.mYL.cyt == null)) {
                intent.putExtra("extra_launch_weishi_video", true);
                intent.putExtra("extra_launch_thumb_url", launchParcel.mYL.cyt.thumbUrl);
                intent.putExtra("extra_launch_thumb_path", launchParcel.mYL.cyt.leN);
            }
            if ((context instanceof Activity) && launchParcel.kHC >= 0) {
                ((Activity) context).startActivityForResult(intent, launchParcel.kHC);
            } else if (launchParcel.mQC != null) {
                int flags = intent.getFlags();
                try {
                    intent.setFlags(-268435457 & flags);
                    ActivityStarterIpcDelegate activityStarterIpcDelegate = launchParcel.mQC;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activityStarterIpcDelegate, bl.axQ(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activityStarterIpcDelegate.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activityStarterIpcDelegate, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } catch (Exception e2) {
                    intent.setFlags(flags);
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
            } else {
                com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl3.axQ(), "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl3.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/launching/precondition/MMLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            if (z && (context instanceof MMActivity)) {
                ((MMActivity) context).hideAllManagedDialogs();
            }
            AppMethodBeat.o(47462);
            return true;
        }
    }

    public static String a(LaunchParcel launchParcel) {
        AppMethodBeat.i(227139);
        String str = launchParcel.appId;
        if (Util.isNullOrNil(str)) {
            str = y.Xw(launchParcel.username);
        }
        AppMethodBeat.o(227139);
        return str;
    }

    static void c(Intent intent, Activity activity) {
        AppMethodBeat.i(47463);
        intent.putExtra("key_from_activity_requested_orientation", activity.getRequestedOrientation());
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                intent.putExtra("extra_from_activity_status_bar_color", activity.getWindow().getStatusBarColor());
                intent.putExtra("extra_from_activity_navigation_bar_color", activity.getWindow().getNavigationBarColor());
            }
            intent.putExtra("extra_from_activity_window_attributes", activity.getWindow().getAttributes());
            AppMethodBeat.o(47463);
        } catch (NullPointerException e2) {
            AppMethodBeat.o(47463);
        }
    }
}
