package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.kinda.gen.KPlatformUIRouter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.WebView;

public class PlatformUIRouterImpl implements KPlatformUIRouter {
    public static final String TAG = "MicroMsg.PlatformUIRouterImpl";
    private byte _hellAccFlag_;

    @Override // com.tencent.kinda.gen.KPlatformUIRouter
    public void gotoExternApp(String str, int i2, String str2, String str3, String str4, int i3, int i4, byte[] bArr) {
        AppMethodBeat.i(18675);
        lk lkVar = new lk();
        lkVar.dQI.dIZ = i2;
        lkVar.dQI.returnKey = str2;
        lkVar.dQI.dNI = str;
        EventCenter.instance.publish(lkVar);
        AppMethodBeat.o(18675);
    }

    @Override // com.tencent.kinda.gen.KPlatformUIRouter
    public void openUrlScheme(String str) {
        AppMethodBeat.i(214453);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(214453);
        } else if (str.startsWith("telprompt://")) {
            Log.i(TAG, "call dial: %s", str);
            String replace = str.replace("telprompt://", "");
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(replace))));
            if (Util.isIntentAvailable(MMApplicationContext.getContext(), intent)) {
                Context context = MMApplicationContext.getContext();
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(214453);
        } else {
            Log.i(TAG, "startOuterApp callbackUrl is ".concat(String.valueOf(str)));
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent2.addFlags(268435456);
            if (Util.isIntentAvailable(MMApplicationContext.getContext(), intent2)) {
                Context context2 = MMApplicationContext.getContext();
                a bl2 = new a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/kinda/framework/module/impl/PlatformUIRouterImpl", "openUrlScheme", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(214453);
        }
    }

    @Override // com.tencent.kinda.gen.KPlatformUIRouter
    public void jointpayGotoExternApp(String str, int i2, String str2, String str3, String str4, int i3, int i4, byte[] bArr) {
        AppMethodBeat.i(18676);
        lk lkVar = new lk();
        lkVar.dQI.dIZ = i2;
        lkVar.dQI.returnKey = str2;
        lkVar.dQI.dNI = str;
        EventCenter.instance.publish(lkVar);
        AppMethodBeat.o(18676);
    }
}
