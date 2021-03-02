package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.a.e;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.booter.notification.d;
import com.tencent.mm.booter.notification.f;
import com.tencent.mm.booter.notification.g;
import com.tencent.mm.bq.a;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;

public final class l implements b {
    @Override // com.tencent.mm.plugin.zero.a.b
    public final void a(long j2, String str, String str2, String str3, String str4, int i2) {
        int i3;
        Bitmap bitmap;
        int i4;
        AppMethodBeat.i(22366);
        if (Util.isNullOrNil(str2)) {
            Context context = MMApplicationContext.getContext();
            if (g.Eq(str)) {
                i4 = R.string.b25;
            } else {
                i4 = R.string.e3s;
            }
            str2 = context.getString(i4);
        }
        f fVar = g.a.gol.gok;
        if (!com.tencent.mm.n.g.apQ()) {
            f.cancel();
        }
        try {
            d dVar = fVar.goc;
            Context context2 = MMApplicationContext.getContext();
            MMApplicationContext.getContext();
            boolean als = e.als();
            MMApplicationContext.getContext();
            boolean alp = e.alp();
            Log.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", Boolean.valueOf(als), Boolean.valueOf(alp));
            if (j2 != 0) {
                if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
                    Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
                    AppMethodBeat.o(22366);
                    return;
                } else if (com.tencent.mm.n.g.aqD() && !com.tencent.mm.n.g.aqE()) {
                    Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
                    AppMethodBeat.o(22366);
                    return;
                } else if (!com.tencent.mm.n.g.apN()) {
                    Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
                    AppMethodBeat.o(22366);
                    return;
                } else if (d.yP(j2)) {
                    Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
                    AppMethodBeat.o(22366);
                    return;
                } else {
                    com.tencent.mm.booter.notification.queue.b.alj().restore();
                    int ale = d.ale() + 1;
                    d.a c2 = d.c(d.alf(), str);
                    if (c2 == null) {
                        i3 = 0;
                    } else {
                        i3 = c2.dOS;
                    }
                    int i5 = i3 + 1;
                    ArrayList<d.a> alf = d.alf();
                    if (alf == null) {
                        alf = new ArrayList<>();
                    }
                    d.a c3 = d.c(alf, str);
                    if (c3 == null) {
                        d.a aVar = new d.a((byte) 0);
                        aVar.userName = str;
                        aVar.dOS = 1;
                        alf.add(aVar);
                    } else {
                        c3.dOS++;
                    }
                    d.h(alf);
                    d.nT(d.ale() + 1);
                    int size = alf.size();
                    if (e.alo()) {
                        alp = false;
                        als = false;
                    }
                    Notification ald = d.ald();
                    int Da = com.tencent.mm.booter.notification.queue.b.alj().Da(str);
                    dVar.dnt.goQ = ale;
                    dVar.dnt.goP = size;
                    dVar.dnt.goW = als;
                    dVar.dnt.goV = alp;
                    boolean apQ = com.tencent.mm.n.g.apQ();
                    int ezb = a.ezb();
                    com.tencent.mm.booter.notification.a.g gVar = dVar.dnt;
                    gVar.goI.a(gVar.mContext, alp, als, ald, null);
                    int i6 = gVar.goI.gou;
                    Log.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", Integer.valueOf(Da), str, Integer.valueOf(i2), Integer.valueOf(ale), Integer.valueOf(size), Boolean.FALSE, Boolean.valueOf(apQ));
                    Intent intent = new Intent(context2, LauncherUI.class);
                    intent.putExtra("nofification_type", "new_msg_nofification");
                    intent.putExtra("Main_User", str);
                    intent.putExtra("MainUI_User_Last_Msg_Type", i2);
                    intent.addFlags(536870912);
                    intent.addFlags(67108864);
                    if (apQ) {
                        intent.putExtra("talkerCount", 1);
                        intent.putExtra("Intro_Is_Muti_Talker", false);
                    } else {
                        if (size <= 1) {
                            intent.putExtra("Intro_Is_Muti_Talker", false);
                        } else {
                            intent.putExtra("Intro_Is_Muti_Talker", true);
                        }
                        intent.putExtra("talkerCount", size);
                    }
                    intent.putExtra("pushcontent_unread_count", ale);
                    PendingIntent c4 = com.tencent.mm.booter.notification.a.d.c(context2, Da, intent);
                    String d2 = h.d(context2, str2, apQ);
                    String a2 = h.a(context2, str3, size, ale, i5, apQ);
                    String e2 = h.e(context2, str3, apQ);
                    if (com.tencent.mm.n.g.apQ()) {
                        bitmap = com.tencent.mm.booter.notification.a.a.a(context2, com.tencent.mm.booter.notification.a.a.V(str, str4));
                    } else {
                        bitmap = null;
                    }
                    NotificationItem notificationItem = new NotificationItem(Da, str, dVar.a(ald, ezb, i6, c4, d2, a2, e2, bitmap, str));
                    notificationItem.gof = j2;
                    notificationItem.gog = i5;
                    dVar.a(notificationItem, dVar.dnt);
                    com.tencent.mm.booter.notification.e.nU(dVar.dnt.alw());
                    com.tencent.mm.booter.notification.e.D(str, i5);
                }
            }
            AppMethodBeat.o(22366);
        } catch (Exception e3) {
            Log.e("MicroMsg.Notification.Handle", "push:notify, error");
            Log.printErrStackTrace("MicroMsg.Notification.Handle", e3, "", new Object[0]);
            AppMethodBeat.o(22366);
        }
    }

    @Override // com.tencent.mm.plugin.zero.a.b
    public final void ckp() {
        AppMethodBeat.i(22367);
        com.tencent.mm.booter.notification.g unused = g.a.gol;
        f.r(-1, null);
        AppMethodBeat.o(22367);
    }
}
