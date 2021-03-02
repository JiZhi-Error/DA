package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.protocal.protobuf.eht;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.File;

public final class d {
    private static String ynA = "tinker-boots-install-info";
    private static String ynB = "tinker-boots-last-show";
    private static String ynC = "tinker-boots-show-time";
    private static String ynD = "";

    public static String gp(Context context) {
        AppMethodBeat.i(117527);
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            AppMethodBeat.o(117527);
            return str;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.UpdateUtil", e2, "", new Object[0]);
            AppMethodBeat.o(117527);
            return null;
        }
    }

    public static void aZ(Context context, String str) {
        AppMethodBeat.i(117528);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/hp/util/UpdateUtil", "install", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(117528);
    }

    public static int aBM(String str) {
        int i2;
        AppMethodBeat.i(196801);
        if (!Util.isNullOrNil(str)) {
            try {
                i2 = Integer.decode(str).intValue();
            } catch (Exception e2) {
            }
            Log.i("MicroMsg.UpdateUtil", "parseClientVersion %s %s", str, Integer.valueOf(i2));
            AppMethodBeat.o(196801);
            return i2;
        }
        i2 = 0;
        Log.i("MicroMsg.UpdateUtil", "parseClientVersion %s %s", str, Integer.valueOf(i2));
        AppMethodBeat.o(196801);
        return i2;
    }

    public static void a(eht eht) {
        AppMethodBeat.i(117529);
        try {
            MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.aps()).edit().putString(ynA, Base64.encodeToString(eht.toByteArray(), 0)).apply();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.UpdateUtil", e2, "", new Object[0]);
        }
        Log.d("MicroMsg.UpdateUtil", "save tinker install update info.");
        AppMethodBeat.o(117529);
    }

    public static void dZA() {
        AppMethodBeat.i(117530);
        Log.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", g.aps());
        sharedPreferences.edit().putString(ynA, "").apply();
        sharedPreferences.edit().putLong(ynB, 0).apply();
        sharedPreferences.edit().putInt(ynC, 0).apply();
        AppMethodBeat.o(117530);
    }

    public static void dZB() {
        AppMethodBeat.i(117531);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.hp.d.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(117526);
                Log.i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
                s.dy(d.dZC(), true);
                AppMethodBeat.o(117526);
            }
        });
        AppMethodBeat.o(117531);
    }

    public static String dZC() {
        AppMethodBeat.i(117532);
        if (Util.isNullOrNil(ynD)) {
            ynD = b.aKM() + "bsdiff/";
        }
        String str = ynD;
        AppMethodBeat.o(117532);
        return str;
    }

    public static String aBN(String str) {
        AppMethodBeat.i(117533);
        String str2 = dZC() + str + ".apk";
        AppMethodBeat.o(117533);
        return str2;
    }
}
