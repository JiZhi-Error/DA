package com.tencent.mm.model;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.UUID;

public final class cq {
    Map<String, String> izF;

    public cq(Map<String, String> map) {
        this.izF = map;
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent F(String str, long j2) {
        String str2;
        AppMethodBeat.i(231538);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
            str2 = "com.tencent.mm.ui.LauncherUI";
        } else if ((4 & j2) == 4 && str.startsWith("weixin://dl/moments")) {
            str2 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
        } else if ((262144 & j2) != 262144 || !str.startsWith("weixin://dl/recommendation")) {
            Log.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", str);
            str2 = "com.tencent.mm.ui.LauncherUI";
        } else {
            str2 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
        }
        Intent intent = new Intent();
        intent.setClassName(MMApplicationContext.getContext(), str2);
        intent.setFlags(536870912);
        intent.putExtra("LauncherUI.Show.Update.DialogMsg", this.izF.get(".sysmsg.WakenPush.PushContent"));
        if (!str.equals("weixin://dl/update_newest_version")) {
            intent.putExtra("LauncherUI.Show.Update.Url", this.izF.get(".sysmsg.WakenPush.Jump"));
        }
        h.INSTANCE.idkeyStat(405, 32, 1, true);
        PendingIntent activity = PendingIntent.getActivity(MMApplicationContext.getContext(), UUID.randomUUID().hashCode(), intent, 134217728);
        AppMethodBeat.o(231538);
        return activity;
    }
}
