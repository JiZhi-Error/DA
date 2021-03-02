package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.x.a;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import java.util.HashSet;
import java.util.Set;

public final class d extends a {
    public static String IXv = "";

    @Override // com.tencent.mm.plugin.x.a, com.tencent.mm.plugin.x.b
    public final int getType() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.x.b
    public final void k(Context context, Intent intent) {
        AppMethodBeat.i(78840);
        final String ahb = c.ahb(IntentUtil.getStringExtra(intent, "id"));
        final String ahb2 = c.ahb(IntentUtil.getStringExtra(intent, "ext_info"));
        String stringExtra = IntentUtil.getStringExtra(intent, "token");
        if (TextUtils.isEmpty(ahb) || TextUtils.isEmpty(ahb2) || TextUtils.isEmpty(stringExtra)) {
            Log.e("MicroMsg.WebViewShortcutEntry", "jump to webview  failed, username or appId or token is null or nil.");
            AppMethodBeat.o(78840);
            return;
        }
        StringBuilder sb = new StringBuilder();
        g.aAf();
        if (!stringExtra.equals(e.eY(ahb2, sb.append(com.tencent.mm.kernel.a.getUin()).toString()))) {
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
            if (sharedPreferences == null) {
                Log.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, sp is null.");
                AppMethodBeat.o(78840);
                return;
            }
            Set<String> stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet == null || stringSet.isEmpty()) {
                Log.w("MicroMsg.WebViewShortcutEntry", "jump to webview failed, uin set is null or nil.");
                AppMethodBeat.o(78840);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : stringSet) {
                hashSet.add(c.eY(ahb2, str));
            }
            if (!hashSet.contains(stringExtra)) {
                Log.e("MicroMsg.WebViewShortcutEntry", "jump to webview failed, illegal token(%s).", stringExtra);
                Toast.makeText(context, context.getString(R.string.j4t), 1).show();
                AppMethodBeat.o(78840);
                return;
            }
        }
        intent.putExtra("type", 0);
        intent.putExtra("id", "");
        String str2 = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/gameloading/index.html?wegame_ssid=25&appid=" + ahb2;
        if (!Util.isNullOrNil(IXv)) {
            str2 = str2 + "&" + IXv;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", str2);
        intent2.putExtra("from_shortcut", true);
        intent2.putExtra("game_hv_menu_appid", ahb2);
        intent2.addFlags(67108864);
        intent2.addFlags(268435456);
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.game.H5GameWebViewUI", intent2);
        ag.bau().MN(ahb);
        String stringExtra2 = IntentUtil.getStringExtra(intent, "digest");
        if (TextUtils.isEmpty(stringExtra2)) {
            Log.i("MicroMsg.WebViewShortcutEntry", "digest is null");
            AppMethodBeat.o(78840);
            return;
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(ahb);
        if (Kn == null || Util.isNullOrNil(Kn.arI())) {
            Log.i("MicroMsg.WebViewShortcutEntry", "no need update, displayName is null");
            AppMethodBeat.o(78840);
            return;
        }
        String arI = Kn.arI();
        i Mx = p.aYB().Mx(ahb);
        if (Mx == null || Util.isNullOrNil(Mx.aYu())) {
            Log.i("MicroMsg.WebViewShortcutEntry", "no need update, imgFlag is null");
            AppMethodBeat.o(78840);
        } else if (stringExtra2.equals(com.tencent.mm.b.g.getMessageDigest((arI + Mx.aYu()).getBytes()))) {
            Log.i("MicroMsg.WebViewShortcutEntry", "no need update, digest is same");
            AppMethodBeat.o(78840);
        } else {
            Bitmap a2 = com.tencent.mm.aj.c.a(ahb, false, -1, null);
            if (a2 == null || a2.isRecycled()) {
                Log.i("MicroMsg.WebViewShortcutEntry", "icon is not downloaded, next time update");
                AppMethodBeat.o(78840);
                return;
            }
            Log.i("MicroMsg.WebViewShortcutEntry", "update shortcut, displayName = %s", arI);
            e.g(context, ahb, ahb2, c.ahb(IntentUtil.getStringExtra(intent, "ext_info_1")));
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.webview.model.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(78839);
                    e.a(MMApplicationContext.getContext(), ahb, ahb2, null);
                    AppMethodBeat.o(78839);
                }
            }, 1000);
            AppMethodBeat.o(78840);
        }
    }
}
