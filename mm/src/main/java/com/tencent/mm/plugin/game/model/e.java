package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.protobuf.an;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    private static String xEt = "";

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.LinkedList<com.tencent.mm.pluginsdk.model.app.g> dUQ() {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.e.dUQ():java.util.LinkedList");
    }

    public static LinkedList<String> dUR() {
        AppMethodBeat.i(41361);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(((com.tencent.mm.plugin.game.api.e) g.af(com.tencent.mm.plugin.game.api.e.class)).dSI().xDS);
        AppMethodBeat.o(41361);
        return linkedList;
    }

    public static void at(Context context, final String str) {
        AppMethodBeat.i(41362);
        a(context, str, (String) null, "WX_GameCenter", new al() {
            /* class com.tencent.mm.plugin.game.model.e.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.model.app.al
            public final void v(boolean z, boolean z2) {
                AppMethodBeat.i(204147);
                if (z) {
                    a.hhr.c(str, 0, 0, null, null);
                }
                AppMethodBeat.o(204147);
            }
        });
        AppMethodBeat.o(41362);
    }

    public static void a(Context context, String str, String str2, String str3, al alVar) {
        AppMethodBeat.i(41363);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GameCenterLogic", "null or nil appid");
            if (alVar != null) {
                alVar.v(false, false);
            }
        }
        a(context, h.o(str, true, false), str2, str3, alVar);
        AppMethodBeat.o(41363);
    }

    private static void a(final Context context, final com.tencent.mm.pluginsdk.model.app.g gVar, String str, String str2, final al alVar) {
        AppMethodBeat.i(41364);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            Log.e("MicroMsg.GameCenterLogic", "appinfo is null or appid is null");
            if (alVar != null) {
                alVar.v(false, false);
            }
            AppMethodBeat.o(41364);
        } else if (!q.b(context, gVar)) {
            Log.e("MicroMsg.GameCenterLogic", "The app %s signature is incorrect.", gVar.field_appName);
            Toast.makeText(context, context.getString(R.string.dpi, h.a(context, gVar, (String) null)), 1).show();
            if (alVar != null) {
                alVar.v(false, false);
            }
            AppMethodBeat.o(41364);
        } else {
            final WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
            wXMediaMessage.sdkVer = Build.SDK_INT;
            wXMediaMessage.messageAction = str;
            wXMediaMessage.messageExt = str2;
            Log.d("MicroMsg.GameCenterLogic", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", gVar.field_appId, gVar.field_appName, gVar.field_openId);
            if (Util.isNullOrNil(gVar.field_openId)) {
                Log.i("MicroMsg.GameCenterLogic", "open id is null or nil, try to get from server:[%s]", gVar.field_appName);
                com.tencent.mm.plugin.r.a.eAU().add(gVar.field_appId);
            }
            com.tencent.mm.ch.a.post(new Runnable() {
                /* class com.tencent.mm.plugin.game.model.e.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(41359);
                    h.a(context, gVar.field_packageName, wXMediaMessage, gVar.field_appId, gVar.field_openId, 0, alVar, null);
                    AppMethodBeat.o(41359);
                }
            });
            AppMethodBeat.o(41364);
        }
    }

    public static String dUS() {
        AppMethodBeat.i(41365);
        String simCountryCode = Util.getSimCountryCode(MMApplicationContext.getContext());
        if (Util.isNullOrNil(simCountryCode)) {
            simCountryCode = WeChatBrands.AppInfo.LANG_CN;
        }
        String upperCase = simCountryCode.toUpperCase();
        AppMethodBeat.o(41365);
        return upperCase;
    }

    public static GameRegionPreference.a fX(Context context) {
        AppMethodBeat.i(41366);
        String gf = gf(context);
        if (Util.isNullOrNil(gf)) {
            gf = dUS();
        }
        GameRegionPreference.a aVar = a.C1396a.dWO().dWN().get(gf);
        AppMethodBeat.o(41366);
        return aVar;
    }

    public static String a(GameRegionPreference.a aVar) {
        AppMethodBeat.i(41367);
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            String nullAsNil = Util.nullAsNil(LocaleUtil.getApplicationLanguage());
            if (LocaleUtil.CHINA.equalsIgnoreCase(nullAsNil)) {
                stringBuffer.append(aVar.xVE);
            } else if (LocaleUtil.TAIWAN.equalsIgnoreCase(nullAsNil) || LocaleUtil.HONGKONG.equalsIgnoreCase(nullAsNil)) {
                stringBuffer.append(aVar.xVF);
            } else {
                stringBuffer.append(aVar.xVG);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(41367);
        return stringBuffer2;
    }

    public static String dUT() {
        AppMethodBeat.i(41368);
        GameRegionPreference.a aVar = a.C1396a.dWO().dWN().get(dUS());
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(aVar.xVE);
            stringBuffer.append(aAh(LocaleUtil.CHINA));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(41368);
        return stringBuffer2;
    }

    public static String dUU() {
        AppMethodBeat.i(41369);
        GameRegionPreference.a aVar = a.C1396a.dWO().dWN().get(dUS());
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(aVar.xVF);
            stringBuffer.append(aAh(LocaleUtil.TAIWAN));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(41369);
        return stringBuffer2;
    }

    public static String dUV() {
        AppMethodBeat.i(41370);
        GameRegionPreference.a aVar = a.C1396a.dWO().dWN().get(dUS());
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(aVar.xVG);
            stringBuffer.append(aAh(LocaleUtil.ENGLISH));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(41370);
        return stringBuffer2;
    }

    private static String aAh(String str) {
        String str2;
        AppMethodBeat.i(41371);
        InputStream inputStream = null;
        try {
            inputStream = MMApplicationContext.getContext().getAssets().open("game_region_default.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.e("MicroMsg.GameCenterLogic", "exception:%s", Util.stackTraceToString(e2));
                }
            }
        } catch (IOException e3) {
            Log.e("MicroMsg.GameCenterLogic", "exception:%s", Util.stackTraceToString(e3));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str2 = "";
                } catch (IOException e4) {
                    Log.e("MicroMsg.GameCenterLogic", "exception:%s", Util.stackTraceToString(e4));
                    str2 = "";
                }
            } else {
                str2 = "";
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    Log.e("MicroMsg.GameCenterLogic", "exception:%s", Util.stackTraceToString(e5));
                }
            }
            AppMethodBeat.o(41371);
            throw th;
        }
        String[] split = str2.trim().split("\\|");
        if (split.length < 3) {
            Log.e("MicroMsg.GameCenterLogic", "this region default title has problem %s", str2);
            AppMethodBeat.o(41371);
            return "";
        } else if (LocaleUtil.CHINA.equalsIgnoreCase(str)) {
            String str3 = split[0];
            AppMethodBeat.o(41371);
            return str3;
        } else if (LocaleUtil.TAIWAN.equalsIgnoreCase(str) || LocaleUtil.HONGKONG.equalsIgnoreCase(str)) {
            String str4 = split[1];
            AppMethodBeat.o(41371);
            return str4;
        } else {
            String str5 = split[2];
            AppMethodBeat.o(41371);
            return str5;
        }
    }

    public static void fU(Context context) {
        AppMethodBeat.i(41372);
        if (context != null) {
            context.getSharedPreferences("game_center_pref", 0).edit().putString("notified_game_for_yyb_download_key", "").commit();
            context.getSharedPreferences("game_center_pref", 0).edit().putInt("total_notify_times_for_yyb_download_key", 0).commit();
            context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("delete_message_by_time_key", false).commit();
        }
        AppMethodBeat.o(41372);
    }

    public static void dUW() {
        AppMethodBeat.i(41373);
        MMApplicationContext.getContext().getSharedPreferences("game_center_pref", 0).edit().putString("game_center_pref_lang", LocaleUtil.getApplicationLanguage()).commit();
        AppMethodBeat.o(41373);
    }

    public static String dUX() {
        AppMethodBeat.i(41374);
        String string = MMApplicationContext.getContext().getSharedPreferences("game_center_pref", 0).getString("game_center_pref_lang", LocaleUtil.getApplicationLanguage());
        AppMethodBeat.o(41374);
        return string;
    }

    public static boolean dUY() {
        AppMethodBeat.i(41375);
        if (System.currentTimeMillis() - ((Long) g.aAh().azQ().get(ar.a.USERINFO_GAME_SEARCH_LIST_UPDATE_TIME_LONG, (Object) 0L)).longValue() > Util.MILLSECONDS_OF_DAY) {
            AppMethodBeat.o(41375);
            return true;
        }
        AppMethodBeat.o(41375);
        return false;
    }

    public static void dUZ() {
        AppMethodBeat.i(41376);
        g.aAh().azQ().set(ar.a.USERINFO_GAME_SEARCH_LIST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(41376);
    }

    public static void aK(Context context, String str) {
        AppMethodBeat.i(41377);
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (Util.isNullOrNil(string)) {
            sharedPreferences.edit().putString("download_app_id_time_map", str + "-" + valueOf).commit();
            AppMethodBeat.o(41377);
        } else if (string.contains(str)) {
            String str2 = new String();
            String[] split = string.split(",");
            for (int i2 = 0; i2 < split.length; i2++) {
                String str3 = split[i2];
                if (str3.contains(str)) {
                    str3 = str + "-" + valueOf;
                }
                str2 = i2 == split.length - 1 ? str2 + str3 : str2 + str3 + ",";
            }
            sharedPreferences.edit().putString("download_app_id_time_map", str2).apply();
            AppMethodBeat.o(41377);
        } else {
            sharedPreferences.edit().putString("download_app_id_time_map", string + "," + str + "-" + valueOf).apply();
            AppMethodBeat.o(41377);
        }
    }

    public static void aL(Context context, String str) {
        AppMethodBeat.i(41378);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (Util.isNullOrNil(string)) {
            AppMethodBeat.o(41378);
            return;
        }
        if (string.contains(str)) {
            String str2 = new String();
            String[] split = string.split(",");
            for (int i2 = 0; i2 < split.length; i2++) {
                String str3 = split[i2];
                if (!str3.contains(str)) {
                    str2 = i2 == split.length - 1 ? str2 + str3 : str2 + str3 + ",";
                }
            }
            sharedPreferences.edit().putString("download_app_id_time_map", str2).apply();
        }
        AppMethodBeat.o(41378);
    }

    public static void fY(Context context) {
        AppMethodBeat.i(41379);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (Util.isNullOrNil(string)) {
            AppMethodBeat.o(41379);
            return;
        }
        String[] split = string.split(",");
        String str = new String();
        for (String str2 : split) {
            String[] split2 = str2.split("-");
            String str3 = split2[0];
            if (!Util.isNullOrNil(str3) && !h.s(context, str3)) {
                if (currentTimeMillis - Util.getLong(split2[1], 0) < 86400) {
                    str = str + str2 + ",";
                } else {
                    FileDownloadTaskInfo alg = f.cBv().alg(str3);
                    Log.i("MicroMsg.GameCenterLogic", "checkGameDownloadTime, status = %d, id = %d", Integer.valueOf(alg.status), Long.valueOf(alg.id));
                    if (alg.status == 2) {
                        f.cBv().Cn(alg.id);
                    } else if ((alg.status == 0 || alg.status == 4) && s.YS(alg.path)) {
                        s.deleteFile(alg.path);
                    }
                }
            }
        }
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41379);
            return;
        }
        if (str.charAt(str.length() - 1) == ',') {
            str = str.substring(0, str.length() - 1);
        }
        sharedPreferences.edit().putString("download_app_id_time_map", str.toString()).apply();
        AppMethodBeat.o(41379);
    }

    public static boolean fZ(Context context) {
        AppMethodBeat.i(41380);
        boolean z = context.getSharedPreferences("game_center_pref", 0).getBoolean("show_open_download_authority_tips", false);
        AppMethodBeat.o(41380);
        return z;
    }

    public static void ga(Context context) {
        AppMethodBeat.i(41381);
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_open_download_authority_tips", true).commit();
        AppMethodBeat.o(41381);
    }

    public static Set<String> gb(Context context) {
        AppMethodBeat.i(41382);
        Set<String> stringSet = context.getSharedPreferences("game_center_pref", 0).getStringSet("show_download_gift_tips", new HashSet());
        AppMethodBeat.o(41382);
        return stringSet;
    }

    public static void a(Context context, Set<String> set) {
        AppMethodBeat.i(41383);
        context.getSharedPreferences("game_center_pref", 0).edit().putStringSet("show_download_gift_tips", set).commit();
        AppMethodBeat.o(41383);
    }

    public static ShapeDrawable fi(int i2, int i3) {
        AppMethodBeat.i(41384);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i3, (float) i3, (float) i3, (float) i3, (float) i3, (float) i3, (float) i3, (float) i3}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        AppMethodBeat.o(41384);
        return shapeDrawable;
    }

    public static boolean gc(Context context) {
        AppMethodBeat.i(41385);
        boolean z = context.getSharedPreferences("game_center_pref", 0).getBoolean("show_message_tips", true);
        AppMethodBeat.o(41385);
        return z;
    }

    public static void gd(Context context) {
        AppMethodBeat.i(41386);
        context.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_message_tips", false).apply();
        AppMethodBeat.o(41386);
    }

    public static int ge(Context context) {
        AppMethodBeat.i(41387);
        int i2 = context.getSharedPreferences("game_center_pref", 0).getInt("game_top_banner_id", 0);
        AppMethodBeat.o(41387);
        return i2;
    }

    public static void ah(Context context, int i2) {
        AppMethodBeat.i(41388);
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_top_banner_id", i2).apply();
        AppMethodBeat.o(41388);
    }

    public static String dVa() {
        AppMethodBeat.i(41389);
        an dST = com.tencent.mm.plugin.game.commlib.a.dST();
        if (dST != null) {
            String str = dST.xIy;
            AppMethodBeat.o(41389);
            return str;
        }
        AppMethodBeat.o(41389);
        return "";
    }

    public static int dVb() {
        AppMethodBeat.i(41390);
        an dST = com.tencent.mm.plugin.game.commlib.a.dST();
        if (dST != null) {
            int i2 = dST.xJa;
            AppMethodBeat.o(41390);
            return i2;
        }
        AppMethodBeat.o(41390);
        return 0;
    }

    public static String gf(Context context) {
        AppMethodBeat.i(41391);
        String string = context.getSharedPreferences("game_center_pref", 0).getString("game_region_code", "");
        AppMethodBeat.o(41391);
        return string;
    }

    public static void aM(Context context, String str) {
        AppMethodBeat.i(41392);
        context.getSharedPreferences("game_center_pref", 0).edit().putString("game_region_code", str).commit();
        AppMethodBeat.o(41392);
    }

    public static boolean gg(Context context) {
        AppMethodBeat.i(41393);
        if (context.getSharedPreferences("game_center_pref", 0).getInt("game_region_confirm_mark", 0) == 1) {
            AppMethodBeat.o(41393);
            return false;
        }
        AppMethodBeat.o(41393);
        return true;
    }

    public static void gh(Context context) {
        AppMethodBeat.i(41394);
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_region_confirm_mark", 1).commit();
        AppMethodBeat.o(41394);
    }

    public static void dVc() {
        AppMethodBeat.i(41395);
        MMApplicationContext.getContext().getSharedPreferences("game_center_pref", 0).edit().putLong("game_index_last_visit_time", System.currentTimeMillis()).commit();
        AppMethodBeat.o(41395);
    }

    public static long dVd() {
        AppMethodBeat.i(41396);
        long j2 = MMApplicationContext.getContext().getSharedPreferences("game_center_pref", 0).getLong("game_index_last_visit_time", 0);
        AppMethodBeat.o(41396);
        return j2;
    }

    public static void Ok(int i2) {
        AppMethodBeat.i(183850);
        String valueOf = String.valueOf(i2);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("game_center_pref", 0);
        String dVe = dVe();
        if (!Util.isNullOrNil(dVe)) {
            for (String str : dVe.split(",")) {
                if (str.equals(valueOf)) {
                    AppMethodBeat.o(183850);
                    return;
                }
            }
            valueOf = dVe + "," + valueOf;
        }
        sharedPreferences.edit().putString("game_ban_msg_type_array", valueOf).apply();
        AppMethodBeat.o(183850);
    }

    public static void Ol(int i2) {
        AppMethodBeat.i(183851);
        String valueOf = String.valueOf(i2);
        String dVe = dVe();
        if (!Util.isNullOrNil(dVe)) {
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("game_center_pref", 0);
            String[] split = dVe.split(",");
            StringBuilder sb = new StringBuilder();
            for (String str : split) {
                if (!str.equals(valueOf)) {
                    sb.append(str).append(",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sharedPreferences.edit().putString("game_ban_msg_type_array", sb.toString()).apply();
        }
        AppMethodBeat.o(183851);
    }

    public static String dVe() {
        AppMethodBeat.i(183852);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("game_center_pref", 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("game_ban_msg_type_array", "");
            AppMethodBeat.o(183852);
            return string;
        }
        AppMethodBeat.o(183852);
        return null;
    }

    public static boolean Om(int i2) {
        AppMethodBeat.i(183853);
        String valueOf = String.valueOf(i2);
        String dVe = dVe();
        if (!Util.isNullOrNil(dVe)) {
            String[] split = dVe.split(",");
            for (String str : split) {
                if (str.equals(valueOf)) {
                    AppMethodBeat.o(183853);
                    return true;
                }
            }
        }
        AppMethodBeat.o(183853);
        return false;
    }

    public static String dVf() {
        return xEt;
    }
}
