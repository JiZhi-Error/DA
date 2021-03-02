package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Arrays;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t\u001a\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u001a\u0010\f\u001a\u00020\u0005*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u000f\u0010\u0011\u001a\u00020\u0005*\u0004\u0018\u00010\u0012H\b\u001a\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0016\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0005¨\u0006\u0019"}, hxF = {"bundleToString", "", "bundle", "Landroid/os/Bundle;", "findProcess", "", "context", "Landroid/content/Context;", "predicate", "Lkotlin/Function1;", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "getNetWorkType", "isExpire", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "key", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "isNullOrEmpty", "", "putNow", "", "toDebugString", "Landroid/content/Intent;", "toInt", "", "plugin-brandservice_release"})
public final class f {
    public static final void b(MultiProcessMMKV multiProcessMMKV, String str) {
        AppMethodBeat.i(6576);
        p.h(multiProcessMMKV, "$this$putNow");
        p.h(str, "key");
        multiProcessMMKV.putLong(str, MMSlotKt.now());
        AppMethodBeat.o(6576);
    }

    public static final boolean a(MultiProcessMMKV multiProcessMMKV, String str, long j2) {
        AppMethodBeat.i(6577);
        p.h(multiProcessMMKV, "$this$isExpire");
        p.h(str, "key");
        boolean isExpire = MMSlotKt.isExpire(multiProcessMMKV.getLong(str, 0), j2);
        AppMethodBeat.o(6577);
        return isExpire;
    }

    public static final boolean c(Context context, b<? super ActivityManager.RunningAppProcessInfo, Boolean> bVar) {
        AppMethodBeat.i(6578);
        p.h(context, "context");
        p.h(bVar, "predicate");
        Object systemService = context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.ActivityManager");
            AppMethodBeat.o(6578);
            throw tVar;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
            p.g(runningAppProcessInfo, "info");
            if (bVar.invoke(runningAppProcessInfo).booleanValue()) {
                AppMethodBeat.o(6578);
                return true;
            }
        }
        AppMethodBeat.o(6578);
        return false;
    }

    public static final String getNetWorkType() {
        AppMethodBeat.i(6579);
        Context context = MMApplicationContext.getContext();
        if (NetStatusUtil.isWifi(context)) {
            AppMethodBeat.o(6579);
            return "wifi";
        } else if (NetStatusUtil.is5G(context)) {
            AppMethodBeat.o(6579);
            return "5g";
        } else if (NetStatusUtil.is4G(context)) {
            AppMethodBeat.o(6579);
            return "4g";
        } else if (NetStatusUtil.is3G(context)) {
            AppMethodBeat.o(6579);
            return "3g";
        } else if (NetStatusUtil.is2G(context)) {
            AppMethodBeat.o(6579);
            return "2g";
        } else {
            AppMethodBeat.o(6579);
            return "none";
        }
    }

    public static final String ag(Intent intent) {
        AppMethodBeat.i(6580);
        p.h(intent, "$this$toDebugString");
        String str = intent.toString() + " " + W(intent.getExtras());
        AppMethodBeat.o(6580);
        return str;
    }

    private static final String W(Bundle bundle) {
        AppMethodBeat.i(6581);
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            p.g(sb.append(BuildConfig.COMMAND), "out.append(\"null\")");
        } else {
            try {
                boolean z = true;
                for (String str : bundle.keySet()) {
                    if (!z) {
                        sb.append(", ");
                    }
                    sb.append(str).append('=');
                    Object obj = bundle.get(str);
                    if (obj instanceof Object[]) {
                        sb.append(Arrays.toString((Object[]) obj));
                    } else if (obj instanceof Bundle) {
                        sb.append(W((Bundle) obj));
                    } else {
                        sb.append(obj);
                    }
                    z = false;
                }
            } catch (Exception e2) {
                sb.append("can not read bundle");
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        p.g(sb2, "out.toString()");
        AppMethodBeat.o(6581);
        return sb2;
    }
}
