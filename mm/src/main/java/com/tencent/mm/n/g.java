package com.tencent.mm.n;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g extends b {
    private static String TAG = "MicroMsg.NotificationConfig";

    public static void dA(boolean z) {
        AppMethodBeat.i(149999);
        apK().edit().putBoolean("settings_new_msg_notification", z).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", Boolean.valueOf(z));
        AppMethodBeat.o(149999);
    }

    public static void dB(boolean z) {
        AppMethodBeat.i(150000);
        apK().edit().putBoolean("settings_new_voip_msg_notification", z).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", Boolean.valueOf(z));
        AppMethodBeat.o(150000);
    }

    public static void dC(boolean z) {
        AppMethodBeat.i(150001);
        apK().edit().putBoolean("settings_show_detail", z).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", Boolean.valueOf(z));
        AppMethodBeat.o(150001);
    }

    public static void dD(boolean z) {
        AppMethodBeat.i(150002);
        apK().edit().putBoolean("settings_sound", z).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", Boolean.valueOf(z));
        AppMethodBeat.o(150002);
    }

    public static void dE(boolean z) {
        AppMethodBeat.i(150003);
        apK().edit().putBoolean("settings_shake", z).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", Boolean.valueOf(z));
        AppMethodBeat.o(150003);
    }

    public static void Ej(String str) {
        AppMethodBeat.i(150004);
        b.Ej(str);
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", str);
        AppMethodBeat.o(150004);
    }

    public static void dF(boolean z) {
        AppMethodBeat.i(150005);
        apK().edit().putBoolean("settings_special_scene_sound", z).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", Boolean.valueOf(z));
        AppMethodBeat.o(150005);
    }

    public static void dG(boolean z) {
        AppMethodBeat.i(150006);
        apK().edit().putBoolean("settings_special_scene_shake", z).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", Boolean.valueOf(z));
        AppMethodBeat.o(150006);
    }

    public static void dH(boolean z) {
        AppMethodBeat.i(150007);
        apK().edit().putBoolean("settings_voip_scene_sound", z).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", Boolean.valueOf(z));
        AppMethodBeat.o(150007);
    }

    public static void dI(boolean z) {
        AppMethodBeat.i(150008);
        apK().edit().putBoolean("settings_voip_scene_shake", z).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", Boolean.valueOf(z));
        AppMethodBeat.o(150008);
    }

    public static void dJ(boolean z) {
        AppMethodBeat.i(150009);
        apK().edit().putBoolean("settings_active_time_full", z).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", Boolean.valueOf(z));
        AppMethodBeat.o(150009);
    }

    public static void cu(int i2, int i3) {
        AppMethodBeat.i(150010);
        SharedPreferences apK = apK();
        apK.edit().putInt("settings_active_begin_time_hour", i2).commit();
        apK.edit().putInt("settings_active_begin_time_min", i3).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(150010);
    }

    public static void cv(int i2, int i3) {
        AppMethodBeat.i(150011);
        SharedPreferences apK = apK();
        apK.edit().putInt("settings_active_end_time_hour", i2).commit();
        apK.edit().putInt("settings_active_end_time_min", i3).commit();
        Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(150011);
    }

    public static void oI(int i2) {
        AppMethodBeat.i(150013);
        apK().edit().putInt("notification.status.webonline.push.open", i2).commit();
        AppMethodBeat.o(150013);
    }

    public static boolean aqE() {
        AppMethodBeat.i(150014);
        boolean rP = z.rP(apK().getInt("notification.status.webonline.push.open", 0));
        AppMethodBeat.o(150014);
        return rP;
    }

    public static boolean oJ(int i2) {
        return i2 == 50 || i2 == 53;
    }

    public static boolean Em(String str) {
        AppMethodBeat.i(150015);
        zj zjVar = new zj();
        zjVar.efx.dKy = 1;
        zjVar.efx.content = str;
        EventCenter.instance.publish(zjVar);
        if (zjVar.efy.type == 2 || str.equals(ca.OqC)) {
            AppMethodBeat.o(150015);
            return true;
        }
        AppMethodBeat.o(150015);
        return false;
    }

    public static boolean En(String str) {
        AppMethodBeat.i(150016);
        zj zjVar = new zj();
        zjVar.efx.dKy = 1;
        zjVar.efx.content = str;
        EventCenter.instance.publish(zjVar);
        if (zjVar.efy.type == 3 || str.equals(ca.OqB)) {
            AppMethodBeat.o(150016);
            return true;
        }
        AppMethodBeat.o(150016);
        return false;
    }

    public static int aqF() {
        AppMethodBeat.i(150017);
        if (!com.tencent.mm.kernel.g.aAc()) {
            Log.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
            AppMethodBeat.o(150017);
            return 0;
        }
        int size = ac.JR(ab.iCF).size();
        AppMethodBeat.o(150017);
        return size;
    }

    public static List<String> oK(int i2) {
        AppMethodBeat.i(223500);
        ArrayList arrayList = new ArrayList();
        Map<String, as> JR = ac.JR(ab.iCF);
        for (String str : JR.keySet()) {
            i2--;
            arrayList.add(JR.get(str).arI());
            if (i2 == 0) {
                break;
            }
        }
        AppMethodBeat.o(223500);
        return arrayList;
    }

    public static int aqG() {
        AppMethodBeat.i(150019);
        if (!com.tencent.mm.kernel.g.aAc()) {
            Log.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
            AppMethodBeat.o(150019);
            return 0;
        }
        int JP = ac.JP(ab.iCF);
        AppMethodBeat.o(150019);
        return JP;
    }

    public static int Eo(String str) {
        AppMethodBeat.i(150021);
        int aI = ac.aI(str, null);
        AppMethodBeat.o(150021);
        return aI;
    }

    public static boolean Ep(String str) {
        AppMethodBeat.i(150022);
        boolean IG = as.IG(str);
        AppMethodBeat.o(150022);
        return IG;
    }

    public static boolean Eq(String str) {
        AppMethodBeat.i(150023);
        boolean Iw = ab.Iw(str);
        AppMethodBeat.o(150023);
        return Iw;
    }

    public static boolean Er(String str) {
        AppMethodBeat.i(150024);
        if (ab.JJ(str) || ((ab.Eq(str) && !ab.JI(str)) || (ab.Iy(str) && !ab.JI(str)))) {
            AppMethodBeat.o(150024);
            return true;
        }
        AppMethodBeat.o(150024);
        return false;
    }

    public static int Es(String str) {
        AppMethodBeat.i(150025);
        int bkn = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().bkn(str);
        AppMethodBeat.o(150025);
        return bkn;
    }

    public static boolean p(ca caVar) {
        AppMethodBeat.i(150026);
        if (caVar == null) {
            AppMethodBeat.o(150026);
            return false;
        }
        boolean bkz = caVar.bkz(z.aTY());
        AppMethodBeat.o(150026);
        return bkz;
    }

    public static boolean aqH() {
        AppMethodBeat.i(150027);
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(73217, Boolean.TRUE)).booleanValue();
        AppMethodBeat.o(150027);
        return booleanValue;
    }

    public static boolean aqI() {
        AppMethodBeat.i(150028);
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(73218, Boolean.TRUE)).booleanValue();
        AppMethodBeat.o(150028);
        return booleanValue;
    }

    public static boolean aqD() {
        AppMethodBeat.i(150012);
        boolean qd = a.qd(a.azm());
        AppMethodBeat.o(150012);
        return qd;
    }
}
