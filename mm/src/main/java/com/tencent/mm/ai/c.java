package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.x;
import com.tencent.mm.plugin.music.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static String iS(String str, String str2) {
        AppMethodBeat.i(259520);
        Log.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", str, str2);
        x xVar = new x();
        xVar.dCQ.action = 10;
        xVar.dCQ.appId = str;
        xVar.dCQ.dtX = str2;
        a.a(xVar);
        String str3 = xVar.dCQ.dtX;
        AppMethodBeat.o(259520);
        return str3;
    }

    public static boolean m(b bVar) {
        AppMethodBeat.i(259521);
        Log.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", bVar.dtX);
        x xVar = new x();
        xVar.dCQ.action = 0;
        xVar.dCQ.dtX = bVar.dtX;
        xVar.dCQ.dCT = bVar;
        a.a(xVar);
        boolean z = xVar.dCR.result;
        AppMethodBeat.o(259521);
        return z;
    }

    public static boolean aGU(String str) {
        AppMethodBeat.i(259522);
        Log.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", str);
        x xVar = new x();
        xVar.dCQ.action = 3;
        xVar.dCQ.dtX = str;
        a.a(xVar);
        boolean z = xVar.dCR.result;
        AppMethodBeat.o(259522);
        return z;
    }

    public static boolean aGW(String str) {
        AppMethodBeat.i(259523);
        Log.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", str);
        x xVar = new x();
        xVar.dCQ.action = 5;
        xVar.dCQ.dtX = str;
        a.a(xVar);
        boolean z = xVar.dCR.result;
        AppMethodBeat.o(259523);
        return z;
    }

    public static boolean LT(String str) {
        AppMethodBeat.i(136979);
        x xVar = new x();
        xVar.dCQ.action = 7;
        xVar.dCQ.dtX = str;
        a.a(xVar);
        boolean z = xVar.dCR.result;
        AppMethodBeat.o(136979);
        return z;
    }

    public static b LU(String str) {
        AppMethodBeat.i(136980);
        x xVar = new x();
        xVar.dCQ.action = 16;
        xVar.dCQ.dtX = str;
        a.a(xVar);
        b bVar = xVar.dCQ.dCT;
        AppMethodBeat.o(136980);
        return bVar;
    }
}
