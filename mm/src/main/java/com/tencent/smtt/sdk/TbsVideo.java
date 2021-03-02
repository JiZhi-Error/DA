package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.tbs.c.a.b;

public class TbsVideo {
    private byte _hellAccFlag_;

    public static void openVideo(Context context, String str) {
        AppMethodBeat.i(54555);
        openVideo(context, str, null);
        AppMethodBeat.o(54555);
    }

    public static void openVideo(Context context, String str, Bundle bundle) {
        AppMethodBeat.i(54556);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(54556);
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("videoUrl", str);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.setFlags(268435456);
        intent.setPackage(context.getPackageName());
        intent.putExtra("extraData", bundle);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/smtt/sdk/TbsVideo", "openVideo", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/smtt/sdk/TbsVideo", "openVideo", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(54556);
    }

    public static boolean openYunboVideo(Context context, String str, Bundle bundle, b bVar) {
        AppMethodBeat.i(54557);
        if (canUseYunbo(context)) {
            boolean a2 = t.a(context).a(str, bundle, bVar);
            AppMethodBeat.o(54557);
            return a2;
        }
        AppMethodBeat.o(54557);
        return false;
    }

    public static boolean canUseTbsPlayer(Context context) {
        AppMethodBeat.i(54558);
        boolean a2 = t.a(context).a();
        AppMethodBeat.o(54558);
        return a2;
    }

    public static boolean canUseYunbo(Context context) {
        AppMethodBeat.i(54559);
        if (!t.a(context).a() || !QbSdk.canUseVideoFeatrue(context, 1)) {
            AppMethodBeat.o(54559);
            return false;
        }
        AppMethodBeat.o(54559);
        return true;
    }
}
