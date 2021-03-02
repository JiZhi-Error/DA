package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.luggage.sdk.config.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\n\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\fH\u0007¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/AppBrandComponentUtil;", "", "()V", "generateInstanceId", "", OpenSDKTool4Assistant.EXTRA_UIN, "", "hasPreLoading", "", "triggerServiceName", "isActivityHasSpecificTaskAffinity", "clazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
public final class b {
    public static final b ogD = new b();

    static {
        AppMethodBeat.i(51400);
        AppMethodBeat.o(51400);
    }

    private b() {
    }

    public static final boolean aI(Class<? extends Activity> cls) {
        String str;
        PackageManager packageManager;
        ActivityInfo activityInfo;
        AppMethodBeat.i(51397);
        p.h(cls, "clazz");
        try {
            Context context = MMApplicationContext.getContext();
            if (context == null || (packageManager = context.getPackageManager()) == null || (activityInfo = packageManager.getActivityInfo(new ComponentName(context, cls), 128)) == null || (str = activityInfo.taskAffinity) == null) {
                p.g(context, "appContext");
                str = context.getPackageName();
            }
            boolean z = !p.j(str, context.getPackageName());
            AppMethodBeat.o(51397);
            return z;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(51397);
            return false;
        }
    }

    public static final String zF(int i2) {
        AppMethodBeat.i(51399);
        c cVar = c.a.czh;
        if (cVar != null) {
            String NI = cVar.NI();
            p.g(NI, "factory.createInstanceId()");
            AppMethodBeat.o(51399);
            return NI;
        }
        String string = com.tencent.mm.b.p.getString(i2);
        p.g(string, "UIN.getString(uin)");
        String a2 = j.a(j.listOf((Object[]) new String[]{string, String.valueOf(Util.nowMilliSecond())}), "_", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62);
        AppMethodBeat.o(51399);
        return a2;
    }

    public static final boolean afF(String str) {
        AppMethodBeat.i(229594);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            AppMethodBeat.o(229594);
            return true;
        }
        AppMethodBeat.o(229594);
        return false;
    }
}
