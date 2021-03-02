package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.h;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;

public final class b {
    private static LruCache<String, String> AkR = new LruCache<>(20);
    private static LruCache<String, Long> AkS = new LruCache<>(20);

    static {
        AppMethodBeat.i(63047);
        AppMethodBeat.o(63047);
    }

    public static void ja(String str, String str2) {
        AppMethodBeat.i(63041);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(63041);
            return;
        }
        AkR.put(str, str2);
        AkS.put(str, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(63041);
    }

    public static boolean c(a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(63043);
        if (aVar == null || TextUtils.isEmpty(aVar.playUrl)) {
            AppMethodBeat.o(63043);
            return false;
        } else if (!aHR(aVar.playUrl)) {
            AppMethodBeat.o(63043);
            return false;
        } else {
            if (c.Th(aVar.field_musicType)) {
                if (aVar == null || TextUtils.isEmpty(aVar.playUrl)) {
                    z2 = false;
                } else {
                    j aHs = e.aHs(com.tencent.mm.plugin.music.h.b.aId(aVar.playUrl));
                    z2 = aHs != null && aHs.jfB == 1;
                }
                if (!z2 || !h.aHG(aVar.playUrl)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    Log.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
                    AppMethodBeat.o(63043);
                    return false;
                }
            } else {
                boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
                if (!(isWifi ? aVar.field_wifiEndFlag == 1 : aVar.field_endFlag == 1) || !new o(com.tencent.mm.plugin.music.h.b.bT(aVar.field_musicId, isWifi)).exists()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    Log.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
                    AppMethodBeat.o(63043);
                    return false;
                }
            }
            if (!AkR.check(aVar.playUrl)) {
                AppMethodBeat.o(63043);
                return true;
            }
            long j2 = 0;
            if (AkS.check(aVar.playUrl)) {
                j2 = AkS.get(aVar.playUrl).longValue();
            }
            if (System.currentTimeMillis() - j2 > Util.MILLSECONDS_OF_DAY) {
                AkR.remove(aVar.playUrl);
                AkS.remove(aVar.playUrl);
                Log.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
                AppMethodBeat.o(63043);
                return true;
            }
            AppMethodBeat.o(63043);
            return false;
        }
    }

    public static boolean aHR(String str) {
        AppMethodBeat.i(63044);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(63044);
            return false;
        } else if (str.contains("wxshakemusic")) {
            AppMethodBeat.o(63044);
            return true;
        } else {
            AppMethodBeat.o(63044);
            return false;
        }
    }

    public static String aHS(String str) {
        AppMethodBeat.i(63045);
        if (aHR(str)) {
            int lastIndexOf = str.lastIndexOf("wxshakemusic");
            if (lastIndexOf > 1) {
                String substring = str.substring(0, lastIndexOf - 1);
                AppMethodBeat.o(63045);
                return substring;
            }
            AppMethodBeat.o(63045);
            return str;
        }
        AppMethodBeat.o(63045);
        return str;
    }

    public static String aHr(String str) {
        AppMethodBeat.i(63046);
        String aiK = aiK(str);
        if (!TextUtils.isEmpty(aiK) && !aiK.equalsIgnoreCase(str)) {
            Log.i("MicroMsg.Music.MusicUrlParser", "use temp shake music url to play:%s", aiK);
            AppMethodBeat.o(63046);
            return aiK;
        } else if (aHR(str)) {
            String aHS = aHS(aiK);
            Log.i("MicroMsg.Music.MusicUrlParser", "play url :%s", aHS);
            AppMethodBeat.o(63046);
            return aHS;
        } else {
            AppMethodBeat.o(63046);
            return "";
        }
    }

    public static String aiK(String str) {
        String str2;
        AppMethodBeat.i(63042);
        if (TextUtils.isEmpty(str) || !AkR.check(str)) {
            str2 = null;
        } else {
            str2 = AkR.get(str);
        }
        if (str2 == null) {
            AppMethodBeat.o(63042);
            return str;
        }
        AppMethodBeat.o(63042);
        return str2;
    }
}
