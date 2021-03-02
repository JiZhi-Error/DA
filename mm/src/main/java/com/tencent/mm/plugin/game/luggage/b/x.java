package com.tencent.mm.plugin.game.luggage.b;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import org.json.JSONObject;

public class x extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "openGameTabHome";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        AppMethodBeat.i(186872);
        Log.i("MicroMsg.JsApiOpenGameTabHome", "invokeInMM");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("invalid_params", null);
            AppMethodBeat.o(186872);
        } else if (aJ(context, "com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI") || aJ(context, "com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI")) {
            aVar.i("exist_tab", null);
            AppMethodBeat.o(186872);
        } else {
            String optString = Zc.optString("tabKey");
            Log.i("MicroMsg.JsApiOpenGameTabHome", "tabKey:[%s]", optString);
            Intent intent = new Intent();
            intent.putExtra("from_find_more_friend", false);
            intent.putExtra("game_report_from_scene", 5);
            intent.putExtra("start_time", System.currentTimeMillis());
            intent.putExtra("has_game_life_chat_msg", false);
            intent.putExtra("default_game_tab_key", optString);
            intent.putExtra("disable_game_tab_home_swipe", true);
            c.b(context, "game", ".ui.GameCenterUI", intent);
            aVar.i(null, null);
            AppMethodBeat.o(186872);
        }
    }

    private static boolean aJ(Context context, String str) {
        AppMethodBeat.i(186873);
        try {
            ComponentName resolveActivity = new Intent(context, Class.forName(str)).resolveActivity(context.getPackageManager());
            if (resolveActivity != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(10)) {
                    if (runningTaskInfo.baseActivity.equals(resolveActivity)) {
                        AppMethodBeat.o(186873);
                        return true;
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
            Log.e("MicroMsg.JsApiOpenGameTabHome", "err: %s", e2.getMessage());
        }
        AppMethodBeat.o(186873);
        return false;
    }
}
