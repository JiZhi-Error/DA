package com.tencent.mm.plugin.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class PluginNotification extends f implements a {
    private ax AGG;

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(149374);
        Log.i("MicroMsg.PluginNotification", "execute");
        if (gVar.aBb()) {
            createNotificationChannel();
        }
        AppMethodBeat.o(149374);
    }

    @Override // com.tencent.mm.plugin.notification.b.a
    public void setNotification(ax axVar) {
        this.AGG = axVar;
        d.AGv = axVar;
    }

    @Override // com.tencent.mm.plugin.notification.b.a
    public ax getNotification() {
        return this.AGG;
    }

    private static void createNotificationChannel() {
        AppMethodBeat.i(149375);
        if (d.oD(26)) {
            Context context = MMApplicationContext.getContext();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            SharedPreferences apK = com.tencent.mm.kernel.a.apK();
            boolean z = apK.getBoolean("settings_sound", true);
            boolean z2 = apK.getBoolean("settings_shake", true);
            deleteNoWeChatSetNotification(notificationManager);
            deleteNoNumberNotification(notificationManager, com.tencent.mm.bq.a.apJ(), "message_channel");
            Log.i("MicroMsg.PluginNotification", "isEnableMsgNotification:%s isSysEnableMsgNotification:%s sound:%s vibration:%s", Boolean.valueOf(b.apN()), Boolean.valueOf(b.apO()), Boolean.valueOf(z), Boolean.valueOf(z2));
            boolean b2 = c.b(context, notificationManager, z2, z, apK);
            boolean a2 = c.a(context, notificationManager, z2, z, apK);
            if (!b2 && !a2) {
                NotificationChannel notificationChannel = new NotificationChannel(com.tencent.mm.bq.a.apJ(), context.getString(R.string.fft), 4);
                notificationChannel.setDescription(context.getString(R.string.ffs));
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.setVibrationPattern(Util.VIRBRATOR_PATTERN);
                notificationChannel.enableVibration(z2);
                if (z) {
                    String string = apK.getString("settings.ringtone", b.gLX);
                    if (c.aIY(string)) {
                        notificationChannel.setSound(Uri.parse(string), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                    }
                } else {
                    notificationChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
                apK.edit().putString("message_channel_id", com.tencent.mm.bq.a.apJ()).commit();
                notificationManager.createNotificationChannel(notificationChannel);
            }
            NotificationChannel notificationChannel2 = new NotificationChannel("reminder_channel_id", context.getString(R.string.fg4), 2);
            notificationChannel2.setDescription(context.getString(R.string.fg3));
            notificationManager.createNotificationChannel(notificationChannel2);
            if (!b.aqe()) {
                NotificationChannel notificationChannel3 = new NotificationChannel("message_dnd_mode_channel_id", context.getString(R.string.ffv), 4);
                notificationChannel3.setDescription(context.getString(R.string.ffu));
                notificationChannel3.enableLights(true);
                notificationChannel3.setLightColor(-16711936);
                notificationChannel3.enableVibration(false);
                notificationChannel3.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                notificationManager.createNotificationChannel(notificationChannel3);
            }
            if (d.oF(28) || Build.VERSION.CODENAME.equals("Q")) {
                notificationManager.deleteNotificationChannel("voip_channel_new_id");
                NotificationChannel notificationChannel4 = new NotificationChannel("voip_notify_channel_new_id", context.getString(R.string.fgp), 4);
                notificationChannel4.setDescription(context.getString(R.string.fgo));
                notificationChannel4.enableLights(true);
                notificationChannel4.setLightColor(-16711936);
                notificationChannel4.enableVibration(true);
                notificationChannel4.setLockscreenVisibility(0);
                notificationChannel4.setSound(Uri.parse("android.resource://" + MMApplicationContext.getContext().getPackageName() + "/raw/phonering"), null);
                notificationManager.createNotificationChannel(notificationChannel4);
            }
        }
        AppMethodBeat.o(149375);
    }

    private static void deleteNoNumberNotification(NotificationManager notificationManager, String str, String str2) {
        AppMethodBeat.i(149376);
        try {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null) {
                AppMethodBeat.o(149376);
            } else if (notificationChannels.size() <= 0) {
                AppMethodBeat.o(149376);
            } else {
                for (NotificationChannel notificationChannel : notificationChannels) {
                    if (notificationChannel != null && notificationChannel.getId() != null && notificationChannel.getId().startsWith(str2) && !Util.isEqual(notificationChannel.getId(), str)) {
                        notificationManager.deleteNotificationChannel(notificationChannel.getId());
                    }
                }
                AppMethodBeat.o(149376);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.PluginNotification", "deleteNoNumberNotification exception:%s", e2.getMessage());
            AppMethodBeat.o(149376);
        }
    }

    private static void deleteNoWeChatSetNotification(NotificationManager notificationManager) {
        AppMethodBeat.i(149377);
        try {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null) {
                AppMethodBeat.o(149377);
            } else if (notificationChannels.size() <= 0) {
                AppMethodBeat.o(149377);
            } else {
                for (NotificationChannel notificationChannel : notificationChannels) {
                    if (notificationChannel != null && notificationChannel.getId() != null && !Util.isEqual(notificationChannel.getId(), "message_dnd_mode_channel_id") && !Util.isEqual(notificationChannel.getId(), "reminder_channel_id") && !notificationChannel.getId().startsWith("message_channel")) {
                        Log.i("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification id:%s", notificationChannel.getId());
                        notificationManager.deleteNotificationChannel(notificationChannel.getId());
                    }
                }
                AppMethodBeat.o(149377);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification exception:%s", e2.getMessage());
            AppMethodBeat.o(149377);
        }
    }

    public static void createActiveTimeNotification() {
        AppMethodBeat.i(149378);
        if (d.oD(26)) {
            Context context = MMApplicationContext.getContext();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (notificationManager.getNotificationChannel("message_dnd_mode_channel_id") == null) {
                NotificationChannel notificationChannel = new NotificationChannel("message_dnd_mode_channel_id", context.getString(R.string.ffv), 4);
                notificationChannel.setDescription(context.getString(R.string.ffu));
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        AppMethodBeat.o(149378);
    }
}
