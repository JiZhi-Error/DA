package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class a implements ag {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag
    public final void a(Context context, String str, dyq dyq) {
        AppMethodBeat.i(47476);
        if (TextUtils.isEmpty(str)) {
            Log.w("MicroMsg.AppBrand.CustomizeExternalToolsHelper", "openWebViewActivity with empty url, stack:%s", android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(47476);
            return;
        }
        if (context == null) {
            context = MMApplicationContext.getContext();
        } else {
            Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(context);
            if (castActivityOrNull != null) {
                context = castActivityOrNull;
            }
        }
        Intent putExtra = new Intent().putExtra("rawUrl", str).putExtra(AppBrandProcessProxyUI.lwe, str);
        putExtra.putExtra("rawUrl", str);
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        if (dyq != null) {
            putExtra.putExtra("show_native_web_view", dyq.MYd);
            putExtra.putExtra("KRightBtn", dyq.MYe);
        }
        c.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
        AppMethodBeat.o(47476);
    }
}
