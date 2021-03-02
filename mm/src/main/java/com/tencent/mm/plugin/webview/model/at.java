package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class at {

    public interface a {
        void zf(boolean z);
    }

    public static void a(a aVar, boolean z) {
        AppMethodBeat.i(79042);
        if (aVar != null) {
            aVar.zf(z);
        }
        AppMethodBeat.o(79042);
    }

    public static Intent a(Bitmap bitmap, String str, String str2, boolean z) {
        AppMethodBeat.i(79043);
        Log.i("MicroMsg.WebViewShortcutManager", "buildIntent, install = %b", Boolean.valueOf(z));
        if (bitmap != null || !z) {
            Intent intent = new Intent(z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", str2);
            intent.putExtra("duplicate", false);
            Intent intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
            intent2.putExtra("type", 4);
            try {
                intent2.putExtra("ext_info", URLEncoder.encode(str, ProtocolPackage.ServerEncoding));
            } catch (UnsupportedEncodingException e2) {
            }
            intent2.setPackage(MMApplicationContext.getPackageName());
            intent2.addFlags(67108864);
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            if (bitmap != null) {
                intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
                intent.putExtra("shortcut_is_adaptive_icon", true);
            }
            AppMethodBeat.o(79043);
            return intent;
        }
        Log.e("MicroMsg.WebViewShortcutManager", "no bmp");
        AppMethodBeat.o(79043);
        return null;
    }
}
