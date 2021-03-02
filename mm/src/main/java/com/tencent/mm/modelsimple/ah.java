package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class ah {
    private static i callback = null;
    private static boolean jkK = false;
    private static int jkL = 3;
    private static long jkM = 0;

    public static void run() {
        AppMethodBeat.i(130965);
        if (jkK) {
            Log.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
            AppMethodBeat.o(130965);
            return;
        }
        if (jkM == 0 || Util.ticksToNow(jkM) > 180000) {
            jkM = Util.currentTicks();
            jkL = 3;
        }
        if (jkL <= 0) {
            Log.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
            AppMethodBeat.o(130965);
            return;
        }
        jkL--;
        final String str = b.aKR() + "temp.avatar.hd";
        if (!s.YS(str)) {
            Log.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
            AppMethodBeat.o(130965);
            return;
        }
        if (callback == null) {
            callback = new i() {
                /* class com.tencent.mm.modelsimple.ah.AnonymousClass1 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(130964);
                    Log.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (i2 == 0 && i3 == 0) {
                        s.deleteFile(str);
                    }
                    boolean unused = ah.jkK = false;
                    g.azz().b(157, ah.callback);
                    AppMethodBeat.o(130964);
                }
            };
        }
        g.azz().a(157, callback);
        g.azz().a(new m(1, str), 0);
        jkK = true;
        AppMethodBeat.o(130965);
    }
}
