package com.tencent.mm.booter.notification.a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.f;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e;

public final class b {
    public int gou = 0;

    public final int a(Context context, boolean z, boolean z2, Notification notification, String str) {
        AppMethodBeat.i(20038);
        if (g.apM()) {
            int a2 = a(context, z, z2, notification);
            AppMethodBeat.o(20038);
            return a2;
        }
        int b2 = b(context, z, z2, notification, str);
        AppMethodBeat.o(20038);
        return b2;
    }

    private int a(Context context, boolean z, boolean z2, Notification notification) {
        int i2;
        AppMethodBeat.i(20039);
        if (notification == null) {
            notification = new Notification();
        }
        Log.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), g.a(notification.vibrate), notification.sound);
        if (z2) {
            notification.vibrate = Util.VIRBRATOR_PATTERN;
        }
        if (z) {
            String apX = g.apX();
            if (co(context)) {
                notification.sound = null;
                i2 = 0;
            } else if (apX == null || apX == e.l.gLX) {
                i2 = 1;
            } else {
                notification.sound = Uri.parse(apX);
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        Log.i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", Integer.valueOf(i2), g.a(notification.vibrate), notification.sound);
        this.gou = i2;
        int i3 = this.gou;
        AppMethodBeat.o(20039);
        return i3;
    }

    private int b(Context context, boolean z, boolean z2, Notification notification, String str) {
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        boolean z6;
        int i3;
        AppMethodBeat.i(20040);
        Log.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), notification.vibrate, notification.sound);
        int i4 = 0;
        boolean z7 = false;
        boolean z8 = false;
        if (!z) {
            z3 = false;
        } else if (co(context)) {
            z3 = true;
        } else {
            i4 = 1;
            z3 = false;
        }
        if (z2) {
            i4 |= 2;
        }
        String apX = g.apX();
        if (Util.isNullOrNil(str)) {
            Log.d("MicroMsg.NotificationDefaults", "msgContent is null");
        }
        if (ae.gKE.gGN != 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            if (nY(i4)) {
                i2 = i4 & -3;
                Util.shake(context, true);
                z7 = true;
            } else {
                i2 = i4;
            }
            if (!nZ(i2) || z3) {
                z5 = z7;
            } else {
                i2 &= -2;
                f.a.goH.De(apX);
                z8 = true;
                z5 = z7;
            }
        } else {
            z5 = false;
            i2 = i4;
        }
        if (z3) {
            i3 = i2 & -2;
            f.a.goH.De(apX);
            z6 = true;
        } else if (!nZ(i2) || apX == null) {
            z6 = z8;
            i3 = i2;
        } else {
            i3 = i2 & -2;
            notification.sound = Uri.parse(apX);
            z6 = z8;
        }
        this.gou = i3;
        Log.i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, SrvDeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", Integer.valueOf(notification.defaults), g.a(notification.vibrate), notification.sound, apX, Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6));
        int i5 = this.gou;
        AppMethodBeat.o(20040);
        return i5;
    }

    private static boolean nY(int i2) {
        return (i2 & 2) > 0;
    }

    private static boolean nZ(int i2) {
        return (i2 & 1) > 0;
    }

    private static boolean co(Context context) {
        AppMethodBeat.i(20041);
        AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (audioManager == null) {
            AppMethodBeat.o(20041);
            return false;
        }
        boolean isWiredHeadsetOn = audioManager.isWiredHeadsetOn();
        AppMethodBeat.o(20041);
        return isWiredHeadsetOn;
    }
}
