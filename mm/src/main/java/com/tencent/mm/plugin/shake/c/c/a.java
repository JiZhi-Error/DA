package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a {
    private static SimpleDateFormat qkZ = null;

    public static void eUg() {
        AppMethodBeat.i(28240);
        Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
        if (!eUh()) {
            Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
            if (eUA()) {
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.TRUE);
                Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
                AppMethodBeat.o(28240);
                return;
            }
            Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
            AppMethodBeat.o(28240);
            return;
        }
        Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
        if (!eUA()) {
            Log.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.FALSE);
        }
        AppMethodBeat.o(28240);
    }

    public static boolean eUh() {
        boolean z;
        AppMethodBeat.i(28241);
        if (!bg.aAc()) {
            Log.e("MicroMsg.ShakeCardUtil", "acc is not ready");
            AppMethodBeat.o(28241);
            return false;
        }
        bg.aVF();
        Object obj = c.azQ().get(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_OPEN_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        } else {
            z = false;
        }
        AppMethodBeat.o(28241);
        return z;
    }

    private static boolean eUA() {
        AppMethodBeat.i(28242);
        int eUB = eUB();
        int eUC = eUC();
        Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + eUB + " end time : " + eUC);
        if (eUB <= 0) {
            Log.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + eUB + " , invalid");
            AppMethodBeat.o(28242);
            return false;
        } else if (eUC <= 0) {
            Log.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + eUC + " , invalid");
            AppMethodBeat.o(28242);
            return false;
        } else if (eUB >= eUC) {
            Log.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
            AppMethodBeat.o(28242);
            return false;
        } else {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : ".concat(String.valueOf(currentTimeMillis)));
            if (currentTimeMillis < eUB || currentTimeMillis > eUC) {
                Log.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
                AppMethodBeat.o(28242);
                return false;
            }
            Log.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
            AppMethodBeat.o(28242);
            return true;
        }
    }

    private static int eUB() {
        AppMethodBeat.i(28243);
        bg.aVF();
        int intValue = ((Integer) c.azQ().get(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, (Object) 0)).intValue();
        AppMethodBeat.o(28243);
        return intValue;
    }

    private static int eUC() {
        AppMethodBeat.i(28244);
        bg.aVF();
        int intValue = ((Integer) c.azQ().get(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, (Object) 0)).intValue();
        AppMethodBeat.o(28244);
        return intValue;
    }

    public static int eUD() {
        AppMethodBeat.i(28245);
        bg.aVF();
        int intValue = ((Integer) c.azQ().get(ar.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, (Object) 0)).intValue();
        AppMethodBeat.o(28245);
        return intValue;
    }

    public static String eUE() {
        AppMethodBeat.i(28246);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, "");
        AppMethodBeat.o(28246);
        return str;
    }

    public static String eUF() {
        AppMethodBeat.i(28247);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, "");
        AppMethodBeat.o(28247);
        return str;
    }

    public static String eUG() {
        AppMethodBeat.i(28248);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, "");
        AppMethodBeat.o(28248);
        return str;
    }

    public static String eUH() {
        AppMethodBeat.i(28249);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, "");
        AppMethodBeat.o(28249);
        return str;
    }

    public static String eUI() {
        AppMethodBeat.i(28250);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_DESC_STRING_SYNC, "");
        AppMethodBeat.o(28250);
        return str;
    }

    public static String eUJ() {
        AppMethodBeat.i(28251);
        bg.aVF();
        String str = (String) c.azQ().get(ar.a.USERINFO_SHAKE_CARD_TAB_RED_DOT_ID_STRING_SYNC, "");
        AppMethodBeat.o(28251);
        return str;
    }

    public static boolean Xx(int i2) {
        return i2 >= 0 && i2 <= 5;
    }

    public static int eUK() {
        AppMethodBeat.i(28252);
        bg.aVF();
        int uin = c.getUin();
        int nextInt = (new Random((long) uin).nextInt(10) + ((int) (System.currentTimeMillis() % 10))) % 10;
        Log.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:".concat(String.valueOf(nextInt)));
        AppMethodBeat.o(28252);
        return nextInt;
    }

    public static int Xy(int i2) {
        switch (i2) {
            case 0:
            default:
                return 0;
            case 1:
                return 10;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 120;
            case 5:
                return 240;
        }
    }

    public static int Xz(int i2) {
        switch (i2) {
            case 0:
            default:
                return 10;
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 90;
            case 5:
                return 120;
            case 6:
                return 150;
            case 7:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 8:
                return 240;
            case 9:
                return 300;
        }
    }

    public static int ake(String str) {
        AppMethodBeat.i(28253);
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            Log.e("MicroMsg.ShakeCardUtil", "string format error");
            AppMethodBeat.o(28253);
        } else {
            try {
                String upperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(upperCase.substring(0, 2), 16), Integer.parseInt(upperCase.substring(2, 4), 16), Integer.parseInt(upperCase.substring(4, 6), 16));
                AppMethodBeat.o(28253);
            } catch (Exception e2) {
                Log.e("MicroMsg.ShakeCardUtil", e2.toString());
                AppMethodBeat.o(28253);
            }
        }
        return rgb;
    }

    public static String AF(long j2) {
        AppMethodBeat.i(28254);
        long j3 = 1000 * j2;
        new GregorianCalendar().setTimeInMillis(j3);
        if (qkZ == null) {
            qkZ = new SimpleDateFormat("yyyy.MM.dd");
        }
        String format = qkZ.format(new Date(j3));
        AppMethodBeat.o(28254);
        return format;
    }

    public static void H(Context context, String str, String str2) {
        AppMethodBeat.i(28255);
        Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
        Intent intent = new Intent();
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_card_ext", str2);
        intent.putExtra("key_from_scene", 15);
        com.tencent.mm.br.c.b(context, "card", ".ui.CardDetailUI", intent);
        AppMethodBeat.o(28255);
    }

    public static boolean eUL() {
        AppMethodBeat.i(28256);
        if (!eUh() || !LocaleUtil.isChineseAppLang()) {
            AppMethodBeat.o(28256);
            return false;
        }
        AppMethodBeat.o(28256);
        return true;
    }

    public static void eUi() {
        AppMethodBeat.i(28257);
        Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i2 = LocalCache.TIME_DAY + currentTimeMillis;
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, Integer.valueOf(currentTimeMillis));
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, Integer.valueOf(i2));
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, "");
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, (Object) 0);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, (Object) 1);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, (Object) 6);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, "");
        com.tencent.mm.y.c.axV().B(262154, true);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, String.valueOf(currentTimeMillis));
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, "hello");
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, "shake card");
        AppMethodBeat.o(28257);
    }

    public static void eUj() {
        AppMethodBeat.i(28258);
        Log.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_BEGIN_TIME_INT_SYNC, (Object) 0);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_END_TIME_INT_SYNC, (Object) 0);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_NAME_STRING_SYNC, "");
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ACTIVITY_TYPE_INT_SYNC, (Object) 0);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MIN_INT_SYNC, (Object) 0);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_FLOW_CONTROL_LEVEL_MAX_INT_SYNC, (Object) 0);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_TIP_STRING_SYNC, "");
        com.tencent.mm.y.c.axV().B(262154, false);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_ID_STRING_SYNC, "");
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_DESC_STRING_SYNC, "");
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, "");
        AppMethodBeat.o(28258);
    }
}
