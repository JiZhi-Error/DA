package com.tencent.mm.pluginsdk.k.b.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.QbSdk;

public final class a {
    public static boolean b(String str, Context context, boolean z) {
        AppMethodBeat.i(31160);
        o.bhj();
        boolean c2 = c(t.Qw(str), context, z);
        AppMethodBeat.o(31160);
        return c2;
    }

    public static boolean c(String str, Context context, boolean z) {
        AppMethodBeat.i(31161);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(31161);
            return false;
        } else if (context == null) {
            AppMethodBeat.o(31161);
            return false;
        } else {
            Intent addFlags = new Intent("android.intent.action.VIEW").addFlags(268435456);
            addFlags.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
            addFlags.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 3);
            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str);
            if (z) {
                FileProviderHelper.setIntentDataAndType(context, addFlags, oVar, "video/quicktime", false);
            } else {
                FileProviderHelper.setIntentDataAndType(context, addFlags, oVar, "video/*", false);
            }
            if (!Util.isIntentAvailable(context, addFlags)) {
                AppMethodBeat.o(31161);
                return false;
            }
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(addFlags);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/subapp/ui/video/VideoPlayerMgr", "startThridPlayerByPath", "(Ljava/lang/String;Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/subapp/ui/video/VideoPlayerMgr", "startThridPlayerByPath", "(Ljava/lang/String;Landroid/content/Context;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(31161);
            return true;
        }
    }
}
