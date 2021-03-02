package com.tencent.mm.plugin.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.cp;
import com.tencent.mm.n.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;
import com.tencent.mm.sdk.vendor.MIUI;
import java.util.List;

public final class c {
    public static boolean a(Context context, NotificationManager notificationManager, boolean z, boolean z2, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(149365);
        if (!MIUI.ifMIUI()) {
            AppMethodBeat.o(149365);
            return false;
        }
        String apJ = a.apJ();
        NotificationChannel a2 = a(notificationManager, apJ);
        if (a2 == null) {
            a(context, notificationManager, apJ, z, z2, sharedPreferences);
        } else {
            cp.KL(b.aKB());
            String sj = cp.sj(2);
            String[] split = sj.split(";");
            Log.i("MicroMsg.NotificationManufacturerCompatibility", "xiaomiNotificationCompatibility() lastVersion:%s curVersion:%s", sj, Integer.valueOf(d.KyO));
            if (split != null && split.length == 2) {
                int parseInt = Integer.parseInt(split[0], 16);
                Log.i("MicroMsg.NotificationManufacturerCompatibility", "xiaomiNotificationCompatibility() lastVersion:%s", Integer.valueOf(parseInt));
                if (654311424 <= parseInt && parseInt <= 654312247 && !Util.isEqual(a2.getId(), "message_channel_compatibility_id")) {
                    if (a2.getSound() == null) {
                        try {
                            notificationManager.deleteNotificationChannel(a2.getId());
                            a(context, notificationManager, "message_channel_compatibility_id", z, z2, sharedPreferences);
                            a.bcS("message_channel_compatibility_id");
                        } catch (Exception e2) {
                            Log.e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", e2.getMessage());
                        }
                    } else {
                        a(context, notificationManager, apJ, z, z2, sharedPreferences);
                    }
                }
            }
        }
        AppMethodBeat.o(149365);
        return true;
    }

    public static boolean b(Context context, NotificationManager notificationManager, boolean z, boolean z2, SharedPreferences sharedPreferences) {
        boolean z3;
        AppMethodBeat.i(149366);
        boolean isEMUI8 = Huawei.isEMUI8();
        boolean isEMUI9 = Huawei.isEMUI9();
        if (isEMUI8 || isEMUI9) {
            String apJ = a.apJ();
            NotificationChannel a2 = a(notificationManager, apJ);
            if (a2 == null) {
                a(context, notificationManager, apJ, isEMUI8, isEMUI9, z, z2, sharedPreferences);
            } else {
                if (!isEMUI8 || (a2.shouldVibrate() && a2.getSound() != null)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    try {
                        if (a2.getSound() != null) {
                            g.Ej(a2.getSound().toString());
                        }
                        notificationManager.deleteNotificationChannel(a2.getId());
                        a(context, notificationManager, "message_channel_compatibility_id", isEMUI8, isEMUI9, z, z2, sharedPreferences);
                        a.bcS("message_channel_compatibility_id");
                    } catch (Exception e2) {
                        Log.e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", e2.getMessage());
                    }
                } else {
                    a(context, notificationManager, apJ, isEMUI8, isEMUI9, z, z2, sharedPreferences);
                }
            }
            AppMethodBeat.o(149366);
            return true;
        }
        AppMethodBeat.o(149366);
        return false;
    }

    private static void a(Context context, NotificationManager notificationManager, String str, boolean z, boolean z2, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(149367);
        NotificationChannel notificationChannel = new NotificationChannel(str, context.getString(R.string.fft), 4);
        notificationChannel.setDescription(context.getString(R.string.ffs));
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setVibrationPattern(Util.VIRBRATOR_PATTERN);
        notificationChannel.enableVibration(z);
        if (z2) {
            String string = sharedPreferences.getString("settings.ringtone", com.tencent.mm.n.b.gLX);
            if (aIY(string)) {
                Log.e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s", Uri.parse(string));
                notificationChannel.setSound(Uri.parse(string), Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        sharedPreferences.edit().putString("message_channel_id", str).commit();
        notificationManager.createNotificationChannel(notificationChannel);
        AppMethodBeat.o(149367);
    }

    private static void a(Context context, NotificationManager notificationManager, String str, boolean z, boolean z2, boolean z3, boolean z4, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(149368);
        NotificationChannel notificationChannel = new NotificationChannel(str, context.getString(R.string.fft), 4);
        notificationChannel.setDescription(context.getString(R.string.ffs));
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setVibrationPattern(Util.VIRBRATOR_PATTERN);
        if (z) {
            notificationChannel.enableVibration(true);
        } else {
            notificationChannel.enableVibration(z3);
        }
        if (z) {
            if (z4) {
                a(notificationChannel, sharedPreferences);
            }
        } else if (z2) {
            if (z4) {
                a(notificationChannel, sharedPreferences);
            } else {
                notificationChannel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        sharedPreferences.edit().putString("message_channel_id", str).commit();
        notificationManager.createNotificationChannel(notificationChannel);
        AppMethodBeat.o(149368);
    }

    private static void a(NotificationChannel notificationChannel, SharedPreferences sharedPreferences) {
        AppMethodBeat.i(149369);
        String string = sharedPreferences.getString("settings.ringtone", com.tencent.mm.n.b.gLX);
        if (aIY(string)) {
            notificationChannel.setSound(Uri.parse(string), Notification.AUDIO_ATTRIBUTES_DEFAULT);
        }
        AppMethodBeat.o(149369);
    }

    private static NotificationChannel a(NotificationManager notificationManager, String str) {
        AppMethodBeat.i(149371);
        try {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null) {
                AppMethodBeat.o(149371);
                return null;
            } else if (notificationChannels.size() <= 0) {
                AppMethodBeat.o(149371);
                return null;
            } else {
                for (NotificationChannel notificationChannel : notificationChannels) {
                    if (!(notificationChannel == null || notificationChannel.getId() == null || !Util.isEqual(notificationChannel.getId(), str))) {
                        AppMethodBeat.o(149371);
                        return notificationChannel;
                    }
                }
                AppMethodBeat.o(149371);
                return null;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.NotificationManufacturerCompatibility", "deleteNoNumberNotification exception:%s", e2.getMessage());
        }
    }

    public static boolean aIY(String str) {
        boolean z;
        AppMethodBeat.i(149372);
        if (!Util.isNullOrNil(str)) {
            z = t(Uri.parse(str));
        } else {
            z = false;
        }
        Log.e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s result = %s", Util.nullAs(str, BuildConfig.COMMAND), Boolean.valueOf(z));
        AppMethodBeat.o(149372);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean t(android.net.Uri r5) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.notification.c.t(android.net.Uri):boolean");
    }
}
