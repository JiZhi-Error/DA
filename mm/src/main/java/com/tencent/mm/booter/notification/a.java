package com.tencent.mm.booter.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.g;

public class a {
    public int a(NotificationItem notificationItem, g gVar) {
        AppMethodBeat.i(19925);
        if (notificationItem == null) {
            AppMethodBeat.o(19925);
            return -1;
        }
        int a2 = notificationItem.a(gVar);
        AppMethodBeat.o(19925);
        return a2;
    }
}
