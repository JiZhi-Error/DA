package com.tencent.mm.plugin.sns.storage;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class y {
    public static String bp(String str, long j2) {
        AppMethodBeat.i(97636);
        String str2 = str + j2;
        AppMethodBeat.o(97636);
        return str2;
    }

    public static String bq(String str, long j2) {
        AppMethodBeat.i(97637);
        String str2 = str + j2;
        AppMethodBeat.o(97637);
        return str2;
    }

    public static boolean aQH(String str) {
        AppMethodBeat.i(97638);
        if (str == null || !str.startsWith("ad_table_")) {
            AppMethodBeat.o(97638);
            return false;
        }
        AppMethodBeat.o(97638);
        return true;
    }

    public static boolean aNz(String str) {
        AppMethodBeat.i(97639);
        if (str == null || !str.startsWith("sns_table_")) {
            AppMethodBeat.o(97639);
            return false;
        }
        AppMethodBeat.o(97639);
        return true;
    }

    public static long aOa(String str) {
        AppMethodBeat.i(97640);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(97640);
            return 0;
        } else if (str.startsWith("ad_table_")) {
            long safeParseLong = Util.safeParseLong(str.substring(9));
            AppMethodBeat.o(97640);
            return safeParseLong;
        } else if (str.startsWith("sns_table_")) {
            long safeParseLong2 = Util.safeParseLong(str.substring(10));
            AppMethodBeat.o(97640);
            return safeParseLong2;
        } else {
            long safeParseLong3 = Util.safeParseLong(str);
            AppMethodBeat.o(97640);
            return safeParseLong3;
        }
    }

    public static int aQI(String str) {
        AppMethodBeat.i(97641);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(97641);
            return 0;
        } else if (str.startsWith("ad_table_")) {
            int safeParseInt = Util.safeParseInt(str.substring(9));
            AppMethodBeat.o(97641);
            return safeParseInt;
        } else {
            int safeParseInt2 = Util.safeParseInt(str.substring(10));
            AppMethodBeat.o(97641);
            return safeParseInt2;
        }
    }

    public static boolean aQJ(String str) {
        AppMethodBeat.i(97642);
        if (str.startsWith("ad_table_")) {
            if (Util.safeParseLong(str.substring(9)) != 0) {
                AppMethodBeat.o(97642);
                return true;
            }
            AppMethodBeat.o(97642);
            return false;
        } else if (Util.safeParseLong(str.substring(10)) != 0) {
            AppMethodBeat.o(97642);
            return true;
        } else {
            AppMethodBeat.o(97642);
            return false;
        }
    }

    public static boolean aQK(String str) {
        AppMethodBeat.i(97643);
        if (!aQJ(str)) {
            AppMethodBeat.o(97643);
            return true;
        }
        AppMethodBeat.o(97643);
        return false;
    }

    public static int kN(String str, String str2) {
        AppMethodBeat.i(97644);
        g.aAf();
        int aS = aS(str, str2, a.ayV());
        AppMethodBeat.o(97644);
        return aS;
    }

    public static int aS(String str, String str2, String str3) {
        int i2 = 0;
        AppMethodBeat.i(97645);
        String aT = aT(str, str2, str3);
        if (!Util.isNullOrNil(aT)) {
            String[] split = aT.split("&");
            int i3 = 0;
            while (true) {
                if (i3 < split.length) {
                    if (split[i3] != null && split[i3].contains("voteResultIndex=")) {
                        i2 = Util.getInt(split[i3].substring(16), 0);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
        }
        Log.d("StorageHelper", "getSnsAdVoteIndex, voteIdx=".concat(String.valueOf(i2)));
        AppMethodBeat.o(97645);
        return i2;
    }

    public static String aT(String str, String str2, String str3) {
        AppMethodBeat.i(97646);
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        String str4 = "";
        if (sb.length() > 0) {
            str4 = MMApplicationContext.getContext().getSharedPreferences("SnsAdVote", 0).getString(sb.toString(), "");
        }
        Log.d("StorageHelper", "getSnsAdVoteInfo, ret=".concat(String.valueOf(str4)));
        AppMethodBeat.o(97646);
        return str4;
    }

    public static void b(String str, String str2, String str3, int i2, int i3, String str4) {
        AppMethodBeat.i(97647);
        if (TextUtils.isEmpty(str)) {
            Log.e("StorageHelper", "saveSnsAdVoteInfo, url is empty");
            AppMethodBeat.o(97647);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        if (sb.length() <= 0) {
            Log.e("StorageHelper", "saveSnsAdVoteInfo, key is empty");
            AppMethodBeat.o(97647);
            return;
        }
        String sb2 = sb.toString();
        SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("SnsAdVote", 0).edit();
        edit.putString(sb2, "voteResultIndex=" + i2 + "&isUpdate=" + i3);
        edit.putString(sb2 + "_voteRet", str4);
        edit.commit();
        Log.i("StorageHelper", "saveSnsAdVoteInfo, voteIdx=" + i2 + ", isUpdate=" + i3 + ", content=" + str4);
        AppMethodBeat.o(97647);
    }

    public static String aQL(String str) {
        AppMethodBeat.i(179142);
        String str2 = "";
        try {
            g.aAf();
            String ayV = a.ayV();
            if (Util.isNullOrNil(str, ayV)) {
                Log.e("StorageHelper", "HalfScreenSubscribe, snsId or uin is empty");
                AppMethodBeat.o(179142);
            } else {
                StringBuilder sb = new StringBuilder();
                if (Util.isNullOrNil(str)) {
                    str = "";
                }
                sb.append(str);
                if (Util.isNullOrNil(ayV)) {
                    ayV = "";
                }
                sb.append(ayV);
                if (sb.length() <= 0) {
                    Log.e("StorageHelper", "HalfScreenSubscribe, key is empty");
                    AppMethodBeat.o(179142);
                } else {
                    str2 = MMApplicationContext.getContext().getSharedPreferences("SnsAdVoteSubscribe", 0).getString(sb.toString(), "");
                    AppMethodBeat.o(179142);
                }
            }
        } catch (Throwable th) {
            Log.e("StorageHelper", th.toString());
        }
        return str2;
    }
}
