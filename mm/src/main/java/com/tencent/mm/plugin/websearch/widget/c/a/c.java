package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class c implements a {
    @Override // com.tencent.mm.plugin.websearch.widget.c.a.a
    public final boolean Mb(long j2) {
        AppMethodBeat.i(116661);
        boolean ak = com.tencent.mm.plugin.websearch.widget.c.c.ak(j2, 1);
        AppMethodBeat.o(116661);
        return ak;
    }

    @Override // com.tencent.mm.plugin.websearch.widget.c.a.a
    public final boolean aXt(String str) {
        AppMethodBeat.i(116662);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(116662);
            return false;
        }
        boolean startsWith = str.startsWith("app://");
        AppMethodBeat.o(116662);
        return startsWith;
    }

    @Override // com.tencent.mm.plugin.websearch.widget.c.a.a
    public final boolean aXu(String str) {
        AppMethodBeat.i(116663);
        if (!aXt(str)) {
            AppMethodBeat.o(116663);
            return false;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("pkgName");
        String queryParameter2 = parse.getQueryParameter("extra");
        String queryParameter3 = parse.getQueryParameter("extraIntentKey");
        String queryParameter4 = parse.getQueryParameter("fallbackUrl");
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(queryParameter2) && !TextUtils.isEmpty(queryParameter3)) {
            hashMap.put(queryParameter3, queryParameter2);
        }
        if (!b(MMApplicationContext.getContext(), queryParameter, hashMap)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", queryParameter4);
            intent.putExtra("useJs", true);
            com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(116663);
        return true;
    }

    private boolean b(final Context context, String str, Map<String, String> map) {
        AppMethodBeat.i(116664);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(116664);
            return false;
        }
        try {
            final Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    launchIntentForPackage.putExtra(entry.getKey(), entry.getValue());
                }
                a.post(new Runnable() {
                    /* class com.tencent.mm.plugin.websearch.widget.c.a.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(116660);
                        h.b(context, launchIntentForPackage, "");
                        AppMethodBeat.o(116660);
                    }
                });
                AppMethodBeat.o(116664);
                return true;
            }
        } catch (Exception e2) {
            Log.e("OpenAppNativeApp", Util.stackTraceToString(e2));
        }
        AppMethodBeat.o(116664);
        return false;
    }
}
