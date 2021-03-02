package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class g {
    public f gok;

    /* synthetic */ g(byte b2) {
        this();
    }

    public static class a {
        private static final g gol = new g((byte) 0);

        static {
            AppMethodBeat.i(19996);
            AppMethodBeat.o(19996);
        }
    }

    private g() {
        AppMethodBeat.i(19997);
        this.gok = new f();
        AppMethodBeat.o(19997);
    }

    public static boolean a(String str, ca caVar, int i2, boolean z) {
        AppMethodBeat.i(19998);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(19998);
            return false;
        }
        boolean a2 = d.a(str, caVar, i2, z);
        AppMethodBeat.o(19998);
        return a2;
    }

    public final int b(NotificationItem notificationItem) {
        AppMethodBeat.i(19999);
        int a2 = this.gok.a(notificationItem);
        AppMethodBeat.o(19999);
        return a2;
    }

    public final Notification a(Notification notification, int i2, int i3, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.i(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
        Notification a2 = this.gok.a(notification, i2, i3, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.o(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
        return a2;
    }
}
