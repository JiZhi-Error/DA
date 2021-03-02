package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bq.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.Map;

public final class p implements i {
    static p pfc;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4;
        AppMethodBeat.i(22378);
        if (i2 == 4 && !bg.azz().foreground) {
            switch (i3) {
                case -999999:
                    new MMHandler().post(new Runnable() {
                        /* class com.tencent.mm.plugin.bbom.p.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(22377);
                            bg.hold();
                            MMAppMgr.Bj(true);
                            AppMethodBeat.o(22377);
                        }
                    });
                    AppMethodBeat.o(22378);
                    return;
                case -2023:
                case -100:
                    ahd(MMApplicationContext.getContext().getString(R.string.ev5));
                    t.ds(MMApplicationContext.getContext());
                    bg.hold();
                    AppMethodBeat.o(22378);
                    return;
                case -311:
                case -310:
                case -205:
                case -72:
                case -9:
                case -6:
                case -4:
                case -3:
                    ahd(MMApplicationContext.getContext().getString(R.string.ev7));
                    bg.hold();
                    AppMethodBeat.o(22378);
                    return;
                case -140:
                    Log.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", str);
                    if (!Util.isNullOrNil(str)) {
                        ahd(str);
                    } else {
                        ahd(MMApplicationContext.getContext().getString(R.string.ev7));
                    }
                    bg.hold();
                    AppMethodBeat.o(22378);
                    return;
                case ShareConstants.ERROR_LOAD_PATCH_VERSION_LIB_DIRECTORY_NOT_EXIST /*{ENCODED_INT: -17}*/:
                case -16:
                    SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
                    long j2 = sharedPreferences.getLong("recomended_update_ignore", -1);
                    if (j2 == -1 || Util.secondsToNow(j2) >= 86400) {
                        if (i3 == -17) {
                            i4 = 2;
                        } else {
                            i4 = 1;
                        }
                        Context context = MMApplicationContext.getContext();
                        Intent intent = new Intent(context, LauncherUI.class);
                        intent.addFlags(536870912);
                        intent.addFlags(67108864);
                        intent.putExtra("nofification_type", "update_nofification");
                        intent.putExtra("show_update_dialog", true);
                        intent.putExtra("update_type", i4);
                        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
                        s.c g2 = a.cd(context, "reminder_channel_id").i((CharSequence) null).i(System.currentTimeMillis()).f(context.getString(R.string.zk)).g(context.getString(R.string.ya));
                        g2.Hv = activity;
                        Notification build = g2.build();
                        build.flags |= 16;
                        bg.getNotification().a(34, build, false);
                        sharedPreferences.edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
                        h.INSTANCE.idkeyStat(405, 27, 1, true);
                        break;
                    } else {
                        Log.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=".concat(String.valueOf(j2)));
                        AppMethodBeat.o(22378);
                        return;
                    }
            }
        }
        AppMethodBeat.o(22378);
    }

    private static void ahd(String str) {
        Map<String, String> parseXml;
        AppMethodBeat.i(22379);
        Context context = MMApplicationContext.getContext();
        Intent intent = new Intent(context, LauncherUI.class);
        intent.putExtra("Intro_Notify", true);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        if (!Util.isNullOrNil(str) && str.startsWith("autoauth_errmsg_")) {
            str = str.substring(16);
        }
        if (!Util.isNullOrNil(str) && str.startsWith("<") && (parseXml = XmlParser.parseXml(str, "e", null)) != null && !Util.isNullOrNil(parseXml.get(".e.Content"))) {
            str = parseXml.get(".e.Content");
        }
        s.c g2 = a.cd(context, a.glE()).f(str).g(null);
        g2.Hv = PendingIntent.getActivity(context, 0, intent, 268435456);
        Notification build = g2.build();
        build.icon = a.ezb();
        build.flags = 16;
        bg.getNotification().c(build);
        AppMethodBeat.o(22379);
    }
}
