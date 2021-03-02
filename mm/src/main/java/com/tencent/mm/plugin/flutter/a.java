package com.tencent.mm.plugin.flutter;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.a.c;
import com.tencent.mm.plugin.flutter.ui.MMFlutterActivity;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(148836);
        if (Log.getLogLevel() > 1) {
            AppMethodBeat.o(148836);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(148836);
            return true;
        } else {
            String str2 = strArr[1];
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -2070196511:
                    if (str2.equals("statusbar")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 94746185:
                    if (str2.equals("clean")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 94921639:
                    if (str2.equals(AppMeasurement.CRASH_ORIGIN)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1316811262:
                    if (str2.equals("startnew")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    AppMethodBeat.o(148836);
                    return true;
                case 1:
                    AppMethodBeat.o(148836);
                    return true;
                case 2:
                    String uuid = UUID.randomUUID().toString();
                    c cVar = new c();
                    cVar.wJd = "emotion";
                    cVar.wJe = "store";
                    cVar.wJg = 2;
                    cVar.wJf = new HashMap<>();
                    cVar.wJf.put("fontScale", Float.valueOf(com.tencent.mm.cb.a.ez(MMApplicationContext.getContext())));
                    cVar.wJf.put("layoutScale", Float.valueOf(com.tencent.mm.cb.a.jj(MMApplicationContext.getContext())));
                    cVar.wJf.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, LocaleUtil.getApplicationLanguage());
                    cVar.wJf.put("sessionId", uuid);
                    Intent intent = new Intent(MMApplicationContext.getContext(), MMFlutterActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra(TencentExtraKeys.LOCATION_KEY_ROUTE, cVar.bua());
                    Context context2 = MMApplicationContext.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/flutter/FlutterCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context2.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/flutter/FlutterCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(148836);
                    return true;
                case 3:
                    File file = new File(aa.z(new o(context.getCacheDir() + "/flutter").her()));
                    o oVar = new o(context.getCacheDir() + "/flutter");
                    file.delete();
                    oVar.delete();
                    AppMethodBeat.o(148836);
                    return true;
                default:
                    AppMethodBeat.o(148836);
                    return false;
            }
        }
    }
}
