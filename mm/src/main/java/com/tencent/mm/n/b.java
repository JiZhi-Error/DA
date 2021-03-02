package com.tencent.mm.n;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.MIUI;

public class b {
    private static int gLW = -1;
    public static final String gLX = null;
    private static String gLY = "";
    private static SharedPreferences gLZ = null;
    private static NotificationChannel gMa;
    private static String gMb = gLX;
    private static boolean gMc = false;
    private static boolean gMd = false;

    public static String apJ() {
        AppMethodBeat.i(149964);
        if (Util.isNullOrNil(gLY)) {
            gLY = a.apK().getString("message_channel_id", "message_channel_new_id");
        }
        String str = gLY;
        AppMethodBeat.o(149964);
        return str;
    }

    protected static SharedPreferences apK() {
        AppMethodBeat.i(149965);
        if (gLZ != null) {
            SharedPreferences sharedPreferences = gLZ;
            AppMethodBeat.o(149965);
            return sharedPreferences;
        }
        SharedPreferences apK = a.apK();
        gLZ = apK;
        AppMethodBeat.o(149965);
        return apK;
    }

    public static SharedPreferences apL() {
        AppMethodBeat.i(149966);
        SharedPreferences bke = af.bke();
        AppMethodBeat.o(149966);
        return bke;
    }

    public static boolean apM() {
        AppMethodBeat.i(149967);
        if (d.oD(26)) {
            AppMethodBeat.o(149967);
            return true;
        }
        AppMethodBeat.o(149967);
        return false;
    }

    public static boolean apN() {
        AppMethodBeat.i(149968);
        boolean z = apK().getBoolean("settings_new_msg_notification", true);
        AppMethodBeat.o(149968);
        return z;
    }

    public static boolean apO() {
        AppMethodBeat.i(149969);
        if (!v.P(MMApplicationContext.getContext()).areNotificationsEnabled()) {
            AppMethodBeat.o(149969);
            return false;
        }
        if (d.oD(26)) {
            if (gMa == null) {
                gMa = ((NotificationManager) MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(apJ());
            }
            if (gMa != null && gMa.getImportance() <= 0) {
                AppMethodBeat.o(149969);
                return false;
            }
        }
        AppMethodBeat.o(149969);
        return true;
    }

    public static boolean apP() {
        AppMethodBeat.i(149970);
        boolean z = apK().getBoolean("settings_new_voip_msg_notification", true);
        AppMethodBeat.o(149970);
        return z;
    }

    public static boolean apQ() {
        AppMethodBeat.i(149971);
        boolean z = apK().getBoolean("settings_show_detail", true);
        AppMethodBeat.o(149971);
        return z;
    }

    public static boolean apR() {
        boolean z;
        AppMethodBeat.i(149972);
        boolean z2 = apK().getBoolean("settings_sound", true);
        if (!d.oD(26)) {
            z = z2;
        } else if (gLW == 0) {
            z = apS();
            if (z2 != z) {
                g.dD(z);
            }
        } else {
            z = apY();
        }
        AppMethodBeat.o(149972);
        return z;
    }

    public static boolean apS() {
        AppMethodBeat.i(149973);
        if (d.oD(26)) {
            NotificationChannel notificationChannel = ((NotificationManager) MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(apJ());
            if (notificationChannel != null && notificationChannel.getImportance() < 3) {
                AppMethodBeat.o(149973);
                return false;
            } else if (notificationChannel != null && notificationChannel.getSound() == null) {
                AppMethodBeat.o(149973);
                return false;
            }
        } else {
            int importance = v.P(MMApplicationContext.getContext()).getImportance();
            if (importance < 3 && importance != -1000) {
                AppMethodBeat.o(149973);
                return false;
            }
        }
        AppMethodBeat.o(149973);
        return true;
    }

    public static boolean apT() {
        AppMethodBeat.i(149974);
        if (d.oF(28)) {
            NotificationChannel notificationChannel = ((NotificationManager) MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel("voip_notify_channel_new_id");
            if (notificationChannel != null && notificationChannel.getImportance() < 3) {
                AppMethodBeat.o(149974);
                return false;
            } else if (notificationChannel == null || notificationChannel.getSound() != null) {
                AppMethodBeat.o(149974);
                return true;
            } else {
                AppMethodBeat.o(149974);
                return false;
            }
        } else {
            AppMethodBeat.o(149974);
            return true;
        }
    }

    public static boolean apU() {
        AppMethodBeat.i(149975);
        if (d.oF(28)) {
            NotificationChannel notificationChannel = ((NotificationManager) MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel("voip_notify_channel_new_id");
            if (notificationChannel == null || (notificationChannel.getImportance() >= 3 && notificationChannel.shouldVibrate())) {
                AppMethodBeat.o(149975);
                return true;
            }
            AppMethodBeat.o(149975);
            return false;
        }
        AppMethodBeat.o(149975);
        return true;
    }

    public static boolean apV() {
        boolean z;
        AppMethodBeat.i(149976);
        boolean z2 = apK().getBoolean("settings_shake", true);
        if (!d.oD(26)) {
            z = z2;
        } else if (gLW == 0) {
            z = apW();
            if (z != z2) {
                g.dE(z);
            }
        } else {
            z = apZ();
        }
        AppMethodBeat.o(149976);
        return z;
    }

    public static boolean apW() {
        AppMethodBeat.i(149977);
        if (d.oD(26)) {
            NotificationChannel notificationChannel = ((NotificationManager) MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(apJ());
            if (notificationChannel != null && (notificationChannel.getImportance() < 3 || !notificationChannel.shouldVibrate())) {
                AppMethodBeat.o(149977);
                return false;
            }
        } else {
            int importance = v.P(MMApplicationContext.getContext()).getImportance();
            if (importance < 3 && importance != -1000) {
                AppMethodBeat.o(149977);
                return false;
            }
        }
        AppMethodBeat.o(149977);
        return true;
    }

    public static String apX() {
        AppMethodBeat.i(149978);
        if (!d.oD(26)) {
            String string = apK().getString("settings.ringtone", gLX);
            if (string != gLX && !string.equals(gMb)) {
                RingtoneManager ringtoneManager = new RingtoneManager(MMApplicationContext.getContext());
                ringtoneManager.setType(2);
                try {
                    if (ringtoneManager.getRingtonePosition(Uri.parse(string)) < 0) {
                        string = gLX;
                        Ej(string);
                        Log.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
                    }
                    if (ringtoneManager.getCursor() != null) {
                        ringtoneManager.getCursor().close();
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.BaseNotificationConfig", e2, "ringTone() Exception:%s", e2.getMessage());
                    if (ringtoneManager.getCursor() != null) {
                        ringtoneManager.getCursor().close();
                    }
                } catch (Throwable th) {
                    if (ringtoneManager.getCursor() != null) {
                        ringtoneManager.getCursor().close();
                    }
                    AppMethodBeat.o(149978);
                    throw th;
                }
                gMb = string;
            }
            AppMethodBeat.o(149978);
            return string;
        }
        NotificationChannel notificationChannel = ((NotificationManager) MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(apJ());
        if (notificationChannel == null || notificationChannel.getSound() == null) {
            AppMethodBeat.o(149978);
            return "";
        }
        String uri = notificationChannel.getSound().toString();
        AppMethodBeat.o(149978);
        return uri;
    }

    static void Ej(String str) {
        AppMethodBeat.i(149979);
        apK().edit().putString("settings.ringtone", str).commit();
        AppMethodBeat.o(149979);
    }

    public static boolean apY() {
        AppMethodBeat.i(149980);
        SharedPreferences apK = apK();
        boolean z = apK.getBoolean("settings_special_scene_sound", apK.getBoolean("settings_sound", true));
        AppMethodBeat.o(149980);
        return z;
    }

    public static boolean apZ() {
        AppMethodBeat.i(149981);
        SharedPreferences apK = apK();
        boolean z = apK.getBoolean("settings_special_scene_shake", apK.getBoolean("settings_shake", true));
        AppMethodBeat.o(149981);
        return z;
    }

    public static boolean aqa() {
        AppMethodBeat.i(149982);
        SharedPreferences apK = apK();
        boolean z = apK.getBoolean("settings_voip_scene_sound", apR());
        if (!gMc) {
            gMc = true;
            apK.edit().putBoolean("settings_voip_scene_sound", z).commit();
        }
        AppMethodBeat.o(149982);
        return z;
    }

    public static boolean aqb() {
        AppMethodBeat.i(149983);
        SharedPreferences apK = apK();
        boolean z = apK.getBoolean("settings_voip_scene_shake", apV());
        if (!gMd) {
            gMd = true;
            apK.edit().putBoolean("settings_voip_scene_shake", z).commit();
        }
        AppMethodBeat.o(149983);
        return z;
    }

    public static int aqc() {
        return gLW;
    }

    public static void aqd() {
        AppMethodBeat.i(149984);
        if (MIUI.ifMIUI()) {
            gLW = 1;
            Log.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() mSpecialSceneSwitchEnable:%s", Integer.valueOf(gLW));
            AppMethodBeat.o(149984);
            return;
        }
        int i2 = apK().getInt("special_scene_enable", -1);
        if (Util.isEqual(i2, -1)) {
            gLW = 0;
        } else {
            gLW = i2;
        }
        Log.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() sceneEnable:%s mSpecialSceneSwitchEnable:%s", Integer.valueOf(i2), Integer.valueOf(gLW));
        AppMethodBeat.o(149984);
    }

    public static boolean aqe() {
        AppMethodBeat.i(149985);
        boolean z = apK().getBoolean("settings_active_time_full", true);
        AppMethodBeat.o(149985);
        return z;
    }

    public static int aqf() {
        AppMethodBeat.i(149986);
        int i2 = apK().getInt("settings_active_begin_time_hour", 8);
        AppMethodBeat.o(149986);
        return i2;
    }

    public static int aqg() {
        AppMethodBeat.i(149987);
        int i2 = apK().getInt("settings_active_end_time_hour", 23);
        AppMethodBeat.o(149987);
        return i2;
    }

    public static int aqh() {
        AppMethodBeat.i(149988);
        int i2 = apK().getInt("settings_active_begin_time_min", 0);
        AppMethodBeat.o(149988);
        return i2;
    }

    public static int aqi() {
        AppMethodBeat.i(149989);
        int i2 = apK().getInt("settings_active_end_time_min", 0);
        AppMethodBeat.o(149989);
        return i2;
    }

    public static boolean ct(int i2, int i3) {
        AppMethodBeat.i(149990);
        if (aqe()) {
            AppMethodBeat.o(149990);
            return true;
        }
        int aqf = aqf();
        int aqh = aqh();
        int aqg = aqg();
        int aqi = aqi();
        if (aqf == aqg && aqh == aqi) {
            AppMethodBeat.o(149990);
            return false;
        } else if (aqf != aqg || aqh >= aqi) {
            if (aqg > aqf) {
                if ((i2 <= aqf || i2 >= aqg) && ((i2 != aqf || i3 <= aqh) && (i2 != aqg || i3 >= aqi))) {
                    AppMethodBeat.o(149990);
                    return false;
                }
                AppMethodBeat.o(149990);
                return true;
            } else if (aqg >= aqf && (aqf != aqg || aqh <= aqi)) {
                AppMethodBeat.o(149990);
                return true;
            } else if ((i2 <= aqf || i2 > 23) && ((i2 != aqf || i3 <= aqh) && ((i2 != aqg || i3 >= aqi) && (i2 <= 0 || i2 >= aqg)))) {
                AppMethodBeat.o(149990);
                return false;
            } else {
                AppMethodBeat.o(149990);
                return true;
            }
        } else if (i2 != aqf || i3 <= aqh || i3 >= aqi) {
            AppMethodBeat.o(149990);
            return false;
        } else {
            AppMethodBeat.o(149990);
            return true;
        }
    }
}
