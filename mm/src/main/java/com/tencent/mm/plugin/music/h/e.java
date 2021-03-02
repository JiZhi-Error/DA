package com.tencent.mm.plugin.music.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e {
    private static final String[] Apb = {"#", "?", "&"};
    private static String Apc = null;
    private static String Apd = null;
    private static final Pattern lnT = Pattern.compile("songid=([0-9]+)");

    public static boolean aIg(String str) {
        boolean z;
        AppMethodBeat.i(137453);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(137453);
            return false;
        }
        Uri parse = Uri.parse(str);
        String str2 = "";
        if (parse != null) {
            str2 = parse.getHost();
        }
        if (str2 != null) {
            z = parse.getHost().contains(".qq.com");
            Log.w("MicroMsg.Music.MusicUrlUtil", "url %s match ? %B", str, Boolean.valueOf(z));
        } else {
            Log.i("MicroMsg.Music.MusicUrlUtil", "host is null, url is not match .qq.com");
            z = false;
        }
        AppMethodBeat.o(137453);
        return z;
    }

    public static String gH(Context context) {
        AppMethodBeat.i(137454);
        String str = "";
        String packageName = MMApplicationContext.getPackageName();
        if (packageName == null) {
            AppMethodBeat.o(137454);
        } else {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    str = (str + packageInfo.versionName) + packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e2, "", new Object[0]);
            }
            AppMethodBeat.o(137454);
        }
        return str;
    }

    public static String a(String str, String str2, boolean z, PBool pBool) {
        String str3;
        AppMethodBeat.i(137455);
        if (z || Util.isNullOrNil(str2)) {
            str3 = str;
        } else {
            str3 = str2;
        }
        if (Util.isNullOrNil(str3)) {
            AppMethodBeat.o(137455);
            return str3;
        }
        PString pString = new PString();
        Log.i("MicroMsg.Music.MusicUrlUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", str, str2, Boolean.valueOf(z));
        String aIh = aIh(str3);
        if (aIh != null) {
            if (a(aIh, z, pString)) {
                pBool.value = z;
            }
        } else if (str3.contains("wechat_music_url=")) {
            a(str3.substring(str3.indexOf("wechat_music_url=") + 17), z, pString);
        } else {
            pString.value = str3;
        }
        String str4 = pString.value;
        AppMethodBeat.o(137455);
        return str4;
    }

    static {
        AppMethodBeat.i(137462);
        AppMethodBeat.o(137462);
    }

    private static String aIh(String str) {
        AppMethodBeat.i(137456);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(137456);
            return null;
        } else if (Apc == null || !str.equals(Apc)) {
            String str2 = "";
            String[] strArr = Apb;
            int length = strArr.length;
            String str3 = null;
            for (int i2 = 0; i2 < length; i2++) {
                str2 = strArr[i2] + "p=";
                if (str.contains(str2)) {
                    str3 = str;
                }
                if (str3 != null) {
                    break;
                }
            }
            if (str3 == null) {
                AppMethodBeat.o(137456);
                return null;
            }
            int indexOf = str3.indexOf(str2);
            if (indexOf < 0) {
                Log.w("MicroMsg.Music.MusicUrlUtil", "pIndex is %d, return", Integer.valueOf(indexOf));
                AppMethodBeat.o(137456);
                return null;
            }
            String substring = str3.substring(str2.length() + indexOf);
            for (String str4 : Apb) {
                int indexOf2 = substring.indexOf(str4);
                if (indexOf2 > 0) {
                    substring = substring.substring(0, indexOf2);
                }
            }
            if (substring != null) {
                Apc = str;
                Apd = substring;
            }
            AppMethodBeat.o(137456);
            return substring;
        } else {
            String str5 = Apd;
            AppMethodBeat.o(137456);
            return str5;
        }
    }

    private static boolean a(String str, boolean z, PString pString) {
        AppMethodBeat.i(137457);
        String str2 = new String(aIi(str));
        int indexOf = str2.indexOf("{");
        if (indexOf != -1) {
            str2 = str2.substring(indexOf);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("song_WapLiveURL");
            String string2 = jSONObject.getString("song_WifiURL");
            Log.d("MicroMsg.Music.MusicUrlUtil", "waplive: " + string + "  wifi:" + string2);
            if (!z) {
                string2 = string;
            }
            pString.value = string2;
            AppMethodBeat.o(137457);
            return true;
        } catch (Exception e2) {
            pString.value = str;
            Log.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e2, "decodeJson", new Object[0]);
            AppMethodBeat.o(137457);
            return false;
        }
    }

    private static byte[] aIi(String str) {
        int i2;
        AppMethodBeat.i(137458);
        byte[] bArr = new byte[((str.length() / 2) + (str.length() % 2))];
        int i3 = 0;
        int i4 = 0;
        while (i3 < str.length()) {
            try {
                int i5 = i3 + 1;
                int E = E(str.charAt(i3));
                if (i5 < str.length()) {
                    i3 = i5 + 1;
                    i2 = E(str.charAt(i5));
                } else {
                    i2 = 0;
                    i3 = i5;
                }
                int i6 = i4 + 1;
                bArr[i4] = (byte) (i2 | (E << 4));
                i4 = i6;
            } catch (Exception e2) {
                AppMethodBeat.o(137458);
                return null;
            }
        }
        AppMethodBeat.o(137458);
        return bArr;
    }

    private static int aIj(String str) {
        int i2 = 0;
        AppMethodBeat.i(137459);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(137459);
        } else {
            Matcher matcher = lnT.matcher(str);
            if (matcher.find()) {
                try {
                    i2 = Integer.valueOf(matcher.group(1)).intValue();
                    AppMethodBeat.o(137459);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e2, "getSongId", new Object[0]);
                    AppMethodBeat.o(137459);
                }
            } else {
                AppMethodBeat.o(137459);
            }
        }
        return i2;
    }

    private static int E(char c2) {
        if (c2 >= '1' && c2 <= '9') {
            return c2 - '0';
        }
        if (c2 < 'A' || c2 > 'F') {
            return 0;
        }
        return (c2 - 'A') + 10;
    }

    public static String W(f fVar) {
        AppMethodBeat.i(198194);
        if (fVar == null) {
            AppMethodBeat.o(198194);
            return null;
        } else if (!Util.isNullOrNil(fVar.jfb)) {
            String str = fVar.jfb;
            AppMethodBeat.o(198194);
            return str;
        } else if (!Util.isNullOrNil(fVar.jfd)) {
            String str2 = fVar.jfd;
            AppMethodBeat.o(198194);
            return str2;
        } else if (!Util.isNullOrNil(fVar.jfc)) {
            String str3 = fVar.jfc;
            AppMethodBeat.o(198194);
            return str3;
        } else {
            AppMethodBeat.o(198194);
            return null;
        }
    }

    private static String X(f fVar) {
        AppMethodBeat.i(137460);
        if (W(fVar) == null) {
            AppMethodBeat.o(137460);
            return null;
        }
        String aIh = aIh(fVar.jfb);
        if (aIh != null) {
            AppMethodBeat.o(137460);
            return aIh;
        }
        String aIh2 = aIh(fVar.jfd);
        if (aIh2 != null) {
            AppMethodBeat.o(137460);
            return aIh2;
        }
        String aIh3 = aIh(fVar.jfc);
        AppMethodBeat.o(137460);
        return aIh3;
    }

    public static String aIk(String str) {
        AppMethodBeat.i(198195);
        int indexOf = str == null ? -1 : str.indexOf("songmid=");
        if (indexOf < 0) {
            AppMethodBeat.o(198195);
            return null;
        }
        String substring = str.substring(indexOf + 8);
        if (substring == null || !substring.contains("&")) {
            AppMethodBeat.o(198195);
            return substring;
        }
        String substring2 = substring.substring(0, substring.indexOf("&"));
        AppMethodBeat.o(198195);
        return substring2;
    }

    public static String aIl(String str) {
        AppMethodBeat.i(198196);
        int indexOf = str == null ? -1 : str.indexOf("songid=");
        if (indexOf < 0) {
            AppMethodBeat.o(198196);
            return null;
        }
        String substring = str.substring(indexOf + 7);
        if (substring == null || !substring.contains("&")) {
            AppMethodBeat.o(198196);
            return substring;
        }
        String substring2 = substring.substring(0, substring.indexOf("&"));
        AppMethodBeat.o(198196);
        return substring2;
    }

    public static f Y(f fVar) {
        AppMethodBeat.i(137461);
        if (fVar != null) {
            fVar.jfk = aIj(fVar.jfb);
            if (fVar.jfk <= 0) {
                fVar.jfk = aIj(fVar.jfd);
                if (fVar.jfk <= 0) {
                    fVar.jfk = aIj(fVar.jfc);
                }
            }
        }
        if (fVar == null || X(fVar) == null) {
            AppMethodBeat.o(137461);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            String X = X(fVar);
            if (X == null) {
                AppMethodBeat.o(137461);
            } else {
                Log.d("MicroMsg.Music.MusicUrlUtil", "bcdUrl: %s", X);
                String str = new String(aIi(X));
                int indexOf = str.indexOf("{");
                if (indexOf != -1) {
                    str = str.substring(indexOf);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    fVar.jfk = jSONObject.optInt("song_ID");
                    if (Util.isNullOrNil(fVar.jeX)) {
                        fVar.jeX = jSONObject.optString("song_Name");
                    }
                    if (Util.isNullOrNil(fVar.jfc)) {
                        fVar.jfc = jSONObject.optString("song_WapLiveURL");
                    }
                    if (Util.isNullOrNil(fVar.jfb)) {
                        fVar.jfb = jSONObject.optString("song_WifiURL");
                    }
                    if (Util.isNullOrNil(fVar.jeZ)) {
                        fVar.jeZ = jSONObject.optString("song_Album");
                    }
                    if (Util.isNullOrNil(fVar.jeY)) {
                        fVar.jeY = jSONObject.optString("song_Singer");
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e2, "", new Object[0]);
                }
                if (fVar.jfk == 0) {
                    fVar.jfk = aIj(Apc);
                }
                Log.i("MicroMsg.Music.MusicUrlUtil", "parseBCDForMusicWrapper %s: expend: %d %d", fVar.jeV, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(fVar.jfk));
                AppMethodBeat.o(137461);
            }
        }
        return fVar;
    }
}
