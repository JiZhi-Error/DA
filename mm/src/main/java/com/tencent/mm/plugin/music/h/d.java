package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.cache.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;

public final class d {
    public static void V(f fVar) {
        int i2;
        boolean z;
        AppMethodBeat.i(137451);
        if (fVar == null) {
            Log.e("MicroMsg.Music.MusicUrlParser", "GetShakeMusicUrl, musicWrapper is null");
            AppMethodBeat.o(137451);
            return;
        }
        boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
        boolean isNetworkConnected = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
        PBool pBool = new PBool();
        String str = Util.isNullOrNil(fVar.jfb) ? fVar.jfd : fVar.jfb;
        String str2 = fVar.jfc;
        String a2 = e.a(str, str2, isWifi, pBool);
        Log.i("MicroMsg.Music.MusicUrlParser", "parsePlayUrl mSrc:%s", a2);
        Log.i("MicroMsg.Music.MusicUrlParser", "songWifiUrl:%s", fVar.jfb);
        Object[] objArr = new Object[2];
        if (isWifi) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(pBool.value ? 1 : 0);
        Log.i("MicroMsg.Music.MusicUrlParser", "isWifi:%d, isQQMusic:%d", objArr);
        if (isWifi) {
            z = pBool.value;
        } else {
            z = false;
        }
        String str3 = "";
        if (!isNetworkConnected) {
            Log.i("MicroMsg.Music.MusicUrlParser", "isNetConnected false, detect right Url to play");
            String a3 = e.a(str, str2, true, pBool);
            String a4 = e.a(str, str2, false, pBool);
            if (a3 == null || !a3.equals(a4)) {
                if (c.U(fVar)) {
                    Log.i("MicroMsg.Music.MusicUrlParser", "use exoMusicPlayer");
                } else if (c.Th(fVar.jeT)) {
                    Log.i("MicroMsg.Music.MusicUrlParser", "use qqMusicPlayer");
                    if (i.aHH(a3)) {
                        str3 = a3;
                    } else if (i.aHH(a4)) {
                        str3 = a4;
                    }
                } else {
                    if (e(fVar, true)) {
                        a4 = a3;
                    } else if (!e(fVar, false)) {
                        a4 = str3;
                    }
                    Log.i("MicroMsg.Music.MusicUrlParser", "use musicPlayer");
                    str3 = a4;
                }
            }
            if (!TextUtils.isEmpty(str3) && !str3.equals(a2)) {
                Log.i("MicroMsg.Music.MusicUrlParser", "reset the mSrc :%s", str3);
                fVar.playUrl = str3;
                g.bS(str3, z);
                AppMethodBeat.o(137451);
            }
        }
        str3 = a2;
        fVar.playUrl = str3;
        g.bS(str3, z);
        AppMethodBeat.o(137451);
    }

    private static boolean e(f fVar, boolean z) {
        AppMethodBeat.i(137452);
        o oVar = new o(b.bT(b.S(fVar), z));
        if (!oVar.exists() || oVar.length() <= 0) {
            AppMethodBeat.o(137452);
            return false;
        }
        AppMethodBeat.o(137452);
        return true;
    }
}
