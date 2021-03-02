package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.utils.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.io.RandomAccessFile;
import java.util.HashMap;

public final class f {
    HashMap<String, Typeface> cMX = new HashMap<>();
    HashMap<String, Integer> cMY = new HashMap<String, Integer>() {
        /* class com.tencent.magicbrush.handler.glfont.f.AnonymousClass1 */

        {
            AppMethodBeat.i(206811);
            put("lighter", 100);
            put("normal", 400);
            put("bold", 700);
            put("bolder", 700);
            put("100", 100);
            put("200", 200);
            put("300", 300);
            put("400", 400);
            put("500", 500);
            put("600", 600);
            put("700", 700);
            put("800", 800);
            put("900", Integer.valueOf((int) TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR));
            AppMethodBeat.o(206811);
        }
    };
    public b cMZ;

    f(b bVar) {
        AppMethodBeat.i(140017);
        this.cMZ = bVar;
        AppMethodBeat.o(140017);
    }

    static String ea(String str) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        AppMethodBeat.i(140018);
        if (h.isNullOrNil(str)) {
            AppMethodBeat.o(140018);
            return null;
        }
        if (!str.endsWith("ttf") && a.Rx() != null) {
            a.Rx().ik(1);
        }
        m mVar = new m();
        try {
            mVar.cNX.clear();
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    mVar.c(randomAccessFile);
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                        c.C0193c.printStackTrace("TTFParser", e2, "ttfparse error", new Object[0]);
                    }
                    if (mVar.cNX.containsKey(Integer.valueOf(m.cNS))) {
                        String str2 = mVar.cNX.get(Integer.valueOf(m.cNS));
                        AppMethodBeat.o(140018);
                        return str2;
                    } else if (mVar.cNX.containsKey(Integer.valueOf(m.cNW))) {
                        String str3 = mVar.cNX.get(Integer.valueOf(m.cNW));
                        AppMethodBeat.o(140018);
                        return str3;
                    } else {
                        AppMethodBeat.o(140018);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                        c.C0193c.printStackTrace("TTFParser", e3, "ttfparse error", new Object[0]);
                    }
                    AppMethodBeat.o(140018);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                randomAccessFile.close();
                AppMethodBeat.o(140018);
                throw th;
            }
        } catch (Exception e4) {
            c.C0193c.printStackTrace("MicroMsg.MBFont", e4, "ttf parse error,path:%s", str);
            AppMethodBeat.o(140018);
            return null;
        }
    }
}
