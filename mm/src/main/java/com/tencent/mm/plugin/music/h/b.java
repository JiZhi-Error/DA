package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class b {
    public static String aId(String str) {
        AppMethodBeat.i(137442);
        String str2 = "piece" + MD5Util.getMD5String(new StringBuilder().append(str.hashCode()).toString());
        AppMethodBeat.o(137442);
        return str2;
    }

    public static String aIe(String str) {
        AppMethodBeat.i(137443);
        o oVar = new o(g.getAccPath(), "music");
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        String aId = aId(str);
        o oVar2 = new o(oVar, aId);
        Log.d("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", aId, oVar2.hes());
        String z = aa.z(oVar2.her());
        AppMethodBeat.o(137443);
        return z;
    }

    public static String S(f fVar) {
        AppMethodBeat.i(137444);
        if (fVar.jeT == 6) {
            String str = "6_" + T(fVar);
            AppMethodBeat.o(137444);
            return str;
        }
        String str2 = "0_" + T(fVar);
        AppMethodBeat.o(137444);
        return str2;
    }

    private static String T(f fVar) {
        AppMethodBeat.i(137445);
        if (TextUtils.isEmpty(fVar.jeV)) {
            AppMethodBeat.o(137445);
            return "";
        }
        String mD5String = MD5Util.getMD5String(fVar.jeV);
        AppMethodBeat.o(137445);
        return mD5String;
    }

    public static String bT(String str, boolean z) {
        AppMethodBeat.i(137446);
        o oVar = new o(g.getAccPath(), "music");
        if (!oVar.exists()) {
            Log.i("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", Boolean.valueOf(oVar.mkdirs()), aa.z(oVar.her()));
        }
        String bU = bU(str, z);
        o oVar2 = new o(oVar, bU);
        Log.d("MicroMsg.Music.MusicFileUtil", "music name %s path %s", bU, oVar2.hes());
        String z2 = aa.z(oVar2.her());
        AppMethodBeat.o(137446);
        return z2;
    }

    private static String bU(String str, boolean z) {
        AppMethodBeat.i(137447);
        if (z) {
            String str2 = MD5Util.getMD5String(str + "temp") + "-wifi";
            AppMethodBeat.o(137447);
            return str2;
        }
        String mD5String = MD5Util.getMD5String(str + "temp");
        AppMethodBeat.o(137447);
        return mD5String;
    }

    public static String bV(String str, boolean z) {
        AppMethodBeat.i(137448);
        String str2 = bT(str, false) + "-thumb-" + z;
        AppMethodBeat.o(137448);
        return str2;
    }

    public static String aIf(String str) {
        AppMethodBeat.i(198193);
        String bT = bT(new StringBuilder().append(str.hashCode()).toString(), false);
        AppMethodBeat.o(198193);
        return bT;
    }
}
