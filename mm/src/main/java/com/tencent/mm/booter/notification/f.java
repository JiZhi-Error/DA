package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.d;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class f extends a {
    private NotificationManager Iw = ((NotificationManager) this.mContext.getSystemService("notification"));
    public d goc = new d();
    private Context mContext = MMApplicationContext.getContext();

    public f() {
        AppMethodBeat.i(19983);
        AppMethodBeat.o(19983);
    }

    public final int a(NotificationItem notificationItem) {
        AppMethodBeat.i(19985);
        if (notificationItem == null) {
            AppMethodBeat.o(19985);
            return -1;
        }
        int a2 = a(notificationItem, null);
        AppMethodBeat.o(19985);
        return a2;
    }

    @TargetApi(11)
    public final Notification a(Notification notification, int i2, int i3, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.i(19986);
        Notification a2 = this.goc.a(notification, i2, i3, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.o(19986);
        return a2;
    }

    public static void cancel() {
        AppMethodBeat.i(19984);
        v P = v.P(MMApplicationContext.getContext());
        LinkedList linkedList = new LinkedList();
        Queue<Integer> all = b.alj().all();
        StringBuilder sb = new StringBuilder();
        for (Integer num : all) {
            sb.append(num + ";");
            if (!linkedList.contains(num)) {
                b.alj().a(P, num.intValue());
                linkedList.add(num);
            }
        }
        Log.i("MicroMsg.Notification.Handle", "needRemoveNotificationId:%s", sb);
        AppMethodBeat.o(19984);
    }

    public static void r(int i2, String str) {
        ArrayList<d.a> arrayList;
        d.a aVar;
        AppMethodBeat.i(19987);
        Log.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", Integer.valueOf(i2), str);
        if (i2 == -1) {
            i2 = g.aqG();
        }
        d.nT(i2);
        if (str == null || str.length() <= 0) {
            arrayList = new ArrayList<>();
            for (String str2 : g.oK(-1)) {
                d.a aVar2 = new d.a((byte) 0);
                aVar2.userName = str2;
                aVar2.dOS = g.Eo(str2);
                arrayList.add(aVar2);
            }
        } else {
            ArrayList<d.a> alf = d.alf();
            if (alf == null) {
                arrayList = new ArrayList<>();
            } else {
                arrayList = alf;
            }
            Iterator<d.a> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = it.next();
                if (aVar.userName.equals(str)) {
                    arrayList.remove(aVar);
                    break;
                }
            }
            if (aVar == null) {
                aVar = new d.a((byte) 0);
            }
            aVar.userName = str;
            aVar.dOS = g.Eo(str);
            if (aVar.dOS == 0 && arrayList.isEmpty()) {
                d.h(null);
                AppMethodBeat.o(19987);
                return;
            } else if (aVar.dOS > 0) {
                arrayList.add(aVar);
            }
        }
        d.h(arrayList);
        AppMethodBeat.o(19987);
    }
}
