package com.tencent.mm.booter.notification.a;

import android.app.NotificationManager;
import android.media.AudioManager;
import android.text.format.Time;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.n.b;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.ca;
import java.util.HashSet;
import java.util.Set;

public final class e {
    private static final Set<String> gow;
    static final Time goy = new Time();
    public boolean gox;

    static {
        AppMethodBeat.i(20055);
        HashSet hashSet = new HashSet();
        gow = hashSet;
        hashSet.add("readerapp");
        gow.add("blogapp");
        gow.add("newsapp");
        AppMethodBeat.o(20055);
    }

    public static boolean Dc(String str) {
        AppMethodBeat.i(20044);
        if (MMEntryLock.isLocked("keep_chatting_silent".concat(String.valueOf(str)))) {
            Log.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: FALSE");
            AppMethodBeat.o(20044);
            return true;
        }
        Log.i("MicroMsg.Notification.Silent.Handle", "check is Sound NOT Lock: TRUE");
        AppMethodBeat.o(20044);
        return false;
    }

    public static boolean a(boolean[] zArr, boolean z, boolean z2) {
        boolean z3;
        if (z || z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z2;
        return z3;
    }

    public static boolean a(boolean[] zArr, boolean z) {
        boolean z2;
        if (!z) {
            z2 = true;
        } else {
            z2 = false;
        }
        zArr[0] = zArr[0] & z;
        zArr[1] = zArr[1] & z;
        return z2;
    }

    public static boolean Dd(String str) {
        boolean z = true;
        AppMethodBeat.i(20045);
        boolean contains = gow.contains(str);
        Object[] objArr = new Object[1];
        if (contains) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.Notification.Silent.Handle", "check is NOT Siler User: %B", objArr);
        AppMethodBeat.o(20045);
        return contains;
    }

    public static boolean alo() {
        AppMethodBeat.i(20046);
        goy.setToNow();
        int i2 = goy.hour;
        int i3 = goy.minute;
        MMApplicationContext.getContext();
        if (!b.ct(i2, i3)) {
            Log.w("MicroMsg.Notification.Silent.Handle", "no shake & sound notification during background deactive time");
            AppMethodBeat.o(20046);
            return true;
        }
        AppMethodBeat.o(20046);
        return false;
    }

    public static boolean alp() {
        AppMethodBeat.i(20047);
        boolean apR = g.apR();
        Log.i("MicroMsg.Notification.Silent.Handle", "check is Sound Mode: %B", Boolean.valueOf(apR));
        AppMethodBeat.o(20047);
        return apR;
    }

    public static boolean oa(int i2) {
        boolean z;
        AppMethodBeat.i(20048);
        if ((i2 & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Sound: %B", Boolean.valueOf(z));
        AppMethodBeat.o(20048);
        return z;
    }

    public static boolean a(String str, ca caVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(20049);
        if (!g.Er(str) || g.p(caVar)) {
            z = false;
        } else {
            z = true;
        }
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        Log.i("MicroMsg.Notification.Silent.Handle", "check is NOT Must Mute: %B", objArr);
        AppMethodBeat.o(20049);
        return z;
    }

    public static boolean alq() {
        boolean z = false;
        AppMethodBeat.i(231502);
        if (d.oD(28) && !MIUI.ifMIUI()) {
            NotificationManager notificationManager = (NotificationManager) MMApplicationContext.getContext().getSystemService("notification");
            if (notificationManager.getCurrentInterruptionFilter() == 2) {
                try {
                    z = !notificationManager.getNotificationChannel(a.glE()).canBypassDnd();
                } catch (Exception e2) {
                    Log.e("MicroMsg.Notification.Silent.Handle", "isSystemDoNotDisturb Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(231502);
        return z;
    }

    public static boolean alr() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(20050);
        try {
            zj zjVar = new zj();
            zjVar.efx.dKy = 2;
            EventCenter.instance.publish(zjVar);
            z = zjVar.efy.calling;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Notification.Silent.Handle", e2, "", new Object[0]);
            z = false;
        }
        Object[] objArr = new Object[1];
        if (z) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        Log.d("MicroMsg.Notification.Silent.Handle", "check is Voip NOT Calling: %B", objArr);
        AppMethodBeat.o(20050);
        return z;
    }

    public static boolean s(int i2, String str) {
        boolean z;
        AppMethodBeat.i(20051);
        if (g.oJ(i2)) {
            if (g.Em(str)) {
                z = g.aqH();
            } else if (g.En(str)) {
                z = g.aqI();
            }
            Log.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(z));
            AppMethodBeat.o(20051);
            return z;
        }
        z = true;
        Log.i("MicroMsg.Notification.Silent.Handle", "check is Voip Need Sound: %B", Boolean.valueOf(z));
        AppMethodBeat.o(20051);
        return z;
    }

    public static boolean als() {
        AppMethodBeat.i(20052);
        boolean apV = g.apV();
        int alt = alt();
        if (alt == 0) {
            apV = false;
        }
        Log.i("MicroMsg.Notification.Silent.Handle", "check is Shake Mode: %B, System AudioManager Mode: %d", Boolean.valueOf(apV), Integer.valueOf(alt));
        AppMethodBeat.o(20052);
        return apV;
    }

    public static int alt() {
        AppMethodBeat.i(20053);
        int ringerMode = ((AudioManager) MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getRingerMode();
        AppMethodBeat.o(20053);
        return ringerMode;
    }

    public static boolean ob(int i2) {
        boolean z;
        AppMethodBeat.i(20054);
        if ((i2 & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.Notification.Silent.Handle", "check is Service Request Shake: %B", Boolean.valueOf(z));
        AppMethodBeat.o(20054);
        return z;
    }
}
