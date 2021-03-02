package com.tencent.mm.plugin.emoji.h;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    private final String TAG = "MicroMsg.emoji.UseSmileyTool";
    public int nTL;
    public String rnF;

    public c(int i2) {
        this.nTL = i2;
    }

    public static void a(Intent intent, String str, Activity activity) {
        AppMethodBeat.i(109443);
        if (intent == null) {
            AppMethodBeat.o(109443);
            return;
        }
        a(intent.getStringExtra("Select_Conv_User"), str, activity);
        AppMethodBeat.o(109443);
    }

    public static void a(String str, String str2, Activity activity) {
        AppMethodBeat.i(109444);
        if (Util.isNullOrNil(str)) {
            Log.d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
            AppMethodBeat.o(109444);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("smiley_product_id", str2);
        com.tencent.mm.plugin.emoji.c.jRt.d(intent, activity);
        AppMethodBeat.o(109444);
    }

    public final void N(Activity activity) {
        AppMethodBeat.i(109445);
        Log.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
        Intent intent = new Intent();
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
        intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
        com.tencent.mm.br.c.c(activity, ".ui.transmit.SelectConversationUI", intent, this.nTL);
        activity.overridePendingTransition(R.anim.dq, R.anim.bs);
        AppMethodBeat.o(109445);
    }
}
