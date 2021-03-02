package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Map;

public final class g {
    private static LruCache<String, String> AiK = new LruCache<>(20);
    private static LruCache<String, Boolean> AiL = new LruCache<>(20);
    private static LruCache<String, Integer> AiM = new LruCache<>(20);
    private static LruCache<String, Integer> AiN = new LruCache<>(20);
    private static LruCache<String, Long> AiO = new LruCache<>(20);
    private static LruCache<String, String> AiP = new LruCache<>(20);
    private static String AiQ = null;
    private static int AiR = 0;

    static {
        AppMethodBeat.i(137194);
        AppMethodBeat.o(137194);
    }

    public static void aHx(String str) {
        String str2;
        AppMethodBeat.i(137176);
        if (!TextUtils.isEmpty(aHy(str))) {
            AppMethodBeat.o(137176);
            return;
        }
        if (e.etK()) {
            str2 = ((c) b.aS(c.class)).aHt(str);
        } else {
            Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str2);
            new f(arrayList).etC();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                AiK.put(str, str2);
            }
        }
        AppMethodBeat.o(137176);
    }

    public static String getAccPath() {
        AppMethodBeat.i(137177);
        if (AiQ != null) {
            String str = AiQ;
            AppMethodBeat.o(137177);
            return str;
        }
        String accPath = e.getAccPath();
        if (TextUtils.isEmpty(accPath)) {
            Log.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", accPath);
            String aKJ = com.tencent.mm.loader.j.b.aKJ();
            AppMethodBeat.o(137177);
            return aKJ;
        }
        Log.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", accPath);
        AiQ = accPath;
        AppMethodBeat.o(137177);
        return accPath;
    }

    public static int etE() {
        int i2;
        AppMethodBeat.i(137178);
        if (AiR != 0) {
            int i3 = AiR;
            AppMethodBeat.o(137178);
            return i3;
        }
        if (e.etK()) {
            i2 = ((c) b.aS(c.class)).etE();
        } else {
            Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            i2 = 3;
        }
        AiR = i2;
        Log.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", Integer.valueOf(AiR));
        if (AiR == 0) {
            AiR = 3;
        }
        int i4 = AiR;
        AppMethodBeat.o(137178);
        return i4;
    }

    public static String aHy(String str) {
        AppMethodBeat.i(137179);
        if (AiK.check(str)) {
            String str2 = AiK.get(str);
            AppMethodBeat.o(137179);
            return str2;
        }
        AppMethodBeat.o(137179);
        return "";
    }

    public static void bS(String str, boolean z) {
        AppMethodBeat.i(137180);
        if (!TextUtils.isEmpty(str)) {
            AiL.put(str, Boolean.valueOf(z));
        }
        AppMethodBeat.o(137180);
    }

    public static boolean aHz(String str) {
        AppMethodBeat.i(137181);
        if (AiL.check(str)) {
            boolean booleanValue = AiL.get(str).booleanValue();
            AppMethodBeat.o(137181);
            return booleanValue;
        }
        AppMethodBeat.o(137181);
        return false;
    }

    public static void H(String str, Map<String, String> map) {
        AppMethodBeat.i(137182);
        if (map != null) {
            aHz(str);
        }
        AppMethodBeat.o(137182);
    }

    public static void iW(String str, String str2) {
        AppMethodBeat.i(137183);
        String aHy = aHy(str);
        if (TextUtils.isEmpty(aHy)) {
            Log.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
            AppMethodBeat.o(137183);
        } else if (!TextUtils.isEmpty(aHB(str))) {
            AppMethodBeat.o(137183);
        } else {
            Log.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", str, str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                AiP.put(str, str2);
            }
            if (e.etK()) {
                ((c) b.aS(c.class)).iU(aHy, str2);
                AppMethodBeat.o(137183);
                return;
            }
            Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            AppMethodBeat.o(137183);
        }
    }

    public static String aHA(String str) {
        AppMethodBeat.i(137184);
        String aHy = aHy(str);
        if (TextUtils.isEmpty(aHy)) {
            Log.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
            AppMethodBeat.o(137184);
            return null;
        } else if (e.etK()) {
            String aHv = ((c) b.aS(c.class)).aHv(aHy);
            AppMethodBeat.o(137184);
            return aHv;
        } else {
            Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            AppMethodBeat.o(137184);
            return null;
        }
    }

    public static String aHB(String str) {
        AppMethodBeat.i(137185);
        if (AiP.check(str)) {
            String str2 = AiP.get(str);
            AppMethodBeat.o(137185);
            return str2;
        }
        AppMethodBeat.o(137185);
        return null;
    }

    public static long aHC(String str) {
        AppMethodBeat.i(137186);
        if (AiO.check(str)) {
            long longValue = AiO.get(str).longValue();
            AppMethodBeat.o(137186);
            return longValue;
        }
        AppMethodBeat.o(137186);
        return -1;
    }

    public static void bc(String str, long j2) {
        AppMethodBeat.i(137187);
        if (j2 > 0) {
            AiO.put(str, Long.valueOf(j2));
        }
        AppMethodBeat.o(137187);
    }

    public static long hv(String str) {
        AppMethodBeat.i(137188);
        long hv = h.hv(str);
        AppMethodBeat.o(137188);
        return hv;
    }

    public static void eT(String str, int i2) {
        AppMethodBeat.i(137190);
        if (str != null) {
            AiM.put(str, Integer.valueOf(i2));
        }
        AppMethodBeat.o(137190);
    }

    public static int aHE(String str) {
        AppMethodBeat.i(137191);
        if (str == null || !AiM.check(str)) {
            AppMethodBeat.o(137191);
            return 0;
        }
        int intValue = AiM.get(str).intValue();
        AppMethodBeat.o(137191);
        return intValue;
    }

    public static void eU(String str, int i2) {
        AppMethodBeat.i(137192);
        if (str != null) {
            AiN.put(str, Integer.valueOf(i2));
        }
        AppMethodBeat.o(137192);
    }

    public static int aHF(String str) {
        AppMethodBeat.i(137193);
        if (str == null || !AiN.check(str)) {
            AppMethodBeat.o(137193);
            return 0;
        }
        int intValue = AiN.get(str).intValue();
        AppMethodBeat.o(137193);
        return intValue;
    }

    public static void aHD(String str) {
        AppMethodBeat.i(137189);
        Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
        h.aHD(com.tencent.mm.plugin.music.h.b.aIe(str));
        AppMethodBeat.o(137189);
    }
}
