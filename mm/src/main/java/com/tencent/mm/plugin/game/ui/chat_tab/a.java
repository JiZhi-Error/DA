package com.tencent.mm.plugin.game.ui.chat_tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static GameTabWidget2 b(Activity activity, View view) {
        GameTabWidget2 gameTabWidget2;
        AppMethodBeat.i(204243);
        if (!(view instanceof FrameLayout)) {
            AppMethodBeat.o(204243);
            return null;
        }
        GameTabData2 gameTabData2 = (GameTabData2) activity.getIntent().getParcelableExtra("game_tab_data");
        String stringExtra = activity.getIntent().getStringExtra("game_tab_key");
        if (gameTabData2 != null) {
            GameTabWidget2 gameTabWidget22 = new GameTabWidget2(activity);
            gameTabWidget22.a(gameTabData2, stringExtra);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            ((FrameLayout) view).addView(gameTabWidget22, layoutParams);
            gameTabWidget2 = gameTabWidget22;
        } else {
            gameTabWidget2 = null;
        }
        AppMethodBeat.o(204243);
        return gameTabWidget2;
    }

    public static void gk(Context context) {
        AppMethodBeat.i(204244);
        context.sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.xtn);
        AppMethodBeat.o(204244);
    }
}
